import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.startup.step.CheckPermission;
import mqq.app.AppActivity;

class apnq
  implements View.OnClickListener
{
  apnq(apnm paramapnm) {}
  
  public void onClick(View paramView)
  {
    if (!CheckPermission.isHasStoragePermission(this.a.a))
    {
      CheckPermission.requestSDCardPermission((AppActivity)this.a.a, new apnr(this));
      return;
    }
    apue.a(this.a.a, this.a.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apnq
 * JD-Core Version:    0.7.0.1
 */