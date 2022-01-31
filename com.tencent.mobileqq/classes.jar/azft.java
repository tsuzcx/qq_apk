import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class azft
{
  public static void a(int paramInt1, int paramInt2, long paramLong)
  {
    String str = "actCapturePhotoCamera";
    if (paramInt1 == 2) {
      str = "actCapturePhotoCamera2";
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_type", paramInt1 + "");
    localHashMap.put("param_cost", paramLong + "");
    localHashMap.put("param_size", paramInt2 + "");
    localHashMap.put("param_version", Build.VERSION.SDK_INT + "");
    localHashMap.put("param_deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
    azri.a(BaseApplication.getContext()).a("", str, true, paramLong, 0L, localHashMap, "");
  }
  
  public static void a(boolean paramBoolean1, String paramString, int paramInt1, int paramInt2, boolean paramBoolean2, long paramLong, int paramInt3)
  {
    label393:
    for (;;)
    {
      int j;
      try
      {
        i = Build.VERSION.SDK_INT;
        if (i < 23) {
          return;
        }
      }
      finally {}
      try
      {
        localObject1 = BaseApplicationImpl.getContext().getSharedPreferences("camera2_support_sp", 0);
        j = ((SharedPreferences)localObject1).getInt("camera2_key_crash_count", 0);
        if (j < 3) {
          break label393;
        }
        i = -3;
        QLog.d("Camera2Support", 1, "reportCamera2DeviceSupport, crash count: " + j);
      }
      catch (Exception localException)
      {
        QLog.e("Camera2Support", 1, "reportCamera2DeviceSupport exception, ", localException);
        i = -4;
        continue;
      }
      catch (VerifyError localVerifyError)
      {
        QLog.e("Camera2Support", 1, "reportCamera2DeviceSupport error, ", localVerifyError);
        i = -4;
        continue;
        paramString = "0";
        continue;
        do
        {
          paramInt1 = 1;
          break;
          paramInt1 = 0;
          if ((paramBoolean2) || (paramInt2 != 2)) {
            break label370;
          }
        } while (paramInt1 == 0);
        paramInt1 = 2;
        continue;
        String str = "0";
        continue;
      }
      Object localObject1 = new HashMap();
      ((HashMap)localObject1).put("camera2SupportLevel", String.valueOf(i));
      ((HashMap)localObject1).put("osVersion", Build.VERSION.SDK_INT + "");
      ((HashMap)localObject1).put("deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
      Object localObject2 = azri.a(BaseApplication.getContext());
      ((azri)localObject2).a("", "Camera2Support", true, 0L, 0L, (HashMap)localObject1, "");
      if (!CameraCaptureView.a.b) {
        break label513;
      }
      HashMap localHashMap = new HashMap();
      if (!paramBoolean1) {
        break label534;
      }
      localObject1 = "1";
      localHashMap.put("previewState", localObject1);
      if (paramString != null) {
        localHashMap.put("ErrorMsg", paramString);
      }
      localHashMap.put("frameCount", String.valueOf(paramInt1));
      if (paramInt1 <= 0) {
        break;
      }
      paramString = "1";
      localHashMap.put("frameState", paramString);
      localHashMap.put("selectCamera", String.valueOf(paramInt2));
      localHashMap.put("osVersion", Build.VERSION.SDK_INT + "");
      localHashMap.put("deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
      ((azri)localObject2).a("", "Camera2RunState", true, 0L, 0L, localHashMap, "");
      paramInt1 = 1;
      break label515;
      b(paramInt1, paramInt3, paramLong);
      label370:
      if (QLog.isColorLevel())
      {
        QLog.d("Camera2Support", 2, "reportCamera2DeviceSupport completed");
        continue;
        localObject2 = ((SharedPreferences)localObject1).edit();
        if (((SharedPreferences)localObject1).contains("camera2_key_pre_report")) {
          ((SharedPreferences.Editor)localObject2).putInt("camera2_key_crash_count", j + 1);
        }
        i = Camera2Control.a();
        ((SharedPreferences.Editor)localObject2).remove("camera2_key_pre_report");
        ((SharedPreferences.Editor)localObject2).remove("camera2_key_crash_count");
        ((SharedPreferences.Editor)localObject2).commit();
      }
    }
  }
  
  public static void b(int paramInt1, int paramInt2, long paramLong)
  {
    if ((paramInt2 > 0) && (paramLong > 0L))
    {
      String str = "actCapturePhotoCameraFps";
      if (paramInt1 == 2) {
        str = "actCapturePhotoCamera2Fps";
      }
      float f = paramInt2 * 1000.0F / (float)paramLong;
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_type", paramInt1 + "");
      localHashMap.put("param_frame", paramInt2 + "");
      localHashMap.put("param_time", paramLong + "");
      localHashMap.put("param_fps", (int)f + "");
      localHashMap.put("param_version", Build.VERSION.SDK_INT + "");
      localHashMap.put("param_deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
      azri.a(BaseApplication.getContext()).a("", str, true, (int)f, 0L, localHashMap, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azft
 * JD-Core Version:    0.7.0.1
 */