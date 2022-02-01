package com.tencent.av.mediacodec;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lfi;
import lfk;
import lkr;
import lks;
import lns;
import lnu;
import mrc;

@SuppressLint({"NewApi"})
public class AndroidCodec
{
  public static String AVC_CODEC_MIME;
  public static int DEC_CODEC = 0;
  public static int ENC_CODEC = 1;
  public static String ForceIFrame;
  public static String HEVC_CODEC_MIME;
  public static final int SUPPORT_AVC_DEC = 1;
  public static final int SUPPORT_AVC_ENC = 2;
  public static final int SUPPORT_HEVC_DEC = 4;
  public static final int SUPPORT_HEVC_ENC = 8;
  public static final int SUPPORT_NONE = 0;
  public static final int SUPPORT_POWER_COUNTS = 4;
  public static final int[] SUPPORT_POWER_LISTS = { 1, 2, 4, 8 };
  public static int TIMEOUT_US;
  public static boolean fInvokeAPILevel21;
  protected static Method fgetInputBuffer21;
  protected static Method fgetOutputBuffer21;
  protected static Method fgetOutputFormat21;
  protected static Method fsetParameters19;
  protected static boolean gfLoaded;
  public static int mOutputFormatForReport;
  public static boolean sIsSupportHwCodec1080P;
  final String TAG;
  protected ByteBuffer[] inputBuffers;
  protected int mCodecType = DEC_CODEC;
  protected MediaFormat mFormat;
  public boolean mIsSetMediaCodecCallbackSuc;
  protected MediaCodec mMediaCodec;
  protected MediaFormat mOutputFormat;
  protected ByteBuffer[] outputBuffers;
  
  static
  {
    AVC_CODEC_MIME = "video/avc";
    HEVC_CODEC_MIME = "video/hevc";
    ForceIFrame = "request-sync";
    fInvokeAPILevel21 = true;
    TIMEOUT_US = 33000;
  }
  
  @Deprecated
  public AndroidCodec()
  {
    this("unknown");
  }
  
  public AndroidCodec(String paramString)
  {
    this.TAG = (paramString + "_AndroidCodec");
    invoke21Apis(this.TAG);
    if ((Build.VERSION.SDK_INT >= 19) && (fsetParameters19 == null)) {}
    try
    {
      fsetParameters19 = MediaCodec.class.getMethod("setParameters", new Class[] { Bundle.class });
      return;
    }
    catch (NoSuchMethodException paramString)
    {
      fsetParameters19 = null;
    }
  }
  
  private static void checkDebug(ArrayList<AndroidCodec.HWCodecAbility> paramArrayList)
  {
    boolean bool5;
    boolean bool6;
    label24:
    boolean bool7;
    label36:
    boolean bool8;
    label48:
    boolean bool1;
    boolean bool2;
    boolean bool3;
    boolean bool4;
    label83:
    AndroidCodec.HWCodecAbility localHWCodecAbility;
    boolean bool9;
    if (1 == AudioHelper.a(33))
    {
      bool5 = true;
      if (1 != AudioHelper.a(32)) {
        break label163;
      }
      bool6 = true;
      if (1 != AudioHelper.a(31)) {
        break label169;
      }
      bool7 = true;
      if (1 != AudioHelper.a(30)) {
        break label175;
      }
      bool8 = true;
      if ((!bool5) && (!bool6) && (!bool8) && (!bool7)) {
        break label452;
      }
      Iterator localIterator = paramArrayList.iterator();
      bool1 = false;
      bool2 = false;
      bool3 = false;
      bool4 = false;
      if (!localIterator.hasNext()) {
        break label273;
      }
      localHWCodecAbility = (AndroidCodec.HWCodecAbility)localIterator.next();
      if (!localHWCodecAbility.isHWCodec) {
        break label453;
      }
      if (localHWCodecAbility.codecType != 4) {
        break label181;
      }
      bool1 = bool4;
      bool9 = bool3;
      bool4 = true;
      bool3 = bool2;
      bool2 = bool9;
    }
    label273:
    for (;;)
    {
      bool9 = bool4;
      boolean bool10 = bool3;
      bool4 = bool1;
      bool3 = bool2;
      bool2 = bool10;
      bool1 = bool9;
      break label83;
      bool5 = false;
      break;
      label163:
      bool6 = false;
      break label24;
      label169:
      bool7 = false;
      break label36;
      label175:
      bool8 = false;
      break label48;
      label181:
      if (localHWCodecAbility.codecType == 8)
      {
        bool2 = bool4;
        bool9 = true;
        bool4 = bool1;
        bool1 = bool2;
        bool2 = bool3;
        bool3 = bool9;
      }
      else if (localHWCodecAbility.codecType == 1)
      {
        bool9 = bool4;
        bool10 = true;
        bool3 = bool2;
        bool4 = bool1;
        bool1 = bool9;
        bool2 = bool10;
      }
      else if (localHWCodecAbility.codecType == 2)
      {
        bool10 = true;
        bool4 = bool2;
        bool9 = bool1;
        bool1 = bool10;
        bool2 = bool3;
        bool3 = bool4;
        bool4 = bool9;
        continue;
        if ((!bool2) && (bool5)) {
          paramArrayList.add(new AndroidCodec.HWCodecAbility(8, true));
        }
        if ((!bool1) && (bool6)) {
          paramArrayList.add(new AndroidCodec.HWCodecAbility(4, true));
        }
        if ((!bool4) && (bool7)) {
          paramArrayList.add(new AndroidCodec.HWCodecAbility(2, true));
        }
        if ((!bool3) && (bool8)) {
          paramArrayList.add(new AndroidCodec.HWCodecAbility(1, true));
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("hw_debug", 4, String.format("checkDebug, h265_dec[%s, %s], h265_enc[%s, %s],h264_dec[%s, %s], h264_enc[%s, %s]", new Object[] { Boolean.valueOf(bool6), Boolean.valueOf(bool1), Boolean.valueOf(bool5), Boolean.valueOf(bool2), Boolean.valueOf(bool8), Boolean.valueOf(bool3), Boolean.valueOf(bool7), Boolean.valueOf(bool4) }));
        }
      }
      else
      {
        label452:
        label453:
        bool9 = bool2;
        bool10 = bool1;
        bool1 = bool4;
        bool2 = bool3;
        bool3 = bool9;
        bool4 = bool10;
      }
    }
  }
  
