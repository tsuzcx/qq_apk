import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.troop.aioapp.FullListGroupAppsDbHelper.1;
import com.tencent.mobileqq.troop.aioapp.data.FullListGroupAppEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ayjb
{
  private final QQAppInterface a;
  
  ayjb(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private void b(FullListGroupAppEntity paramFullListGroupAppEntity)
  {
    if ((paramFullListGroupAppEntity == null) || (ayjf.a(paramFullListGroupAppEntity.troopAIOAppInfos)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FullListGroupAppsDbHelper", 2, "saveToDb: invoked. empty full list, no need to persist");
      }
      return;
    }
    atmp localatmp = this.a.getEntityManagerFactory().createEntityManager();
    paramFullListGroupAppEntity.setStatus(1000);
    localatmp.a(FullListGroupAppEntity.class.getSimpleName(), null, null);
    localatmp.b(paramFullListGroupAppEntity);
    localatmp.a();
  }
  
  public void a()
  {
    atmp localatmp = this.a.getEntityManagerFactory().createEntityManager();
    ayja localayja = ayja.a(this.a);
    Object localObject = localatmp.a(FullListGroupAppEntity.class);
    if (!ayjf.a((Collection)localObject))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        FullListGroupAppEntity localFullListGroupAppEntity = (FullListGroupAppEntity)((Iterator)localObject).next();
        if (!ayjf.a(localFullListGroupAppEntity.troopAIOAppInfos))
        {
          localayja.a = localFullListGroupAppEntity.troopAIOAppInfos;
          QLog.i("FullListGroupAppsDbHelper", 1, "buildFullListFromDb: invoked. " + localayja.a);
          return;
        }
      }
    }
    localatmp.a();
  }
  
  void a(FullListGroupAppEntity paramFullListGroupAppEntity)
  {
    ThreadManagerV2.excute(new FullListGroupAppsDbHelper.1(this, paramFullListGroupAppEntity), 32, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayjb
 * JD-Core Version:    0.7.0.1
 */