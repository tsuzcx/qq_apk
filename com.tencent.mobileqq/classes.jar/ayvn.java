import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.homework.arithmetic.ui.ArithResultView;
import com.tencent.mobileqq.troop.homework.arithmetic.ui.CheckArithHWResultFragment;
import org.json.JSONException;

public class ayvn
  implements View.OnClickListener
{
  public ayvn(CheckArithHWResultFragment paramCheckArithHWResultFragment) {}
  
  public void onClick(View paramView)
  {
    try
    {
      CheckArithHWResultFragment.a(this.a, CheckArithHWResultFragment.a(this.a).a(), CheckArithHWResultFragment.a(this.a).a());
      return;
    }
    catch (JSONException paramView)
    {
      paramView.printStackTrace();
      vkw.a("QQ.Troop.homework.CheckArithHWResultFragment//onClick toJSON error:" + paramView, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayvn
 * JD-Core Version:    0.7.0.1
 */