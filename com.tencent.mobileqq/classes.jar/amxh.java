import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class amxh
  extends bhhe
{
  amxh(String paramString, File paramFile, amxn paramamxn) {}
  
  public void onDone(bhhf parambhhf)
  {
    super.onDone(parambhhf);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData onDone url" + this.jdField_a_of_type_JavaLangString + " task.getStatus():" + parambhhf.a());
    }
    if (3 == parambhhf.a()) {
      if (!this.jdField_a_of_type_JavaIoFile.exists()) {}
    }
    while (this.jdField_a_of_type_Amxn == null)
    {
      do
      {
        try
        {
          nmk.a(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
          if (this.jdField_a_of_type_Amxn != null) {
            this.jdField_a_of_type_Amxn.a(true, 0);
          }
          return;
        }
        catch (Exception parambhhf)
        {
          for (;;)
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            if (QLog.isColorLevel()) {
              QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData unZipFile file error  error->" + parambhhf.getMessage());
            }
          }
        }
        catch (OutOfMemoryError parambhhf)
        {
          for (;;)
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            if (QLog.isColorLevel()) {
              QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData unZipFile file error resType->" + parambhhf.getMessage());
            }
          }
        }
      } while (this.jdField_a_of_type_Amxn == null);
      this.jdField_a_of_type_Amxn.a(false, 0);
      return;
    }
    this.jdField_a_of_type_Amxn.a(false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amxh
 * JD-Core Version:    0.7.0.1
 */