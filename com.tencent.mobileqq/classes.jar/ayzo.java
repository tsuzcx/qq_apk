import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ayzo
  implements mod
{
  ayzo(ayzm paramayzm, long paramLong) {}
  
  public void loaded(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLibraryLoader", 2, "transToLocalUrl loadMode:" + paramInt + ", time:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("SoLibraryLoader", 4, "transToLocalUrl transUrl:" + paramString);
    }
    paramString = mol.a(ayzm.a(this.jdField_a_of_type_Ayzm)) + ayzm.a(this.jdField_a_of_type_Ayzm) + File.separator + ayzm.b(this.jdField_a_of_type_Ayzm);
    if (!new File(paramString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e("SoLibraryLoader", 2, "file not exist! path = " + paramString);
      }
      return;
    }
    bace.d(paramString, ayzm.a(this.jdField_a_of_type_Ayzm).getFilesDir().getAbsolutePath() + File.separator + ayzm.b(this.jdField_a_of_type_Ayzm));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayzo
 * JD-Core Version:    0.7.0.1
 */