package com.tencent.biz.troop;

import com.tencent.mobileqq.app.HardCodeUtil;
import java.io.File;
import java.util.ArrayList;

class VideoCombineHelper$4
  implements Runnable
{
  public void run()
  {
    File localFile1 = new File(VideoCombineHelper.a + File.separator + "v1.mp4");
    File localFile2 = new File(VideoCombineHelper.a + File.separator + "v2.mp4");
    File localFile3 = new File(VideoCombineHelper.a + File.separator + "v3.mp4");
    File localFile4 = new File(VideoCombineHelper.a + File.separator + "v4.mp4");
    File localFile5 = new File(VideoCombineHelper.a + File.separator + "m1.m4a");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localFile4.getAbsolutePath());
    localArrayList.add(localFile2.getAbsolutePath());
    localArrayList.add(localFile3.getAbsolutePath());
    localArrayList.add(localFile1.getAbsolutePath());
    new VideoCombineHelper.CombineTask(this.this$0, new VideoCombineHelper.4.1(this), "key", localArrayList, localFile5.getAbsolutePath(), HardCodeUtil.a(2131715944)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.4
 * JD-Core Version:    0.7.0.1
 */