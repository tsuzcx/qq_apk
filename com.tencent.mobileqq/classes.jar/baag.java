import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class baag
  implements mzc
{
  baag(baae parambaae, long paramLong) {}
  
  public void loaded(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLibraryLoader", 2, "transToLocalUrl loadMode:" + paramInt + ", time:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("SoLibraryLoader", 4, "transToLocalUrl transUrl:" + paramString);
    }
    paramString = mzk.a(baae.a(this.jdField_a_of_type_Baae)) + baae.a(this.jdField_a_of_type_Baae) + File.separator + baae.b(this.jdField_a_of_type_Baae);
    if (!new File(paramString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e("SoLibraryLoader", 2, "file not exist! path = " + paramString);
      }
      return;
    }
    bbdj.d(paramString, baae.a(this.jdField_a_of_type_Baae).getFilesDir().getAbsolutePath() + File.separator + baae.b(this.jdField_a_of_type_Baae));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baag
 * JD-Core Version:    0.7.0.1
 */