import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bbue
  implements View.OnClickListener
{
  public bbue(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  public void onClick(View paramView)
  {
    bdll.b(null, "dc00898", "", "", "0X800A98A", "0X800A98A", 1, 0, "0", "0", "", "");
    SignatureHistoryFragment.d(this.a, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbue
 * JD-Core Version:    0.7.0.1
 */