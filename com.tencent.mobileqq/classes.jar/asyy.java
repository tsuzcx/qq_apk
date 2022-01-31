import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.CountDownLatch;

class asyy
  implements atcr
{
  asyy(asyw paramasyw, File paramFile, Exception[] paramArrayOfException, long paramLong, CountDownLatch paramCountDownLatch) {}
  
  public void a()
  {
    QLog.d("shadow::CdnPmUpdater", 1, " download cdn success");
    if (!asyw.a(this.jdField_a_of_type_Asyw).renameTo(this.jdField_a_of_type_JavaIoFile)) {
      this.jdField_a_of_type_ArrayOfJavaLangException[0] = new RuntimeException(alud.a(2131701853) + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
    }
    if (asyw.b(this.jdField_a_of_type_Asyw)) {}
    for (String str = "33669797";; str = "33669802")
    {
      atbh.b(str);
      asyw.a(this.jdField_a_of_type_Asyw).opType("onDownloadComplete").opResult((int)(System.currentTimeMillis() - this.jdField_a_of_type_Long)).report();
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangException[0] = new Exception("下载失败 retcode:" + paramInt1 + " httpCode:" + paramInt2 + " err:" + paramString);
    if (QLog.isColorLevel()) {
      QLog.d("shadow::CdnPmUpdater", 2, " onDownloadFailed ");
    }
    if (asyw.b(this.jdField_a_of_type_Asyw)) {}
    for (paramString = "33669798";; paramString = "33669803")
    {
      atbh.b(paramString);
      asyw.a(this.jdField_a_of_type_Asyw).opType("onDownloadFailed").opResult((int)(System.currentTimeMillis() - this.jdField_a_of_type_Long)).report();
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asyy
 * JD-Core Version:    0.7.0.1
 */