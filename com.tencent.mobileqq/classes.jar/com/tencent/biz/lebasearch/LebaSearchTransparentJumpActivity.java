package com.tencent.biz.lebasearch;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.FunctionModuleConfigManager;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.NetSearchTemplateBaseItem;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavHelper;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QzonePluginProxyActivity;

public class LebaSearchTransparentJumpActivity
  extends IphoneTitleBarActivity
{
  public View a;
  
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
    FunctionModuleConfigManager localFunctionModuleConfigManager = (FunctionModuleConfigManager)this.app.getManager(221);
    if (localFunctionModuleConfigManager.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultModel != null) {
      localFunctionModuleConfigManager.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultModel = null;
    }
    if (localFunctionModuleConfigManager.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateBaseItem != null) {
      localFunctionModuleConfigManager.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateBaseItem = null;
    }
  }
  
  protected void doOnResume()
  {
    int j = 0;
    super.doOnResume();
    Object localObject1 = getIntent();
    switch (((Intent)localObject1).getIntExtra("key_business", 0))
    {
    }
    for (;;)
    {
      finish();
      return;
      StoryApi.a(this, 23, ((Intent)localObject1).getLongExtra("uin", 0L));
      continue;
      QWalletHelper.launchQWalletAct(this, this.app, true);
      continue;
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("newflag", true);
      ((Intent)localObject1).putExtra("refer", "schemeActiveFeeds");
      QzonePluginProxyActivity.a((Intent)localObject1, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
      ((Intent)localObject1).addFlags(805306368);
      QZoneHelper.b(this, this.app.getCurrentAccountUin(), (Intent)localObject1, -1);
      continue;
      ((Intent)localObject1).putExtra("selfSet_leftViewText", getString(2131433698));
      QfavHelper.a(this, this.app.getAccount(), (Intent)localObject1, -1, false);
      continue;
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
      try
      {
        long l = Long.valueOf(this.app.getCurrentAccountUin()).longValue();
        localUserInfo.a = String.valueOf(l);
        String str = this.app.getCurrentNickname();
        localObject1 = str;
        if (TextUtils.isEmpty(str)) {
          localObject1 = ContactUtils.j(this.app, String.valueOf(l));
        }
        localUserInfo.b = ((String)localObject1);
        QZoneHelper.a(this, localUserInfo, Long.valueOf(l), 0, false, -1);
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        return;
      }
      int i = localException1.getIntExtra("tab_tab_index", 0);
      ReadInJoyActivityHelper.a(this.app, this, 1, i);
      continue;
      Object localObject2 = new Intent(this, PhoneUnityBindInfoActivity.class);
      ((Intent)localObject2).putExtra("kSrouce", 18);
      startActivity((Intent)localObject2);
      continue;
      localObject2 = ((Intent)localObject2).getStringExtra("key_click_web_search_fts_key");
      i = j;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject2 = ((String)localObject2).split("-");
      }
      try
      {
        i = Integer.valueOf(localObject2[1]).intValue();
        localObject2 = ((FunctionModuleConfigManager)this.app.getManager(221)).jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultModel;
        if (localObject2 != null)
        {
          this.a.setTag(2131362080, Integer.valueOf(i));
          ((ISearchResultModel)localObject2).a(this.a);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.e("IphoneTitleBarActivity", 2, " local result idStr parse error!");
            i = j;
          }
        }
        QLog.d("kueenie", 2, "result model is null");
      }
      continue;
      ((FunctionModuleConfigManager)this.app.getManager(221)).jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateBaseItem.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.lebasearch.LebaSearchTransparentJumpActivity
 * JD-Core Version:    0.7.0.1
 */