package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.troop.recommend.api.ITroopRecommendHandler;
import com.tencent.qphone.base.util.QLog;

class AddContactFindTroopRTLW$1
  extends LbsManagerServiceOnLocationChangeListener
{
  AddContactFindTroopRTLW$1(AddContactFindTroopRTLW paramAddContactFindTroopRTLW, String paramString, ITroopRecommendHandler paramITroopRecommendHandler, boolean paramBoolean)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getRecommendTroopList onLocationFinish info = ");
      localStringBuilder.append(paramSosoLbsInfo);
      QLog.i("ac_ft.AddContactFindTroopRTLW", 2, localStringBuilder.toString());
    }
    if (paramInt != 0)
    {
      paramSosoLbsInfo = new StringBuilder();
      paramSosoLbsInfo.append("getRecommendTroopList onLocationFinish, errorCode=");
      paramSosoLbsInfo.append(paramInt);
      QLog.i("ac_ft.AddContactFindTroopRTLW", 1, paramSosoLbsInfo.toString());
    }
    this.a.a(1, this.c.d, 25, this.b, AddContactFindTroopRTLW.a(this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactFindTroopRTLW.1
 * JD-Core Version:    0.7.0.1
 */