package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import java.io.File;

class RIJUgcVideoPublishManager$6
  implements Runnable
{
  RIJUgcVideoPublishManager$6(RIJUgcVideoPublishManager paramRIJUgcVideoPublishManager, UgcVideo paramUgcVideo) {}
  
  public void run()
  {
    File localFile;
    if ((this.a.compressPath != null) && (!this.a.compressPath.isEmpty()))
    {
      localFile = new File(this.a.compressPath);
      if ((localFile.exists()) && (!this.a.compressPath.equals(this.a.filePath))) {
        localFile.delete();
      }
    }
    if ((this.a.coverPath != null) && (!this.a.coverPath.isEmpty()))
    {
      localFile = new File(this.a.coverPath);
      if (localFile.exists()) {
        localFile.delete();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.6
 * JD-Core Version:    0.7.0.1
 */