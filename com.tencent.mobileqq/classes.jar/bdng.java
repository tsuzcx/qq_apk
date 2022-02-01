import android.content.Context;
import android.widget.ListView;
import java.util.List;

public class bdng
{
  private static String jdField_a_of_type_JavaLangString = "TribeTitlePrefixPanelView";
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private bdnk jdField_a_of_type_Bdnk;
  
  public bdng(Context paramContext, ListView paramListView)
  {
    this.jdField_a_of_type_AndroidWidgetListView = paramListView;
    this.jdField_a_of_type_Bdnk = new bdnk(paramContext);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Bdnk);
  }
  
  public void a(bdnj parambdnj)
  {
    if (this.jdField_a_of_type_Bdnk != null) {
      this.jdField_a_of_type_Bdnk.a(parambdnj);
    }
  }
  
  public void a(List<bdnl> paramList)
  {
    if (this.jdField_a_of_type_Bdnk != null) {
      this.jdField_a_of_type_Bdnk.a(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdng
 * JD-Core Version:    0.7.0.1
 */