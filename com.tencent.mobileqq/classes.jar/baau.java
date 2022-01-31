import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class baau
  implements myz
{
  baau(baas parambaas, long paramLong) {}
  
  public void loaded(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLibraryLoader", 2, "transToLocalUrl loadMode:" + paramInt + ", time:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("SoLibraryLoader", 4, "transToLocalUrl transUrl:" + paramString);
    }
    paramString = mzh.a(baas.a(this.jdField_a_of_type_Baas)) + baas.a(this.jdField_a_of_type_Baas) + File.separator + baas.b(this.jdField_a_of_type_Baas);
    if (!new File(paramString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e("SoLibraryLoader", 2, "file not exist! path = " + paramString);
      }
      return;
    }
    bbdx.d(paramString, baas.a(this.jdField_a_of_type_Baas).getFilesDir().getAbsolutePath() + File.separator + baas.b(this.jdField_a_of_type_Baas));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baau
 * JD-Core Version:    0.7.0.1
 */