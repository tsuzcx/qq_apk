import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public abstract class amch
  extends amcc
{
  public amch(QQAppInterface paramQQAppInterface, amcg paramamcg, Class<? extends awbv> paramClass)
  {
    super(paramQQAppInterface, paramamcg, paramClass);
  }
  
  protected void a()
  {
    awbw localawbw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject = localawbw.a(this.jdField_a_of_type_JavaLangClass, false, null, null, null, null, null, null);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        awbv localawbv = (awbv)((Iterator)localObject).next();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(a(localawbv), localawbv);
      }
    }
    localawbw.a();
  }
  
  public void a(awbv paramawbv, int paramInt, amci paramamci)
  {
    String str = a(paramawbv);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramawbv);
    if (paramawbv.getStatus() == 1000)
    {
      this.a.a(paramawbv, 0, paramInt, paramamci);
      return;
    }
    this.a.a(paramawbv, 1, paramInt, paramamci);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amch
 * JD-Core Version:    0.7.0.1
 */