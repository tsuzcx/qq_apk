import android.content.Context;
import android.widget.ListView;
import java.util.List;

public class aycb
{
  private static String jdField_a_of_type_JavaLangString = "TribeTitlePrefixPanelView";
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private aycf jdField_a_of_type_Aycf;
  
  public aycb(Context paramContext, ListView paramListView)
  {
    this.jdField_a_of_type_AndroidWidgetListView = paramListView;
    this.jdField_a_of_type_Aycf = new aycf(paramContext);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Aycf);
  }
  
  public void a(ayce paramayce)
  {
    if (this.jdField_a_of_type_Aycf != null) {
      this.jdField_a_of_type_Aycf.a(paramayce);
    }
  }
  
  public void a(List<aycg> paramList)
  {
    if (this.jdField_a_of_type_Aycf != null) {
      this.jdField_a_of_type_Aycf.a(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aycb
 * JD-Core Version:    0.7.0.1
 */