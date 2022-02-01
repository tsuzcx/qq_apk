import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.List;

public class boqd
{
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int;
  Typeface jdField_a_of_type_AndroidGraphicsTypeface = null;
  ArrayList<bopz> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float = 0.0F;
  int jdField_b_of_type_Int = 0;
  boolean jdField_b_of_type_Boolean = false;
  float jdField_c_of_type_Float = 0.0F;
  int jdField_c_of_type_Int = 0;
  float d = 0.0F;
  
  public boqd()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public boqb a(int paramInt, List<String> paramList)
  {
    boqb localboqb = new boqb(paramInt, paramList);
    localboqb.jdField_a_of_type_JavaUtilArrayList.clear();
    localboqb.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    if (this.jdField_a_of_type_AndroidGraphicsTypeface != null) {
      localboqb.a(this.jdField_a_of_type_AndroidGraphicsTypeface);
    }
    localboqb.a(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Boolean) {
      boqb.a(localboqb, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, this.jdField_b_of_type_Int);
    }
    boqb.a(localboqb, this.jdField_b_of_type_Boolean, this.d, this.jdField_c_of_type_Int);
    if (!paramList.isEmpty()) {
      localboqb.a(0, (String)paramList.get(0));
    }
    return localboqb;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Typeface paramTypeface)
  {
    this.jdField_a_of_type_AndroidGraphicsTypeface = paramTypeface;
  }
  
  public void a(bopz parambopz)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(parambopz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boqd
 * JD-Core Version:    0.7.0.1
 */