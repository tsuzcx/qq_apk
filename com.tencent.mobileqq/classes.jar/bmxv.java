import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.contentbox.FootNavigationLayout;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.report.lp.LpReportManager;

public class bmxv
  implements View.OnClickListener
{
  public bmxv(FootNavigationLayout paramFootNavigationLayout, bmyn parambmyn, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Object localObject = bhni.a(((BaseActivity)this.jdField_a_of_type_CooperationQzoneContentboxFootNavigationLayout.getContext()).app, this.jdField_a_of_type_CooperationQzoneContentboxFootNavigationLayout.getContext(), this.jdField_a_of_type_Bmyn.b);
    if (localObject != null) {
      ((bhmr)localObject).a();
    }
    for (;;)
    {
      localObject = new LpReportInfo_dc02880(7, FootNavigationLayout.a()[this.jdField_a_of_type_Int]);
      LpReportManager.getInstance().reportToDC02880((LpReportInfo_dc02880)localObject, false, true);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = new Intent(this.jdField_a_of_type_CooperationQzoneContentboxFootNavigationLayout.getContext(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.jdField_a_of_type_Bmyn.b);
      bmtd.c((Intent)localObject);
      this.jdField_a_of_type_CooperationQzoneContentboxFootNavigationLayout.getContext().startActivity((Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmxv
 * JD-Core Version:    0.7.0.1
 */