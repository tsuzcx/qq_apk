import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.ApolloGameNormalStartHandler.3;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class amsw
  implements View.OnClickListener
{
  public amsw(ApolloGameNormalStartHandler.3 param3) {}
  
  public void onClick(View paramView)
  {
    amsv.a(this.a.this$0).dismiss();
    amsv.a(this.a.this$0, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsw
 * JD-Core Version:    0.7.0.1
 */