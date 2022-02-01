package com.tencent.biz.qqstory.newshare.mode;

import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.newshare.mode.base.MultiVideoShareModeBase;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class FeedDetailShareMode
  extends MultiVideoShareModeBase
{
  public static final String a;
  public static final String b;
  private int[] v;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://story.now.qq.com/mobile/transfer.html?src_type=app&version=1&fromId=17&videoOwnerUin=%s&videoId=%s&unionid=%s&ptype=%d&actionnamekey=1&storysharefrom=%s&sharefromtype=%d&one_page=0");
    localStringBuilder.append(StoryApi.b(2131897956));
    a = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("&type=");
    localStringBuilder.append("onedaylist");
    localStringBuilder.append("&feedid=%s&identify=%d");
    b = localStringBuilder.toString();
  }
  
  public FeedDetailShareMode(StoryVideoItem paramStoryVideoItem, String paramString, int paramInt)
  {
    Object localObject = ((FeedManager)SuperManager.a(11)).b(paramString);
    if (localObject == null) {
      return;
    }
    UserManager localUserManager = (UserManager)SuperManager.a(2);
    localObject = (QQUserUIItem)((FeedItem)localObject).getOwner();
    this.i = paramStoryVideoItem;
    paramStoryVideoItem = new StringBuilder();
    paramStoryVideoItem.append(((QQUserUIItem)localObject).nickName);
    paramStoryVideoItem.append(HardCodeUtil.a(2131902465));
    paramStoryVideoItem.append(QQStoryConstant.a);
    this.d = paramStoryVideoItem.toString();
    paramStoryVideoItem = new StringBuilder();
    paramStoryVideoItem.append(((QQUserUIItem)localObject).nickName);
    paramStoryVideoItem.append(HardCodeUtil.a(2131902464));
    paramStoryVideoItem.append(QQStoryConstant.a);
    this.e = paramStoryVideoItem.toString();
    this.f = localUserManager.a(((QQUserUIItem)localObject).getUnionId(), false);
    this.j = (((QQUserUIItem)localObject).isMe() ^ true);
    this.h = paramString;
    this.p = paramInt;
    this.c = ((QQUserUIItem)localObject).nickName;
    this.g = ((QQUserUIItem)localObject).getUnionId();
    this.m = a(this.c, this.i.mCreateTime);
    paramStoryVideoItem = new SimpleDateFormat("M月d日").format(Long.valueOf(this.i.mCreateTime));
    paramString = new StringBuilder();
    paramString.append(paramStoryVideoItem);
    paramString.append(" · ");
    paramString.append(this.p);
    paramString.append(HardCodeUtil.a(2131902467));
    this.k = paramString.toString();
    paramStoryVideoItem = new StringBuilder();
    paramStoryVideoItem.append("#");
    paramStoryVideoItem.append(QQStoryConstant.a);
    paramStoryVideoItem.append("# ");
    paramStoryVideoItem.append(this.c);
    paramStoryVideoItem.append(HardCodeUtil.a(2131902466));
    paramStoryVideoItem.append(QQStoryConstant.a);
    paramStoryVideoItem.append("（");
    paramStoryVideoItem.append(this.k);
    paramStoryVideoItem.append("）");
    this.l = paramStoryVideoItem.toString();
    if (this.j == 0) {
      paramInt = 8;
    } else {
      paramInt = 9;
    }
    this.o = paramInt;
    if (this.j == 0)
    {
      this.v = new int[] { 0, 81, 82, 83, 84, 85, 45 };
      return;
    }
    this.v = new int[] { 0, 69, 70, 71, 72, 73, 45 };
  }
  
  protected String a(int paramInt)
  {
    Integer localInteger = Integer.valueOf(5);
    if (paramInt == 1) {
      return String.format("mqqapi://qstory/openVideo?src_type=app&version=1&fromId=17&videoOwnerUin=%s&videoId=%s&unionid=%s&ptype=%d&type=onedaylist&feedid=%s&identify=%d&sharefromtype=%d", new Object[] { this.f, this.i.mVid, this.g, localInteger, this.h, Integer.valueOf(this.j), Integer.valueOf(this.v[paramInt]) });
    }
    return String.format(b, new Object[] { this.f, this.i.mVid, this.g, localInteger, b(paramInt), Integer.valueOf(this.v[paramInt]), this.h, Integer.valueOf(this.j) });
  }
  
  public String a(String paramString, long paramLong)
  {
    String str = new SimpleDateFormat("M月d日").format(Long.valueOf(paramLong));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(HardCodeUtil.a(2131902460));
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.FeedDetailShareMode
 * JD-Core Version:    0.7.0.1
 */