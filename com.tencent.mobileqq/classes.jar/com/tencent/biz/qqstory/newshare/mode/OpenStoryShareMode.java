package com.tencent.biz.qqstory.newshare.mode;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.newshare.mode.base.VideoShareModeBase;

public class OpenStoryShareMode
  extends VideoShareModeBase
{
  public static final String a;
  private final int[] a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "https://story.now.qq.com/mobile/transfer.html?src_type=app&version=1&fromid=17&videoOwnerUin=%s&videoId=%s&unionid=%s&feedid=%s&identify=%d&ptype=%d&type=1&actionnamekey=1&storysharefrom=%s&sharefromtype=%d&one_page=0" + StoryApi.a(2131699762);
  }
  
  public String a(int paramInt)
  {
    if (paramInt == 1) {
      return String.format("mqqapi://qstory/openVideo?src_type=app&version=1&fromid=17&videoOwnerUin=%s&videoId=%s&unionid=%s&feedid=%s&identify=%d&ptype=%d&type=1", new Object[] { this.e, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, this.f, this.h, Integer.valueOf(this.b), Integer.valueOf(6) });
    }
    return String.format(jdField_a_of_type_JavaLangString, new Object[] { this.e, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, this.f, this.h, Integer.valueOf(this.b), Integer.valueOf(6), b(paramInt), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[paramInt]) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.OpenStoryShareMode
 * JD-Core Version:    0.7.0.1
 */