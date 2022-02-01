import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amjd
  implements View.OnClickListener
{
  amjd(amjc paramamjc) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof amjj)))
    {
      localObject = (amjj)localObject;
      bghs.a(amjc.a(this.a), amjc.a(this.a), ((amjj)localObject).a);
      bgls localbgls = (bgls)amjc.a(this.a).getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
      if ((localbgls != null) && (localbgls.a(amjc.a(this.a), ((amjj)localObject).a, amjc.a(this.a)))) {
        localbgls.a(amjc.a(this.a), ((amjj)localObject).a);
      }
      if (amjc.a(this.a) != null) {
        break label121;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label121:
      bdla.b(amjc.a(this.a).app, "dc00898", "", "", "", "0X8009F9F", 0, 0, ((amjj)localObject).a, "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amjd
 * JD-Core Version:    0.7.0.1
 */