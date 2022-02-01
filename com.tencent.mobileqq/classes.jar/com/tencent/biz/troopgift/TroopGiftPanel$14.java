package com.tencent.biz.troopgift;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class TroopGiftPanel$14
  extends TroopGiftCallback
{
  TroopGiftPanel$14(TroopGiftPanel paramTroopGiftPanel, int paramInt, TroopGiftAioItemData paramTroopGiftAioItemData) {}
  
  public void a(int paramInt)
  {
    paramInt = this.jdField_a_of_type_Int;
    String str1 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData.e);
    localObject = ((StringBuilder)localObject).toString();
    String str2 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
    ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "send_forone_suc", paramInt, 0, str1, (String)localObject, str2, localStringBuilder.toString());
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetThrowGiftResult() onError errorCode = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", errorMsg = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("zivonchen", 2, ((StringBuilder)localObject).toString());
    }
    QQToast.a(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131715208), 0).b(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.getResources().getDimensionPixelSize(2131299168));
    paramInt = this.jdField_a_of_type_Int;
    paramString = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData.e);
    localObject = ((StringBuilder)localObject).toString();
    String str = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
    ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "send_forone_fail", paramInt, 0, paramString, (String)localObject, str, localStringBuilder.toString());
  }
  
  public void b(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onGetThrowGiftResult() onError errorCode = ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(", errorMsg = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("zivonchen", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_AndroidContentContext;
    Object localObject1 = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject1 = HardCodeUtil.a(2131715193);
    }
    QQToast.a((Context)localObject2, (CharSequence)localObject1, 0).b(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.getResources().getDimensionPixelSize(2131299168));
    paramInt = this.jdField_a_of_type_Int;
    paramString = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData.e);
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
    ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "send_forone_fail", paramInt, 0, paramString, (String)localObject1, (String)localObject2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.14
 * JD-Core Version:    0.7.0.1
 */