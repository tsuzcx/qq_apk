import java.util.Comparator;
import java.util.List;

public class anhp<T>
{
  private int jdField_a_of_type_Int;
  private final anhq<T> jdField_a_of_type_Anhq;
  private final anhr jdField_a_of_type_Anhr;
  private final Comparator<T> jdField_a_of_type_JavaUtilComparator;
  
  public anhp(Comparator<T> paramComparator, anhr<T> paramanhr)
  {
    this.jdField_a_of_type_Anhr = paramanhr;
    this.jdField_a_of_type_Anhq = new anhq();
    this.jdField_a_of_type_JavaUtilComparator = paramComparator;
  }
  
  private void a(long paramLong, List<T> paramList, anhq<T> paramanhq)
  {
    if ((anfe.a().a().a()) && ((paramList == null) || (paramList.isEmpty())) && (!a()) && ((paramanhq.jdField_a_of_type_JavaLangObject instanceof anfv)))
    {
      paramList = (anfv)paramanhq.jdField_a_of_type_JavaLangObject;
      long l = Math.abs(paramList.d() - paramLong);
      if (l > 60000L) {
        anhx.d("DanmakuDataSource", "Danmaku upload to screen fail, deltaTime = " + l + " , curTime = " + paramLong + ", curDanmaku = " + paramList);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public T a()
  {
    return this.jdField_a_of_type_Anhq.jdField_a_of_type_Anhq.jdField_a_of_type_JavaLangObject;
  }
  
  public List<T> a(long paramLong, List<T> paramList, int paramInt)
  {
    anhq localanhq = this.jdField_a_of_type_Anhq.jdField_a_of_type_Anhq;
    int j;
    for (int i = 0; (i < paramInt) && (localanhq != this.jdField_a_of_type_Anhq) && (this.jdField_a_of_type_Anhr.a(localanhq.jdField_a_of_type_JavaLangObject, paramLong) <= 0); i = j)
    {
      j = i;
      if (paramList != null)
      {
        paramList.add(localanhq.jdField_a_of_type_JavaLangObject);
        j = i + 1;
      }
      this.jdField_a_of_type_Int -= 1;
      localanhq = localanhq.jdField_a_of_type_Anhq;
    }
    a(paramLong, paramList, localanhq);
    this.jdField_a_of_type_Anhq.jdField_a_of_type_Anhq = localanhq;
    localanhq.b = this.jdField_a_of_type_Anhq;
    return paramList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Anhq.jdField_a_of_type_Anhq = this.jdField_a_of_type_Anhq;
    this.jdField_a_of_type_Anhq.b = this.jdField_a_of_type_Anhq;
    this.jdField_a_of_type_Int = 0;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Anhq.jdField_a_of_type_Anhq == this.jdField_a_of_type_Anhq;
  }
  
  public boolean a(T paramT)
  {
    if (paramT == null) {
      return false;
    }
    for (anhq localanhq = this.jdField_a_of_type_Anhq.b; (localanhq != this.jdField_a_of_type_Anhq) && (this.jdField_a_of_type_JavaUtilComparator.compare(localanhq.jdField_a_of_type_JavaLangObject, paramT) > 0); localanhq = localanhq.b) {}
    if (paramT.equals(localanhq.jdField_a_of_type_JavaLangObject)) {
      return false;
    }
    paramT = new anhq(paramT, localanhq.jdField_a_of_type_Anhq, localanhq);
    localanhq.jdField_a_of_type_Anhq.b = paramT;
    localanhq.jdField_a_of_type_Anhq = paramT;
    this.jdField_a_of_type_Int += 1;
    return true;
  }
  
  public T b()
  {
    anhq localanhq = this.jdField_a_of_type_Anhq.b;
    if (localanhq != this.jdField_a_of_type_Anhq) {
      return localanhq.jdField_a_of_type_JavaLangObject;
    }
    return null;
  }
  
  public boolean b(T paramT)
  {
    if (paramT == null) {
      return false;
    }
    for (anhq localanhq = this.jdField_a_of_type_Anhq.jdField_a_of_type_Anhq; (localanhq != this.jdField_a_of_type_Anhq) && (this.jdField_a_of_type_JavaUtilComparator.compare(localanhq.jdField_a_of_type_JavaLangObject, paramT) < 0); localanhq = localanhq.jdField_a_of_type_Anhq) {}
    if (paramT.equals(localanhq.jdField_a_of_type_JavaLangObject)) {
      return false;
    }
    paramT = new anhq(paramT, localanhq, localanhq.b);
    localanhq.b.jdField_a_of_type_Anhq = paramT;
    localanhq.b = paramT;
    this.jdField_a_of_type_Int += 1;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anhp
 * JD-Core Version:    0.7.0.1
 */