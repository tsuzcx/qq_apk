import android.text.TextUtils;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import qqcircle.QQCircleCountergroup.GetGroupCountRsp;

class bgcp
  implements VSDispatchObserver.onVSRspCallBack
{
  bgcp(bgco parambgco) {}
  
  public void onReceive(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof QQCircleCountergroup.GetGroupCountRsp)))
    {
      paramVSBaseRequest = (QQCircleCountergroup.GetGroupCountRsp)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("QCircleMsgProcessor", 2, String.format(Locale.getDefault(), "rsp.content=%s,rsp.count=%d, rsp.hasMore=%d, rsp.iconUrl=%s, rsp.latestFeedTime=%s, rsp.timeInterval=%s", new Object[] { paramVSBaseRequest.content.get(), Integer.valueOf(paramVSBaseRequest.count.get()), Integer.valueOf(paramVSBaseRequest.hasMore.get()), paramVSBaseRequest.iconUrl.get(), Integer.valueOf(paramVSBaseRequest.latestFeedTime.get()), Integer.valueOf(paramVSBaseRequest.timeInterval.get()) }));
      }
      if ((paramVSBaseRequest.count.get() < 1) || (TextUtils.isEmpty(paramVSBaseRequest.content.get())))
      {
        QLog.d("QCircleMsgProcessor", 2, "rsp.count.get() < 1 || TextUtils.isEmpty(rsp.content.get())");
        return;
      }
      bgco.a(this.a, paramVSBaseRequest);
      bgco.a(this.a, NetConnInfoCenter.getServerTimeMillis() / 1000L);
      bgco.b(this.a, paramVSBaseRequest.timeInterval.get());
      bdla.b(null, "dc00898", "", String.valueOf(bgco.a(this.a)), "0X800B24E", "0X800B24E", 0, 0, "", "", "", "");
      return;
    }
    QLog.e("QCircleMsgProcessor", 2, "retCode:" + paramLong + ", errMsg:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgcp
 * JD-Core Version:    0.7.0.1
 */