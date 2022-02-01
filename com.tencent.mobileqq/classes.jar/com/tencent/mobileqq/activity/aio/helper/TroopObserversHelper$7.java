package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.troopfriend.api.ITroopBatchAddFriendService;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class TroopObserversHelper$7
  extends TroopMngObserver
{
  TroopObserversHelper$7(TroopObserversHelper paramTroopObserversHelper) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 9) && (TroopObserversHelper.a(this.a).y())) {
      QQToast.a(TroopObserversHelper.a(this.a), 1, HardCodeUtil.a(2131715047), 0).a();
    }
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 == 2) || (paramInt1 == 9))
    {
      if (paramInt2 == 0)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onTroopManagerSuccess, isTroopOwner =");
          ((StringBuilder)localObject).append(TroopObserversHelper.a(this.a).y());
          QLog.i("troop.credit.act", 2, ((StringBuilder)localObject).toString());
        }
        Object localObject = HardCodeUtil.a(2131715052);
        if (TroopObserversHelper.a(this.a).y()) {
          localObject = HardCodeUtil.a(2131715050);
        }
        QQToast.a(TroopObserversHelper.a(this.a), 2, (CharSequence)localObject, 0).a();
        localObject = TroopObserversHelper.a(this.a).getCurrentUin();
        TroopObserversHelper.a(this.a, paramString, (String)localObject);
        ((ITroopBatchAddFriendService)TroopObserversHelper.a(this.a).getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr().a(TroopObserversHelper.a(this.a).a);
        return;
      }
      QQToast.a(TroopObserversHelper.a(this.a), 1, HardCodeUtil.a(2131715045), 0).a();
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if ((paramBoolean) && (String.valueOf(paramLong).equals(TroopObserversHelper.a(this.a).a)) && (TroopObserversHelper.a(this.a).y()) && (!paramString2.equals(TroopObserversHelper.a(this.a).getCurrentAccountUin()))) {
      TroopObserversHelper.a(this.a).p(false);
    }
  }
  
  protected void b(String paramString)
  {
    if ((TroopObserversHelper.a(this.a).a.equals(paramString)) && (!TroopObserversHelper.a(this.a).B)) {
      TroopObserversHelper.a(this.a).b(1);
    }
  }
  
  protected void c(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(TroopObserversHelper.a(this.a).a))) {
      TroopObserversHelper.a(this.a).m();
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopObserversHelper", 2, String.format("onAddTroopSuccess, troopUin: %s", new Object[] { paramString }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopObserversHelper.7
 * JD-Core Version:    0.7.0.1
 */