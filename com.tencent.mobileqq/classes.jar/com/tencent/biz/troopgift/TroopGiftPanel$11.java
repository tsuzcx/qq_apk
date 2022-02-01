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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getGiftStorage, onGetStockResult: count = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", giveCount=");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(", info=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", giveGifts.size=");
    ((StringBuilder)localObject).append(paramList.size());
    QLog.d("TroopGiftPanel", 1, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.i = (paramInt1 + paramInt2);
    paramString = Looper.getMainLooper().getThread();
    localObject = Thread.currentThread();
    int i = 0;
    if (paramString == localObject)
    {
      paramString = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("");
      paramString.setText(((StringBuilder)localObject).toString());
      if (paramInt2 > 0)
      {
        paramString = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_c_of_type_AndroidWidgetTextView;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("+");
        ((StringBuilder)localObject).append(paramInt2);
        paramString.setText(((StringBuilder)localObject).toString());
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_c_of_type_AndroidWidgetTextView.setText("");
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    else
    {
      new Handler(Looper.getMainLooper()).post(new TroopGiftPanel.11.1(this, paramInt1, paramInt2));
    }
    paramString = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnGetGiveGiftCallback;
    if (paramString != null)
    {
      paramString.a(paramList);
      paramInt1 = i;
    }
    else
    {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.a(paramList);
      paramInt1 = i;
    }
    try
    {
      while (paramInt1 < TroopGiftPanel.jdField_c_of_type_Int)
      {
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[paramInt1] != null) {
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[paramInt1].a();
        }
        paramInt1 += 1;
      }
      label372:
      return;
    }
    catch (Exception paramString)
    {
      try
      {
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[TroopGiftPanel.jdField_c_of_type_Int] != null) {
            this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[TroopGiftPanel.jdField_c_of_type_Int].a();
          }
          try
          {
            if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[TroopGiftPanel.d] != null) {
              this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[TroopGiftPanel.d].a();
            }
            return;
          }
          catch (Exception paramString) {}
          paramString = paramString;
        }
      }
      catch (Exception paramString)
      {
        break label372;
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getGiftStorage, onError: errorCode = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", errorMsg = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("TroopGiftPanel", 1, ((StringBuilder)localObject).toString());
    paramString = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnGetGiveGiftCallback;
    if (paramString != null) {
      paramString.a(paramInt);
    }
    paramString = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a();
    localObject = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_c_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
    ReportController.b(null, "dc00899", "Grp_flower", "", "video_mall", "fail_expbean", 0, 0, paramString, "", (String)localObject, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.11
 * JD-Core Version:    0.7.0.1
 */