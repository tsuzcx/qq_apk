package com.tencent.biz.subscribe.bizdapters;

import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
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
        Object localObject = LayoutInflater.from(DetailBaseBlock.b(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$3.a)).inflate(2131558860, null, false);
        ((View)localObject).measure(0, 0);
        ((View)localObject).getMeasuredWidth();
        i = ((View)localObject).getMeasuredHeight();
        ImageView localImageView = (ImageView)((View)localObject).findViewById(2131369662);
        DetailBaseBlock.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$3.a, new PopViewAnimationDrawableHelper(this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable));
        DetailBaseBlock.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$3.a).a(new DetailBaseBlock.3.1.1(this));
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.setOneShot(true);
        localImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable);
        this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$3.a.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow((View)localObject, -2, -2);
        this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$3.a.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
        this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$3.a.jdField_a_of_type_AndroidWidgetPopupWindow.setTouchable(true);
        localObject = new int[2];
        if ((DetailBaseBlock.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$3.a) == null) || (this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$3.a.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar == null)) {
          break;
        }
        if ((this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$3.a.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.c()) || (this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$3.a.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.d()))
        {
          DetailBaseBlock.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$3.a, true);
          QLog.i(DetailBaseBlock.jdField_a_of_type_JavaLangString, 1, "isShowCommentList or isAddCommentMode");
          return;
        }
        DetailBaseBlock.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$3.a).getLocationOnScreen((int[])localObject);
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.setOneShot(true);
        if (DetailBaseBlock.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$3.a))
        {
          i = localObject[1] - i + DisplayUtil.b(DetailBaseBlock.c(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$3.a), 100.0F);
          this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$3.a.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(DetailBaseBlock.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$3.a), 53, 0, i);
          DetailBaseBlock.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$3.a).a();
          DetailBaseBlock.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$3.a, false);
          TimeAndCountHelper.a().a(DetailBaseBlock.d(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$3.a), "subscribe_sp_key_show_follow_guide", 1);
          TimeAndCountHelper.a().a(DetailBaseBlock.e(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$3.a), "subscribe_freshman_interaction_guide", 1);
          AnimationDrawableFactory.a().a((String)SubscribeConstants.b.get("follow_guide_pics"));
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      int i = localException[1];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.DetailBaseBlock.3.1
 * JD-Core Version:    0.7.0.1
 */