package com.tencent.biz.videostory.capture;

import com.tencent.biz.videostory.capture.widgets.AEBottomListScrollView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import wql;
import wqq;
import wsi;

public class AEBottomListPart$6
  implements Runnable
{
  public AEBottomListPart$6(wqq paramwqq, long paramLong) {}
  
  public void run()
  {
    if (wqq.a(this.this$0)) {
      return;
    }
    if (wqq.a(this.this$0).b()) {
      wqq.a(this.this$0).setVisibility(0);
    }
    wqq.a(this.this$0).a(new ArrayList());
    QLog.d("AEWaterMarkListPart", 4, "hot data is empty, updatePackage, total cost=" + (System.currentTimeMillis() - this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.AEBottomListPart.6
 * JD-Core Version:    0.7.0.1
 */