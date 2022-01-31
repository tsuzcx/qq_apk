import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;

public class bhsm
{
  private static ArrayList<bhsm> a;
  public int a;
  public int b;
  public int c;
  public int d;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  }
  
  private static bhsm a()
  {
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      if (jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localbhsm = (bhsm)jdField_a_of_type_JavaUtilArrayList.remove(0);
        localbhsm.b();
        return localbhsm;
      }
      bhsm localbhsm = new bhsm();
      return localbhsm;
    }
  }
  
  public static bhsm a(int paramInt)
  {
    return a(2, paramInt, 0, 0);
  }
  
  public static bhsm a(int paramInt1, int paramInt2)
  {
    return a(1, paramInt1, paramInt2, 0);
  }
  
  public static bhsm a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    bhsm localbhsm = a();
    localbhsm.d = paramInt1;
    localbhsm.jdField_a_of_type_Int = paramInt2;
    localbhsm.b = paramInt3;
    localbhsm.c = paramInt4;
    return localbhsm;
  }
  
  public static bhsm a(long paramLong)
  {
    if (paramLong == 4294967295L) {
      return null;
    }
    bhsm localbhsm = a();
    localbhsm.jdField_a_of_type_Int = ExpandableListView.c(paramLong);
    if (ExpandableListView.b(paramLong) == 1)
    {
      localbhsm.d = 1;
      localbhsm.b = ExpandableListView.d(paramLong);
      return localbhsm;
    }
    localbhsm.d = 2;
    return localbhsm;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhsm
 * JD-Core Version:    0.7.0.1
 */