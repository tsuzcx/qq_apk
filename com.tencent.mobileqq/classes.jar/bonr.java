import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

class bonr
{
  static CharSequence a(@NonNull bonc parambonc)
  {
    if (parambonc.a) {
      return parambonc.toString();
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    parambonc = parambonc.toString();
    SpannableString localSpannableString = new SpannableString(parambonc);
    localSpannableString.setSpan(new ForegroundColorSpan(-65536), 0, parambonc.length(), 17);
    localSpannableStringBuilder.append(localSpannableString);
    return localSpannableStringBuilder;
  }
  
  static CharSequence a(@NonNull bond parambond)
  {
    if ("failed".equals(parambond.c))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      parambond = parambond.toString();
      SpannableString localSpannableString = new SpannableString(parambond);
      localSpannableString.setSpan(new ForegroundColorSpan(-65536), 0, parambond.length(), 17);
      localSpannableStringBuilder.append(localSpannableString);
      return localSpannableStringBuilder;
    }
    return parambond.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bonr
 * JD-Core Version:    0.7.0.1
 */