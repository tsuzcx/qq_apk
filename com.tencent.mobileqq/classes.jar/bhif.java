import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class bhif
{
  public static CharSequence a(Context paramContext, axwq paramaxwq, String paramString)
  {
    if ((paramaxwq == null) || (TextUtils.isEmpty(paramaxwq.a()))) {
      return paramString;
    }
    String str = "#" + paramaxwq.a() + "#";
    paramString = new SpannableString(str + paramString);
    if (QLog.isColorLevel()) {
      QLog.i("TopicHelper", 2, "topicName is " + str);
    }
    paramString.setSpan(new bhig(paramContext, paramaxwq), 0, str.length(), 33);
    return paramString;
  }
  
  public static CharSequence b(Context paramContext, axwq paramaxwq, String paramString)
  {
    if ((paramaxwq == null) || (TextUtils.isEmpty(paramaxwq.a()))) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString).append("\n").append("#").append(paramaxwq.a()).append("#");
    SpannableString localSpannableString = new SpannableString(localStringBuilder.toString());
    if (QLog.isColorLevel()) {
      QLog.i("TopicHelper", 2, "topicAndDescWithLine is " + localStringBuilder);
    }
    localSpannableString.setSpan(new bhih(paramContext, paramaxwq), paramString.length(), localStringBuilder.length(), 33);
    return localSpannableString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhif
 * JD-Core Version:    0.7.0.1
 */