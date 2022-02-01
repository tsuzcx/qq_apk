import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class amdv
  extends bgod
{
  amdv(String paramString, File paramFile, ameb paramameb) {}
  
  public void onDone(bgoe parambgoe)
  {
    super.onDone(parambgoe);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData onDone url" + this.jdField_a_of_type_JavaLangString + " task.getStatus():" + parambgoe.a());
    }
    if (3 == parambgoe.a()) {
      if (!this.jdField_a_of_type_JavaIoFile.exists()) {}
    }
    while (this.jdField_a_of_type_Ameb == null)
    {
      do
      {
        try
        {
          npo.a(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
          if (this.jdField_a_of_type_Ameb != null) {
            this.jdField_a_of_type_Ameb.a(true, 0);
          }
          return;
        }
        catch (Exception parambgoe)
        {
          for (;;)
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            if (QLog.isColorLevel()) {
              QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData unZipFile file error  error->" + parambgoe.getMessage());
            }
          }
        }
        catch (OutOfMemoryError parambgoe)
        {
          for (;;)
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            if (QLog.isColorLevel()) {
              QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData unZipFile file error resType->" + parambgoe.getMessage());
            }
          }
        }
      } while (this.jdField_a_of_type_Ameb == null);
      this.jdField_a_of_type_Ameb.a(false, 0);
      return;
    }
    this.jdField_a_of_type_Ameb.a(false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amdv
 * JD-Core Version:    0.7.0.1
 */