package com.tencent.mobileqq.activity;

import SummaryCardTaf.SSummaryCardRsp;
import android.annotation.TargetApi;
import android.os.Message;
import android.util.Pair;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.concurrent.atomic.AtomicBoolean;

class VipProfileCardDiyActivity$4
  extends CardObserver
{
  VipProfileCardDiyActivity$4(VipProfileCardDiyActivity paramVipProfileCardDiyActivity) {}
  
  @TargetApi(9)
  public void onSetCardTemplateReturn(boolean paramBoolean, Object paramObject)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CardObserver onSetCardTemplateReturn isSuccess : ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", obj : ");
      ((StringBuilder)localObject).append(paramObject);
      QLog.d("VipProfileCardDiyActivity", 2, ((StringBuilder)localObject).toString());
    }
    this.a.b.set(false);
    this.a.a.removeMessages(6);
    this.a.i();
    if ((paramBoolean) && (paramObject != null))
    {
      if ((paramObject instanceof Card))
      {
        ThreadManager.post(new VipProfileCardDiyActivity.4.1(this, (Card)paramObject), 5, null, true);
      }
      else if ((paramObject instanceof Pair))
      {
        paramObject = (Pair)paramObject;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("set diy card failed, code=");
        ((StringBuilder)localObject).append(paramObject.first);
        ((StringBuilder)localObject).append(", msg=");
        ((StringBuilder)localObject).append(((SSummaryCardRsp)paramObject.second).emsg);
        QLog.e("VipProfileCardDiyActivity", 1, ((StringBuilder)localObject).toString());
        if (((Integer)paramObject.first).intValue() == 101107)
        {
          localObject = this.a;
          ((VipProfileCardDiyActivity)localObject).n = 1;
          ((VipProfileCardDiyActivity)localObject).a.obtainMessage(2, ((SSummaryCardRsp)paramObject.second).emsg).sendToTarget();
          if (VasUtil.a(this.a.app).getVipStatus().isVip()) {
            paramObject = "3";
          } else {
            paramObject = "2";
          }
          VasWebviewUtil.a("", "card_mall", "0X80081C2", "", 1, 0, 0, "", paramObject, String.valueOf(this.a.j));
        }
        else if (((Integer)paramObject.first).intValue() == 101108)
        {
          localObject = this.a;
          ((VipProfileCardDiyActivity)localObject).n = 2;
          ((VipProfileCardDiyActivity)localObject).a.obtainMessage(2, ((SSummaryCardRsp)paramObject.second).emsg).sendToTarget();
          if (VasUtil.a(this.a.app).getVipStatus().isSVip()) {
            paramObject = "3";
          } else {
            paramObject = "2";
          }
          VasWebviewUtil.a("", "card_mall", "0X80081C2", "", 1, 0, 0, "", paramObject, String.valueOf(this.a.j));
        }
        else if (((Integer)paramObject.first).intValue() == 401019)
        {
          this.a.a.obtainMessage(8, ((SSummaryCardRsp)paramObject.second).emsg).sendToTarget();
        }
        else if (((Integer)paramObject.first).intValue() == 401020)
        {
          this.a.a.obtainMessage(7, ((SSummaryCardRsp)paramObject.second).emsg).sendToTarget();
        }
        else if (((Integer)paramObject.first).intValue() == 401009)
        {
          localObject = this.a;
          ((VipProfileCardDiyActivity)localObject).n = 2;
          ((VipProfileCardDiyActivity)localObject).a.obtainMessage(2, ((SSummaryCardRsp)paramObject.second).emsg).sendToTarget();
          if (VasUtil.a(this.a.app).getVipStatus().isSVip()) {
            paramObject = "3";
          } else {
            paramObject = "2";
          }
          VasWebviewUtil.a("", "card_mall", "0X80081C2", "", 1, 0, 0, "", paramObject, String.valueOf(this.a.j));
        }
        else
        {
          localObject = this.a.a.obtainMessage(1);
          if ((((Integer)paramObject.first).intValue() >= 400000) && (((Integer)paramObject.first).intValue() <= 499999)) {
            ((Message)localObject).obj = ((SSummaryCardRsp)paramObject.second).emsg;
          }
          this.a.a.sendMessage((Message)localObject);
        }
      }
    }
    else
    {
      paramObject = this.a.a.obtainMessage(1);
      this.a.a.sendMessage(paramObject);
    }
    paramObject = this.a;
    paramObject.f = null;
    paramObject.j = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VipProfileCardDiyActivity.4
 * JD-Core Version:    0.7.0.1
 */