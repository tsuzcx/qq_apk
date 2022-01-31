import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

class bkxd
{
  static CharSequence a(@NonNull bkwo parambkwo)
  {
    if (parambkwo.a) {
      return parambkwo.toString();
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    parambkwo = parambkwo.toString();
    SpannableString localSpannableString = new SpannableString(parambkwo);
    localSpannableString.setSpan(new ForegroundColorSpan(-65536), 0, parambkwo.length(), 17);
    localSpannableStringBuilder.append(localSpannableString);
    return localSpannableStringBuilder;
  }
  
  static CharSequence a(@NonNull bkwp parambkwp)
  {
    if ("failed".equals(parambkwp.c))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      parambkwp = parambkwp.toString();
      SpannableString localSpannableString = new SpannableString(parambkwp);
      localSpannableString.setSpan(new ForegroundColorSpan(-65536), 0, parambkwp.length(), 17);
      localSpannableStringBuilder.append(localSpannableString);
      return localSpannableStringBuilder;
    }
    return parambkwp.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkxd
 * JD-Core Version:    0.7.0.1
 */