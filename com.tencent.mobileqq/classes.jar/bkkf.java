import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;

public class bkkf
{
  private static ArrayList<bkkf> a;
  public int a;
  public int b;
  public int c;
  public int d;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  }
  
  private static bkkf a()
  {
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      if (jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localbkkf = (bkkf)jdField_a_of_type_JavaUtilArrayList.remove(0);
        localbkkf.b();
        return localbkkf;
      }
      bkkf localbkkf = new bkkf();
      return localbkkf;
    }
  }
  
  public static bkkf a(int paramInt)
  {
    return a(2, paramInt, 0, 0);
  }
  
  public static bkkf a(int paramInt1, int paramInt2)
  {
    return a(1, paramInt1, paramInt2, 0);
  }
  
  public static bkkf a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    bkkf localbkkf = a();
    localbkkf.d = paramInt1;
    localbkkf.jdField_a_of_type_Int = paramInt2;
    localbkkf.b = paramInt3;
    localbkkf.c = paramInt4;
    return localbkkf;
  }
  
  public static bkkf a(long paramLong)
  {
    if (paramLong == 4294967295L) {
      return null;
    }
    bkkf localbkkf = a();
    localbkkf.jdField_a_of_type_Int = ExpandableListView.c(paramLong);
    if (ExpandableListView.b(paramLong) == 1)
    {
      localbkkf.d = 1;
      localbkkf.b = ExpandableListView.d(paramLong);
      return localbkkf;
    }
    localbkkf.d = 2;
    return localbkkf;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkkf
 * JD-Core Version:    0.7.0.1
 */