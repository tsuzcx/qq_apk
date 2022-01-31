import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bbzd
  implements nbt
{
  bbzd(bbzb parambbzb, long paramLong) {}
  
  public void loaded(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLibraryLoader", 2, "transToLocalUrl loadMode:" + paramInt + ", time:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("SoLibraryLoader", 4, "transToLocalUrl transUrl:" + paramString);
    }
    paramString = ncb.a(bbzb.a(this.jdField_a_of_type_Bbzb)) + bbzb.a(this.jdField_a_of_type_Bbzb) + File.separator + bbzb.b(this.jdField_a_of_type_Bbzb);
    if (!new File(paramString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e("SoLibraryLoader", 2, "file not exist! path = " + paramString);
      }
      return;
    }
    bdcs.d(paramString, bbzb.a(this.jdField_a_of_type_Bbzb).getFilesDir().getAbsolutePath() + File.separator + bbzb.b(this.jdField_a_of_type_Bbzb));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbzd
 * JD-Core Version:    0.7.0.1
 */