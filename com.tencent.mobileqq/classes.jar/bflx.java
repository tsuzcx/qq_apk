import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.aioapp.FullListGroupAppsDbHelper.1;
import com.tencent.mobileqq.troop.aioapp.data.FullListGroupAppEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class bflx
{
  private final QQAppInterface a;
  
  bflx(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private void b(FullListGroupAppEntity paramFullListGroupAppEntity)
  {
    if ((paramFullListGroupAppEntity == null) || (bfmb.a(paramFullListGroupAppEntity.troopAIOAppInfos)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FullListGroupAppsDbHelper", 2, "saveToDb: invoked. empty full list, no need to persist");
      }
      return;
    }
    EntityManager localEntityManager = this.a.a().createEntityManager();
    paramFullListGroupAppEntity.setStatus(1000);
    localEntityManager.delete(FullListGroupAppEntity.class.getSimpleName(), null, null);
    localEntityManager.persistOrReplace(paramFullListGroupAppEntity);
    localEntityManager.close();
  }
  
  public void a()
  {
    EntityManager localEntityManager = this.a.a().createEntityManager();
    bflw localbflw = bflw.a(this.a);
    Object localObject = localEntityManager.query(FullListGroupAppEntity.class);
    if (!bfmb.a((Collection)localObject))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        FullListGroupAppEntity localFullListGroupAppEntity = (FullListGroupAppEntity)((Iterator)localObject).next();
        if (!bfmb.a(localFullListGroupAppEntity.troopAIOAppInfos))
        {
          localbflw.a = localFullListGroupAppEntity.troopAIOAppInfos;
          QLog.i("FullListGroupAppsDbHelper", 1, "buildFullListFromDb: invoked. " + localbflw.a);
          return;
        }
      }
    }
    localEntityManager.close();
  }
  
  void a(FullListGroupAppEntity paramFullListGroupAppEntity)
  {
    ThreadManagerV2.excute(new FullListGroupAppsDbHelper.1(this, paramFullListGroupAppEntity), 32, null, false);
  }
  
  void b()
  {
    this.a.a().createEntityManager().delete(FullListGroupAppEntity.class.getSimpleName(), null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bflx
 * JD-Core Version:    0.7.0.1
 */