import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.mobileqq.datareportviewer.DataReportViewer;
import com.tencent.mobileqq.datareportviewer.ReportData;

class anlo
  implements View.OnClickListener
{
  anlo(anlm paramanlm, ReportData paramReportData, WindowManager paramWindowManager) {}
  
  public void onClick(View paramView)
  {
    paramView = (ClipboardManager)this.jdField_a_of_type_Anlm.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard");
    if (paramView != null)
    {
      paramView.setPrimaryClip(ClipData.newPlainText(null, this.jdField_a_of_type_ComTencentMobileqqDatareportviewerReportData.toString()));
      bcql.a(this.jdField_a_of_type_Anlm.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.getContext(), ajya.a(2131702774), 0).a();
    }
    this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_Anlm.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anlo
 * JD-Core Version:    0.7.0.1
 */