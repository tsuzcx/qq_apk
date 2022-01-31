import java.util.Comparator;
import java.util.List;

public class apdk<T>
{
  private int jdField_a_of_type_Int;
  private final apdl<T> jdField_a_of_type_Apdl;
  private final apdm jdField_a_of_type_Apdm;
  private final Comparator<T> jdField_a_of_type_JavaUtilComparator;
  
  public apdk(Comparator<T> paramComparator, apdm<T> paramapdm)
  {
    this.jdField_a_of_type_Apdm = paramapdm;
    this.jdField_a_of_type_Apdl = new apdl();
    this.jdField_a_of_type_JavaUtilComparator = paramComparator;
  }
  
  private void a(long paramLong, List<T> paramList, apdl<T> paramapdl)
  {
    if ((apaz.a().a().a()) && ((paramList == null) || (paramList.isEmpty())) && (!a()) && ((paramapdl.jdField_a_of_type_JavaLangObject instanceof apbq)))
    {
      paramList = (apbq)paramapdl.jdField_a_of_type_JavaLangObject;
      long l = Math.abs(paramList.d() - paramLong);
      if (l > 60000L) {
        apds.d("DanmakuDataSource", "Danmaku upload to screen fail, deltaTime = " + l + " , curTime = " + paramLong + ", curDanmaku = " + paramList);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public T a()
  {
    return this.jdField_a_of_type_Apdl.jdField_a_of_type_Apdl.jdField_a_of_type_JavaLangObject;
  }
  
  public List<T> a(long paramLong, List<T> paramList, int paramInt)
  {
    apdl localapdl = this.jdField_a_of_type_Apdl.jdField_a_of_type_Apdl;
    int j;
    for (int i = 0; (i < paramInt) && (localapdl != this.jdField_a_of_type_Apdl) && (this.jdField_a_of_type_Apdm.a(localapdl.jdField_a_of_type_JavaLangObject, paramLong) <= 0); i = j)
    {
      j = i;
      if (paramList != null)
      {
        paramList.add(localapdl.jdField_a_of_type_JavaLangObject);
        j = i + 1;
      }
      this.jdField_a_of_type_Int -= 1;
      localapdl = localapdl.jdField_a_of_type_Apdl;
    }
    a(paramLong, paramList, localapdl);
    this.jdField_a_of_type_Apdl.jdField_a_of_type_Apdl = localapdl;
    localapdl.b = this.jdField_a_of_type_Apdl;
    return paramList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Apdl.jdField_a_of_type_Apdl = this.jdField_a_of_type_Apdl;
    this.jdField_a_of_type_Apdl.b = this.jdField_a_of_type_Apdl;
    this.jdField_a_of_type_Int = 0;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Apdl.jdField_a_of_type_Apdl == this.jdField_a_of_type_Apdl;
  }
  
  public boolean a(T paramT)
  {
    if (paramT == null) {
      return false;
    }
    for (apdl localapdl = this.jdField_a_of_type_Apdl.b; (localapdl != this.jdField_a_of_type_Apdl) && (this.jdField_a_of_type_JavaUtilComparator.compare(localapdl.jdField_a_of_type_JavaLangObject, paramT) > 0); localapdl = localapdl.b) {}
    if (paramT.equals(localapdl.jdField_a_of_type_JavaLangObject)) {
      return false;
    }
    paramT = new apdl(paramT, localapdl.jdField_a_of_type_Apdl, localapdl);
    localapdl.jdField_a_of_type_Apdl.b = paramT;
    localapdl.jdField_a_of_type_Apdl = paramT;
    this.jdField_a_of_type_Int += 1;
    return true;
  }
  
  public T b()
  {
    apdl localapdl = this.jdField_a_of_type_Apdl.b;
    if (localapdl != this.jdField_a_of_type_Apdl) {
      return localapdl.jdField_a_of_type_JavaLangObject;
    }
    return null;
  }
  
  public boolean b(T paramT)
  {
    if (paramT == null) {
      return false;
    }
    for (apdl localapdl = this.jdField_a_of_type_Apdl.jdField_a_of_type_Apdl; (localapdl != this.jdField_a_of_type_Apdl) && (this.jdField_a_of_type_JavaUtilComparator.compare(localapdl.jdField_a_of_type_JavaLangObject, paramT) < 0); localapdl = localapdl.jdField_a_of_type_Apdl) {}
    if (paramT.equals(localapdl.jdField_a_of_type_JavaLangObject)) {
      return false;
    }
    paramT = new apdl(paramT, localapdl, localapdl.b);
    localapdl.b.jdField_a_of_type_Apdl = paramT;
    localapdl.b = paramT;
    this.jdField_a_of_type_Int += 1;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apdk
 * JD-Core Version:    0.7.0.1
 */