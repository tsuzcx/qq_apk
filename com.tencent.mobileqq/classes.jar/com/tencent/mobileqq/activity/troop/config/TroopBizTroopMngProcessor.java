package com.tencent.mobileqq.activity.troop.config;

import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.config.AbsTroopMngHandlerProcessor;
import com.tencent.mobileqq.troop.data.JoinGroupInfo;
import com.tencent.mobileqq.troop.utils.api.IBizTroopDBUtilsApi;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Map;
import java.util.Set;

public class TroopBizTroopMngProcessor
  extends AbsTroopMngHandlerProcessor
{
  private void e(@NonNull AppInterface paramAppInterface, String paramString)
  {
    if ((paramAppInterface instanceof QQAppInterface))
    {
      paramAppInterface = (QQAppInterface)paramAppInterface;
      paramAppInterface.getMessageFacade().c(paramString, 1);
      ((IBizTroopDBUtilsApi)QRoute.api(IBizTroopDBUtilsApi.class)).removeToopMsgFilter(paramAppInterface, paramString, paramAppInterface.getCurrentAccountUin(), paramAppInterface.getApp());
    }
  }
  
  public void a(@NonNull AppInterface paramAppInterface, String paramString1, String paramString2, TroopInfo paramTroopInfo)
  {
    if ((paramAppInterface instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)paramAppInterface;
      if (!TextUtils.isEmpty(paramString1))
      {
        if (TextUtils.equals("0", paramString1)) {
          return;
        }
        TroopManager localTroopManager = (TroopManager)paramAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (localTroopManager != null)
        {
          localTroopManager.d(paramTroopInfo);
          localTroopManager.e(localTroopManager.f(paramTroopInfo.troopuin));
        }
        paramAppInterface = (DiscussionManager)paramAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
        paramAppInterface.a.put(paramString2, new String[] { paramString1, localQQAppInterface.getCurrentAccountUin() });
        paramAppInterface.b.add(paramString1);
      }
    }
  }
  
  public void a(String paramString, int paramInt, Parcelable paramParcelable)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramParcelable != null))
    {
      int i;
      if ((paramParcelable instanceof JoinGroupInfo)) {
        i = 0;
      } else {
        i = 1;
      }
      Intent localIntent = new Intent(BaseApplication.getContext(), JumpActivity.class);
      localIntent.setAction("com.tencent.security.VERIFY_WEB");
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("busi_type", i);
      localIntent.putExtra("verify_type", paramInt);
      localIntent.putExtra("extra_data", paramParcelable);
      localIntent.addFlags(268435456);
      BaseApplication.getContext().startActivity(localIntent);
    }
  }
  
  public void c(@NonNull AppInterface paramAppInterface, String paramString)
  {
    e(paramAppInterface, paramString);
  }
  
  public void d(@NonNull AppInterface paramAppInterface, String paramString)
  {
    e(paramAppInterface, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.TroopBizTroopMngProcessor
 * JD-Core Version:    0.7.0.1
 */