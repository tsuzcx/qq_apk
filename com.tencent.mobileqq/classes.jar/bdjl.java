import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class bdjl
{
  public static CharSequence a(Context paramContext, auyu paramauyu, String paramString)
  {
    if ((paramauyu == null) || (TextUtils.isEmpty(paramauyu.a()))) {
      return paramString;
    }
    String str = "#" + paramauyu.a() + "#";
    paramString = new SpannableString(str + paramString);
    if (QLog.isColorLevel()) {
      QLog.i("TopicHelper", 2, "topicName is " + str);
    }
    paramString.setSpan(new bdjm(paramContext, paramauyu), 0, str.length(), 33);
    return paramString;
  }
  
  public static CharSequence b(Context paramContext, auyu paramauyu, String paramString)
  {
    if ((paramauyu == null) || (TextUtils.isEmpty(paramauyu.a()))) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString).append("\n").append("#").append(paramauyu.a()).append("#");
    SpannableString localSpannableString = new SpannableString(localStringBuilder.toString());
    if (QLog.isColorLevel()) {
      QLog.i("TopicHelper", 2, "topicAndDescWithLine is " + localStringBuilder);
    }
    localSpannableString.setSpan(new bdjn(paramContext, paramauyu), paramString.length(), localStringBuilder.length(), 33);
    return localSpannableString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdjl
 * JD-Core Version:    0.7.0.1
 */