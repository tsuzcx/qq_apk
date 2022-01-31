import android.os.Bundle;
import com.tencent.biz.qqcircle.events.QCircleFakeFeed;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import feedcloud.FeedCloudWrite.StPublishFeedRsp;

class bjbo
  implements yvn<FeedCloudWrite.StPublishFeedRsp>
{
  bjbo(bjbk parambjbk, String paramString, int paramInt) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StPublishFeedRsp paramStPublishFeedRsp)
  {
    QLog.d("[QzoneIPCModule_upload2]QCircle", 1, "ACTION_QCIRCLE_PULISH_FEED onReceive isSuccess:" + paramBoolean + " retCode:" + paramLong + " errMsg:" + paramString);
    if ((paramBoolean) && (paramLong == 0L) && (paramStPublishFeedRsp != null) && (paramStPublishFeedRsp.feed != null) && (paramStPublishFeedRsp.feed.id != null))
    {
      localObject = new tvx().a(paramStPublishFeedRsp.feed.id.get()).b(this.jdField_a_of_type_JavaLangString).a(paramStPublishFeedRsp.feed.createTime.get()).f(paramStPublishFeedRsp.feed.poster.id.get()).a(paramStPublishFeedRsp.feed.feedType.get()).g(paramStPublishFeedRsp.feed.video.playUrl.get()).e(paramStPublishFeedRsp.feed.cover.picUrl.get()).b(paramStPublishFeedRsp.feed.cover.width.get()).c(paramStPublishFeedRsp.feed.cover.height.get()).d(paramStPublishFeedRsp.feed.video.duration.get()).a();
      QLog.d("[QzoneIPCModule_upload2]QCircle", 1, new Object[] { "ACTION_QCIRCLE_PULISH_FEED onReceive feed id:", paramStPublishFeedRsp.feed.id.get(), " clientKey:", this.jdField_a_of_type_JavaLangString });
      yej.a().a(new QCircleFeedEvent((QCircleFakeFeed)localObject, 2));
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putLong("key_return_code", paramLong);
    ((Bundle)localObject).putString("key_error_msg", paramString);
    if ((paramStPublishFeedRsp != null) && (paramStPublishFeedRsp.feed != null) && (paramStPublishFeedRsp.feed.id != null)) {
      ((Bundle)localObject).putString("key_stfeed_id", paramStPublishFeedRsp.feed.id.get());
    }
    ((Bundle)localObject).putString("key_clientkey", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Bjbk.callbackResult(this.jdField_a_of_type_Int, EIPCResult.createResult(0, (Bundle)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjbo
 * JD-Core Version:    0.7.0.1
 */