  public static ArrayList<AndroidCodec.HWCodecAbility> checkSupportHWCodecAbility(Context paramContext)
  {
    return checkSupportHWCodecAbility("unknown", paramContext);
  }
  
  public static ArrayList<AndroidCodec.HWCodecAbility> checkSupportHWCodecAbility(String paramString, Context paramContext)
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
    if (!new File(paramContext.getApplicationInfo().nativeLibraryDir + "/libhwcodec.so").exists())
    {
      QLog.w(paramString, 1, "checkSupportHWCodecAbility,  libhwcodec不存在");
      return null;
    }
    Object localObject2;
    if (!gfLoaded)
    {
      loadCodecLibrarys();
      if (gfLoaded)
      {
        localObject1 = "PRODUCT=" + Build.PRODUCT.toLowerCase() + ";";
        localObject1 = (String)localObject1 + "MODEL=" + Build.MODEL.toLowerCase() + ";";
        localObject1 = (String)localObject1 + "SDK=" + Build.VERSION.SDK_INT + ";";
        localObject1 = (String)localObject1 + "FINGERPRINT=" + Build.FINGERPRINT.toLowerCase() + ";";
        localObject2 = (String)localObject1 + "MANUFACTURER=" + Build.MANUFACTURER.toLowerCase() + ";";
        localObject1 = paramContext.getApplicationInfo();
        localObject2 = (String)localObject2 + "DATADIR=" + ((ApplicationInfo)localObject1).dataDir + ";";
        if (Build.VERSION.SDK_INT < 9) {
          break label362;
        }
      }
    }
    label362:
    for (Object localObject1 = (String)localObject2 + "LIBDIR=" + ((ApplicationInfo)localObject1).nativeLibraryDir + ";";; localObject1 = (String)localObject2 + "LIBDIR=" + ((ApplicationInfo)localObject1).dataDir + "/lib;")
    {
      NativeCodec.set_device_infos((String)localObject1);
      if (gfLoaded) {
        break;
      }
      QLog.w(paramString, 1, "checkSupportHWCodecAbility, lib失败");
      return null;
    }
    localObject1 = new ArrayList();
    if (AudioHelper.f()) {
      QLog.e(paramString, 1, "checkSupportHWCodecAbility start");
    }
    if (DeviceCheck.b()) {
      if (DeviceCheck.e())
      {
        ((ArrayList)localObject1).add(new AndroidCodec.HWCodecAbility(1, true));
        if (AudioHelper.f()) {
          QLog.w(paramString, 1, "checkSupportHWCodecAbility, 白名单, 支持H264解码");
        }
        if (!DeviceCheck.a()) {
          break label778;
        }
        if (!DeviceCheck.f()) {
          break label767;
        }
        ((ArrayList)localObject1).add(new AndroidCodec.HWCodecAbility(2, true));
        if (AudioHelper.f()) {
          QLog.w(paramString, 1, "checkSupportHWCodecAbility, 白名单, 支持H264编码");
        }
      }
    }
    for (;;)
    {
      paramContext = new ArrayList();
      getChipHWCodecAbility(paramString, paramContext);
      paramString = mergeMediaCodecConifgTwoList((ArrayList)localObject1, paramContext);
      sIsSupportHwCodec1080P = isSupportHwCodec1080P(paramString);
      return paramString;
      QLog.w(paramString, 1, "checkSupportHWCodecAbility, 白名单, 不支持H264解码");
      break;
      localObject2 = new lnu(lfi.a(paramContext));
      AndroidCodec.HWCodecAbility localHWCodecAbility = ((lnu)localObject2).c();
      if ((localHWCodecAbility != null) && (localHWCodecAbility.isHWCodec)) {
        if (DeviceCheck.e())
        {
          ((ArrayList)localObject1).add(localHWCodecAbility);
          if (AudioHelper.f()) {
            QLog.w(paramString, 1, "checkSupportHWCodecAbility, 支持H264解码. maxW = " + localHWCodecAbility.maxW + ", maxH = " + localHWCodecAbility.maxH);
          }
        }
      }
      for (;;)
      {
        localObject2 = ((lnu)localObject2).a();
        if ((localObject2 == null) || (!((AndroidCodec.HWCodecAbility)localObject2).isHWCodec)) {
          break label750;
        }
        if (!DeviceCheck.c()) {
          break label739;
        }
        ((ArrayList)localObject1).add(localObject2);
        if (!AudioHelper.f()) {
          break;
        }
        QLog.w(paramString, 1, "checkSupportHWCodecAbility, 支持H265解码. maxW = " + ((AndroidCodec.HWCodecAbility)localObject2).maxW + ", maxH = " + ((AndroidCodec.HWCodecAbility)localObject2).maxH);
        break;
        QLog.w(paramString, 1, "checkSupportHWCodecAbility, 不支持H264解码");
        continue;
        if (QLog.isDevelopLevel()) {
          QLog.w(paramString, 1, "checkSupportHWCodecAbility, 无H264解码配置");
        }
      }
      label739:
      QLog.w(paramString, 1, "checkSupportHWCodecAbility, 不支持H265解码");
      break;
      label750:
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.w(paramString, 1, "checkSupportHWCodecAbility, 无H265解码配置");
      break;
      label767:
      QLog.w(paramString, 1, "checkSupportHWCodecAbility, 白名单, 不支持H264编码");
      continue;
      label778:
      paramContext = new lnu(lfi.a(paramContext));
      localObject2 = paramContext.d();
      if ((localObject2 != null) && (((AndroidCodec.HWCodecAbility)localObject2).isHWCodec)) {
        if (DeviceCheck.f())
        {
          ((ArrayList)localObject1).add(localObject2);
          if (AudioHelper.f()) {
            QLog.w(paramString, 1, "checkSupportHWCodecAbility, 支持H264编码. maxW = " + ((AndroidCodec.HWCodecAbility)localObject2).maxW + ", maxH = " + ((AndroidCodec.HWCodecAbility)localObject2).maxH);
          }
        }
      }
      for (;;)
      {
        paramContext = paramContext.b();
        if ((paramContext == null) || (!paramContext.isHWCodec)) {
          break label982;
        }
        if (!DeviceCheck.d()) {
          break label971;
        }
        ((ArrayList)localObject1).add(paramContext);
        if (!AudioHelper.f()) {
          break;
        }
        QLog.w(paramString, 1, "checkSupportHWCodecAbility, 支持H265编码. maxW = " + paramContext.maxW + ", maxH = " + paramContext.maxH);
        break;
        QLog.w(paramString, 1, "checkSupportHWCodecAbility, 不支持H264编码");
        continue;
        if (QLog.isDevelopLevel()) {
          QLog.w(paramString, 1, "checkSupportHWCodecAbility, 无H264编码配置");
        }
      }
      label971:
      QLog.w(paramString, 1, "checkSupportHWCodecAbility, 不支持H265编码");
      continue;
      label982:
      if (QLog.isDevelopLevel()) {
        QLog.w(paramString, 1, "checkSupportHWCodecAbility, 无H265编码配置");
      }
    }
  }
  
  public static int checkSupportMediaCodecFeature(Context paramContext)
  {
    paramContext = checkSupportHWCodecAbility("unknown", paramContext);
    int j = 0;
    int i = j;
    if (paramContext != null)
    {
      i = j;
      if (paramContext.size() > 0)
      {
        paramContext = paramContext.iterator();
        i = 0;
        if (paramContext.hasNext())
        {
          AndroidCodec.HWCodecAbility localHWCodecAbility = (AndroidCodec.HWCodecAbility)paramContext.next();
          if (!localHWCodecAbility.isHWCodec) {
            break label69;
          }
          i = localHWCodecAbility.codecType + i;
        }
      }
    }
    label69:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public static void getChipHWCodecAbility(String paramString, ArrayList<AndroidCodec.HWCodecAbility> paramArrayList)
  {
    Object localObject = lfk.a().a();
    if ((localObject == null) || (((lkr)localObject).a().isEmpty()) || (Build.VERSION.SDK_INT < 19)) {}
    for (;;)
    {
      return;
      localObject = ((lkr)localObject).a().iterator();
      while (((Iterator)localObject).hasNext())
      {
        lks locallks = (lks)((Iterator)localObject).next();
        if (locallks.jdField_a_of_type_Boolean)
        {
          AndroidCodec.HWCodecAbility localHWCodecAbility = new AndroidCodec.HWCodecAbility();
          if (locallks.jdField_a_of_type_Long == 1L) {
            if (DeviceCheck.f())
            {
              localHWCodecAbility.codecType = 2;
              if (QLog.isDevelopLevel()) {
                QLog.w(paramString, 1, "checkSupportHWCodecAbility getChipHWCodecAbility, 支持H264硬编");
              }
            }
          }
          label331:
          do
          {
            for (;;)
            {
              localHWCodecAbility.isHWCodec = true;
              localHWCodecAbility.maxH = locallks.b;
              localHWCodecAbility.maxW = locallks.jdField_a_of_type_Int;
              paramArrayList.add(localHWCodecAbility);
              break;
              if (!QLog.isDevelopLevel()) {
                break;
              }
              QLog.w(paramString, 1, "checkSupportHWCodecAbility getChipHWCodecAbility, 不支持H264硬编");
              break;
              if (locallks.jdField_a_of_type_Long == 4L)
              {
                if (DeviceCheck.d())
                {
                  localHWCodecAbility.codecType = 8;
                  if (!QLog.isDevelopLevel()) {
                    continue;
                  }
                  QLog.w(paramString, 1, "checkSupportHWCodecAbility getChipHWCodecAbility, 支持H265硬编");
                  continue;
                }
                if (!QLog.isDevelopLevel()) {
                  break;
                }
                QLog.w(paramString, 1, "checkSupportHWCodecAbility getChipHWCodecAbility, 不支持H265硬编");
                break;
              }
              if (locallks.jdField_a_of_type_Long == 2L)
              {
                if (DeviceCheck.e())
                {
                  localHWCodecAbility.codecType = 1;
                  if (!QLog.isDevelopLevel()) {
                    continue;
                  }
                  QLog.w(paramString, 1, "checkSupportHWCodecAbility getChipHWCodecAbility, 支持H264硬解");
                  continue;
                }
                if (!QLog.isDevelopLevel()) {
                  break;
                }
                QLog.w(paramString, 1, "checkSupportHWCodecAbility getChipHWCodecAbility, 不支持H264硬解");
                break;
              }
              if (locallks.jdField_a_of_type_Long != 8L) {
                break label331;
              }
              if (DeviceCheck.c())
              {
                localHWCodecAbility.codecType = 4;
                if (QLog.isDevelopLevel()) {
                  QLog.w(paramString, 1, "checkSupportHWCodecAbility getChipHWCodecAbility, 支持H265硬解");
                }
              }
              else if (QLog.isDevelopLevel())
              {
                QLog.w(paramString, 1, "checkSupportHWCodecAbility getChipHWCodecAbility, 不支持H265硬解");
              }
            }
          } while (locallks.jdField_a_of_type_Long != 0L);
        }
      }
    }
  }
  
  public static MediaCodecInfo.CodecCapabilities getCodecCapabilities(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    Object localObject = null;
    try
    {
      paramMediaCodecInfo = paramMediaCodecInfo.getCapabilitiesForType(paramString);
      return paramMediaCodecInfo;
    }
    catch (Exception localException)
    {
      do
      {
        paramMediaCodecInfo = localObject;
      } while (!QLog.isDevelopLevel());
      QLog.w("AndroidCodec", 1, "getCodecCapabilities, Exception, mime[" + paramString + "]", localException);
    }
    return null;
  }
  
  public static MediaCodecInfo getCodecInfo(String paramString)
  {
    try
    {
      int j = MediaCodecList.getCodecCount();
      int i = 0;
      while (i < j)
      {
        MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
        boolean bool = localMediaCodecInfo.getName().equalsIgnoreCase(paramString);
        if (bool) {
          return localMediaCodecInfo;
        }
        i += 1;
      }
      return null;
    }
    catch (Throwable paramString) {}
  }
  
  @SuppressLint({"NewApi"})
  public static List<MediaCodecInfo> getDecoderInfos(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        int k = MediaCodecList.getCodecCount();
        i = 0;
        if (i < k)
        {
          MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
          if ((!localMediaCodecInfo.isEncoder()) && (!localMediaCodecInfo.getName().contains(".sw.")) && (!localMediaCodecInfo.getName().contains(".SW.")) && (!localMediaCodecInfo.getName().contains("google")) && (!localMediaCodecInfo.getName().contains("Google")) && (!localMediaCodecInfo.getName().contains("GOOGLE")))
          {
            String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
            int j = 0;
            if (j < arrayOfString.length)
            {
              if (arrayOfString[j].equalsIgnoreCase(paramString)) {
                localArrayList.add(localMediaCodecInfo);
              }
              j += 1;
              continue;
            }
          }
        }
        else
        {
          return localArrayList;
        }
      }
      catch (Throwable paramString) {}
      i += 1;
    }
  }
  
  public static List<MediaCodecInfo> getEndoderInfos(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        int k = MediaCodecList.getCodecCount();
        i = 0;
        if (i < k)
        {
          MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
          if ((localMediaCodecInfo.isEncoder()) && (!localMediaCodecInfo.getName().contains(".sw.")) && (!localMediaCodecInfo.getName().contains(".SW.")) && (!localMediaCodecInfo.getName().contains("google")) && (!localMediaCodecInfo.getName().contains("Google")) && (!localMediaCodecInfo.getName().contains("GOOGLE")))
          {
            String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
            int j = 0;
            if (j < arrayOfString.length)
            {
              if (arrayOfString[j].equalsIgnoreCase(paramString)) {
                localArrayList.add(localMediaCodecInfo);
              }
              j += 1;
              continue;
            }
          }
        }
        else
        {
          return localArrayList;
        }
      }
      catch (Throwable paramString) {}
      i += 1;
    }
  }
  
  private static AndroidCodec.HWCodecAbility getHWCodecAbilityByCodecType(int paramInt, ArrayList<AndroidCodec.HWCodecAbility> paramArrayList)
  {
    if (paramArrayList.isEmpty()) {
      return null;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      AndroidCodec.HWCodecAbility localHWCodecAbility = (AndroidCodec.HWCodecAbility)paramArrayList.next();
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
  
  public static void invoke21Apis()
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
      if (fgetOutputFormat21 == null) {
        fgetOutputFormat21 = MediaCodec.class.getMethod("getOutputFormat", new Class[] { Integer.TYPE });
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        fgetInputBuffer21 = null;
        fgetOutputBuffer21 = null;
        fgetOutputFormat21 = null;
        fInvokeAPILevel21 = false;
      }
    }
    if ((QLog.isDevelopLevel()) || (!fInvokeAPILevel21)) {
      QLog.w(paramString, 1, "invoke21Apis, fInvokeAPILevel21[" + fInvokeAPILevel21 + "]");
    }
  }
  
  private static boolean isSupportHwCodec1080P(ArrayList<AndroidCodec.HWCodecAbility> paramArrayList)
  {
    boolean bool2 = false;
    int m;
    int k;
    int j;
    int i;
    int i3;
    int i2;
    int i1;
    int n;
    AndroidCodec.HWCodecAbility localHWCodecAbility;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      m = 0;
      k = 0;
      j = 0;
      i = 0;
      i3 = m;
      i2 = k;
      i1 = j;
      n = i;
      if (!paramArrayList.hasNext()) {
        break label327;
      }
      localHWCodecAbility = (AndroidCodec.HWCodecAbility)paramArrayList.next();
      if ((localHWCodecAbility.codecType == 1) && (localHWCodecAbility.isHWCodec) && (localHWCodecAbility.maxW >= 1920) && (localHWCodecAbility.maxH >= 1080))
      {
        n = m;
        j = k;
        k = 1;
        m = i;
        i = n;
      }
    }
    for (;;)
    {
      n = m;
      i1 = k;
      m = i;
      k = j;
      j = i1;
      i = n;
      break;
      if ((localHWCodecAbility.codecType == 2) && (localHWCodecAbility.isHWCodec) && (localHWCodecAbility.maxW >= 1920) && (localHWCodecAbility.maxH >= 1080))
      {
        i = m;
        m = j;
        n = 1;
        j = k;
        k = m;
        m = n;
      }
      else if ((localHWCodecAbility.codecType == 4) && (localHWCodecAbility.isHWCodec) && (localHWCodecAbility.maxW >= 1920) && (localHWCodecAbility.maxH >= 1080))
      {
        i1 = 1;
        m = j;
        n = i;
        i = i1;
        j = k;
        k = m;
        m = n;
      }
      else if ((localHWCodecAbility.codecType == 8) && (localHWCodecAbility.isHWCodec) && (localHWCodecAbility.maxW >= 1920) && (localHWCodecAbility.maxH >= 1080))
      {
        n = m;
        k = j;
        j = 1;
        m = i;
        i = n;
        continue;
        i3 = 0;
        i2 = 0;
        i1 = 0;
        n = 0;
        label327:
        boolean bool1;
        if ((n == 0) || (i1 == 0))
        {
          bool1 = bool2;
          if (i2 != 0)
          {
            bool1 = bool2;
            if (i3 == 0) {}
          }
        }
        else
        {
          bool1 = true;
        }
        QLog.i("AndroidCodec", 1, "isSupportHwCodec1080P = " + bool1);
        return bool1;
      }
      else
      {
        n = j;
        i1 = i;
        i = m;
        j = k;
        k = n;
        m = i1;
      }
    }
  }
  
  public static void loadCodecLibrarys()
  {
    if (!gfLoaded) {}
    try
    {
      SoLoadUtil.a(BaseApplicationImpl.getContext(), "c++_shared", 0, false);
      System.loadLibrary("hwcodec");
      int i = NativeCodec.getVersion();
      QLog.w("AndroidCodec", 1, "loadCodecLibrarys suc, ver[" + i + "]");
      gfLoaded = true;
      if (!gfLoaded) {
        QLog.w("AndroidCodec", 1, "loadCodecLibrarys fail");
      }
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
        gfLoaded = false;
      }
    }
  }
  
  private static ArrayList<AndroidCodec.HWCodecAbility> mergeMediaCodecConifgTwoList(ArrayList<AndroidCodec.HWCodecAbility> paramArrayList1, ArrayList<AndroidCodec.HWCodecAbility> paramArrayList2)
  {
    if (paramArrayList1.isEmpty()) {
      return paramArrayList2;
    }
    if (paramArrayList2.isEmpty()) {
      return paramArrayList1;
    }
    ArrayList localArrayList = new ArrayList(4);
    int i = 0;
    if (i < 4)
    {
      AndroidCodec.HWCodecAbility localHWCodecAbility = getHWCodecAbilityByCodecType(SUPPORT_POWER_LISTS[i], paramArrayList1);
      if (localHWCodecAbility != null) {
        localArrayList.add(localHWCodecAbility);
      }
      for (;;)
      {
        i += 1;
        break;
        localHWCodecAbility = getHWCodecAbilityByCodecType((int)lkr.a[i], paramArrayList2);
        if (localHWCodecAbility != null) {
          localArrayList.add(localHWCodecAbility);
        }
      }
    }
    return localArrayList;
  }
  
  public AndroidCodec.BufferData dequeueDecoderOutputBuffer(long paramLong)
  {
    Object localObject5 = null;
    AndroidCodec.BufferData localBufferData;
    long l1;
    label100:
    Object localObject3;
    do
    {
      try
      {
        Object localObject1;
        if (this.mMediaCodec == null)
        {
          localObject1 = localObject5;
          if (AudioHelper.f())
          {
            QLog.e(this.TAG, 1, "dequeueDecoderOutputBuffer mMediaCodec is null");
            localObject1 = localObject5;
          }
        }
        for (;;)
        {
          return localObject1;
          if (this.mCodecType == DEC_CODEC) {
            break;
          }
          localObject1 = localObject5;
          if (AudioHelper.f())
          {
            QLog.e(this.TAG, 1, "dequeueDecoderOutputBuffer mCodecType isn't Decoder");
            localObject1 = localObject5;
          }
        }
        localBufferData = new AndroidCodec.BufferData(this);
      }
      finally {}
      l1 = 0L;
      localObject3 = localObject5;
    } while (l1 >= paramLong);
    long l2 = System.nanoTime();
    int i = this.mMediaCodec.dequeueOutputBuffer(localBufferData.info, 3000L);
    l2 = l1 + (System.nanoTime() - l2);
    switch (i)
    {
    }
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          localObject3 = localObject5;
          if (i < 0) {
            break;
          }
          if (Build.VERSION.SDK_INT > 20) {
            break label418;
          }
          localBufferData.buffer = this.outputBuffers[i];
          localBufferData.index = i;
          localBufferData.format = this.mOutputFormat;
          localObject3 = localBufferData;
          break;
          if (NativeCodec.canLog()) {
            QLog.e(this.TAG, 1, "dequeueDecoderOutputBuffer INFO_OUTPUT_BUFFERS_CHANGED");
          }
          this.outputBuffers = this.mMediaCodec.getOutputBuffers();
          localBufferData.index = -3;
          l1 = l2;
          break label100;
          localBufferData.index = -2;
          this.mOutputFormat = this.mMediaCodec.getOutputFormat();
          localObject3 = this.mOutputFormat;
          l1 = l2;
          if (localObject3 == null) {
            break label100;
          }
          try
          {
            i = this.mOutputFormat.getInteger("color-format");
            mOutputFormatForReport = i;
            l1 = l2;
            if (!NativeCodec.canLog()) {
              break label100;
            }
            QLog.e(this.TAG, 1, "dequeueDecoderOutputBuffer New color format " + i + "[0x" + Integer.toHexString(i) + "]");
            l1 = l2;
          }
          catch (Exception localException)
          {
            l1 = l2;
          }
        }
        if (!AudioHelper.f()) {
          break label100;
        }
        QLog.e(this.TAG, 1, "dequeueDecoderOutputBuffer Exception,INFO_OUTPUT_FORMAT_CHANGED");
        l1 = l2;
        break label100;
        localBufferData.index = -1;
        Object localObject4 = localBufferData;
        break;
        label418:
        localBufferData.index = i;
        try
        {
          localBufferData.buffer = ((ByteBuffer)fgetOutputBuffer21.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(i) }));
          localBufferData.format = ((MediaFormat)fgetOutputFormat21.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(i) }));
          localObject4 = localBufferData;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          for (;;)
          {
            localIllegalAccessException.printStackTrace();
            localBufferData.success = false;
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            localIllegalArgumentException.printStackTrace();
            localBufferData.success = false;
          }
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          for (;;)
          {
            localInvocationTargetException.printStackTrace();
            localBufferData.success = false;
          }
        }
      }
    }
  }
  
  public AndroidCodec.BufferData dequeueOutputBuffer()
  {
    Object localObject4 = null;
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = this.mMediaCodec;
        if (localObject1 == null)
        {
          localObject1 = localObject4;
          return localObject1;
        }
        AndroidCodec.BufferData localBufferData = new AndroidCodec.BufferData(this);
        i = this.mMediaCodec.dequeueOutputBuffer(localBufferData.info, TIMEOUT_US);
        switch (i)
        {
        case -3: 
          if (NativeCodec.canLog()) {
            QLog.w(this.TAG, 1, "dequeueOutputBuffer, outIndex[" + i + "]");
          }
          localObject1 = localObject4;
          if (i < 0) {
            continue;
          }
          if (Build.VERSION.SDK_INT > 20) {
            break label464;
          }
          localBufferData.buffer = this.outputBuffers[i];
          localBufferData.index = i;
          localBufferData.format = this.mOutputFormat;
          localObject1 = localBufferData;
          continue;
          this.outputBuffers = this.mMediaCodec.getOutputBuffers();
          localBufferData.index = -3;
          localObject1 = localObject4;
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.e(this.TAG, 1, "dequeueOutputBuffer, INFO_OUTPUT_BUFFERS_CHANGED");
          localObject1 = localObject4;
          break;
        case -2: 
          localBufferData.index = -2;
        }
      }
      finally {}
      this.mOutputFormat = this.mMediaCodec.getOutputFormat();
      Object localObject3;
      if (this.mOutputFormat != null)
      {
        i = this.mCodecType;
        int j = DEC_CODEC;
        if (i == j)
        {
          try
          {
            i = this.mOutputFormat.getInteger("color-format");
            localObject3 = localObject4;
            if (!NativeCodec.canLog()) {
              continue;
            }
            QLog.w(this.TAG, 1, "dequeueOutputBuffer, INFO_OUTPUT_FORMAT_CHANGED, colorformat[" + i + "|0x" + Integer.toHexString(i).toUpperCase() + "]");
            localObject3 = localObject4;
          }
          catch (Exception localException)
          {
            localObject3 = localObject4;
          }
          if (AudioHelper.f())
          {
            QLog.e(this.TAG, 1, "dequeueOutputBuffer, INFO_OUTPUT_FORMAT_CHANGED, Exception", localException);
            localObject3 = localObject4;
          }
        }
        else
        {
          localObject3 = localObject4;
          if (AudioHelper.f())
          {
            QLog.w(this.TAG, 1, "dequeueOutputBuffer, INFO_OUTPUT_FORMAT_CHANGED, CodecType[" + this.mCodecType + "]");
            localObject3 = localObject4;
          }
        }
      }
      else
      {
        localObject3 = localObject4;
        if (QLog.isDevelopLevel())
        {
          QLog.e(this.TAG, 1, "dequeueOutputBuffer, INFO_OUTPUT_FORMAT_CHANGED, null");
          localObject3 = localObject4;
          continue;
          if (NativeCodec.canLog()) {
            QLog.e(this.TAG, 1, "dequeueOutputBuffer, INFO_TRY_AGAIN_LATER");
          }
          localException.index = -1;
          localObject3 = localException;
          continue;
          label464:
          localException.index = i;
          try
          {
            localException.buffer = ((ByteBuffer)fgetOutputBuffer21.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(i) }));
            localException.format = ((MediaFormat)fgetOutputFormat21.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(i) }));
            localObject3 = localException;
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            for (;;)
            {
              localIllegalAccessException.printStackTrace();
              localException.success = false;
            }
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            for (;;)
            {
              localIllegalArgumentException.printStackTrace();
              localException.success = false;
            }
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            for (;;)
            {
              localInvocationTargetException.printStackTrace();
              localException.success = false;
            }
          }
        }
      }
    }
  }
  
  public void flush()
  {
    if (this.mMediaCodec != null) {
      this.mMediaCodec.flush();
    }
  }
  
  /* Error */
  public AndroidCodec.BufferData getInputBuffer()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 584	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 590	com/tencent/av/mediacodec/AndroidCodec$BufferData
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 593	com/tencent/av/mediacodec/AndroidCodec$BufferData:<init>	(Lcom/tencent/av/mediacodec/AndroidCodec;)V
    //   17: astore_2
    //   18: aload_0
    //   19: getfield 584	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   22: getstatic 70	com/tencent/av/mediacodec/AndroidCodec:TIMEOUT_US	I
    //   25: i2l
    //   26: invokevirtual 696	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   29: istore_1
    //   30: iload_1
    //   31: iflt -24 -> 7
    //   34: getstatic 112	android/os/Build$VERSION:SDK_INT	I
    //   37: bipush 20
    //   39: if_icmpgt +29 -> 68
    //   42: aload_0
    //   43: monitorenter
    //   44: aload_2
    //   45: iload_1
    //   46: putfield 616	com/tencent/av/mediacodec/AndroidCodec$BufferData:index	I
    //   49: aload_2
    //   50: aload_0
    //   51: getfield 698	com/tencent/av/mediacodec/AndroidCodec:inputBuffers	[Ljava/nio/ByteBuffer;
    //   54: iload_1
    //   55: aaload
    //   56: putfield 613	com/tencent/av/mediacodec/AndroidCodec$BufferData:buffer	Ljava/nio/ByteBuffer;
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_2
    //   62: areturn
    //   63: astore_2
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_2
    //   67: athrow
    //   68: aload_0
    //   69: monitorenter
    //   70: aload_2
    //   71: iload_1
    //   72: putfield 616	com/tencent/av/mediacodec/AndroidCodec$BufferData:index	I
    //   75: aload_2
    //   76: getstatic 509	com/tencent/av/mediacodec/AndroidCodec:fgetInputBuffer21	Ljava/lang/reflect/Method;
    //   79: aload_0
    //   80: getfield 584	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   83: iconst_1
    //   84: anewarray 4	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: iload_1
    //   90: invokestatic 653	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   93: aastore
    //   94: invokevirtual 659	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   97: checkcast 661	java/nio/ByteBuffer
    //   100: putfield 613	com/tencent/av/mediacodec/AndroidCodec$BufferData:buffer	Ljava/nio/ByteBuffer;
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_2
    //   106: areturn
    //   107: astore_3
    //   108: aload_3
    //   109: invokevirtual 662	java/lang/IllegalAccessException:printStackTrace	()V
    //   112: aload_2
    //   113: iconst_0
    //   114: putfield 665	com/tencent/av/mediacodec/AndroidCodec$BufferData:success	Z
    //   117: goto -14 -> 103
    //   120: astore_2
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_2
    //   124: athrow
    //   125: astore_3
    //   126: aload_3
    //   127: invokevirtual 666	java/lang/IllegalArgumentException:printStackTrace	()V
    //   130: aload_2
    //   131: iconst_0
    //   132: putfield 665	com/tencent/av/mediacodec/AndroidCodec$BufferData:success	Z
    //   135: goto -32 -> 103
    //   138: astore_3
    //   139: aload_3
    //   140: invokevirtual 667	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   143: aload_2
    //   144: iconst_0
    //   145: putfield 665	com/tencent/av/mediacodec/AndroidCodec$BufferData:success	Z
    //   148: goto -45 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	AndroidCodec
    //   29	61	1	i	int
    //   17	45	2	localBufferData1	AndroidCodec.BufferData
    //   63	50	2	localBufferData2	AndroidCodec.BufferData
    //   120	24	2	localObject	Object
    //   107	2	3	localIllegalAccessException	IllegalAccessException
    //   125	2	3	localIllegalArgumentException	IllegalArgumentException
    //   138	2	3	localInvocationTargetException	InvocationTargetException
    // Exception table:
    //   from	to	target	type
    //   44	61	63	finally
    //   64	66	63	finally
    //   75	103	107	java/lang/IllegalAccessException
    //   70	75	120	finally
    //   75	103	120	finally
    //   103	105	120	finally
    //   108	117	120	finally
    //   121	123	120	finally
    //   126	135	120	finally
    //   139	148	120	finally
    //   75	103	125	java/lang/IllegalArgumentException
    //   75	103	138	java/lang/reflect/InvocationTargetException
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
      if (AudioHelper.f()) {
        QLog.e(this.TAG, 1, "invoke getInputBuffer exception", localException);
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
      if (AudioHelper.f()) {
        QLog.e(this.TAG, 1, "invoke getOutputBuffer exception", localException);
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
      if (AudioHelper.f()) {
        QLog.e(this.TAG, 1, "invoke getOutputFormat exception", localException);
      }
    }
    return null;
  }
  
  /* Error */
  public boolean init(MediaFormat paramMediaFormat, int paramInt, lns paramlns)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: aload_1
    //   5: putfield 710	com/tencent/av/mediacodec/AndroidCodec:mFormat	Landroid/media/MediaFormat;
    //   8: iload_2
    //   9: getstatic 87	com/tencent/av/mediacodec/AndroidCodec:DEC_CODEC	I
    //   12: if_icmpne +88 -> 100
    //   15: aload_0
    //   16: aload_0
    //   17: getfield 710	com/tencent/av/mediacodec/AndroidCodec:mFormat	Landroid/media/MediaFormat;
    //   20: ldc_w 712
    //   23: invokevirtual 716	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   26: invokestatic 720	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   29: putfield 584	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   32: aload_0
    //   33: iload_2
    //   34: putfield 89	com/tencent/av/mediacodec/AndroidCodec:mCodecType	I
    //   37: aload_0
    //   38: getfield 584	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   41: ifnull +39 -> 80
    //   44: iload_2
    //   45: getstatic 53	com/tencent/av/mediacodec/AndroidCodec:ENC_CODEC	I
    //   48: if_icmpne +86 -> 134
    //   51: iconst_1
    //   52: istore_2
    //   53: aload_0
    //   54: aload_0
    //   55: aload_0
    //   56: getfield 584	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   59: aload_3
    //   60: invokevirtual 724	com/tencent/av/mediacodec/AndroidCodec:setMediaCodecCallback	(Landroid/media/MediaCodec;Llns;)Z
    //   63: putfield 726	com/tencent/av/mediacodec/AndroidCodec:mIsSetMediaCodecCallbackSuc	Z
    //   66: aload_0
    //   67: getfield 584	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   70: aload_0
    //   71: getfield 710	com/tencent/av/mediacodec/AndroidCodec:mFormat	Landroid/media/MediaFormat;
    //   74: aconst_null
    //   75: aconst_null
    //   76: iload_2
    //   77: invokevirtual 730	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   80: aload_0
    //   81: getfield 584	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   84: ifnull +6 -> 90
    //   87: iconst_1
    //   88: istore 4
    //   90: iload 4
    //   92: ireturn
    //   93: astore_1
    //   94: aload_1
    //   95: invokevirtual 731	java/lang/Exception:printStackTrace	()V
    //   98: iconst_0
    //   99: ireturn
    //   100: aload_0
    //   101: aload_0
    //   102: getfield 710	com/tencent/av/mediacodec/AndroidCodec:mFormat	Landroid/media/MediaFormat;
    //   105: ldc_w 712
    //   108: invokevirtual 716	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   111: invokestatic 734	android/media/MediaCodec:createEncoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   114: putfield 584	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   117: goto -85 -> 32
    //   120: astore_1
    //   121: aload_1
    //   122: invokevirtual 731	java/lang/Exception:printStackTrace	()V
    //   125: iconst_0
    //   126: ireturn
    //   127: astore_1
    //   128: aload_1
    //   129: invokevirtual 731	java/lang/Exception:printStackTrace	()V
    //   132: iconst_0
    //   133: ireturn
    //   134: iconst_0
    //   135: istore_2
    //   136: goto -83 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	AndroidCodec
    //   0	139	1	paramMediaFormat	MediaFormat
    //   0	139	2	paramInt	int
    //   0	139	3	paramlns	lns
    //   1	90	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   15	32	93	java/lang/Exception
    //   100	117	120	java/lang/Exception
    //   37	51	127	java/lang/Exception
    //   53	80	127	java/lang/Exception
  }
  
  public boolean init(MediaFormat paramMediaFormat, String paramString, Surface paramSurface, lns paramlns)
  {
    this.mFormat = paramMediaFormat;
    for (;;)
    {
      try
      {
        this.mMediaCodec = MediaCodec.createByCodecName(paramString);
        paramMediaFormat = getCodecInfo(paramString);
        if ((paramMediaFormat != null) && (paramMediaFormat.isEncoder()))
        {
          this.mCodecType = ENC_CODEC;
          i = 1;
          return false;
        }
      }
      catch (Exception paramMediaFormat)
      {
        try
        {
          if (this.mMediaCodec != null)
          {
            this.mIsSetMediaCodecCallbackSuc = setMediaCodecCallback(this.mMediaCodec, paramlns);
            this.mMediaCodec.configure(this.mFormat, paramSurface, null, i);
          }
          if (this.mMediaCodec == null) {
            break label98;
          }
          return true;
        }
        catch (Exception paramMediaFormat)
        {
          paramMediaFormat.printStackTrace();
          return false;
        }
        paramMediaFormat = paramMediaFormat;
        paramMediaFormat.printStackTrace();
        return false;
      }
      label98:
      int i = 0;
    }
  }
  
  public boolean init(MediaFormat paramMediaFormat, String paramString, lns paramlns)
  {
    this.mFormat = paramMediaFormat;
    paramMediaFormat = getCodecInfo(paramString);
    if ((paramMediaFormat != null) && (paramMediaFormat.isEncoder())) {
      this.mCodecType = ENC_CODEC;
    }
    for (int i = 1;; i = 0) {
      try
      {
        this.mMediaCodec = MediaCodec.createByCodecName(paramString);
        return false;
      }
      catch (Exception paramMediaFormat)
      {
        try
        {
          if (this.mMediaCodec != null)
          {
            this.mIsSetMediaCodecCallbackSuc = setMediaCodecCallback(this.mMediaCodec, paramlns);
            this.mMediaCodec.configure(this.mFormat, null, null, i);
          }
          if (this.mMediaCodec == null) {
            continue;
          }
          return true;
        }
        catch (Exception paramMediaFormat)
        {
          paramMediaFormat.printStackTrace();
          return false;
        }
        paramMediaFormat = paramMediaFormat;
        paramMediaFormat.printStackTrace();
        return false;
      }
    }
  }
  
  /* Error */
  public void queueInputBuffer(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 584	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   6: astore 6
    //   8: aload 6
    //   10: ifnonnull +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield 584	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   20: iload_1
    //   21: iconst_0
    //   22: iload_2
    //   23: lload_3
    //   24: iload 5
    //   26: invokevirtual 746	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   29: goto -16 -> 13
    //   32: astore 6
    //   34: invokestatic 281	com/tencent/mobileqq/utils/AudioHelper:f	()Z
    //   37: ifeq -24 -> 13
    //   40: aload_0
    //   41: getfield 104	com/tencent/av/mediacodec/AndroidCodec:TAG	Ljava/lang/String;
    //   44: iconst_1
    //   45: new 91	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   52: ldc_w 748
    //   55: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: iload_1
    //   59: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc_w 750
    //   65: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: iload_2
    //   69: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: ldc_w 752
    //   75: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: lload_3
    //   79: invokevirtual 755	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   82: ldc_w 757
    //   85: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: iload 5
    //   90: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   93: ldc_w 449
    //   96: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: aload 6
    //   104: invokestatic 452	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   107: goto -94 -> 13
    //   110: astore 6
    //   112: aload_0
    //   113: monitorexit
    //   114: aload 6
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	AndroidCodec
    //   0	117	1	paramInt1	int
    //   0	117	2	paramInt2	int
    //   0	117	3	paramLong	long
    //   0	117	5	paramInt3	int
    //   6	3	6	localMediaCodec	MediaCodec
    //   32	71	6	localException	Exception
    //   110	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	29	32	java/lang/Exception
    //   2	8	110	finally
    //   16	29	110	finally
    //   34	107	110	finally
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
  
  /* Error */
  public void releaseOutputBuffer(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 584	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 584	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   18: iload_1
    //   19: iconst_0
    //   20: invokevirtual 763	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   23: goto -12 -> 11
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	AndroidCodec
    //   0	31	1	paramInt	int
    //   6	2	2	localMediaCodec	MediaCodec
    //   26	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	26	finally
    //   14	23	26	finally
  }
  
  public void reset() {}
  
  boolean setMediaCodecCallback(MediaCodec paramMediaCodec, lns paramlns)
  {
    if ((paramlns != null) && (DeviceCheck.g()))
    {
      DexClassLoader localDexClassLoader = mrc.a();
      Object localObject = mrc.a(localDexClassLoader, "com.tencent.av.mediacodec.MediaCodecWrapper");
      if (localObject != null) {
        try
        {
          Object[] arrayOfObject = new Object[1];
          boolean bool = mrc.a(localDexClassLoader, localObject, "setCallback", new Class[] { MediaCodec.class, lns.class }, new Object[] { paramMediaCodec, paramlns }, arrayOfObject);
          return bool;
        }
        catch (Exception paramMediaCodec)
        {
          if (AudioHelper.f()) {
            QLog.w(this.TAG, 1, "setMediaCodecCallback, Exception", paramMediaCodec);
          }
        }
      }
    }
    return false;
  }
  
  public void setParameters(Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT < 19) {}
    do
    {
      for (;;)
      {
        return;
        if ((this.mMediaCodec != null) && (fsetParameters19 != null)) {
          try
          {
            fsetParameters19.invoke(this.mMediaCodec, new Object[] { paramBundle });
            return;
          }
          catch (IllegalArgumentException paramBundle)
          {
            if (QLog.isDevelopLevel())
            {
              QLog.w(this.TAG, 1, "setParameters, IllegalArgumentException", paramBundle);
              return;
            }
          }
          catch (IllegalAccessException paramBundle)
          {
            if (QLog.isDevelopLevel())
            {
              QLog.w(this.TAG, 1, "setParameters, IllegalAccessException", paramBundle);
              return;
            }
          }
          catch (InvocationTargetException paramBundle) {}
        }
      }
    } while (!QLog.isDevelopLevel());
    QLog.w(this.TAG, 1, "setParameters, InvocationTargetException", paramBundle);
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
      }
      else
      {
        return false;
      }
    }
    catch (Exception localException) {}
    return true;
  }
  
  public void stop()
  {
    if (this.mMediaCodec != null) {
      this.mMediaCodec.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.mediacodec.AndroidCodec
 * JD-Core Version:    0.7.0.1
 */