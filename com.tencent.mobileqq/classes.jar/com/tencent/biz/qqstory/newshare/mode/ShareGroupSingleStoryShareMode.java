package com.tencent.biz.qqstory.newshare.mode;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.newshare.mode.base.VideoShareModeBase;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;

public class ShareGroupSingleStoryShareMode
  extends VideoShareModeBase
{
  public static final String a;
  protected int a;
  private final int[] a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "http://story.now.qq.com/mobile/transfer.html?src_type=app&version=1&fromId=17&videoOwnerUin=%s&videoId=%s&unionid=%s&feedid=%s&ptype=%d&identify=1&actionnamekey=1&storysharefrom=%s&sharefromtype=%d&one_page=0" + StoryApi.a(2131432086);
  }
  
  public ShareGroupSingleStoryShareMode(ShareGroupItem paramShareGroupItem, StoryVideoItem paramStoryVideoItem, String paramString, int paramInt)
  {
    paramShareGroupItem = (UserManager)SuperManager.a(2);
    QQUserUIItem localQQUserUIItem = paramShareGroupItem.b(paramStoryVideoItem.mOwnerUid);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
    this.h = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_e_of_type_Int = 1;
    if (localQQUserUIItem != null)
    {
      this.c = localQQUserUIItem.nickName;
      this.jdField_d_of_type_JavaLangString = a();
      this.k = this.jdField_d_of_type_JavaLangString;
    }
    this.f = paramStoryVideoItem.mOwnerUid;
    this.jdField_e_of_type_JavaLangString = paramShareGroupItem.a(this.f, false);
    this.g = paramStoryVideoItem.mDoodleText;
    this.i = b();
    this.j = ("#日迹# " + a() + "（" + this.i + "）");
    this.jdField_d_of_type_Int = 12;
    this.jdField_a_of_type_ArrayOfInt = new int[] { 0, 0, 91, 92, 93, 94, 95 };
  }
  
  public static ShareGroupSingleStoryShareMode a(ShareGroupItem paramShareGroupItem, StoryVideoItem paramStoryVideoItem, String paramString)
  {
    return new ShareGroupSingleStoryShareMode(paramShareGroupItem, paramStoryVideoItem, paramString, 8);
  }
  
  protected String a(int paramInt)
  {
    if (paramInt == 1) {
      return String.format("mqqapi://qstory/openVideo?src_type=app&version=1&fromId=17&videoOwnerUin=%s&videoId=%s&unionid=%s&feedid=%s&ptype=%d&identify=1", new Object[] { this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, this.f, this.h, Integer.valueOf(this.jdField_a_of_type_Int) });
    }
    return String.format(jdField_a_of_type_JavaLangString, new Object[] { this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, this.f, this.h, Integer.valueOf(this.jdField_a_of_type_Int), b(paramInt), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[paramInt]) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.ShareGroupSingleStoryShareMode
 * JD-Core Version:    0.7.0.1
 */