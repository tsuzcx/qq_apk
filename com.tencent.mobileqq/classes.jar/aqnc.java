import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aqnc
  implements View.OnClickListener
{
  public aqnc(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (this.a.jdField_a_of_type_AndroidAppDialog.isShowing()))
    {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.a.jdField_a_of_type_AndroidAppDialog = null;
    }
    if (this.a.jdField_a_of_type_Int == 0)
    {
      bdll.b(this.a.app, "CliOper", "", "", "0X80064E3", "0X80064E3", 0, 0, "", "", "", "");
      if ((!this.a.jdField_a_of_type_Boolean) || (!this.a.b) || (this.a.isFinishing())) {
        break label176;
      }
      this.a.finish();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.getIntent().getIntExtra("source_activity", 0) != 1) {
        break;
      }
      bdll.b(this.a.app, "CliOper", "", "", "0X80064EE", "0X80064EE", 0, 0, "", "", "", "");
      break;
      label176:
      if (this.a.c)
      {
        aqoj.a(this.a.app.getCurrentAccountUin(), -1);
        this.a.c = false;
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard == null) || (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardId))) {
        this.a.finish();
      } else {
        BusinessCardEditActivity.a(this.a, false, true, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqnc
 * JD-Core Version:    0.7.0.1
 */