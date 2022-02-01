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
  public void a(View paramView)
  {
    QQStoryMemoriesActivity.a(this.d, 2, QQStoryContext.a().i(), true);
    com.tencent.mobileqq.activity.recent.DrawerFrame.b = QQSettingMe.a;
  }
  
  public void a(QQSettingMe paramQQSettingMe) {}
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean) {}
  
  public String b()
  {
    return "d_video";
  }
  
  public void d()
  {
    super.d();
    QQStoryManager localQQStoryManager = (QQStoryManager)this.c.getManager(QQManagerFactory.QQSTORY_MANAGER);
    if ((localQQStoryManager != null) && (localQQStoryManager.h()))
    {
      QQSettingMe.b("d_video").setVisibility(0);
      return;
    }
    QQSettingMe.b("d_video").setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeVideoProcessor
 * JD-Core Version:    0.7.0.1
 */