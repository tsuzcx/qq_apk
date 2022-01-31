import java.util.Comparator;
import java.util.List;

public class anhu<T>
{
  private int jdField_a_of_type_Int;
  private final anhv<T> jdField_a_of_type_Anhv;
  private final anhw jdField_a_of_type_Anhw;
  private final Comparator<T> jdField_a_of_type_JavaUtilComparator;
  
  public anhu(Comparator<T> paramComparator, anhw<T> paramanhw)
  {
    this.jdField_a_of_type_Anhw = paramanhw;
    this.jdField_a_of_type_Anhv = new anhv();
    this.jdField_a_of_type_JavaUtilComparator = paramComparator;
  }
  
  private void a(long paramLong, List<T> paramList, anhv<T> paramanhv)
  {
    if ((anfj.a().a().a()) && ((paramList == null) || (paramList.isEmpty())) && (!a()) && ((paramanhv.jdField_a_of_type_JavaLangObject instanceof anga)))
    {
      paramList = (anga)paramanhv.jdField_a_of_type_JavaLangObject;
      long l = Math.abs(paramList.d() - paramLong);
      if (l > 60000L) {
        anic.d("DanmakuDataSource", "Danmaku upload to screen fail, deltaTime = " + l + " , curTime = " + paramLong + ", curDanmaku = " + paramList);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public T a()
  {
    return this.jdField_a_of_type_Anhv.jdField_a_of_type_Anhv.jdField_a_of_type_JavaLangObject;
  }
  
  public List<T> a(long paramLong, List<T> paramList, int paramInt)
  {
    anhv localanhv = this.jdField_a_of_type_Anhv.jdField_a_of_type_Anhv;
    int j;
    for (int i = 0; (i < paramInt) && (localanhv != this.jdField_a_of_type_Anhv) && (this.jdField_a_of_type_Anhw.a(localanhv.jdField_a_of_type_JavaLangObject, paramLong) <= 0); i = j)
    {
      j = i;
      if (paramList != null)
      {
        paramList.add(localanhv.jdField_a_of_type_JavaLangObject);
        j = i + 1;
      }
      this.jdField_a_of_type_Int -= 1;
      localanhv = localanhv.jdField_a_of_type_Anhv;
    }
    a(paramLong, paramList, localanhv);
    this.jdField_a_of_type_Anhv.jdField_a_of_type_Anhv = localanhv;
    localanhv.b = this.jdField_a_of_type_Anhv;
    return paramList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Anhv.jdField_a_of_type_Anhv = this.jdField_a_of_type_Anhv;
    this.jdField_a_of_type_Anhv.b = this.jdField_a_of_type_Anhv;
    this.jdField_a_of_type_Int = 0;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Anhv.jdField_a_of_type_Anhv == this.jdField_a_of_type_Anhv;
  }
  
  public boolean a(T paramT)
  {
    if (paramT == null) {
      return false;
    }
    for (anhv localanhv = this.jdField_a_of_type_Anhv.b; (localanhv != this.jdField_a_of_type_Anhv) && (this.jdField_a_of_type_JavaUtilComparator.compare(localanhv.jdField_a_of_type_JavaLangObject, paramT) > 0); localanhv = localanhv.b) {}
    if (paramT.equals(localanhv.jdField_a_of_type_JavaLangObject)) {
      return false;
    }
    paramT = new anhv(paramT, localanhv.jdField_a_of_type_Anhv, localanhv);
    localanhv.jdField_a_of_type_Anhv.b = paramT;
    localanhv.jdField_a_of_type_Anhv = paramT;
    this.jdField_a_of_type_Int += 1;
    return true;
  }
  
  public T b()
  {
    anhv localanhv = this.jdField_a_of_type_Anhv.b;
    if (localanhv != this.jdField_a_of_type_Anhv) {
      return localanhv.jdField_a_of_type_JavaLangObject;
    }
    return null;
  }
  
  public boolean b(T paramT)
  {
    if (paramT == null) {
      return false;
    }
    for (anhv localanhv = this.jdField_a_of_type_Anhv.jdField_a_of_type_Anhv; (localanhv != this.jdField_a_of_type_Anhv) && (this.jdField_a_of_type_JavaUtilComparator.compare(localanhv.jdField_a_of_type_JavaLangObject, paramT) < 0); localanhv = localanhv.jdField_a_of_type_Anhv) {}
    if (paramT.equals(localanhv.jdField_a_of_type_JavaLangObject)) {
      return false;
    }
    paramT = new anhv(paramT, localanhv, localanhv.b);
    localanhv.b.jdField_a_of_type_Anhv = paramT;
    localanhv.b = paramT;
    this.jdField_a_of_type_Int += 1;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anhu
 * JD-Core Version:    0.7.0.1
 */