import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;

class bgma
  extends bgku
{
  bgma(bglz parambglz, QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected void a(long paramLong)
  {
    for (;;)
    {
      try
      {
        if ((paramLong != bglz.a(this.a)) || (bglz.a(this.a).M)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AppShortcutBarProcessor", 2, "onShortcutBarItemUpdated.");
        }
        TroopInfo localTroopInfo = ((TroopManager)bglz.a(this.a).a.getManager(52)).b(bglz.a(this.a));
        if (localTroopInfo != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AppShortcutBarProcessor", 2, "onShortcutBarItemUpdated. getTroopAIOShortCutBar.");
          }
          Object localObject1 = (bgks)bglz.a(this.a).a.getManager(355);
          if (localObject1 != null)
          {
            localObject1 = ((bgks)localObject1).a(Long.valueOf(bglz.a(this.a)));
            if (localObject1 != null)
            {
              ((bgkr)localObject1).d(0);
              ((bgkr)localObject1).a(0L);
            }
            localObject1 = (bgkq)bglz.a(this.a).a.a(171);
            if (localObject1 == null) {
              break;
            }
            ((bgkq)localObject1).a(bglz.a(this.a), (int)localTroopInfo.dwGroupClassExt);
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
    bgkr localbgkr;
    int i;
    if ((paramLong == bglz.a(this.a)) && (!bglz.a(this.a).M))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarProcessor", 2, "onGetAIOShortcutBarInfo.");
      }
      if ((bglz.a(this.a) != null) && (bglz.a(this.a).a != null))
      {
        TroopInfo localTroopInfo = ((TroopManager)bglz.a(this.a).a.getManager(52)).b(bglz.a(this.a));
        if (localTroopInfo == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AppShortcutBarProcessor", 2, "updateAppShortcutPanel. troopInfo is null.");
          }
        }
        else
        {
          bgko localbgko = (bgko)aran.a().a(590);
          if ((localbgko != null) && (localTroopInfo != null) && ((localbgko.a((int)localTroopInfo.dwGroupClassExt)) || (localbgko.b((int)localTroopInfo.dwGroupClassExt))))
          {
            bgks localbgks = (bgks)bglz.a(this.a).a.getManager(355);
            if (localbgks != null) {
              localbgkr = localbgks.a(Long.valueOf(bglz.a(this.a)));
            }
            if (localTroopInfo.isAdmin()) {
              break label373;
            }
            if (!localTroopInfo.isTroopOwner(bglz.a(this.a).a.getCurrentAccountUin())) {
              break label379;
            }
            break label373;
            if (i != 0) {
              break label390;
            }
            if (localbgko.a != bgko.c) {
              break label385;
            }
            paramBoolean = true;
          }
        }
      }
    }
    for (;;)
    {
      if (((i == 0) && (localbgkr.a() == 0)) || ((i != 0) && (localbgkr.b() == 0)))
      {
        bglz.a(this.a).a(0, bglz.a(this.a, localbgkr.a()), paramBoolean);
        return;
      }
      bglz.a(this.a).a(0, null, paramBoolean);
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
    if ((!paramBoolean) || (bglz.a(this.a) == null) || (bglz.a(this.a).M)) {
      return;
    }
    Object localObject = (bgks)bglz.a(this.a).a.getManager(355);
    if ((localObject != null) && (((bgks)localObject).a()))
    {
      ((bgks)localObject).a(false);
      localObject = ((bgks)localObject).a(Long.valueOf(bglz.a(this.a)));
      if (localObject != null)
      {
        ((bgkr)localObject).c(0);
        ((bgkr)localObject).a(0L);
        ((bgkr)localObject).d(0);
      }
    }
    bglz.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgma
 * JD-Core Version:    0.7.0.1
 */