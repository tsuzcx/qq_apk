package com.tencent.biz.pubaccount.weishi_new.comment;

import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.text.TextUtils;

class WSCommentEmoController$2
  extends WSSimpleEmoticonCallback
{
  WSCommentEmoController$2(WSCommentEmoController paramWSCommentEmoController) {}
  
  public void delete()
  {
    if (WSCommentEmoController.a(this.a) != null) {
      TextUtils.backspace(WSCommentEmoController.a(this.a));
    }
  }
  
  public void send(EmoticonInfo paramEmoticonInfo)
  {
    WSCommentEmoController.a(this.a, paramEmoticonInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WSCommentEmoController.2
 * JD-Core Version:    0.7.0.1
 */