import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.mobileqq.datareportviewer.DataReportViewer;
import com.tencent.mobileqq.datareportviewer.ReportData;
import com.tencent.mobileqq.widget.QQToast;

class apcv
  implements View.OnClickListener
{
  apcv(apct paramapct, ReportData paramReportData, WindowManager paramWindowManager) {}
  
  public void onClick(View paramView)
  {
    paramView = (ClipboardManager)this.jdField_a_of_type_Apct.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard");
    if (paramView != null)
    {
      paramView.setPrimaryClip(ClipData.newPlainText(null, this.jdField_a_of_type_ComTencentMobileqqDatareportviewerReportData.toString()));
      QQToast.a(this.jdField_a_of_type_Apct.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.getContext(), alpo.a(2131703146), 0).a();
    }
    this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_Apct.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apcv
 * JD-Core Version:    0.7.0.1
 */