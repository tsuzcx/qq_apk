package com.tencent.biz.qqstory.msgTabNode.view;

import aekt;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.views.RoundBorderImageView;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationParam;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.dispatch.Dispatcher;
import uht;
import uuq;
import uvz;
import uwn;
import vjf;
import wsv;

public class MsgTabStoryNodeDelegate$3
  implements Runnable
{
  public MsgTabStoryNodeDelegate$3(uvz paramuvz, String paramString) {}
  
  public void run()
  {
    int j = this.this$0.jdField_a_of_type_Uwn.a.a.getChildCount();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Object localObject = this.this$0.jdField_a_of_type_Uwn.a.a.getChildAt(i);
        if ((TextUtils.equals(this.a, String.valueOf(((View)localObject).getTag()))) && ((localObject instanceof StoryMsgNodeFrameLayout)))
        {
          localObject = (StoryMsgNodeFrameLayout)localObject;
          if (localObject != null)
          {
            Rect localRect = new Rect();
            ((StoryMsgNodeFrameLayout)localObject).getGlobalVisibleRect(localRect);
            uuq localuuq = (uuq)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(251);
            localuuq.a = (localRect.left + ((StoryMsgNodeFrameLayout)localObject).getWidth() / 2);
            localuuq.b = (localRect.top + ((StoryMsgNodeFrameLayout)localObject).getHeight() / 2);
            wsv.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "handlePlayModeSwitchNode findView. x=%d, y=%d, rect=%s", Integer.valueOf(localuuq.a), Integer.valueOf(localuuq.b), String.valueOf(localRect));
            RoundBorderImageView localRoundBorderImageView = ((StoryMsgNodeFrameLayout)localObject).a;
            localRoundBorderImageView.getGlobalVisibleRect(localRect);
            localuuq.c = (localRect.top + localRoundBorderImageView.getPaddingTop());
            localuuq.d = (localRect.left + localRoundBorderImageView.getPaddingLeft());
            localuuq.e = (localRect.width() - localRoundBorderImageView.getPaddingLeft() - localRoundBorderImageView.getPaddingRight());
            localuuq.f = (localRect.height() - localRoundBorderImageView.getPaddingTop() - localRoundBorderImageView.getPaddingBottom());
            localuuq.g = aekt.a(8.0F, this.this$0.jdField_a_of_type_Uwn.a.getResources());
            uht.a().dispatch(new vjf(new AnimationParam(((StoryMsgNodeFrameLayout)localObject).a, false), null));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.3
 * JD-Core Version:    0.7.0.1
 */