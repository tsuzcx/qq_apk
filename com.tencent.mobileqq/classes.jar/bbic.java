import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.troop.aioapp.FullListGroupAppsDbHelper.1;
import com.tencent.mobileqq.troop.aioapp.data.FullListGroupAppEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class bbic
{
  private final QQAppInterface a;
  
  bbic(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private void b(FullListGroupAppEntity paramFullListGroupAppEntity)
  {
    if ((paramFullListGroupAppEntity == null) || (bbig.a(paramFullListGroupAppEntity.troopAIOAppInfos)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FullListGroupAppsDbHelper", 2, "saveToDb: invoked. empty full list, no need to persist");
      }
      return;
    }
    awbw localawbw = this.a.getEntityManagerFactory().createEntityManager();
    paramFullListGroupAppEntity.setStatus(1000);
    localawbw.a(FullListGroupAppEntity.class.getSimpleName(), null, null);
    localawbw.b(paramFullListGroupAppEntity);
    localawbw.a();
  }
  
  public void a()
  {
    awbw localawbw = this.a.getEntityManagerFactory().createEntityManager();
    bbib localbbib = bbib.a(this.a);
    Object localObject = localawbw.a(FullListGroupAppEntity.class);
    if (!bbig.a((Collection)localObject))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        FullListGroupAppEntity localFullListGroupAppEntity = (FullListGroupAppEntity)((Iterator)localObject).next();
        if (!bbig.a(localFullListGroupAppEntity.troopAIOAppInfos))
        {
          localbbib.a = localFullListGroupAppEntity.troopAIOAppInfos;
          QLog.i("FullListGroupAppsDbHelper", 1, "buildFullListFromDb: invoked. " + localbbib.a);
          return;
        }
      }
    }
    localawbw.a();
  }
  
  void a(FullListGroupAppEntity paramFullListGroupAppEntity)
  {
    ThreadManagerV2.excute(new FullListGroupAppsDbHelper.1(this, paramFullListGroupAppEntity), 32, null, false);
  }
  
  void b()
  {
    this.a.getEntityManagerFactory().createEntityManager().a(FullListGroupAppEntity.class.getSimpleName(), null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbic
 * JD-Core Version:    0.7.0.1
 */