import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class bfzn
{
  public static CharSequence a(Context paramContext, awqo paramawqo, String paramString)
  {
    if ((paramawqo == null) || (TextUtils.isEmpty(paramawqo.a()))) {
      return paramString;
    }
    String str = "#" + paramawqo.a() + "#";
    paramString = new SpannableString(str + paramString);
    if (QLog.isColorLevel()) {
      QLog.i("TopicHelper", 2, "topicName is " + str);
    }
    paramString.setSpan(new bfzo(paramContext, paramawqo), 0, str.length(), 33);
    return paramString;
  }
  
  public static CharSequence b(Context paramContext, awqo paramawqo, String paramString)
  {
    if ((paramawqo == null) || (TextUtils.isEmpty(paramawqo.a()))) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString).append("\n").append("#").append(paramawqo.a()).append("#");
    SpannableString localSpannableString = new SpannableString(localStringBuilder.toString());
    if (QLog.isColorLevel()) {
      QLog.i("TopicHelper", 2, "topicAndDescWithLine is " + localStringBuilder);
    }
    localSpannableString.setSpan(new bfzp(paramContext, paramawqo), paramString.length(), localStringBuilder.length(), 33);
    return localSpannableString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfzn
 * JD-Core Version:    0.7.0.1
 */