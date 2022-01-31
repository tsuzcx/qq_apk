import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.troop.aioapp.FullListGroupAppsDbHelper.1;
import com.tencent.mobileqq.troop.aioapp.data.FullListGroupAppEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class azjt
{
  private final QQAppInterface a;
  
  azjt(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private void b(FullListGroupAppEntity paramFullListGroupAppEntity)
  {
    if ((paramFullListGroupAppEntity == null) || (azjx.a(paramFullListGroupAppEntity.troopAIOAppInfos)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FullListGroupAppsDbHelper", 2, "saveToDb: invoked. empty full list, no need to persist");
      }
      return;
    }
    aukp localaukp = this.a.getEntityManagerFactory().createEntityManager();
    paramFullListGroupAppEntity.setStatus(1000);
    localaukp.a(FullListGroupAppEntity.class.getSimpleName(), null, null);
    localaukp.b(paramFullListGroupAppEntity);
    localaukp.a();
  }
  
  public void a()
  {
    aukp localaukp = this.a.getEntityManagerFactory().createEntityManager();
    azjs localazjs = azjs.a(this.a);
    Object localObject = localaukp.a(FullListGroupAppEntity.class);
    if (!azjx.a((Collection)localObject))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        FullListGroupAppEntity localFullListGroupAppEntity = (FullListGroupAppEntity)((Iterator)localObject).next();
        if (!azjx.a(localFullListGroupAppEntity.troopAIOAppInfos))
        {
          localazjs.a = localFullListGroupAppEntity.troopAIOAppInfos;
          QLog.i("FullListGroupAppsDbHelper", 1, "buildFullListFromDb: invoked. " + localazjs.a);
          return;
        }
      }
    }
    localaukp.a();
  }
  
  void a(FullListGroupAppEntity paramFullListGroupAppEntity)
  {
    ThreadManagerV2.excute(new FullListGroupAppsDbHelper.1(this, paramFullListGroupAppEntity), 32, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azjt
 * JD-Core Version:    0.7.0.1
 */