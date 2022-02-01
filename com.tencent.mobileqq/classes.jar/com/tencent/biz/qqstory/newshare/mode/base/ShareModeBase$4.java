package com.tencent.biz.qqstory.newshare.mode.base;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.newshare.job.AddPollViewJob;
import com.tencent.biz.qqstory.newshare.model.ShareWeChatData;

class ShareModeBase$4
  extends AddPollViewJob
{
  ShareModeBase$4(ShareModeBase paramShareModeBase, StoryVideoItem paramStoryVideoItem, ShareWeChatData paramShareWeChatData)
  {
    super(paramStoryVideoItem);
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareWeChatData.e = ((String)a("result"));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase.4
 * JD-Core Version:    0.7.0.1
 */