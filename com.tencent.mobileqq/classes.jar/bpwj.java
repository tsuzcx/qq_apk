import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.view.QIMSlidingTabView;

public class bpwj
  implements View.OnClickListener
{
  public bpwj(QIMSlidingTabView paramQIMSlidingTabView, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.a(this.jdField_a_of_type_Int);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpwj
 * JD-Core Version:    0.7.0.1
 */