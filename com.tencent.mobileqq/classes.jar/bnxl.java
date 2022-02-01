import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.av.video.effect.lowlight.LowLightTools;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.data.CaptureRedDotConfig;
import java.io.File;
import java.io.FileOutputStream;

public class bnxl
{
  public static int a;
  public static Object a;
  public static final String a;
  private static int b;
  public static final String b;
  private static int c;
  public static String c;
  private static int d;
  public static String d;
  private static final String e;
  private static final String f;
  public CaptureRedDotConfig a;
  
  static
  {
    jdField_a_of_type_JavaLangString = aktw.jdField_d_of_type_JavaLangString + "pddata/prd/dov_capture_qsvf" + File.separator;
    jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "capture_res" + File.separator;
    e = aktw.jdField_d_of_type_JavaLangString + "qav" + File.separator + "beauty" + File.separator;
    f = e + "SKINCOLOR" + File.separator;
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_c_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "lowlight";
    jdField_d_of_type_JavaLangString = jdField_c_of_type_JavaLangString + File.separator + "LowLight.png";
    jdField_b_of_type_Int = 2;
    jdField_c_of_type_Int = 1;
    jdField_d_of_type_Int = -1;
  }
  
  private void a()
  {
    File localFile = new File(jdField_d_of_type_JavaLangString);
    if (localFile.exists()) {
      localFile.delete();
    }
    for (;;)
    {
      Object localObject = LowLightTools.getLowLightImage(3.0F, 0.88F, 0.96F, 1.22F, false);
      try
      {
        FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
        ((Bitmap)localObject).compress(Bitmap.CompressFormat.PNG, 100, localFileOutputStream);
        localFileOutputStream.flush();
        localFileOutputStream.close();
        if (!localFile.exists())
        {
          jdField_a_of_type_Int = jdField_d_of_type_Int;
          return;
          localObject = localFile.getParentFile();
          if (((File)localObject).exists()) {
            continue;
          }
          ((File)localObject).mkdirs();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.w("CaptureVideoFilterManager", 2, "LowLightTools saveBitmap:" + localException);
        }
        jdField_a_of_type_Int = jdField_b_of_type_Int;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig != null) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.update))
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.update = false;
        CaptureRedDotConfig.saveRedDotConfig(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig, jdField_a_of_type_JavaLangString, "_Filter");
      }
      return;
    }
    CaptureRedDotConfig.saveRedDotConfig(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig, jdField_a_of_type_JavaLangString, "_Filter");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnxl
 * JD-Core Version:    0.7.0.1
 */