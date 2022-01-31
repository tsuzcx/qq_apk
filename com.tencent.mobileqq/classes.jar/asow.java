import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.AudioHelper;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class asow
{
  public static void a(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, MessageRecord paramMessageRecord)
  {
    a(paramContext, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramMessageRecord, null);
  }
  
  public static void a(Context paramContext, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, MessageRecord paramMessageRecord, String paramString2)
  {
    if (wij.b(paramString1))
    {
      paramMessageRecord = new Intent(paramContext, JoinDiscussionActivity.class);
      int i = paramString1.indexOf("dc/ft?k=");
      if (i > 0) {
        paramMessageRecord.putExtra("innerSig", paramString1.substring("dc/ft?k=".length() + i));
      }
      for (;;)
      {
        paramContext.startActivity(paramMessageRecord);
        return;
        paramMessageRecord.putExtra("innerSig", paramString1);
      }
    }
    if ((!TextUtils.isEmpty(paramString1)) && (rvx.b(paramString1)))
    {
      rvx.a(paramContext, null, rvx.b(paramString1), null);
      return;
    }
    AudioHelper.b("gotoWebViewBrowser_" + paramString1);
    Intent localIntent = new Intent(paramContext, QQBrowserDelegationActivity.class);
    localIntent.putExtra("param_force_internal_browser", paramBoolean4);
    localIntent.putExtra("key_isReadModeEnabled", paramBoolean1);
    localIntent.putExtra("big_brother_source_key", paramString2);
    if ((paramContext instanceof BaseActivity)) {
      localIntent.putExtra("uin", ((BaseActivity)paramContext).getAppRuntime().getAccount());
    }
    localIntent.putExtra("useDefBackText", paramBoolean3);
    localIntent.putExtra("injectrecommend", paramBoolean2);
    if (paramMessageRecord != null)
    {
      localIntent.putExtra("curtype", paramMessageRecord.istroop);
      localIntent.putExtra("friendUin", paramMessageRecord.frienduin);
      if (paramMessageRecord.istroop != 0) {
        break label347;
      }
      localIntent.putExtra("articalChannelId", 2);
    }
    for (;;)
    {
      localIntent.putExtra("url", paramString1);
      localIntent.putExtra("fromOneCLickCLose", true);
      localIntent.putExtra("fromAio", true);
      sgg.a(paramMessageRecord, localIntent, paramString1);
      paramString2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if ((paramString2 instanceof QQAppInterface)) {
        acsz.a(localIntent, (QQAppInterface)paramString2, paramMessageRecord);
      }
      acqv.a(paramContext, localIntent, paramString1);
      axqy.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString1, "", "", "");
      return;
      label347:
      if (paramMessageRecord.istroop == 1) {
        localIntent.putExtra("articalChannelId", 3);
      } else if (paramMessageRecord.istroop == 3000) {
        localIntent.putExtra("articalChannelId", 4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asow
 * JD-Core Version:    0.7.0.1
 */