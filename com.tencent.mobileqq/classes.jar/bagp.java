import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

class bagp
  implements View.OnClickListener
{
  bagp(bagn parambagn) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.a.a) {
      return;
    }
    if (this.a.a != null) {
      this.a.a.findViewById(2131303597).setVisibility(8);
    }
    TextView localTextView = (TextView)paramView.findViewById(2131303598);
    this.a.a(localTextView.getText().toString());
    paramView.findViewById(2131303597).setVisibility(0);
    this.a.a = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bagp
 * JD-Core Version:    0.7.0.1
 */