package com.tencent.biz.addContactTroopView;

import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class AddContactTroopHandler$1
  extends LbsManagerServiceOnLocationChangeListener
{
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramInt == 0) {}
    try
    {
      this.b.a(this.a, paramSosoLbsInfo);
      return;
    }
    catch (Exception paramSosoLbsInfo)
    {
      break label58;
    }
    if (paramInt == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.w("AddContactTroopHandler", 2, "location permission denied 2");
      }
      this.b.a(this.a);
      return;
    }
    this.a.b();
    return;
    label58:
    paramSosoLbsInfo.printStackTrace();
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.AddContactTroopHandler.1
 * JD-Core Version:    0.7.0.1
 */