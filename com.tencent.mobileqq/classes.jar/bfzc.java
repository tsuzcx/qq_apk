import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.homework.arithmetic.ui.ArithResultView;
import com.tencent.mobileqq.troop.homework.arithmetic.ui.CheckArithHWResultFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;

public class bfzc
  implements View.OnClickListener
{
  public bfzc(CheckArithHWResultFragment paramCheckArithHWResultFragment) {}
  
  public void onClick(View paramView)
  {
    try
    {
      CheckArithHWResultFragment.a(this.a, CheckArithHWResultFragment.a(this.a).a(), CheckArithHWResultFragment.a(this.a).a());
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        znw.a("QQ.Troop.homework.CheckArithHWResultFragment//onClick toJSON error:" + localJSONException, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfzc
 * JD-Core Version:    0.7.0.1
 */