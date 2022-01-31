package com.tencent.biz.qqstory.newshare.mode;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.newshare.mode.base.MultiVideoShareModeBase;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class FeedDetailShareMode
  extends MultiVideoShareModeBase
{
  public static final String a;
  public static final String b = jdField_a_of_type_JavaLangString + "&type=" + "onedaylist" + "&feedid=%s&identify=%d";
  private int[] a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "http://story.now.qq.com/mobile/transfer.html?src_type=app&version=1&fromId=17&videoOwnerUin=%s&videoId=%s&unionid=%s&ptype=%d&actionnamekey=1&storysharefrom=%s&sharefromtype=%d&one_page=0" + StoryApi.a(2131432086);
  }
  
  public FeedDetailShareMode(StoryVideoItem paramStoryVideoItem, String paramString, int paramInt)
  {
    Object localObject = ((FeedManager)SuperManager.a(11)).a(paramString);
    if (localObject == null) {
      return;
    }
    UserManager localUserManager = (UserManager)SuperManager.a(2);
    localObject = (QQUserUIItem)((FeedItem)localObject).getOwner();
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
    this.jdField_d_of_type_JavaLangString = (((QQUserUIItem)localObject).nickName + "的" + "日迹");
    this.e = (((QQUserUIItem)localObject).nickName + "的" + "日迹");
    this.f = localUserManager.a(((QQUserUIItem)localObject).getUnionId(), false);
    int i;
    if (((QQUserUIItem)localObject).isMe())
    {
      i = 0;
      this.jdField_a_of_type_Int = i;
      this.h = paramString;
      this.jdField_d_of_type_Int = paramInt;
      this.jdField_c_of_type_JavaLangString = ((QQUserUIItem)localObject).nickName;
      this.g = ((QQUserUIItem)localObject).getUnionId();
      this.k = a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mCreateTime);
      paramStoryVideoItem = new SimpleDateFormat("M月d日").format(Long.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mCreateTime));
      this.i = (paramStoryVideoItem + " · " + this.jdField_d_of_type_Int + "个小视频");
      this.j = ("#日迹# " + this.jdField_c_of_type_JavaLangString + "的" + "日迹" + "（" + this.i + "）");
      if (this.jdField_a_of_type_Int != 0) {
        break label374;
      }
    }
    label374:
    for (paramInt = 8;; paramInt = 9)
    {
      this.jdField_c_of_type_Int = paramInt;
      if (this.jdField_a_of_type_Int != 0) {
        break label380;
      }
      this.jdField_a_of_type_ArrayOfInt = new int[] { 0, 81, 82, 83, 84, 85, 45 };
      return;
      i = 1;
      break;
    }
    label380:
    this.jdField_a_of_type_ArrayOfInt = new int[] { 0, 69, 70, 71, 72, 73, 45 };
  }
  
  protected String a(int paramInt)
  {
    if (paramInt == 1) {
      return String.format("mqqapi://qstory/openVideo?src_type=app&version=1&fromId=17&videoOwnerUin=%s&videoId=%s&unionid=%s&ptype=%d&type=onedaylist&feedid=%s&identify=%d&sharefromtype=%d", new Object[] { this.f, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, this.g, Integer.valueOf(5), this.h, Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[paramInt]) });
    }
    return String.format(b, new Object[] { this.f, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, this.g, Integer.valueOf(5), b(paramInt), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[paramInt]), this.h, Integer.valueOf(this.jdField_a_of_type_Int) });
  }
  
  public String a(String paramString, long paramLong)
  {
    String str = new SimpleDateFormat("M月d日").format(Long.valueOf(paramLong));
    return paramString + "的" + str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.FeedDetailShareMode
 * JD-Core Version:    0.7.0.1
 */