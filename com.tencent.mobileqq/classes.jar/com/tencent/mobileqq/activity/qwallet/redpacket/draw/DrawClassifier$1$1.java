package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.qphone.base.util.QLog;

class DrawClassifier$1$1
  implements IPreloadService.OnGetPathListener
{
  DrawClassifier$1$1(DrawClassifier.1 param1) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DrawClassifier", 2, "tryPreDownLoadModel finished:" + paramInt);
    }
    if (paramInt == 0) {
      DrawClassifier.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawClassifier.1.1
 * JD-Core Version:    0.7.0.1
 */