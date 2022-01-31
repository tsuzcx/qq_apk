import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public abstract class amgr
{
  protected amgv a;
  public QQAppInterface a;
  protected Class<? extends awge> a;
  protected ArrayList<amgu> a;
  public ConcurrentHashMap<String, awge> a;
  
  public amgr(QQAppInterface paramQQAppInterface, amgv paramamgv, Class<? extends awge> paramClass)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Amgv = paramamgv;
    this.jdField_a_of_type_JavaLangClass = paramClass;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public awge a(String paramString)
  {
    return (awge)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  protected String a(awge paramawge)
  {
    return Long.toString(paramawge.getId());
  }
  
  protected abstract void a();
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((amgu)localIterator.next()).a(paramInt);
    }
  }
  
  public void a(awge paramawge)
  {
    a(paramawge, 0, null);
  }
  
  public abstract void a(awge paramawge, int paramInt, amgx paramamgx);
  
  protected abstract void b();
  
  public void b(awge paramawge)
  {
    b(paramawge, 0, null);
  }
  
  public void b(awge paramawge, int paramInt, amgx paramamgx)
  {
    String str = a(paramawge);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramawge);
    if (paramawge.getStatus() == 1000)
    {
      this.jdField_a_of_type_Amgv.a(paramawge, 0, paramInt, paramamgx);
      return;
    }
    this.jdField_a_of_type_Amgv.a(paramawge, 1, paramInt, paramamgx);
  }
  
  public void c(awge paramawge)
  {
    c(paramawge, 0, null);
  }
  
  public void c(awge paramawge, int paramInt, amgx paramamgx)
  {
    String str = a(paramawge);
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
    }
    this.jdField_a_of_type_Amgv.a(paramawge, 2, paramInt, paramamgx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amgr
 * JD-Core Version:    0.7.0.1
 */