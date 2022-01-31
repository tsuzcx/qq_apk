import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.widgets.ShareAioResultDialog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;

public class bp
  implements DialogInterface.OnClickListener
{
  public bp(LiteActivity paramLiteActivity, long paramLong, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.dismiss();
      return;
      if (this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getIntent().getIntExtra("forward_type", -1) == 11) {
        ReportCenter.a().a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getAccount(), "", String.valueOf(this.jdField_a_of_type_Long), "1000", "51", "0", false);
      }
      if (QLog.isColorLevel()) {
        QLog.i(LiteActivity.jdField_a_of_type_JavaLangString, 2, "qbShowShareResultDialog back");
      }
      if (this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getIntent().getBooleanExtra("MigSdkShareNotDone", false))
      {
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getIntent().putExtra("MigSdkShareNotDone", false);
        ForwardSdkShareOption.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, true, "sendToMyComputer", this.jdField_a_of_type_Long);
      }
      for (;;)
      {
        for (;;)
        {
          Util.a(this.jdField_a_of_type_AndroidContentContext, 0, "", "");
          this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.finish();
          if (!this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getIntent().getBooleanExtra("show_share_result_dialog_return_thirdapp", true)) {
            break;
          }
          try
          {
            this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getActivity().moveTaskToBack(true);
          }
          catch (Throwable paramDialogInterface) {}
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e(LiteActivity.jdField_a_of_type_JavaLangString, 2, "qbShowShareResultDialog ", paramDialogInterface);
        break;
        ForwardSdkShareOption.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, true, "shareToQQ", this.jdField_a_of_type_Long);
      }
      if (this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getIntent().getIntExtra("forward_type", -1) == 11) {
        ReportCenter.a().a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getAccount(), "", String.valueOf(this.jdField_a_of_type_Long), "1000", "52", "0", false);
      }
      if (QLog.isColorLevel()) {
        QLog.i(LiteActivity.jdField_a_of_type_JavaLangString, 2, "qbShowShareResultDialog stay");
      }
      if (this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getIntent().getBooleanExtra("MigSdkShareNotDone", false)) {
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getIntent().putExtra("MigSdkShareNotDone", false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bp
 * JD-Core Version:    0.7.0.1
 */