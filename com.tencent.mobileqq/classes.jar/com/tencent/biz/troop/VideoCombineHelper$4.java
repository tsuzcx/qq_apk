package com.tencent.biz.troop;

import ajjy;
import java.io.File;
import java.util.ArrayList;
import wju;
import wjx;
import wkf;

public class VideoCombineHelper$4
  implements Runnable
{
  public void run()
  {
    File localFile1 = new File(wju.a + File.separator + "v1.mp4");
    File localFile2 = new File(wju.a + File.separator + "v2.mp4");
    File localFile3 = new File(wju.a + File.separator + "v3.mp4");
    File localFile4 = new File(wju.a + File.separator + "v4.mp4");
    File localFile5 = new File(wju.a + File.separator + "m1.m4a");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localFile4.getAbsolutePath());
    localArrayList.add(localFile2.getAbsolutePath());
    localArrayList.add(localFile3.getAbsolutePath());
    localArrayList.add(localFile1.getAbsolutePath());
    new wkf(this.this$0, new wjx(this), "key", localArrayList, localFile5.getAbsolutePath(), ajjy.a(2131650324)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.4
 * JD-Core Version:    0.7.0.1
 */