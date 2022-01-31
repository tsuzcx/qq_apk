import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.fragment.LangSettingFragment;

public class apoc
  implements View.OnClickListener
{
  public apoc(LangSettingFragment paramLangSettingFragment) {}
  
  public void onClick(View paramView)
  {
    LangSettingFragment.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apoc
 * JD-Core Version:    0.7.0.1
 */