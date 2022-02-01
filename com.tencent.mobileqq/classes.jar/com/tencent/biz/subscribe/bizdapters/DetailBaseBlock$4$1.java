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
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class DetailBaseBlock$4$1
  implements Runnable
{
  DetailBaseBlock$4$1(DetailBaseBlock.4 param4, AnimationDrawable paramAnimationDrawable) {}
  
  public void run()
  {
    try
    {
      Object localObject = LayoutInflater.from(DetailBaseBlock.k(this.b.a)).inflate(2131624379, null, false);
      ((View)localObject).measure(0, 0);
      ((View)localObject).getMeasuredWidth();
      int i = ((View)localObject).getMeasuredHeight();
      ImageView localImageView = (ImageView)((View)localObject).findViewById(2131436502);
      DetailBaseBlock.a(this.b.a, new PopViewAnimationDrawableHelper(this.a));
      DetailBaseBlock.c(this.b.a).a(new DetailBaseBlock.4.1.1(this));
      this.a.setOneShot(true);
      localImageView.setImageDrawable(this.a);
      this.b.a.f = new PopupWindow((View)localObject, -2, -2);
      this.b.a.f.setOutsideTouchable(true);
      this.b.a.f.setTouchable(true);
      localObject = new int[2];
      if (this.b.a.b != null)
      {
        if (this.b.a.b.c())
        {
          QLog.i(DetailBaseBlock.a, 1, "mCommentBottomBar.isPraised");
          return;
        }
        if ((!this.b.a.b.h()) && (!this.b.a.b.i()))
        {
          int j = UIUtils.e(DetailBaseBlock.l(this.b.a));
          this.b.a.f.showAtLocation(this.b.a.b, 53, -UIUtils.a(DetailBaseBlock.m(this.b.a), 32.0F), j - i - this.b.a.b.getMeasuredHeight() + DisplayUtil.a(DetailBaseBlock.n(this.b.a), 10.0F));
          DetailBaseBlock.c(this.b.a).a();
          DetailBaseBlock.b(this.b.a, false);
          TimeAndCountHelper.a().a(DetailBaseBlock.o(this.b.a), "subscribe_sp_key_show_praise_guide", 1);
          AnimationDrawableFactory.a().a((String)SubscribeConstants.f.get("praise_guide_pics"));
          return;
        }
        DetailBaseBlock.b(this.b.a, true);
        QLog.i(DetailBaseBlock.a, 1, "isShowCommentList or isAddCommentMode");
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.DetailBaseBlock.4.1
 * JD-Core Version:    0.7.0.1
 */