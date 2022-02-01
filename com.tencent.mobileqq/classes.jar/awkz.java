import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleSwitch.GetCircleSwitchRsp;
import qqcircle.QQCircleSwitch.StSwitch;

class awkz
  implements aaav<QQCircleSwitch.GetCircleSwitchRsp>
{
  awkz(awkw paramawkw, FormSwitchItem paramFormSwitchItem) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QQCircleSwitch.GetCircleSwitchRsp paramGetCircleSwitchRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      QLog.w("leba_sort_LebaTableMgrAdpter", 1, "GetCircleSwitch success");
      if (paramGetCircleSwitchRsp.sw.value.get().equals("1"))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
      return;
    }
    QLog.w("leba_sort_LebaTableMgrAdpter", 1, "GetCircleSwitch error retcode= " + paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awkz
 * JD-Core Version:    0.7.0.1
 */