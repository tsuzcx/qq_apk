package com.tencent.biz.qqstory.newshare.mode;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.newshare.mode.base.VideoShareModeBase;

public class OpenStoryShareMode
  extends VideoShareModeBase
{
  public static final String a;
  private final int[] b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://story.now.qq.com/mobile/transfer.html?src_type=app&version=1&fromid=17&videoOwnerUin=%s&videoId=%s&unionid=%s&feedid=%s&identify=%d&ptype=%d&type=1&actionnamekey=1&storysharefrom=%s&sharefromtype=%d&one_page=0");
    localStringBuilder.append(StoryApi.b(2131897956));
    a = localStringBuilder.toString();
  }
  
  protected String a(int paramInt)
  {
    Integer localInteger = Integer.valueOf(6);
    if (paramInt == 1) {
      return String.format("mqqapi://qstory/openVideo?src_type=app&version=1&fromid=17&videoOwnerUin=%s&videoId=%s&unionid=%s&feedid=%s&identify=%d&ptype=%d&type=1", new Object[] { this.f, this.j.mVid, this.g, this.i, Integer.valueOf(this.k), localInteger });
    }
    return String.format(a, new Object[] { this.f, this.j.mVid, this.g, this.i, Integer.valueOf(this.k), localInteger, b(paramInt), Integer.valueOf(this.b[paramInt]) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.OpenStoryShareMode
 * JD-Core Version:    0.7.0.1
 */