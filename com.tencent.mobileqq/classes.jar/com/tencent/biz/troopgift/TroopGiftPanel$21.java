package com.tencent.biz.troopgift;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.mobileqq.troop.utils.TroopGiftManager.PackGift;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class TroopGiftPanel$21
  extends TroopGiftCallback
{
  TroopGiftPanel$21(TroopGiftPanel paramTroopGiftPanel, TroopGiftPanel.OnGetPackGiftCallback paramOnGetPackGiftCallback) {}
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getPackGiftStorage, onError: errorCode = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errorMsg = ");
    localStringBuilder.append(paramString);
    QLog.d("TroopGiftPanel", 1, localStringBuilder.toString());
    paramString = this.a;
    if (paramString != null) {
      paramString.a(paramInt);
    }
  }
  
  public void a(List<TroopGiftManager.PackGift> paramList, TroopGiftAioPanelData.EmptyPackagePage paramEmptyPackagePage)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getPackGiftStorage, onGetPackageGiftList giveGifts.size=");
    ((StringBuilder)localObject).append(paramList.size());
    QLog.d("TroopGiftPanel", 1, ((StringBuilder)localObject).toString());
    if (this.b.B == null) {
      return;
    }
    localObject = this.a;
    if (localObject != null)
    {
      ((TroopGiftPanel.OnGetPackGiftCallback)localObject).a(paramList, paramEmptyPackagePage);
    }
    else
    {
      this.b.B.c(paramList);
      this.b.B.a(paramEmptyPackagePage);
    }
    boolean bool1 = this.b.q[TroopGiftPanel.d] instanceof RadioViewPager;
    boolean bool2 = false;
    if (bool1)
    {
      if (this.b.B.x != null)
      {
        ((RadioViewPager)this.b.q[TroopGiftPanel.d]).setEmptyInfo(this.b.B.x.b, this.b.B.x.c);
        paramList = (RadioViewPager)this.b.q[TroopGiftPanel.d];
        if (this.b.B.x.a == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        paramList.setIsShowJumpInfo(bool1, this.b.B.x.d, this.b.m);
      }
      int i;
      if ((this.b.B.j != null) && (this.b.B.j.size() > 0)) {
        i = 1;
      } else {
        i = 0;
      }
      ((RadioViewPager)this.b.q[TroopGiftPanel.d]).setIsListEmpty(i ^ 0x1);
      if (this.b.j())
      {
        paramList = this.b.U;
        if (i != 0) {
          i = 0;
        } else {
          i = 4;
        }
        paramList.setVisibility(i);
      }
    }
    try
    {
      if (this.b.p[TroopGiftPanel.d] != null)
      {
        this.b.p[TroopGiftPanel.d].setData(this.b.B.j);
        this.b.p[TroopGiftPanel.d].a();
      }
      if (this.b.j())
      {
        paramList = this.b;
        bool1 = bool2;
        if (!TextUtils.isEmpty(this.b.Z))
        {
          bool1 = bool2;
          if (TroopGiftPanel.c(this.b)) {
            bool1 = true;
          }
        }
        paramList.setSendGiftBtnEnabled(bool1);
        return;
      }
      this.b.setSendGiftBtnEnabled(TroopGiftPanel.c(this.b));
      return;
    }
    catch (Exception paramList) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.21
 * JD-Core Version:    0.7.0.1
 */