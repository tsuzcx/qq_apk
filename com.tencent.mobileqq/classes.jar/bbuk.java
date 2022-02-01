import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class bbuk
  implements View.OnClickListener
{
  public bbuk(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
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
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (SignatureHistoryFragment.a(this.a).size() >= 200)
      {
        this.a.a(1, 2131718902);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbuk
 * JD-Core Version:    0.7.0.1
 */