import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import cooperation.qzone.contentbox.FootNavigationLayout;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.report.lp.LpReportManager;

public class bhcu
  implements View.OnClickListener
{
  public bhcu(FootNavigationLayout paramFootNavigationLayout, bhdm parambhdm, int paramInt) {}
  
  public void onClick(View paramView)
  {
    paramView = bbex.a(((BaseActivity)this.jdField_a_of_type_CooperationQzoneContentboxFootNavigationLayout.getContext()).app, this.jdField_a_of_type_CooperationQzoneContentboxFootNavigationLayout.getContext(), this.jdField_a_of_type_Bhdm.b);
    if (paramView != null) {
      paramView.c();
    }
    for (;;)
    {
      paramView = new LpReportInfo_dc02880(7, FootNavigationLayout.a()[this.jdField_a_of_type_Int]);
      LpReportManager.getInstance().reportToDC02880(paramView, false, true);
      return;
      paramView = new Intent(this.jdField_a_of_type_CooperationQzoneContentboxFootNavigationLayout.getContext(), QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_Bhdm.b);
      bgyp.c(paramView);
      this.jdField_a_of_type_CooperationQzoneContentboxFootNavigationLayout.getContext().startActivity(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhcu
 * JD-Core Version:    0.7.0.1
 */