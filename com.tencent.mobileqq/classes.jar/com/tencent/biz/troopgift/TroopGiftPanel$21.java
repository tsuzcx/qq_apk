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
    paramString = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnGetPackGiftCallback;
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
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData == null) {
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnGetPackGiftCallback;
    if (localObject != null)
    {
      ((TroopGiftPanel.OnGetPackGiftCallback)localObject).a(paramList, paramEmptyPackagePage);
    }
    else
    {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.b(paramList);
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.a(paramEmptyPackagePage);
    }
    boolean bool1 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ArrayOfAndroidViewView[TroopGiftPanel.d] instanceof RadioViewPager;
    boolean bool2 = false;
    if (bool1)
    {
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.a != null)
      {
        ((RadioViewPager)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ArrayOfAndroidViewView[TroopGiftPanel.d]).setEmptyInfo(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.a.b);
        paramList = (RadioViewPager)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ArrayOfAndroidViewView[TroopGiftPanel.d];
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.a.jdField_a_of_type_Int == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        paramList.setIsShowJumpInfo(bool1, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.a.c, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_AndroidContentContext);
      }
      int i;
      if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.e != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.e.size() > 0)) {
        i = 1;
      } else {
        i = 0;
      }
      ((RadioViewPager)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ArrayOfAndroidViewView[TroopGiftPanel.d]).setIsListEmpty(i ^ 0x1);
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.d())
      {
        paramList = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.i;
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
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[TroopGiftPanel.d] != null)
      {
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[TroopGiftPanel.d].setData(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.e);
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[TroopGiftPanel.d].a();
      }
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.d())
      {
        paramList = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel;
        bool1 = bool2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.f))
        {
          bool1 = bool2;
          if (TroopGiftPanel.a(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel)) {
            bool1 = true;
          }
        }
        paramList.setSendGiftBtnEnabled(bool1);
        return;
      }
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setSendGiftBtnEnabled(TroopGiftPanel.a(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel));
      return;
    }
    catch (Exception paramList) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.21
 * JD-Core Version:    0.7.0.1
 */