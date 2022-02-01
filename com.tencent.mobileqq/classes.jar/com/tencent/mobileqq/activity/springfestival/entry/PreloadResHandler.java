package com.tencent.mobileqq.activity.springfestival.entry;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.springfestival.entry.model.ZipRes;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbMonitorReporter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.olympic.OlympicDPC;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs;
import com.tencent.mobileqq.qwallet.preload.IPreloadStaticApi;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.utils.CommonImageCacheHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PreloadResHandler
  implements IPreloadRes
{
  volatile OlympicDPC jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC;
  List<WeakReference<IPreloadRes.OnDownloadCallback>> jdField_a_of_type_JavaUtilList = new ArrayList();
  CopyOnWriteArrayList<ZipRes> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  
  public PreloadResHandler()
  {
    long l = SystemClock.uptimeMillis();
    ThreadManager.getSubThreadHandler().postAtTime(new PreloadResHandler.1(this), this, l + 1000L);
  }
  
  private static int a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if ("hb_pendant_icon".equals(paramString)) {
        return 2130844937;
      }
      if ("hb_busi_icon".equals(paramString)) {
        return 2130845277;
      }
      if ("qq_hongbao_formal_bg".equals(paramString)) {
        return 2130845289;
      }
      if ("qq_hongbao_cloud_ing_left".equals(paramString)) {
        return 2130845283;
      }
      if ("qq_hongbao_cloud_ing_right".equals(paramString)) {
        return 2130845284;
      }
      if ("qq_hongbao_progress_name".equals(paramString)) {
        return 2130845415;
      }
      if ("qq_hongbao_fudai_business_logo".equals(paramString)) {
        return 2130845404;
      }
      if ("default_miniapp_desktop_bg".equals(paramString)) {
        return 2130840333;
      }
      if ("default_share_bg_fullscreen".equals(paramString)) {
        return 2130845420;
      }
      if ("default_share_bg_window".equals(paramString)) {
        return 2130845418;
      }
    }
    return -1;
  }
  
  private static Bitmap a(String paramString, boolean paramBoolean, OlympicDPC paramOlympicDPC)
  {
    if (QLog.isColorLevel()) {
      QLog.d("shua2021_PreloadResHandler", 2, String.format("getDefaultIconBitmap start [%s]", new Object[] { paramString }));
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("red_packet_");
      ((StringBuilder)localObject).append(paramString);
      localObject = CommonImageCacheHelper.a(((StringBuilder)localObject).toString());
      if (localObject != null) {
        return localObject;
      }
      int i = a(paramString);
      if (i < 0) {
        return null;
      }
      Pair localPair = a("", i, paramOlympicDPC, 2);
      paramOlympicDPC = (OlympicDPC)localObject;
      if (localPair != null) {
        paramOlympicDPC = (Bitmap)localPair.second;
      }
      if ((paramOlympicDPC != null) && (paramBoolean))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("red_packet_");
        ((StringBuilder)localObject).append(paramString);
        CommonImageCacheHelper.a(((StringBuilder)localObject).toString(), paramOlympicDPC);
      }
      return paramOlympicDPC;
    }
    catch (Exception paramString)
    {
      SpringHbMonitorReporter.a(107, paramString, new String[0]);
      if (QLog.isColorLevel()) {
        QLog.e("shua2021_PreloadResHandler", 2, "", paramString);
      }
      return null;
    }
    catch (OutOfMemoryError paramOlympicDPC)
    {
      SpringHbMonitorReporter.a(106, paramOlympicDPC, new String[] { paramString });
      if (QLog.isColorLevel()) {
        QLog.e("shua2021_PreloadResHandler", 2, "", paramOlympicDPC);
      }
    }
    return null;
  }
  
  private static Pair<Integer, Bitmap> a(String paramString, int paramInt1, OlympicDPC paramOlympicDPC, int paramInt2)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject3 = null;
    Object localObject2 = null;
    StringBuilder localStringBuilder2 = null;
    if ((bool) && (paramInt1 < 0)) {
      return null;
    }
    int j = 3;
    Object localObject1;
    try
    {
      localObject4 = new BitmapFactory.Options();
      if (paramOlympicDPC != null)
      {
        ((BitmapFactory.Options)localObject4).inPurgeable = true;
        ((BitmapFactory.Options)localObject4).inInputShareable = true;
        if (paramOlympicDPC.d)
        {
          ((BitmapFactory.Options)localObject4).inPreferredConfig = Bitmap.Config.ARGB_8888;
        }
        else
        {
          ((BitmapFactory.Options)localObject4).inPreferredConfig = Bitmap.Config.RGB_565;
          ((BitmapFactory.Options)localObject4).inDither = true;
        }
        if (paramOlympicDPC.b) {
          ((BitmapFactory.Options)localObject4).inSampleSize = 2;
        } else {
          ((BitmapFactory.Options)localObject4).inSampleSize = 1;
        }
      }
      else
      {
        ((BitmapFactory.Options)localObject4).inPurgeable = true;
        ((BitmapFactory.Options)localObject4).inInputShareable = true;
        ((BitmapFactory.Options)localObject4).inSampleSize = 1;
        ((BitmapFactory.Options)localObject4).inPreferredConfig = Bitmap.Config.RGB_565;
        ((BitmapFactory.Options)localObject4).inDither = true;
      }
      if (paramInt2 == 1)
      {
        localObject1 = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject4);
        paramOlympicDPC = (OlympicDPC)localObject1;
      }
      else if (paramInt2 == 2)
      {
        localObject1 = BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), paramInt1, (BitmapFactory.Options)localObject4);
        if (localObject1 != null) {
          try
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder3 = new StringBuilder();
              localStringBuilder3.append("decodeResource width:");
              localStringBuilder3.append(((Bitmap)localObject1).getWidth());
              localStringBuilder3.append(", heiht:");
              localStringBuilder3.append(((Bitmap)localObject1).getHeight());
              localStringBuilder3.append(", inDensity:");
              localStringBuilder3.append(((BitmapFactory.Options)localObject4).inDensity);
              localStringBuilder3.append(", inTargetDensity:");
              localStringBuilder3.append(((BitmapFactory.Options)localObject4).inTargetDensity);
              QLog.d("shua2021_PreloadResHandler", 2, localStringBuilder3.toString());
            }
          }
          catch (Exception paramOlympicDPC)
          {
            break label323;
          }
          catch (OutOfMemoryError localOutOfMemoryError1)
          {
            break label408;
          }
        }
        paramOlympicDPC = (OlympicDPC)localObject1;
      }
      else
      {
        paramOlympicDPC = null;
      }
      localObject1 = paramOlympicDPC;
      paramInt1 = 0;
      paramOlympicDPC = (OlympicDPC)localObject3;
    }
    catch (Exception paramOlympicDPC)
    {
      localObject1 = null;
      SpringHbMonitorReporter.a(109, paramOlympicDPC, new String[0]);
      if (QLog.isColorLevel())
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("decodeBitmap Exception:");
        localStringBuilder2.append(paramOlympicDPC.toString());
        localStringBuilder2.append(",filePath:");
        localStringBuilder2.append(paramString);
        QLog.d("shua2021_PreloadResHandler", 2, localStringBuilder2.toString());
      }
      paramInt2 = 0;
      i = 1;
      paramOlympicDPC = localOutOfMemoryError1;
      break label578;
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      label323:
      localObject1 = null;
      label408:
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramInt2);
      ((StringBuilder)localObject3).append("");
      localObject3 = ((StringBuilder)localObject3).toString();
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(paramInt1);
      ((StringBuilder)localObject4).append("");
      SpringHbMonitorReporter.a(108, localOutOfMemoryError2, new String[] { localObject3, paramString, ((StringBuilder)localObject4).toString() });
      if ((paramOlympicDPC != null) && (!paramOlympicDPC.b))
      {
        paramOlympicDPC.b = true;
        paramOlympicDPC = a(paramString, paramInt1, paramOlympicDPC, paramInt2);
        localObject1 = (Bitmap)paramOlympicDPC.second;
      }
      else
      {
        paramOlympicDPC = localStringBuilder2;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("decodeBitmap OOM|path:");
        localStringBuilder1.append(paramString);
        QLog.d("shua2021_PreloadResHandler", 2, localStringBuilder1.toString());
      }
      paramInt1 = 1;
    }
    int i = 0;
    paramInt2 = paramInt1;
    label578:
    if (paramOlympicDPC != null)
    {
      if (((Integer)paramOlympicDPC.first).intValue() == 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = ((Integer)paramOlympicDPC.first).intValue();
      }
    }
    else if (paramInt2 != 0) {
      paramInt1 = 2;
    } else if (i != 0) {
      paramInt1 = j;
    } else {
      paramInt1 = 0;
    }
    if ((localObject1 == null) && (paramInt2 == 0) && (i == 0)) {}
    try
    {
      paramString = new File(paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
      if (QLog.isColorLevel()) {
        QLog.d("shua2021_PreloadResHandler", 2, "decodeBitmap| file.delete()");
      }
    }
    catch (Exception paramString)
    {
      label689:
      long l;
      break label689;
    }
    paramString = new Pair(Integer.valueOf(paramInt1), localObject1);
    if (QLog.isColorLevel())
    {
      if (localObject1 == null) {
        l = 0L;
      } else {
        l = ((Bitmap)localObject1).getRowBytes() * ((Bitmap)localObject1).getHeight() / 1024;
      }
      paramOlympicDPC = new StringBuilder();
      paramOlympicDPC.append("decodeBitmap|size:");
      paramOlympicDPC.append(l);
      paramOlympicDPC.append("KB,errCode:");
      paramOlympicDPC.append(paramInt1);
      QLog.d("shua2021_PreloadResHandler", 2, paramOlympicDPC.toString());
    }
    return paramString;
  }
  
  private PreloadResHandler.ZipResRef a(String paramString)
  {
    try
    {
      Object localObject1 = Uri.parse(paramString);
      String str2 = ((Uri)localObject1).getScheme();
      String str1 = ((Uri)localObject1).getHost();
      Object localObject2 = ((Uri)localObject1).getPath();
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).startsWith("/")) {
          localObject1 = ((String)localObject2).substring(1);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("shua2021_PreloadResHandler", 2, String.format("getZipResRef scheme=%s host=%s path=%s url=%s", new Object[] { str2, str1, localObject1, paramString }));
      }
      if ((str2.equalsIgnoreCase("ref")) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        localObject2 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          paramString = (ZipRes)((Iterator)localObject2).next();
          if (str1.equalsIgnoreCase(paramString.id))
          {
            localObject2 = new PreloadResHandler.ZipResRef(this, null);
            ((PreloadResHandler.ZipResRef)localObject2).jdField_a_of_type_JavaLangString = paramString.id;
            ((PreloadResHandler.ZipResRef)localObject2).c = paramString.url;
            ((PreloadResHandler.ZipResRef)localObject2).b = ((String)localObject1);
            return localObject2;
          }
        }
      }
    }
    catch (Throwable paramString)
    {
      SpringHbMonitorReporter.a(103, paramString, new String[0]);
      QLog.d("shua2021_PreloadResHandler", 1, paramString.getMessage(), paramString);
    }
    return null;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC == null)
    {
      OlympicDPC localOlympicDPC = new OlympicDPC();
      int i = (int)(DeviceInfoUtil.a() / 1024L / 1024L);
      int j = ViewUtils.a();
      String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.olympic_act_config.name());
      localOlympicDPC.jdField_a_of_type_JavaLangString = str;
      boolean bool;
      try
      {
        if (str.length() > 0)
        {
          String[] arrayOfString = str.split("\\|");
          if (arrayOfString.length >= 9)
          {
            if (i <= Integer.valueOf(arrayOfString[0]).intValue()) {
              localOlympicDPC.b = true;
            } else if (j <= Integer.valueOf(arrayOfString[1]).intValue()) {
              localOlympicDPC.b = true;
            }
            if (Integer.valueOf(arrayOfString[3]).intValue() == 1) {
              localOlympicDPC.d = true;
            }
            bool = false;
          }
        }
      }
      catch (Exception localException)
      {
        SpringHbMonitorReporter.a(102, localException, new String[0]);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("loadDPCConfig Exception:");
          localStringBuilder2.append(localException.toString());
          QLog.d("shua2021_PreloadResHandler", 2, localStringBuilder2.toString());
        }
        bool = true;
      }
      localOlympicDPC.jdField_a_of_type_Boolean = bool;
      if (bool)
      {
        if (i <= 512) {
          localOlympicDPC.b = true;
        } else if (j <= 480) {
          localOlympicDPC.b = true;
        }
        localOlympicDPC.d = false;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("loadDPCConfig|featureValue:");
        localStringBuilder1.append(str);
        localStringBuilder1.append(",systemTotalMem:");
        localStringBuilder1.append(i);
        localStringBuilder1.append(",screenWidth:");
        localStringBuilder1.append(j);
        localStringBuilder1.append(",isUseDefault:");
        localStringBuilder1.append(bool);
        localStringBuilder1.append(",dpc:");
        localStringBuilder1.append(localOlympicDPC.toString());
        QLog.d("shua2021_PreloadResHandler", 2, localStringBuilder1.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC = localOlympicDPC;
    }
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.length() >= 3)
      {
        bool1 = bool2;
        if ("ref".equalsIgnoreCase(paramString.substring(0, 3))) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private static Bitmap b(String paramString1, String paramString2, OlympicDPC paramOlympicDPC)
  {
    if (QLog.isColorLevel()) {
      QLog.d("shua2021_PreloadResHandler", 2, String.format("getBitmap start path=%s, defaultResName=%s", new Object[] { paramString1, paramString2 }));
    }
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject1 = localObject4;
    try
    {
      if (TextUtils.isEmpty(paramString1))
      {
        localObject1 = localObject4;
        return a(paramString2, true, paramOlympicDPC);
      }
      localObject1 = localObject4;
      Object localObject2 = new StringBuilder();
      localObject1 = localObject4;
      ((StringBuilder)localObject2).append("red_packet_");
      localObject1 = localObject4;
      ((StringBuilder)localObject2).append(paramString1);
      localObject1 = localObject4;
      String str = ((StringBuilder)localObject2).toString();
      localObject1 = localObject4;
      localObject2 = CommonImageCacheHelper.a(str);
      if (localObject2 != null) {}
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("shua2021_PreloadResHandler", 2, "getBitmap, hit cache");
        }
        return localObject2;
      }
      catch (Exception paramString2)
      {
        try
        {
          paramString1 = a(paramString1, -1, paramOlympicDPC, 1);
          if (paramString1 != null) {
            paramString1 = (Bitmap)paramString1.second;
          } else {
            paramString1 = (String)localObject2;
          }
        }
        catch (Throwable localThrowable)
        {
          SpringHbMonitorReporter.a(104, localThrowable, new String[0]);
          paramString1 = localObject3;
          localObject1 = localObject4;
          if (!QLog.isColorLevel()) {
            break label246;
          }
          localObject1 = localObject4;
          paramString1 = new StringBuilder();
          localObject1 = localObject4;
          paramString1.append("getBitmap, exception=");
          localObject1 = localObject4;
          paramString1.append(localThrowable.getMessage());
          localObject1 = localObject4;
          QLog.e("shua2021_PreloadResHandler", 2, paramString1.toString(), localThrowable);
          paramString1 = localObject3;
          if (paramString1 == null) {
            break label260;
          }
          localObject1 = paramString1;
          CommonImageCacheHelper.a(str, paramString1);
          return paramString1;
          localObject1 = paramString1;
          paramString2 = a(paramString2, true, paramOlympicDPC);
          localObject1 = paramString2;
          paramString1 = paramString2;
          if (!QLog.isColorLevel()) {
            return paramString1;
          }
        }
        paramString2 = paramString2;
        localObject1 = localObject2;
      }
      label246:
      localObject1 = paramString2;
      label260:
      QLog.d("shua2021_PreloadResHandler", 2, "getBitmap, using default bitmap");
      return paramString2;
    }
    catch (Exception paramString2)
    {
      SpringHbMonitorReporter.a(105, paramString2, new String[0]);
      paramString1 = (String)localObject1;
      if (QLog.isColorLevel())
      {
        QLog.d("shua2021_PreloadResHandler", 2, "", paramString2);
        paramString1 = (String)localObject1;
      }
    }
    return paramString1;
  }
  
  @NotNull
  public static String c(String paramString)
  {
    Object localObject = PreloadStaticApi.a(paramString, 0);
    String str;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      str = ((IPreloadStaticApi)QRoute.api(IPreloadStaticApi.class)).getRealMd5(paramString, (String)localObject, 0);
      if (!TextUtils.isEmpty(str))
      {
        localObject = PreloadStaticApi.a(str, paramString, 0);
        if (PreloadStaticApi.b((String)localObject)) {}
      }
      else
      {
        localObject = "";
      }
    }
    else
    {
      str = "";
      localObject = str;
    }
    if (QLog.isColorLevel()) {
      QLog.i("shua2021_PreloadResHandler", 2, String.format("getUnzipFolderPath foldPath=[%s] md5=[%s] zipUrl=[%s]", new Object[] { localObject, str, paramString }));
    }
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = "";
    }
    return paramString;
  }
  
  @Nullable
  public Bitmap a(String paramString1, String paramString2)
  {
    Object localObject1 = null;
    if (paramString1 == null) {
      paramString1 = null;
    } else {
      paramString1 = paramString1.trim();
    }
    if (QLog.isColorLevel()) {
      QLog.i("shua2021_PreloadResHandler", 2, String.format("getPreloadBitmap start defaultResName=[%s] url=%s", new Object[] { paramString2, paramString1 }));
    }
    if (TextUtils.isEmpty(paramString1)) {
      return b("", paramString2, this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC);
    }
    Object localObject2;
    if (a(paramString1))
    {
      localObject2 = a(paramString1);
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.i("shua2021_PreloadResHandler", 2, String.format("getPreloadBitmap find zipResRef=%s", new Object[] { localObject2 }));
        localObject1 = localObject2;
      }
    }
    if (localObject1 != null) {
      return a(((PreloadResHandler.ZipResRef)localObject1).c, ((PreloadResHandler.ZipResRef)localObject1).b, paramString2);
    }
    localObject1 = PreloadStaticApi.a(paramString1);
    boolean bool;
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (new File((String)localObject1).exists()))
    {
      bool = true;
    }
    else
    {
      localObject2 = new DownloadParam();
      ((DownloadParam)localObject2).filePos = 0;
      ((DownloadParam)localObject2).url = paramString1;
      WeakReference localWeakReference = new WeakReference(this);
      PreloadStaticApi.a().getResPath((DownloadParam)localObject2, new PreloadResHandler.3(this, paramString2, localWeakReference, paramString1));
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("shua2021_PreloadResHandler", 2, String.format("getPreloadBitmap end defaultResName=[%s] hasFile=%b path=%s", new Object[] { paramString2, Boolean.valueOf(bool), localObject1 }));
    }
    if (bool) {
      paramString1 = (String)localObject1;
    } else {
      paramString1 = "";
    }
    return b(paramString1, paramString2, this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC);
  }
  
  @Nullable
  public Bitmap a(String paramString1, String paramString2, String paramString3)
  {
    String str = null;
    if (paramString1 == null) {
      paramString1 = null;
    } else {
      paramString1 = paramString1.trim();
    }
    if (paramString2 == null) {
      paramString2 = str;
    } else {
      paramString2 = paramString2.trim();
    }
    boolean bool = QLog.isColorLevel();
    int i = 1;
    if (bool) {
      QLog.i("shua2021_PreloadResHandler", 2, String.format("getPreloadBitmapOfZip start fileName=[%s] defaultResName=[%s] zipUrl=%s", new Object[] { paramString2, paramString3, paramString1 }));
    }
    bool = TextUtils.isEmpty(paramString1);
    str = "";
    if ((!bool) && (!TextUtils.isEmpty(paramString2)))
    {
      Object localObject2 = c(paramString1);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append(paramString2);
      localObject1 = ((StringBuilder)localObject1).toString();
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!new File((String)localObject1).exists()))
      {
        localObject2 = new DownloadParam();
        ((DownloadParam)localObject2).filePos = 0;
        ((DownloadParam)localObject2).url = paramString1;
        ((DownloadParam)localObject2).isForceUnzip = true;
        PreloadStaticApi.a().getResPath((DownloadParam)localObject2, new PreloadResHandler.6(this, paramString2, paramString3));
        i = 0;
      }
      paramString1 = str;
      if (i != 0) {
        paramString1 = (String)localObject1;
      }
      return b(paramString1, paramString3, this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC);
    }
    return b("", paramString3, this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC);
  }
  
  @Nullable
  public String a(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    } else {
      paramString = paramString.trim();
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str = c(paramString);
    if (TextUtils.isEmpty(str))
    {
      DownloadParam localDownloadParam = new DownloadParam();
      localDownloadParam.filePos = 0;
      localDownloadParam.url = paramString;
      localDownloadParam.isForceUnzip = true;
      PreloadStaticApi.a().getResPath(localDownloadParam, new PreloadResHandler.4(this));
    }
    if (QLog.isColorLevel()) {
      QLog.i("shua2021_PreloadResHandler", 2, String.format("getPreloadFolderPathOfZip end url=%s zipFolderPath=%s", new Object[] { paramString, str }));
    }
    return str;
  }
  
  public void a(IPreloadRes.OnDownloadCallback paramOnDownloadCallback)
  {
    int i;
    label122:
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        i = this.jdField_a_of_type_JavaUtilList.size() - 1;
        if (i >= 0)
        {
          WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilList.get(i);
          if ((localWeakReference != null) && (localWeakReference.get() != null) && (localWeakReference.get() != paramOnDownloadCallback)) {
            break label122;
          }
          this.jdField_a_of_type_JavaUtilList.remove(i);
          break label122;
        }
      }
      if (paramOnDownloadCallback != null) {
        this.jdField_a_of_type_JavaUtilList.add(new WeakReference(paramOnDownloadCallback));
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean, String paramString, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyDownloadCallback suc=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", url=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", result=");
    localStringBuilder.append(paramObject);
    QLog.i("shua2021_PreloadResHandler", 1, localStringBuilder.toString());
    paramString = new PreloadResHandler.2(this, paramBoolean, paramString, paramObject);
    ThreadManager.getUIHandler().postAtTime(paramString, this, SystemClock.uptimeMillis());
  }
  
  @Nullable
  public String b(String paramString)
  {
    String str = null;
    DownloadParam localDownloadParam = null;
    if (paramString == null) {
      paramString = null;
    } else {
      paramString = paramString.trim();
    }
    if (QLog.isColorLevel()) {
      QLog.i("shua2021_PreloadResHandler", 2, String.format("getPreloadFilePath start url=%s", new Object[] { paramString }));
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject2;
    if (a(paramString))
    {
      localObject2 = a(paramString);
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.i("shua2021_PreloadResHandler", 2, String.format("getPreloadFilePath find zipResRef=%s", new Object[] { localObject2 }));
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      str = a(((PreloadResHandler.ZipResRef)localObject1).c);
      paramString = localDownloadParam;
      if (!TextUtils.isEmpty(str))
      {
        paramString = new StringBuilder();
        paramString.append(str);
        paramString.append(File.separator);
        paramString.append(((PreloadResHandler.ZipResRef)localObject1).b);
        localObject1 = paramString.toString();
        paramString = localDownloadParam;
        if (new File((String)localObject1).exists()) {
          paramString = (String)localObject1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("shua2021_PreloadResHandler", 2, String.format("getPreloadFilePath end [isZip] path=%s folder=%s", new Object[] { paramString, str }));
      }
      return paramString;
    }
    Object localObject1 = PreloadStaticApi.a(paramString);
    boolean bool;
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (new File((String)localObject1).exists()))
    {
      bool = true;
    }
    else
    {
      localDownloadParam = new DownloadParam();
      localDownloadParam.filePos = 0;
      localDownloadParam.url = paramString;
      localObject2 = new WeakReference(this);
      PreloadStaticApi.a().getResPath(localDownloadParam, new PreloadResHandler.5(this, paramString, (WeakReference)localObject2));
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("shua2021_PreloadResHandler", 2, String.format("getPreloadFilePath end hasFile=%b path=%s", new Object[] { Boolean.valueOf(bool), localObject1 }));
    }
    paramString = str;
    if (bool) {
      paramString = (String)localObject1;
    }
    return paramString;
  }
  
  public void b(IPreloadRes.OnDownloadCallback paramOnDownloadCallback)
  {
    int i;
    label100:
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        i = this.jdField_a_of_type_JavaUtilList.size() - 1;
        if (i >= 0)
        {
          WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilList.get(i);
          if ((localWeakReference != null) && (localWeakReference.get() != null) && (localWeakReference.get() != paramOnDownloadCallback)) {
            break label100;
          }
          this.jdField_a_of_type_JavaUtilList.remove(i);
          break label100;
        }
      }
      return;
    }
  }
  
  public void onDestroy()
  {
    ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(this);
    ThreadManager.getUIHandler().removeCallbacksAndMessages(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.PreloadResHandler
 * JD-Core Version:    0.7.0.1
 */