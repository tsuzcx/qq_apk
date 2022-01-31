import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;

public class apyb
  implements bfpi
{
  public apyb(SendBottomBar paramSendBottomBar) {}
  
  public void a(View paramView, int paramInt, String paramString)
  {
    if (paramString.equals(ajya.a(2131713793)))
    {
      paramView = apug.a("排序方式:\n时间", ajya.a(2131713802), null);
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
      if (paramString.equals(ajya.a(2131713822)))
      {
        paramView = apug.a("排序方式:\n大小", ajya.a(2131713796), null);
        SendBottomBar.a(this.a).setText(paramView);
        if (SendBottomBar.a(this.a).g() == 1) {
          break;
        }
        SendBottomBar.a(this.a).b(1);
        continue;
      }
      if (paramString.equals(ajya.a(2131713795)))
      {
        paramView = apug.a("排序方式:\n类型", ajya.a(2131713818), null);
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
 * Qualified Name:     apyb
 * JD-Core Version:    0.7.0.1
 */