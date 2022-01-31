import android.content.Context;
import android.widget.ListView;
import java.util.List;

public class azcn
{
  private static String jdField_a_of_type_JavaLangString = "TribeTitlePrefixPanelView";
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private azcr jdField_a_of_type_Azcr;
  
  public azcn(Context paramContext, ListView paramListView)
  {
    this.jdField_a_of_type_AndroidWidgetListView = paramListView;
    this.jdField_a_of_type_Azcr = new azcr(paramContext);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Azcr);
  }
  
  public void a(azcq paramazcq)
  {
    if (this.jdField_a_of_type_Azcr != null) {
      this.jdField_a_of_type_Azcr.a(paramazcq);
    }
  }
  
  public void a(List<azcs> paramList)
  {
    if (this.jdField_a_of_type_Azcr != null) {
      this.jdField_a_of_type_Azcr.a(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azcn
 * JD-Core Version:    0.7.0.1
 */