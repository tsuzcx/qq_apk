import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class awur
  implements View.OnClickListener
{
  awur(awuo paramawuo, BaseActivity paramBaseActivity, awpk paramawpk) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    int i = this.jdField_a_of_type_Awpk.a();
    Object localObject = this.jdField_a_of_type_Awpk.a();
    awpq.a(localQQAppInterface).a.a(3, i, (String)localObject);
    localObject = new awpk(i, (String)localObject);
    awpq.a(localQQAppInterface).a((awpk)localObject, false);
    bdll.b(null, "CliOper", "", "", "0X800A979", "0X800A979", 0, 0, "", "0", "0", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awur
 * JD-Core Version:    0.7.0.1
 */