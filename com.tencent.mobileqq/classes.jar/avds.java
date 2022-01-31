import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import java.util.ArrayList;

public class avds
  implements View.OnClickListener
{
  public avds(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  public void onClick(View paramView)
  {
    String str = (String)paramView.getTag();
    if (SignatureHistoryFragment.a(this.a).contains(str))
    {
      SignatureHistoryFragment.a(this.a).remove(str);
      ((CheckBox)paramView).setChecked(false);
    }
    for (;;)
    {
      SignatureHistoryFragment.b(this.a, false);
      return;
      if (SignatureHistoryFragment.a(this.a).size() >= 200)
      {
        this.a.a(1, 2131653756);
        ((CheckBox)paramView).setChecked(false);
      }
      else
      {
        SignatureHistoryFragment.a(this.a).add(str);
        ((CheckBox)paramView).setChecked(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avds
 * JD-Core Version:    0.7.0.1
 */