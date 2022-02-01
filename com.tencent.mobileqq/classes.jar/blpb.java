import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import com.tencent.widget.RangeButtonView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class blpb
{
  private List<blpa> jdField_a_of_type_JavaUtilList;
  
  public blpb(List<blpa> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((blpa)localIterator.next()).a(paramCanvas, paramPaint, this.jdField_a_of_type_ComTencentWidgetRangeButtonView.a);
      }
    }
  }
  
  public void a(ArrayList<Integer> paramArrayList, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramArrayList.size())
      {
        blpa localblpa = (blpa)this.jdField_a_of_type_JavaUtilList.get(i);
        localblpa.a = new Point(((Integer)paramArrayList.get(i)).intValue() - (localblpa.a() >> 1), paramInt);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blpb
 * JD-Core Version:    0.7.0.1
 */