package com.tencent.biz.troop;

import alud;
import java.io.File;
import java.util.ArrayList;
import ysb;
import yse;
import ysm;

public class VideoCombineHelper$4
  implements Runnable
{
  public void run()
  {
    File localFile1 = new File(ysb.a + File.separator + "v1.mp4");
    File localFile2 = new File(ysb.a + File.separator + "v2.mp4");
    File localFile3 = new File(ysb.a + File.separator + "v3.mp4");
    File localFile4 = new File(ysb.a + File.separator + "v4.mp4");
    File localFile5 = new File(ysb.a + File.separator + "m1.m4a");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localFile4.getAbsolutePath());
    localArrayList.add(localFile2.getAbsolutePath());
    localArrayList.add(localFile3.getAbsolutePath());
    localArrayList.add(localFile1.getAbsolutePath());
    new ysm(this.this$0, new yse(this), "key", localArrayList, localFile5.getAbsolutePath(), alud.a(2131716510)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.4
 * JD-Core Version:    0.7.0.1
 */