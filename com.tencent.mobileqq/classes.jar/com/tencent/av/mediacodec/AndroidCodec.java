package com.tencent.av.mediacodec;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.av.business.config.ConfigManager;
import com.tencent.av.business.config.MediaCodecChipConfigManager;
import com.tencent.av.config.MediaCodecChipConfigInfo;
import com.tencent.av.config.MediaCodecChipConfigInfo.ChipAbilityInfo;
import com.tencent.av.config.api.ICodecConfigParser;
import com.tencent.av.config.api.IConfigParser;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.ClassLoaderUtil;
import com.tencent.avcore.jni.codec.AndroidCodecBase;
import com.tencent.avcore.jni.codec.BufferData;
import com.tencent.avcore.jni.codec.HWCodecAbility;
import com.tencent.avcore.jni.codec.IMediaCodecCallback;
import com.tencent.avcore.jni.codec.NativeCodec;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressLint({"NewApi"})
public class AndroidCodec
  extends AndroidCodecBase
{
  public static int DEC_CODEC = 0;
  public static int ENC_CODEC = 1;
  public static int TIMEOUT_US = 33000;
  protected static boolean fInvokeAPILevel21 = true;
  protected static Method fgetInputBuffer21;
  protected static Method fgetOutputBuffer21;
  protected static Method fgetOutputFormat21;
  protected static Method fsetParameters19;
  protected static boolean gfLoaded = false;
  public static int mOutputFormatForReport = 0;
  public static boolean sIsSupportHwCodec1080P = false;
  protected ByteBuffer[] inputBuffers;
  protected int mCodecType = DEC_CODEC;
  protected MediaFormat mFormat;
  public boolean mIsSetMediaCodecCallbackSuc = false;
  protected MediaCodec mMediaCodec;
  protected MediaFormat mOutputFormat;
  final String mTAG;
  protected ByteBuffer[] outputBuffers;
  
  @Deprecated
  public AndroidCodec()
  {
    this("unknown");
  }
  
  public AndroidCodec(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_AndroidCodec");
    this.mTAG = localStringBuilder.toString();
    invoke21Apis(this.mTAG);
    if ((Build.VERSION.SDK_INT >= 19) && (fsetParameters19 == null)) {}
    try
    {
      fsetParameters19 = MediaCodec.class.getMethod("setParameters", new Class[] { Bundle.class });
      return;
    }
    catch (NoSuchMethodException paramString)
    {
      label86:
      break label86;
    }
    fsetParameters19 = null;
  }
  
  private static void checkDebug(ArrayList<HWCodecAbility> paramArrayList)
  {
    boolean bool1;
    if (1 == AudioHelper.a(33)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (1 == AudioHelper.a(32)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool3;
    if (1 == AudioHelper.a(31)) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    boolean bool4;
    if (1 == AudioHelper.a(30)) {
      bool4 = true;
    } else {
      bool4 = false;
    }
    if ((bool1) || (bool2) || (bool4) || (bool3))
    {
      Iterator localIterator = paramArrayList.iterator();
      boolean bool8 = false;
      boolean bool7 = false;
      boolean bool6 = false;
      boolean bool5 = false;
      while (localIterator.hasNext())
      {
        HWCodecAbility localHWCodecAbility = (HWCodecAbility)localIterator.next();
        if (localHWCodecAbility.isHWCodec) {
          if (localHWCodecAbility.codecType == 4) {
            bool7 = true;
          } else if (localHWCodecAbility.codecType == 8) {
            bool8 = true;
          } else if (localHWCodecAbility.codecType == 1) {
            bool5 = true;
          } else if (localHWCodecAbility.codecType == 2) {
            bool6 = true;
          }
        }
      }
      if ((!bool8) && (bool1)) {
        paramArrayList.add(new HWCodecAbility(8, true));
      }
      if ((!bool7) && (bool2)) {
        paramArrayList.add(new HWCodecAbility(4, true));
      }
      if ((!bool6) && (bool3)) {
        paramArrayList.add(new HWCodecAbility(2, true));
      }
      if ((!bool5) && (bool4)) {
        paramArrayList.add(new HWCodecAbility(1, true));
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("hw_debug", 4, String.format("checkDebug, h265_dec[%s, %s], h265_enc[%s, %s],h264_dec[%s, %s], h264_enc[%s, %s]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool7), Boolean.valueOf(bool1), Boolean.valueOf(bool8), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool3), Boolean.valueOf(bool6) }));
      }
    }
  }
  
  private static boolean checkMachinePower(String paramString, MediaCodecChipConfigInfo.ChipAbilityInfo paramChipAbilityInfo, HWCodecAbility paramHWCodecAbility)
  {
    long l = paramChipAbilityInfo.b;
    boolean bool = true;
    if (l == 1L)
    {
      if (DeviceCheck.f())
      {
        paramHWCodecAbility.codecType = 2;
        printsDevelop(paramString, "H264 ENC SUCCESS");
        return true;
      }
      printsDevelop(paramString, "H264 ENC FAIL");
      return false;
    }
    if (paramChipAbilityInfo.b == 4L)
    {
      if (DeviceCheck.d())
      {
        paramHWCodecAbility.codecType = 8;
        printsDevelop(paramString, "H265 ENC SUCCESS");
        return true;
      }
      printsDevelop(paramString, "H265 ENC FAIL");
      return false;
    }
    if (paramChipAbilityInfo.b == 2L)
    {
      if (DeviceCheck.e())
      {
        paramHWCodecAbility.codecType = 1;
        printsDevelop(paramString, "H264 DEC SUCCESS");
        return true;
      }
      printsDevelop(paramString, "H264 DEC FAIL");
      return false;
    }
    if (paramChipAbilityInfo.b == 8L)
    {
      if (DeviceCheck.c())
      {
        paramHWCodecAbility.codecType = 4;
        printsDevelop(paramString, "H265 DEC FAIL");
        return true;
      }
      printsDevelop(paramString, "H265 DEC FAIL");
      return false;
    }
    if (paramChipAbilityInfo.b == 0L) {
      bool = false;
    }
    return bool;
  }
  
  public static ArrayList<HWCodecAbility> checkSupportHWCodecAbility(Context paramContext)
  {
    return checkSupportHWCodecAbility("unknown", paramContext);
  }
  
  public static ArrayList<HWCodecAbility> checkSupportHWCodecAbility(String paramString, Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return null;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      invoke21Apis(paramString);
      if (!fInvokeAPILevel21)
      {
        QLog.w(paramString, 1, "checkSupportHWCodecAbility, 不是API21");
        return null;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext.getApplicationInfo().nativeLibraryDir);
    ((StringBuilder)localObject).append("/libhwcodec.so");
    if (!new File(((StringBuilder)localObject).toString()).exists())
    {
      QLog.w(paramString, 1, "checkSupportHWCodecAbility,  libhwcodec不存在");
      return null;
    }
    loadLibrary(gfLoaded, paramContext);
    if (!gfLoaded)
    {
      QLog.w(paramString, 1, "checkSupportHWCodecAbility, lib失败");
      return null;
    }
    localObject = new ArrayList();
    if (AudioHelper.e()) {
      QLog.e(paramString, 1, "checkSupportHWCodecAbility start");
    }
    getDecoderAbility(paramString, paramContext, (ArrayList)localObject);
    getEncoderAbility(paramString, paramContext, (ArrayList)localObject);
    paramContext = new ArrayList();
    getChipHWCodecAbility(paramString, paramContext);
    paramString = mergeMediaCodecConifgTwoList((ArrayList)localObject, paramContext);
    sIsSupportHwCodec1080P = isSupportHwCodec1080P(paramString);
    return paramString;
  }
  
  public static int checkSupportMediaCodecFeature(Context paramContext)
  {
    paramContext = checkSupportHWCodecAbility("unknown", paramContext);
    int k = 0;
    int i = 0;
    int j = k;
    if (paramContext != null)
    {
      j = k;
      if (paramContext.size() > 0)
      {
        paramContext = paramContext.iterator();
        for (;;)
        {
          j = i;
          if (!paramContext.hasNext()) {
            break;
          }
          HWCodecAbility localHWCodecAbility = (HWCodecAbility)paramContext.next();
          if (localHWCodecAbility.isHWCodec) {
            i += localHWCodecAbility.codecType;
          }
        }
      }
    }
    return j;
  }
  
  public static void getChipHWCodecAbility(String paramString, ArrayList<HWCodecAbility> paramArrayList)
  {
    Object localObject = MediaCodecChipConfigManager.a().b();
    if ((localObject != null) && (!((MediaCodecChipConfigInfo)localObject).a().isEmpty()))
    {
      if (Build.VERSION.SDK_INT < 19) {
        return;
      }
      localObject = ((MediaCodecChipConfigInfo)localObject).a().iterator();
      while (((Iterator)localObject).hasNext())
      {
        MediaCodecChipConfigInfo.ChipAbilityInfo localChipAbilityInfo = (MediaCodecChipConfigInfo.ChipAbilityInfo)((Iterator)localObject).next();
        if (localChipAbilityInfo.c)
        {
          HWCodecAbility localHWCodecAbility = new HWCodecAbility();
          if (checkMachinePower(paramString, localChipAbilityInfo, localHWCodecAbility))
          {
            localHWCodecAbility.isHWCodec = true;
            localHWCodecAbility.maxH = localChipAbilityInfo.e;
            localHWCodecAbility.maxW = localChipAbilityInfo.d;
            paramArrayList.add(localHWCodecAbility);
          }
        }
      }
    }
  }
  
  private static void getDecoderAbility(String paramString, Context paramContext, ArrayList<HWCodecAbility> paramArrayList)
  {
    if (DeviceCheck.b())
    {
      if (DeviceCheck.e())
      {
        paramArrayList.add(new HWCodecAbility(1, true));
        if (AudioHelper.e()) {
          QLog.w(paramString, 1, "checkSupportHWCodecAbility, 白名单, 支持H264解码");
        }
      }
      else
      {
        QLog.w(paramString, 1, "checkSupportHWCodecAbility, 白名单, 不支持H264解码");
      }
    }
    else
    {
      Object localObject = ConfigManager.c(paramContext);
      paramContext = (ICodecConfigParser)QRoute.api(ICodecConfigParser.class);
      paramContext.init((IConfigParser)localObject);
      localObject = paramContext.getAVCDecoderAbility();
      if ((localObject != null) && (((HWCodecAbility)localObject).isHWCodec))
      {
        if (DeviceCheck.e())
        {
          paramArrayList.add(localObject);
          if (AudioHelper.e())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkSupportHWCodecAbility, 支持H264解码. maxW = ");
            localStringBuilder.append(((HWCodecAbility)localObject).maxW);
            localStringBuilder.append(", maxH = ");
            localStringBuilder.append(((HWCodecAbility)localObject).maxH);
            QLog.w(paramString, 1, localStringBuilder.toString());
          }
        }
        else
        {
          QLog.w(paramString, 1, "checkSupportHWCodecAbility, 不支持H264解码");
        }
      }
      else if (QLog.isDevelopLevel()) {
        QLog.w(paramString, 1, "checkSupportHWCodecAbility, 无H264解码配置");
      }
      paramContext = paramContext.getHevcDecoderAbility();
      if ((paramContext != null) && (paramContext.isHWCodec))
      {
        if (DeviceCheck.c())
        {
          paramArrayList.add(paramContext);
          if (AudioHelper.e())
          {
            paramArrayList = new StringBuilder();
            paramArrayList.append("checkSupportHWCodecAbility, 支持H265解码. maxW = ");
            paramArrayList.append(paramContext.maxW);
            paramArrayList.append(", maxH = ");
            paramArrayList.append(paramContext.maxH);
            QLog.w(paramString, 1, paramArrayList.toString());
          }
        }
        else
        {
          QLog.w(paramString, 1, "checkSupportHWCodecAbility, 不支持H265解码");
        }
      }
      else if (QLog.isDevelopLevel()) {
        QLog.w(paramString, 1, "checkSupportHWCodecAbility, 无H265解码配置");
      }
    }
  }
  
  private static void getEncoderAbility(String paramString, Context paramContext, ArrayList<HWCodecAbility> paramArrayList)
  {
    if (DeviceCheck.a())
    {
      if (DeviceCheck.f())
      {
        paramArrayList.add(new HWCodecAbility(2, true));
        if (AudioHelper.e()) {
          QLog.w(paramString, 1, "checkSupportHWCodecAbility, 白名单, 支持H264编码");
        }
      }
      else
      {
        QLog.w(paramString, 1, "checkSupportHWCodecAbility, 白名单, 不支持H264编码");
      }
    }
    else
    {
      Object localObject = ConfigManager.c(paramContext);
      paramContext = (ICodecConfigParser)QRoute.api(ICodecConfigParser.class);
      paramContext.init((IConfigParser)localObject);
      localObject = paramContext.getAVCEncoderAbility();
      if ((localObject != null) && (((HWCodecAbility)localObject).isHWCodec))
      {
        if (DeviceCheck.f())
        {
          paramArrayList.add(localObject);
          if (AudioHelper.e())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkSupportHWCodecAbility, 支持H264编码. maxW = ");
            localStringBuilder.append(((HWCodecAbility)localObject).maxW);
            localStringBuilder.append(", maxH = ");
            localStringBuilder.append(((HWCodecAbility)localObject).maxH);
            QLog.w(paramString, 1, localStringBuilder.toString());
          }
        }
        else
        {
          QLog.w(paramString, 1, "checkSupportHWCodecAbility, 不支持H264编码");
        }
      }
      else if (QLog.isDevelopLevel()) {
        QLog.w(paramString, 1, "checkSupportHWCodecAbility, 无H264编码配置");
      }
      paramContext = paramContext.getHevcEncoderAbility();
      if ((paramContext != null) && (paramContext.isHWCodec))
      {
        if (DeviceCheck.d())
        {
          paramArrayList.add(paramContext);
          if (AudioHelper.e())
          {
            paramArrayList = new StringBuilder();
            paramArrayList.append("checkSupportHWCodecAbility, 支持H265编码. maxW = ");
            paramArrayList.append(paramContext.maxW);
            paramArrayList.append(", maxH = ");
            paramArrayList.append(paramContext.maxH);
            QLog.w(paramString, 1, paramArrayList.toString());
          }
        }
        else
        {
          QLog.w(paramString, 1, "checkSupportHWCodecAbility, 不支持H265编码");
        }
      }
      else if (QLog.isDevelopLevel()) {
        QLog.w(paramString, 1, "checkSupportHWCodecAbility, 无H265编码配置");
      }
    }
  }
  
  private static HWCodecAbility getHWCodecAbilityByCodecType(int paramInt, ArrayList<HWCodecAbility> paramArrayList)
  {
    if (paramArrayList.isEmpty()) {
      return null;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      HWCodecAbility localHWCodecAbility = (HWCodecAbility)paramArrayList.next();
      if ((paramInt == localHWCodecAbility.codecType) && (localHWCodecAbility.isHWCodec)) {
        return localHWCodecAbility;
      }
    }
    return null;
  }
  
  public static int getHwDetectOutputFormatForReport()
  {
    return mOutputFormatForReport;
  }
  
  protected static void invoke21Apis()
  {
    invoke21Apis("unknown");
  }
  
  protected static void invoke21Apis(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    try
    {
      if (fgetInputBuffer21 == null) {
        fgetInputBuffer21 = MediaCodec.class.getMethod("getInputBuffer", new Class[] { Integer.TYPE });
      }
      if (fgetOutputBuffer21 == null) {
        fgetOutputBuffer21 = MediaCodec.class.getMethod("getOutputBuffer", new Class[] { Integer.TYPE });
      }
      if (fgetOutputFormat21 != null) {
        break label108;
      }
      fgetOutputFormat21 = MediaCodec.class.getMethod("getOutputFormat", new Class[] { Integer.TYPE });
    }
    catch (Exception localException)
    {
      label92:
      StringBuilder localStringBuilder;
      break label92;
    }
    fgetInputBuffer21 = null;
    fgetOutputBuffer21 = null;
    fgetOutputFormat21 = null;
    fInvokeAPILevel21 = false;
    label108:
    if ((QLog.isDevelopLevel()) || (!fInvokeAPILevel21))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("invoke21Apis, fInvokeAPILevel21[");
      localStringBuilder.append(fInvokeAPILevel21);
      localStringBuilder.append("]");
      QLog.w(paramString, 1, localStringBuilder.toString());
    }
  }
  
  private static boolean isSupportHwCodec1080P(ArrayList<HWCodecAbility> paramArrayList)
  {
    boolean bool2 = false;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      int m = 0;
      int k = 0;
      int j = 0;
      int i = 0;
      for (;;)
      {
        i3 = m;
        i2 = k;
        i1 = j;
        n = i;
        if (!paramArrayList.hasNext()) {
          break;
        }
        HWCodecAbility localHWCodecAbility = (HWCodecAbility)paramArrayList.next();
        if ((localHWCodecAbility.codecType == 1) && (localHWCodecAbility.isHWCodec) && (localHWCodecAbility.maxW >= 1920) && (localHWCodecAbility.maxH >= 1080)) {
          k = 1;
        } else if ((localHWCodecAbility.codecType == 2) && (localHWCodecAbility.isHWCodec) && (localHWCodecAbility.maxW >= 1920) && (localHWCodecAbility.maxH >= 1080)) {
          m = 1;
        } else if ((localHWCodecAbility.codecType == 4) && (localHWCodecAbility.isHWCodec) && (localHWCodecAbility.maxW >= 1920) && (localHWCodecAbility.maxH >= 1080)) {
          i = 1;
        } else if ((localHWCodecAbility.codecType == 8) && (localHWCodecAbility.isHWCodec) && (localHWCodecAbility.maxW >= 1920) && (localHWCodecAbility.maxH >= 1080)) {
          j = 1;
        }
      }
    }
    int i3 = 0;
    int i2 = 0;
    int i1 = 0;
    int n = 0;
    boolean bool1;
    if ((i3 == 0) || (i2 == 0))
    {
      bool1 = bool2;
      if (i1 != 0)
      {
        bool1 = bool2;
        if (n == 0) {}
      }
    }
    else
    {
      bool1 = true;
    }
    paramArrayList = new StringBuilder();
    paramArrayList.append("isSupportHwCodec1080P = ");
    paramArrayList.append(bool1);
    QLog.i("AndroidCodec", 1, paramArrayList.toString());
    return bool1;
  }
  
  public static void loadCodecLibrarys()
  {
    if (!gfLoaded)
    {
      try
      {
        SoLoadUtil.a(BaseApplication.getContext(), "c++_shared", 0, false);
        System.loadLibrary("hwcodec");
        int i = NativeCodec.getVersion();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadCodecLibrarys suc, ver[");
        localStringBuilder.append(i);
        localStringBuilder.append("]");
        QLog.w("AndroidCodec", 1, localStringBuilder.toString());
        gfLoaded = true;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        localUnsatisfiedLinkError.printStackTrace();
        gfLoaded = false;
      }
      if (!gfLoaded) {
        QLog.w("AndroidCodec", 1, "loadCodecLibrarys fail");
      }
    }
  }
  
  private static void loadLibrary(boolean paramBoolean, Context paramContext)
  {
    if (!paramBoolean)
    {
      loadCodecLibrarys();
      if (paramBoolean)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("PRODUCT=");
        ((StringBuilder)localObject).append(Build.PRODUCT.toLowerCase());
        ((StringBuilder)localObject).append(";");
        localObject = ((StringBuilder)localObject).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("MODEL=");
        localStringBuilder.append(Build.MODEL.toLowerCase());
        localStringBuilder.append(";");
        localObject = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("SDK=");
        localStringBuilder.append(Build.VERSION.SDK_INT);
        localStringBuilder.append(";");
        localObject = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("FINGERPRINT=");
        localStringBuilder.append(Build.FINGERPRINT.toLowerCase());
        localStringBuilder.append(";");
        localObject = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("MANUFACTURER=");
        localStringBuilder.append(Build.MANUFACTURER.toLowerCase());
        localStringBuilder.append(";");
        localObject = localStringBuilder.toString();
        paramContext = paramContext.getApplicationInfo();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("DATADIR=");
        localStringBuilder.append(paramContext.dataDir);
        localStringBuilder.append(";");
        localObject = localStringBuilder.toString();
        if (Build.VERSION.SDK_INT >= 9)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("LIBDIR=");
          localStringBuilder.append(paramContext.nativeLibraryDir);
          localStringBuilder.append(";");
          paramContext = localStringBuilder.toString();
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("LIBDIR=");
          localStringBuilder.append(paramContext.dataDir);
          localStringBuilder.append("/lib;");
          paramContext = localStringBuilder.toString();
        }
        NativeCodec.setDeviceInfo(paramContext);
      }
    }
  }
  
  private static ArrayList<HWCodecAbility> mergeMediaCodecConifgTwoList(ArrayList<HWCodecAbility> paramArrayList1, ArrayList<HWCodecAbility> paramArrayList2)
  {
    if (paramArrayList1.isEmpty()) {
      return paramArrayList2;
    }
    if (paramArrayList2.isEmpty()) {
      return paramArrayList1;
    }
    ArrayList localArrayList = new ArrayList(4);
    int i = 0;
    while (i < 4)
    {
      int k = SUPPORT_POWER_LISTS[i];
      int j;
      if ((k != 8) && (k != 4)) {
        j = 0;
      } else {
        j = 1;
      }
      HWCodecAbility localHWCodecAbility1 = getHWCodecAbilityByCodecType(k, paramArrayList1);
      HWCodecAbility localHWCodecAbility2 = getHWCodecAbilityByCodecType(k, paramArrayList2);
      if (localHWCodecAbility1 != null)
      {
        if ((j != 0) && (localHWCodecAbility2 != null) && (localHWCodecAbility2.maxW >= 1920) && (localHWCodecAbility2.maxH >= 1080)) {
          localArrayList.add(localHWCodecAbility2);
        } else {
          localArrayList.add(localHWCodecAbility1);
        }
      }
      else if (localHWCodecAbility2 != null) {
        localArrayList.add(localHWCodecAbility2);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private static void printsDevelop(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(paramString1, 1, paramString2);
    }
  }
  
  public BufferData dequeueDecoderOutputBuffer(long paramLong)
  {
    for (;;)
    {
      try
      {
        if (this.mMediaCodec == null)
        {
          if (AudioHelper.e()) {
            QLog.e(this.mTAG, 1, "dequeueDecoderOutputBuffer mMediaCodec is null");
          }
          return null;
        }
        if (this.mCodecType != DEC_CODEC)
        {
          if (AudioHelper.e()) {
            QLog.e(this.mTAG, 1, "dequeueDecoderOutputBuffer mCodecType isn't Decoder");
          }
          return null;
        }
        localBufferData = new BufferData();
        l1 = 0L;
        if (l1 < paramLong)
        {
          l2 = System.nanoTime();
          i = this.mMediaCodec.dequeueOutputBuffer(localBufferData.info, 3000L);
          l2 = l1 + (System.nanoTime() - l2);
          if (i != -3)
          {
            if (i != -2)
            {
              if (i != -1)
              {
                if (i >= 0)
                {
                  if (Build.VERSION.SDK_INT <= 20)
                  {
                    localBufferData.buffer = this.outputBuffers[i];
                    localBufferData.index = i;
                    localBufferData.format = this.mOutputFormat;
                    return localBufferData;
                  }
                  localBufferData.index = i;
                  try
                  {
                    localBufferData.buffer = ((ByteBuffer)fgetOutputBuffer21.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(i) }));
                    localBufferData.format = ((MediaFormat)fgetOutputFormat21.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(i) }));
                  }
                  catch (InvocationTargetException localInvocationTargetException)
                  {
                    localInvocationTargetException.printStackTrace();
                    localBufferData.success = false;
                  }
                  catch (IllegalArgumentException localIllegalArgumentException)
                  {
                    localIllegalArgumentException.printStackTrace();
                    localBufferData.success = false;
                  }
                  catch (IllegalAccessException localIllegalAccessException)
                  {
                    localIllegalAccessException.printStackTrace();
                    localBufferData.success = false;
                  }
                  return localBufferData;
                }
                return null;
              }
              localBufferData.index = -1;
              return localBufferData;
            }
            localBufferData.index = -2;
            this.mOutputFormat = this.mMediaCodec.getOutputFormat();
            localObject2 = this.mOutputFormat;
            l1 = l2;
            if (localObject2 == null) {
              continue;
            }
          }
        }
      }
      finally
      {
        BufferData localBufferData;
        long l1;
        long l2;
        int i;
        Object localObject2;
        StringBuilder localStringBuilder;
        continue;
        throw localObject1;
        continue;
      }
      try
      {
        i = this.mOutputFormat.getInteger("color-format");
        mOutputFormatForReport = i;
        l1 = l2;
        if (!AudioHelper.e()) {
          continue;
        }
        localObject2 = this.mTAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("dequeueDecoderOutputBuffer New color format ");
        localStringBuilder.append(i);
        localStringBuilder.append("[0x");
        localStringBuilder.append(Integer.toHexString(i));
        localStringBuilder.append("]");
        QLog.e((String)localObject2, 1, localStringBuilder.toString());
        l1 = l2;
      }
      catch (Exception localException)
      {
        continue;
      }
      l1 = l2;
      if (AudioHelper.e())
      {
        QLog.e(this.mTAG, 1, "dequeueDecoderOutputBuffer Exception,INFO_OUTPUT_FORMAT_CHANGED");
        l1 = l2;
        continue;
        if (AudioHelper.e()) {
          QLog.e(this.mTAG, 1, "dequeueDecoderOutputBuffer INFO_OUTPUT_BUFFERS_CHANGED");
        }
        this.outputBuffers = this.mMediaCodec.getOutputBuffers();
        localBufferData.index = -3;
        l1 = l2;
      }
    }
    return null;
  }
  
  public BufferData dequeueOutputBuffer()
  {
    try
    {
      Object localObject1 = this.mMediaCodec;
      if (localObject1 == null) {
        return null;
      }
      localObject1 = new BufferData();
      int i = this.mMediaCodec.dequeueOutputBuffer(((BufferData)localObject1).info, TIMEOUT_US);
      String str1;
      if (i != -3)
      {
        if (i != -2)
        {
          if (i != -1)
          {
            if (AudioHelper.e())
            {
              String str2 = this.mTAG;
              StringBuilder localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("dequeueOutputBuffer, outIndex[");
              localStringBuilder2.append(i);
              localStringBuilder2.append("]");
              QLog.w(str2, 1, localStringBuilder2.toString());
            }
            if (i >= 0)
            {
              if (Build.VERSION.SDK_INT <= 20)
              {
                ((BufferData)localObject1).buffer = this.outputBuffers[i];
                ((BufferData)localObject1).index = i;
                ((BufferData)localObject1).format = this.mOutputFormat;
                return localObject1;
              }
              ((BufferData)localObject1).index = i;
              try
              {
                ((BufferData)localObject1).buffer = ((ByteBuffer)fgetOutputBuffer21.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(i) }));
                ((BufferData)localObject1).format = ((MediaFormat)fgetOutputFormat21.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(i) }));
              }
              catch (InvocationTargetException localInvocationTargetException)
              {
                localInvocationTargetException.printStackTrace();
                ((BufferData)localObject1).success = false;
              }
              catch (IllegalArgumentException localIllegalArgumentException)
              {
                localIllegalArgumentException.printStackTrace();
                ((BufferData)localObject1).success = false;
              }
              catch (IllegalAccessException localIllegalAccessException)
              {
                localIllegalAccessException.printStackTrace();
                ((BufferData)localObject1).success = false;
              }
              return localObject1;
            }
            return null;
          }
          if (AudioHelper.e()) {
            QLog.e(this.mTAG, 1, "dequeueOutputBuffer, INFO_TRY_AGAIN_LATER");
          }
          ((BufferData)localObject1).index = -1;
          return localObject1;
        }
        ((BufferData)localObject1).index = -2;
        this.mOutputFormat = this.mMediaCodec.getOutputFormat();
        if (this.mOutputFormat != null)
        {
          i = this.mCodecType;
          int j = DEC_CODEC;
          StringBuilder localStringBuilder1;
          if (i == j)
          {
            try
            {
              i = this.mOutputFormat.getInteger("color-format");
              if (!AudioHelper.e()) {
                break label558;
              }
              localObject1 = this.mTAG;
              localStringBuilder1 = new StringBuilder();
              localStringBuilder1.append("dequeueOutputBuffer, INFO_OUTPUT_FORMAT_CHANGED, colorformat[");
              localStringBuilder1.append(i);
              localStringBuilder1.append("|0x");
              localStringBuilder1.append(Integer.toHexString(i).toUpperCase());
              localStringBuilder1.append("]");
              QLog.w((String)localObject1, 1, localStringBuilder1.toString());
            }
            catch (Exception localException)
            {
              if (!AudioHelper.e()) {
                break label558;
              }
            }
            QLog.e(this.mTAG, 1, "dequeueOutputBuffer, INFO_OUTPUT_FORMAT_CHANGED, Exception", localException);
          }
          else if (AudioHelper.e())
          {
            str1 = this.mTAG;
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("dequeueOutputBuffer, INFO_OUTPUT_FORMAT_CHANGED, CodecType[");
            localStringBuilder1.append(this.mCodecType);
            localStringBuilder1.append("]");
            QLog.w(str1, 1, localStringBuilder1.toString());
          }
        }
        else if (AudioHelper.e())
        {
          QLog.e(this.mTAG, 1, "dequeueOutputBuffer, INFO_OUTPUT_FORMAT_CHANGED, null");
        }
      }
      else
      {
        this.outputBuffers = this.mMediaCodec.getOutputBuffers();
        str1.index = -3;
        if (AudioHelper.e()) {
          QLog.e(this.mTAG, 1, "dequeueOutputBuffer, INFO_OUTPUT_BUFFERS_CHANGED");
        }
      }
      label558:
      return null;
    }
    finally {}
  }
  
  public void flush()
  {
    MediaCodec localMediaCodec = this.mMediaCodec;
    if (localMediaCodec != null) {
      localMediaCodec.flush();
    }
  }
  
  public BufferData getInputBuffer()
  {
    if (this.mMediaCodec == null) {
      return null;
    }
    BufferData localBufferData1 = new BufferData();
    int i = this.mMediaCodec.dequeueInputBuffer(TIMEOUT_US);
    if (i >= 0)
    {
      if (Build.VERSION.SDK_INT <= 20) {
        try
        {
          localBufferData1.index = i;
          localBufferData1.buffer = this.inputBuffers[i];
          return localBufferData1;
        }
        finally {}
      }
      try
      {
        localBufferData2.index = i;
        try
        {
          localBufferData2.buffer = ((ByteBuffer)fgetInputBuffer21.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(i) }));
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          localInvocationTargetException.printStackTrace();
          localBufferData2.success = false;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          localIllegalArgumentException.printStackTrace();
          localBufferData2.success = false;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localIllegalAccessException.printStackTrace();
          localBufferData2.success = false;
        }
        return localBufferData2;
      }
      finally {}
    }
    return null;
  }
  
  public ByteBuffer getInputBuffer(int paramInt)
  {
    try
    {
      ByteBuffer localByteBuffer = (ByteBuffer)fgetInputBuffer21.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(paramInt) });
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      if (AudioHelper.e()) {
        QLog.e(this.mTAG, 1, "invoke getInputBuffer exception", localException);
      }
    }
    return null;
  }
  
  public ByteBuffer getOutputBuffer(int paramInt)
  {
    try
    {
      ByteBuffer localByteBuffer = (ByteBuffer)fgetOutputBuffer21.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(paramInt) });
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      if (AudioHelper.e()) {
        QLog.e(this.mTAG, 1, "invoke getOutputBuffer exception", localException);
      }
    }
    return null;
  }
  
  public MediaFormat getOutputFormat(int paramInt)
  {
    try
    {
      MediaFormat localMediaFormat = (MediaFormat)fgetOutputFormat21.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(paramInt) });
      return localMediaFormat;
    }
    catch (Exception localException)
    {
      if (AudioHelper.e()) {
        QLog.e(this.mTAG, 1, "invoke getOutputFormat exception", localException);
      }
    }
    return null;
  }
  
  public boolean init(MediaFormat paramMediaFormat, int paramInt, IMediaCodecCallback paramIMediaCodecCallback)
  {
    this.mFormat = paramMediaFormat;
    if (paramInt == DEC_CODEC) {
      try
      {
        this.mMediaCodec = MediaCodec.createDecoderByType(this.mFormat.getString("mime"));
      }
      catch (Exception paramMediaFormat)
      {
        paramMediaFormat.printStackTrace();
        return false;
      }
    }
    for (;;)
    {
      try
      {
        this.mMediaCodec = MediaCodec.createEncoderByType(this.mFormat.getString("mime"));
        this.mCodecType = paramInt;
        try
        {
          if (this.mMediaCodec != null)
          {
            if (paramInt == ENC_CODEC)
            {
              paramInt = 1;
              this.mIsSetMediaCodecCallbackSuc = setMediaCodecCallback(this.mMediaCodec, paramIMediaCodecCallback);
              this.mMediaCodec.configure(this.mFormat, null, null, paramInt);
            }
          }
          else {
            return this.mMediaCodec != null;
          }
        }
        catch (Exception paramMediaFormat)
        {
          paramMediaFormat.printStackTrace();
          return false;
        }
        paramInt = 0;
      }
      catch (Exception paramMediaFormat)
      {
        paramMediaFormat.printStackTrace();
        return false;
      }
    }
  }
  
  public boolean init(MediaFormat paramMediaFormat, String paramString, Surface paramSurface, IMediaCodecCallback paramIMediaCodecCallback)
  {
    this.mFormat = paramMediaFormat;
    try
    {
      this.mMediaCodec = MediaCodec.createByCodecName(paramString);
      paramMediaFormat = getCodecInfo(paramString);
      int i;
      if ((paramMediaFormat != null) && (paramMediaFormat.isEncoder()))
      {
        this.mCodecType = ENC_CODEC;
        i = 1;
      }
      else
      {
        i = 0;
      }
      try
      {
        if (this.mMediaCodec != null)
        {
          this.mIsSetMediaCodecCallbackSuc = setMediaCodecCallback(this.mMediaCodec, paramIMediaCodecCallback);
          this.mMediaCodec.configure(this.mFormat, paramSurface, null, i);
        }
        return this.mMediaCodec != null;
      }
      catch (Exception paramMediaFormat)
      {
        paramMediaFormat.printStackTrace();
        return false;
      }
      return false;
    }
    catch (Exception paramMediaFormat)
    {
      paramMediaFormat.printStackTrace();
    }
  }
  
  public boolean init(MediaFormat paramMediaFormat, String paramString, IMediaCodecCallback paramIMediaCodecCallback)
  {
    this.mFormat = paramMediaFormat;
    paramMediaFormat = getCodecInfo(paramString);
    int i;
    if ((paramMediaFormat != null) && (paramMediaFormat.isEncoder()))
    {
      this.mCodecType = ENC_CODEC;
      i = 1;
    }
    else
    {
      i = 0;
    }
    try
    {
      this.mMediaCodec = MediaCodec.createByCodecName(paramString);
      try
      {
        if (this.mMediaCodec != null)
        {
          this.mIsSetMediaCodecCallbackSuc = setMediaCodecCallback(this.mMediaCodec, paramIMediaCodecCallback);
          this.mMediaCodec.configure(this.mFormat, null, null, i);
        }
        return this.mMediaCodec != null;
      }
      catch (Exception paramMediaFormat)
      {
        paramMediaFormat.printStackTrace();
        return false;
      }
      return false;
    }
    catch (Exception paramMediaFormat)
    {
      paramMediaFormat.printStackTrace();
    }
  }
  
  public void queueInputBuffer(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    try
    {
      MediaCodec localMediaCodec = this.mMediaCodec;
      if (localMediaCodec == null) {
        return;
      }
      try
      {
        this.mMediaCodec.queueInputBuffer(paramInt1, 0, paramInt2, paramLong, paramInt3);
      }
      catch (Exception localException)
      {
        if (AudioHelper.e())
        {
          String str = this.mTAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("queueInputBuffer exception, index[");
          localStringBuilder.append(paramInt1);
          localStringBuilder.append("], sampleSize[");
          localStringBuilder.append(paramInt2);
          localStringBuilder.append("], timestamp[");
          localStringBuilder.append(paramLong);
          localStringBuilder.append("], flags[");
          localStringBuilder.append(paramInt3);
          localStringBuilder.append("]");
          QLog.w(str, 1, localStringBuilder.toString(), localException);
        }
      }
      return;
    }
    finally {}
  }
  
  public void release()
  {
    try
    {
      this.inputBuffers = null;
      this.outputBuffers = null;
      if (this.mMediaCodec != null)
      {
        this.mMediaCodec.release();
        this.mMediaCodec = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void releaseOutputBuffer(int paramInt)
  {
    try
    {
      MediaCodec localMediaCodec = this.mMediaCodec;
      if (localMediaCodec == null) {
        return;
      }
      this.mMediaCodec.releaseOutputBuffer(paramInt, false);
      return;
    }
    finally {}
  }
  
  public void reset() {}
  
  boolean setMediaCodecCallback(MediaCodec paramMediaCodec, IMediaCodecCallback paramIMediaCodecCallback)
  {
    if ((paramIMediaCodecCallback != null) && (DeviceCheck.g()))
    {
      DexClassLoader localDexClassLoader = ClassLoaderUtil.a();
      Object localObject = ClassLoaderUtil.a(localDexClassLoader, "com.tencent.av.mediacodec.MediaCodecWrapper");
      if (localObject != null) {
        try
        {
          Object[] arrayOfObject = new Object[1];
          boolean bool = ClassLoaderUtil.a(localDexClassLoader, localObject, "setCallback", new Class[] { MediaCodec.class, IMediaCodecCallback.class }, new Object[] { paramMediaCodec, paramIMediaCodecCallback }, arrayOfObject);
          return bool;
        }
        catch (Exception paramMediaCodec)
        {
          if (AudioHelper.e()) {
            QLog.w(this.mTAG, 1, "setMediaCodecCallback, Exception", paramMediaCodec);
          }
        }
      }
    }
    return false;
  }
  
  public void setParameters(Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT < 19) {
      return;
    }
    MediaCodec localMediaCodec = this.mMediaCodec;
    if (localMediaCodec == null) {
      return;
    }
    Method localMethod = fsetParameters19;
    if (localMethod != null) {
      try
      {
        localMethod.invoke(localMediaCodec, new Object[] { paramBundle });
        return;
      }
      catch (InvocationTargetException paramBundle)
      {
        if (QLog.isDevelopLevel())
        {
          QLog.w(this.mTAG, 1, "setParameters, InvocationTargetException", paramBundle);
          return;
        }
      }
      catch (IllegalAccessException paramBundle)
      {
        if (QLog.isDevelopLevel())
        {
          QLog.w(this.mTAG, 1, "setParameters, IllegalAccessException", paramBundle);
          return;
        }
      }
      catch (IllegalArgumentException paramBundle)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(this.mTAG, 1, "setParameters, IllegalArgumentException", paramBundle);
        }
      }
    }
  }
  
  public void setSurface(Surface paramSurface) {}
  
  public boolean start()
  {
    try
    {
      if (this.mMediaCodec != null)
      {
        this.mMediaCodec.start();
        if (Build.VERSION.SDK_INT <= 20) {
          try
          {
            this.inputBuffers = this.mMediaCodec.getInputBuffers();
            this.outputBuffers = this.mMediaCodec.getOutputBuffers();
          }
          finally {}
        }
        return true;
      }
    }
    catch (Exception localException)
    {
      label58:
      break label58;
    }
    return false;
  }
  
  public void stop()
  {
    MediaCodec localMediaCodec = this.mMediaCodec;
    if (localMediaCodec != null) {
      localMediaCodec.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.mediacodec.AndroidCodec
 * JD-Core Version:    0.7.0.1
 */