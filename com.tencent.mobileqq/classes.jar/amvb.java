import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.mobileqq.datareportviewer.DataReportViewer;
import com.tencent.mobileqq.datareportviewer.ReportData;

class amvb
  implements View.OnClickListener
{
  amvb(amuz paramamuz, ReportData paramReportData, WindowManager paramWindowManager) {}
  
  public void onClick(View paramView)
  {
    paramView = (ClipboardManager)this.jdField_a_of_type_Amuz.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard");
    if (paramView != null)
    {
      paramView.setPrimaryClip(ClipData.newPlainText(null, this.jdField_a_of_type_ComTencentMobileqqDatareportviewerReportData.toString()));
      bbmy.a(this.jdField_a_of_type_Amuz.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.getContext(), ajjy.a(2131636979), 0).a();
    }
    this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_Amuz.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amvb
 * JD-Core Version:    0.7.0.1
 */