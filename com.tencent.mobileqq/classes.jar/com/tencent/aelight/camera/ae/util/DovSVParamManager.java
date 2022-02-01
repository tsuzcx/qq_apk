package com.tencent.aelight.camera.ae.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.aelight.camera.ae.AECameraConfig;
import com.tencent.aelight.camera.ae.camera.AECaptureParam;
import com.tencent.aelight.camera.util.api.IMediaCodecDPC;
import com.tencent.av.AVLog;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.opencl.OpenclInfoManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.util.CameraHelper;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.CaptureParam;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class DovSVParamManager
{
  private static DovSVParamManager jdField_a_of_type_ComTencentAelightCameraAeUtilDovSVParamManager;
  public float a;
  private int jdField_a_of_type_Int = 1;
  public String a;
  public Map<Integer, Float> a;
  public boolean a;
  private int jdField_b_of_type_Int = 1;
  private String jdField_b_of_type_JavaLangString = "";
  private Map<Integer, Size> jdField_b_of_type_JavaUtilMap = new HashMap();
  public boolean b;
  private Map<Integer, Size> c;
  public boolean c;
  public boolean d = false;
  public boolean e = false;
  
  private DovSVParamManager()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Float = 0.5F;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_c_of_type_JavaUtilMap = new HashMap();
    a();
  }
  
  public static DovSVParamManager a()
  {
    if (jdField_a_of_type_ComTencentAelightCameraAeUtilDovSVParamManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentAelightCameraAeUtilDovSVParamManager == null) {
          jdField_a_of_type_ComTencentAelightCameraAeUtilDovSVParamManager = new DovSVParamManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentAelightCameraAeUtilDovSVParamManager;
  }
  
  private String a()
  {
    String str2 = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_gpu_config", 0).getString("cfg_content", "");
    String str1;
    if (TextUtils.isEmpty(str2))
    {
      str2 = FileUtils.readStringFromAsset("short_video_device_rule_config.xml");
      str1 = str2;
      if (QLog.isColorLevel())
      {
        QLog.d("DovSVParamManager", 2, "take local config");
        return str2;
      }
    }
    else
    {
      str1 = str2;
      if (QLog.isColorLevel())
      {
        QLog.d("DovSVParamManager", 2, "take server config");
        str1 = str2;
      }
    }
    return str1;
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String[] arrayOfString = paramString.split(";");
    for (;;)
    {
      int i;
      try
      {
        boolean bool1 = this.jdField_a_of_type_JavaLangString.contains("Mali");
        boolean bool2 = false;
        int j;
        Object localObject;
        int k;
        int m;
        int n;
        if (bool1)
        {
          j = arrayOfString.length;
          i = 0;
          bool1 = bool2;
          if (i < j)
          {
            paramString = arrayOfString[i].split("#");
            bool1 = bool2;
            if (paramString.length == 4)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(paramString[0]);
              ((StringBuilder)localObject).append(paramString[1]);
              localObject = ((StringBuilder)localObject).toString();
              if (!this.jdField_a_of_type_JavaLangString.contains((CharSequence)localObject)) {
                break label391;
              }
              localObject = Pattern.compile("(G|T|\\-)(\\d+)(.+MP(\\d+))?").matcher(this.jdField_a_of_type_JavaLangString);
              bool1 = ((Matcher)localObject).find();
              if (!bool1) {
                break label391;
              }
              try
              {
                k = Integer.parseInt(((Matcher)localObject).group(4));
                m = Integer.parseInt(paramString[2]);
                n = Integer.parseInt(paramString[3]);
                bool1 = bool2;
                if (k > n) {
                  continue;
                }
                bool1 = bool2;
                if (k < m) {
                  continue;
                }
                bool1 = true;
              }
              catch (Exception paramString)
              {
                paramString.printStackTrace();
                break label391;
              }
            }
          }
        }
        else
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_JavaLangString.contains("Adreno"))
          {
            j = arrayOfString.length;
            i = 0;
            bool1 = bool2;
            if (i < j)
            {
              localObject = arrayOfString[i].split("#");
              paramString = "0";
              Matcher localMatcher = Pattern.compile("Adreno.*(\\d{3,4})").matcher(this.jdField_a_of_type_JavaLangString);
              if (localMatcher.find()) {
                paramString = localMatcher.group(1);
              }
              if ((localObject.length != 3) || (!paramString.substring(0, 1).equals(localObject[0])))
              {
                k = localObject.length;
                if (k != 2) {
                  break label398;
                }
              }
              try
              {
                k = Integer.parseInt(paramString);
                m = Integer.parseInt(localObject[(localObject.length - 2)]);
                n = Integer.parseInt(localObject[(localObject.length - 1)]);
                bool1 = bool2;
                if (k <= n)
                {
                  bool1 = bool2;
                  if (k >= m) {
                    continue;
                  }
                }
                a(bool1);
              }
              catch (Exception paramString)
              {
                paramString.printStackTrace();
              }
            }
          }
        }
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      label391:
      i += 1;
      continue;
      label398:
      i += 1;
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ("large".equals(paramString1))
    {
      a(paramString2, true);
      return;
    }
    if ("less".equals(paramString1))
    {
      a(paramString2, false);
      return;
    }
    if ("between".equals(paramString1))
    {
      a(paramString2);
      return;
    }
    if ("enum".equals(paramString1)) {
      b(paramString2);
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String[] arrayOfString1 = paramString.split(";");
    for (;;)
    {
      int i;
      try
      {
        boolean bool1 = this.jdField_a_of_type_JavaLangString.contains("Mali");
        boolean bool2 = false;
        int j;
        String[] arrayOfString2;
        int k;
        int m;
        if (bool1)
        {
          j = arrayOfString1.length;
          i = 0;
          bool1 = bool2;
          if (i < j)
          {
            arrayOfString2 = arrayOfString1[i].split("#");
            if (arrayOfString2.length == 2)
            {
              paramString = arrayOfString2[0];
            }
            else
            {
              bool1 = bool2;
              if (arrayOfString2.length != 3) {
                continue;
              }
              paramString = new StringBuilder();
              paramString.append(arrayOfString2[0]);
              paramString.append(arrayOfString2[1]);
              paramString = paramString.toString();
            }
            if (!this.jdField_a_of_type_JavaLangString.contains(paramString)) {
              break label415;
            }
            paramString = Pattern.compile("(G|T|\\-)(\\d+)(.+MP(\\d+))?").matcher(this.jdField_a_of_type_JavaLangString);
            k = arrayOfString2.length;
            bool1 = paramString.find();
            if (!bool1) {
              break label415;
            }
            try
            {
              k = Integer.parseInt(paramString.group((k - 1) * 2));
              m = Integer.parseInt(arrayOfString2[(arrayOfString2.length - 1)]);
              if ((!paramBoolean) || (k < m))
              {
                bool1 = bool2;
                if (!paramBoolean)
                {
                  bool1 = bool2;
                  if (k > m) {}
                }
              }
              else
              {
                bool1 = true;
              }
            }
            catch (Exception paramString)
            {
              paramString.printStackTrace();
              break label415;
            }
          }
        }
        else
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_JavaLangString.contains("Adreno"))
          {
            j = arrayOfString1.length;
            i = 0;
            bool1 = bool2;
            if (i < j)
            {
              arrayOfString2 = arrayOfString1[i].split("#");
              paramString = "0";
              Matcher localMatcher = Pattern.compile("Adreno.*(\\d{3,4})").matcher(this.jdField_a_of_type_JavaLangString);
              if (localMatcher.find()) {
                paramString = localMatcher.group(1);
              }
              if ((arrayOfString2.length != 2) || (!paramString.substring(0, 1).equals(arrayOfString2[0])))
              {
                k = arrayOfString2.length;
                if (k != 1) {
                  break label422;
                }
              }
              try
              {
                k = Integer.parseInt(paramString);
                m = Integer.parseInt(arrayOfString2[(arrayOfString2.length - 1)]);
                if ((paramBoolean) && (k >= m)) {
                  continue;
                }
                bool1 = bool2;
                if (!paramBoolean)
                {
                  bool1 = bool2;
                  if (k <= m) {
                    continue;
                  }
                }
                a(bool1);
              }
              catch (Exception paramString)
              {
                paramString.printStackTrace();
              }
            }
          }
        }
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      label415:
      i += 1;
      continue;
      label422:
      i += 1;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if ("white".equals(this.jdField_b_of_type_JavaLangString))
    {
      if (paramBoolean)
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    if ("black".equals(this.jdField_b_of_type_JavaLangString))
    {
      if (!paramBoolean)
      {
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = paramString.split(";");
    for (;;)
    {
      int i;
      try
      {
        int j = paramString.length;
        boolean bool2 = false;
        i = 0;
        boolean bool1 = bool2;
        if (i < j)
        {
          CharSequence localCharSequence = paramString[i];
          if (!this.jdField_a_of_type_JavaLangString.contains(localCharSequence)) {
            break label68;
          }
          bool1 = true;
        }
        a(bool1);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      label68:
      i += 1;
    }
  }
  
  private void c(JSONObject paramJSONObject)
  {
    try
    {
      String[] arrayOfString = paramJSONObject.getString("verdor").split(";");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (this.jdField_a_of_type_JavaLangString.contains(str)) {
          d(paramJSONObject.getJSONObject(str));
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void d(JSONObject paramJSONObject)
  {
    try
    {
      String[] arrayOfString = paramJSONObject.getString("strategy").split(";");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        JSONObject localJSONObject = paramJSONObject.getJSONObject(str);
        this.jdField_b_of_type_JavaLangString = str;
        e(localJSONObject);
        i += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void e(JSONObject paramJSONObject)
  {
    try
    {
      String[] arrayOfString = paramJSONObject.getString("rule").split(";");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        a(str, paramJSONObject.getString(str));
        i += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void f(JSONObject paramJSONObject)
  {
    try
    {
      this.jdField_a_of_type_Float = Float.valueOf(paramJSONObject.getString("maxWeight")).floatValue();
      paramJSONObject = paramJSONObject.getJSONObject("renderListWeight");
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = paramJSONObject.getString(str1);
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(str1), Float.valueOf(str2));
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void g(JSONObject paramJSONObject)
  {
    try
    {
      String[] arrayOfString1 = paramJSONObject.getString("resolutionList").split(";");
      paramJSONObject = paramJSONObject.getString("cpResolutionList").split(";");
      if (arrayOfString1.length == paramJSONObject.length)
      {
        int i = 0;
        while (i < arrayOfString1.length)
        {
          String[] arrayOfString2 = arrayOfString1[i].split("\\*");
          String[] arrayOfString3 = paramJSONObject[i].split("\\*");
          if ((arrayOfString2.length == 2) && (arrayOfString3.length == 2))
          {
            this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(i), new Size(Integer.valueOf(arrayOfString2[0]).intValue(), Integer.valueOf(arrayOfString2[1]).intValue()));
            this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(i), new Size(Integer.valueOf(arrayOfString3[0]).intValue(), Integer.valueOf(arrayOfString3[1]).intValue()));
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void h(JSONObject paramJSONObject)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Build.MANUFACTURER);
      ((StringBuilder)localObject).append(";");
      ((StringBuilder)localObject).append(Build.MODEL);
      localObject = ((StringBuilder)localObject).toString();
      JSONArray localJSONArray = paramJSONObject.getJSONArray("blackList");
      int i = 0;
      while (i < localJSONArray.length())
      {
        paramJSONObject = localJSONArray.getString(i);
        if (paramJSONObject.trim().equals(((String)localObject).trim()))
        {
          this.d = true;
          if (!QLog.isColorLevel()) {
            break;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("parseJSONBlackList true =");
          ((StringBuilder)localObject).append(paramJSONObject);
          QLog.d("DovSVParamManager", 2, ((StringBuilder)localObject).toString());
          return;
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void i(JSONObject paramJSONObject)
  {
    try
    {
      Object localObject = DeviceInstance.getInstance().getDeviceName();
      JSONArray localJSONArray = paramJSONObject.getJSONArray("qijianList");
      int i = 0;
      while (i < localJSONArray.length())
      {
        paramJSONObject = localJSONArray.getString(i);
        if (paramJSONObject.trim().equals(((String)localObject).trim()))
        {
          this.jdField_c_of_type_Boolean = true;
          if (!QLog.isColorLevel()) {
            break;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("parseJSONQijianList true =");
          ((StringBuilder)localObject).append(paramJSONObject);
          QLog.d("DovSVParamManager", 2, ((StringBuilder)localObject).toString());
          return;
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void j(JSONObject paramJSONObject)
  {
    try
    {
      this.jdField_a_of_type_Int = paramJSONObject.optInt("faceDetectSwitch", 1);
      if (QLog.isColorLevel())
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("parseJSONFaceDetectSwitch mFaceDetectType:");
        paramJSONObject.append(this.jdField_a_of_type_Int);
        QLog.d("DovSVParamManager", 2, paramJSONObject.toString());
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public float a(int paramInt)
  {
    return 1.0F;
  }
  
  public int a(int paramInt)
  {
    return 4000;
  }
  
  public AECaptureParam a(Context paramContext, int paramInt)
  {
    paramContext = new AECaptureParam();
    Size localSize1 = a(paramInt);
    Size localSize2 = b(paramInt);
    if (localSize1 != null)
    {
      paramContext.a(localSize1.a());
      paramContext.b(localSize1.b());
    }
    if (localSize2 != null)
    {
      paramContext.c(localSize2.a());
      paramContext.d(localSize2.b());
    }
    paramContext.a(a(paramInt));
    int i = a(paramInt) * 1000;
    paramContext.e(i);
    com.tencent.mobileqq.editor.composite.CodecParam.mMaxrate = i;
    paramContext.f(1);
    paramContext.g(paramInt);
    if ((((IMediaCodecDPC)QRoute.api(IMediaCodecDPC.class)).isCqBitrateModeSwitchOpen()) && (Build.VERSION.SDK_INT < 27)) {
      paramContext.h(0);
    }
    return paramContext;
  }
  
  public AECaptureParam a(AECameraConfig paramAECameraConfig)
  {
    AECaptureParam localAECaptureParam = new AECaptureParam();
    localAECaptureParam.a(paramAECameraConfig.a().a());
    localAECaptureParam.b(paramAECameraConfig.a().b());
    localAECaptureParam.a(paramAECameraConfig.a().floatValue());
    localAECaptureParam.e(paramAECameraConfig.a().intValue());
    com.tencent.mobileqq.editor.composite.CodecParam.mMaxrate = paramAECameraConfig.a().intValue();
    localAECaptureParam.f(1);
    localAECaptureParam.g(paramAECameraConfig.g());
    return localAECaptureParam;
  }
  
  public Size a(int paramInt)
  {
    if (this.d)
    {
      localObject = this.jdField_b_of_type_JavaUtilMap;
      paramInt = 1;
    }
    else
    {
      localObject = this.jdField_b_of_type_JavaUtilMap;
      paramInt = 0;
    }
    Object localObject = (Size)((Map)localObject).get(Integer.valueOf(paramInt));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCameraResolution inBlackPhone = ");
      localStringBuilder.append(this.d);
      localStringBuilder.append(" dpcSize=");
      localStringBuilder.append(localObject);
      QLog.d("DovSVParamManager", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public Size a(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    return new Size(localDisplayMetrics.heightPixels, localDisplayMetrics.widthPixels);
  }
  
  public CameraCaptureView.CaptureParam a(Context paramContext)
  {
    CameraCaptureView.CaptureParam localCaptureParam = new CameraCaptureView.CaptureParam();
    int i = CameraHelper.a();
    Size localSize1 = a(i);
    Size localSize2 = b(i);
    paramContext = a(paramContext);
    if (localSize1 != null)
    {
      localCaptureParam.a(localSize1.a());
      localCaptureParam.b(localSize1.b());
    }
    if (localSize2 != null)
    {
      localCaptureParam.c(localSize2.a());
      localCaptureParam.d(localSize2.b());
    }
    if (paramContext != null)
    {
      localCaptureParam.e(paramContext.a());
      localCaptureParam.f(paramContext.b());
    }
    localCaptureParam.a(a(i));
    int j = a(i) * 1000;
    localCaptureParam.h(j);
    com.tencent.mobileqq.editor.composite.CodecParam.mMaxrate = j;
    localCaptureParam.i(1);
    localCaptureParam.g(i);
    if ((((IMediaCodecDPC)QRoute.api(IMediaCodecDPC.class)).isCqBitrateModeSwitchOpen()) && (Build.VERSION.SDK_INT < 27)) {
      localCaptureParam.j(0);
    }
    return localCaptureParam;
  }
  
  public void a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(a());
      g(localJSONObject);
      f(localJSONObject);
      a(localJSONObject);
      h(localJSONObject);
      i(localJSONObject);
      j(localJSONObject);
      b(localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parse sv config error, stacktrace :  ");
        localStringBuilder.append(QLog.getStackTraceString(localException));
        QLog.e("DovSVParamManager", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if ((!Build.MODEL.contains("Pixel")) && (!Build.MODEL.contains("Nexus")) && (Build.VERSION.SDK_INT < 24) && (Build.VERSION.SDK_INT >= 21))
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaLangString = new OpenclInfoManager().a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("GPUInfo:");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        QLog.d("DovSVParamManager", 1, localStringBuilder.toString());
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_Boolean = (a(4, 1200000L, 2573741824L, 17) ^ true);
      }
    }
    else
    {
      this.jdField_a_of_type_Boolean = (a(4, 1200000L, 2573741824L, 17) ^ true);
    }
    c(paramJSONObject);
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean a(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    int i = DeviceInfoUtil.a();
    StringBuilder localStringBuilder;
    if (i < paramInt2)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSupportOfDevice error OSversion: ");
      localStringBuilder.append(i);
      AVLog.printColorLog("DovSVParamManager", localStringBuilder.toString());
      return false;
    }
    paramInt2 = VcSystemInfo.getNumCores();
    if (paramInt2 < paramInt1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSupportOfDevice error cpucount: ");
      localStringBuilder.append(paramInt2);
      AVLog.printColorLog("DovSVParamManager", localStringBuilder.toString());
      return false;
    }
    long l = VcSystemInfo.getMaxCpuFreq();
    if (l < paramLong1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSupportOfDevice error cpuFrequency: ");
      localStringBuilder.append(l);
      AVLog.printColorLog("DovSVParamManager", localStringBuilder.toString());
      return false;
    }
    paramLong1 = DeviceInfoUtil.a();
    if (paramLong1 < paramLong2)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSupportOfDevice error memory: ");
      localStringBuilder.append(paramLong1);
      AVLog.printColorLog("DovSVParamManager", localStringBuilder.toString());
      return false;
    }
    return true;
  }
  
  public Size b(int paramInt)
  {
    if (this.d)
    {
      localObject = this.jdField_c_of_type_JavaUtilMap;
      paramInt = 1;
    }
    else
    {
      localObject = this.jdField_c_of_type_JavaUtilMap;
      paramInt = 0;
    }
    Object localObject = (Size)((Map)localObject).get(Integer.valueOf(paramInt));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDpcCompressResolution inBlackPhone = ");
      localStringBuilder.append(this.d);
      localStringBuilder.append(" dpcCompressSize=");
      localStringBuilder.append(localObject);
      QLog.d("DovSVParamManager", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public void b(JSONObject paramJSONObject)
  {
    try
    {
      this.jdField_b_of_type_Int = paramJSONObject.optInt("samSungCameraSwitch", 1);
      if (QLog.isColorLevel())
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("parseJsonSamSungSwitch parseJsonSamSungSwitch:");
        paramJSONObject.append(this.jdField_b_of_type_Int);
        QLog.d("DovSVParamManager", 2, paramJSONObject.toString());
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Int == 1;
  }
  
  public boolean c()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.util.DovSVParamManager
 * JD-Core Version:    0.7.0.1
 */