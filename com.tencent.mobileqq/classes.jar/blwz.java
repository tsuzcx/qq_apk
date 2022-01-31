import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.List;

public class blwz
{
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int;
  Typeface jdField_a_of_type_AndroidGraphicsTypeface = null;
  ArrayList<blwv> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float = 0.0F;
  int jdField_b_of_type_Int = 0;
  boolean jdField_b_of_type_Boolean = false;
  float jdField_c_of_type_Float = 0.0F;
  int jdField_c_of_type_Int = 0;
  float d = 0.0F;
  
  public blwz()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public blwx a(int paramInt, List<String> paramList)
  {
    blwx localblwx = new blwx(paramInt, paramList);
    localblwx.jdField_a_of_type_JavaUtilArrayList.clear();
    localblwx.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    if (this.jdField_a_of_type_AndroidGraphicsTypeface != null) {
      localblwx.a(this.jdField_a_of_type_AndroidGraphicsTypeface);
    }
    localblwx.a(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Boolean) {
      blwx.a(localblwx, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, this.jdField_b_of_type_Int);
    }
    blwx.a(localblwx, this.jdField_b_of_type_Boolean, this.d, this.jdField_c_of_type_Int);
    if (!paramList.isEmpty()) {
      localblwx.a(0, (String)paramList.get(0));
    }
    return localblwx;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Typeface paramTypeface)
  {
    this.jdField_a_of_type_AndroidGraphicsTypeface = paramTypeface;
  }
  
  public void a(blwv paramblwv)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramblwv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blwz
 * JD-Core Version:    0.7.0.1
 */