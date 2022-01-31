import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;

public class arvm
  implements bhul
{
  public arvm(SendBottomBar paramSendBottomBar) {}
  
  public void a(View paramView, int paramInt, String paramString)
  {
    if (paramString.equals(alud.a(2131714177)))
    {
      paramView = arrr.a("排序方式:\n时间", alud.a(2131714186), null);
      SendBottomBar.a(this.a).setText(paramView);
      if (SendBottomBar.a(this.a).g() == 0) {
        return;
      }
      SendBottomBar.a(this.a).b(0);
    }
    for (;;)
    {
      this.a.a.dismiss();
      return;
      if (paramString.equals(alud.a(2131714206)))
      {
        paramView = arrr.a("排序方式:\n大小", alud.a(2131714180), null);
        SendBottomBar.a(this.a).setText(paramView);
        if (SendBottomBar.a(this.a).g() == 1) {
          break;
        }
        SendBottomBar.a(this.a).b(1);
        continue;
      }
      if (paramString.equals(alud.a(2131714179)))
      {
        paramView = arrr.a("排序方式:\n类型", alud.a(2131714202), null);
        SendBottomBar.a(this.a).setText(paramView);
        if (SendBottomBar.a(this.a).g() == 2) {
          break;
        }
        SendBottomBar.a(this.a).b(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arvm
 * JD-Core Version:    0.7.0.1
 */