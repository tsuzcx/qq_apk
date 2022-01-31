package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import ndn;
import qht;
import qiy;
import qmu;
import qmv;

public class VideoUIManager$7
  implements Runnable
{
  public VideoUIManager$7(qiy paramqiy, int paramInt) {}
  
  public void run()
  {
    if ((qiy.a(this.this$0) != null) && (qiy.a(this.this$0).a != null))
    {
      qmv localqmv = new qmv("", "", qiy.a(this.this$0).a.mVideoVid, qiy.a(this.this$0).a.innerUniqueID).a((int)qiy.a(this.this$0).a.mChannelID);
      ndn.a(null, "", "0X8008AD0", "0X8008AD0", 0, 0, "", "", "", localqmv.a().a(), false);
      ndn.a(null, "", "0X8009B57", "0X8009B57", 0, 0, String.valueOf(this.a), "", "", localqmv.a().a(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.7
 * JD-Core Version:    0.7.0.1
 */