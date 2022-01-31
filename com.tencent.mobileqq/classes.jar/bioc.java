import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

class bioc
{
  static CharSequence a(@NonNull binn parambinn)
  {
    if (parambinn.a) {
      return parambinn.toString();
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    parambinn = parambinn.toString();
    SpannableString localSpannableString = new SpannableString(parambinn);
    localSpannableString.setSpan(new ForegroundColorSpan(-65536), 0, parambinn.length(), 17);
    localSpannableStringBuilder.append(localSpannableString);
    return localSpannableStringBuilder;
  }
  
  static CharSequence a(@NonNull bino parambino)
  {
    if ("failed".equals(parambino.c))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      parambino = parambino.toString();
      SpannableString localSpannableString = new SpannableString(parambino);
      localSpannableString.setSpan(new ForegroundColorSpan(-65536), 0, parambino.length(), 17);
      localSpannableStringBuilder.append(localSpannableString);
      return localSpannableStringBuilder;
    }
    return parambino.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bioc
 * JD-Core Version:    0.7.0.1
 */