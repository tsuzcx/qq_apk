import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

public class bfys
  extends GridLayoutManager.SpanSizeLookup
{
  private GridLayoutManager.SpanSizeLookup jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager$SpanSizeLookup;
  private final GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  private final bfzg jdField_a_of_type_Bfzg;
  
  public bfys(bfzg parambfzg, GridLayoutManager paramGridLayoutManager)
  {
    this.jdField_a_of_type_Bfzg = parambfzg;
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = paramGridLayoutManager;
  }
  
  public void a(GridLayoutManager.SpanSizeLookup paramSpanSizeLookup)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager$SpanSizeLookup = paramSpanSizeLookup;
  }
  
  public int getSpanSize(int paramInt)
  {
    int j = 1;
    int i;
    if ((this.jdField_a_of_type_Bfzg.a(paramInt)) || (this.jdField_a_of_type_Bfzg.b(paramInt)))
    {
      i = 1;
      if (i == 0) {
        break label45;
      }
      i = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.getSpanCount();
    }
    label45:
    do
    {
      return i;
      i = 0;
      break;
      i = j;
    } while (this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager$SpanSizeLookup == null);
    return this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager$SpanSizeLookup.getSpanSize(paramInt - this.jdField_a_of_type_Bfzg.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfys
 * JD-Core Version:    0.7.0.1
 */