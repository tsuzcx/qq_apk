import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;

public class amdw
  implements View.OnClickListener
{
  public amdw(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (amea)paramView.getTag();
    if (!((ajxl)this.a.app.getManager(51)).b(paramView.a)) {}
    for (int i = 35;; i = 1)
    {
      paramView = new ProfileActivity.AllInOne(paramView.a, i);
      ProfileActivity.a(this.a, paramView, 1016);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     amdw
 * JD-Core Version:    0.7.0.1
 */