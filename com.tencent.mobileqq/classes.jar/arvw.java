import java.util.Comparator;
import java.util.List;

public class arvw<T>
{
  private int jdField_a_of_type_Int;
  private final arvx<T> jdField_a_of_type_Arvx;
  private final arvy jdField_a_of_type_Arvy;
  private final Comparator<T> jdField_a_of_type_JavaUtilComparator;
  
  public arvw(Comparator<T> paramComparator, arvy<T> paramarvy)
  {
    this.jdField_a_of_type_Arvy = paramarvy;
    this.jdField_a_of_type_Arvx = new arvx();
    this.jdField_a_of_type_JavaUtilComparator = paramComparator;
  }
  
  private void a(long paramLong, List<T> paramList, arvx<T> paramarvx)
  {
    if ((artl.a().a().a()) && ((paramList == null) || (paramList.isEmpty())) && (!a()) && ((paramarvx.jdField_a_of_type_JavaLangObject instanceof aruc)))
    {
      paramList = (aruc)paramarvx.jdField_a_of_type_JavaLangObject;
      long l = Math.abs(paramList.d() - paramLong);
      if (l > 60000L) {
        arwe.d("DanmakuDataSource", "Danmaku upload to screen fail, deltaTime = " + l + " , curTime = " + paramLong + ", curDanmaku = " + paramList);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public T a()
  {
    return this.jdField_a_of_type_Arvx.jdField_a_of_type_Arvx.jdField_a_of_type_JavaLangObject;
  }
  
  public List<T> a(long paramLong, List<T> paramList, int paramInt)
  {
    arvx localarvx = this.jdField_a_of_type_Arvx.jdField_a_of_type_Arvx;
    int j;
    for (int i = 0; (i < paramInt) && (localarvx != this.jdField_a_of_type_Arvx) && (this.jdField_a_of_type_Arvy.a(localarvx.jdField_a_of_type_JavaLangObject, paramLong) <= 0); i = j)
    {
      j = i;
      if (paramList != null)
      {
        paramList.add(localarvx.jdField_a_of_type_JavaLangObject);
        j = i + 1;
      }
      this.jdField_a_of_type_Int -= 1;
      localarvx = localarvx.jdField_a_of_type_Arvx;
    }
    a(paramLong, paramList, localarvx);
    this.jdField_a_of_type_Arvx.jdField_a_of_type_Arvx = localarvx;
    localarvx.b = this.jdField_a_of_type_Arvx;
    return paramList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Arvx.jdField_a_of_type_Arvx = this.jdField_a_of_type_Arvx;
    this.jdField_a_of_type_Arvx.b = this.jdField_a_of_type_Arvx;
    this.jdField_a_of_type_Int = 0;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Arvx.jdField_a_of_type_Arvx == this.jdField_a_of_type_Arvx;
  }
  
  public boolean a(T paramT)
  {
    if (paramT == null) {
      return false;
    }
    for (arvx localarvx = this.jdField_a_of_type_Arvx.b; (localarvx != this.jdField_a_of_type_Arvx) && (this.jdField_a_of_type_JavaUtilComparator.compare(localarvx.jdField_a_of_type_JavaLangObject, paramT) > 0); localarvx = localarvx.b) {}
    if (paramT.equals(localarvx.jdField_a_of_type_JavaLangObject)) {
      return false;
    }
    paramT = new arvx(paramT, localarvx.jdField_a_of_type_Arvx, localarvx);
    localarvx.jdField_a_of_type_Arvx.b = paramT;
    localarvx.jdField_a_of_type_Arvx = paramT;
    this.jdField_a_of_type_Int += 1;
    return true;
  }
  
  public T b()
  {
    arvx localarvx = this.jdField_a_of_type_Arvx.b;
    if (localarvx != this.jdField_a_of_type_Arvx) {
      return localarvx.jdField_a_of_type_JavaLangObject;
    }
    return null;
  }
  
  public boolean b(T paramT)
  {
    if (paramT == null) {
      return false;
    }
    for (arvx localarvx = this.jdField_a_of_type_Arvx.jdField_a_of_type_Arvx; (localarvx != this.jdField_a_of_type_Arvx) && (this.jdField_a_of_type_JavaUtilComparator.compare(localarvx.jdField_a_of_type_JavaLangObject, paramT) < 0); localarvx = localarvx.jdField_a_of_type_Arvx) {}
    if (paramT.equals(localarvx.jdField_a_of_type_JavaLangObject)) {
      return false;
    }
    paramT = new arvx(paramT, localarvx, localarvx.b);
    localarvx.b.jdField_a_of_type_Arvx = paramT;
    localarvx.b = paramT;
    this.jdField_a_of_type_Int += 1;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arvw
 * JD-Core Version:    0.7.0.1
 */