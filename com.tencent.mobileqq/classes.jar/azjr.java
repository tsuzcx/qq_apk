import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.troop.aioapp.FullListGroupAppsDbHelper.1;
import com.tencent.mobileqq.troop.aioapp.data.FullListGroupAppEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class azjr
{
  private final QQAppInterface a;
  
  azjr(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private void b(FullListGroupAppEntity paramFullListGroupAppEntity)
  {
    if ((paramFullListGroupAppEntity == null) || (azjv.a(paramFullListGroupAppEntity.troopAIOAppInfos)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FullListGroupAppsDbHelper", 2, "saveToDb: invoked. empty full list, no need to persist");
      }
      return;
    }
    aukn localaukn = this.a.getEntityManagerFactory().createEntityManager();
    paramFullListGroupAppEntity.setStatus(1000);
    localaukn.a(FullListGroupAppEntity.class.getSimpleName(), null, null);
    localaukn.b(paramFullListGroupAppEntity);
    localaukn.a();
  }
  
  public void a()
  {
    aukn localaukn = this.a.getEntityManagerFactory().createEntityManager();
    azjq localazjq = azjq.a(this.a);
    Object localObject = localaukn.a(FullListGroupAppEntity.class);
    if (!azjv.a((Collection)localObject))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        FullListGroupAppEntity localFullListGroupAppEntity = (FullListGroupAppEntity)((Iterator)localObject).next();
        if (!azjv.a(localFullListGroupAppEntity.troopAIOAppInfos))
        {
          localazjq.a = localFullListGroupAppEntity.troopAIOAppInfos;
          QLog.i("FullListGroupAppsDbHelper", 1, "buildFullListFromDb: invoked. " + localazjq.a);
          return;
        }
      }
    }
    localaukn.a();
  }
  
  void a(FullListGroupAppEntity paramFullListGroupAppEntity)
  {
    ThreadManagerV2.excute(new FullListGroupAppsDbHelper.1(this, paramFullListGroupAppEntity), 32, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azjr
 * JD-Core Version:    0.7.0.1
 */