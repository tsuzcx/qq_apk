import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;

public class bjqe
{
  private static ArrayList<bjqe> a;
  public int a;
  public int b;
  public int c;
  public int d;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  }
  
  private static bjqe a()
  {
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      if (jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localbjqe = (bjqe)jdField_a_of_type_JavaUtilArrayList.remove(0);
        localbjqe.b();
        return localbjqe;
      }
      bjqe localbjqe = new bjqe();
      return localbjqe;
    }
  }
  
  public static bjqe a(int paramInt)
  {
    return a(2, paramInt, 0, 0);
  }
  
  public static bjqe a(int paramInt1, int paramInt2)
  {
    return a(1, paramInt1, paramInt2, 0);
  }
  
  public static bjqe a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    bjqe localbjqe = a();
    localbjqe.d = paramInt1;
    localbjqe.jdField_a_of_type_Int = paramInt2;
    localbjqe.b = paramInt3;
    localbjqe.c = paramInt4;
    return localbjqe;
  }
  
  public static bjqe a(long paramLong)
  {
    if (paramLong == 4294967295L) {
      return null;
    }
    bjqe localbjqe = a();
    localbjqe.jdField_a_of_type_Int = ExpandableListView.c(paramLong);
    if (ExpandableListView.b(paramLong) == 1)
    {
      localbjqe.d = 1;
      localbjqe.b = ExpandableListView.d(paramLong);
      return localbjqe;
    }
    localbjqe.d = 2;
    return localbjqe;
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
 * Qualified Name:     bjqe
 * JD-Core Version:    0.7.0.1
 */