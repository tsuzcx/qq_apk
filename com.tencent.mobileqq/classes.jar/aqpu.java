import java.util.Comparator;
import java.util.List;

public class aqpu<T>
{
  private int jdField_a_of_type_Int;
  private final aqpv<T> jdField_a_of_type_Aqpv;
  private final aqpw jdField_a_of_type_Aqpw;
  private final Comparator<T> jdField_a_of_type_JavaUtilComparator;
  
  public aqpu(Comparator<T> paramComparator, aqpw<T> paramaqpw)
  {
    this.jdField_a_of_type_Aqpw = paramaqpw;
    this.jdField_a_of_type_Aqpv = new aqpv();
    this.jdField_a_of_type_JavaUtilComparator = paramComparator;
  }
  
  private void a(long paramLong, List<T> paramList, aqpv<T> paramaqpv)
  {
    if ((aqnj.a().a().a()) && ((paramList == null) || (paramList.isEmpty())) && (!a()) && ((paramaqpv.jdField_a_of_type_JavaLangObject instanceof aqoa)))
    {
      paramList = (aqoa)paramaqpv.jdField_a_of_type_JavaLangObject;
      long l = Math.abs(paramList.d() - paramLong);
      if (l > 60000L) {
        aqqb.d("DanmakuDataSource", "Danmaku upload to screen fail, deltaTime = " + l + " , curTime = " + paramLong + ", curDanmaku = " + paramList);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public T a()
  {
    return this.jdField_a_of_type_Aqpv.jdField_a_of_type_Aqpv.jdField_a_of_type_JavaLangObject;
  }
  
  public List<T> a(long paramLong, List<T> paramList, int paramInt)
  {
    aqpv localaqpv = this.jdField_a_of_type_Aqpv.jdField_a_of_type_Aqpv;
    int j;
    for (int i = 0; (i < paramInt) && (localaqpv != this.jdField_a_of_type_Aqpv) && (this.jdField_a_of_type_Aqpw.a(localaqpv.jdField_a_of_type_JavaLangObject, paramLong) <= 0); i = j)
    {
      j = i;
      if (paramList != null)
      {
        paramList.add(localaqpv.jdField_a_of_type_JavaLangObject);
        j = i + 1;
      }
      this.jdField_a_of_type_Int -= 1;
      localaqpv = localaqpv.jdField_a_of_type_Aqpv;
    }
    a(paramLong, paramList, localaqpv);
    this.jdField_a_of_type_Aqpv.jdField_a_of_type_Aqpv = localaqpv;
    localaqpv.b = this.jdField_a_of_type_Aqpv;
    return paramList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aqpv.jdField_a_of_type_Aqpv = this.jdField_a_of_type_Aqpv;
    this.jdField_a_of_type_Aqpv.b = this.jdField_a_of_type_Aqpv;
    this.jdField_a_of_type_Int = 0;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Aqpv.jdField_a_of_type_Aqpv == this.jdField_a_of_type_Aqpv;
  }
  
  public boolean a(T paramT)
  {
    if (paramT == null) {
      return false;
    }
    for (aqpv localaqpv = this.jdField_a_of_type_Aqpv.b; (localaqpv != this.jdField_a_of_type_Aqpv) && (this.jdField_a_of_type_JavaUtilComparator.compare(localaqpv.jdField_a_of_type_JavaLangObject, paramT) > 0); localaqpv = localaqpv.b) {}
    if (paramT.equals(localaqpv.jdField_a_of_type_JavaLangObject)) {
      return false;
    }
    paramT = new aqpv(paramT, localaqpv.jdField_a_of_type_Aqpv, localaqpv);
    localaqpv.jdField_a_of_type_Aqpv.b = paramT;
    localaqpv.jdField_a_of_type_Aqpv = paramT;
    this.jdField_a_of_type_Int += 1;
    return true;
  }
  
  public T b()
  {
    aqpv localaqpv = this.jdField_a_of_type_Aqpv.b;
    if (localaqpv != this.jdField_a_of_type_Aqpv) {
      return localaqpv.jdField_a_of_type_JavaLangObject;
    }
    return null;
  }
  
  public boolean b(T paramT)
  {
    if (paramT == null) {
      return false;
    }
    for (aqpv localaqpv = this.jdField_a_of_type_Aqpv.jdField_a_of_type_Aqpv; (localaqpv != this.jdField_a_of_type_Aqpv) && (this.jdField_a_of_type_JavaUtilComparator.compare(localaqpv.jdField_a_of_type_JavaLangObject, paramT) < 0); localaqpv = localaqpv.jdField_a_of_type_Aqpv) {}
    if (paramT.equals(localaqpv.jdField_a_of_type_JavaLangObject)) {
      return false;
    }
    paramT = new aqpv(paramT, localaqpv, localaqpv.b);
    localaqpv.b.jdField_a_of_type_Aqpv = paramT;
    localaqpv.b = paramT;
    this.jdField_a_of_type_Int += 1;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqpu
 * JD-Core Version:    0.7.0.1
 */