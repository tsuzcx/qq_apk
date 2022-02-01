import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class anjb
  extends biht
{
  anjb(String paramString, File paramFile, anjh paramanjh) {}
  
  public void onDone(bihu parambihu)
  {
    super.onDone(parambihu);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData onDone url" + this.jdField_a_of_type_JavaLangString + " task.getStatus():" + parambihu.a());
    }
    if (3 == parambihu.a()) {
      if (!this.jdField_a_of_type_JavaIoFile.exists()) {}
    }
    while (this.jdField_a_of_type_Anjh == null)
    {
      do
      {
        try
        {
          nof.a(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
          if (this.jdField_a_of_type_Anjh != null) {
            this.jdField_a_of_type_Anjh.a(true, 0);
          }
          return;
        }
        catch (Exception parambihu)
        {
          for (;;)
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            if (QLog.isColorLevel()) {
              QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData unZipFile file error  error->" + parambihu.getMessage());
            }
          }
        }
        catch (OutOfMemoryError parambihu)
        {
          for (;;)
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            if (QLog.isColorLevel()) {
              QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData unZipFile file error resType->" + parambihu.getMessage());
            }
          }
        }
      } while (this.jdField_a_of_type_Anjh == null);
      this.jdField_a_of_type_Anjh.a(false, 0);
      return;
    }
    this.jdField_a_of_type_Anjh.a(false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anjb
 * JD-Core Version:    0.7.0.1
 */