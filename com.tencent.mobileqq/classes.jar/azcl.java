import android.content.Context;
import android.widget.ListView;
import java.util.List;

public class azcl
{
  private static String jdField_a_of_type_JavaLangString = "TribeTitlePrefixPanelView";
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private azcp jdField_a_of_type_Azcp;
  
  public azcl(Context paramContext, ListView paramListView)
  {
    this.jdField_a_of_type_AndroidWidgetListView = paramListView;
    this.jdField_a_of_type_Azcp = new azcp(paramContext);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Azcp);
  }
  
  public void a(azco paramazco)
  {
    if (this.jdField_a_of_type_Azcp != null) {
      this.jdField_a_of_type_Azcp.a(paramazco);
    }
  }
  
  public void a(List<azcq> paramList)
  {
    if (this.jdField_a_of_type_Azcp != null) {
      this.jdField_a_of_type_Azcp.a(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azcl
 * JD-Core Version:    0.7.0.1
 */