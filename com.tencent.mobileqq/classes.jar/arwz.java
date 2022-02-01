import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.datareportviewer.DataReportViewer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arwz
  implements AdapterView.OnItemClickListener
{
  public arwz(DataReportViewer paramDataReportViewer, Context paramContext) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    DataReportViewer.a(this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer, this.jdField_a_of_type_AndroidContentContext, paramInt);
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arwz
 * JD-Core Version:    0.7.0.1
 */