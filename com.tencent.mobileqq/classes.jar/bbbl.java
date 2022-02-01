import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bbbl
  implements View.OnClickListener
{
  public bbbl(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  public void onClick(View paramView)
  {
    bcst.b(null, "dc00898", "", "", "0X800A98A", "0X800A98A", 1, 0, "0", "0", "", "");
    SignatureHistoryFragment.d(this.a, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbbl
 * JD-Core Version:    0.7.0.1
 */