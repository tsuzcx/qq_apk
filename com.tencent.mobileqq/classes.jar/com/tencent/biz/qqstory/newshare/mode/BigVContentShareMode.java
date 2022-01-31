package com.tencent.biz.qqstory.newshare.mode;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.newshare.mode.base.VideoShareModeBase;

public class BigVContentShareMode
  extends VideoShareModeBase
{
  public static final String a;
  private final int[] a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "http://story.now.qq.com/mobile/transfer.html?src_type=app&version=1&fromid=17&videoOwnerUin=%s&videoId=%s&unionid=%s&feedid=%s&identify=%d&type=1&actionnamekey=1&storysharefrom=%s&sharefromtype=%d&one_page=0" + StoryApi.a(2131432097);
  }
  
  public BigVContentShareMode(StoryVideoItem paramStoryVideoItem, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
    this.h = paramString;
    paramString = (UserManager)SuperManager.a(2);
    this.c = paramString.b(paramStoryVideoItem.mOwnerUid).nickName;
    this.d = a();
    this.k = this.d;
    this.e = paramString.a(paramStoryVideoItem.mOwnerUid, false);
    this.f = paramStoryVideoItem.mOwnerUid;
    this.g = paramStoryVideoItem.mDoodleText;
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isMine()) {}
    for (int i = 0;; i = 1)
    {
      this.b = i;
      this.i = b();
      this.j = ("#小视频# " + a() + "（" + this.i + "）");
      this.jdField_a_of_type_ArrayOfInt = new int[] { 0, 0, 58, 59, 60, 61, 45 };
      return;
    }
  }
  
  protected String a(int paramInt)
  {
    if (paramInt == 1) {
      return String.format("mqqapi://qstory/openVideo?src_type=app&version=1&fromid=17&videoOwnerUin=%s&videoId=%s&unionid=%s&feedid=%s&identify=%d&type=1", new Object[] { this.e, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, this.f, this.h, Integer.valueOf(this.b) });
    }
    return String.format(jdField_a_of_type_JavaLangString, new Object[] { this.e, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, this.f, this.h, Integer.valueOf(this.b), b(paramInt), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[paramInt]) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.BigVContentShareMode
 * JD-Core Version:    0.7.0.1
 */