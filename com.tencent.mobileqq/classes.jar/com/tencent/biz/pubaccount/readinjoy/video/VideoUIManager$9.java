package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import olh;
import spk;
import sqd;
import sut;
import suu;

public class VideoUIManager$9
  implements Runnable
{
  public VideoUIManager$9(sqd paramsqd, int paramInt) {}
  
  public void run()
  {
    if ((sqd.a(this.this$0) != null) && (sqd.a(this.this$0).a != null))
    {
      suu localsuu = new suu("", "", sqd.a(this.this$0).a.mVideoVid, sqd.a(this.this$0).a.innerUniqueID).a((int)sqd.a(this.this$0).a.mChannelID);
      olh.a(null, "", "0X8008AD0", "0X8008AD0", 0, 0, "", "", "", localsuu.a().a(), false);
      olh.a(null, "", "0X8009B57", "0X8009B57", 0, 0, String.valueOf(this.a), "", "", localsuu.a().a(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.9
 * JD-Core Version:    0.7.0.1
 */