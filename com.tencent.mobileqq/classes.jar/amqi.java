import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amqi
  implements View.OnClickListener
{
  amqi(amqh paramamqh) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof amqo)))
    {
      localObject = (amqo)localObject;
      bgpy.a(amqh.a(this.a), amqh.a(this.a), ((amqo)localObject).a);
      bgty localbgty = (bgty)amqh.a(this.a).getManager(203);
      if ((localbgty != null) && (localbgty.a(amqh.a(this.a), ((amqo)localObject).a, amqh.a(this.a)))) {
        localbgty.a(amqh.a(this.a), ((amqo)localObject).a);
      }
      if (amqh.a(this.a) != null) {
        break label121;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label121:
      bdll.b(amqh.a(this.a).app, "dc00898", "", "", "", "0X8009F9F", 0, 0, ((amqo)localObject).a, "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amqi
 * JD-Core Version:    0.7.0.1
 */