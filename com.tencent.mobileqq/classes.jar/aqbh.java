import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.camera.adapter.CameraWrapper.1;
import com.tencent.qphone.base.util.QLog;

@TargetApi(9)
public class aqbh
{
  private static int jdField_a_of_type_Int = -1;
  private static aqbh jdField_a_of_type_Aqbh;
  private volatile boolean jdField_a_of_type_Boolean;
  
  private aqbh()
  {
    a(false);
  }
  
  public static aqbh a()
  {
    if (jdField_a_of_type_Aqbh == null) {}
    try
    {
      if (jdField_a_of_type_Aqbh == null) {
        jdField_a_of_type_Aqbh = new aqbh();
      }
      return jdField_a_of_type_Aqbh;
    }
    finally {}
  }
  
  public int a()
  {
    return 21;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    QLog.d("Q.camera.CameraWrapper", 2, "[getCameraOrientation] cameraId = " + paramInt1 + ", cameraOrientation = " + paramInt2);
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    Camera.getCameraInfo(paramInt1, localCameraInfo);
    paramInt1 = localCameraInfo.orientation;
    aqbg.a().d();
    if (localCameraInfo.facing == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.camera.CameraWrapper", 2, "is FRONT camera, orientation = " + paramInt1);
      }
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.camera.CameraWrapper", 2, "return orientation = " + paramInt1);
      }
      return paramInt1;
      if (aqbg.a().jdField_b_of_type_Int != -1)
      {
        paramInt1 = aqbg.a().jdField_b_of_type_Int;
        QLog.d("Q.camera.CameraWrapper", 2, "reset FRONT Cam frontCamRotate0 = " + paramInt1);
        continue;
        if (aqbg.a().jdField_c_of_type_Int != -1)
        {
          paramInt1 = aqbg.a().jdField_c_of_type_Int;
          QLog.d("Q.camera.CameraWrapper", 2, "reset FRONT Cam frontCamRotate90 = " + paramInt1);
          continue;
          if (aqbg.a().d != -1)
          {
            paramInt1 = aqbg.a().d;
            QLog.d("Q.camera.CameraWrapper", 2, "reset FRONT Cam frontCamRotate180 = " + paramInt1);
            continue;
            if (aqbg.a().e != -1)
            {
              paramInt1 = aqbg.a().e;
              QLog.d("Q.camera.CameraWrapper", 2, "reset FRONT Cam frontCamRotate270 = " + paramInt1);
              continue;
              if (QLog.isColorLevel()) {
                QLog.d("Q.camera.CameraWrapper", 2, "is BACK camera, orientation = " + paramInt1);
              }
              switch (paramInt2)
              {
              default: 
                break;
              case -1: 
              case 0: 
                if (aqbg.a().f != -1)
                {
                  paramInt1 = aqbg.a().f;
                  QLog.d("Q.camera.CameraWrapper", 2, "reset BACK Cam backCamRotate0 = " + paramInt1);
                }
                break;
              case 90: 
                if (aqbg.a().jdField_g_of_type_Int != -1)
                {
                  paramInt1 = aqbg.a().jdField_g_of_type_Int;
                  QLog.d("Q.camera.CameraWrapper", 2, "reset BACK Cam backCamRotate90 = " + paramInt1);
                }
                break;
              case 180: 
                if (aqbg.a().h != -1)
                {
                  paramInt1 = aqbg.a().h;
                  QLog.d("Q.camera.CameraWrapper", 2, "reset BACK Cam backCamRotate180 = " + paramInt1);
                }
                break;
              case 270: 
                if (aqbg.a().i != -1)
                {
                  paramInt1 = aqbg.a().i;
                  QLog.d("Q.camera.CameraWrapper", 2, "reset BACK Cam backCamRotate270 = " + paramInt1);
                }
                break;
              }
            }
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    aqbg.a().a(aqbj.a(BaseApplicationImpl.getContext()), paramBoolean);
  }
  
  public boolean a()
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraWrapper", 2, "[isSysVersionValid] ENTER sysCamerOn=" + aqbg.a().jdField_b_of_type_Boolean + " sysMinVersion=" + aqbg.a().a + " sysMaxVersion=" + aqbg.a().jdField_b_of_type_JavaLangString + " currVersion=" + Build.VERSION.RELEASE);
    }
    aqbg.a().a();
    boolean bool1 = bool3;
    if (aqbg.a().jdField_b_of_type_Boolean) {}
    try
    {
      String[] arrayOfString2 = aqbg.a().a.split("\\.");
      String[] arrayOfString3 = aqbg.a().jdField_b_of_type_JavaLangString.split("\\.");
      String[] arrayOfString1;
      int j;
      int i;
      if (Build.VERSION.RELEASE != null)
      {
        arrayOfString1 = Build.VERSION.RELEASE.split("\\.");
        bool1 = bool3;
        if (arrayOfString1 != null)
        {
          bool1 = bool3;
          if (arrayOfString2.length == 3)
          {
            bool1 = bool3;
            if (arrayOfString3.length == 3)
            {
              j = Integer.parseInt(arrayOfString2[0]);
              int i3 = Integer.parseInt(arrayOfString2[1]);
              int i4 = Integer.parseInt(arrayOfString2[2]);
              int k = Integer.parseInt(arrayOfString1[0]);
              int m = Integer.parseInt(arrayOfString1[1]);
              if (arrayOfString1.length != 3) {
                break label356;
              }
              i = Integer.parseInt(arrayOfString1[2]);
              label231:
              int n = Integer.parseInt(arrayOfString3[0]);
              int i1 = Integer.parseInt(arrayOfString3[1]);
              int i2 = Integer.parseInt(arrayOfString3[2]);
              if ((k <= j) && ((k != j) || (m <= i3)) && ((j != k) || (i3 != m) || (i < i4))) {
                break label361;
              }
              j = 1;
              label295:
              if ((k >= n) && ((k != n) || (m >= i1)) && ((n != k) || (i1 != m) || (i > i2))) {
                break label366;
              }
              i = 1;
              label335:
              if ((j == 0) || (i == 0)) {
                break label371;
              }
            }
          }
        }
      }
      label356:
      label361:
      label366:
      label371:
      for (bool1 = bool2;; bool1 = false)
      {
        return bool1;
        arrayOfString1 = null;
        break;
        i = 0;
        break label231;
        j = 0;
        break label295;
        i = 0;
        break label335;
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public int b()
  {
    int j;
    if (jdField_a_of_type_Int != -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.camera.CameraWrapper", 2, "[getNumberOfCameras] sNumberOfCameras = " + jdField_a_of_type_Int);
      }
      j = jdField_a_of_type_Int;
      return j;
    }
    SharedPreferences localSharedPreferences = aqbj.b(BaseApplicationImpl.getContext());
    int i;
    if (localSharedPreferences.contains("localsp_camera_num"))
    {
      j = localSharedPreferences.getInt("localsp_camera_num", 0);
      i = j;
      if (j < 1)
      {
        i = Camera.getNumberOfCameras();
        bctj.e("event_camera_num_less_two");
      }
    }
    for (;;)
    {
      jdField_a_of_type_Int = i;
      j = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.camera.CameraWrapper", 2, new Object[] { "getNumberOfCameras, return ", Integer.valueOf(jdField_a_of_type_Int) });
      return i;
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        ThreadManager.excute(new CameraWrapper.1(this, localSharedPreferences), 64, null, false);
      }
      i = 2;
    }
  }
  
  public boolean b()
  {
    aqbg.a().e();
    return aqbg.a().jdField_g_of_type_Boolean;
  }
  
  public boolean c()
  {
    aqbg.a().b();
    return aqbg.a().jdField_c_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqbh
 * JD-Core Version:    0.7.0.1
 */