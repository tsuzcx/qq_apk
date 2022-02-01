import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;

public class atcr
  implements bjof
{
  public atcr(SendBottomBar paramSendBottomBar) {}
  
  public void a(View paramView, int paramInt, String paramString)
  {
    if (paramString.equals(amtj.a(2131712890)))
    {
      paramView = aszt.a("排序方式:\n时间", amtj.a(2131712899), null);
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
      if (paramString.equals(amtj.a(2131712919)))
      {
        paramView = aszt.a("排序方式:\n大小", amtj.a(2131712893), null);
        SendBottomBar.a(this.a).setText(paramView);
        if (SendBottomBar.a(this.a).g() == 1) {
          break;
        }
        SendBottomBar.a(this.a).d(1);
        continue;
      }
      if (paramString.equals(amtj.a(2131712892)))
      {
        paramView = aszt.a("排序方式:\n类型", amtj.a(2131712915), null);
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
 * Qualified Name:     atcr
 * JD-Core Version:    0.7.0.1
 */