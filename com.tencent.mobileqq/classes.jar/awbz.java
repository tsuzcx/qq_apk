import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class awbz
  implements View.OnClickListener
{
  awbz(awbw paramawbw, BaseActivity paramBaseActivity, avwp paramavwp) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    int i = this.jdField_a_of_type_Avwp.a();
    Object localObject = this.jdField_a_of_type_Avwp.a();
    avwv.a(localQQAppInterface).a.a(3, i, (String)localObject);
    localObject = new avwp(i, (String)localObject);
    avwv.a(localQQAppInterface).a((avwp)localObject, false);
    bcst.b(null, "CliOper", "", "", "0X800A979", "0X800A979", 0, 0, "", "0", "0", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awbz
 * JD-Core Version:    0.7.0.1
 */