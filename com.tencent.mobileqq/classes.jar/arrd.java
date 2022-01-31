import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;

public class arrd
  implements bhqe
{
  public arrd(SendBottomBar paramSendBottomBar) {}
  
  public void a(View paramView, int paramInt, String paramString)
  {
    if (paramString.equals(alpo.a(2131714165)))
    {
      paramView = arni.a("排序方式:\n时间", alpo.a(2131714174), null);
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
      if (paramString.equals(alpo.a(2131714194)))
      {
        paramView = arni.a("排序方式:\n大小", alpo.a(2131714168), null);
        SendBottomBar.a(this.a).setText(paramView);
        if (SendBottomBar.a(this.a).g() == 1) {
          break;
        }
        SendBottomBar.a(this.a).b(1);
        continue;
      }
      if (paramString.equals(alpo.a(2131714167)))
      {
        paramView = arni.a("排序方式:\n类型", alpo.a(2131714190), null);
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
 * Qualified Name:     arrd
 * JD-Core Version:    0.7.0.1
 */