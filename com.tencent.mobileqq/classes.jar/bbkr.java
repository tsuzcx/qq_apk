import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class bbkr
{
  public static CharSequence a(Context paramContext, athv paramathv, String paramString)
  {
    if ((paramathv == null) || (TextUtils.isEmpty(paramathv.a()))) {
      return paramString;
    }
    String str = "#" + paramathv.a() + "#";
    paramString = new SpannableString(str + paramString);
    if (QLog.isColorLevel()) {
      QLog.i("TopicHelper", 2, "topicName is " + str);
    }
    paramString.setSpan(new bbks(paramContext, paramathv), 0, str.length(), 33);
    return paramString;
  }
  
  public static CharSequence b(Context paramContext, athv paramathv, String paramString)
  {
    if ((paramathv == null) || (TextUtils.isEmpty(paramathv.a()))) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString).append("\n").append("#").append(paramathv.a()).append("#");
    SpannableString localSpannableString = new SpannableString(localStringBuilder.toString());
    if (QLog.isColorLevel()) {
      QLog.i("TopicHelper", 2, "topicAndDescWithLine is " + localStringBuilder);
    }
    localSpannableString.setSpan(new bbkt(paramContext, paramathv), paramString.length(), localStringBuilder.length(), 33);
    return localSpannableString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbkr
 * JD-Core Version:    0.7.0.1
 */