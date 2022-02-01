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
  public boolean b = false;
  private final int[] c;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://story.now.qq.com/mobile/transfer.html?src_type=app&version=1&fromId=17&videoOwnerUin=%s&videoId=%s&unionid=%s&feedid=%s&identify=%d&ptype=%d&actionnamekey=1&storysharefrom=%s&sharefromtype=%d&one_page=0");
    localStringBuilder.append(StoryApi.b(2131897956));
    a = localStringBuilder.toString();
  }
  
  public MyContentStoryShareMode(StoryVideoItem paramStoryVideoItem, boolean paramBoolean, String paramString)
  {
    QQAppInterface localQQAppInterface = PlayModeUtils.b();
    UserManager localUserManager = (UserManager)SuperManager.a(2);
    this.j = paramStoryVideoItem;
    this.b = paramBoolean;
    this.d = localQQAppInterface.getCurrentNickname();
    StringBuilder localStringBuilder;
    if (this.j.isPollVideo())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.d);
      str = HardCodeUtil.a(2131904923);
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.d);
      localStringBuilder.append(HardCodeUtil.a(2131904924));
      str = QQStoryConstant.a;
    }
    localStringBuilder.append(str);
    this.e = localStringBuilder.toString();
    this.g = paramStoryVideoItem.mOwnerUid;
    this.f = localUserManager.a(this.g, false);
    this.h = paramStoryVideoItem.mDoodleText;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.i = str;
    this.k = (paramStoryVideoItem.isMine() ^ true);
    this.d = localQQAppInterface.getCurrentNickname();
    paramStoryVideoItem = localUserManager.b(this.g);
    if ((paramStoryVideoItem != null) && (paramStoryVideoItem.isVip)) {
      this.d = paramStoryVideoItem.nickName;
    }
    this.e = b();
    this.n = this.e;
    this.l = c();
    paramStoryVideoItem = new StringBuilder();
    paramStoryVideoItem.append("#");
    paramStoryVideoItem.append(QQStoryConstant.a);
    paramStoryVideoItem.append("# ");
    paramStoryVideoItem.append(b());
    paramStoryVideoItem.append("（");
    paramStoryVideoItem.append(this.l);
    paramStoryVideoItem.append("）");
    this.m = paramStoryVideoItem.toString();
    this.v = 11;
    if (this.b) {
      this.v = 4;
    } else {
      this.v = 1;
    }
    if (this.b)
    {
      this.c = new int[] { 0, 0, 38, 39, 40, 55, 45 };
      return;
    }
    this.c = new int[] { 0, 0, 32, 33, 34, 54, 45 };
  }
  
  protected String a(int paramInt)
  {
    int i = 3;
    if (paramInt == 1)
    {
      str1 = this.f;
      str2 = this.j.mVid;
      str3 = this.g;
      str4 = this.i;
      paramInt = this.k;
      if (!this.b) {
        i = 1;
      }
      return String.format("mqqapi://qstory/openVideo?src_type=app&version=1&fromId=17&videoOwnerUin=%s&videoId=%s&unionid=%s&feedid=%s&identify=%d&ptype=%d", new Object[] { str1, str2, str3, str4, Integer.valueOf(paramInt), Integer.valueOf(i) });
    }
    String str1 = a;
    String str2 = this.f;
    String str3 = this.j.mVid;
    String str4 = this.g;
    String str5 = this.i;
    int j = this.k;
    if (!this.b) {
      i = 1;
    }
    return String.format(str1, new Object[] { str2, str3, str4, str5, Integer.valueOf(j), Integer.valueOf(i), b(paramInt), Integer.valueOf(this.c[paramInt]) });
  }
  
  protected void a(ShareData paramShareData)
  {
    if ((paramShareData instanceof ShareQQData))
    {
      VideoGameInfo localVideoGameInfo = this.j.getVideoGameInfo();
      if (localVideoGameInfo == null) {
        return;
      }
      paramShareData = (ShareQQData)paramShareData;
      paramShareData.v = localVideoGameInfo.c;
      if (localVideoGameInfo.a == 2)
      {
        paramShareData.w = HardCodeUtil.a(2131904925);
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localVideoGameInfo.d);
        localStringBuilder.append(HardCodeUtil.a(2131904926));
        paramShareData.w = localStringBuilder.toString();
      }
      paramShareData.h = b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.MyContentStoryShareMode
 * JD-Core Version:    0.7.0.1
 */