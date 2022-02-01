import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.asyncdb.BaseCache;
import com.tencent.mobileqq.app.asyncdb.BaseCacheManager;

public class aohg
  extends BaseCacheManager
{
  private QQAppInterface a;
  
  public aohg(QQAppInterface paramQQAppInterface)
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
      return new aohj(this.a, this.dbDelayManager);
    }
    return new aohl(this.a, this.dbDelayManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aohg
 * JD-Core Version:    0.7.0.1
 */