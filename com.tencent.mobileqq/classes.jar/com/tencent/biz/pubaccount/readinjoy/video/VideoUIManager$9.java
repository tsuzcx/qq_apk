package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import nrt;
import rjk;
import rkp;
import rom;
import ron;

public class VideoUIManager$9
  implements Runnable
{
  public VideoUIManager$9(rkp paramrkp, int paramInt) {}
  
  public void run()
  {
    if ((rkp.a(this.this$0) != null) && (rkp.a(this.this$0).a != null))
    {
      ron localron = new ron("", "", rkp.a(this.this$0).a.mVideoVid, rkp.a(this.this$0).a.innerUniqueID).a((int)rkp.a(this.this$0).a.mChannelID);
      nrt.a(null, "", "0X8008AD0", "0X8008AD0", 0, 0, "", "", "", localron.a().a(), false);
      nrt.a(null, "", "0X8009B57", "0X8009B57", 0, 0, String.valueOf(this.a), "", "", localron.a().a(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.9
 * JD-Core Version:    0.7.0.1
 */