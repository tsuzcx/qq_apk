package com.tencent.biz.pubaccount.weishi_new.comment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WSCommentEmoController$3
  implements View.OnClickListener
{
  WSCommentEmoController$3(WSCommentEmoController paramWSCommentEmoController) {}
  
  public void onClick(View paramView)
  {
    WSCommentEmoController.a(this.a).deleteEmoticonClick();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WSCommentEmoController.3
 * JD-Core Version:    0.7.0.1
 */