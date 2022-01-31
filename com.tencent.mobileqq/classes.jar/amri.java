import java.util.Comparator;
import java.util.List;

public class amri<T>
{
  private int jdField_a_of_type_Int;
  private final amrj<T> jdField_a_of_type_Amrj;
  private final amrk jdField_a_of_type_Amrk;
  private final Comparator<T> jdField_a_of_type_JavaUtilComparator;
  
  public amri(Comparator<T> paramComparator, amrk<T> paramamrk)
  {
    this.jdField_a_of_type_Amrk = paramamrk;
    this.jdField_a_of_type_Amrj = new amrj();
    this.jdField_a_of_type_JavaUtilComparator = paramComparator;
  }
  
  private void a(long paramLong, List<T> paramList, amrj<T> paramamrj)
  {
    if ((amox.a().a().a()) && ((paramList == null) || (paramList.isEmpty())) && (!a()) && ((paramamrj.jdField_a_of_type_JavaLangObject instanceof ampo)))
    {
      paramList = (ampo)paramamrj.jdField_a_of_type_JavaLangObject;
      long l = Math.abs(paramList.d() - paramLong);
      if (l > 60000L) {
        amrq.d("DanmakuDataSource", "Danmaku upload to screen fail, deltaTime = " + l + " , curTime = " + paramLong + ", curDanmaku = " + paramList);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public T a()
  {
    return this.jdField_a_of_type_Amrj.jdField_a_of_type_Amrj.jdField_a_of_type_JavaLangObject;
  }
  
  public List<T> a(long paramLong, List<T> paramList, int paramInt)
  {
    amrj localamrj = this.jdField_a_of_type_Amrj.jdField_a_of_type_Amrj;
    int j;
    for (int i = 0; (i < paramInt) && (localamrj != this.jdField_a_of_type_Amrj) && (this.jdField_a_of_type_Amrk.a(localamrj.jdField_a_of_type_JavaLangObject, paramLong) <= 0); i = j)
    {
      j = i;
      if (paramList != null)
      {
        paramList.add(localamrj.jdField_a_of_type_JavaLangObject);
        j = i + 1;
      }
      this.jdField_a_of_type_Int -= 1;
      localamrj = localamrj.jdField_a_of_type_Amrj;
    }
    a(paramLong, paramList, localamrj);
    this.jdField_a_of_type_Amrj.jdField_a_of_type_Amrj = localamrj;
    localamrj.b = this.jdField_a_of_type_Amrj;
    return paramList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Amrj.jdField_a_of_type_Amrj = this.jdField_a_of_type_Amrj;
    this.jdField_a_of_type_Amrj.b = this.jdField_a_of_type_Amrj;
    this.jdField_a_of_type_Int = 0;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Amrj.jdField_a_of_type_Amrj == this.jdField_a_of_type_Amrj;
  }
  
  public boolean a(T paramT)
  {
    if (paramT == null) {
      return false;
    }
    for (amrj localamrj = this.jdField_a_of_type_Amrj.b; (localamrj != this.jdField_a_of_type_Amrj) && (this.jdField_a_of_type_JavaUtilComparator.compare(localamrj.jdField_a_of_type_JavaLangObject, paramT) > 0); localamrj = localamrj.b) {}
    if (paramT.equals(localamrj.jdField_a_of_type_JavaLangObject)) {
      return false;
    }
    paramT = new amrj(paramT, localamrj.jdField_a_of_type_Amrj, localamrj);
    localamrj.jdField_a_of_type_Amrj.b = paramT;
    localamrj.jdField_a_of_type_Amrj = paramT;
    this.jdField_a_of_type_Int += 1;
    return true;
  }
  
  public T b()
  {
    amrj localamrj = this.jdField_a_of_type_Amrj.b;
    if (localamrj != this.jdField_a_of_type_Amrj) {
      return localamrj.jdField_a_of_type_JavaLangObject;
    }
    return null;
  }
  
  public boolean b(T paramT)
  {
    if (paramT == null) {
      return false;
    }
    for (amrj localamrj = this.jdField_a_of_type_Amrj.jdField_a_of_type_Amrj; (localamrj != this.jdField_a_of_type_Amrj) && (this.jdField_a_of_type_JavaUtilComparator.compare(localamrj.jdField_a_of_type_JavaLangObject, paramT) < 0); localamrj = localamrj.jdField_a_of_type_Amrj) {}
    if (paramT.equals(localamrj.jdField_a_of_type_JavaLangObject)) {
      return false;
    }
    paramT = new amrj(paramT, localamrj, localamrj.b);
    localamrj.b.jdField_a_of_type_Amrj = paramT;
    localamrj.b = paramT;
    this.jdField_a_of_type_Int += 1;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amri
 * JD-Core Version:    0.7.0.1
 */