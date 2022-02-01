package com.tencent.biz.pubaccount.readinjoy.comment.topic;

import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelModule.UserLevelCallBack;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelRequestModule.UserLevelInfo;
import java.util.Map;

class RIJCommentTopicUi$1
  implements RIJUserLevelModule.UserLevelCallBack
{
  RIJCommentTopicUi$1(RIJCommentTopicUi paramRIJCommentTopicUi) {}
  
  public void a(RIJUserLevelRequestModule.UserLevelInfo paramUserLevelInfo)
  {
    if (paramUserLevelInfo != null) {
      RIJCommentTopicUi.a((String)paramUserLevelInfo.operFobidWording.get(Integer.valueOf(11)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.topic.RIJCommentTopicUi.1
 * JD-Core Version:    0.7.0.1
 */