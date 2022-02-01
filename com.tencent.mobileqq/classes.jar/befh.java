import android.content.Intent;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity;

public class befh
  extends ClickableSpan
{
  public befh(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.getActivity(), QQBrowserActivity.class);
    paramView.putExtra("uin", this.a.app.getCurrentAccountUin());
    paramView.putExtra("hide_more_button", true);
    paramView.putExtra("hide_operation_bar", true);
    this.a.startActivity(paramView.putExtra("url", "https://tim.qq.com/htdocs/2.0_lead/document.html"));
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.a.getResources().getColor(2131165524));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     befh
 * JD-Core Version:    0.7.0.1
 */