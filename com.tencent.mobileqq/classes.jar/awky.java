import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import mqq.app.AppRuntime;
import qqcircle.QQCircleSwitch.SetCircleSwitchRsp;

class awky
  implements aaav<QQCircleSwitch.SetCircleSwitchRsp>
{
  awky(awkx paramawkx, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QQCircleSwitch.SetCircleSwitchRsp paramSetCircleSwitchRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      QLog.w("leba_sort_LebaTableMgrAdpter", 1, "setCircleSwitch success isChecked" + this.jdField_a_of_type_Boolean);
      paramSetCircleSwitchRsp = QzoneConfig.getInstance();
      if (this.jdField_a_of_type_Boolean) {}
      for (paramString = "1";; paramString = "0")
      {
        paramSetCircleSwitchRsp.updateOneConfig("qqcircle", "qqcircle_entrance_enable", paramString);
        if (!this.jdField_a_of_type_Boolean)
        {
          ((vtf)BaseApplicationImpl.getApplication().getRuntime().getManager(376)).a();
          QLog.w("leba_sort_LebaTableMgrAdpter", 1, "setCircleSwitch success clearPedPoint");
        }
        return;
      }
    }
    QLog.w("leba_sort_LebaTableMgrAdpter", 1, "setCircleSwitch error retcode= " + paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awky
 * JD-Core Version:    0.7.0.1
 */