package com.tencent.biz.qqstory.newshare.mode;

import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.newshare.mode.base.VideoShareModeBase;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.StringUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ShareGroupOneDayStoryShareMode
  extends VideoShareModeBase
{
  public static final String a;
  public static final String b;
  protected int a;
  private final int[] a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://story.now.qq.com/mobile/transfer.html?src_type=app&version=1&fromId=17&videoOwnerUin=%s&videoId=%s&unionid=%s&feedid=%s&ptype=%d&identify=1&actionnamekey=1&storysharefrom=%s&sharefromtype=%d&one_page=0");
    localStringBuilder.append(StoryApi.a(2131699903));
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append("&et=%d&time_zone=%d");
    b = localStringBuilder.toString();
  }
  
  public ShareGroupOneDayStoryShareMode(ShareGroupItem paramShareGroupItem, StoryVideoItem paramStoryVideoItem, String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    UserManager localUserManager = (UserManager)SuperManager.a(2);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
    this.h = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_e_of_type_Int = paramInt2;
    this.f = paramStoryVideoItem.mOwnerUid;
    this.jdField_e_of_type_JavaLangString = localUserManager.a(this.f, false);
    this.c = StringUtil.a(paramShareGroupItem.name, 0, 16, "...");
    this.g = paramStoryVideoItem.mDoodleText;
    this.jdField_d_of_type_JavaLangString = a();
    paramShareGroupItem = new StringBuilder();
    paramShareGroupItem.append(HardCodeUtil.a(2131713784));
    paramShareGroupItem.append(this.c);
    paramShareGroupItem.append(HardCodeUtil.a(2131713792));
    paramShareGroupItem.append(QQStoryConstant.jdField_a_of_type_JavaLangString);
    this.k = paramShareGroupItem.toString();
    paramShareGroupItem = new StringBuilder();
    paramShareGroupItem.append(this.c);
    paramShareGroupItem.append("\n");
    paramShareGroupItem.append(paramInt2);
    paramShareGroupItem.append(HardCodeUtil.a(2131713788));
    this.l = paramShareGroupItem.toString();
    new SimpleDateFormat("M月d日").format(Long.valueOf(paramLong));
    this.i = b();
    paramShareGroupItem = new StringBuilder();
    paramShareGroupItem.append("#");
    paramShareGroupItem.append(QQStoryConstant.jdField_a_of_type_JavaLangString);
    paramShareGroupItem.append("# ");
    paramShareGroupItem.append(a());
    paramShareGroupItem.append("（");
    paramShareGroupItem.append(this.i);
    paramShareGroupItem.append("）");
    this.j = paramShareGroupItem.toString();
    this.jdField_d_of_type_Int = 11;
    this.jdField_a_of_type_ArrayOfInt = new int[] { 0, 0, 97, 98, 99, 100, 101 };
  }
  
  public static ShareGroupOneDayStoryShareMode a(ShareGroupItem paramShareGroupItem, StoryVideoItem paramStoryVideoItem, String paramString, long paramLong, int paramInt)
  {
    return new ShareGroupOneDayStoryShareMode(paramShareGroupItem, paramStoryVideoItem, paramString, paramLong, 9, paramInt);
  }
  
  protected String a(int paramInt)
  {
    if (paramInt == 1) {
      return String.format("mqqapi://qstory/openVideo?src_type=app&version=1&fromId=17&videoOwnerUin=%s&videoId=%s&unionid=%s&feedid=%s&ptype=%d&identify=1&type=onedaylist&et=%d&time_zone=%d", new Object[] { this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, this.f, this.h, Integer.valueOf(this.jdField_a_of_type_Int), Long.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mCreateTime / 1000L), Integer.valueOf(UIUtils.a()) });
    }
    return String.format(b, new Object[] { this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, this.f, this.h, Integer.valueOf(this.jdField_a_of_type_Int), b(paramInt), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[paramInt]), Long.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mCreateTime / 1000L), Integer.valueOf(UIUtils.a()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.ShareGroupOneDayStoryShareMode
 * JD-Core Version:    0.7.0.1
 */