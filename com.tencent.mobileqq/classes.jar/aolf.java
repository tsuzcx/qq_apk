import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.asyncdb.BaseCache;
import com.tencent.mobileqq.app.asyncdb.BaseCacheManager;

public class aolf
  extends BaseCacheManager
{
  private QQAppInterface a;
  
  public aolf(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  public BaseCache createCacheByName(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 2: 
      return new aoli(this.a, this.dbDelayManager);
    }
    return new aolk(this.a, this.dbDelayManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aolf
 * JD-Core Version:    0.7.0.1
 */