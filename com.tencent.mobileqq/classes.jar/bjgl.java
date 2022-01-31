import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.List;

public class bjgl
{
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int;
  Typeface jdField_a_of_type_AndroidGraphicsTypeface = null;
  ArrayList<bjgh> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float = 0.0F;
  int jdField_b_of_type_Int = 0;
  boolean jdField_b_of_type_Boolean = false;
  float jdField_c_of_type_Float = 0.0F;
  int jdField_c_of_type_Int = 0;
  float d = 0.0F;
  
  public bjgl()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public bjgj a(int paramInt, List<String> paramList)
  {
    bjgj localbjgj = new bjgj(paramInt, paramList);
    localbjgj.jdField_a_of_type_JavaUtilArrayList.clear();
    localbjgj.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    if (this.jdField_a_of_type_AndroidGraphicsTypeface != null) {
      localbjgj.a(this.jdField_a_of_type_AndroidGraphicsTypeface);
    }
    localbjgj.a(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Boolean) {
      bjgj.a(localbjgj, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, this.jdField_b_of_type_Int);
    }
    bjgj.a(localbjgj, this.jdField_b_of_type_Boolean, this.d, this.jdField_c_of_type_Int);
    if (!paramList.isEmpty()) {
      localbjgj.a(0, (String)paramList.get(0));
    }
    return localbjgj;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Typeface paramTypeface)
  {
    this.jdField_a_of_type_AndroidGraphicsTypeface = paramTypeface;
  }
  
  public void a(bjgh parambjgh)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(parambjgh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjgl
 * JD-Core Version:    0.7.0.1
 */