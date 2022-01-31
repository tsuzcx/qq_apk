import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.multiaio.MultiAIOFragment;

public class aukf
  implements View.OnClickListener
{
  public aukf(MultiAIOFragment paramMultiAIOFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = (TextView)MultiAIOFragment.a(this.a).findViewById(2131379081);
    auli.a -= 1;
    if (auli.a < 1) {
      auli.a = 1;
    }
    paramView.setText(alud.a(2131707385) + auli.a);
    MultiAIOFragment.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aukf
 * JD-Core Version:    0.7.0.1
 */