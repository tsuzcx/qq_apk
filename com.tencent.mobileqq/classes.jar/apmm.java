import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.startup.step.CheckPermission;
import mqq.app.AppActivity;

class apmm
  implements View.OnClickListener
{
  apmm(apme paramapme) {}
  
  public void onClick(View paramView)
  {
    if (!CheckPermission.isHasStoragePermission(this.a.a))
    {
      CheckPermission.requestSDCardPermission((AppActivity)this.a.a, new apmn(this));
      return;
    }
    apue.a(this.a.a, this.a.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apmm
 * JD-Core Version:    0.7.0.1
 */