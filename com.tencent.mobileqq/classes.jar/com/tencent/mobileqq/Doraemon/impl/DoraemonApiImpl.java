package com.tencent.mobileqq.Doraemon.impl;

import android.os.Bundle;
import com.tencent.biz.qqstory.base.StoryBoss;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.DoraemonAPIModule;
import com.tencent.mobileqq.Doraemon.IDoraemonApi;
import com.tencent.mobileqq.Doraemon.impl.commonModule.UserInfoModule;
import com.tencent.mobileqq.miniapp.MiniAppInfo;
import com.tencent.mobileqq.miniapp.MiniAppInfoCallback;
import com.tencent.mobileqq.miniapp.MiniAppManager;
import com.tribe.async.async.Bosses;

public class DoraemonApiImpl
  implements IDoraemonApi
{
  public void bindService()
  {
    TroopMemberApiClient.a().e();
  }
  
  public MiniAppInfo getAppInfo(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, MiniAppInfoCallback paramMiniAppInfoCallback)
  {
    return MiniAppManager.a().a(paramString, paramInt1, paramInt2, paramBoolean, paramMiniAppInfoCallback);
  }
  
  public MiniAppInfo getAppInfo(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, MiniAppInfoCallback paramMiniAppInfoCallback, int paramInt3)
  {
    return MiniAppManager.a().a(paramString, paramInt1, paramInt2, paramBoolean, paramMiniAppInfoCallback, paramInt3);
  }
  
  public Bundle getUserInfo()
  {
    return UserInfoModule.c();
  }
  
  public void initBosses()
  {
    Bosses.initWithBoss(BaseApplicationImpl.getApplication(), new StoryBoss(BaseApplicationImpl.getApplication()));
  }
  
  public boolean isLogin(DoraemonAPIModule paramDoraemonAPIModule)
  {
    if ((paramDoraemonAPIModule instanceof UserInfoModule)) {
      return ((UserInfoModule)paramDoraemonAPIModule).d();
    }
    return false;
  }
  
  public void putAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    MiniAppManager.a().a(paramMiniAppInfo);
  }
  
  public void unbindService()
  {
    TroopMemberApiClient.a().f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.DoraemonApiImpl
 * JD-Core Version:    0.7.0.1
 */