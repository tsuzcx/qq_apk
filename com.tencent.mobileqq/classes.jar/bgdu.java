import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bgdu
  implements nmh
{
  bgdu(bgds parambgds, long paramLong) {}
  
  public void loaded(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLibraryLoader", 2, "transToLocalUrl loadMode:" + paramInt + ", time:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("SoLibraryLoader", 4, "transToLocalUrl transUrl:" + paramString);
    }
    paramString = nmp.a(bgds.a(this.jdField_a_of_type_Bgds)) + bgds.a(this.jdField_a_of_type_Bgds) + File.separator + bgds.b(this.jdField_a_of_type_Bgds);
    if (!new File(paramString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e("SoLibraryLoader", 2, "file not exist! path = " + paramString);
      }
      return;
    }
    bhmi.d(paramString, bgds.a(this.jdField_a_of_type_Bgds).getFilesDir().getAbsolutePath() + File.separator + bgds.b(this.jdField_a_of_type_Bgds));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgdu
 * JD-Core Version:    0.7.0.1
 */