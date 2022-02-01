import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudWrite.StDoFollowRsp;
import java.util.HashMap;
import java.util.Map;

class atir
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudWrite.StDoFollowRsp>
{
  atir(atip paramatip, String paramString, int paramInt) {}
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoFollowRsp paramStDoFollowRsp)
  {
    QLog.d("flutter.QQCircleChannelHandler", 1, "[onReceive] isSuccess=" + paramBoolean + ", retCode=" + paramLong + ", errMsg=" + paramString + ", uin=" + this.jdField_a_of_type_JavaLangString);
    if ((paramBoolean) && (0L == paramLong))
    {
      paramVSBaseRequest = new HashMap();
      paramVSBaseRequest.put("userId", this.jdField_a_of_type_JavaLangString);
      paramVSBaseRequest.put("followState", Integer.valueOf(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_Atip.a.a("tencent_qqcircle/follow", paramVSBaseRequest);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atir
 * JD-Core Version:    0.7.0.1
 */