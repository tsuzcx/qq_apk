import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;

public class apfz
  implements View.OnClickListener
{
  public apfz(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    String str1 = ajjy.a(2131648001) + aonm.b() + ajjy.a(2131648007);
    paramView = null;
    String str2 = ajjy.a(2131648019);
    if (SendBottomBar.a(this.a).g() != -1)
    {
      str1 = ajjy.a(2131648025);
      paramView = ajjy.a(2131648021);
      str2 = ajjy.a(2131648018);
    }
    this.a.a = babr.a(SendBottomBar.a(this.a), 230, paramView, str1, ajjy.a(2131648017), str2, new apga(this), new apgb(this));
    this.a.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apfz
 * JD-Core Version:    0.7.0.1
 */