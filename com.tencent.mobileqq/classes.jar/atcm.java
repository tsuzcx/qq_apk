import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class atcm
  implements View.OnClickListener
{
  public atcm(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    String str2 = amtj.a(2131712896) + aslg.b() + amtj.a(2131712902);
    String str1 = null;
    String str3 = amtj.a(2131712914);
    if (SendBottomBar.a(this.a).g() != -1)
    {
      str2 = amtj.a(2131712920);
      str1 = amtj.a(2131712916);
      str3 = amtj.a(2131712913);
    }
    this.a.a = bfur.a(SendBottomBar.a(this.a), 230, str1, str2, amtj.a(2131712912), str3, new atcn(this), new atco(this));
    this.a.a.show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atcm
 * JD-Core Version:    0.7.0.1
 */