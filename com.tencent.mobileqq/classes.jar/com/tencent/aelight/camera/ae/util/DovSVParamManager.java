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
  private static DovSVParamManager i;
  public String a = "";
  public boolean b = false;
  public boolean c = false;
  public boolean d = true;
  public boolean e = false;
  public boolean f = false;
  public float g = 0.5F;
  public Map<Integer, Float> h = new HashMap();
  private String j = "";
  private Map<Integer, Size> k = new HashMap();
  private Map<Integer, Size> l = new HashMap();
  private int m = 1;
  private int n = 1;
  
  private DovSVParamManager()
  {
    b();
  }
  
  public static DovSVParamManager a()
  {
    if (i == null) {
      try
      {
        if (i == null) {
          i = new DovSVParamManager();
        }
      }
      finally {}
    }
    return i;
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String[] arrayOfString = paramString.split(";");
    for (;;)
    {
      int i1;
      try
      {
        boolean bool1 = this.a.contains("Mali");
        boolean bool2 = false;
        int i2;
        Object localObject;
        int i3;
        int i4;
        int i5;
        if (bool1)
        {
          i2 = arrayOfString.length;
          i1 = 0;
          bool1 = bool2;
          if (i1 < i2)
          {
            paramString = arrayOfString[i1].split("#");
            bool1 = bool2;
            if (paramString.length == 4)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(paramString[0]);
              ((StringBuilder)localObject).append(paramString[1]);
              localObject = ((StringBuilder)localObject).toString();
              if (!this.a.contains((CharSequence)localObject)) {
                break label391;
              }
              localObject = Pattern.compile("(G|T|\\-)(\\d+)(.+MP(\\d+))?").matcher(this.a);
              bool1 = ((Matcher)localObject).find();
              if (!bool1) {
                break label391;
              }
              try
              {
                i3 = Integer.parseInt(((Matcher)localObject).group(4));
                i4 = Integer.parseInt(paramString[2]);
                i5 = Integer.parseInt(paramString[3]);
                bool1 = bool2;
                if (i3 > i5) {
                  continue;
                }
                bool1 = bool2;
                if (i3 < i4) {
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
          if (this.a.contains("Adreno"))
          {
            i2 = arrayOfString.length;
            i1 = 0;
            bool1 = bool2;
            if (i1 < i2)
            {
              localObject = arrayOfString[i1].split("#");
              paramString = "0";
              Matcher localMatcher = Pattern.compile("Adreno.*(\\d{3,4})").matcher(this.a);
              if (localMatcher.find()) {
                paramString = localMatcher.group(1);
              }
              if ((localObject.length != 3) || (!paramString.substring(0, 1).equals(localObject[0])))
              {
                i3 = localObject.length;
                if (i3 != 2) {
                  break label398;
                }
              }
              try
              {
                i3 = Integer.parseInt(paramString);
                i4 = Integer.parseInt(localObject[(localObject.length - 2)]);
                i5 = Integer.parseInt(localObject[(localObject.length - 1)]);
                bool1 = bool2;
                if (i3 <= i5)
                {
                  bool1 = bool2;
                  if (i3 >= i4) {
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
      i1 += 1;
      continue;
      label398:
      i1 += 1;
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
      int i1;
      try
      {
        boolean bool1 = this.a.contains("Mali");
        boolean bool2 = false;
        int i2;
        String[] arrayOfString2;
        int i3;
        int i4;
        if (bool1)
        {
          i2 = arrayOfString1.length;
          i1 = 0;
          bool1 = bool2;
          if (i1 < i2)
          {
            arrayOfString2 = arrayOfString1[i1].split("#");
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
            if (!this.a.contains(paramString)) {
              break label415;
            }
            paramString = Pattern.compile("(G|T|\\-)(\\d+)(.+MP(\\d+))?").matcher(this.a);
            i3 = arrayOfString2.length;
            bool1 = paramString.find();
            if (!bool1) {
              break label415;
            }
            try
            {
              i3 = Integer.parseInt(paramString.group((i3 - 1) * 2));
              i4 = Integer.parseInt(arrayOfString2[(arrayOfString2.length - 1)]);
              if ((!paramBoolean) || (i3 < i4))
              {
                bool1 = bool2;
                if (!paramBoolean)
                {
                  bool1 = bool2;
                  if (i3 > i4) {}
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
          if (this.a.contains("Adreno"))
          {
            i2 = arrayOfString1.length;
            i1 = 0;
            bool1 = bool2;
            if (i1 < i2)
            {
              arrayOfString2 = arrayOfString1[i1].split("#");
              paramString = "0";
              Matcher localMatcher = Pattern.compile("Adreno.*(\\d{3,4})").matcher(this.a);
              if (localMatcher.find()) {
                paramString = localMatcher.group(1);
              }
              if ((arrayOfString2.length != 2) || (!paramString.substring(0, 1).equals(arrayOfString2[0])))
              {
                i3 = arrayOfString2.length;
                if (i3 != 1) {
                  break label422;
                }
              }
              try
              {
                i3 = Integer.parseInt(paramString);
                i4 = Integer.parseInt(arrayOfString2[(arrayOfString2.length - 1)]);
                if ((paramBoolean) && (i3 >= i4)) {
                  continue;
                }
                bool1 = bool2;
                if (!paramBoolean)
                {
                  bool1 = bool2;
                  if (i3 <= i4) {
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
      i1 += 1;
      continue;
      label422:
      i1 += 1;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if ("white".equals(this.j))
    {
      if (paramBoolean)
      {
        this.c = true;
        this.b = false;
        return;
      }
      this.c = false;
      return;
    }
    if ("black".equals(this.j))
    {
      if (!paramBoolean)
      {
        this.b = false;
        return;
      }
      this.b = true;
      this.c = false;
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
      int i1;
      try
      {
        int i2 = paramString.length;
        boolean bool2 = false;
        i1 = 0;
        boolean bool1 = bool2;
        if (i1 < i2)
        {
          CharSequence localCharSequence = paramString[i1];
          if (!this.a.contains(localCharSequence)) {
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
      i1 += 1;
    }
  }
  
  private void c(JSONObject paramJSONObject)
  {
    try
    {
      String[] arrayOfString = paramJSONObject.getString("verdor").split(";");
      int i2 = arrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        String str = arrayOfString[i1];
        if (this.a.contains(str)) {
          d(paramJSONObject.getJSONObject(str));
        }
        i1 += 1;
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
      int i2 = arrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        String str = arrayOfString[i1];
        JSONObject localJSONObject = paramJSONObject.getJSONObject(str);
        this.j = str;
        e(localJSONObject);
        i1 += 1;
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
      int i2 = arrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        String str = arrayOfString[i1];
        a(str, paramJSONObject.getString(str));
        i1 += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private String f()
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
  
  private void f(JSONObject paramJSONObject)
  {
    try
    {
      this.g = Float.valueOf(paramJSONObject.getString("maxWeight")).floatValue();
      paramJSONObject = paramJSONObject.getJSONObject("renderListWeight");
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = paramJSONObject.getString(str1);
        this.h.put(Integer.valueOf(str1), Float.valueOf(str2));
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
        int i1 = 0;
        while (i1 < arrayOfString1.length)
        {
          String[] arrayOfString2 = arrayOfString1[i1].split("\\*");
          String[] arrayOfString3 = paramJSONObject[i1].split("\\*");
          if ((arrayOfString2.length == 2) && (arrayOfString3.length == 2))
          {
            this.k.put(Integer.valueOf(i1), new Size(Integer.valueOf(arrayOfString2[0]).intValue(), Integer.valueOf(arrayOfString2[1]).intValue()));
            this.l.put(Integer.valueOf(i1), new Size(Integer.valueOf(arrayOfString3[0]).intValue(), Integer.valueOf(arrayOfString3[1]).intValue()));
          }
          i1 += 1;
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
      int i1 = 0;
      while (i1 < localJSONArray.length())
      {
        paramJSONObject = localJSONArray.getString(i1);
        if (paramJSONObject.trim().equals(((String)localObject).trim()))
        {
          this.e = true;
          if (!QLog.isColorLevel()) {
            break;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("parseJSONBlackList true =");
          ((StringBuilder)localObject).append(paramJSONObject);
          QLog.d("DovSVParamManager", 2, ((StringBuilder)localObject).toString());
          return;
        }
        i1 += 1;
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
      int i1 = 0;
      while (i1 < localJSONArray.length())
      {
        paramJSONObject = localJSONArray.getString(i1);
        if (paramJSONObject.trim().equals(((String)localObject).trim()))
        {
          this.d = true;
          if (!QLog.isColorLevel()) {
            break;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("parseJSONQijianList true =");
          ((StringBuilder)localObject).append(paramJSONObject);
          QLog.d("DovSVParamManager", 2, ((StringBuilder)localObject).toString());
          return;
        }
        i1 += 1;
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
      this.m = paramJSONObject.optInt("faceDetectSwitch", 1);
      if (QLog.isColorLevel())
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("parseJSONFaceDetectSwitch mFaceDetectType:");
        paramJSONObject.append(this.m);
        QLog.d("DovSVParamManager", 2, paramJSONObject.toString());
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
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
    paramContext.a(c(paramInt));
    int i1 = d(paramInt) * 1000;
    paramContext.e(i1);
    com.tencent.mobileqq.editor.composite.CodecParam.mMaxrate = i1;
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
    localAECaptureParam.a(paramAECameraConfig.n().a());
    localAECaptureParam.b(paramAECameraConfig.n().b());
    localAECaptureParam.a(paramAECameraConfig.l().floatValue());
    localAECaptureParam.e(paramAECameraConfig.k().intValue());
    com.tencent.mobileqq.editor.composite.CodecParam.mMaxrate = paramAECameraConfig.k().intValue();
    localAECaptureParam.f(1);
    localAECaptureParam.g(paramAECameraConfig.s());
    return localAECaptureParam;
  }
  
  public Size a(int paramInt)
  {
    if (this.e)
    {
      localObject = this.k;
      paramInt = 1;
    }
    else
    {
      localObject = this.k;
      paramInt = 0;
    }
    Object localObject = (Size)((Map)localObject).get(Integer.valueOf(paramInt));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCameraResolution inBlackPhone = ");
      localStringBuilder.append(this.e);
      localStringBuilder.append(" dpcSize=");
      localStringBuilder.append(localObject);
      QLog.d("DovSVParamManager", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public CameraCaptureView.CaptureParam a(Context paramContext)
  {
    CameraCaptureView.CaptureParam localCaptureParam = new CameraCaptureView.CaptureParam();
    int i1 = CameraHelper.a();
    Size localSize1 = a(i1);
    Size localSize2 = b(i1);
    paramContext = b(paramContext);
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
    localCaptureParam.a(c(i1));
    int i2 = d(i1) * 1000;
    localCaptureParam.h(i2);
    com.tencent.mobileqq.editor.composite.CodecParam.mMaxrate = i2;
    localCaptureParam.i(1);
    localCaptureParam.g(i1);
    if ((((IMediaCodecDPC)QRoute.api(IMediaCodecDPC.class)).isCqBitrateModeSwitchOpen()) && (Build.VERSION.SDK_INT < 27)) {
      localCaptureParam.j(0);
    }
    return localCaptureParam;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if ((!Build.MODEL.contains("Pixel")) && (!Build.MODEL.contains("Nexus")) && (Build.VERSION.SDK_INT < 24) && (Build.VERSION.SDK_INT >= 21))
    {
      if (TextUtils.isEmpty(this.a))
      {
        this.a = new OpenclInfoManager().b();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("GPUInfo:");
        localStringBuilder.append(this.a);
        QLog.d("DovSVParamManager", 1, localStringBuilder.toString());
      }
      if (TextUtils.isEmpty(this.a)) {
        this.b = (a(4, 1200000L, 2573741824L, 17) ^ true);
      }
    }
    else
    {
      this.b = (a(4, 1200000L, 2573741824L, 17) ^ true);
    }
    c(paramJSONObject);
  }
  
  public boolean a(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    int i1 = DeviceInfoUtil.d();
    StringBuilder localStringBuilder;
    if (i1 < paramInt2)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSupportOfDevice error OSversion: ");
      localStringBuilder.append(i1);
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
    long l1 = VcSystemInfo.getMaxCpuFreq();
    if (l1 < paramLong1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSupportOfDevice error cpuFrequency: ");
      localStringBuilder.append(l1);
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
    if (this.e)
    {
      localObject = this.l;
      paramInt = 1;
    }
    else
    {
      localObject = this.l;
      paramInt = 0;
    }
    Object localObject = (Size)((Map)localObject).get(Integer.valueOf(paramInt));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDpcCompressResolution inBlackPhone = ");
      localStringBuilder.append(this.e);
      localStringBuilder.append(" dpcCompressSize=");
      localStringBuilder.append(localObject);
      QLog.d("DovSVParamManager", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public Size b(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    return new Size(localDisplayMetrics.heightPixels, localDisplayMetrics.widthPixels);
  }
  
  public void b()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(f());
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
  
  public void b(JSONObject paramJSONObject)
  {
    try
    {
      this.n = paramJSONObject.optInt("samSungCameraSwitch", 1);
      if (QLog.isColorLevel())
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("parseJsonSamSungSwitch parseJsonSamSungSwitch:");
        paramJSONObject.append(this.n);
        QLog.d("DovSVParamManager", 2, paramJSONObject.toString());
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public float c(int paramInt)
  {
    return 1.0F;
  }
  
  public boolean c()
  {
    return this.d;
  }
  
  public int d(int paramInt)
  {
    return 4000;
  }
  
  public boolean d()
  {
    return this.n == 1;
  }
  
  public boolean e()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.util.DovSVParamManager
 * JD-Core Version:    0.7.0.1
 */