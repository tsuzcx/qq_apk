import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aqnk
  implements View.OnClickListener
{
  public aqnk(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (aqno)paramView.getTag();
    if (!((anyw)this.a.app.getManager(51)).b(((aqno)localObject).a)) {}
    for (int i = 35;; i = 1)
    {
      localObject = new ProfileActivity.AllInOne(((aqno)localObject).a, i);
      ProfileActivity.a(this.a, (ProfileActivity.AllInOne)localObject, 1016);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqnk
 * JD-Core Version:    0.7.0.1
 */