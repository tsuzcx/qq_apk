import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class augt
  implements View.OnClickListener
{
  public augt(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    String str2 = anvx.a(2131713243) + atpm.b() + anvx.a(2131713249);
    String str1 = null;
    String str3 = anvx.a(2131713261);
    if (SendBottomBar.a(this.a).g() != -1)
    {
      str2 = anvx.a(2131713267);
      str1 = anvx.a(2131713263);
      str3 = anvx.a(2131713260);
    }
    this.a.a = bhdj.a(SendBottomBar.a(this.a), 230, str1, str2, anvx.a(2131713259), str3, new augu(this), new augv(this));
    this.a.a.show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     augt
 * JD-Core Version:    0.7.0.1
 */