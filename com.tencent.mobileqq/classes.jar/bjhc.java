import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.List;

public class bjhc
{
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int;
  Typeface jdField_a_of_type_AndroidGraphicsTypeface = null;
  ArrayList<bjgy> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float = 0.0F;
  int jdField_b_of_type_Int = 0;
  boolean jdField_b_of_type_Boolean = false;
  float jdField_c_of_type_Float = 0.0F;
  int jdField_c_of_type_Int = 0;
  float d = 0.0F;
  
  public bjhc()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public bjha a(int paramInt, List<String> paramList)
  {
    bjha localbjha = new bjha(paramInt, paramList);
    localbjha.jdField_a_of_type_JavaUtilArrayList.clear();
    localbjha.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    if (this.jdField_a_of_type_AndroidGraphicsTypeface != null) {
      localbjha.a(this.jdField_a_of_type_AndroidGraphicsTypeface);
    }
    localbjha.a(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Boolean) {
      bjha.a(localbjha, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, this.jdField_b_of_type_Int);
    }
    bjha.a(localbjha, this.jdField_b_of_type_Boolean, this.d, this.jdField_c_of_type_Int);
    if (!paramList.isEmpty()) {
      localbjha.a(0, (String)paramList.get(0));
    }
    return localbjha;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Typeface paramTypeface)
  {
    this.jdField_a_of_type_AndroidGraphicsTypeface = paramTypeface;
  }
  
  public void a(bjgy parambjgy)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(parambjgy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjhc
 * JD-Core Version:    0.7.0.1
 */