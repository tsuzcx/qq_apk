package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import oat;
import sey;
import sfq;
import skb;
import skc;

public class VideoUIManager$9
  implements Runnable
{
  public VideoUIManager$9(sfq paramsfq, int paramInt) {}
  
  public void run()
  {
    if ((sfq.a(this.this$0) != null) && (sfq.a(this.this$0).a != null))
    {
      skc localskc = new skc("", "", sfq.a(this.this$0).a.mVideoVid, sfq.a(this.this$0).a.innerUniqueID).a((int)sfq.a(this.this$0).a.mChannelID);
      oat.a(null, "", "0X8008AD0", "0X8008AD0", 0, 0, "", "", "", localskc.a().a(), false);
      oat.a(null, "", "0X8009B57", "0X8009B57", 0, 0, String.valueOf(this.a), "", "", localskc.a().a(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.9
 * JD-Core Version:    0.7.0.1
 */