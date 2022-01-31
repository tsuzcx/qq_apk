import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;

public class apfw
  implements begx
{
  public apfw(SendBottomBar paramSendBottomBar) {}
  
  public void a(View paramView, int paramInt, String paramString)
  {
    if (paramString.equals(ajjy.a(2131647995)))
    {
      paramView = apck.a("排序方式:\n时间", ajjy.a(2131648004), null);
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
      if (paramString.equals(ajjy.a(2131648024)))
      {
        paramView = apck.a("排序方式:\n大小", ajjy.a(2131647998), null);
        SendBottomBar.a(this.a).setText(paramView);
        if (SendBottomBar.a(this.a).g() == 1) {
          break;
        }
        SendBottomBar.a(this.a).b(1);
        continue;
      }
      if (paramString.equals(ajjy.a(2131647997)))
      {
        paramView = apck.a("排序方式:\n类型", ajjy.a(2131648020), null);
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
 * Qualified Name:     apfw
 * JD-Core Version:    0.7.0.1
 */