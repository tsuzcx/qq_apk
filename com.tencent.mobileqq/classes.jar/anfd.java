import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class anfd
  extends bhyn
{
  anfd(String paramString, File paramFile, anfj paramanfj) {}
  
  public void onDone(bhyo parambhyo)
  {
    super.onDone(parambhyo);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData onDone url" + this.jdField_a_of_type_JavaLangString + " task.getStatus():" + parambhyo.a());
    }
    if (3 == parambhyo.a()) {
      if (!this.jdField_a_of_type_JavaIoFile.exists()) {}
    }
    while (this.jdField_a_of_type_Anfj == null)
    {
      do
      {
        try
        {
          nwp.a(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
          if (this.jdField_a_of_type_Anfj != null) {
            this.jdField_a_of_type_Anfj.onDownloadFinish(true, 0);
          }
          return;
        }
        catch (Exception parambhyo)
        {
          do
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            if (QLog.isColorLevel()) {
              QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData unZipFile file error  error->" + parambhyo.getMessage());
            }
          } while (this.jdField_a_of_type_Anfj == null);
          this.jdField_a_of_type_Anfj.onDownloadFinish(false, anex.a);
          return;
        }
        catch (OutOfMemoryError parambhyo)
        {
          do
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            if (QLog.isColorLevel()) {
              QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData unZipFile file error resType->" + parambhyo.getMessage());
            }
          } while (this.jdField_a_of_type_Anfj == null);
          this.jdField_a_of_type_Anfj.onDownloadFinish(false, anex.a);
          return;
        }
      } while (this.jdField_a_of_type_Anfj == null);
      this.jdField_a_of_type_Anfj.onDownloadFinish(false, anex.b);
      return;
    }
    this.jdField_a_of_type_Anfj.onDownloadFinish(false, anex.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anfd
 * JD-Core Version:    0.7.0.1
 */