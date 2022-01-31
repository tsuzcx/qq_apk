package com.tencent.biz.qqstory.storyHome;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.QQStoryLoggingDelegate;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import dov.com.qq.im.QIMShortVideoUtils;
import java.util.Map;
import nyc;

public class QQStoryMainActivity
  extends QQStoryBaseActivity
{
  public static long a;
  protected QQStoryMainController a;
  NavBarCommon a;
  
  public QQStoryMainActivity()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController = new QQStoryMainController(new nyc(this), QQStoryMainController.c);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon = ((NavBarCommon)findViewById(2131363261));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setOnItemSelectListener(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a);
    c("小视频");
  }
  
  private void a(@NonNull String paramString1, @NonNull String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(paramString1, paramString1, paramString2, paramString2);
  }
  
  private void c(@NonNull String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(paramString, paramString);
  }
  
  protected void a(@NonNull Map paramMap) {}
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.c();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    SLog.d("Q.qqstory.home.QQStoryMainActivity", "QQStoryMainActivity start");
    this.mUseOptimizMode = true;
    jdField_a_of_type_Long = System.currentTimeMillis();
    super.doOnCreate(paramBundle);
    setContentView(2130970779);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a(paramBundle);
    a();
    int i = ((Integer)((StoryConfigManager)SuperManager.a(10)).b("string_story_global_log_level", Integer.valueOf(-1))).intValue();
    QQStoryLoggingDelegate.a().a(i);
    QIMShortVideoUtils.a(BaseApplicationImpl.getContext());
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.d();
    QQStoryLoggingDelegate.a().a(-1);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a(paramIntent);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.b();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a();
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.b(paramBundle);
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.c();
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
  
  public boolean onBackEvent()
  {
    return super.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryMainActivity
 * JD-Core Version:    0.7.0.1
 */