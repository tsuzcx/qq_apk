import com.qflutter.qqcircle.TencentQQCirclePlugin;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudWrite.StDoFollowRsp;
import java.util.HashMap;
import java.util.Map;

class aumx
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudWrite.StDoFollowRsp>
{
  aumx(aumv paramaumv, String paramString, int paramInt) {}
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoFollowRsp paramStDoFollowRsp)
  {
    QLog.d("QQCircleMethodImpl", 1, "[onReceive] isSuccess=" + paramBoolean + ", retCode=" + paramLong + ", errMsg=" + paramString + ", uin=" + this.jdField_a_of_type_JavaLangString);
    if ((paramBoolean) && (0L == paramLong))
    {
      paramVSBaseRequest = new HashMap();
      paramVSBaseRequest.put("userId", this.jdField_a_of_type_JavaLangString);
      paramVSBaseRequest.put("followState", Integer.valueOf(this.jdField_a_of_type_Int));
      TencentQQCirclePlugin.sendEvent("tencent_qqcircle/follow", paramVSBaseRequest);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aumx
 * JD-Core Version:    0.7.0.1
 */