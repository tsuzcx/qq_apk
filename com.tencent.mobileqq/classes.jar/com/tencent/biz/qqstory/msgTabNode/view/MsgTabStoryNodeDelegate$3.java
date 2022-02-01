package com.tencent.biz.qqstory.msgTabNode.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.views.RoundBorderImageView;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.playvideo.StoryPlayerActivity.ClosePlayerAnimationInfoEvent;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationParam;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tribe.async.dispatch.Dispatcher;

class MsgTabStoryNodeDelegate$3
  implements Runnable
{
  MsgTabStoryNodeDelegate$3(MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate, String paramString) {}
  
  public void run()
  {
    int j = this.this$0.b.o.c.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.this$0.b.o.c.getChildAt(i);
      if ((TextUtils.equals(this.a, String.valueOf(((View)localObject).getTag()))) && ((localObject instanceof StoryMsgNodeFrameLayout)))
      {
        localObject = (StoryMsgNodeFrameLayout)localObject;
        if (localObject != null)
        {
          Rect localRect = new Rect();
          ((StoryMsgNodeFrameLayout)localObject).getGlobalVisibleRect(localRect);
          MsgTabStoryManager localMsgTabStoryManager = (MsgTabStoryManager)this.this$0.g.getManager(QQManagerFactory.MSG_TAB_STORY_MANAGER);
          localMsgTabStoryManager.c = (localRect.left + ((StoryMsgNodeFrameLayout)localObject).getWidth() / 2);
          localMsgTabStoryManager.d = (localRect.top + ((StoryMsgNodeFrameLayout)localObject).getHeight() / 2);
          SLog.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "handlePlayModeSwitchNode findView. x=%d, y=%d, rect=%s", Integer.valueOf(localMsgTabStoryManager.c), Integer.valueOf(localMsgTabStoryManager.d), String.valueOf(localRect));
          RoundBorderImageView localRoundBorderImageView = ((StoryMsgNodeFrameLayout)localObject).a;
          localRoundBorderImageView.getGlobalVisibleRect(localRect);
          localMsgTabStoryManager.e = (localRect.top + localRoundBorderImageView.getPaddingTop());
          localMsgTabStoryManager.f = (localRect.left + localRoundBorderImageView.getPaddingLeft());
          localMsgTabStoryManager.g = (localRect.width() - localRoundBorderImageView.getPaddingLeft() - localRoundBorderImageView.getPaddingRight());
          localMsgTabStoryManager.h = (localRect.height() - localRoundBorderImageView.getPaddingTop() - localRoundBorderImageView.getPaddingBottom());
          localMsgTabStoryManager.i = AIOUtils.b(8.0F, this.this$0.b.o.getResources());
          StoryDispatcher.a().dispatch(new StoryPlayerActivity.ClosePlayerAnimationInfoEvent(new AnimationParam(((StoryMsgNodeFrameLayout)localObject).a, false), null));
          return;
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.3
 * JD-Core Version:    0.7.0.1
 */