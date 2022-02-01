import android.content.Context;
import android.widget.ListView;
import java.util.List;

public class beuj
{
  private static String jdField_a_of_type_JavaLangString = "TribeTitlePrefixPanelView";
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private beun jdField_a_of_type_Beun;
  
  public beuj(Context paramContext, ListView paramListView)
  {
    this.jdField_a_of_type_AndroidWidgetListView = paramListView;
    this.jdField_a_of_type_Beun = new beun(paramContext);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Beun);
  }
  
  public void a(beum parambeum)
  {
    if (this.jdField_a_of_type_Beun != null) {
      this.jdField_a_of_type_Beun.a(parambeum);
    }
  }
  
  public void a(List<beuo> paramList)
  {
    if (this.jdField_a_of_type_Beun != null) {
      this.jdField_a_of_type_Beun.a(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beuj
 * JD-Core Version:    0.7.0.1
 */