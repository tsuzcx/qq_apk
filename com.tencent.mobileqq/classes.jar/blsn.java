import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.List;

public class blsn
{
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int;
  Typeface jdField_a_of_type_AndroidGraphicsTypeface = null;
  ArrayList<blsj> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float = 0.0F;
  int jdField_b_of_type_Int = 0;
  boolean jdField_b_of_type_Boolean = false;
  float jdField_c_of_type_Float = 0.0F;
  int jdField_c_of_type_Int = 0;
  float d = 0.0F;
  
  public blsn()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public blsl a(int paramInt, List<String> paramList)
  {
    blsl localblsl = new blsl(paramInt, paramList);
    localblsl.jdField_a_of_type_JavaUtilArrayList.clear();
    localblsl.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    if (this.jdField_a_of_type_AndroidGraphicsTypeface != null) {
      localblsl.a(this.jdField_a_of_type_AndroidGraphicsTypeface);
    }
    localblsl.a(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Boolean) {
      blsl.a(localblsl, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, this.jdField_b_of_type_Int);
    }
    blsl.a(localblsl, this.jdField_b_of_type_Boolean, this.d, this.jdField_c_of_type_Int);
    if (!paramList.isEmpty()) {
      localblsl.a(0, (String)paramList.get(0));
    }
    return localblsl;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Typeface paramTypeface)
  {
    this.jdField_a_of_type_AndroidGraphicsTypeface = paramTypeface;
  }
  
  public void a(blsj paramblsj)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramblsj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blsn
 * JD-Core Version:    0.7.0.1
 */