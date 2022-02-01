import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;

public class blli
{
  private static ArrayList<blli> a;
  public int a;
  public int b;
  public int c;
  public int d;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  }
  
  private static blli a()
  {
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      if (jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localblli = (blli)jdField_a_of_type_JavaUtilArrayList.remove(0);
        localblli.b();
        return localblli;
      }
      blli localblli = new blli();
      return localblli;
    }
  }
  
  public static blli a(int paramInt)
  {
    return a(2, paramInt, 0, 0);
  }
  
  public static blli a(int paramInt1, int paramInt2)
  {
    return a(1, paramInt1, paramInt2, 0);
  }
  
  public static blli a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    blli localblli = a();
    localblli.d = paramInt1;
    localblli.jdField_a_of_type_Int = paramInt2;
    localblli.b = paramInt3;
    localblli.c = paramInt4;
    return localblli;
  }
  
  public static blli a(long paramLong)
  {
    if (paramLong == 4294967295L) {
      return null;
    }
    blli localblli = a();
    localblli.jdField_a_of_type_Int = ExpandableListView.c(paramLong);
    if (ExpandableListView.b(paramLong) == 1)
    {
      localblli.d = 1;
      localblli.b = ExpandableListView.d(paramLong);
      return localblli;
    }
    localblli.d = 2;
    return localblli;
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
 * Qualified Name:     blli
 * JD-Core Version:    0.7.0.1
 */