import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudWrite.StDoFollowRsp;
import java.util.concurrent.CountDownLatch;

class bjbm
  implements yvn<FeedCloudWrite.StDoFollowRsp>
{
  bjbm(bjbk parambjbk, boolean[] paramArrayOfBoolean, CountDownLatch paramCountDownLatch) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoFollowRsp paramStDoFollowRsp)
  {
    QLog.i("QzoneIPCModule", 1, "flow qq circle resp " + paramBoolean + " " + paramLong + " " + paramString);
    this.jdField_a_of_type_ArrayOfBoolean[0] = paramBoolean;
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjbm
 * JD-Core Version:    0.7.0.1
 */