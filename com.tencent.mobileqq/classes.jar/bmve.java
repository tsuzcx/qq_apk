import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.List;

public class bmve
{
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int;
  Typeface jdField_a_of_type_AndroidGraphicsTypeface = null;
  ArrayList<bmva> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float = 0.0F;
  int jdField_b_of_type_Int = 0;
  boolean jdField_b_of_type_Boolean = false;
  float jdField_c_of_type_Float = 0.0F;
  int jdField_c_of_type_Int = 0;
  float d = 0.0F;
  
  public bmve()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public bmvc a(int paramInt, List<String> paramList)
  {
    bmvc localbmvc = new bmvc(paramInt, paramList);
    localbmvc.jdField_a_of_type_JavaUtilArrayList.clear();
    localbmvc.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    if (this.jdField_a_of_type_AndroidGraphicsTypeface != null) {
      localbmvc.a(this.jdField_a_of_type_AndroidGraphicsTypeface);
    }
    localbmvc.a(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Boolean) {
      bmvc.a(localbmvc, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, this.jdField_b_of_type_Int);
    }
    bmvc.a(localbmvc, this.jdField_b_of_type_Boolean, this.d, this.jdField_c_of_type_Int);
    if (!paramList.isEmpty()) {
      localbmvc.a(0, (String)paramList.get(0));
    }
    return localbmvc;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Typeface paramTypeface)
  {
    this.jdField_a_of_type_AndroidGraphicsTypeface = paramTypeface;
  }
  
  public void a(bmva parambmva)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(parambmva);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmve
 * JD-Core Version:    0.7.0.1
 */