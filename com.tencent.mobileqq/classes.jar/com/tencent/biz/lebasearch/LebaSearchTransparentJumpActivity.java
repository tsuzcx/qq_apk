package com.tencent.biz.lebasearch;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.FunctionModuleConfigManager;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBaseItem;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqfav.QfavHelper;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QzonePluginProxyActivity;

public class LebaSearchTransparentJumpActivity
  extends IphoneTitleBarActivity
{
  public View a;
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramBundle != null) && ((paramBundle instanceof QQAppInterface))) {
      this.app = ((QQAppInterface)paramBundle);
    }
    this.a = new View(this);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    FunctionModuleConfigManager localFunctionModuleConfigManager = (FunctionModuleConfigManager)this.app.getManager(QQManagerFactory.FUNCTION_MODULE_MANAGER);
    if (localFunctionModuleConfigManager.d != null) {
      localFunctionModuleConfigManager.d = null;
    }
    if (localFunctionModuleConfigManager.e != null) {
      localFunctionModuleConfigManager.e = null;
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    Object localObject1 = getIntent();
    int j = 0;
    int i = ((Intent)localObject1).getIntExtra("key_business", 0);
    if (i != 100)
    {
      if (i != 101) {
        switch (i)
        {
        default: 
          break;
        case 7: 
          localObject1 = new Intent(this, PhoneUnityBindInfoActivity.class);
          ((Intent)localObject1).putExtra("kSrouce", 18);
          startActivity((Intent)localObject1);
          break;
        case 6: 
          i = ((Intent)localObject1).getIntExtra("tab_tab_index", 0);
          ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchFeedsActivity(this, 1, i);
          break;
        case 5: 
          QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
          try
          {
            long l = Long.valueOf(this.app.getCurrentAccountUin()).longValue();
            localUserInfo.qzone_uin = String.valueOf(l);
            String str = this.app.getCurrentNickname();
            localObject1 = str;
            if (TextUtils.isEmpty(str)) {
              localObject1 = ContactUtils.f(this.app, String.valueOf(l));
            }
            localUserInfo.nickname = ((String)localObject1);
            QZoneHelper.forwardFromSearchToPersonalAlbum(this, localUserInfo, Long.valueOf(l), 0, false, -1);
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
            return;
          }
        case 4: 
          localException1.putExtra("selfSet_leftViewText", getString(2131887625));
          QfavHelper.a(this, this.app.getAccount(), localException1, -1, false);
          break;
        case 3: 
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("newflag", true);
          ((Intent)localObject2).putExtra("refer", "schemeActiveFeeds");
          QzonePluginProxyActivity.setActivityNameToIntent((Intent)localObject2, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
          ((Intent)localObject2).addFlags(805306368);
          QZoneHelper.forwardFromSearchToFriendFeed(this, this.app.getCurrentAccountUin(), (Intent)localObject2, -1);
          break;
        case 2: 
          ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).launchQWalletAct(this, this.app, true, false);
          break;
        case 1: 
          StoryApi.a(this, 23, ((Intent)localObject2).getLongExtra("uin", 0L));
          break;
        }
      } else {
        ((FunctionModuleConfigManager)this.app.getManager(QQManagerFactory.FUNCTION_MODULE_MANAGER)).e.a(this.a);
      }
    }
    else
    {
      localObject2 = ((Intent)localObject2).getStringExtra("key_click_web_search_fts_key");
      i = j;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject2 = ((String)localObject2).split("-");
      }
    }
    try
    {
      i = Integer.valueOf(localObject2[1]).intValue();
    }
    catch (Exception localException2)
    {
      label433:
      break label433;
    }
    i = j;
    if (QLog.isColorLevel())
    {
      QLog.e("IphoneTitleBarActivity", 2, " local result idStr parse error!");
      i = j;
    }
    Object localObject2 = ((FunctionModuleConfigManager)this.app.getManager(QQManagerFactory.FUNCTION_MODULE_MANAGER)).d;
    if (localObject2 != null)
    {
      this.a.setTag(2131449868, Integer.valueOf(i));
      ((ISearchResultModel)localObject2).a(this.a);
    }
    else
    {
      QLog.d("kueenie", 2, "result model is null");
    }
    finish();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.lebasearch.LebaSearchTransparentJumpActivity
 * JD-Core Version:    0.7.0.1
 */