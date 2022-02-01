import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;

public class augy
  implements bkzr
{
  public augy(SendBottomBar paramSendBottomBar) {}
  
  public void a(View paramView, int paramInt, String paramString)
  {
    if (paramString.equals(anvx.a(2131713237)))
    {
      paramView = auea.a("排序方式:\n时间", anvx.a(2131713246), null);
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
      if (paramString.equals(anvx.a(2131713266)))
      {
        paramView = auea.a("排序方式:\n大小", anvx.a(2131713240), null);
        SendBottomBar.a(this.a).setText(paramView);
        if (SendBottomBar.a(this.a).g() == 1) {
          break;
        }
        SendBottomBar.a(this.a).d(1);
        continue;
      }
      if (paramString.equals(anvx.a(2131713239)))
      {
        paramView = auea.a("排序方式:\n类型", anvx.a(2131713262), null);
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
 * Qualified Name:     augy
 * JD-Core Version:    0.7.0.1
 */