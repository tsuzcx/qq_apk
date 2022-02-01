import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.mobileqq.datareportviewer.DataReportViewer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aqto
  implements View.OnClickListener
{
  public aqto(DataReportViewer paramDataReportViewer, WindowManager paramWindowManager) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqto
 * JD-Core Version:    0.7.0.1
 */