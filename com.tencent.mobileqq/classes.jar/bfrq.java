import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;

public class bfrq
{
  private static ArrayList<bfrq> a;
  public int a;
  public int b;
  public int c;
  public int d;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  }
  
  private static bfrq a()
  {
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      if (jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localbfrq = (bfrq)jdField_a_of_type_JavaUtilArrayList.remove(0);
        localbfrq.b();
        return localbfrq;
      }
      bfrq localbfrq = new bfrq();
      return localbfrq;
    }
  }
  
  public static bfrq a(int paramInt)
  {
    return a(2, paramInt, 0, 0);
  }
  
  public static bfrq a(int paramInt1, int paramInt2)
  {
    return a(1, paramInt1, paramInt2, 0);
  }
  
  public static bfrq a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    bfrq localbfrq = a();
    localbfrq.d = paramInt1;
    localbfrq.jdField_a_of_type_Int = paramInt2;
    localbfrq.b = paramInt3;
    localbfrq.c = paramInt4;
    return localbfrq;
  }
  
  public static bfrq a(long paramLong)
  {
    if (paramLong == 4294967295L) {
      return null;
    }
    bfrq localbfrq = a();
    localbfrq.jdField_a_of_type_Int = ExpandableListView.c(paramLong);
    if (ExpandableListView.b(paramLong) == 1)
    {
      localbfrq.d = 1;
      localbfrq.b = ExpandableListView.d(paramLong);
      return localbfrq;
    }
    localbfrq.d = 2;
    return localbfrq;
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
 * Qualified Name:     bfrq
 * JD-Core Version:    0.7.0.1
 */