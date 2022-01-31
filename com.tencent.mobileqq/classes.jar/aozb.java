import java.util.Comparator;
import java.util.List;

public class aozb<T>
{
  private int jdField_a_of_type_Int;
  private final aozc<T> jdField_a_of_type_Aozc;
  private final aozd jdField_a_of_type_Aozd;
  private final Comparator<T> jdField_a_of_type_JavaUtilComparator;
  
  public aozb(Comparator<T> paramComparator, aozd<T> paramaozd)
  {
    this.jdField_a_of_type_Aozd = paramaozd;
    this.jdField_a_of_type_Aozc = new aozc();
    this.jdField_a_of_type_JavaUtilComparator = paramComparator;
  }
  
  private void a(long paramLong, List<T> paramList, aozc<T> paramaozc)
  {
    if ((aowq.a().a().a()) && ((paramList == null) || (paramList.isEmpty())) && (!a()) && ((paramaozc.jdField_a_of_type_JavaLangObject instanceof aoxh)))
    {
      paramList = (aoxh)paramaozc.jdField_a_of_type_JavaLangObject;
      long l = Math.abs(paramList.d() - paramLong);
      if (l > 60000L) {
        aozj.d("DanmakuDataSource", "Danmaku upload to screen fail, deltaTime = " + l + " , curTime = " + paramLong + ", curDanmaku = " + paramList);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public T a()
  {
    return this.jdField_a_of_type_Aozc.jdField_a_of_type_Aozc.jdField_a_of_type_JavaLangObject;
  }
  
  public List<T> a(long paramLong, List<T> paramList, int paramInt)
  {
    aozc localaozc = this.jdField_a_of_type_Aozc.jdField_a_of_type_Aozc;
    int j;
    for (int i = 0; (i < paramInt) && (localaozc != this.jdField_a_of_type_Aozc) && (this.jdField_a_of_type_Aozd.a(localaozc.jdField_a_of_type_JavaLangObject, paramLong) <= 0); i = j)
    {
      j = i;
      if (paramList != null)
      {
        paramList.add(localaozc.jdField_a_of_type_JavaLangObject);
        j = i + 1;
      }
      this.jdField_a_of_type_Int -= 1;
      localaozc = localaozc.jdField_a_of_type_Aozc;
    }
    a(paramLong, paramList, localaozc);
    this.jdField_a_of_type_Aozc.jdField_a_of_type_Aozc = localaozc;
    localaozc.b = this.jdField_a_of_type_Aozc;
    return paramList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aozc.jdField_a_of_type_Aozc = this.jdField_a_of_type_Aozc;
    this.jdField_a_of_type_Aozc.b = this.jdField_a_of_type_Aozc;
    this.jdField_a_of_type_Int = 0;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Aozc.jdField_a_of_type_Aozc == this.jdField_a_of_type_Aozc;
  }
  
  public boolean a(T paramT)
  {
    if (paramT == null) {
      return false;
    }
    for (aozc localaozc = this.jdField_a_of_type_Aozc.b; (localaozc != this.jdField_a_of_type_Aozc) && (this.jdField_a_of_type_JavaUtilComparator.compare(localaozc.jdField_a_of_type_JavaLangObject, paramT) > 0); localaozc = localaozc.b) {}
    if (paramT.equals(localaozc.jdField_a_of_type_JavaLangObject)) {
      return false;
    }
    paramT = new aozc(paramT, localaozc.jdField_a_of_type_Aozc, localaozc);
    localaozc.jdField_a_of_type_Aozc.b = paramT;
    localaozc.jdField_a_of_type_Aozc = paramT;
    this.jdField_a_of_type_Int += 1;
    return true;
  }
  
  public T b()
  {
    aozc localaozc = this.jdField_a_of_type_Aozc.b;
    if (localaozc != this.jdField_a_of_type_Aozc) {
      return localaozc.jdField_a_of_type_JavaLangObject;
    }
    return null;
  }
  
  public boolean b(T paramT)
  {
    if (paramT == null) {
      return false;
    }
    for (aozc localaozc = this.jdField_a_of_type_Aozc.jdField_a_of_type_Aozc; (localaozc != this.jdField_a_of_type_Aozc) && (this.jdField_a_of_type_JavaUtilComparator.compare(localaozc.jdField_a_of_type_JavaLangObject, paramT) < 0); localaozc = localaozc.jdField_a_of_type_Aozc) {}
    if (paramT.equals(localaozc.jdField_a_of_type_JavaLangObject)) {
      return false;
    }
    paramT = new aozc(paramT, localaozc, localaozc.b);
    localaozc.b.jdField_a_of_type_Aozc = paramT;
    localaozc.b = paramT;
    this.jdField_a_of_type_Int += 1;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aozb
 * JD-Core Version:    0.7.0.1
 */