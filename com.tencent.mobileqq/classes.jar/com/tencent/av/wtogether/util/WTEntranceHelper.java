package com.tencent.av.wtogether.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.av.wtogether.data.ChooseFileInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.helper.OnActivityResultCallback;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;

public class WTEntranceHelper
  implements ILifeCycleHelper, OnActivityResultCallback
{
  public static final String a = "WTEntranceHelper";
  private BaseChatPie b;
  
  public WTEntranceHelper(BaseChatPie paramBaseChatPie)
  {
    this.b = paramBaseChatPie;
  }
  
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = URLUtil.a(paramString1, "inviteeUin", paramString2);
    paramString2 = new StringBuilder();
    int i = 1;
    if (paramInt == 1) {
      paramInt = i;
    } else {
      paramInt = 2;
    }
    paramString2.append(paramInt);
    paramString2.append("");
    return URLUtil.a(paramString1, "fromid", paramString2.toString());
  }
  
  private void a()
  {
    Object localObject = this.b;
    if ((localObject != null) && (((BaseChatPie)localObject).aE() != null))
    {
      localObject = ChooseFileAssistant.a().a(this.b.aE().a, this.b.aE().b);
      if (localObject == null)
      {
        QLog.i(a, 1, "chooseFileInfo is null, return.");
        return;
      }
      if (((ChooseFileInfo)localObject).a != 4)
      {
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("chooseFileInfo is not from micro app, return. entrance=");
        localStringBuilder.append(((ChooseFileInfo)localObject).a);
        QLog.i(str, 1, localStringBuilder.toString());
        return;
      }
      try
      {
        if (ChatActivityUtils.b(this.b.aX(), true, new WTEntranceHelper.1(this)))
        {
          PlusPanelUtils.a(this.b.i(), this.b.aX(), this.b.aE(), true, "AIOQAVWatchTogether", null);
          return;
        }
      }
      catch (Exception localException)
      {
        ChooseFileAssistant.a().b(this.b.aE().a, this.b.aE().b);
        QLog.e(a, 1, "startWatchWhenAIOCreate error", localException);
      }
    }
  }
  
  public static void a(@NonNull Activity paramActivity, int paramInt1, int paramInt2, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("key_from_type", paramInt1);
    localIntent.putExtra("watch_together_uinType", paramInt2);
    localIntent.putExtra("watch_together_uin", paramString);
    localIntent.putExtra("url", a("https://ti.qq.com/sportslive/index?_wwv=128&_wv=2", paramString, paramInt1));
    paramActivity.startActivityForResult(localIntent, 2020);
  }
  
  public static void a(@NonNull Activity paramActivity, String paramString)
  {
    if ((paramActivity instanceof SplashActivity))
    {
      localObject = ((SplashActivity)paramActivity).getChatFragment();
      if ((localObject != null) && (((ChatFragment)localObject).k() != null) && (((ChatFragment)localObject).k().aE() != null)) {
        ChooseFileAssistant.a().a(((ChatFragment)localObject).k().aE());
      }
    }
    Object localObject = new Intent(paramActivity, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("key_from_type", 3);
    ((Intent)localObject).putExtra("url", paramString);
    paramActivity.startActivityForResult((Intent)localObject, 2020);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramQQAppInterface != null) && (paramContext != null))
    {
      Intent localIntent = new Intent(BaseApplicationImpl.getContext(), ChatActivity.class);
      ChooseFileInfo localChooseFileInfo = (ChooseFileInfo)paramIntent.getParcelableExtra("ChooseFileInfo");
      if (localChooseFileInfo == null)
      {
        QLog.w(a, 1, "fileInfo is null, do nothing");
        return;
      }
      int i = paramIntent.getIntExtra("key_from_type", 0);
      int j = paramIntent.getIntExtra("watch_together_uinType", 0);
      if (paramIntent.getIntExtra("MicroAppType", 0) == 2)
      {
        long l = paramQQAppInterface.getPreferences().getLong("love_uin_for_current_user", 0L);
        paramIntent = "";
        if (l > 0L)
        {
          paramIntent = new StringBuilder();
          paramIntent.append(l);
          paramIntent.append("");
          paramIntent = paramIntent.toString();
        }
      }
      else
      {
        paramIntent = paramIntent.getStringExtra("watch_together_uin");
      }
      if (TextUtils.isEmpty(paramIntent))
      {
        paramQQAppInterface = a;
        paramContext = new StringBuilder();
        paramContext.append("uin is empty, return.fromType = ");
        paramContext.append(i);
        QLog.e(paramQQAppInterface, 1, paramContext.toString());
        return;
      }
      localIntent.putExtra("uinname", paramIntent);
      FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localFriendsManager != null)
      {
        if (localFriendsManager.n(paramIntent)) {
          paramQQAppInterface = ContactUtils.a(paramQQAppInterface, paramIntent);
        } else {
          paramQQAppInterface = paramIntent;
        }
        if (!TextUtils.isEmpty(paramQQAppInterface)) {
          localIntent.putExtra("uinname", paramQQAppInterface);
        }
      }
      paramQQAppInterface = new SessionInfo();
      paramQQAppInterface.a = j;
      paramQQAppInterface.b = paramIntent;
      ChooseFileAssistant.a().a(j, paramIntent, localChooseFileInfo, paramQQAppInterface);
      localIntent.putExtra("uintype", 0);
      localIntent.putExtra("uin", paramIntent);
      localIntent.putExtra("PREVIOUS_UIN", paramIntent);
      localIntent.putExtra("open_chatfragment", true);
      localIntent.putExtra("watch_together_uinType", j);
      localIntent.putExtra("key_from_type", i);
      localIntent.setFlags(67108864);
      paramContext.startActivity(localIntent);
      return;
    }
    QLog.w(a, 1, "params error, do nothing");
  }
  
  @NonNull
  public String getTag()
  {
    return a;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 15 };
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == 4660) && (paramInt1 == 2020) && (paramIntent != null))
    {
      paramInt1 = paramIntent.getIntExtra("key_from_type", 0);
      paramInt2 = paramIntent.getIntExtra("watch_together_uinType", -1);
      String str = paramIntent.getStringExtra("watch_together_uin");
      paramIntent = (ChooseFileInfo)paramIntent.getParcelableExtra("ChooseFileInfo");
      if (ChatActivityUtils.b(this.b.aX(), true, new WTEntranceHelper.2(this, paramInt1, paramIntent, paramInt2, str)))
      {
        if (paramInt1 == 3) {
          ChooseFileAssistant.a().a(this.b.aE().a, this.b.aE().b, paramIntent);
        } else {
          ChooseFileAssistant.a().a(paramInt2, str, paramIntent);
        }
        PlusPanelUtils.a(this.b.i(), this.b.aX(), this.b.aE(), true, "AIOQAVWatchTogether", null);
      }
    }
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 15) {
        return;
      }
      ChooseFileAssistant.a().b(this.b.aE().a, this.b.aE().b);
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.util.WTEntranceHelper
 * JD-Core Version:    0.7.0.1
 */