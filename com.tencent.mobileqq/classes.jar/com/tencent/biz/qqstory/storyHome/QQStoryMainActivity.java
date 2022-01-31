package com.tencent.biz.qqstory.storyHome;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import bddz;
import bkjr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Subscriber;
import java.util.Map;
import mqq.app.MobileQQ;
import ugx;
import upg;
import urk;
import urr;
import wcm;
import wcn;
import wsu;
import wsv;
import zcp;

public class QQStoryMainActivity
  extends QQStoryBaseActivity
{
  public static long a;
  protected QQStoryMainController a;
  NavBarCommon jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon;
  private zcp jdField_a_of_type_Zcp;
  
  public QQStoryMainActivity()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController = new QQStoryMainController(new wcm(this), QQStoryMainController.c);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon = ((NavBarCommon)findViewById(2131375812));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setOnItemSelectListener(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a);
    a(ugx.a);
  }
  
  private void a(Intent paramIntent)
  {
    try
    {
      if (paramIntent.getBooleanExtra("is_from_share", false))
      {
        String str = paramIntent.getStringExtra("struct_share_key_source_name");
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new QQStoryMainActivity.3(this, paramIntent, str), 1800L);
      }
      return;
    }
    catch (Exception paramIntent) {}
  }
  
  private void a(Intent paramIntent, String paramString)
  {
    if (this.jdField_a_of_type_Zcp == null) {
      this.jdField_a_of_type_Zcp = new zcp(this);
    }
    String str2 = this.app.getApplication().getString(2131719909);
    String str1 = str2;
    if (paramString != null) {
      str1 = str2 + paramString;
    }
    paramIntent = new wcn(this, paramIntent);
    this.jdField_a_of_type_Zcp.a(str1, paramIntent);
    this.jdField_a_of_type_Zcp.a(paramIntent);
    this.jdField_a_of_type_Zcp.show();
  }
  
  private void a(@NonNull String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(paramString, paramString);
  }
  
  private void a(@NonNull String paramString1, @NonNull String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(paramString1, paramString1, paramString2, paramString2);
  }
  
  protected void a(@NonNull Map<Subscriber, String> paramMap) {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.b();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.QQStoryMainActivity", 2, " doOnCreate");
    }
    wsv.d("Q.qqstory.home.QQStoryMainActivity", "QQStoryMainActivity start");
    this.mUseOptimizMode = true;
    jdField_a_of_type_Long = System.currentTimeMillis();
    super.doOnCreate(paramBundle);
    setContentView(2131561472);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a(paramBundle);
    a();
    int i = ((Integer)((urk)urr.a(10)).b("string_story_global_log_level", Integer.valueOf(-1))).intValue();
    wsu.a().a(i);
    bkjr.a(BaseApplicationImpl.getContext(), new QQStoryMainActivity.2(this), null);
    a(getIntent());
    return true;
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.QQStoryMainActivity", 2, " doOnDestroy");
    }
    super.doOnDestroy();
    jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.d(this);
    wsu.a().a(-1);
    upg.a().b();
    if (this.jdField_a_of_type_Zcp != null)
    {
      this.jdField_a_of_type_Zcp.dismiss();
      this.jdField_a_of_type_Zcp = null;
    }
    bddz.a().a();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a(paramIntent);
    a(paramIntent);
  }
  
  public void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.QQStoryMainActivity", 2, " doOnPause");
    }
    super.doOnPause();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a();
  }
  
  public void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.QQStoryMainActivity", 2, " doOnResume");
    }
    super.doOnResume();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.b(this);
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.b(paramBundle);
  }
  
  public void doOnStop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.QQStoryMainActivity", 2, " doOnStop");
    }
    super.doOnStop();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.c(this);
    bddz.a().a();
  }
  
  public void finish()
  {
    super.setResult(-1);
    super.finish();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    return super.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryMainActivity
 * JD-Core Version:    0.7.0.1
 */