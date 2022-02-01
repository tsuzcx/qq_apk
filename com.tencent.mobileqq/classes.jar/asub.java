import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class asub
  implements View.OnClickListener
{
  asub(asua paramasua, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (asua.a(this.jdField_a_of_type_Asua).a(this.jdField_a_of_type_JavaLangString) == null)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    boolean bool = asua.a(this.jdField_a_of_type_Asua).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Asua.jdField_a_of_type_Int, this.jdField_a_of_type_Asua.jdField_a_of_type_JavaUtilList);
    String str2 = asua.a(this.jdField_a_of_type_Asua) + "";
    if (bool) {}
    for (String str1 = "1";; str1 = "2")
    {
      bdll.b(null, "dc00898", "", "", "0X800AC87", "0X800AC87", 2, 0, str2, str1, "", "");
      this.jdField_a_of_type_Asua.notifyDataSetChanged();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asub
 * JD-Core Version:    0.7.0.1
 */