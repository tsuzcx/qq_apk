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
      Object localObject = LayoutInflater.from(DetailBaseBlock.h(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$4.a)).inflate(2131558759, null, false);
      ((View)localObject).measure(0, 0);
      ((View)localObject).getMeasuredWidth();
      int i = ((View)localObject).getMeasuredHeight();
      ImageView localImageView = (ImageView)((View)localObject).findViewById(2131369446);
      DetailBaseBlock.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$4.a, new PopViewAnimationDrawableHelper(this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable));
      DetailBaseBlock.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$4.a).a(new DetailBaseBlock.4.1.1(this));
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.setOneShot(true);
      localImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable);
      this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$4.a.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow((View)localObject, -2, -2);
      this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$4.a.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
      this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$4.a.jdField_a_of_type_AndroidWidgetPopupWindow.setTouchable(true);
      localObject = new int[2];
      if (this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$4.a.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null)
      {
        if (this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$4.a.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a())
        {
          QLog.i(DetailBaseBlock.jdField_a_of_type_JavaLangString, 1, "mCommentBottomBar.isPraised");
          return;
        }
        if ((!this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$4.a.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.c()) && (!this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$4.a.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.d()))
        {
          int j = UIUtils.d(DetailBaseBlock.i(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$4.a));
          this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$4.a.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$4.a.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar, 53, -UIUtils.a(DetailBaseBlock.j(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$4.a), 32.0F), j - i - this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$4.a.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.getMeasuredHeight() + DisplayUtil.a(DetailBaseBlock.k(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$4.a), 10.0F));
          DetailBaseBlock.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$4.a).a();
          DetailBaseBlock.b(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$4.a, false);
          TimeAndCountHelper.a().a(DetailBaseBlock.l(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$4.a), "subscribe_sp_key_show_praise_guide", 1);
          AnimationDrawableFactory.a().a((String)SubscribeConstants.b.get("praise_guide_pics"));
          return;
        }
        DetailBaseBlock.b(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock$4.a, true);
        QLog.i(DetailBaseBlock.jdField_a_of_type_JavaLangString, 1, "isShowCommentList or isAddCommentMode");
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