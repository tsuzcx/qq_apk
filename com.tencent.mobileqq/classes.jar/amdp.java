import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;

public class amdp
  implements View.OnClickListener
{
  public amdp(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && (this.a.a.isShowing()))
    {
      this.a.a.dismiss();
      this.a.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     amdp
 * JD-Core Version:    0.7.0.1
 */