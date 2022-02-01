import android.content.Intent;
import android.view.View;
import com.dataline.activities.LiteAdvanceActivity;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;

public class co
  implements bkzq
{
  public co(LiteAdvanceActivity paramLiteAdvanceActivity, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkzi.cancel();
      return;
      bdlq.a(this.jdField_a_of_type_ComDatalineActivitiesLiteAdvanceActivity.app.getApplication().getApplicationContext(), this.jdField_a_of_type_ComDatalineActivitiesLiteAdvanceActivity.app.getCurrentAccountUin(), "dl_ckclearmsg");
      paramView = (ansr)this.jdField_a_of_type_ComDatalineActivitiesLiteAdvanceActivity.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      paramView.a(32, true);
      paramView.e();
      this.jdField_a_of_type_ComDatalineActivitiesLiteAdvanceActivity.app.getMessageFacade().getDatalineMessageManager(this.jdField_a_of_type_ComDatalineActivitiesLiteAdvanceActivity.a).a();
      this.jdField_a_of_type_ComDatalineActivitiesLiteAdvanceActivity.getIntent().putExtra("clear_flag", true);
      this.jdField_a_of_type_ComDatalineActivitiesLiteAdvanceActivity.setResult(-1, this.jdField_a_of_type_ComDatalineActivitiesLiteAdvanceActivity.getIntent());
      this.jdField_a_of_type_ComDatalineActivitiesLiteAdvanceActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     co
 * JD-Core Version:    0.7.0.1
 */