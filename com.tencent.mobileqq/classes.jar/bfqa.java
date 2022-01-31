import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

class bfqa
  extends bfpc
{
  bfqa(Context paramContext)
  {
    super(paramContext);
    f();
  }
  
  private void f()
  {
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131558978, null);
    localLinearLayout.findViewById(2131368507).setOnClickListener(new bfqb(this));
    String str = getContext().getString(2131690287);
    TextView localTextView = (TextView)localLinearLayout.findViewById(2131378112);
    SpannableString localSpannableString = new SpannableString(str);
    localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#1B90EE")), str.length() - 3, str.length() - 1, 33);
    localSpannableString.setSpan(new bfqc(getContext(), null), str.length() - 3, str.length() - 1, 33);
    localTextView.setText(localSpannableString);
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
    a(localLinearLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfqa
 * JD-Core Version:    0.7.0.1
 */