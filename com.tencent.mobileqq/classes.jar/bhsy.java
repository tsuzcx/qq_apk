import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class bhsy
{
  public static CharSequence a(Context paramContext, aydg paramaydg, String paramString)
  {
    if ((paramaydg == null) || (TextUtils.isEmpty(paramaydg.a()))) {
      return paramString;
    }
    String str = "#" + paramaydg.a() + "#";
    paramString = new SpannableString(str + paramString);
    if (QLog.isColorLevel()) {
      QLog.i("TopicHelper", 2, "topicName is " + str);
    }
    paramString.setSpan(new bhsz(paramContext, paramaydg), 0, str.length(), 33);
    return paramString;
  }
  
  public static CharSequence b(Context paramContext, aydg paramaydg, String paramString)
  {
    if ((paramaydg == null) || (TextUtils.isEmpty(paramaydg.a()))) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString).append("\n").append("#").append(paramaydg.a()).append("#");
    SpannableString localSpannableString = new SpannableString(localStringBuilder.toString());
    if (QLog.isColorLevel()) {
      QLog.i("TopicHelper", 2, "topicAndDescWithLine is " + localStringBuilder);
    }
    localSpannableString.setSpan(new bhta(paramContext, paramaydg), paramString.length(), localStringBuilder.length(), 33);
    return localSpannableString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhsy
 * JD-Core Version:    0.7.0.1
 */