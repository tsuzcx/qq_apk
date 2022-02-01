import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bgqp
  implements View.OnClickListener
{
  bgqp(bgqn parambgqn) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.a.a) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.a != null) {
        this.a.a.findViewById(2131369915).setVisibility(8);
      }
      TextView localTextView = (TextView)paramView.findViewById(2131369916);
      this.a.a(localTextView.getText().toString());
      paramView.findViewById(2131369915).setVisibility(0);
      this.a.a = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bgqp
 * JD-Core Version:    0.7.0.1
 */