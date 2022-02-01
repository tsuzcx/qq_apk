import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.List;

public class bokw
{
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int;
  Typeface jdField_a_of_type_AndroidGraphicsTypeface = null;
  ArrayList<boks> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float = 0.0F;
  int jdField_b_of_type_Int = 0;
  boolean jdField_b_of_type_Boolean = false;
  float jdField_c_of_type_Float = 0.0F;
  int jdField_c_of_type_Int = 0;
  float d = 0.0F;
  
  public bokw()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public boku a(int paramInt, List<String> paramList)
  {
    boku localboku = new boku(paramInt, paramList);
    localboku.jdField_a_of_type_JavaUtilArrayList.clear();
    localboku.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    if (this.jdField_a_of_type_AndroidGraphicsTypeface != null) {
      localboku.a(this.jdField_a_of_type_AndroidGraphicsTypeface);
    }
    localboku.a(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Boolean) {
      boku.a(localboku, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, this.jdField_b_of_type_Int);
    }
    boku.a(localboku, this.jdField_b_of_type_Boolean, this.d, this.jdField_c_of_type_Int);
    if (!paramList.isEmpty()) {
      localboku.a(0, (String)paramList.get(0));
    }
    return localboku;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Typeface paramTypeface)
  {
    this.jdField_a_of_type_AndroidGraphicsTypeface = paramTypeface;
  }
  
  public void a(boks paramboks)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramboks);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bokw
 * JD-Core Version:    0.7.0.1
 */