import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.CountDownLatch;

class baci
  implements babu
{
  baci(bacg parambacg, File paramFile, Exception[] paramArrayOfException, CountDownLatch paramCountDownLatch) {}
  
  public void a()
  {
    QLog.d("studyroom.CdnPmUpdater", 1, " download cdn success");
    if (!bacg.a(this.jdField_a_of_type_Bacg).renameTo(this.jdField_a_of_type_JavaIoFile)) {
      this.jdField_a_of_type_ArrayOfJavaLangException[0] = new RuntimeException(alud.a(2131701853) + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
    }
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangException[0] = new Exception("下载失败 retcode:" + paramInt1 + " httpCode:" + paramInt2 + " err:" + paramString);
    if (QLog.isColorLevel()) {
      QLog.d("studyroom.CdnPmUpdater", 2, " onDownloadFailed ");
    }
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baci
 * JD-Core Version:    0.7.0.1
 */