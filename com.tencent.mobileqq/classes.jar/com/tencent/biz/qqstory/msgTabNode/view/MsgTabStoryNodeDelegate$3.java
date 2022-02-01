package com.tencent.biz.qqstory.msgTabNode.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.views.RoundBorderImageView;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationParam;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tribe.async.dispatch.Dispatcher;
import wad;
import wmr;
import woa;
import woo;
import xba;
import ykq;

public class MsgTabStoryNodeDelegate$3
  implements Runnable
{
  public MsgTabStoryNodeDelegate$3(woa paramwoa, String paramString) {}
  
  public void run()
  {
    int j = this.this$0.jdField_a_of_type_Woo.a.a.getChildCount();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Object localObject = this.this$0.jdField_a_of_type_Woo.a.a.getChildAt(i);
        if ((TextUtils.equals(this.a, String.valueOf(((View)localObject).getTag()))) && ((localObject instanceof StoryMsgNodeFrameLayout)))
        {
          localObject = (StoryMsgNodeFrameLayout)localObject;
          if (localObject != null)
          {
            Rect localRect = new Rect();
            ((StoryMsgNodeFrameLayout)localObject).getGlobalVisibleRect(localRect);
            wmr localwmr = (wmr)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MSG_TAB_STORY_MANAGER);
            localwmr.a = (localRect.left + ((StoryMsgNodeFrameLayout)localObject).getWidth() / 2);
            localwmr.b = (localRect.top + ((StoryMsgNodeFrameLayout)localObject).getHeight() / 2);
            ykq.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "handlePlayModeSwitchNode findView. x=%d, y=%d, rect=%s", Integer.valueOf(localwmr.a), Integer.valueOf(localwmr.b), String.valueOf(localRect));
            RoundBorderImageView localRoundBorderImageView = ((StoryMsgNodeFrameLayout)localObject).a;
            localRoundBorderImageView.getGlobalVisibleRect(localRect);
            localwmr.c = (localRect.top + localRoundBorderImageView.getPaddingTop());
            localwmr.d = (localRect.left + localRoundBorderImageView.getPaddingLeft());
            localwmr.e = (localRect.width() - localRoundBorderImageView.getPaddingLeft() - localRoundBorderImageView.getPaddingRight());
            localwmr.f = (localRect.height() - localRoundBorderImageView.getPaddingTop() - localRoundBorderImageView.getPaddingBottom());
            localwmr.g = AIOUtils.dp2px(8.0F, this.this$0.jdField_a_of_type_Woo.a.getResources());
            wad.a().dispatch(new xba(new AnimationParam(((StoryMsgNodeFrameLayout)localObject).a, false), null));
          }
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.3
 * JD-Core Version:    0.7.0.1
 */