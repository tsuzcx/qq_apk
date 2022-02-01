import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

class bnfh
{
  static CharSequence a(@NonNull bnes parambnes)
  {
    if (parambnes.a) {
      return parambnes.toString();
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    parambnes = parambnes.toString();
    SpannableString localSpannableString = new SpannableString(parambnes);
    localSpannableString.setSpan(new ForegroundColorSpan(-65536), 0, parambnes.length(), 17);
    localSpannableStringBuilder.append(localSpannableString);
    return localSpannableStringBuilder;
  }
  
  static CharSequence a(@NonNull bnet parambnet)
  {
    if ("failed".equals(parambnet.c))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      parambnet = parambnet.toString();
      SpannableString localSpannableString = new SpannableString(parambnet);
      localSpannableString.setSpan(new ForegroundColorSpan(-65536), 0, parambnet.length(), 17);
      localSpannableStringBuilder.append(localSpannableString);
      return localSpannableStringBuilder;
    }
    return parambnet.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnfh
 * JD-Core Version:    0.7.0.1
 */