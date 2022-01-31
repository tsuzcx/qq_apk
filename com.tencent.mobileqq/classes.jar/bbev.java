import android.content.Context;
import android.widget.ListView;
import java.util.List;

public class bbev
{
  private static String jdField_a_of_type_JavaLangString = "TribeTitlePrefixPanelView";
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private bbez jdField_a_of_type_Bbez;
  
  public bbev(Context paramContext, ListView paramListView)
  {
    this.jdField_a_of_type_AndroidWidgetListView = paramListView;
    this.jdField_a_of_type_Bbez = new bbez(paramContext);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Bbez);
  }
  
  public void a(bbey parambbey)
  {
    if (this.jdField_a_of_type_Bbez != null) {
      this.jdField_a_of_type_Bbez.a(parambbey);
    }
  }
  
  public void a(List<bbfa> paramList)
  {
    if (this.jdField_a_of_type_Bbez != null) {
      this.jdField_a_of_type_Bbez.a(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbev
 * JD-Core Version:    0.7.0.1
 */