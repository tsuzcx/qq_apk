import java.util.Comparator;
import java.util.List;

public class artf<T>
{
  private int jdField_a_of_type_Int;
  private final artg<T> jdField_a_of_type_Artg;
  private final arth jdField_a_of_type_Arth;
  private final Comparator<T> jdField_a_of_type_JavaUtilComparator;
  
  public artf(Comparator<T> paramComparator, arth<T> paramarth)
  {
    this.jdField_a_of_type_Arth = paramarth;
    this.jdField_a_of_type_Artg = new artg();
    this.jdField_a_of_type_JavaUtilComparator = paramComparator;
  }
  
  private void a(long paramLong, List<T> paramList, artg<T> paramartg)
  {
    if ((arqu.a().a().a()) && ((paramList == null) || (paramList.isEmpty())) && (!a()) && ((paramartg.jdField_a_of_type_JavaLangObject instanceof arrl)))
    {
      paramList = (arrl)paramartg.jdField_a_of_type_JavaLangObject;
      long l = Math.abs(paramList.d() - paramLong);
      if (l > 60000L) {
        artm.d("DanmakuDataSource", "Danmaku upload to screen fail, deltaTime = " + l + " , curTime = " + paramLong + ", curDanmaku = " + paramList);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public T a()
  {
    return this.jdField_a_of_type_Artg.jdField_a_of_type_Artg.jdField_a_of_type_JavaLangObject;
  }
  
  public List<T> a(long paramLong, List<T> paramList, int paramInt)
  {
    artg localartg = this.jdField_a_of_type_Artg.jdField_a_of_type_Artg;
    int j;
    for (int i = 0; (i < paramInt) && (localartg != this.jdField_a_of_type_Artg) && (this.jdField_a_of_type_Arth.a(localartg.jdField_a_of_type_JavaLangObject, paramLong) <= 0); i = j)
    {
      j = i;
      if (paramList != null)
      {
        paramList.add(localartg.jdField_a_of_type_JavaLangObject);
        j = i + 1;
      }
      this.jdField_a_of_type_Int -= 1;
      localartg = localartg.jdField_a_of_type_Artg;
    }
    a(paramLong, paramList, localartg);
    this.jdField_a_of_type_Artg.jdField_a_of_type_Artg = localartg;
    localartg.b = this.jdField_a_of_type_Artg;
    return paramList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Artg.jdField_a_of_type_Artg = this.jdField_a_of_type_Artg;
    this.jdField_a_of_type_Artg.b = this.jdField_a_of_type_Artg;
    this.jdField_a_of_type_Int = 0;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Artg.jdField_a_of_type_Artg == this.jdField_a_of_type_Artg;
  }
  
  public boolean a(T paramT)
  {
    if (paramT == null) {
      return false;
    }
    for (artg localartg = this.jdField_a_of_type_Artg.b; (localartg != this.jdField_a_of_type_Artg) && (this.jdField_a_of_type_JavaUtilComparator.compare(localartg.jdField_a_of_type_JavaLangObject, paramT) > 0); localartg = localartg.b) {}
    if (paramT.equals(localartg.jdField_a_of_type_JavaLangObject)) {
      return false;
    }
    paramT = new artg(paramT, localartg.jdField_a_of_type_Artg, localartg);
    localartg.jdField_a_of_type_Artg.b = paramT;
    localartg.jdField_a_of_type_Artg = paramT;
    this.jdField_a_of_type_Int += 1;
    return true;
  }
  
  public T b()
  {
    artg localartg = this.jdField_a_of_type_Artg.b;
    if (localartg != this.jdField_a_of_type_Artg) {
      return localartg.jdField_a_of_type_JavaLangObject;
    }
    return null;
  }
  
  public boolean b(T paramT)
  {
    if (paramT == null) {
      return false;
    }
    for (artg localartg = this.jdField_a_of_type_Artg.jdField_a_of_type_Artg; (localartg != this.jdField_a_of_type_Artg) && (this.jdField_a_of_type_JavaUtilComparator.compare(localartg.jdField_a_of_type_JavaLangObject, paramT) < 0); localartg = localartg.jdField_a_of_type_Artg) {}
    if (paramT.equals(localartg.jdField_a_of_type_JavaLangObject)) {
      return false;
    }
    paramT = new artg(paramT, localartg, localartg.b);
    localartg.b.jdField_a_of_type_Artg = paramT;
    localartg.b = paramT;
    this.jdField_a_of_type_Int += 1;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     artf
 * JD-Core Version:    0.7.0.1
 */