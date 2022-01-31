package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import ndn;
import new;
import qht;
import qiy;

public class VideoUIManager$4
  implements Runnable
{
  public VideoUIManager$4(qiy paramqiy) {}
  
  public void run()
  {
    if ((qiy.a(this.this$0) != null) && (qiy.a(this.this$0).a != null)) {
      ndn.a(null, "", "0X8008ACD", "0X8008ACD", 0, 0, "", "", "", new.a(qiy.a(this.this$0).a.mVideoVid, qiy.a(this.this$0).a.innerUniqueID, (int)qiy.a(this.this$0).a.mChannelID, null), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.4
 * JD-Core Version:    0.7.0.1
 */