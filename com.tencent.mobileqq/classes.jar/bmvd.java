import com.tencent.biz.qqcircle.beans.QCircleFakeFeed;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;

public class bmvd
  implements aaav<FeedCloudRead.StGetFeedDetailRsp>
{
  public bmvd(QzoneIPCModule paramQzoneIPCModule, QCircleFakeFeed paramQCircleFakeFeed, bmvg parambmvg, int paramInt) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedDetailRsp paramStGetFeedDetailRsp)
  {
    QLog.d("[QzoneIPCModule_upload2]QCircle", 1, "fetch real feed success:" + paramBoolean + "  retCode code:" + paramLong);
    if ((paramBoolean) && (paramLong == 0L) && (paramStGetFeedDetailRsp.feed != null))
    {
      aaak.a().a(new QCircleFeedEvent(this.jdField_a_of_type_ComTencentBizQqcircleBeansQCircleFakeFeed, 2));
      QzoneIPCModule.a(this.jdField_a_of_type_CooperationQzoneQzoneIPCModule, this.jdField_a_of_type_Bmvg);
    }
    do
    {
      return;
      QLog.d("QzoneIPCModule", 1, "start retry retryCount:" + this.jdField_a_of_type_Int);
    } while (this.jdField_a_of_type_CooperationQzoneQzoneIPCModule.a(this.jdField_a_of_type_ComTencentBizQqcircleBeansQCircleFakeFeed, this.jdField_a_of_type_Int, this.jdField_a_of_type_Bmvg));
    QzoneIPCModule.a(this.jdField_a_of_type_CooperationQzoneQzoneIPCModule, this.jdField_a_of_type_Bmvg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmvd
 * JD-Core Version:    0.7.0.1
 */