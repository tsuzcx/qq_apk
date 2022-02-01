import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.LebaHelper.4;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.redpoint.QCircleRedPointManager;
import mqq.app.AppRuntime;
import qqcircle.QQCircleSwitch.SetCircleSwitchRsp;

public class amuy
  implements VSDispatchObserver.onVSRspCallBack<QQCircleSwitch.SetCircleSwitchRsp>
{
  public amuy(LebaHelper.4 param4) {}
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleSwitch.SetCircleSwitchRsp paramSetCircleSwitchRsp)
  {
    QLog.i("leba_study", 1, "SetCircleSwitch isSuccess=" + paramBoolean + ",retCode=" + paramLong + ",errMsg=" + paramString);
    if ((paramBoolean) && (paramLong == 0L))
    {
      QzoneConfig.getInstance().updateOneConfig("qqcircle", "qqcircle_entrance_enable", "0");
      ((QCircleRedPointManager)BaseApplicationImpl.getApplication().getRuntime().getManager(376)).clearPedPoint();
      this.a.this$0.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amuy
 * JD-Core Version:    0.7.0.1
 */