package com.tencent.biz.qqstory.newshare.mode;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.newshare.mode.base.CardShareModeBase;
import com.tencent.biz.qqstory.newshare.model.ShareData;
import com.tencent.biz.qqstory.newshare.model.ShareQQData;
import com.tencent.biz.qqstory.newshare.util.ShareUtils;

public class InfoCardShareMode
  extends CardShareModeBase
{
  public static final String a;
  public static final String b;
  public static final String c;
  private String d;
  private String o;
  private int p;
  private final int[] v;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("src_type=internal&version=1&uin=%s&usertype=%s&unionid=%s&fromId=%s&storysharefrom=%s");
    localStringBuilder.append(StoryApi.b(2131897956));
    a = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqqapi://qstory/infoCard?");
    localStringBuilder.append(a);
    b = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://story.now.qq.com/mobile/transfer.html?");
    localStringBuilder.append(a);
    localStringBuilder.append("&actionnamekey=3&one_page=0");
    c = localStringBuilder.toString();
  }
  
  public InfoCardShareMode(QQUserUIItem paramQQUserUIItem) {}
  
  protected String a(int paramInt)
  {
    if (paramInt == 1) {
      return String.format(b, new Object[] { this.d, Integer.valueOf(this.p), this.o, Integer.valueOf(this.v[paramInt]), b(paramInt) });
    }
    return String.format(c, new Object[] { this.d, Integer.valueOf(this.p), this.o, Integer.valueOf(this.v[paramInt]), b(paramInt) });
  }
  
  protected void a(ShareData paramShareData)
  {
    super.a(paramShareData);
    if ((paramShareData != null) && ((paramShareData instanceof ShareQQData)))
    {
      paramShareData = (ShareQQData)paramShareData;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ShareUtils.b(this.j));
      localStringBuilder.append("#private_share_cache");
      paramShareData.f = localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.InfoCardShareMode
 * JD-Core Version:    0.7.0.1
 */