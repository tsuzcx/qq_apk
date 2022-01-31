import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.troop.aioapp.GrayGroupAppsDbHelper.1;
import com.tencent.mobileqq.troop.aioapp.data.GrayGroupAppEntity;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class bbid
{
  private final QQAppInterface a;
  
  bbid(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private void a(boolean paramBoolean)
  {
    awbw localawbw = this.a.getEntityManagerFactory().createEntityManager();
    bbib localbbib = bbib.a(this.a);
    Object localObject = localawbw.a(GrayGroupAppEntity.class);
    if (!bbig.a((Collection)localObject))
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
        localbbib.a.put(Long.valueOf(localGrayGroupAppEntity.groupUin), localGrayGroupAppEntity);
      }
    }
    localawbw.a();
  }
  
  private void b(GrayGroupAppEntity paramGrayGroupAppEntity)
  {
    awbw localawbw = this.a.getEntityManagerFactory().createEntityManager();
    paramGrayGroupAppEntity.setStatus(1000);
    localawbw.b(paramGrayGroupAppEntity);
    localawbw.a();
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
  
  void c()
  {
    this.a.getEntityManagerFactory().createEntityManager().a(GrayGroupAppEntity.class.getSimpleName(), null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbid
 * JD-Core Version:    0.7.0.1
 */