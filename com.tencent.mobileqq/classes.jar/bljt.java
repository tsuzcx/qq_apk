import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

class bljt
  extends blir
{
  bljt(Context paramContext)
  {
    super(paramContext);
    f();
  }
  
  private void f()
  {
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131559081, null);
    localLinearLayout.findViewById(2131369134).setOnClickListener(new blju(this));
    String str = getContext().getString(2131690180);
    TextView localTextView = (TextView)localLinearLayout.findViewById(2131379761);
    SpannableString localSpannableString = new SpannableString(str);
    localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#1B90EE")), str.length() - 3, str.length() - 1, 33);
    localSpannableString.setSpan(new bljv(getContext(), null), str.length() - 3, str.length() - 1, 33);
    localTextView.setText(localSpannableString);
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
    a(localLinearLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bljt
 * JD-Core Version:    0.7.0.1
 */