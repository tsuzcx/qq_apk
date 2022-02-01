package com.tencent.biz.troopgift;

import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.mobileqq.troop.utils.TroopGiftManager.GiveGift;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

class TroopGiftPanel$11
  extends TroopGiftCallback
{
  TroopGiftPanel$11(TroopGiftPanel paramTroopGiftPanel, TroopGiftPanel.OnGetGiveGiftCallback paramOnGetGiveGiftCallback) {}
  
  public void a(int paramInt1, int paramInt2, String paramString, List<TroopGiftManager.GiveGift> paramList)
  {
    int i = 0;
    QLog.d("TroopGiftPanel", 1, "getGiftStorage, onGetStockResult: count = " + paramInt1 + ", giveCount=" + paramInt2 + ", info=" + paramString + ", giveGifts.size=" + paramList.size());
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.i = (paramInt1 + paramInt2);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b.setText(paramInt1 + "");
      if (paramInt2 > 0)
      {
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_c_of_type_AndroidWidgetTextView.setText("+" + paramInt2);
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnGetGiveGiftCallback == null) {
          break label269;
        }
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnGetGiveGiftCallback.a(paramList);
      }
    }
    for (paramInt1 = i;; paramInt1 = i)
    {
      label269:
      try
      {
        while (paramInt1 < TroopGiftPanel.jdField_c_of_type_Int)
        {
          if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[paramInt1] != null) {
            this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[paramInt1].a();
          }
          paramInt1 += 1;
        }
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_c_of_type_AndroidWidgetTextView.setText("");
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      catch (Exception paramString) {}
      new Handler(Looper.getMainLooper()).post(new TroopGiftPanel.11.1(this, paramInt1, paramInt2));
      break;
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.a(paramList);
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[TroopGiftPanel.jdField_c_of_type_Int] != null) {
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[TroopGiftPanel.jdField_c_of_type_Int].a();
      }
      try
      {
        label316:
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[TroopGiftPanel.d] != null) {
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[TroopGiftPanel.d].a();
        }
        return;
      }
      catch (Exception paramString) {}
    }
    catch (Exception paramString)
    {
      break label316;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.d("TroopGiftPanel", 1, "getGiftStorage, onError: errorCode = " + paramInt + ", errorMsg = " + paramString);
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnGetGiveGiftCallback != null) {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnGetGiveGiftCallback.a(paramInt);
    }
    ReportController.b(null, "dc00899", "Grp_flower", "", "video_mall", "fail_expbean", 0, 0, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), "", this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_c_of_type_JavaLangString, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.11
 * JD-Core Version:    0.7.0.1
 */