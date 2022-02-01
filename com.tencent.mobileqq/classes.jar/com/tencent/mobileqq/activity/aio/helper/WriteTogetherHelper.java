package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.ActionMode.Callback;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.writetogether.api.IWTStartup;
import com.tencent.mobileqq.writetogether.api.IWriteTogetherConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

public class WriteTogetherHelper
  implements ILifeCycleHelper, OnActivityResultCallback
{
  private BaseChatPie a;
  private QQAppInterface b;
  private Context c;
  private ActionMode.Callback d;
  private boolean e = false;
  
  public WriteTogetherHelper(HelperProvider paramHelperProvider, BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
    this.b = paramBaseChatPie.d;
    this.c = paramBaseChatPie.e;
    paramHelperProvider.a(this);
  }
  
  public static void a(Context paramContext, BaseChatPie paramBaseChatPie, String paramString1, String paramString2, int paramInt)
  {
    if (paramBaseChatPie != null) {
      paramBaseChatPie = paramBaseChatPie.f;
    } else {
      paramBaseChatPie = null;
    }
    ((IWTStartup)QRoute.api(IWTStartup.class)).launchEditor(paramContext, paramBaseChatPie, paramString1, paramString2, paramInt, 18005);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    a(paramContext, null, paramString1, paramString2, paramInt);
  }
  
  private String e()
  {
    Object localObject = this.a;
    if ((localObject == null) || (((BaseChatPie)localObject).ah == null) || (this.a.ah.b == null)) {
      localObject = "";
    } else {
      localObject = this.a.ah.b;
    }
    TextUtils.isEmpty((CharSequence)localObject);
    return localObject;
  }
  
  private boolean f()
  {
    Object localObject = e();
    localObject = ((TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER)).b((String)localObject, true);
    return (localObject != null) && (((TroopInfo)localObject).exitTroopReason == 0);
  }
  
  private void g()
  {
    if (this.d != null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      this.d = new WriteTogetherHelper.1(this);
    }
  }
  
  private void h()
  {
    ChatXListView localChatXListView = this.a.U;
    localChatXListView.setSelectionFromBottom(localChatXListView.getCount() - 1, 0);
  }
  
  public void a()
  {
    g();
  }
  
  public void a(String paramString, int paramInt)
  {
    a(this.c, this.a, paramString, e(), paramInt);
  }
  
  public void b() {}
  
  public void b(String paramString, int paramInt)
  {
    String str = e();
    ((IWTStartup)QRoute.api(IWTStartup.class)).launchWriteTogetherEditor(this.b, this.c, this.a.f, paramString, paramInt, str, 18005);
  }
  
  public ActionMode.Callback c()
  {
    g();
    return this.d;
  }
  
  public boolean d()
  {
    SessionInfo localSessionInfo = this.a.ah;
    boolean bool = ((IWriteTogetherConfig)QRoute.api(IWriteTogetherConfig.class)).isAllowShowEntrance(this.b, this.a.ah.b);
    if ((localSessionInfo != null) && (bool)) {
      return (localSessionInfo.a == 1) && (f());
    }
    return false;
  }
  
  public String getTag()
  {
    return "WriteTogetherHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 0, 15 };
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 18005) {
      return;
    }
    if ((paramInt2 & 0x1) != 0)
    {
      if ((paramInt2 & 0x2) != 0) {
        this.a.Y.setText("");
      }
      if ((paramInt2 & 0x4) != 0)
      {
        paramIntent = (FullScreenInputHelper)this.a.q(24);
        if (paramIntent != null) {
          paramIntent.b(true);
        }
      }
      if ((paramInt2 & 0x8) != 0) {
        h();
      }
    }
    else
    {
      paramIntent = new StringBuilder();
      paramIntent.append("[onActivityResult] failed code: ");
      paramIntent.append(paramInt2);
      QLog.e("WriteTogetherHelper", 1, paramIntent.toString());
    }
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt == 0)
    {
      a();
      return;
    }
    if (paramInt == 15) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.WriteTogetherHelper
 * JD-Core Version:    0.7.0.1
 */