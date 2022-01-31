import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.datareportviewer.DataReportViewer;
import com.tencent.mobileqq.datareportviewer.ReportData;
import java.util.ArrayList;

public class apct
  implements AdapterView.OnItemClickListener
{
  public apct(DataReportViewer paramDataReportViewer, Context paramContext) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (WindowManager)this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.getContext().getSystemService("window");
    if (this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559473, null));
    }
    paramView = new apdd(this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer, this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.jdField_a_of_type_AndroidWidgetRelativeLayout);
    ReportData localReportData = (ReportData)this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    paramView.a.setText(localReportData.table);
    paramView.b.setText(localReportData.mainAction);
    paramView.c.setText(localReportData.subAction);
    paramView.d.setText(localReportData.actionName);
    paramView.e.setText(String.valueOf(localReportData.opType));
    paramView.f.setText(String.valueOf(localReportData.result));
    paramView.g.setText(localReportData.r2);
    paramView.h.setText(localReportData.r3);
    paramView.i.setText(localReportData.r4);
    paramView.j.setText(localReportData.r5);
    ((TextView)this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365226)).setOnClickListener(new apcu(this, paramAdapterView));
    ((TextView)this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365220)).setOnClickListener(new apcv(this, localReportData, paramAdapterView));
    if (Build.VERSION.SDK_INT >= 26) {}
    for (paramInt = 2038;; paramInt = 2003)
    {
      paramView = new WindowManager.LayoutParams(-1, -1, paramInt, 776, -2);
      paramView.gravity = 49;
      paramAdapterView.addView(this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.jdField_a_of_type_AndroidWidgetRelativeLayout, paramView);
      this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new apcw(this, paramAdapterView));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apct
 * JD-Core Version:    0.7.0.1
 */