import android.content.Context;
import android.widget.ListView;
import java.util.List;

public class bbam
{
  private static String jdField_a_of_type_JavaLangString = "TribeTitlePrefixPanelView";
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private bbaq jdField_a_of_type_Bbaq;
  
  public bbam(Context paramContext, ListView paramListView)
  {
    this.jdField_a_of_type_AndroidWidgetListView = paramListView;
    this.jdField_a_of_type_Bbaq = new bbaq(paramContext);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Bbaq);
  }
  
  public void a(bbap parambbap)
  {
    if (this.jdField_a_of_type_Bbaq != null) {
      this.jdField_a_of_type_Bbaq.a(parambbap);
    }
  }
  
  public void a(List<bbar> paramList)
  {
    if (this.jdField_a_of_type_Bbaq != null) {
      this.jdField_a_of_type_Bbaq.a(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbam
 * JD-Core Version:    0.7.0.1
 */