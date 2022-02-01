import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

class atzt
{
  float jdField_a_of_type_Float = 14.0F;
  int jdField_a_of_type_Int = 0;
  DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
  Integer jdField_a_of_type_JavaLangInteger = null;
  final String jdField_a_of_type_JavaLangString = "SearchForText";
  float jdField_b_of_type_Float = 16.0F;
  Integer jdField_b_of_type_JavaLangInteger = null;
  final String jdField_b_of_type_JavaLangString = "SearchForTitle";
  
  atzt(atzr paramatzr, Context paramContext)
  {
    if (paramContext != null) {
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
    }
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public Integer a()
  {
    return this.jdField_b_of_type_JavaLangInteger;
  }
  
  public float b()
  {
    return this.jdField_b_of_type_Float;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atzt
 * JD-Core Version:    0.7.0.1
 */