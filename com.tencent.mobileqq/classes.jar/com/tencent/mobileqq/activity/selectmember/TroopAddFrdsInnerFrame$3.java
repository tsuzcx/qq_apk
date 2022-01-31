package com.tencent.mobileqq.activity.selectmember;

import com.tencent.qphone.base.util.QLog;

class TroopAddFrdsInnerFrame$3
  implements Runnable
{
  TroopAddFrdsInnerFrame$3(TroopAddFrdsInnerFrame paramTroopAddFrdsInnerFrame) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopAddFrdsInnerFrame", 2, "read troop members from database before updating data from server");
    }
    TroopAddFrdsInnerFrame.a(this.this$0, this.this$0.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopAddFrdsInnerFrame.3
 * JD-Core Version:    0.7.0.1
 */