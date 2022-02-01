import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.mobileqq.datareportviewer.DataReportViewer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class arzp
  implements View.OnClickListener
{
  arzp(arzm paramarzm, WindowManager paramWindowManager) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_Arzm.a.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arzp
 * JD-Core Version:    0.7.0.1
 */