import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;

public class arrg
  implements View.OnClickListener
{
  public arrg(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    String str1 = alpo.a(2131714171) + aqxj.b() + alpo.a(2131714177);
    paramView = null;
    String str2 = alpo.a(2131714189);
    if (SendBottomBar.a(this.a).g() != -1)
    {
      str1 = alpo.a(2131714195);
      paramView = alpo.a(2131714191);
      str2 = alpo.a(2131714188);
    }
    this.a.a = bdcd.a(SendBottomBar.a(this.a), 230, paramView, str1, alpo.a(2131714187), str2, new arrh(this), new arri(this));
    this.a.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arrg
 * JD-Core Version:    0.7.0.1
 */