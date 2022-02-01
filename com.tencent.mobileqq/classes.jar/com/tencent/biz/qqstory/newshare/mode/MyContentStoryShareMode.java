package com.tencent.biz.qqstory.newshare.mode;

import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.VideoGameInfo;
import com.tencent.biz.qqstory.newshare.mode.base.VideoShareModeBase;
import com.tencent.biz.qqstory.newshare.model.ShareData;
import com.tencent.biz.qqstory.newshare.model.ShareQQData;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;

public class MyContentStoryShareMode
  extends VideoShareModeBase
{
  public static final String a;
  public boolean a;
  private final int[] a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://story.now.qq.com/mobile/transfer.html?src_type=app&version=1&fromId=17&videoOwnerUin=%s&videoId=%s&unionid=%s&feedid=%s&identify=%d&ptype=%d&actionnamekey=1&storysharefrom=%s&sharefromtype=%d&one_page=0");
    localStringBuilder.append(StoryApi.a(2131699903));
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public MyContentStoryShareMode(StoryVideoItem paramStoryVideoItem, boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Boolean = false;
    QQAppInterface localQQAppInterface = PlayModeUtils.a();
    UserManager localUserManager = (UserManager)SuperManager.a(2);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.c = localQQAppInterface.getCurrentNickname();
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c);
      str = HardCodeUtil.a(2131707085);
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c);
      localStringBuilder.append(HardCodeUtil.a(2131707086));
      str = QQStoryConstant.jdField_a_of_type_JavaLangString;
    }
    localStringBuilder.append(str);
    this.jdField_d_of_type_JavaLangString = localStringBuilder.toString();
    this.f = paramStoryVideoItem.mOwnerUid;
    this.e = localUserManager.a(this.f, false);
    this.g = paramStoryVideoItem.mDoodleText;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.h = str;
    this.b = (paramStoryVideoItem.isMine() ^ true);
    this.c = localQQAppInterface.getCurrentNickname();
    paramStoryVideoItem = localUserManager.b(this.f);
    if ((paramStoryVideoItem != null) && (paramStoryVideoItem.isVip)) {
      this.c = paramStoryVideoItem.nickName;
    }
    this.jdField_d_of_type_JavaLangString = a();
    this.k = this.jdField_d_of_type_JavaLangString;
    this.i = b();
    paramStoryVideoItem = new StringBuilder();
    paramStoryVideoItem.append("#");
    paramStoryVideoItem.append(QQStoryConstant.jdField_a_of_type_JavaLangString);
    paramStoryVideoItem.append("# ");
    paramStoryVideoItem.append(a());
    paramStoryVideoItem.append("（");
    paramStoryVideoItem.append(this.i);
    paramStoryVideoItem.append("）");
    this.j = paramStoryVideoItem.toString();
    this.jdField_d_of_type_Int = 11;
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_d_of_type_Int = 4;
    } else {
      this.jdField_d_of_type_Int = 1;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ArrayOfInt = new int[] { 0, 0, 38, 39, 40, 55, 45 };
      return;
    }
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
      if (!this.jdField_a_of_type_Boolean) {
        i = 1;
      }
      return String.format("mqqapi://qstory/openVideo?src_type=app&version=1&fromId=17&videoOwnerUin=%s&videoId=%s&unionid=%s&feedid=%s&identify=%d&ptype=%d", new Object[] { str1, str2, str3, str4, Integer.valueOf(paramInt), Integer.valueOf(i) });
    }
    String str1 = jdField_a_of_type_JavaLangString;
    String str2 = this.e;
    String str3 = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid;
    String str4 = this.f;
    String str5 = this.h;
    int j = this.b;
    if (!this.jdField_a_of_type_Boolean) {
      i = 1;
    }
    return String.format(str1, new Object[] { str2, str3, str4, str5, Integer.valueOf(j), Integer.valueOf(i), b(paramInt), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[paramInt]) });
  }
  
  protected void a(ShareData paramShareData)
  {
    if ((paramShareData instanceof ShareQQData))
    {
      VideoGameInfo localVideoGameInfo = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getVideoGameInfo();
      if (localVideoGameInfo == null) {
        return;
      }
      paramShareData = (ShareQQData)paramShareData;
      paramShareData.o = localVideoGameInfo.b;
      if (localVideoGameInfo.a == 2)
      {
        paramShareData.p = HardCodeUtil.a(2131707087);
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localVideoGameInfo.c);
        localStringBuilder.append(HardCodeUtil.a(2131707088));
        paramShareData.p = localStringBuilder.toString();
      }
      paramShareData.jdField_d_of_type_JavaLangString = a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.MyContentStoryShareMode
 * JD-Core Version:    0.7.0.1
 */