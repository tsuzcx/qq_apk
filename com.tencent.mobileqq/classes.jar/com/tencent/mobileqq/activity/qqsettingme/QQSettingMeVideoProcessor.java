package com.tencent.mobileqq.activity.qqsettingme;

import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.storyHome.memory.QQStoryMemoriesActivity;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import mqq.app.AppRuntime;

public class QQSettingMeVideoProcessor
  extends QQSettingMeBaseMenuProcessor
{
  public String a()
  {
    return "d_video";
  }
  
  public void a(View paramView)
  {
    QQStoryMemoriesActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2, QQStoryContext.a().b(), true);
    com.tencent.mobileqq.activity.recent.DrawerFrame.a = QQSettingMe.a;
  }
  
  public void a(QQSettingMe paramQQSettingMe) {}
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean) {}
  
  public void b()
  {
    super.b();
    QQStoryManager localQQStoryManager = (QQStoryManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.QQSTORY_MANAGER);
    if ((localQQStoryManager != null) && (localQQStoryManager.e()))
    {
      QQSettingMe.a("d_video").setVisibility(0);
      return;
    }
    QQSettingMe.a("d_video").setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeVideoProcessor
 * JD-Core Version:    0.7.0.1
 */