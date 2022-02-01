import android.content.Intent;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class ayuy
{
  public static void a(BaseActivity paramBaseActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousViewHelper", 0, "jumpToReqFriendAskQuestion()");
    }
    ayuz.a.a(paramBaseActivity, true);
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramBaseActivity, QQBrowserActivity.class);
    String str = String.format("https://ti.qq.com/v2/anonymous/answer?_wv=16777218&_wwv=129&uin=%s&from=%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    localIntent.putExtra("url", str);
    paramBaseActivity.startActivityForResult(localIntent, 4660);
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousViewHelper", 0, String.format("jumpToQuestionListAndAnswer() uin=%s from=%d url =%s", new Object[] { paramString, Integer.valueOf(paramInt), str }));
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, long paramLong)
  {
    a(paramBaseActivity, paramString1, paramString2, "", 7, paramLong);
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    Intent localIntent = new Intent(paramBaseActivity, QQBrowserActivity.class);
    String str = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      str = "0";
    }
    paramString3 = String.format("https://ti.qq.com/v2/anonymous/detail?_wv=16777218&_wwv=129&uin=%s&qid=%s&cid=%s&from=%d&qtime=%d", new Object[] { paramString1, paramString2, str, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    localIntent.putExtra("url", paramString3);
    paramBaseActivity.startActivityForResult(localIntent, 4660);
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousViewHelper", 0, String.format("jumpToAnonymousDetail() uin=%s qId=%s cId=%s form=%d url =%s", new Object[] { paramString1, paramString2, str, Integer.valueOf(paramInt), paramString3 }));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ayup paramayup)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousViewHelper", 0, "before onClickLike() question.mPraised = " + paramayup.b);
    }
    paramQQAppInterface = (ayur)paramQQAppInterface.getBusinessHandler(189);
    if (!paramayup.b) {
      bool = true;
    }
    paramQQAppInterface.a(paramayup, bool);
  }
  
  public static void b(BaseActivity paramBaseActivity, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramBaseActivity, QQBrowserActivity.class);
    String str = String.format("https://ti.qq.com/v2/anonymous/question?_wv=16777218&_wwv=129&uin=%s&from=%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    localIntent.putExtra("url", str);
    paramBaseActivity.startActivityForResult(localIntent, 4660);
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousViewHelper", 0, String.format("jumpToAskQuestion() uin=%s from=%d url =%s", new Object[] { paramString, Integer.valueOf(paramInt), str }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayuy
 * JD-Core Version:    0.7.0.1
 */