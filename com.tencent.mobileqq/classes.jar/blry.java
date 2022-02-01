import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

class blry
{
  static CharSequence a(@NonNull blrj paramblrj)
  {
    if (paramblrj.a) {
      return paramblrj.toString();
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    paramblrj = paramblrj.toString();
    SpannableString localSpannableString = new SpannableString(paramblrj);
    localSpannableString.setSpan(new ForegroundColorSpan(-65536), 0, paramblrj.length(), 17);
    localSpannableStringBuilder.append(localSpannableString);
    return localSpannableStringBuilder;
  }
  
  static CharSequence a(@NonNull blrk paramblrk)
  {
    if ("failed".equals(paramblrk.c))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      paramblrk = paramblrk.toString();
      SpannableString localSpannableString = new SpannableString(paramblrk);
      localSpannableString.setSpan(new ForegroundColorSpan(-65536), 0, paramblrk.length(), 17);
      localSpannableStringBuilder.append(localSpannableString);
      return localSpannableStringBuilder;
    }
    return paramblrk.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blry
 * JD-Core Version:    0.7.0.1
 */