import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public abstract class amgw
  extends amgr
{
  public amgw(QQAppInterface paramQQAppInterface, amgv paramamgv, Class<? extends awge> paramClass)
  {
    super(paramQQAppInterface, paramamgv, paramClass);
  }
  
  protected void a()
  {
    awgf localawgf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject = localawgf.a(this.jdField_a_of_type_JavaLangClass, false, null, null, null, null, null, null);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        awge localawge = (awge)((Iterator)localObject).next();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(a(localawge), localawge);
      }
    }
    localawgf.a();
  }
  
  public void a(awge paramawge, int paramInt, amgx paramamgx)
  {
    String str = a(paramawge);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramawge);
    if (paramawge.getStatus() == 1000)
    {
      this.a.a(paramawge, 0, paramInt, paramamgx);
      return;
    }
    this.a.a(paramawge, 1, paramInt, paramamgx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amgw
 * JD-Core Version:    0.7.0.1
 */