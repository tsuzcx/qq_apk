import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.multiaio.MultiAIOFragment;

public class arss
  implements View.OnClickListener
{
  public arss(MultiAIOFragment paramMultiAIOFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = (TextView)MultiAIOFragment.a(this.a).findViewById(2131312583);
    artu.a += 1;
    paramView.setText(ajjy.a(2131641204) + artu.a);
    MultiAIOFragment.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arss
 * JD-Core Version:    0.7.0.1
 */