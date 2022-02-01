package com.tencent.biz.troopgift;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.troop.utils.TroopGiftManager.PackGift;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class TroopGiftPanel$13
  implements TroopGiftPanel.OnGetPackGiftCallback
{
  TroopGiftPanel$13(TroopGiftPanel paramTroopGiftPanel) {}
  
  public void a(int paramInt) {}
  
  public void a(List<TroopGiftManager.PackGift> paramList, TroopGiftAioPanelData.EmptyPackagePage paramEmptyPackagePage)
  {
    if (this.a.B == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopGiftPanel", 2, "getPackGiftStorage--onGetPackGift error--mTroopGifPanelData is null");
      }
      return;
    }
    this.a.B.c(paramList);
    this.a.B.a(paramEmptyPackagePage);
    if ((this.a.B != null) && (this.a.B.j != null) && (this.a.B.j.size() > 0) && (this.a.B.w.size() > 0) && (this.a.B.q != -1))
    {
      paramList = this.a;
      paramList.A = ((TroopGiftAioItemData)paramList.B.j.get(this.a.B.q));
      paramList = this.a;
      TroopGiftPanel.a(paramList, paramList.A);
    }
    if (this.a.j())
    {
      paramList = this.a;
      boolean bool;
      if ((!TextUtils.isEmpty(paramList.Z)) && (TroopGiftPanel.c(this.a))) {
        bool = true;
      } else {
        bool = false;
      }
      paramList.setSendGiftBtnEnabled(bool);
      return;
    }
    paramList = this.a;
    paramList.setSendGiftBtnEnabled(TroopGiftPanel.c(paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.13
 * JD-Core Version:    0.7.0.1
 */