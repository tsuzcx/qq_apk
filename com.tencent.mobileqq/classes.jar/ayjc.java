import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.troop.aioapp.GrayGroupAppsDbHelper.1;
import com.tencent.mobileqq.troop.aioapp.data.GrayGroupAppEntity;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ayjc
{
  private final QQAppInterface a;
  
  ayjc(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private void a(boolean paramBoolean)
  {
    atmp localatmp = this.a.getEntityManagerFactory().createEntityManager();
    ayja localayja = ayja.a(this.a);
    Object localObject = localatmp.a(GrayGroupAppEntity.class);
    if (!ayjf.a((Collection)localObject))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        GrayGroupAppEntity localGrayGroupAppEntity = (GrayGroupAppEntity)((Iterator)localObject).next();
        if (paramBoolean)
        {
          localGrayGroupAppEntity.updatedTimestamp = 0L;
          b(localGrayGroupAppEntity);
        }
        localayja.a.put(Long.valueOf(localGrayGroupAppEntity.groupUin), localGrayGroupAppEntity);
      }
    }
    localatmp.a();
  }
  
  private void b(GrayGroupAppEntity paramGrayGroupAppEntity)
  {
    atmp localatmp = this.a.getEntityManagerFactory().createEntityManager();
    paramGrayGroupAppEntity.setStatus(1000);
    localatmp.b(paramGrayGroupAppEntity);
    localatmp.a();
  }
  
  public void a()
  {
    a(false);
  }
  
  void a(GrayGroupAppEntity paramGrayGroupAppEntity)
  {
    ThreadManagerV2.excute(new GrayGroupAppsDbHelper.1(this, paramGrayGroupAppEntity), 32, null, false);
  }
  
  public void b()
  {
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayjc
 * JD-Core Version:    0.7.0.1
 */