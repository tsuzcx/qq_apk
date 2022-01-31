import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;

public class amiu
{
  private static ArrayList a;
  public int a;
  public int b;
  public int c;
  public int d;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  }
  
  private static amiu a()
  {
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      if (jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localamiu = (amiu)jdField_a_of_type_JavaUtilArrayList.remove(0);
        localamiu.b();
        return localamiu;
      }
      amiu localamiu = new amiu();
      return localamiu;
    }
  }
  
  public static amiu a(int paramInt)
  {
    return a(2, paramInt, 0, 0);
  }
  
  public static amiu a(int paramInt1, int paramInt2)
  {
    return a(1, paramInt1, paramInt2, 0);
  }
  
  public static amiu a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    amiu localamiu = a();
    localamiu.d = paramInt1;
    localamiu.jdField_a_of_type_Int = paramInt2;
    localamiu.b = paramInt3;
    localamiu.c = paramInt4;
    return localamiu;
  }
  
  public static amiu a(long paramLong)
  {
    if (paramLong == 4294967295L) {
      return null;
    }
    amiu localamiu = a();
    localamiu.jdField_a_of_type_Int = ExpandableListView.c(paramLong);
    if (ExpandableListView.b(paramLong) == 1)
    {
      localamiu.d = 1;
      localamiu.b = ExpandableListView.d(paramLong);
      return localamiu;
    }
    localamiu.d = 2;
    return localamiu;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amiu
 * JD-Core Version:    0.7.0.1
 */