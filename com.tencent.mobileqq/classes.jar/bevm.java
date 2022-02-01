import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;

class bevm
  extends beud
{
  bevm(bevl parambevl, QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected void a(long paramLong)
  {
    for (;;)
    {
      try
      {
        if ((paramLong != bevl.a(this.a)) || (bevl.a(this.a).hasDestory)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AppShortcutBarProcessor", 2, "onShortcutBarItemUpdated.");
        }
        TroopInfo localTroopInfo = ((TroopManager)bevl.a(this.a).app.getManager(52)).b(bevl.a(this.a));
        if (localTroopInfo != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AppShortcutBarProcessor", 2, "onShortcutBarItemUpdated. getTroopAIOShortCutBar.");
          }
          Object localObject1 = (beua)bevl.a(this.a).app.getManager(355);
          if (localObject1 != null)
          {
            localObject1 = ((beua)localObject1).a(Long.valueOf(bevl.a(this.a)));
            if (localObject1 != null)
            {
              ((betz)localObject1).d(0);
              ((betz)localObject1).a(0L);
            }
            localObject1 = (bety)bevl.a(this.a).app.getBusinessHandler(171);
            if (localObject1 == null) {
              break;
            }
            ((bety)localObject1).a(bevl.a(this.a), (int)localTroopInfo.dwGroupClassExt, null);
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
        break label377;
      }
      QLog.d("AppShortcutBarProcessor", 2, "onGetAIOShortcutBarInfo Fail");
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AppShortcutBarProcessor", 1, localException.getMessage());
      return;
    }
    betz localbetz;
    int i;
    if ((paramLong == bevl.a(this.a)) && (!bevl.a(this.a).hasDestory))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarProcessor", 2, "onGetAIOShortcutBarInfo.");
      }
      if ((bevl.a(this.a) != null) && (bevl.a(this.a).app != null))
      {
        TroopInfo localTroopInfo = ((TroopManager)bevl.a(this.a).app.getManager(52)).b(bevl.a(this.a));
        if (localTroopInfo == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AppShortcutBarProcessor", 2, "updateAppShortcutPanel. troopInfo is null.");
          }
        }
        else
        {
          betw localbetw = (betw)apub.a().a(590);
          if ((localbetw != null) && (localTroopInfo != null) && ((localbetw.a((int)localTroopInfo.dwGroupClassExt)) || (localbetw.b((int)localTroopInfo.dwGroupClassExt))))
          {
            beua localbeua = (beua)bevl.a(this.a).app.getManager(355);
            if (localbeua != null) {
              localbetz = localbeua.a(Long.valueOf(bevl.a(this.a)));
            }
            if (localTroopInfo.isAdmin()) {
              break label378;
            }
            if (!localTroopInfo.isTroopOwner(bevl.a(this.a).app.getCurrentAccountUin())) {
              break label384;
            }
            break label378;
            if (i != 0) {
              break label395;
            }
            if (localbetw.a != betw.c) {
              break label390;
            }
            paramBoolean = true;
          }
        }
      }
    }
    for (;;)
    {
      if ((localbetz != null) && (((i == 0) && (localbetz.a() == 0)) || ((i != 0) && (localbetz.b() == 0))))
      {
        bevl.a(this.a).a(0, bevl.a(this.a, localbetz.a()), paramBoolean);
        return;
      }
      bevl.a(this.a).a(0, null, paramBoolean);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("AppShortcutBarProcessor", 2, "onGetAIOShortcutBarInfo. Noting To Do!");
      }
      label377:
      return;
      label378:
      i = 1;
      break;
      label384:
      i = 0;
      break;
      label390:
      paramBoolean = false;
      continue;
      label395:
      paramBoolean = true;
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if ((!paramBoolean) || (bevl.a(this.a) == null) || (bevl.a(this.a).hasDestory)) {
      return;
    }
    Object localObject = (beua)bevl.a(this.a).app.getManager(355);
    if ((localObject != null) && (((beua)localObject).a()))
    {
      ((beua)localObject).a(false);
      localObject = ((beua)localObject).a(Long.valueOf(bevl.a(this.a)));
      if (localObject != null)
      {
        ((betz)localObject).c(0);
        ((betz)localObject).a(0L);
        ((betz)localObject).d(0);
      }
    }
    bevl.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bevm
 * JD-Core Version:    0.7.0.1
 */