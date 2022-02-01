import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.datareportviewer.DataReportViewer;
import com.tencent.mobileqq.datareportviewer.ReportData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class arzm
  implements AdapterView.OnItemClickListener
{
  public arzm(DataReportViewer paramDataReportViewer, Context paramContext) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    WindowManager localWindowManager = (WindowManager)this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.getContext().getSystemService("window");
    if (this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559609, null));
    }
    Object localObject = new arzw(this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer, this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.jdField_a_of_type_AndroidWidgetRelativeLayout);
    ReportData localReportData = (ReportData)this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    ((arzw)localObject).a.setText(localReportData.table);
    ((arzw)localObject).b.setText(localReportData.mainAction);
    ((arzw)localObject).c.setText(localReportData.subAction);
    ((arzw)localObject).d.setText(localReportData.actionName);
    ((arzw)localObject).e.setText(String.valueOf(localReportData.opType));
    ((arzw)localObject).f.setText(String.valueOf(localReportData.result));
    ((arzw)localObject).g.setText(localReportData.r2);
    ((arzw)localObject).h.setText(localReportData.r3);
    ((arzw)localObject).i.setText(localReportData.r4);
    ((arzw)localObject).j.setText(localReportData.r5);
    ((TextView)this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365514)).setOnClickListener(new arzn(this, localWindowManager));
    ((TextView)this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365508)).setOnClickListener(new arzo(this, localReportData, localWindowManager));
    if (Build.VERSION.SDK_INT >= 26) {}
    for (int i = 2038;; i = 2003)
    {
      localObject = new WindowManager.LayoutParams(-1, -1, i, 776, -2);
      ((WindowManager.LayoutParams)localObject).gravity = 49;
      localWindowManager.addView(this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.jdField_a_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new arzp(this, localWindowManager));
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arzm
 * JD-Core Version:    0.7.0.1
 */