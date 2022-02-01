import android.content.Context;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bfuf
  implements nux
{
  bfuf(bfud parambfud, long paramLong) {}
  
  public void loaded(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLibraryLoader", 2, "transToLocalUrl loadMode:" + paramInt + ", time:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("SoLibraryLoader", 4, "transToLocalUrl transUrl:" + paramString);
    }
    paramString = nvf.a(bfud.a(this.jdField_a_of_type_Bfud)) + bfud.a(this.jdField_a_of_type_Bfud) + File.separator + bfud.b(this.jdField_a_of_type_Bfud);
    if (!new File(paramString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e("SoLibraryLoader", 2, "file not exist! path = " + paramString);
      }
      return;
    }
    FileUtils.copyFile(paramString, bfud.a(this.jdField_a_of_type_Bfud).getFilesDir().getAbsolutePath() + File.separator + bfud.b(this.jdField_a_of_type_Bfud));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfuf
 * JD-Core Version:    0.7.0.1
 */