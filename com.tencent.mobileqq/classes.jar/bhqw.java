import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

class bhqw
  extends bhpy
{
  bhqw(Context paramContext)
  {
    super(paramContext);
    f();
  }
  
  private void f()
  {
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131559015, null);
    localLinearLayout.findViewById(2131368697).setOnClickListener(new bhqx(this));
    String str = getContext().getString(2131690338);
    TextView localTextView = (TextView)localLinearLayout.findViewById(2131378668);
    SpannableString localSpannableString = new SpannableString(str);
    localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#1B90EE")), str.length() - 3, str.length() - 1, 33);
    localSpannableString.setSpan(new bhqy(getContext(), null), str.length() - 3, str.length() - 1, 33);
    localTextView.setText(localSpannableString);
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
    a(localLinearLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhqw
 * JD-Core Version:    0.7.0.1
 */