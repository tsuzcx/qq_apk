import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class amft
{
  private static amft jdField_a_of_type_Amft;
  public int a;
  public String a;
  private final ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public final boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public boolean c;
  public int d;
  public boolean d;
  public int e;
  public boolean e;
  public int f;
  public boolean f;
  public int g;
  public boolean g;
  public int h = -1;
  public int i = -1;
  
  public amft()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
    this.jdField_f_of_type_Int = -1;
    this.jdField_g_of_type_Int = -1;
  }
  
  public static amft a()
  {
    if (jdField_a_of_type_Amft == null) {}
    try
    {
      if (jdField_a_of_type_Amft == null) {
        jdField_a_of_type_Amft = new amft();
      }
      return jdField_a_of_type_Amft;
    }
    finally {}
  }
  
  private void a(SharedPreferences paramSharedPreferences)
  {
    QLog.i("Q.camera.adapter.CameraAttrs", 1, "[loadValueFromPref] + BEGIN");
    this.jdField_b_of_type_Boolean = paramSharedPreferences.getBoolean("sysCameraOn", false);
    this.jdField_a_of_type_JavaLangString = paramSharedPreferences.getString("str_sysMinVersion", "1.0.0");
    this.jdField_b_of_type_JavaLangString = paramSharedPreferences.getString("str_sysMaxVersion", "1000.0.0");
    this.jdField_c_of_type_Boolean = paramSharedPreferences.getBoolean("disableCameraSDK", true);
    this.jdField_d_of_type_Boolean = paramSharedPreferences.getBoolean("readCamNumException", false);
    this.jdField_e_of_type_Boolean = paramSharedPreferences.getBoolean("disableFrontCamera", false);
    this.jdField_f_of_type_Boolean = paramSharedPreferences.getBoolean("beBlurredPreviewAfterTakePic", false);
    this.jdField_b_of_type_Int = paramSharedPreferences.getInt("int_frontCamRotate0", -1);
    this.jdField_c_of_type_Int = paramSharedPreferences.getInt("int_frontCamRotate90", -1);
    this.jdField_d_of_type_Int = paramSharedPreferences.getInt("int_frontCamRotate180", -1);
    this.jdField_e_of_type_Int = paramSharedPreferences.getInt("int_frontCamRotate270", -1);
    this.jdField_f_of_type_Int = paramSharedPreferences.getInt("int_backCamRotate0", -1);
    this.jdField_g_of_type_Int = paramSharedPreferences.getInt("int_backCamRotate90", -1);
    this.h = paramSharedPreferences.getInt("int_backCamRotate180", -1);
    this.i = paramSharedPreferences.getInt("int_backCamRotate270", -1);
    this.jdField_g_of_type_Boolean = paramSharedPreferences.getBoolean("frontCamFlipH", false);
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "[loadValueFromPref] + END");
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.contains("sysCameraOn")) {
      return;
    }
    SharedPreferences localSharedPreferences = amfw.a(BaseApplicationImpl.getContext());
    this.jdField_b_of_type_Boolean = localSharedPreferences.getBoolean("sysCameraOn", false);
    this.jdField_a_of_type_JavaLangString = localSharedPreferences.getString("str_sysMinVersion", "1.0.0");
    this.jdField_b_of_type_JavaLangString = localSharedPreferences.getString("str_sysMaxVersion", "1000.0.0");
    this.jdField_a_of_type_JavaUtilArrayList.add("sysCameraOn");
  }
  
  public void a(SharedPreferences paramSharedPreferences, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.adapter.CameraAttrs", 4, "[loadConfigAndSave] + BEGIN");
    }
    int j = paramSharedPreferences.getInt("qcamera_conf_version", 0);
    if ((j != this.jdField_a_of_type_Int) && (paramBoolean))
    {
      this.jdField_a_of_type_Int = j;
      a(paramSharedPreferences);
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.adapter.CameraAttrs", 4, "[loadConfigAndSave] + END");
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.contains("disableCameraSDK")) {
      return;
    }
    this.jdField_c_of_type_Boolean = amfw.a(BaseApplicationImpl.getContext()).getBoolean("disableCameraSDK", true);
    this.jdField_a_of_type_JavaUtilArrayList.add("disableCameraSDK");
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.contains("readCamNumException")) {
      return;
    }
    SharedPreferences localSharedPreferences = amfw.a(BaseApplicationImpl.getContext());
    this.jdField_d_of_type_Boolean = localSharedPreferences.getBoolean("readCamNumException", false);
    this.jdField_e_of_type_Boolean = localSharedPreferences.getBoolean("disableFrontCamera", false);
    this.jdField_a_of_type_JavaUtilArrayList.add("readCamNumException");
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.contains("int_frontCamRotate0")) {
      return;
    }
    SharedPreferences localSharedPreferences = amfw.a(BaseApplicationImpl.getContext());
    this.jdField_b_of_type_Int = localSharedPreferences.getInt("int_frontCamRotate0", -1);
    this.jdField_c_of_type_Int = localSharedPreferences.getInt("int_frontCamRotate90", -1);
    this.jdField_d_of_type_Int = localSharedPreferences.getInt("int_frontCamRotate180", -1);
    this.jdField_e_of_type_Int = localSharedPreferences.getInt("int_frontCamRotate270", -1);
    this.jdField_f_of_type_Int = localSharedPreferences.getInt("int_backCamRotate0", -1);
    this.jdField_g_of_type_Int = localSharedPreferences.getInt("int_backCamRotate90", -1);
    this.h = localSharedPreferences.getInt("int_backCamRotate180", -1);
    this.i = localSharedPreferences.getInt("int_backCamRotate270", -1);
    this.jdField_a_of_type_JavaUtilArrayList.add("int_frontCamRotate0");
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.contains("frontCamFlipH")) {
      return;
    }
    this.jdField_g_of_type_Boolean = amfw.a(BaseApplicationImpl.getContext()).getBoolean("frontCamFlipH", false);
    this.jdField_a_of_type_JavaUtilArrayList.add("frontCamFlipH");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amft
 * JD-Core Version:    0.7.0.1
 */