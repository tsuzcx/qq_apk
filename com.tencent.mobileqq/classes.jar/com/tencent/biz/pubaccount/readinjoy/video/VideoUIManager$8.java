package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import ocd;
import odr;
import rwc;
import rwu;

public class VideoUIManager$8
  implements Runnable
{
  public VideoUIManager$8(rwu paramrwu) {}
  
  public void run()
  {
    if ((rwu.a(this.this$0) != null) && (rwu.a(this.this$0).a != null)) {
      ocd.a(null, "", "0X8008ACF", "0X8008ACF", 0, 0, "", "", "", odr.a(rwu.a(this.this$0).a.mVideoVid, rwu.a(this.this$0).a.innerUniqueID, (int)rwu.a(this.this$0).a.mChannelID, null), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.8
 * JD-Core Version:    0.7.0.1
 */