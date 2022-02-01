package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import ocd;
import rwc;
import rwu;
import sbf;
import sbg;

public class VideoUIManager$9
  implements Runnable
{
  public VideoUIManager$9(rwu paramrwu, int paramInt) {}
  
  public void run()
  {
    if ((rwu.a(this.this$0) != null) && (rwu.a(this.this$0).a != null))
    {
      sbg localsbg = new sbg("", "", rwu.a(this.this$0).a.mVideoVid, rwu.a(this.this$0).a.innerUniqueID).a((int)rwu.a(this.this$0).a.mChannelID);
      ocd.a(null, "", "0X8008AD0", "0X8008AD0", 0, 0, "", "", "", localsbg.a().a(), false);
      ocd.a(null, "", "0X8009B57", "0X8009B57", 0, 0, String.valueOf(this.a), "", "", localsbg.a().a(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.9
 * JD-Core Version:    0.7.0.1
 */