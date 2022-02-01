import android.content.Context;
import android.widget.ListView;
import java.util.List;

public class beft
{
  private static String jdField_a_of_type_JavaLangString = "TribeTitlePrefixPanelView";
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private befx jdField_a_of_type_Befx;
  
  public beft(Context paramContext, ListView paramListView)
  {
    this.jdField_a_of_type_AndroidWidgetListView = paramListView;
    this.jdField_a_of_type_Befx = new befx(paramContext);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Befx);
  }
  
  public void a(befw parambefw)
  {
    if (this.jdField_a_of_type_Befx != null) {
      this.jdField_a_of_type_Befx.a(parambefw);
    }
  }
  
  public void a(List<befy> paramList)
  {
    if (this.jdField_a_of_type_Befx != null) {
      this.jdField_a_of_type_Befx.a(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beft
 * JD-Core Version:    0.7.0.1
 */