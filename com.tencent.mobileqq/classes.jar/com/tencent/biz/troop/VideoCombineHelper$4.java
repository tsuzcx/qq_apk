package com.tencent.biz.troop;

import com.tencent.mobileqq.app.HardCodeUtil;
import java.io.File;
import java.util.ArrayList;

class VideoCombineHelper$4
  implements Runnable
{
  public void run()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(VideoCombineHelper.a);
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append("v1.mp4");
    localObject1 = new File(((StringBuilder)localObject1).toString());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(VideoCombineHelper.a);
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append("v2.mp4");
    localObject2 = new File(((StringBuilder)localObject2).toString());
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(VideoCombineHelper.a);
    ((StringBuilder)localObject3).append(File.separator);
    ((StringBuilder)localObject3).append("v3.mp4");
    localObject3 = new File(((StringBuilder)localObject3).toString());
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(VideoCombineHelper.a);
    ((StringBuilder)localObject4).append(File.separator);
    ((StringBuilder)localObject4).append("v4.mp4");
    localObject4 = new File(((StringBuilder)localObject4).toString());
    Object localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append(VideoCombineHelper.a);
    ((StringBuilder)localObject5).append(File.separator);
    ((StringBuilder)localObject5).append("m1.m4a");
    localObject5 = new File(((StringBuilder)localObject5).toString());
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(((File)localObject4).getAbsolutePath());
    localArrayList.add(((File)localObject2).getAbsolutePath());
    localArrayList.add(((File)localObject3).getAbsolutePath());
    localArrayList.add(((File)localObject1).getAbsolutePath());
    new VideoCombineHelper.CombineTask(this.this$0, new VideoCombineHelper.4.1(this), "key", localArrayList, ((File)localObject5).getAbsolutePath(), HardCodeUtil.a(2131715867)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.4
 * JD-Core Version:    0.7.0.1
 */