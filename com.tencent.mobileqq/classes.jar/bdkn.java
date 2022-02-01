import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.LocalCrashCollector;
import com.tencent.mobileqq.statistics.LocalCrashCollector.3;
import com.tencent.widget.XEditTextEx;

public class bdkn
  implements DialogInterface.OnClickListener
{
  public bdkn(LocalCrashCollector.3 param3, SessionInfo paramSessionInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if (LocalCrashCollector.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsLocalCrashCollector$3.this$0) > 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1) {
          break label106;
        }
        LocalCrashCollector.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsLocalCrashCollector$3.this$0).app.getFileManagerEngine().a("/data/data/com.tencent.mobileqq/files/crashinfo/CrashInfoSummary.txt", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      }
      for (;;)
      {
        LocalCrashCollector.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsLocalCrashCollector$3.this$0).input.setText("");
        LocalCrashCollector.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsLocalCrashCollector$3.this$0).delete(0, LocalCrashCollector.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsLocalCrashCollector$3.this$0).length());
        paramDialogInterface.dismiss();
        return;
        label106:
        LocalCrashCollector.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsLocalCrashCollector$3.this$0).app.getFileManagerEngine().a("/data/data/com.tencent.mobileqq/files/crashinfo/CrashInfoSummary.txt", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, true);
      }
      return;
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdkn
 * JD-Core Version:    0.7.0.1
 */