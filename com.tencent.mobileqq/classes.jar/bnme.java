import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

class bnme
{
  static CharSequence a(@NonNull bnlp parambnlp)
  {
    if (parambnlp.a) {
      return parambnlp.toString();
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    parambnlp = parambnlp.toString();
    SpannableString localSpannableString = new SpannableString(parambnlp);
    localSpannableString.setSpan(new ForegroundColorSpan(-65536), 0, parambnlp.length(), 17);
    localSpannableStringBuilder.append(localSpannableString);
    return localSpannableStringBuilder;
  }
  
  static CharSequence a(@NonNull bnlq parambnlq)
  {
    if ("failed".equals(parambnlq.c))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      parambnlq = parambnlq.toString();
      SpannableString localSpannableString = new SpannableString(parambnlq);
      localSpannableString.setSpan(new ForegroundColorSpan(-65536), 0, parambnlq.length(), 17);
      localSpannableStringBuilder.append(localSpannableString);
      return localSpannableStringBuilder;
    }
    return parambnlq.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnme
 * JD-Core Version:    0.7.0.1
 */