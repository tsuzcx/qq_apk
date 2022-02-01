package com.tencent.biz.qqstory.storyHome;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import com.tencent.aelight.camera.util.api.IQIMShortVideoUtil;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.comment.StoryFailCommentCacher;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.QQStoryLoggingDelegate;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.widgets.ShareAioResultDialog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.MessageProgressController;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Subscriber;
import java.util.Map;
import mqq.app.MobileQQ;

public class QQStoryMainActivity
  extends QQStoryBaseActivity
{
  public static long a;
  protected QQStoryMainController a;
  private ShareAioResultDialog jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = null;
  public AppInterface a;
  NavBarCommon jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon;
  private boolean jdField_a_of_type_Boolean = false;
  
  public QQStoryMainActivity()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController = new QQStoryMainController(new QQStoryMainActivity.1(this), QQStoryMainController.c);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon = ((NavBarCommon)findViewById(2131376636));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setOnItemSelectListener(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a);
    a(QQStoryConstant.a);
  }
  
  private void a(Intent paramIntent)
  {
    try
    {
      if (paramIntent.getBooleanExtra("is_from_share", false))
      {
        String str = paramIntent.getStringExtra("struct_share_key_source_name");
        this.mHandler.postDelayed(new QQStoryMainActivity.3(this, paramIntent, str), 1800L);
      }
      return;
    }
    catch (Exception paramIntent) {}
  }
  
  private void a(Intent paramIntent, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog == null) {
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = new ShareAioResultDialog(this);
    }
    String str = this.app.getApplication().getString(2131718866);
    Object localObject = str;
    if (paramString != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    paramIntent = new QQStoryMainActivity.4(this, paramIntent);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a((String)localObject, paramIntent);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(paramIntent);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.show();
  }
  
  private void a(@NonNull String paramString)
  {
    NavBarCommon localNavBarCommon = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon;
    if (localNavBarCommon == null) {
      return;
    }
    localNavBarCommon.setTitle(paramString, paramString);
  }
  
  private void a(@NonNull String paramString1, @NonNull String paramString2)
  {
    NavBarCommon localNavBarCommon = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon;
    if (localNavBarCommon == null) {
      return;
    }
    localNavBarCommon.setTitle(paramString1, paramString1, paramString2, paramString2);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.b();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.QQStoryMainActivity", 2, " doOnCreate");
    }
    SLog.d("Q.qqstory.home.QQStoryMainActivity", "QQStoryMainActivity start");
    this.mUseOptimizMode = true;
    jdField_a_of_type_Long = System.currentTimeMillis();
    super.doOnCreate(paramBundle);
    setContentView(2131561695);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a(paramBundle);
    a();
    int i = ((Integer)((StoryConfigManager)SuperManager.a(10)).b("string_story_global_log_level", Integer.valueOf(-1))).intValue();
    QQStoryLoggingDelegate.a().a(i);
    ((IQIMShortVideoUtil)QRoute.api(IQIMShortVideoUtil.class)).preLoadPeakProcess(BaseApplicationImpl.getContext(), new QQStoryMainActivity.2(this), null);
    a(getIntent());
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.QQStoryMainActivity", 2, " doOnDestroy");
    }
    super.doOnDestroy();
    jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.d(this);
    QQStoryLoggingDelegate.a().a(-1);
    StoryFailCommentCacher.a().b();
    ShareAioResultDialog localShareAioResultDialog = this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog;
    if (localShareAioResultDialog != null)
    {
      localShareAioResultDialog.dismiss();
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = null;
    }
    MessageProgressController.a().a();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a(paramIntent);
    a(paramIntent);
  }
  
  protected void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.QQStoryMainActivity", 2, " doOnPause");
    }
    super.doOnPause();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a();
  }
  
  protected void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.QQStoryMainActivity", 2, " doOnResume");
    }
    super.doOnResume();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.b(this);
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.b(paramBundle);
  }
  
  protected void doOnStop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.QQStoryMainActivity", 2, " doOnStop");
    }
    super.doOnStop();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.c(this);
    MessageProgressController.a().a();
  }
  
  public void finish()
  {
    super.setResult(-1);
    super.finish();
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    return super.onBackEvent();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreateSubscribers(@NonNull Map<Subscriber, String> paramMap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryMainActivity
 * JD-Core Version:    0.7.0.1
 */