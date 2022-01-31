package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import nol;
import qtv;
import qva;
import qza;
import qzb;

public class VideoUIManager$8
  implements Runnable
{
  public VideoUIManager$8(qva paramqva, int paramInt) {}
  
  public void run()
  {
    if ((qva.a(this.this$0) != null) && (qva.a(this.this$0).a != null))
    {
      qzb localqzb = new qzb("", "", qva.a(this.this$0).a.mVideoVid, qva.a(this.this$0).a.innerUniqueID).a((int)qva.a(this.this$0).a.mChannelID);
      nol.a(null, "", "0X8008AD0", "0X8008AD0", 0, 0, "", "", "", localqzb.a().a(), false);
      nol.a(null, "", "0X8009B57", "0X8009B57", 0, 0, String.valueOf(this.a), "", "", localqzb.a().a(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.8
 * JD-Core Version:    0.7.0.1
 */