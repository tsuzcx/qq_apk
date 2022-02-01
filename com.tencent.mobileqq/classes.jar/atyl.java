import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class atyl
  implements View.OnClickListener
{
  public atyl(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    String str2 = anni.a(2131712555) + athc.b() + anni.a(2131712561);
    String str1 = null;
    String str3 = anni.a(2131712573);
    if (SendBottomBar.a(this.a).g() != -1)
    {
      str2 = anni.a(2131712579);
      str1 = anni.a(2131712575);
      str3 = anni.a(2131712572);
    }
    this.a.a = bglp.a(SendBottomBar.a(this.a), 230, str1, str2, anni.a(2131712571), str3, new atym(this), new atyn(this));
    this.a.a.show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atyl
 * JD-Core Version:    0.7.0.1
 */