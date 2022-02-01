import java.util.Comparator;
import java.util.List;

public class argh<T>
{
  private int jdField_a_of_type_Int;
  private final argi<T> jdField_a_of_type_Argi;
  private final argj jdField_a_of_type_Argj;
  private final Comparator<T> jdField_a_of_type_JavaUtilComparator;
  
  public argh(Comparator<T> paramComparator, argj<T> paramargj)
  {
    this.jdField_a_of_type_Argj = paramargj;
    this.jdField_a_of_type_Argi = new argi();
    this.jdField_a_of_type_JavaUtilComparator = paramComparator;
  }
  
  private void a(long paramLong, List<T> paramList, argi<T> paramargi)
  {
    if ((ardw.a().a().a()) && ((paramList == null) || (paramList.isEmpty())) && (!a()) && ((paramargi.jdField_a_of_type_JavaLangObject instanceof aren)))
    {
      paramList = (aren)paramargi.jdField_a_of_type_JavaLangObject;
      long l = Math.abs(paramList.d() - paramLong);
      if (l > 60000L) {
        argp.d("DanmakuDataSource", "Danmaku upload to screen fail, deltaTime = " + l + " , curTime = " + paramLong + ", curDanmaku = " + paramList);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public T a()
  {
    return this.jdField_a_of_type_Argi.jdField_a_of_type_Argi.jdField_a_of_type_JavaLangObject;
  }
  
  public List<T> a(long paramLong, List<T> paramList, int paramInt)
  {
    argi localargi = this.jdField_a_of_type_Argi.jdField_a_of_type_Argi;
    int j;
    for (int i = 0; (i < paramInt) && (localargi != this.jdField_a_of_type_Argi) && (this.jdField_a_of_type_Argj.a(localargi.jdField_a_of_type_JavaLangObject, paramLong) <= 0); i = j)
    {
      j = i;
      if (paramList != null)
      {
        paramList.add(localargi.jdField_a_of_type_JavaLangObject);
        j = i + 1;
      }
      this.jdField_a_of_type_Int -= 1;
      localargi = localargi.jdField_a_of_type_Argi;
    }
    a(paramLong, paramList, localargi);
    this.jdField_a_of_type_Argi.jdField_a_of_type_Argi = localargi;
    localargi.b = this.jdField_a_of_type_Argi;
    return paramList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Argi.jdField_a_of_type_Argi = this.jdField_a_of_type_Argi;
    this.jdField_a_of_type_Argi.b = this.jdField_a_of_type_Argi;
    this.jdField_a_of_type_Int = 0;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Argi.jdField_a_of_type_Argi == this.jdField_a_of_type_Argi;
  }
  
  public boolean a(T paramT)
  {
    if (paramT == null) {
      return false;
    }
    for (argi localargi = this.jdField_a_of_type_Argi.b; (localargi != this.jdField_a_of_type_Argi) && (this.jdField_a_of_type_JavaUtilComparator.compare(localargi.jdField_a_of_type_JavaLangObject, paramT) > 0); localargi = localargi.b) {}
    if (paramT.equals(localargi.jdField_a_of_type_JavaLangObject)) {
      return false;
    }
    paramT = new argi(paramT, localargi.jdField_a_of_type_Argi, localargi);
    localargi.jdField_a_of_type_Argi.b = paramT;
    localargi.jdField_a_of_type_Argi = paramT;
    this.jdField_a_of_type_Int += 1;
    return true;
  }
  
  public T b()
  {
    argi localargi = this.jdField_a_of_type_Argi.b;
    if (localargi != this.jdField_a_of_type_Argi) {
      return localargi.jdField_a_of_type_JavaLangObject;
    }
    return null;
  }
  
  public boolean b(T paramT)
  {
    if (paramT == null) {
      return false;
    }
    for (argi localargi = this.jdField_a_of_type_Argi.jdField_a_of_type_Argi; (localargi != this.jdField_a_of_type_Argi) && (this.jdField_a_of_type_JavaUtilComparator.compare(localargi.jdField_a_of_type_JavaLangObject, paramT) < 0); localargi = localargi.jdField_a_of_type_Argi) {}
    if (paramT.equals(localargi.jdField_a_of_type_JavaLangObject)) {
      return false;
    }
    paramT = new argi(paramT, localargi, localargi.b);
    localargi.b.jdField_a_of_type_Argi = paramT;
    localargi.b = paramT;
    this.jdField_a_of_type_Int += 1;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     argh
 * JD-Core Version:    0.7.0.1
 */