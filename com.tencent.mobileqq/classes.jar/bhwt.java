import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;

public class bhwt
{
  private static ArrayList<bhwt> a;
  public int a;
  public int b;
  public int c;
  public int d;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  }
  
  private static bhwt a()
  {
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      if (jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localbhwt = (bhwt)jdField_a_of_type_JavaUtilArrayList.remove(0);
        localbhwt.b();
        return localbhwt;
      }
      bhwt localbhwt = new bhwt();
      return localbhwt;
    }
  }
  
  public static bhwt a(int paramInt)
  {
    return a(2, paramInt, 0, 0);
  }
  
  public static bhwt a(int paramInt1, int paramInt2)
  {
    return a(1, paramInt1, paramInt2, 0);
  }
  
  public static bhwt a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    bhwt localbhwt = a();
    localbhwt.d = paramInt1;
    localbhwt.jdField_a_of_type_Int = paramInt2;
    localbhwt.b = paramInt3;
    localbhwt.c = paramInt4;
    return localbhwt;
  }
  
  public static bhwt a(long paramLong)
  {
    if (paramLong == 4294967295L) {
      return null;
    }
    bhwt localbhwt = a();
    localbhwt.jdField_a_of_type_Int = ExpandableListView.c(paramLong);
    if (ExpandableListView.b(paramLong) == 1)
    {
      localbhwt.d = 1;
      localbhwt.b = ExpandableListView.d(paramLong);
      return localbhwt;
    }
    localbhwt.d = 2;
    return localbhwt;
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
 * Qualified Name:     bhwt
 * JD-Core Version:    0.7.0.1
 */