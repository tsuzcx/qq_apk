import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bcdm
  implements nbt
{
  bcdm(bcdk parambcdk, long paramLong) {}
  
  public void loaded(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLibraryLoader", 2, "transToLocalUrl loadMode:" + paramInt + ", time:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("SoLibraryLoader", 4, "transToLocalUrl transUrl:" + paramString);
    }
    paramString = ncb.a(bcdk.a(this.jdField_a_of_type_Bcdk)) + bcdk.a(this.jdField_a_of_type_Bcdk) + File.separator + bcdk.b(this.jdField_a_of_type_Bcdk);
    if (!new File(paramString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e("SoLibraryLoader", 2, "file not exist! path = " + paramString);
      }
      return;
    }
    bdhb.d(paramString, bcdk.a(this.jdField_a_of_type_Bcdk).getFilesDir().getAbsolutePath() + File.separator + bcdk.b(this.jdField_a_of_type_Bcdk));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcdm
 * JD-Core Version:    0.7.0.1
 */