import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.ApolloGameNormalStartHandler.3;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class amhc
  implements View.OnClickListener
{
  public amhc(ApolloGameNormalStartHandler.3 param3) {}
  
  public void onClick(View paramView)
  {
    amhb.a(this.a.this$0).dismiss();
    amhb.a(this.a.this$0, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amhc
 * JD-Core Version:    0.7.0.1
 */