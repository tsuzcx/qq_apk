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
    QLog.d("TroopGiftPanel", 1, "getPackGiftStorage, onError: errorCode = " + paramInt + ", errorMsg = " + paramString);
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnGetPackGiftCallback != null) {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnGetPackGiftCallback.a(paramInt);
    }
  }
  
  public void a(List<TroopGiftManager.PackGift> paramList, TroopGiftAioPanelData.EmptyPackagePage paramEmptyPackagePage)
  {
    boolean bool2 = true;
    QLog.d("TroopGiftPanel", 1, "getPackGiftStorage, onGetPackageGiftList giveGifts.size=" + paramList.size());
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData == null) {
      return;
    }
    boolean bool1;
    label170:
    int i;
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnGetPackGiftCallback != null)
    {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnGetPackGiftCallback.a(paramList, paramEmptyPackagePage);
      if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ArrayOfAndroidViewView[TroopGiftPanel.d] instanceof RadioViewPager))
      {
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.a != null)
        {
          ((RadioViewPager)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ArrayOfAndroidViewView[TroopGiftPanel.d]).setEmptyInfo(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.a.b);
          paramList = (RadioViewPager)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ArrayOfAndroidViewView[TroopGiftPanel.d];
          if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.a.jdField_a_of_type_Int != 1) {
            break label412;
          }
          bool1 = true;
          paramList.setIsShowJumpInfo(bool1, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.a.c, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_AndroidContentContext);
        }
        if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.e == null) || (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.e.size() <= 0)) {
          break label418;
        }
        i = 1;
        label227:
        paramList = (RadioViewPager)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ArrayOfAndroidViewView[TroopGiftPanel.d];
        if (i != 0) {
          break label423;
        }
        bool1 = true;
        label249:
        paramList.setIsListEmpty(bool1);
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.d())
        {
          paramList = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.i;
          if (i == 0) {
            break label429;
          }
          i = 0;
          label279:
          paramList.setVisibility(i);
        }
      }
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[TroopGiftPanel.d] != null)
        {
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[TroopGiftPanel.d].setData(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.e);
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[TroopGiftPanel.d].a();
        }
        if (!this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.d()) {
          break label440;
        }
        paramList = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel;
        if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.f)) || (!TroopGiftPanel.a(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel))) {
          break label434;
        }
        bool1 = bool2;
        paramList.setSendGiftBtnEnabled(bool1);
        return;
      }
      catch (Exception paramList)
      {
        return;
      }
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.b(paramList);
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.a(paramEmptyPackagePage);
      break;
      label412:
      bool1 = false;
      break label170;
      label418:
      i = 0;
      break label227;
      label423:
      bool1 = false;
      break label249;
      label429:
      i = 4;
      break label279;
      label434:
      bool1 = false;
    }
    label440:
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setSendGiftBtnEnabled(TroopGiftPanel.a(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.21
 * JD-Core Version:    0.7.0.1
 */