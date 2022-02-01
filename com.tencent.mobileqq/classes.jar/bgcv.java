import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;

class bgcv
  extends bgbj
{
  bgcv(bgcu parambgcu, QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected void a(long paramLong)
  {
    for (;;)
    {
      try
      {
        if ((paramLong != bgcu.a(this.a)) || (bgcu.a(this.a).hasDestory)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AppShortcutBarProcessor", 2, "onShortcutBarItemUpdated.");
        }
        TroopInfo localTroopInfo = ((TroopManager)bgcu.a(this.a).app.getManager(QQManagerFactory.TROOP_MANAGER)).b(bgcu.a(this.a));
        if (localTroopInfo != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AppShortcutBarProcessor", 2, "onShortcutBarItemUpdated. getTroopAIOShortCutBar.");
          }
          Object localObject1 = (bgbg)bgcu.a(this.a).app.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER);
          if (localObject1 != null)
          {
            localObject1 = ((bgbg)localObject1).a(Long.valueOf(bgcu.a(this.a)));
            if (localObject1 != null)
            {
              ((bgbf)localObject1).d(0);
              ((bgbf)localObject1).a(0L);
            }
            localObject1 = (bgbe)bgcu.a(this.a).app.getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE);
            if (localObject1 == null) {
              break;
            }
            ((bgbe)localObject1).a(bgcu.a(this.a), (int)localTroopInfo.dwGroupClassExt, null);
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
        break label378;
      }
      QLog.d("AppShortcutBarProcessor", 2, "onGetAIOShortcutBarInfo Fail");
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AppShortcutBarProcessor", 1, localException.getMessage());
      return;
    }
    bgbf localbgbf;
    int i;
    if ((paramLong == bgcu.a(this.a)) && (!bgcu.a(this.a).hasDestory))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarProcessor", 2, "onGetAIOShortcutBarInfo.");
      }
      if ((bgcu.a(this.a) != null) && (bgcu.a(this.a).app != null))
      {
        TroopInfo localTroopInfo = ((TroopManager)bgcu.a(this.a).app.getManager(QQManagerFactory.TROOP_MANAGER)).b(bgcu.a(this.a));
        if (localTroopInfo == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AppShortcutBarProcessor", 2, "updateAppShortcutPanel. troopInfo is null.");
          }
        }
        else
        {
          bgbc localbgbc = (bgbc)aqxe.a().a(590);
          if ((localbgbc != null) && (localTroopInfo != null) && ((localbgbc.a((int)localTroopInfo.dwGroupClassExt)) || (localbgbc.b((int)localTroopInfo.dwGroupClassExt))))
          {
            bgbg localbgbg = (bgbg)bgcu.a(this.a).app.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER);
            if (localbgbg != null) {
              localbgbf = localbgbg.a(Long.valueOf(bgcu.a(this.a)));
            }
            if (localTroopInfo.isAdmin()) {
              break label379;
            }
            if (!localTroopInfo.isTroopOwner(bgcu.a(this.a).app.getCurrentAccountUin())) {
              break label385;
            }
            break label379;
            if (i != 0) {
              break label396;
            }
            if (localbgbc.a != bgbc.c) {
              break label391;
            }
            paramBoolean = true;
          }
        }
      }
    }
    for (;;)
    {
      if ((localbgbf != null) && (((i == 0) && (localbgbf.a() == 0)) || ((i != 0) && (localbgbf.b() == 0))))
      {
        bgcu.a(this.a).a(0, bgcu.a(this.a, localbgbf.a()), paramBoolean);
        return;
      }
      bgcu.a(this.a).a(0, null, paramBoolean);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("AppShortcutBarProcessor", 2, "onGetAIOShortcutBarInfo. Noting To Do!");
      }
      label378:
      return;
      label379:
      i = 1;
      break;
      label385:
      i = 0;
      break;
      label391:
      paramBoolean = false;
      continue;
      label396:
      paramBoolean = true;
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if ((!paramBoolean) || (bgcu.a(this.a) == null) || (bgcu.a(this.a).hasDestory)) {
      return;
    }
    Object localObject = (bgbg)bgcu.a(this.a).app.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER);
    if ((localObject != null) && (((bgbg)localObject).a()))
    {
      ((bgbg)localObject).a(false);
      localObject = ((bgbg)localObject).a(Long.valueOf(bgcu.a(this.a)));
      if (localObject != null)
      {
        ((bgbf)localObject).c(0);
        ((bgbf)localObject).a(0L);
        ((bgbf)localObject).d(0);
      }
    }
    bgcu.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgcv
 * JD-Core Version:    0.7.0.1
 */