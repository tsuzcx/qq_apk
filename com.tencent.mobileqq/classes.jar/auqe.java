import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class auqe
  implements View.OnClickListener
{
  public auqe(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    String str2 = anzj.a(2131712664) + atyw.b() + anzj.a(2131712670);
    String str1 = null;
    String str3 = anzj.a(2131712682);
    if (SendBottomBar.a(this.a).g() != -1)
    {
      str2 = anzj.a(2131712688);
      str1 = anzj.a(2131712684);
      str3 = anzj.a(2131712681);
    }
    this.a.a = bhlq.a(SendBottomBar.a(this.a), 230, str1, str2, anzj.a(2131712680), str3, new auqf(this), new auqg(this));
    this.a.a.show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auqe
 * JD-Core Version:    0.7.0.1
 */