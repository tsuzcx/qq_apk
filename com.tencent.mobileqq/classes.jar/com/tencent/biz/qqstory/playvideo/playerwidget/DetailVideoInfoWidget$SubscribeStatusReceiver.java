package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.MainPageChangeEvent;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.Dispatcher;

class DetailVideoInfoWidget$SubscribeStatusReceiver
  extends QQStoryObserver
{
  public String a;
  
  private DetailVideoInfoWidget$SubscribeStatusReceiver(DetailVideoInfoWidget paramDetailVideoInfoWidget) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    super.a(paramBoolean1, paramBoolean2, paramInt, paramString);
    boolean bool = TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString);
    if (bool) {
      this.jdField_a_of_type_JavaLangString = null;
    }
    StoryVideoItem localStoryVideoItem;
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetDetailVideoInfoWidget.a != null)
    {
      localStoryVideoItem = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetDetailVideoInfoWidget.a.a();
      if (localStoryVideoItem != null) {
        break label64;
      }
    }
    label64:
    label326:
    do
    {
      do
      {
        UserManager localUserManager;
        QQUserUIItem localQQUserUIItem;
        do
        {
          return;
          localStoryVideoItem = null;
          break;
          localUserManager = (UserManager)SuperManager.a(2);
          localQQUserUIItem = localUserManager.b(localStoryVideoItem.mOwnerUid);
        } while ((localQQUserUIItem == null) || (!TextUtils.equals(paramString, localQQUserUIItem.getUnionId())));
        if (paramBoolean1)
        {
          if (paramBoolean2) {}
          for (paramInt = 1;; paramInt = 0)
          {
            localQQUserUIItem.isSubscribe = paramInt;
            ThreadManager.post(new DetailVideoInfoWidget.SubscribeStatusReceiver.1(this, localUserManager, localQQUserUIItem), 5, null, false);
            if (paramBoolean2)
            {
              paramString = (QQStoryManager)PlayModeUtils.a().getManager(QQManagerFactory.QQSTORY_MANAGER);
              if (!paramString.g())
              {
                paramString.c();
                QQToast.a(PlayModeUtils.a(), 2, HardCodeUtil.a(2131703191), 0).a();
              }
              paramString = new MainPageChangeEvent(2);
              StoryDispatcher.a().dispatch(paramString);
            }
            DetailVideoInfoWidget.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetDetailVideoInfoWidget, localStoryVideoItem, localQQUserUIItem);
            if (!bool) {
              break;
            }
            StoryReportor.a("play_video", "follow_suc", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
            return;
          }
        }
        if (!paramBoolean2) {
          break label326;
        }
        QQToast.a(PlayModeUtils.a(), 1, HardCodeUtil.a(2131703190), 0).a();
      } while (!bool);
      StoryReportor.a("play_video", "follow_fail", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
      return;
      QQToast.a(PlayModeUtils.a(), 1, HardCodeUtil.a(2131703188), 0).a();
    } while (!bool);
    StoryReportor.a("play_video", "unfollow_fail", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.DetailVideoInfoWidget.SubscribeStatusReceiver
 * JD-Core Version:    0.7.0.1
 */