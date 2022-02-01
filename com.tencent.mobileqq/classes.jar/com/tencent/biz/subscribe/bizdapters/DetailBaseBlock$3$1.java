package com.tencent.biz.subscribe.bizdapters;

import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.subscribe.SubscribeConstants;
import com.tencent.biz.subscribe.animation.PopViewAnimationDrawableHelper;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.biz.subscribe.utils.TimeAndCountHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class DetailBaseBlock$3$1
  implements Runnable
{
  DetailBaseBlock$3$1(DetailBaseBlock.3 param3, AnimationDrawable paramAnimationDrawable) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Object localObject = LayoutInflater.from(DetailBaseBlock.b(this.b.a)).inflate(2131624378, null, false);
        ((View)localObject).measure(0, 0);
        ((View)localObject).getMeasuredWidth();
        i = ((View)localObject).getMeasuredHeight();
        ImageView localImageView = (ImageView)((View)localObject).findViewById(2131436383);
        DetailBaseBlock.a(this.b.a, new PopViewAnimationDrawableHelper(this.a));
        DetailBaseBlock.c(this.b.a).a(new DetailBaseBlock.3.1.1(this));
        this.a.setOneShot(true);
        localImageView.setImageDrawable(this.a);
        this.b.a.f = new PopupWindow((View)localObject, -2, -2);
        this.b.a.f.setOutsideTouchable(true);
        this.b.a.f.setTouchable(true);
        localObject = new int[2];
        if ((DetailBaseBlock.d(this.b.a) != null) && (this.b.a.b != null))
        {
          if ((!this.b.a.b.h()) && (!this.b.a.b.i()))
          {
            DetailBaseBlock.d(this.b.a).getLocationOnScreen((int[])localObject);
            this.a.setOneShot(true);
            if (!DetailBaseBlock.e(this.b.a)) {
              break label417;
            }
            i = localObject[1] - i + UIUtils.a(DetailBaseBlock.f(this.b.a), 100.0F);
            this.b.a.f.showAtLocation(DetailBaseBlock.d(this.b.a), 53, 0, i);
            DetailBaseBlock.c(this.b.a).a();
            DetailBaseBlock.a(this.b.a, false);
            TimeAndCountHelper.a().a(DetailBaseBlock.g(this.b.a), "subscribe_sp_key_show_follow_guide", 1);
            TimeAndCountHelper.a().a(DetailBaseBlock.h(this.b.a), "subscribe_freshman_interaction_guide", 1);
            AnimationDrawableFactory.a().a((String)SubscribeConstants.f.get("follow_guide_pics"));
            return;
          }
          DetailBaseBlock.a(this.b.a, true);
          QLog.i(DetailBaseBlock.a, 1, "isShowCommentList or isAddCommentMode");
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return;
      label417:
      int i = localException[1];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.DetailBaseBlock.3.1
 * JD-Core Version:    0.7.0.1
 */