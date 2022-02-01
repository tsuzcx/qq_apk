import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.ShortVideoUpInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import mqq.manager.Manager;

public class anba
  implements Manager
{
  private EntityManager a;
  
  public anba(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  public ShortVideoUpInfo a(String paramString)
  {
    return (ShortVideoUpInfo)this.a.find(ShortVideoUpInfo.class, paramString);
  }
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    paramString = a(paramString);
    if (paramString != null) {
      bool = this.a.remove(paramString);
    }
    return bool;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anba
 * JD-Core Version:    0.7.0.1
 */