import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class bbiv
{
  private static volatile bbiv a;
  
  public static bbiv a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bbiv();
      }
      return a;
    }
    finally {}
  }
  
  protected long a(String paramString1, String paramString2, long paramLong)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getLong(paramString1 + "_" + paramString2, paramLong);
  }
  
  public TipsBar a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    TipsBar localTipsBar = new TipsBar(paramContext);
    localTipsBar.setVisibility(0);
    localTipsBar.a().setText(a(paramQQAppInterface.getCurrentUin(), "bar_content_string", ""));
    localTipsBar.setTipsIcon(paramContext.getResources().getDrawable(2130839319));
    localTipsBar.setOriginalOnClickListener(new bbiw(this, paramContext, paramQQAppInterface));
    return localTipsBar;
  }
  
  protected String a(String paramString1, String paramString2, String paramString3)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getString(paramString1 + "_" + paramString2, paramString3);
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getCurrentAccountUin())) || (paramLong <= 0L)) {
      QLog.e("ModifyPwdTopBarHelper", 1, "updateBarDisplayStatus: params error");
    }
    String str1;
    do
    {
      return;
      str1 = paramQQAppInterface.getCurrentAccountUin();
      if (a(str1)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ModifyPwdTopBarHelper", 2, "isModifyPwdBarHelperEnable false");
    return;
    boolean bool1 = a(str1, "key_verify_for_dlg_or_clk", false);
    boolean bool2 = a(str1, "key_show_status", false);
    long l1 = a(str1, "time_dlg_show_or_bar_clk", 0L);
    long l2 = a(str1, "time_fetch_next_time", 0L);
    String str2 = a(str1, "bar_url", "");
    String str3 = a(str1, "bar_content_string", "");
    QLog.d("ModifyPwdTopBarHelper", 1, "updateBarDisplayInfo verifyForDlgOrClk: " + bool1 + " showStatus: " + bool2 + " timeDlgShowOrBarClk: " + l1 + " fetchNext: " + l2 + " barUrl: " + str2 + " contentStr: " + str3 + " currentMillis: " + paramLong);
    if ((bool1) && (paramLong - l1 >= 86400000L) && (paramLong >= l2)) {
      a(paramQQAppInterface, str1);
    }
    a(paramQQAppInterface, bool2);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("ModifyPwdTopBarHelper", 1, "requestTopBarDisplayInfo error: app == null");
      return;
    }
    bbiy localbbiy = (bbiy)paramQQAppInterface.getBusinessHandler(187);
    if (localbbiy == null)
    {
      QLog.e("ModifyPwdTopBarHelper", 1, "requestTopBarDisplayInfo error: handler == null");
      return;
    }
    long l = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    paramString = new bbix(this, l, localHashMap, paramQQAppInterface, paramString);
    localHashMap.put(Long.valueOf(l), paramString);
    paramQQAppInterface.addObserver(paramString);
    localbbiy.a(l);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    MqqHandler localMqqHandler = paramQQAppInterface.getHandler(Conversation.class);
    if (paramBoolean)
    {
      bcef.b(paramQQAppInterface, "dc00898", "", "", "0X800B186", "0X800B186", 0, 0, "", "", "", "");
      localMqqHandler.sendEmptyMessage(1134075);
      return;
    }
    localMqqHandler.sendEmptyMessage(1134076);
  }
  
  public void a(String paramString)
  {
    QLog.d("ModifyPwdTopBarHelper", 1, "cancelVerifyRiskDialog uin: " + paramString);
    a(paramString, false, false, 0L, 0L);
  }
  
  public void a(String paramString, long paramLong)
  {
    QLog.d("ModifyPwdTopBarHelper", 1, "doAfterPushRiskDialog uin: " + paramString + " currentMillis: " + paramLong);
    b(paramString);
    a(paramString, true, false, paramLong, 0L);
  }
  
  protected void a(String paramString1, String paramString2, long paramLong)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    localEditor.putLong(paramString1 + "_" + paramString2, paramLong);
    localEditor.commit();
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    localEditor.putString(paramString1 + "_" + paramString2, paramString3);
    localEditor.commit();
  }
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    localEditor.putBoolean(paramString1 + "_" + paramString2, paramBoolean);
    localEditor.commit();
  }
  
  protected void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2)
  {
    QLog.d("ModifyPwdTopBarHelper", 1, "updateConfigData uin: " + paramString + " verifyForDlgOrClk: " + paramBoolean1 + " showStatus: " + paramBoolean2 + " timeDlgShowOrBarClk: " + paramLong1 + " fetchNext: " + paramLong2);
    a(paramString, "key_verify_for_dlg_or_clk", paramBoolean1);
    a(paramString, "key_show_status", paramBoolean2);
    a(paramString, "time_dlg_show_or_bar_clk", paramLong1);
    a(paramString, "time_fetch_next_time", paramLong2);
  }
  
  public boolean a(String paramString)
  {
    return a(paramString, "key_risk_top_bar_enable", false);
  }
  
  protected boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getBoolean(paramString1 + "_" + paramString2, paramBoolean);
  }
  
  protected void b(String paramString)
  {
    QLog.d("ModifyPwdTopBarHelper", 1, "setModifyPwdTopBarEnable uin: " + paramString);
    a(paramString, "key_risk_top_bar_enable", true);
  }
  
  protected void b(String paramString, long paramLong)
  {
    QLog.d("ModifyPwdTopBarHelper", 1, "doAfterClickTopBar uin: " + paramString + " currentMillis: " + paramLong);
    a(paramString, true, false, paramLong, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbiv
 * JD-Core Version:    0.7.0.1
 */