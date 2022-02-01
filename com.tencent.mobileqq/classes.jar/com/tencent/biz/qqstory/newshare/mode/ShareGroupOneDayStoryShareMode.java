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
  protected int c;
  private final int[] x;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://story.now.qq.com/mobile/transfer.html?src_type=app&version=1&fromId=17&videoOwnerUin=%s&videoId=%s&unionid=%s&feedid=%s&ptype=%d&identify=1&actionnamekey=1&storysharefrom=%s&sharefromtype=%d&one_page=0");
    localStringBuilder.append(StoryApi.b(2131897956));
    a = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("&et=%d&time_zone=%d");
    b = localStringBuilder.toString();
  }
  
  public ShareGroupOneDayStoryShareMode(ShareGroupItem paramShareGroupItem, StoryVideoItem paramStoryVideoItem, String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    UserManager localUserManager = (UserManager)SuperManager.a(2);
    this.j = paramStoryVideoItem;
    this.i = paramString;
    this.c = paramInt1;
    this.w = paramInt2;
    this.g = paramStoryVideoItem.mOwnerUid;
    this.f = localUserManager.a(this.g, false);
    this.d = StringUtil.substring(paramShareGroupItem.name, 0, 16, "...");
    this.h = paramStoryVideoItem.mDoodleText;
    this.e = b();
    paramShareGroupItem = new StringBuilder();
    paramShareGroupItem.append(HardCodeUtil.a(2131911325));
    paramShareGroupItem.append(this.d);
    paramShareGroupItem.append(HardCodeUtil.a(2131911332));
    paramShareGroupItem.append(QQStoryConstant.a);
    this.n = paramShareGroupItem.toString();
    paramShareGroupItem = new StringBuilder();
    paramShareGroupItem.append(this.d);
    paramShareGroupItem.append("\n");
    paramShareGroupItem.append(paramInt2);
    paramShareGroupItem.append(HardCodeUtil.a(2131911328));
    this.o = paramShareGroupItem.toString();
    new SimpleDateFormat("M月d日").format(Long.valueOf(paramLong));
    this.l = c();
    paramShareGroupItem = new StringBuilder();
    paramShareGroupItem.append("#");
    paramShareGroupItem.append(QQStoryConstant.a);
    paramShareGroupItem.append("# ");
    paramShareGroupItem.append(b());
    paramShareGroupItem.append("（");
    paramShareGroupItem.append(this.l);
    paramShareGroupItem.append("）");
    this.m = paramShareGroupItem.toString();
    this.v = 11;
    this.x = new int[] { 0, 0, 97, 98, 99, 100, 101 };
  }
  
  public static ShareGroupOneDayStoryShareMode a(ShareGroupItem paramShareGroupItem, StoryVideoItem paramStoryVideoItem, String paramString, long paramLong, int paramInt)
  {
    return new ShareGroupOneDayStoryShareMode(paramShareGroupItem, paramStoryVideoItem, paramString, paramLong, 9, paramInt);
  }
  
  protected String a(int paramInt)
  {
    if (paramInt == 1) {
      return String.format("mqqapi://qstory/openVideo?src_type=app&version=1&fromId=17&videoOwnerUin=%s&videoId=%s&unionid=%s&feedid=%s&ptype=%d&identify=1&type=onedaylist&et=%d&time_zone=%d", new Object[] { this.f, this.j.mVid, this.g, this.i, Integer.valueOf(this.c), Long.valueOf(this.j.mCreateTime / 1000L), Integer.valueOf(UIUtils.b()) });
    }
    return String.format(b, new Object[] { this.f, this.j.mVid, this.g, this.i, Integer.valueOf(this.c), b(paramInt), Integer.valueOf(this.x[paramInt]), Long.valueOf(this.j.mCreateTime / 1000L), Integer.valueOf(UIUtils.b()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.ShareGroupOneDayStoryShareMode
 * JD-Core Version:    0.7.0.1
 */