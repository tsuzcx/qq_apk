package com.tencent.biz.subscribe.comment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CommentBottomBar$2
  implements View.OnClickListener
{
  CommentBottomBar$2(CommentBottomBar paramCommentBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.isNetworkAvailable(this.a.getContext())) {
      QQToast.a(this.a.getContext(), HardCodeUtil.a(2131694427), 0).a();
    }
    this.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentBottomBar.2
 * JD-Core Version:    0.7.0.1
 */