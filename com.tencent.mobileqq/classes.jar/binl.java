import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

class binl
{
  static CharSequence a(@NonNull bimw parambimw)
  {
    if (parambimw.a) {
      return parambimw.toString();
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    parambimw = parambimw.toString();
    SpannableString localSpannableString = new SpannableString(parambimw);
    localSpannableString.setSpan(new ForegroundColorSpan(-65536), 0, parambimw.length(), 17);
    localSpannableStringBuilder.append(localSpannableString);
    return localSpannableStringBuilder;
  }
  
  static CharSequence a(@NonNull bimx parambimx)
  {
    if ("failed".equals(parambimx.c))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      parambimx = parambimx.toString();
      SpannableString localSpannableString = new SpannableString(parambimx);
      localSpannableString.setSpan(new ForegroundColorSpan(-65536), 0, parambimx.length(), 17);
      localSpannableStringBuilder.append(localSpannableString);
      return localSpannableStringBuilder;
    }
    return parambimx.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     binl
 * JD-Core Version:    0.7.0.1
 */