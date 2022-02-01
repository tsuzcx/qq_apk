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
  public static final String a;
  private BaseChatPie a;
  
  static
  {
    jdField_a_of_type_JavaLangString = WTEntranceHelper.class.getSimpleName();
  }
  
  public WTEntranceHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    int i = 1;
    paramString1 = URLUtil.a(paramString1, "inviteeUin", paramString2);
    paramString2 = new StringBuilder();
    if (paramInt == 1) {}
    for (paramInt = i;; paramInt = 2) {
      return URLUtil.a(paramString1, "fromid", paramInt + "");
    }
  }
  
  private void a()
  {
    ChooseFileInfo localChooseFileInfo;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() != null))
    {
      localChooseFileInfo = ChooseFileAssistant.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().jdField_a_of_type_JavaLangString);
      if (localChooseFileInfo != null) {
        break label58;
      }
      QLog.i(jdField_a_of_type_JavaLangString, 1, "chooseFileInfo is null, return.");
    }
    for (;;)
    {
      return;
      label58:
      if (localChooseFileInfo.jdField_a_of_type_Int != 4)
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "chooseFileInfo is not from micro app, return. entrance=" + localChooseFileInfo.jdField_a_of_type_Int);
        return;
      }
      try
      {
        if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), true, new WTEntranceHelper.1(this)))
        {
          PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), true, "AIOQAVWatchTogether", null);
          return;
        }
      }
      catch (Exception localException)
      {
        ChooseFileAssistant.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().jdField_a_of_type_JavaLangString);
        QLog.e(jdField_a_of_type_JavaLangString, 1, "startWatchWhenAIOCreate error", localException);
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
    if (paramInt1 == 1) {}
    paramActivity.startActivityForResult(localIntent, 2020);
  }
  
  public static void a(@NonNull Activity paramActivity, String paramString)
  {
    if ((paramActivity instanceof SplashActivity))
    {
      localObject = ((SplashActivity)paramActivity).getChatFragment();
      if ((localObject != null) && (((ChatFragment)localObject).a() != null) && (((ChatFragment)localObject).a().a() != null)) {
        ChooseFileAssistant.a().a(((ChatFragment)localObject).a().a());
      }
    }
    Object localObject = new Intent(paramActivity, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("key_from_type", 3);
    ((Intent)localObject).putExtra("url", paramString);
    paramActivity.startActivityForResult((Intent)localObject, 2020);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramQQAppInterface == null) || (paramContext == null))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "params error, do nothing");
      return;
    }
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), ChatActivity.class);
    ChooseFileInfo localChooseFileInfo = (ChooseFileInfo)paramIntent.getParcelableExtra("ChooseFileInfo");
    if (localChooseFileInfo == null)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "fileInfo is null, do nothing");
      return;
    }
    int i = paramIntent.getIntExtra("key_from_type", 0);
    int j = paramIntent.getIntExtra("watch_together_uinType", 0);
    int k = paramIntent.getIntExtra("MicroAppType", 0);
    Object localObject = "";
    long l;
    if (k == 2)
    {
      l = paramQQAppInterface.getPreferences().getLong("love_uin_for_current_user", 0L);
      paramIntent = (Intent)localObject;
      if (l <= 0L) {}
    }
    for (paramIntent = l + ""; TextUtils.isEmpty(paramIntent); paramIntent = paramIntent.getStringExtra("watch_together_uin"))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "uin is empty, return.fromType = " + i);
      return;
    }
    localIntent.putExtra("uinname", paramIntent);
    localObject = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject != null) {
      if (!((FriendsManager)localObject).b(paramIntent)) {
        break label350;
      }
    }
    label350:
    for (paramQQAppInterface = ContactUtils.a(paramQQAppInterface, paramIntent);; paramQQAppInterface = paramIntent)
    {
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        localIntent.putExtra("uinname", paramQQAppInterface);
      }
      paramQQAppInterface = new SessionInfo();
      paramQQAppInterface.jdField_a_of_type_Int = j;
      paramQQAppInterface.jdField_a_of_type_JavaLangString = paramIntent;
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
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str;
    if ((paramInt2 == 4660) && (paramInt1 == 2020) && (paramIntent != null))
    {
      paramInt1 = paramIntent.getIntExtra("key_from_type", 0);
      paramInt2 = paramIntent.getIntExtra("watch_together_uinType", -1);
      str = paramIntent.getStringExtra("watch_together_uin");
      paramIntent = (ChooseFileInfo)paramIntent.getParcelableExtra("ChooseFileInfo");
      if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), true, new WTEntranceHelper.2(this, paramInt1, paramIntent, paramInt2, str)))
      {
        if (paramInt1 != 3) {
          break label140;
        }
        ChooseFileAssistant.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().jdField_a_of_type_JavaLangString, paramIntent);
      }
    }
    for (;;)
    {
      PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), true, "AIOQAVWatchTogether", null);
      return;
      label140:
      ChooseFileAssistant.a().a(paramInt2, str, paramIntent);
    }
  }
  
  @NonNull
  public String getTag()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 14 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
      a();
      return;
    }
    ChooseFileAssistant.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.util.WTEntranceHelper
 * JD-Core Version:    0.7.0.1
 */