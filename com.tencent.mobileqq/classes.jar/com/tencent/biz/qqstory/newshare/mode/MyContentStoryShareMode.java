package com.tencent.biz.qqstory.newshare.mode;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.newshare.mode.base.VideoShareModeBase;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.mobileqq.app.QQAppInterface;

public class MyContentStoryShareMode
  extends VideoShareModeBase
{
  public static final String a;
  public boolean a;
  private final int[] a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "http://story.now.qq.com/mobile/transfer.html?src_type=app&version=1&fromId=17&videoOwnerUin=%s&videoId=%s&unionid=%s&feedid=%s&identify=%d&ptype=%d&actionnamekey=1&storysharefrom=%s&sharefromtype=%d&one_page=0" + StoryApi.a(2131432069);
  }
  
  public MyContentStoryShareMode(StoryVideoItem paramStoryVideoItem, boolean paramBoolean, String paramString)
  {
    QQAppInterface localQQAppInterface = PlayModeUtils.a();
    UserManager localUserManager = (UserManager)SuperManager.a(2);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.c = localQQAppInterface.getCurrentNickname();
    String str;
    int i;
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())
    {
      str = this.c + "的投票" + "日迹";
      this.jdField_d_of_type_JavaLangString = str;
      this.f = paramStoryVideoItem.mOwnerUid;
      this.e = localUserManager.a(this.f, false);
      this.g = paramStoryVideoItem.mDoodleText;
      str = paramString;
      if (paramString == null) {
        str = "";
      }
      this.h = str;
      if (!paramStoryVideoItem.isMine()) {
        break label350;
      }
      i = 0;
      label139:
      this.b = i;
      this.c = localQQAppInterface.getCurrentNickname();
      paramStoryVideoItem = localUserManager.b(this.f);
      if ((paramStoryVideoItem != null) && (paramStoryVideoItem.isVip)) {
        this.c = paramStoryVideoItem.nickName;
      }
      this.jdField_d_of_type_JavaLangString = a();
      this.k = this.jdField_d_of_type_JavaLangString;
      this.i = b();
      this.j = ("#日迹# " + a() + "（" + this.i + "）");
      this.jdField_d_of_type_Int = 11;
      if (!this.jdField_a_of_type_Boolean) {
        break label356;
      }
    }
    label350:
    label356:
    for (this.jdField_d_of_type_Int = 4;; this.jdField_d_of_type_Int = 1)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label364;
      }
      this.jdField_a_of_type_ArrayOfInt = new int[] { 0, 0, 38, 39, 40, 55, 45 };
      return;
      str = this.c + "的" + "日迹";
      break;
      i = 1;
      break label139;
    }
    label364:
    this.jdField_a_of_type_ArrayOfInt = new int[] { 0, 0, 32, 33, 34, 54, 45 };
  }
  
  protected String a(int paramInt)
  {
    int i = 3;
    if (paramInt == 1)
    {
      str1 = this.e;
      str2 = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid;
      str3 = this.f;
      str4 = this.h;
      paramInt = this.b;
      if (this.jdField_a_of_type_Boolean) {}
      for (;;)
      {
        return String.format("mqqapi://qstory/openVideo?src_type=app&version=1&fromId=17&videoOwnerUin=%s&videoId=%s&unionid=%s&feedid=%s&identify=%d&ptype=%d", new Object[] { str1, str2, str3, str4, Integer.valueOf(paramInt), Integer.valueOf(i) });
        i = 1;
      }
    }
    String str1 = jdField_a_of_type_JavaLangString;
    String str2 = this.e;
    String str3 = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid;
    String str4 = this.f;
    String str5 = this.h;
    int j = this.b;
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return String.format(str1, new Object[] { str2, str3, str4, str5, Integer.valueOf(j), Integer.valueOf(i), b(paramInt), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[paramInt]) });
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.MyContentStoryShareMode
 * JD-Core Version:    0.7.0.1
 */