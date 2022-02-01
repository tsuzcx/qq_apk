package com.tencent.mobileqq.activity.shopping;

import VAC_ADV_GET_ACCESS.VacAdvGetAccess.VacMemberGetOrderCntRsp;
import android.os.Message;
import com.tencent.mobileqq.app.BusinessObserver;
import mqq.os.MqqHandler;

class ShoppingFragment$2
  implements BusinessObserver
{
  ShoppingFragment$2(ShoppingFragment paramShoppingFragment) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof VacAdvGetAccess.VacMemberGetOrderCntRsp)))
    {
      Message localMessage = Message.obtain();
      localMessage.obj = paramObject;
      localMessage.what = 1001;
      ShoppingFragment.a(this.a).sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shopping.ShoppingFragment.2
 * JD-Core Version:    0.7.0.1
 */