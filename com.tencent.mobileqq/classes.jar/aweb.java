import android.text.TextUtils;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.redpoint.QCircleRedPointManager;
import mqq.app.AppRuntime;
import qqcircle.QQCircleSwitch.SetMultiCircleSwitchRsp;

class aweb
  implements VSDispatchObserver.onVSRspCallBack<QQCircleSwitch.SetMultiCircleSwitchRsp>
{
  aweb(awea paramawea, boolean paramBoolean, String paramString) {}
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleSwitch.SetMultiCircleSwitchRsp paramSetMultiCircleSwitchRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      QLog.w("leba_sort_LebaTableMgrAdpter", 1, "setCircleSwitch success isChecked" + this.jdField_a_of_type_Boolean);
      if (!this.jdField_a_of_type_Boolean)
      {
        ((QCircleRedPointManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.QCIRCLE_MGR_RED_TOUCH)).clearPedPoint();
        QLog.w("leba_sort_LebaTableMgrAdpter", 1, "setCircleSwitch success clearPedPoint");
      }
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      paramString = QzoneConfig.getInstance();
      if (this.jdField_a_of_type_Boolean)
      {
        paramVSBaseRequest = "0";
        paramString.updateOneConfig("qqcircle", "qqcircle_entrance_enable_on_children_mode", paramVSBaseRequest);
      }
    }
    else
    {
      paramString = QzoneConfig.getInstance();
      if (!this.jdField_a_of_type_Boolean) {
        break label164;
      }
    }
    label164:
    for (paramVSBaseRequest = "0";; paramVSBaseRequest = "1")
    {
      paramString.updateOneConfig("qqcircle", "qqcircle_entrance_enable", paramVSBaseRequest);
      QLog.w("leba_sort_LebaTableMgrAdpter", 1, "setCircleSwitch error retcode= " + paramLong);
      return;
      paramVSBaseRequest = "1";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aweb
 * JD-Core Version:    0.7.0.1
 */