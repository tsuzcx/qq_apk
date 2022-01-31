import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class berx
{
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  public bamp a;
  private List<RectF> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private List<bamp> b = new ArrayList();
  
  private berx(bamp parambamp)
  {
    this.jdField_a_of_type_Bamp = parambamp;
  }
  
  private void a(RectF paramRectF, bamp parambamp)
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
        this.b.add(parambamp);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     berx
 * JD-Core Version:    0.7.0.1
 */