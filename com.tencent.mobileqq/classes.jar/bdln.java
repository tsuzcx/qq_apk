import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

class bdln
  implements View.OnClickListener
{
  bdln(bdll parambdll) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.a.a) {
      return;
    }
    if (this.a.a != null) {
      this.a.a.findViewById(2131369520).setVisibility(8);
    }
    TextView localTextView = (TextView)paramView.findViewById(2131369521);
    this.a.a(localTextView.getText().toString());
    paramView.findViewById(2131369520).setVisibility(0);
    this.a.a = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdln
 * JD-Core Version:    0.7.0.1
 */