package com.tencent.biz.pubaccount.readinjoy.model;

import android.text.TextUtils;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;

class SelectPositionModule$1
  extends SosoInterfaceOnLocationListener
{
  SelectPositionModule$1(SelectPositionModule paramSelectPositionModule, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelectPositionModule", 2, "onLocationFinish() errCode=" + paramInt);
    }
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null) && (!TextUtils.isEmpty(paramSosoLbsInfo.mLocation.city)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPositionModule", 2, "onLocationFinish() info.mLocation =" + paramSosoLbsInfo.mLocation);
      }
      SelectPositionModule.a(this.a, new SelectPositionModule.PositionData(paramSosoLbsInfo.mLocation));
      SelectPositionModule.a(this.a, SelectPositionModule.a(this.a));
      SelectPositionModule.b(this.a, SelectPositionModule.a(this.a));
      if (SelectPositionModule.a(this.a) != null) {
        SelectPositionModule.a(this.a).a(SelectPositionModule.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.1
 * JD-Core Version:    0.7.0.1
 */