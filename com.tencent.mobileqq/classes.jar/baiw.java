import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class baiw
{
  public static CharSequence a(Context paramContext, aslp paramaslp, String paramString)
  {
    if ((paramaslp == null) || (TextUtils.isEmpty(paramaslp.a()))) {
      return paramString;
    }
    String str = "#" + paramaslp.a() + "#";
    paramString = new SpannableString(str + paramString);
    if (QLog.isColorLevel()) {
      QLog.i("TopicHelper", 2, "topicName is " + str);
    }
    paramString.setSpan(new baix(paramContext, paramaslp), 0, str.length(), 33);
    return paramString;
  }
  
  public static CharSequence b(Context paramContext, aslp paramaslp, String paramString)
  {
    if ((paramaslp == null) || (TextUtils.isEmpty(paramaslp.a()))) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString).append("\n").append("#").append(paramaslp.a()).append("#");
    SpannableString localSpannableString = new SpannableString(localStringBuilder.toString());
    if (QLog.isColorLevel()) {
      QLog.i("TopicHelper", 2, "topicAndDescWithLine is " + localStringBuilder);
    }
    localSpannableString.setSpan(new baiy(paramContext, paramaslp), paramString.length(), localStringBuilder.length(), 33);
    return localSpannableString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baiw
 * JD-Core Version:    0.7.0.1
 */