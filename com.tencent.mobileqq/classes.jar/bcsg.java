import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.LocalCrashCollector;
import com.tencent.mobileqq.statistics.LocalCrashCollector.3;
import com.tencent.widget.XEditTextEx;

public class bcsg
  implements DialogInterface.OnClickListener
{
  public bcsg(LocalCrashCollector.3 param3, SessionInfo paramSessionInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if (LocalCrashCollector.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsLocalCrashCollector$3.this$0) > 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
          break label106;
        }
        LocalCrashCollector.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsLocalCrashCollector$3.this$0).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("/data/data/com.tencent.mobileqq/files/crashinfo/CrashInfoSummary.txt", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        LocalCrashCollector.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsLocalCrashCollector$3.this$0).jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
        LocalCrashCollector.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsLocalCrashCollector$3.this$0).delete(0, LocalCrashCollector.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsLocalCrashCollector$3.this$0).length());
        paramDialogInterface.dismiss();
        return;
        label106:
        LocalCrashCollector.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsLocalCrashCollector$3.this$0).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("/data/data/com.tencent.mobileqq/files/crashinfo/CrashInfoSummary.txt", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true);
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
 * Qualified Name:     bcsg
 * JD-Core Version:    0.7.0.1
 */