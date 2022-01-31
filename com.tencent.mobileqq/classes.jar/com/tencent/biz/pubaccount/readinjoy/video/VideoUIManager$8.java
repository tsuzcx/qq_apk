package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import noo;
import qty;
import qvd;
import qzd;
import qze;

public class VideoUIManager$8
  implements Runnable
{
  public VideoUIManager$8(qvd paramqvd, int paramInt) {}
  
  public void run()
  {
    if ((qvd.a(this.this$0) != null) && (qvd.a(this.this$0).a != null))
    {
      qze localqze = new qze("", "", qvd.a(this.this$0).a.mVideoVid, qvd.a(this.this$0).a.innerUniqueID).a((int)qvd.a(this.this$0).a.mChannelID);
      noo.a(null, "", "0X8008AD0", "0X8008AD0", 0, 0, "", "", "", localqze.a().a(), false);
      noo.a(null, "", "0X8009B57", "0X8009B57", 0, 0, String.valueOf(this.a), "", "", localqze.a().a(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.8
 * JD-Core Version:    0.7.0.1
 */