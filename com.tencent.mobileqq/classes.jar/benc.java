import android.content.Context;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class benc
  implements nnw
{
  benc(bena parambena, long paramLong) {}
  
  public void loaded(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLibraryLoader", 2, "transToLocalUrl loadMode:" + paramInt + ", time:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("SoLibraryLoader", 4, "transToLocalUrl transUrl:" + paramString);
    }
    paramString = noe.a(bena.a(this.jdField_a_of_type_Bena)) + bena.a(this.jdField_a_of_type_Bena) + File.separator + bena.b(this.jdField_a_of_type_Bena);
    if (!new File(paramString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e("SoLibraryLoader", 2, "file not exist! path = " + paramString);
      }
      return;
    }
    FileUtils.copyFile(paramString, bena.a(this.jdField_a_of_type_Bena).getFilesDir().getAbsolutePath() + File.separator + bena.b(this.jdField_a_of_type_Bena));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     benc
 * JD-Core Version:    0.7.0.1
 */