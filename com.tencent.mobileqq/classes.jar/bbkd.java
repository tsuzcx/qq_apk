import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class bbkd
{
  public static CharSequence a(Context paramContext, atht paramatht, String paramString)
  {
    if ((paramatht == null) || (TextUtils.isEmpty(paramatht.a()))) {
      return paramString;
    }
    String str = "#" + paramatht.a() + "#";
    paramString = new SpannableString(str + paramString);
    if (QLog.isColorLevel()) {
      QLog.i("TopicHelper", 2, "topicName is " + str);
    }
    paramString.setSpan(new bbke(paramContext, paramatht), 0, str.length(), 33);
    return paramString;
  }
  
  public static CharSequence b(Context paramContext, atht paramatht, String paramString)
  {
    if ((paramatht == null) || (TextUtils.isEmpty(paramatht.a()))) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString).append("\n").append("#").append(paramatht.a()).append("#");
    SpannableString localSpannableString = new SpannableString(localStringBuilder.toString());
    if (QLog.isColorLevel()) {
      QLog.i("TopicHelper", 2, "topicAndDescWithLine is " + localStringBuilder);
    }
    localSpannableString.setSpan(new bbkf(paramContext, paramatht), paramString.length(), localStringBuilder.length(), 33);
    return localSpannableString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbkd
 * JD-Core Version:    0.7.0.1
 */