import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

final class bmlh
  implements View.OnClickListener
{
  bmlh(bbbu parambbbu, BaseActivity paramBaseActivity, MqqHandler paramMqqHandler, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = null;
    if ("1".equals(this.jdField_a_of_type_Bbbu.k)) {
      localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
    }
    for (;;)
    {
      if (localIntent != null)
      {
        localIntent.putExtra("url", this.jdField_a_of_type_Bbbu.d);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(9);
      }
      bmlf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 102, this.jdField_a_of_type_Bbbu.a, this.jdField_a_of_type_Bbbu.b);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ("2".equals(this.jdField_a_of_type_Bbbu.k)) {
        localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQTranslucentBrowserActivity.class);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmlh
 * JD-Core Version:    0.7.0.1
 */