import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class bgsw
{
  public static CharSequence a(Context paramContext, axkm paramaxkm, String paramString)
  {
    if ((paramaxkm == null) || (TextUtils.isEmpty(paramaxkm.a()))) {
      return paramString;
    }
    String str = "#" + paramaxkm.a() + "#";
    paramString = new SpannableString(str + paramString);
    if (QLog.isColorLevel()) {
      QLog.i("TopicHelper", 2, "topicName is " + str);
    }
    paramString.setSpan(new bgsx(paramContext, paramaxkm), 0, str.length(), 33);
    return paramString;
  }
  
  public static CharSequence b(Context paramContext, axkm paramaxkm, String paramString)
  {
    if ((paramaxkm == null) || (TextUtils.isEmpty(paramaxkm.a()))) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString).append("\n").append("#").append(paramaxkm.a()).append("#");
    SpannableString localSpannableString = new SpannableString(localStringBuilder.toString());
    if (QLog.isColorLevel()) {
      QLog.i("TopicHelper", 2, "topicAndDescWithLine is " + localStringBuilder);
    }
    localSpannableString.setSpan(new bgsy(paramContext, paramaxkm), paramString.length(), localStringBuilder.length(), 33);
    return localSpannableString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgsw
 * JD-Core Version:    0.7.0.1
 */