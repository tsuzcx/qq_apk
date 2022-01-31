import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.fragment.AppletsSettingFragment;

public class asfb
  implements View.OnClickListener
{
  public asfb(AppletsSettingFragment paramAppletsSettingFragment) {}
  
  public void onClick(View paramView)
  {
    if (AppletsSettingFragment.a(this.a))
    {
      this.a.a();
      return;
    }
    paramView = this.a;
    if (!AppletsSettingFragment.a(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      AppletsSettingFragment.a(paramView, bool);
      AppletsSettingFragment.a(this.a, AppletsSettingFragment.a(this.a));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asfb
 * JD-Core Version:    0.7.0.1
 */