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
    if ((paramInt1 == 9) && (TroopObserversHelper.d(this.a).cd())) {
      QQToast.makeText(TroopObserversHelper.g(this.a), 1, HardCodeUtil.a(2131912537), 0).show();
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
          ((StringBuilder)localObject).append(TroopObserversHelper.d(this.a).cd());
          QLog.i("troop.credit.act", 2, ((StringBuilder)localObject).toString());
        }
        Object localObject = HardCodeUtil.a(2131912541);
        if (TroopObserversHelper.d(this.a).cd()) {
          localObject = HardCodeUtil.a(2131912540);
        }
        QQToast.makeText(TroopObserversHelper.g(this.a), 2, (CharSequence)localObject, 0).show();
        localObject = TroopObserversHelper.a(this.a).getCurrentUin();
        TroopObserversHelper.a(this.a, paramString, (String)localObject);
        ((ITroopBatchAddFriendService)TroopObserversHelper.a(this.a).getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr().b(TroopObserversHelper.b(this.a).b);
        return;
      }
      QQToast.makeText(TroopObserversHelper.g(this.a), 1, HardCodeUtil.a(2131912535), 0).show();
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if ((paramBoolean) && (String.valueOf(paramLong).equals(TroopObserversHelper.b(this.a).b)) && (TroopObserversHelper.d(this.a).cd()) && (!paramString2.equals(TroopObserversHelper.a(this.a).getCurrentAccountUin()))) {
      TroopObserversHelper.d(this.a).t(false);
    }
  }
  
  protected void b(String paramString)
  {
    if ((TroopObserversHelper.b(this.a).b.equals(paramString)) && (!TroopObserversHelper.d(this.a).aY)) {
      TroopObserversHelper.d(this.a).f(1);
    }
  }
  
  protected void c(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(TroopObserversHelper.b(this.a).b))) {
      TroopObserversHelper.d(this.a).D();
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopObserversHelper", 2, String.format("onAddTroopSuccess, troopUin: %s", new Object[] { paramString }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopObserversHelper.7
 * JD-Core Version:    0.7.0.1
 */