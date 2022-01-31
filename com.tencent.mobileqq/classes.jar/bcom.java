import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class bcom
{
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  public aykk a;
  private List<RectF> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private List<aykk> b = new ArrayList();
  
  private bcom(aykk paramaykk)
  {
    this.jdField_a_of_type_Aykk = paramaykk;
  }
  
  private void a(RectF paramRectF, aykk paramaykk)
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
        this.b.add(paramaykk);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcom
 * JD-Core Version:    0.7.0.1
 */