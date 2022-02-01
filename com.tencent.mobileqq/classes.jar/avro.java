import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.CountDownLatch;

class avro
  implements avuh
{
  avro(avrm paramavrm, File paramFile, Exception[] paramArrayOfException, long paramLong, CountDownLatch paramCountDownLatch) {}
  
  public void a()
  {
    QLog.d("shadow::CdnPmUpdater", 1, " download cdn success");
    if (!avrm.a(this.jdField_a_of_type_Avrm).renameTo(this.jdField_a_of_type_JavaIoFile)) {
      this.jdField_a_of_type_ArrayOfJavaLangException[0] = new RuntimeException(anvx.a(2131700966) + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
    }
    if (avrm.b(this.jdField_a_of_type_Avrm)) {}
    for (String str = "33669797";; str = "33669802")
    {
      avue.b(str);
      avrm.a(this.jdField_a_of_type_Avrm).opType("onDownloadComplete").opResult((int)(System.currentTimeMillis() - this.jdField_a_of_type_Long)).report();
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
    if (avrm.b(this.jdField_a_of_type_Avrm)) {}
    for (paramString = "33669798";; paramString = "33669803")
    {
      avue.b(paramString);
      avrm.a(this.jdField_a_of_type_Avrm).opType("onDownloadFailed").opResult((int)(System.currentTimeMillis() - this.jdField_a_of_type_Long)).report();
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avro
 * JD-Core Version:    0.7.0.1
 */