package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import odq;
import sdg;
import sdy;
import sid;
import sie;

public class VideoUIManager$9
  implements Runnable
{
  public VideoUIManager$9(sdy paramsdy, int paramInt) {}
  
  public void run()
  {
    if ((sdy.a(this.this$0) != null) && (sdy.a(this.this$0).a != null))
    {
      sie localsie = new sie("", "", sdy.a(this.this$0).a.mVideoVid, sdy.a(this.this$0).a.innerUniqueID).a((int)sdy.a(this.this$0).a.mChannelID);
      odq.a(null, "", "0X8008AD0", "0X8008AD0", 0, 0, "", "", "", localsie.a().a(), false);
      odq.a(null, "", "0X8009B57", "0X8009B57", 0, 0, String.valueOf(this.a), "", "", localsie.a().a(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.9
 * JD-Core Version:    0.7.0.1
 */