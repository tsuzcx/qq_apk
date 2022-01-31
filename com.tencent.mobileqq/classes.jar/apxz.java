import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;

public class apxz
  implements bfor
{
  public apxz(SendBottomBar paramSendBottomBar) {}
  
  public void a(View paramView, int paramInt, String paramString)
  {
    if (paramString.equals(ajyc.a(2131713782)))
    {
      paramView = apue.a("排序方式:\n时间", ajyc.a(2131713791), null);
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
      if (paramString.equals(ajyc.a(2131713811)))
      {
        paramView = apue.a("排序方式:\n大小", ajyc.a(2131713785), null);
        SendBottomBar.a(this.a).setText(paramView);
        if (SendBottomBar.a(this.a).g() == 1) {
          break;
        }
        SendBottomBar.a(this.a).b(1);
        continue;
      }
      if (paramString.equals(ajyc.a(2131713784)))
      {
        paramView = apue.a("排序方式:\n类型", ajyc.a(2131713807), null);
        SendBottomBar.a(this.a).setText(paramView);
        if (SendBottomBar.a(this.a).g() == 2) {
          break;
        }
        SendBottomBar.a(this.a).b(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apxz
 * JD-Core Version:    0.7.0.1
 */