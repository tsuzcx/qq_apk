import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

class bksw
{
  static CharSequence a(@NonNull bksh parambksh)
  {
    if (parambksh.a) {
      return parambksh.toString();
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    parambksh = parambksh.toString();
    SpannableString localSpannableString = new SpannableString(parambksh);
    localSpannableString.setSpan(new ForegroundColorSpan(-65536), 0, parambksh.length(), 17);
    localSpannableStringBuilder.append(localSpannableString);
    return localSpannableStringBuilder;
  }
  
  static CharSequence a(@NonNull bksi parambksi)
  {
    if ("failed".equals(parambksi.c))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      parambksi = parambksi.toString();
      SpannableString localSpannableString = new SpannableString(parambksi);
      localSpannableString.setSpan(new ForegroundColorSpan(-65536), 0, parambksi.length(), 17);
      localSpannableStringBuilder.append(localSpannableString);
      return localSpannableStringBuilder;
    }
    return parambksi.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bksw
 * JD-Core Version:    0.7.0.1
 */