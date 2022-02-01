package com.tencent.mobileqq.app.avgameshare;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.avgame.business.api.IAvGameManager;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class AVGameShareUtil
{
  private static volatile AVGameShareUtil a;
  private HashMap<String, String> b;
  private boolean c = false;
  
  public static AVGameShareUtil a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new AVGameShareUtil();
        }
      }
      finally {}
    }
    return a;
  }
  
  private boolean c(BroadcastReceiver paramBroadcastReceiver, Context paramContext)
  {
    return (paramBroadcastReceiver == null) || (paramContext == null);
  }
  
  public Intent a(Context paramContext)
  {
    if (paramContext == null)
    {
      QLog.e("AVGameShareUtil", 1, "getBackFlowIntent error: context is null");
      return null;
    }
    paramContext = new Intent(paramContext, SplashActivity.class);
    paramContext.putExtra("thridparty_prepare_av_game", true);
    paramContext.addFlags(67108864);
    paramContext.addFlags(268435456);
    paramContext.putExtra("fragment_id", 1);
    return paramContext;
  }
  
  public String a(String paramString)
  {
    Object localObject = this.b;
    if (localObject == null)
    {
      QLog.e("AVGameShareUtil", 1, "getCoverUrl error: map is null");
      return null;
    }
    localObject = (String)((HashMap)localObject).get(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCoverUrl gameId: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" coverUrl: ");
    localStringBuilder.append((String)localObject);
    QLog.d("AVGameShareUtil", 1, localStringBuilder.toString());
    return localObject;
  }
  
  public void a(Activity paramActivity, String paramString, int paramInt)
  {
    if (paramActivity == null)
    {
      QLog.e("AVGameShareUtil", 1, "shareAVGameResultPic error: activity == null");
      return;
    }
    new AVGameShareResultPic(paramActivity, paramString, paramInt).p();
  }
  
  public void a(BroadcastReceiver paramBroadcastReceiver, Context paramContext)
  {
    try
    {
      if (c(paramBroadcastReceiver, paramContext))
      {
        QLog.e("AVGameShareUtil", 2, "unregisterShareReceiver error: iLegalReceiver");
        return;
      }
      if (this.c)
      {
        QLog.e("AVGameShareUtil", 2, "unregisterShareReceiver error: is registered");
        return;
      }
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.app.avgameshare.avgameshareutil");
      paramContext.registerReceiver(paramBroadcastReceiver, localIntentFilter);
      this.c = true;
      return;
    }
    catch (Exception paramBroadcastReceiver)
    {
      paramContext = new StringBuilder();
      paramContext.append("registerShareReceiver error: ");
      paramContext.append(paramBroadcastReceiver.getMessage());
      QLog.e("AVGameShareUtil", 2, paramContext.toString());
    }
  }
  
  public void a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    if (paramContext == null) {}
    try
    {
      QLog.e("AVGameShareUtil", 1, "notifyFromForward error: context is null");
      return;
    }
    catch (Exception paramContext)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notifyFromForward error: ");
      ((StringBuilder)localObject).append(paramContext.getMessage());
      QLog.e("AVGameShareUtil", 1, ((StringBuilder)localObject).toString());
    }
    localObject = new Intent();
    ((Intent)localObject).setAction("com.tencent.mobileqq.app.avgameshare.avgameshareutil");
    ((Intent)localObject).putExtra("avgame_share_result_success", paramBoolean);
    ((Intent)localObject).putExtra("avgame_share_result_type", paramInt);
    ((Intent)localObject).setPackage(paramContext.getPackageName());
    paramContext.sendBroadcast((Intent)localObject);
    return;
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null) {}
    try
    {
      QLog.e("AVGameShareUtil", 1, "notifyFromForward error: context is null");
      return;
    }
    catch (Exception paramContext)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notifyFromForward error: ");
      ((StringBuilder)localObject).append(paramContext.getMessage());
      QLog.e("AVGameShareUtil", 1, ((StringBuilder)localObject).toString());
    }
    localObject = new Intent();
    ((Intent)localObject).setAction("com.tencent.mobileqq.app.avgameshare.avgameshareutil");
    ((Intent)localObject).putExtra("avgame_share_result_success", paramBoolean);
    ((Intent)localObject).setPackage(paramContext.getPackageName());
    paramContext.sendBroadcast((Intent)localObject);
    return;
  }
  
  public void a(AppInterface paramAppInterface, String paramString, AVGameShareUtil.AVGameShareProxy paramAVGameShareProxy)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestGetInviteBackflowInfo key: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("AVGameShareUtil", 1, ((StringBuilder)localObject).toString());
    localObject = (IAvGameManager)paramAppInterface.getRuntimeService(IAvGameManager.class, "");
    long l = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    paramAVGameShareProxy = new AVGameShareUtil.5(this, l, localHashMap, paramAppInterface, paramAVGameShareProxy);
    localHashMap.put(Long.valueOf(l), paramAVGameShareProxy);
    paramAppInterface.addObserver(paramAVGameShareProxy);
    if (localObject != null) {
      ((IAvGameManager)localObject).requestShareInviteBackflowInfo(paramString, l);
    }
  }
  
  public void a(BaseAVGameAppInterface paramBaseAVGameAppInterface, long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, AVGameShareUtil.AVGameShareProxy paramAVGameShareProxy)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestGetShareLink roomId: ");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append(" shareUin: ");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong2);
    localStringBuilder.append("");
    ((StringBuilder)localObject).append(AuthorityUtil.a(localStringBuilder.toString()));
    ((StringBuilder)localObject).append(" shareName: ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" shareType: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" gameId: ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(" gameType: ");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.d("AVGameShareUtil", 1, ((StringBuilder)localObject).toString());
    long l = System.currentTimeMillis();
    localObject = new HashMap();
    paramAVGameShareProxy = new AVGameShareUtil.4(this, l, (Map)localObject, paramBaseAVGameAppInterface, paramAVGameShareProxy);
    ((Map)localObject).put(Long.valueOf(l), paramAVGameShareProxy);
    paramBaseAVGameAppInterface.addObserver(paramAVGameShareProxy);
    GameEngine.a().a(paramLong1, paramLong2, paramString1, paramInt1, paramString2, paramInt2, l);
  }
  
  public void a(BaseAVGameAppInterface paramBaseAVGameAppInterface, Activity paramActivity, long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt)
  {
    if (paramActivity == null)
    {
      QLog.e("AVGameShareUtil", 1, "shareAVGameResultLink error: activity == null");
      return;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("shareAVGameResultLink currentUin: ");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(paramLong2);
    localStringBuilder2.append("");
    localStringBuilder1.append(AuthorityUtil.a(localStringBuilder2.toString()));
    localStringBuilder1.append(" roomId: ");
    localStringBuilder1.append(paramLong1);
    localStringBuilder1.append(" shareUin: ");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(paramLong2);
    localStringBuilder2.append("");
    localStringBuilder1.append(AuthorityUtil.a(localStringBuilder2.toString()));
    localStringBuilder1.append(" shareName: ");
    localStringBuilder1.append(paramString1);
    localStringBuilder1.append(" roundId: ");
    localStringBuilder1.append(paramString2);
    localStringBuilder1.append(" gameType: ");
    localStringBuilder1.append(paramInt);
    QLog.d("AVGameShareUtil", 1, localStringBuilder1.toString());
    a(paramBaseAVGameAppInterface, paramLong1, paramLong2, paramString1, 2, paramString2, paramInt, new AVGameShareUtil.3(this, paramActivity, paramLong2, paramLong1, paramInt, paramString1, paramString2));
  }
  
  public void a(BaseAVGameAppInterface paramBaseAVGameAppInterface, QBaseActivity paramQBaseActivity, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (paramQBaseActivity == null)
    {
      QLog.e("AVGameShareUtil", 1, "shareAVGameEntry error: activity == null");
      return;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("sinviteCallbackhareAVGameEntry currentUin: ");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(paramLong2);
    localStringBuilder2.append("");
    localStringBuilder1.append(AuthorityUtil.a(localStringBuilder2.toString()));
    localStringBuilder1.append(" roomId: ");
    localStringBuilder1.append(paramLong1);
    localStringBuilder1.append(" shareUin: ");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(paramLong2);
    localStringBuilder2.append("");
    localStringBuilder1.append(AuthorityUtil.a(localStringBuilder2.toString()));
    localStringBuilder1.append(" shareName: ");
    localStringBuilder1.append(paramString);
    localStringBuilder1.append(" gameSerType:");
    localStringBuilder1.append(paramInt);
    QLog.d("AVGameShareUtil", 1, localStringBuilder1.toString());
    a(paramBaseAVGameAppInterface, paramLong1, paramLong2, paramString, 1, "", paramInt, new AVGameShareUtil.1(this, paramQBaseActivity, paramLong2, paramLong1, paramString));
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt1, String paramString1, long paramLong1, long paramLong2, String paramString2, int paramInt2, String paramString3, int paramInt3)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("requestShareUrlAndSendMsg roomId: ");
    ((StringBuilder)localObject1).append(paramLong1);
    ((StringBuilder)localObject1).append(" curType: ");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(" friendUin: ");
    ((StringBuilder)localObject1).append(AuthorityUtil.a(paramString1));
    ((StringBuilder)localObject1).append(" shareUin: ");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramLong2);
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject1).append(AuthorityUtil.a(((StringBuilder)localObject2).toString()));
    ((StringBuilder)localObject1).append(" shareName: ");
    ((StringBuilder)localObject1).append(paramString2);
    ((StringBuilder)localObject1).append(" shareType: ");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(" gameId: ");
    ((StringBuilder)localObject1).append(paramString3);
    ((StringBuilder)localObject1).append(" gameType: ");
    ((StringBuilder)localObject1).append(paramInt3);
    QLog.d("AVGameShareUtil", 1, ((StringBuilder)localObject1).toString());
    localObject1 = (IAvGameManager)paramBaseQQAppInterface.getRuntimeService(IAvGameManager.class, "");
    long l = System.currentTimeMillis();
    localObject2 = new HashMap();
    paramString1 = new AVGameShareUtil.6(this, l, (Map)localObject2, paramBaseQQAppInterface, paramInt1, paramString1, paramString2, paramLong2, paramLong1);
    ((Map)localObject2).put(Long.valueOf(l), paramString1);
    paramBaseQQAppInterface.addObserver(paramString1);
    if (localObject1 != null) {
      ((IAvGameManager)localObject1).requestGetShareLink(paramLong1, paramLong2, paramString2, paramInt2, paramString3, paramInt3, l);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.b == null) {
      this.b = new HashMap();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addCoverUrl gameId: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" coverUrl: ");
    localStringBuilder.append(paramString2);
    QLog.d("AVGameShareUtil", 1, localStringBuilder.toString());
    this.b.put(paramString1, paramString2);
  }
  
  public void b()
  {
    HashMap localHashMap = this.b;
    if (localHashMap == null)
    {
      QLog.e("AVGameShareUtil", 1, "clearCoverMap invalid: map is null");
      return;
    }
    localHashMap.clear();
  }
  
  public void b(BroadcastReceiver paramBroadcastReceiver, Context paramContext)
  {
    try
    {
      if (c(paramBroadcastReceiver, paramContext))
      {
        QLog.e("AVGameShareUtil", 2, "unregisterShareReceiver error: iLegalReceiver");
        return;
      }
      if (!this.c)
      {
        QLog.e("AVGameShareUtil", 2, "unregisterShareReceiver error: is not registered");
        return;
      }
      paramContext.unregisterReceiver(paramBroadcastReceiver);
      this.c = false;
      return;
    }
    catch (Exception paramBroadcastReceiver)
    {
      paramContext = new StringBuilder();
      paramContext.append("unregisterShareReceiver error: ");
      paramContext.append(paramBroadcastReceiver.getMessage());
      QLog.e("AVGameShareUtil", 2, paramContext.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.avgameshare.AVGameShareUtil
 * JD-Core Version:    0.7.0.1
 */