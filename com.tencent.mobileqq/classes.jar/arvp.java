import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;

public class arvp
  implements View.OnClickListener
{
  public arvp(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    String str1 = alud.a(2131714183) + arbs.b() + alud.a(2131714189);
    paramView = null;
    String str2 = alud.a(2131714201);
    if (SendBottomBar.a(this.a).g() != -1)
    {
      str1 = alud.a(2131714207);
      paramView = alud.a(2131714203);
      str2 = alud.a(2131714200);
    }
    this.a.a = bdgm.a(SendBottomBar.a(this.a), 230, paramView, str1, alud.a(2131714199), str2, new arvq(this), new arvr(this));
    this.a.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arvp
 * JD-Core Version:    0.7.0.1
 */