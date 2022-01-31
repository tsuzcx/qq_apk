import android.graphics.Color;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import android.widget.TextView;

class bldh
  implements TextWatcher
{
  bldh(bldg parambldg) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i = 0;
    int j = paramEditable.length();
    paramEditable = String.format("%d/%d", new Object[] { Integer.valueOf(j), Integer.valueOf(bldg.a(this.a)) });
    if (j > bldg.a(this.a))
    {
      paramEditable = new SpannableString(paramEditable);
      int k = String.valueOf(j).length();
      paramEditable.setSpan(new ForegroundColorSpan(Color.parseColor("#12b7f5")), 0, k, 33);
      bldg.a(this.a).setText(paramEditable);
      paramEditable = bldg.a(this.a);
      if (j <= 0) {
        break label132;
      }
    }
    for (;;)
    {
      paramEditable.setVisibility(i);
      return;
      bldg.a(this.a).setText(paramEditable);
      break;
      label132:
      i = 8;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bldh
 * JD-Core Version:    0.7.0.1
 */