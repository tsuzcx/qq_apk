package com.tencent.biz.qqstory.newshare.mode.base;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.newshare.job.AddPollViewJob;
import com.tencent.biz.qqstory.newshare.model.ShareQQData;

class ShareModeBase$1
  extends AddPollViewJob
{
  ShareModeBase$1(ShareModeBase paramShareModeBase, StoryVideoItem paramStoryVideoItem, ShareQQData paramShareQQData)
  {
    super(paramStoryVideoItem);
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareQQData.a = ((String)a("result"));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase.1
 * JD-Core Version:    0.7.0.1
 */