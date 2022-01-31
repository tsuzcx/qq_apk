import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class beno
{
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  public baig a;
  private List<RectF> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private List<baig> b = new ArrayList();
  
  private beno(baig parambaig)
  {
    this.jdField_a_of_type_Baig = parambaig;
  }
  
  private void a(RectF paramRectF, baig parambaig)
  {
    int j;
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      int i = 0;
      j = i;
      if (!localIterator.hasNext()) {
        break label63;
      }
      if (!paramRectF.equals((RectF)localIterator.next())) {
        break label91;
      }
      i = 1;
    }
    label63:
    label91:
    for (;;)
    {
      break;
      j = 0;
      if (j == 0)
      {
        this.jdField_a_of_type_JavaUtilList.add(paramRectF);
        this.b.add(parambaig);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beno
 * JD-Core Version:    0.7.0.1
 */