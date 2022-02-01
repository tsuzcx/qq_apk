import android.graphics.RectF;
import com.tencent.mobileqq.text.QQText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class bhgd
{
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  public QQText a;
  private List<RectF> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private List<QQText> b = new ArrayList();
  
  private bhgd(QQText paramQQText)
  {
    this.jdField_a_of_type_ComTencentMobileqqTextQQText = paramQQText;
  }
  
  private void a(RectF paramRectF, QQText paramQQText)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!paramRectF.equals((RectF)localIterator.next()));
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.jdField_a_of_type_JavaUtilList.add(paramRectF);
        this.b.add(paramQQText);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhgd
 * JD-Core Version:    0.7.0.1
 */