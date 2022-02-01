import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;

public class blbq
{
  private static ArrayList<blbq> a;
  public int a;
  public int b;
  public int c;
  public int d;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  }
  
  private static blbq a()
  {
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      if (jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localblbq = (blbq)jdField_a_of_type_JavaUtilArrayList.remove(0);
        localblbq.b();
        return localblbq;
      }
      blbq localblbq = new blbq();
      return localblbq;
    }
  }
  
  public static blbq a(int paramInt)
  {
    return a(2, paramInt, 0, 0);
  }
  
  public static blbq a(int paramInt1, int paramInt2)
  {
    return a(1, paramInt1, paramInt2, 0);
  }
  
  public static blbq a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    blbq localblbq = a();
    localblbq.d = paramInt1;
    localblbq.jdField_a_of_type_Int = paramInt2;
    localblbq.b = paramInt3;
    localblbq.c = paramInt4;
    return localblbq;
  }
  
  public static blbq a(long paramLong)
  {
    if (paramLong == 4294967295L) {
      return null;
    }
    blbq localblbq = a();
    localblbq.jdField_a_of_type_Int = ExpandableListView.c(paramLong);
    if (ExpandableListView.b(paramLong) == 1)
    {
      localblbq.d = 1;
      localblbq.b = ExpandableListView.d(paramLong);
      return localblbq;
    }
    localblbq.d = 2;
    return localblbq;
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
 * Qualified Name:     blbq
 * JD-Core Version:    0.7.0.1
 */