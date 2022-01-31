import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class bdnu
{
  public static CharSequence a(Context paramContext, avdd paramavdd, String paramString)
  {
    if ((paramavdd == null) || (TextUtils.isEmpty(paramavdd.a()))) {
      return paramString;
    }
    String str = "#" + paramavdd.a() + "#";
    paramString = new SpannableString(str + paramString);
    if (QLog.isColorLevel()) {
      QLog.i("TopicHelper", 2, "topicName is " + str);
    }
    paramString.setSpan(new bdnv(paramContext, paramavdd), 0, str.length(), 33);
    return paramString;
  }
  
  public static CharSequence b(Context paramContext, avdd paramavdd, String paramString)
  {
    if ((paramavdd == null) || (TextUtils.isEmpty(paramavdd.a()))) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString).append("\n").append("#").append(paramavdd.a()).append("#");
    SpannableString localSpannableString = new SpannableString(localStringBuilder.toString());
    if (QLog.isColorLevel()) {
      QLog.i("TopicHelper", 2, "topicAndDescWithLine is " + localStringBuilder);
    }
    localSpannableString.setSpan(new bdnw(paramContext, paramavdd), paramString.length(), localStringBuilder.length(), 33);
    return localSpannableString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdnu
 * JD-Core Version:    0.7.0.1
 */