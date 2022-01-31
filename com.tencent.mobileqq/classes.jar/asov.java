import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.multiaio.MultiAIOFragment;

public class asov
  implements View.OnClickListener
{
  public asov(MultiAIOFragment paramMultiAIOFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = (TextView)MultiAIOFragment.a(this.a).findViewById(2131378407);
    aspy.a -= 1;
    if (aspy.a < 1) {
      aspy.a = 1;
    }
    paramView.setText(ajyc.a(2131706990) + aspy.a);
    MultiAIOFragment.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asov
 * JD-Core Version:    0.7.0.1
 */