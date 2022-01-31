package com.tencent.biz.qqstory.msgTabNode.view;

import aciy;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.views.RoundBorderImageView;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationParam;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.dispatch.Dispatcher;
import sgi;
import stf;
import suo;
import svc;
import thu;
import urk;

public class MsgTabStoryNodeDelegate$3
  implements Runnable
{
  public MsgTabStoryNodeDelegate$3(suo paramsuo, String paramString) {}
  
  public void run()
  {
    int j = this.this$0.jdField_a_of_type_Svc.a.a.getChildCount();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Object localObject = this.this$0.jdField_a_of_type_Svc.a.a.getChildAt(i);
        if ((TextUtils.equals(this.a, String.valueOf(((View)localObject).getTag()))) && ((localObject instanceof StoryMsgNodeFrameLayout)))
        {
          localObject = (StoryMsgNodeFrameLayout)localObject;
          if (localObject != null)
          {
            Rect localRect = new Rect();
            ((StoryMsgNodeFrameLayout)localObject).getGlobalVisibleRect(localRect);
            stf localstf = (stf)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(251);
            localstf.a = (localRect.left + ((StoryMsgNodeFrameLayout)localObject).getWidth() / 2);
            localstf.b = (localRect.top + ((StoryMsgNodeFrameLayout)localObject).getHeight() / 2);
            urk.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "handlePlayModeSwitchNode findView. x=%d, y=%d, rect=%s", Integer.valueOf(localstf.a), Integer.valueOf(localstf.b), String.valueOf(localRect));
            RoundBorderImageView localRoundBorderImageView = ((StoryMsgNodeFrameLayout)localObject).a;
            localRoundBorderImageView.getGlobalVisibleRect(localRect);
            localstf.c = (localRect.top + localRoundBorderImageView.getPaddingTop());
            localstf.d = (localRect.left + localRoundBorderImageView.getPaddingLeft());
            localstf.e = (localRect.width() - localRoundBorderImageView.getPaddingLeft() - localRoundBorderImageView.getPaddingRight());
            localstf.f = (localRect.height() - localRoundBorderImageView.getPaddingTop() - localRoundBorderImageView.getPaddingBottom());
            localstf.g = aciy.a(8.0F, this.this$0.jdField_a_of_type_Svc.a.getResources());
            sgi.a().dispatch(new thu(new AnimationParam(((StoryMsgNodeFrameLayout)localObject).a, false), null));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.3
 * JD-Core Version:    0.7.0.1
 */