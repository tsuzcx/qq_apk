package com.tencent.biz.videostory.capture;

import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import wql;

public class AEBottomListAdapter$2
  implements Runnable
{
  public AEBottomListAdapter$2(wql paramwql) {}
  
  public void run()
  {
    FeatureManager.loadBasicFeatures();
    QLog.d("Q.videostory.capture", 1, "use watermark failed because of so load failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.AEBottomListAdapter.2
 * JD-Core Version:    0.7.0.1
 */