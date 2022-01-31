import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.multiaio.MultiAIOFragment;

public class aufw
  implements View.OnClickListener
{
  public aufw(MultiAIOFragment paramMultiAIOFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = (TextView)MultiAIOFragment.a(this.a).findViewById(2131379023);
    augz.a -= 1;
    if (augz.a < 1) {
      augz.a = 1;
    }
    paramView.setText(alpo.a(2131707373) + augz.a);
    MultiAIOFragment.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aufw
 * JD-Core Version:    0.7.0.1
 */