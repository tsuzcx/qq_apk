import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.studymode.KidModeAdvanceSettingFragment;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import qqcircle.QQCircleSwitch.GetCircleSwitchRsp;
import qqcircle.QQCircleSwitch.StSwitch;

public class bcno
  implements VSDispatchObserver.onVSRspCallBack<QQCircleSwitch.GetCircleSwitchRsp>
{
  public bcno(KidModeAdvanceSettingFragment paramKidModeAdvanceSettingFragment) {}
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleSwitch.GetCircleSwitchRsp paramGetCircleSwitchRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      paramVSBaseRequest = paramGetCircleSwitchRsp.sw.value.get();
      QLog.d("leba_study", 1, "requestEntertainCount GetCircleSwitch success" + paramVSBaseRequest);
      QzoneConfig.getInstance().updateOneConfig("qqcircle", "qqcircle_entrance_enable", paramVSBaseRequest);
    }
    for (;;)
    {
      KidModeAdvanceSettingFragment.b(this.a);
      return;
      QLog.d("leba_study", 1, "requestEntertainCount GetCircleSwitch error retcode= " + paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcno
 * JD-Core Version:    0.7.0.1
 */