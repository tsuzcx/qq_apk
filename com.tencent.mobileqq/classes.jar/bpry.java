import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.List;

public class bpry
{
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int;
  Typeface jdField_a_of_type_AndroidGraphicsTypeface = null;
  ArrayList<bpru> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float = 0.0F;
  int jdField_b_of_type_Int = 0;
  boolean jdField_b_of_type_Boolean = false;
  float jdField_c_of_type_Float = 0.0F;
  int jdField_c_of_type_Int = 0;
  float d = 0.0F;
  
  public bpry()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public bprw a(int paramInt, List<String> paramList)
  {
    bprw localbprw = new bprw(paramInt, paramList);
    localbprw.jdField_a_of_type_JavaUtilArrayList.clear();
    localbprw.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    if (this.jdField_a_of_type_AndroidGraphicsTypeface != null) {
      localbprw.a(this.jdField_a_of_type_AndroidGraphicsTypeface);
    }
    localbprw.a(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Boolean) {
      bprw.a(localbprw, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, this.jdField_b_of_type_Int);
    }
    bprw.a(localbprw, this.jdField_b_of_type_Boolean, this.d, this.jdField_c_of_type_Int);
    if (!paramList.isEmpty()) {
      localbprw.a(0, (String)paramList.get(0));
    }
    return localbprw;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Typeface paramTypeface)
  {
    this.jdField_a_of_type_AndroidGraphicsTypeface = paramTypeface;
  }
  
  public void a(bpru parambpru)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(parambpru);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpry
 * JD-Core Version:    0.7.0.1
 */