import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bfea
  implements nkm
{
  bfea(bfdy parambfdy, long paramLong) {}
  
  public void loaded(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLibraryLoader", 2, "transToLocalUrl loadMode:" + paramInt + ", time:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("SoLibraryLoader", 4, "transToLocalUrl transUrl:" + paramString);
    }
    paramString = nku.a(bfdy.a(this.jdField_a_of_type_Bfdy)) + bfdy.a(this.jdField_a_of_type_Bfdy) + File.separator + bfdy.b(this.jdField_a_of_type_Bfdy);
    if (!new File(paramString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e("SoLibraryLoader", 2, "file not exist! path = " + paramString);
      }
      return;
    }
    bgmg.d(paramString, bfdy.a(this.jdField_a_of_type_Bfdy).getFilesDir().getAbsolutePath() + File.separator + bfdy.b(this.jdField_a_of_type_Bfdy));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfea
 * JD-Core Version:    0.7.0.1
 */