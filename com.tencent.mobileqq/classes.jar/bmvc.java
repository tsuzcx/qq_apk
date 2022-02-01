import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCircleFuelAnimationEvent;
import com.tencent.biz.qqcircle.requests.QCirclePublishFeedRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import feedcloud.FeedCloudWrite.StPublishFeedRsp;

public class bmvc
  implements aaav<FeedCloudWrite.StPublishFeedRsp>
{
  public bmvc(QzoneIPCModule paramQzoneIPCModule, QCirclePublishFeedRequest paramQCirclePublishFeedRequest, String paramString, int paramInt) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StPublishFeedRsp paramStPublishFeedRsp)
  {
    QLog.d("[QzoneIPCModule_upload2]QCircle", 1, "ACTION_QCIRCLE_PULISH_FEED onReceive isSuccess:" + paramBoolean + " retCode:" + paramLong + " errMsg:" + paramString + " traceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCirclePublishFeedRequest.getTraceId());
    bmvg localbmvg = new bmvg(this.jdField_a_of_type_CooperationQzoneQzoneIPCModule);
    localbmvg.jdField_a_of_type_Long = paramLong;
    localbmvg.jdField_a_of_type_JavaLangString = paramString;
    localbmvg.c = this.jdField_a_of_type_JavaLangString;
    localbmvg.d = this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCirclePublishFeedRequest.getTraceId();
    localbmvg.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    if ((paramStPublishFeedRsp != null) && (paramStPublishFeedRsp.feed != null) && (paramStPublishFeedRsp.feed.id != null)) {
      localbmvg.b = paramStPublishFeedRsp.feed.id.get();
    }
    if ((paramBoolean) && (paramLong == 0L) && (paramStPublishFeedRsp != null) && (paramStPublishFeedRsp.feed != null) && (paramStPublishFeedRsp.feed.id != null))
    {
      paramString = new vaz().a(paramStPublishFeedRsp.feed.id.get()).b(this.jdField_a_of_type_JavaLangString).a(paramStPublishFeedRsp.feed.createTime.get()).f(paramStPublishFeedRsp.feed.poster.id.get()).a(paramStPublishFeedRsp.feed.feedType.get()).g(paramStPublishFeedRsp.feed.video.playUrl.get()).e(paramStPublishFeedRsp.feed.cover.picUrl.get()).b(paramStPublishFeedRsp.feed.cover.width.get()).c(paramStPublishFeedRsp.feed.cover.height.get()).d(paramStPublishFeedRsp.feed.video.duration.get()).a();
      QLog.d("[QzoneIPCModule_upload2]QCircle", 1, new Object[] { "ACTION_QCIRCLE_PULISH_FEED onReceive feed id:", paramStPublishFeedRsp.feed.id.get(), " clientKey:", this.jdField_a_of_type_JavaLangString });
      aaak.a().a(new QCircleFuelAnimationEvent(true));
      QzoneIPCModule.a(this.jdField_a_of_type_CooperationQzoneQzoneIPCModule, paramString, 0, localbmvg);
      return;
    }
    if (paramLong == 10027L)
    {
      paramString = new vaz().b(this.jdField_a_of_type_JavaLangString).a();
      aaak.a().a(new QCircleFeedEvent(paramString, 3));
    }
    QzoneIPCModule.a(this.jdField_a_of_type_CooperationQzoneQzoneIPCModule, localbmvg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmvc
 * JD-Core Version:    0.7.0.1
 */