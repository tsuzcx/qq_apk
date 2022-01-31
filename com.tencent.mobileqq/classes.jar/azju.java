import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.troop.aioapp.GrayGroupAppsDbHelper.1;
import com.tencent.mobileqq.troop.aioapp.data.GrayGroupAppEntity;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class azju
{
  private final QQAppInterface a;
  
  azju(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private void a(boolean paramBoolean)
  {
    aukp localaukp = this.a.getEntityManagerFactory().createEntityManager();
    azjs localazjs = azjs.a(this.a);
    Object localObject = localaukp.a(GrayGroupAppEntity.class);
    if (!azjx.a((Collection)localObject))
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
        localazjs.a.put(Long.valueOf(localGrayGroupAppEntity.groupUin), localGrayGroupAppEntity);
      }
    }
    localaukp.a();
  }
  
  private void b(GrayGroupAppEntity paramGrayGroupAppEntity)
  {
    aukp localaukp = this.a.getEntityManagerFactory().createEntityManager();
    paramGrayGroupAppEntity.setStatus(1000);
    localaukp.b(paramGrayGroupAppEntity);
    localaukp.a();
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
 * Qualified Name:     azju
 * JD-Core Version:    0.7.0.1
 */