import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aqjx
  implements View.OnClickListener
{
  public aqjx(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (aqkd)paramView.getTag();
    if (!((anvk)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(((aqkd)localObject).a)) {}
    for (int i = 35;; i = 1)
    {
      localObject = new ProfileActivity.AllInOne(((aqkd)localObject).a, i);
      ProfileActivity.a(this.a, (ProfileActivity.AllInOne)localObject, 1016);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqjx
 * JD-Core Version:    0.7.0.1
 */