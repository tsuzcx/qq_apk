import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;

public class bejf
{
  private static ArrayList<bejf> a;
  public int a;
  public int b;
  public int c;
  public int d;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  }
  
  private static bejf a()
  {
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      if (jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localbejf = (bejf)jdField_a_of_type_JavaUtilArrayList.remove(0);
        localbejf.b();
        return localbejf;
      }
      bejf localbejf = new bejf();
      return localbejf;
    }
  }
  
  public static bejf a(int paramInt)
  {
    return a(2, paramInt, 0, 0);
  }
  
  public static bejf a(int paramInt1, int paramInt2)
  {
    return a(1, paramInt1, paramInt2, 0);
  }
  
  public static bejf a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    bejf localbejf = a();
    localbejf.d = paramInt1;
    localbejf.jdField_a_of_type_Int = paramInt2;
    localbejf.b = paramInt3;
    localbejf.c = paramInt4;
    return localbejf;
  }
  
  public static bejf a(long paramLong)
  {
    if (paramLong == 4294967295L) {
      return null;
    }
    bejf localbejf = a();
    localbejf.jdField_a_of_type_Int = ExpandableListView.c(paramLong);
    if (ExpandableListView.b(paramLong) == 1)
    {
      localbejf.d = 1;
      localbejf.b = ExpandableListView.d(paramLong);
      return localbejf;
    }
    localbejf.d = 2;
    return localbejf;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
    this.c = 0;
    this.d = 0;
  }
  
  public long a()
  {
    if (this.d == 1) {
      return ExpandableListView.a(this.jdField_a_of_type_Int, this.b);
    }
    return ExpandableListView.b(this.jdField_a_of_type_Int);
  }
  
  public void a()
  {
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      if (jdField_a_of_type_JavaUtilArrayList.size() < 5) {
        jdField_a_of_type_JavaUtilArrayList.add(this);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bejf
 * JD-Core Version:    0.7.0.1
 */