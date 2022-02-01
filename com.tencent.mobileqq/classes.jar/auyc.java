import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.redpoint.QCircleRedPointManager;
import mqq.app.AppRuntime;
import qqcircle.QQCircleSwitch.SetCircleSwitchRsp;

class auyc
  implements VSDispatchObserver.onVSRspCallBack<QQCircleSwitch.SetCircleSwitchRsp>
{
  auyc(auyb paramauyb, boolean paramBoolean) {}
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleSwitch.SetCircleSwitchRsp paramSetCircleSwitchRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      QLog.w("leba_sort_LebaTableMgrAdpter", 1, "setCircleSwitch success isChecked" + this.jdField_a_of_type_Boolean);
      paramString = QzoneConfig.getInstance();
      if (this.jdField_a_of_type_Boolean) {}
      for (paramVSBaseRequest = "1";; paramVSBaseRequest = "0")
      {
        paramString.updateOneConfig("qqcircle", "qqcircle_entrance_enable", paramVSBaseRequest);
        if (!this.jdField_a_of_type_Boolean)
        {
          ((QCircleRedPointManager)BaseApplicationImpl.getApplication().getRuntime().getManager(376)).clearPedPoint();
          QLog.w("leba_sort_LebaTableMgrAdpter", 1, "setCircleSwitch success clearPedPoint");
        }
        return;
      }
    }
    QLog.w("leba_sort_LebaTableMgrAdpter", 1, "setCircleSwitch error retcode= " + paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auyc
 * JD-Core Version:    0.7.0.1
 */