package com.tencent.biz.qqstory.storyHome;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import bbeq;
import bihe;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Subscriber;
import java.util.Map;
import mqq.app.MobileQQ;
import ssi;
import tar;
import tcv;
import tdc;
import unx;
import uny;
import vef;
import veg;
import xnz;

public class QQStoryMainActivity
  extends QQStoryBaseActivity
{
  public static long a;
  protected QQStoryMainController a;
  NavBarCommon jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon;
  private xnz jdField_a_of_type_Xnz;
  
  public QQStoryMainActivity()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController = new QQStoryMainController(new unx(this), QQStoryMainController.c);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon = ((NavBarCommon)findViewById(2131375327));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setOnItemSelectListener(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a);
    a(ssi.a);
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
    if (this.jdField_a_of_type_Xnz == null) {
      this.jdField_a_of_type_Xnz = new xnz(this);
    }
    String str2 = this.app.getApplication().getString(2131719410);
    String str1 = str2;
    if (paramString != null) {
      str1 = str2 + paramString;
    }
    paramIntent = new uny(this, paramIntent);
    this.jdField_a_of_type_Xnz.a(str1, paramIntent);
    this.jdField_a_of_type_Xnz.a(paramIntent);
    this.jdField_a_of_type_Xnz.show();
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
    veg.d("Q.qqstory.home.QQStoryMainActivity", "QQStoryMainActivity start");
    this.mUseOptimizMode = true;
    jdField_a_of_type_Long = System.currentTimeMillis();
    super.doOnCreate(paramBundle);
    setContentView(2131561283);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.a(paramBundle);
    a();
    int i = ((Integer)((tcv)tdc.a(10)).b("string_story_global_log_level", Integer.valueOf(-1))).intValue();
    vef.a().a(i);
    bihe.a(BaseApplicationImpl.getContext(), new QQStoryMainActivity.2(this), null);
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
    vef.a().a(-1);
    tar.a().b();
    if (this.jdField_a_of_type_Xnz != null)
    {
      this.jdField_a_of_type_Xnz.dismiss();
      this.jdField_a_of_type_Xnz = null;
    }
    bbeq.a().a();
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
    bbeq.a().a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryMainActivity
 * JD-Core Version:    0.7.0.1
 */