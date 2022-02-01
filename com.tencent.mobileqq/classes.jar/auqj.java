import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;

public class auqj
  implements blja
{
  public auqj(SendBottomBar paramSendBottomBar) {}
  
  public void a(View paramView, int paramInt, String paramString)
  {
    if (paramString.equals(anzj.a(2131712658)))
    {
      paramView = aunj.a("排序方式:\n时间", anzj.a(2131712667), null);
      SendBottomBar.a(this.a).setText(paramView);
      if (SendBottomBar.a(this.a).g() == 0) {
        return;
      }
      SendBottomBar.a(this.a).d(0);
    }
    for (;;)
    {
      this.a.a.dismiss();
      return;
      if (paramString.equals(anzj.a(2131712687)))
      {
        paramView = aunj.a("排序方式:\n大小", anzj.a(2131712661), null);
        SendBottomBar.a(this.a).setText(paramView);
        if (SendBottomBar.a(this.a).g() == 1) {
          break;
        }
        SendBottomBar.a(this.a).d(1);
        continue;
      }
      if (paramString.equals(anzj.a(2131712660)))
      {
        paramView = aunj.a("排序方式:\n类型", anzj.a(2131712683), null);
        SendBottomBar.a(this.a).setText(paramView);
        if (SendBottomBar.a(this.a).g() == 2) {
          break;
        }
        SendBottomBar.a(this.a).d(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auqj
 * JD-Core Version:    0.7.0.1
 */