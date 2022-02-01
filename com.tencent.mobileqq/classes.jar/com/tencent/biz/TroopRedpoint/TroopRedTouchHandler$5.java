package com.tencent.biz.TroopRedpoint;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.qphone.base.util.QLog;

class TroopRedTouchHandler$5
  extends MessageObserver
{
  TroopRedTouchHandler$5(TroopRedTouchHandler paramTroopRedTouchHandler) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (105 == paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.i("storyRedDotDebug", 2, "mGetRedPointPushObserver");
      }
      this.a.notifyUI(105, true, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.TroopRedpoint.TroopRedTouchHandler.5
 * JD-Core Version:    0.7.0.1
 */