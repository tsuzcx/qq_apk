import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_dc00307;
import org.json.JSONException;
import org.json.JSONObject;

public class bhxi
{
  private static long a;
  
  private static String a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      do
      {
        do
        {
          acmw localacmw;
          do
          {
            return null;
            localacmw = paramQQAppInterface.getConversationFacade();
          } while ((localacmw == null) || (localacmw.a("3026775809", 1008) <= 0));
          paramQQAppInterface = paramQQAppInterface.getMessageProxy(1008);
        } while (paramQQAppInterface == null);
        paramQQAppInterface = paramQQAppInterface.a("3026775809", 1008);
      } while ((paramQQAppInterface == null) || (paramQQAppInterface.mExJsonObject == null));
      paramQQAppInterface = paramQQAppInterface.mExJsonObject.optString("report_key_bytes_oac_msg_extend", "");
      QLog.d("VSHealthUtil", 1, "[redirectAIOToMainPage] bytes_oac_msg_extend: " + paramQQAppInterface);
    } while (paramQQAppInterface == null);
    for (;;)
    {
      try
      {
        paramQQAppInterface = new JSONObject(paramQQAppInterface).optString("sports_extra");
        if (!TextUtils.isEmpty(paramQQAppInterface))
        {
          paramQQAppInterface = new JSONObject(paramQQAppInterface).optString("h5_url");
          boolean bool = TextUtils.isEmpty(paramQQAppInterface);
          if (!bool) {
            return paramQQAppInterface;
          }
        }
      }
      catch (JSONException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return null;
      }
      paramQQAppInterface = null;
    }
  }
  
  public static void a(long paramLong)
  {
    a = paramLong;
  }
  
  public static boolean a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramContext == null) || (paramQQAppInterface == null))
    {
      paramQQAppInterface = new StringBuilder().append("[redirectAIOToMainPage] error! context: ");
      if (paramContext == null)
      {
        bool = true;
        paramQQAppInterface = paramQQAppInterface.append(bool).append(", app: ");
        if (paramContext != null) {
          break label70;
        }
      }
      label70:
      for (boolean bool = true;; bool = false)
      {
        QLog.e("VSHealthUtil", 1, bool);
        return false;
        bool = false;
        break;
      }
    }
    Object localObject1 = (String)VSConfigManager.getInstance().getValue("main_page_jump_url", "https://web.yundong.qq.com/pushsport/index?_wv=18950115&asyncMode=1&crashFrom=40501&_wwv=265&ls=1&spec=1&ADTAG=gzh.menu_page.main");
    Object localObject2 = a(paramQQAppInterface);
    QLog.d("VSHealthUtil", 1, "[redirectAIOToMainPage] healthMainPageJumpUrl: " + (String)localObject1 + ", msgJumpUrl: " + (String)localObject2);
    if (TextUtils.isEmpty((CharSequence)localObject2)) {}
    while (TextUtils.isEmpty((CharSequence)localObject1))
    {
      QLog.e("VSHealthUtil", 1, "[redirectAIOToMainPage] error! targetJumpUrl is null!");
      paramContext = new LpReportInfo_dc00307();
      paramContext.page_id = 159;
      paramContext.module_id = 3;
      paramContext.act_id = 5;
      paramContext.ext0 = "1";
      paramContext.success_or_not = 0;
      return false;
      localObject1 = localObject2;
    }
    a(System.currentTimeMillis());
    localObject2 = bhey.a(paramQQAppInterface, paramContext, (String)localObject1);
    if (localObject2 != null) {
      ((bheh)localObject2).a();
    }
    for (;;)
    {
      paramContext = paramQQAppInterface.getConversationFacade();
      if (paramContext != null) {
        paramContext.a("3026775809", 1008, true);
      }
      return true;
      localObject1 = bkyp.a(bkyp.a(bkyp.a(bkyp.a((String)localObject1, "uin", paramQQAppInterface.getCurrentUin()), "puin", "3026775809"), "isHealthPublicAccountMainPage", "1"), "sourceFrom", String.valueOf(paramInt));
      localObject2 = new Intent(paramContext, PublicAccountBrowser.class);
      ((Intent)localObject2).putExtra("from", QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      ((Intent)localObject2).putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
      ((Intent)localObject2).putExtra("puin", "3026775809");
      ((Intent)localObject2).putExtra("puin_name", paramString);
      ((Intent)localObject2).putExtra("puin_type", 1008);
      ((Intent)localObject2).putExtra("assignBackText", paramContext.getResources().getString(2131690676));
      ((Intent)localObject2).putExtra("call_from", paramInt);
      ((Intent)localObject2).putExtra("FORCE_BLANK_SCREEN_REPORTE", true);
      ((Intent)localObject2).putExtra("big_brother_source_key", uuc.b("3026775809"));
      paramContext.startActivity((Intent)localObject2);
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = false;
    if (b(paramString)) {
      bool = ((Boolean)VSConfigManager.getInstance().getValue("is_redirect_aio_to_main_page", Boolean.valueOf(false))).booleanValue();
    }
    return bool;
  }
  
  public static boolean b(String paramString)
  {
    return TextUtils.equals("3026775809", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhxi
 * JD-Core Version:    0.7.0.1
 */