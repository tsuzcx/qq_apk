import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;

class bflz
  extends bfkt
{
  bflz(bfly parambfly, QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected void a(long paramLong)
  {
    for (;;)
    {
      try
      {
        if ((paramLong != bfly.a(this.a)) || (bfly.a(this.a).M)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AppShortcutBarProcessor", 2, "onShortcutBarItemUpdated.");
        }
        TroopInfo localTroopInfo = ((TroopManager)bfly.a(this.a).a.getManager(52)).b(bfly.a(this.a));
        if (localTroopInfo != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AppShortcutBarProcessor", 2, "onShortcutBarItemUpdated. getTroopAIOShortCutBar.");
          }
          Object localObject1 = (bfkr)bfly.a(this.a).a.getManager(355);
          if (localObject1 != null)
          {
            localObject1 = ((bfkr)localObject1).a(Long.valueOf(bfly.a(this.a)));
            if (localObject1 != null)
            {
              ((bfkq)localObject1).d(0);
              ((bfkq)localObject1).a(0L);
            }
            localObject1 = (bfkp)bfly.a(this.a).a.a(171);
            if (localObject1 == null) {
              break;
            }
            ((bfkp)localObject1).a(bfly.a(this.a), (int)localTroopInfo.dwGroupClassExt);
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("AppShortcutBarProcessor", 2, "onShortcutBarItemUpdated. TroopInfo is null!");
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("AppShortcutBarProcessor", 1, localException.getMessage());
        return;
      }
      Object localObject2 = null;
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean)
  {
    Object localObject = null;
    if (!paramBoolean) {}
    try
    {
      if (!QLog.isColorLevel()) {
        break label372;
      }
      QLog.d("AppShortcutBarProcessor", 2, "onGetAIOShortcutBarInfo Fail");
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AppShortcutBarProcessor", 1, localException.getMessage());
      return;
    }
    bfkq localbfkq;
    int i;
    if ((paramLong == bfly.a(this.a)) && (!bfly.a(this.a).M))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarProcessor", 2, "onGetAIOShortcutBarInfo.");
      }
      if ((bfly.a(this.a) != null) && (bfly.a(this.a).a != null))
      {
        TroopInfo localTroopInfo = ((TroopManager)bfly.a(this.a).a.getManager(52)).b(bfly.a(this.a));
        if (localTroopInfo == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AppShortcutBarProcessor", 2, "updateAppShortcutPanel. troopInfo is null.");
          }
        }
        else
        {
          bfkn localbfkn = (bfkn)aqlk.a().a(590);
          if ((localbfkn != null) && (localTroopInfo != null) && ((localbfkn.a((int)localTroopInfo.dwGroupClassExt)) || (localbfkn.b((int)localTroopInfo.dwGroupClassExt))))
          {
            bfkr localbfkr = (bfkr)bfly.a(this.a).a.getManager(355);
            if (localbfkr != null) {
              localbfkq = localbfkr.a(Long.valueOf(bfly.a(this.a)));
            }
            if (localTroopInfo.isAdmin()) {
              break label373;
            }
            if (!localTroopInfo.isTroopOwner(bfly.a(this.a).a.getCurrentAccountUin())) {
              break label379;
            }
            break label373;
            if (i != 0) {
              break label390;
            }
            if (localbfkn.a != bfkn.c) {
              break label385;
            }
            paramBoolean = true;
          }
        }
      }
    }
    for (;;)
    {
      if (((i == 0) && (localbfkq.a() == 0)) || ((i != 0) && (localbfkq.b() == 0)))
      {
        bfly.a(this.a).a(0, bfly.a(this.a, localbfkq.a()), paramBoolean);
        return;
      }
      bfly.a(this.a).a(0, null, paramBoolean);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("AppShortcutBarProcessor", 2, "onGetAIOShortcutBarInfo. Noting To Do!");
      }
      label372:
      return;
      label373:
      i = 1;
      break;
      label379:
      i = 0;
      break;
      label385:
      paramBoolean = false;
      continue;
      label390:
      paramBoolean = true;
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if ((!paramBoolean) || (bfly.a(this.a) == null) || (bfly.a(this.a).M)) {
      return;
    }
    Object localObject = (bfkr)bfly.a(this.a).a.getManager(355);
    if ((localObject != null) && (((bfkr)localObject).a()))
    {
      ((bfkr)localObject).a(false);
      localObject = ((bfkr)localObject).a(Long.valueOf(bfly.a(this.a)));
      if (localObject != null)
      {
        ((bfkq)localObject).c(0);
        ((bfkq)localObject).a(0L);
        ((bfkq)localObject).d(0);
      }
    }
    bfly.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bflz
 * JD-Core Version:    0.7.0.1
 */