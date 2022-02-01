package com.tencent.biz.qqstory.settings;

import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;

class QQStoryBasicSettingsActivity$1
  extends QQStoryObserver
{
  QQStoryBasicSettingsActivity$1(QQStoryBasicSettingsActivity paramQQStoryBasicSettingsActivity) {}
  
  public void b(int paramInt)
  {
    QQStoryBasicSettingsActivity.a(this.a);
    if (paramInt != -1)
    {
      if ((paramInt != 1001) && (paramInt != 1))
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return;
          }
          this.a.a(2);
          return;
        }
        this.a.a(1);
        return;
      }
      this.a.a(0);
      return;
    }
    QQToast.a(this.a, HardCodeUtil.a(2131710758), 0).b(this.a.getTitleBarHeight());
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b();
    }
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.a.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager;
      QQStoryBasicSettingsActivity localQQStoryBasicSettingsActivity = this.a;
      ((QQStoryManager)localObject).a(localQQStoryBasicSettingsActivity.b(localQQStoryBasicSettingsActivity.jdField_a_of_type_Int));
      localObject = this.a.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager;
      localQQStoryBasicSettingsActivity = this.a;
      ((QQStoryManager)localObject).b(localQQStoryBasicSettingsActivity.b(localQQStoryBasicSettingsActivity.jdField_a_of_type_Int));
      if (this.a.jdField_a_of_type_Int == 2)
      {
        StoryReportor.a("browse_friend_settings", "close", 0, 0, new String[] { "", "", "", "" });
        return;
      }
      if (this.a.jdField_a_of_type_Int == 0)
      {
        StoryReportor.a("browse_friend_settings", "choose_all", 0, 0, new String[] { "", "", "", "" });
        return;
      }
      if (this.a.jdField_a_of_type_Int == 1) {
        StoryReportor.a("browse_friend_settings", "choose_wifi", 0, 0, new String[] { "", "", "", "" });
      }
    }
    else
    {
      QQToast.a(this.a, 2131694712, 0).b(this.a.getTitleBarHeight());
      localObject = this.a;
      ((QQStoryBasicSettingsActivity)localObject).a(((QQStoryBasicSettingsActivity)localObject).b);
      this.a.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryBasicSettingsActivity.1
 * JD-Core Version:    0.7.0.1
 */