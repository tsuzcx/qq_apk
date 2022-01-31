import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.List;

public class bhlt
{
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int;
  Typeface jdField_a_of_type_AndroidGraphicsTypeface = null;
  ArrayList<bhlp> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float = 0.0F;
  int jdField_b_of_type_Int = 0;
  boolean jdField_b_of_type_Boolean = false;
  float jdField_c_of_type_Float = 0.0F;
  int jdField_c_of_type_Int = 0;
  float d = 0.0F;
  
  public bhlt()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public bhlr a(int paramInt, List<String> paramList)
  {
    bhlr localbhlr = new bhlr(paramInt, paramList);
    localbhlr.jdField_a_of_type_JavaUtilArrayList.clear();
    localbhlr.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    if (this.jdField_a_of_type_AndroidGraphicsTypeface != null) {
      localbhlr.a(this.jdField_a_of_type_AndroidGraphicsTypeface);
    }
    localbhlr.a(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Boolean) {
      bhlr.a(localbhlr, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, this.jdField_b_of_type_Int);
    }
    bhlr.a(localbhlr, this.jdField_b_of_type_Boolean, this.d, this.jdField_c_of_type_Int);
    if (!paramList.isEmpty()) {
      localbhlr.a(0, (String)paramList.get(0));
    }
    return localbhlr;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Typeface paramTypeface)
  {
    this.jdField_a_of_type_AndroidGraphicsTypeface = paramTypeface;
  }
  
  public void a(bhlp parambhlp)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(parambhlp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhlt
 * JD-Core Version:    0.7.0.1
 */