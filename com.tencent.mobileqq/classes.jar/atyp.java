import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar.7.1;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class atyp
  implements View.OnClickListener
{
  public atyp(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (SendBottomBar.b(this.a)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      SendBottomBar.a(this.a, true);
      new Handler().postDelayed(new SendBottomBar.7.1(this), 800L);
      SendBottomBar.b(this.a);
      switch (SendBottomBar.a(this.a).b())
      {
      case 2: 
      case 3: 
      case 4: 
      case 6: 
      default: 
        if (!AppNetConnInfo.isNetSupport()) {
          atvf.a(2131693919);
        }
        break;
      case 7: 
        SendBottomBar.c(this.a);
        break;
      case 1: 
        SendBottomBar.d(this.a);
        break;
      case 5: 
        SendBottomBar.e(this.a);
        break;
      case 8: 
        SendBottomBar.f(this.a);
        break;
      case 9: 
        this.a.b();
        continue;
        int j = SendBottomBar.a(this.a).a();
        if (j == 1) {}
        for (int i = 1;; i = 0)
        {
          if (j != 5) {
            break label218;
          }
          this.a.c();
          break;
        }
        label218:
        if (i != 0) {
          SendBottomBar.a(this.a, true);
        } else {
          SendBottomBar.g(this.a);
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atyp
 * JD-Core Version:    0.7.0.1
 */