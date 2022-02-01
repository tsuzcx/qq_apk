import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.CountDownLatch;

class avgq
  implements avje
{
  avgq(avgo paramavgo, File paramFile, Exception[] paramArrayOfException, long paramLong, CountDownLatch paramCountDownLatch) {}
  
  public void a()
  {
    QLog.d("shadow::CdnPmUpdater", 1, " download cdn success");
    if (!avgo.a(this.jdField_a_of_type_Avgo).renameTo(this.jdField_a_of_type_JavaIoFile)) {
      this.jdField_a_of_type_ArrayOfJavaLangException[0] = new RuntimeException(anni.a(2131700273) + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
    }
    if (avgo.b(this.jdField_a_of_type_Avgo)) {}
    for (String str = "33669797";; str = "33669802")
    {
      avjb.b(str);
      avgo.a(this.jdField_a_of_type_Avgo).opType("onDownloadComplete").opResult((int)(System.currentTimeMillis() - this.jdField_a_of_type_Long)).report();
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangException[0] = new Exception("下载失败 retcode:" + paramInt1 + " httpCode:" + paramInt2 + " err:" + paramString);
    if (QLog.isColorLevel()) {
      QLog.d("shadow::CdnPmUpdater", 2, " onDownloadFailed retCode =  " + paramInt1);
    }
    if (avgo.b(this.jdField_a_of_type_Avgo)) {}
    for (paramString = "33669798";; paramString = "33669803")
    {
      avjb.b(paramString);
      avgo.a(this.jdField_a_of_type_Avgo).opType("onDownloadFailed").opResult((int)(System.currentTimeMillis() - this.jdField_a_of_type_Long)).report();
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avgq
 * JD-Core Version:    0.7.0.1
 */