import android.graphics.Color;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import android.widget.TextView;

class boyl
  implements TextWatcher
{
  boyl(boyk paramboyk) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i = 0;
    int j = paramEditable.length();
    paramEditable = String.format("%d/%d", new Object[] { Integer.valueOf(j), Integer.valueOf(boyk.a(this.a)) });
    if (j > boyk.a(this.a))
    {
      paramEditable = new SpannableString(paramEditable);
      int k = String.valueOf(j).length();
      paramEditable.setSpan(new ForegroundColorSpan(Color.parseColor("#12b7f5")), 0, k, 33);
      boyk.a(this.a).setText(paramEditable);
      paramEditable = boyk.a(this.a);
      if (j <= 0) {
        break label132;
      }
    }
    for (;;)
    {
      paramEditable.setVisibility(i);
      return;
      boyk.a(this.a).setText(paramEditable);
      break;
      label132:
      i = 8;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boyl
 * JD-Core Version:    0.7.0.1
 */