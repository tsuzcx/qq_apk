package com.tencent.biz.troopgift;

import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class TroopGiftPanel$18
  extends TroopGiftCallback
{
  TroopGiftPanel$18(TroopGiftPanel paramTroopGiftPanel, int paramInt, TroopGiftAioItemData paramTroopGiftAioItemData) {}
  
  public void a(int paramInt)
  {
    paramInt = this.a;
    String str1 = this.c.getTroopUin();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(this.b.i);
    localObject = ((StringBuilder)localObject).toString();
    String str2 = this.c.H;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(TroopMemberUtil.a((AppInterface)this.c.l.get(), ((AppInterface)this.c.l.get()).getCurrentAccountUin(), this.c.getTroopUin()));
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
    Object localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = HardCodeUtil.a(2131912671);
    }
    QQToast.makeText(this.c.m, (CharSequence)localObject, 0).show(this.c.getResources().getDimensionPixelSize(2131299920)).show();
    paramInt = this.a;
    paramString = this.c.getTroopUin();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(this.b.i);
    localObject = ((StringBuilder)localObject).toString();
    String str = this.c.H;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(TroopMemberUtil.a((AppInterface)this.c.l.get(), ((AppInterface)this.c.l.get()).getCurrentAccountUin(), this.c.getTroopUin()));
    ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "send_forone_fail", paramInt, 0, paramString, (String)localObject, str, localStringBuilder.toString());
  }
  
  public void b(int paramInt, String paramString)
  {
    super.b(paramInt, paramString);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = HardCodeUtil.a(2131912681);
    }
    QQToast.makeText(this.c.m, str, 0).show(this.c.getResources().getDimensionPixelSize(2131299920)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.18
 * JD-Core Version:    0.7.0.1
 */