import android.content.Context;
import android.widget.ListView;
import java.util.List;

public class bfes
{
  private static String jdField_a_of_type_JavaLangString = "TribeTitlePrefixPanelView";
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private bfew jdField_a_of_type_Bfew;
  
  public bfes(Context paramContext, ListView paramListView)
  {
    this.jdField_a_of_type_AndroidWidgetListView = paramListView;
    this.jdField_a_of_type_Bfew = new bfew(paramContext);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Bfew);
  }
  
  public void a(bfev parambfev)
  {
    if (this.jdField_a_of_type_Bfew != null) {
      this.jdField_a_of_type_Bfew.a(parambfev);
    }
  }
  
  public void a(List<bfex> paramList)
  {
    if (this.jdField_a_of_type_Bfew != null) {
      this.jdField_a_of_type_Bfew.a(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfes
 * JD-Core Version:    0.7.0.1
 */