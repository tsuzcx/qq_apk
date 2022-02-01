import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.richmedia.capture.view.QQSlidingTabView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bbjl
  implements View.OnClickListener
{
  public bbjl(QQSlidingTabView paramQQSlidingTabView, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.a(this.jdField_a_of_type_Int);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbjl
 * JD-Core Version:    0.7.0.1
 */