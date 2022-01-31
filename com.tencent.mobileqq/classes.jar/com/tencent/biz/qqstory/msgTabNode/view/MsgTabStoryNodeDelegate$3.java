package com.tencent.biz.qqstory.msgTabNode.view;

import aepi;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.views.RoundBorderImageView;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationParam;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.dispatch.Dispatcher;
import umc;
import uyz;
import vai;
import vaw;
import vno;
import wxe;

public class MsgTabStoryNodeDelegate$3
  implements Runnable
{
  public MsgTabStoryNodeDelegate$3(vai paramvai, String paramString) {}
  
  public void run()
  {
    int j = this.this$0.jdField_a_of_type_Vaw.a.a.getChildCount();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Object localObject = this.this$0.jdField_a_of_type_Vaw.a.a.getChildAt(i);
        if ((TextUtils.equals(this.a, String.valueOf(((View)localObject).getTag()))) && ((localObject instanceof StoryMsgNodeFrameLayout)))
        {
          localObject = (StoryMsgNodeFrameLayout)localObject;
          if (localObject != null)
          {
            Rect localRect = new Rect();
            ((StoryMsgNodeFrameLayout)localObject).getGlobalVisibleRect(localRect);
            uyz localuyz = (uyz)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(251);
            localuyz.a = (localRect.left + ((StoryMsgNodeFrameLayout)localObject).getWidth() / 2);
            localuyz.b = (localRect.top + ((StoryMsgNodeFrameLayout)localObject).getHeight() / 2);
            wxe.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "handlePlayModeSwitchNode findView. x=%d, y=%d, rect=%s", Integer.valueOf(localuyz.a), Integer.valueOf(localuyz.b), String.valueOf(localRect));
            RoundBorderImageView localRoundBorderImageView = ((StoryMsgNodeFrameLayout)localObject).a;
            localRoundBorderImageView.getGlobalVisibleRect(localRect);
            localuyz.c = (localRect.top + localRoundBorderImageView.getPaddingTop());
            localuyz.d = (localRect.left + localRoundBorderImageView.getPaddingLeft());
            localuyz.e = (localRect.width() - localRoundBorderImageView.getPaddingLeft() - localRoundBorderImageView.getPaddingRight());
            localuyz.f = (localRect.height() - localRoundBorderImageView.getPaddingTop() - localRoundBorderImageView.getPaddingBottom());
            localuyz.g = aepi.a(8.0F, this.this$0.jdField_a_of_type_Vaw.a.getResources());
            umc.a().dispatch(new vno(new AnimationParam(((StoryMsgNodeFrameLayout)localObject).a, false), null));
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