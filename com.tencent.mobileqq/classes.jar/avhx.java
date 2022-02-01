import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class avhx
  implements View.OnClickListener
{
  avhx(avhu paramavhu, BaseActivity paramBaseActivity, avcq paramavcq) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    int i = this.jdField_a_of_type_Avcq.a();
    Object localObject = this.jdField_a_of_type_Avcq.a();
    avcw.a(localQQAppInterface).a.a(3, i, (String)localObject);
    localObject = new avcq(i, (String)localObject);
    avcw.a(localQQAppInterface).a((avcq)localObject, false);
    bcef.b(null, "CliOper", "", "", "0X800A979", "0X800A979", 0, 0, "", "0", "0", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avhx
 * JD-Core Version:    0.7.0.1
 */