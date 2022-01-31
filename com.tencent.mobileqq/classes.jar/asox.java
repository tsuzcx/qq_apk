import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.multiaio.MultiAIOFragment;

public class asox
  implements View.OnClickListener
{
  public asox(MultiAIOFragment paramMultiAIOFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = (TextView)MultiAIOFragment.a(this.a).findViewById(2131378412);
    asqa.a -= 1;
    if (asqa.a < 1) {
      asqa.a = 1;
    }
    paramView.setText(ajya.a(2131707001) + asqa.a);
    MultiAIOFragment.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asox
 * JD-Core Version:    0.7.0.1
 */