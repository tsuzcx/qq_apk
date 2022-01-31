import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.troop.utils.ChangeMachineManager.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class bcgi
  implements Manager
{
  public int a;
  protected Handler a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Runnable jdField_a_of_type_JavaLangRunnable = new ChangeMachineManager.2(this);
  public String a;
  public String b;
  public String c;
  
  public bcgi(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    paramQQAppInterface = BaseApplicationImpl.getContext().getSharedPreferences("ChangeMachine", 0);
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getString("title", null);
    this.b = paramQQAppInterface.getString("desc", null);
    this.jdField_a_of_type_Int = paramQQAppInterface.getInt("resIconId", 0);
    this.c = paramQQAppInterface.getString("url", null);
  }
  
  private void c()
  {
    amjk localamjk = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    Object localObject1 = localamjk.b(aljq.aE, 7440);
    if (localObject1 == null)
    {
      localObject1 = new RecentUser(aljq.aE, 7440);
      ((RecentUser)localObject1).lastmsgtime = (System.currentTimeMillis() / 1000L);
    }
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("isRead", false);
        ((RecentUser)localObject1).msg = ((JSONObject)localObject2).toString();
        ((RecentUser)localObject1).msgData = ((JSONObject)localObject2).toString().getBytes();
        ((RecentUser)localObject1).msgType = 1;
        localObject2 = BaseApplicationImpl.getContext().getResources().getString(2131697721);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          localObject2 = this.jdField_a_of_type_JavaLangString;
        }
        ((RecentUser)localObject1).displayName = ((String)localObject2);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
      }
      localamjk.a((RecentUser)localObject1);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if (localObject1 != null) {
        ((MqqHandler)localObject1).sendEmptyMessage(1009);
      }
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "huanjibao", "", "feeds", "view", 0, 0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "", "");
      return;
    }
  }
  
  private void d()
  {
    amjk localamjk = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    RecentUser localRecentUser = localamjk.b(aljq.aE, 7440);
    if (localRecentUser == null) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("isRead", true);
      localRecentUser.msg = localJSONObject.toString();
      localamjk.a(localRecentUser);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void e()
  {
    BaseApplicationImpl.getContext().getSharedPreferences("ChangeMachine", 0).edit().putString("title", this.jdField_a_of_type_JavaLangString).putString("desc", this.b).putInt("resIconId", this.jdField_a_of_type_Int).putString("url", this.c).commit();
  }
  
  public int a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return 2130843401;
    case 2: 
      return 2130843402;
    case 3: 
      return 2130843403;
    }
    return 2130843404;
  }
  
  protected String a()
  {
    Object localObject = "";
    try
    {
      String str = UserAction.getQIMEI();
      localObject = str;
    }
    catch (Exception localException)
    {
      while (!QLog.isDevelopLevel()) {}
      QLog.e(".troop.change_machine", 2, "get QIMI error");
    }
    return localObject;
    return "";
  }
  
  public void a()
  {
    String str = a();
    if (str == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    Bundle localBundle = new Bundle();
    localBundle.putString("qimei", str);
    localBundle.putString("id", "13");
    localHashMap.put("BUNDLE", localBundle);
    localHashMap.put("CONTEXT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
    new bcgp("https://innovate.qq.com/GetNewMachine", "GET", new bcgj(this), 10001, null).a(localHashMap);
  }
  
  public void a(Context paramContext)
  {
    Object localObject2 = this.c;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "http://qzs.qq.com/open/yyb/switch_phone/html/qq_cooperation.html";
    }
    localObject1 = bhos.a(bhos.a((String)localObject1, "qqnum", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), "qimei", a());
    localObject2 = new Intent(paramContext, QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("url", (String)localObject1);
    paramContext.startActivity((Intent)localObject2);
    d();
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "huanjibao", "", "feeds", "click", 0, 0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "", "");
  }
  
  public void a(String paramString)
  {
    int i = 1;
    try
    {
      paramString = new JSONObject(paramString);
      int j = paramString.optInt("showMode");
      this.jdField_a_of_type_JavaLangString = paramString.optString("title");
      this.b = paramString.optString("desc");
      this.jdField_a_of_type_Int = paramString.optInt("icon");
      this.c = paramString.optString("url");
      if (j == -2) {}
      while (i != 0)
      {
        a();
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "huanjibao", "", "new_mobile", "request", 0, 0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "", "");
        return;
        if (j >= 0)
        {
          boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().endsWith(String.valueOf(j));
          if (bool) {}
        }
        else
        {
          i = 0;
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e(".troop.change_machine", 2, "parseSevletConfigContent JSONException", paramString);
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcgi
 * JD-Core Version:    0.7.0.1
 */