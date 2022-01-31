import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import com.tencent.widget.RangeButtonView;
import com.tencent.widget.RangeButtonView.Title;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class amdk
{
  private List jdField_a_of_type_JavaUtilList;
  
  public amdk(RangeButtonView paramRangeButtonView, List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((RangeButtonView.Title)localIterator.next()).a(paramCanvas, paramPaint, this.jdField_a_of_type_ComTencentWidgetRangeButtonView.a);
      }
    }
  }
  
  public void a(ArrayList paramArrayList, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramArrayList.size())
      {
        RangeButtonView.Title localTitle = (RangeButtonView.Title)this.jdField_a_of_type_JavaUtilList.get(i);
        localTitle.a = new Point(((Integer)paramArrayList.get(i)).intValue() - (localTitle.a() >> 1), paramInt);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amdk
 * JD-Core Version:    0.7.0.1
 */