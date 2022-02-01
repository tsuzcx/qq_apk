import com.tencent.util.Pair;
import java.util.List;

public class belx
{
  int jdField_a_of_type_Int;
  bemg jdField_a_of_type_Bemg = new bemg();
  bemj jdField_a_of_type_Bemj = new bemj();
  StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  
  public belx(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public belx a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Bemg.jdField_a_of_type_Char = '=';
    this.jdField_a_of_type_Bemg.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Bemg.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Bemg.b = Math.max(paramInt2, 0);
    this.jdField_a_of_type_Bemj.a(this.jdField_a_of_type_Bemg);
    return this;
  }
  
  public belx a(String paramString, List<Pair<String, String>> paramList, beli parambeli)
  {
    this.jdField_a_of_type_Bemj.a('+', paramString, paramList, parambeli);
    this.jdField_a_of_type_JavaLangStringBuilder.append(paramString);
    return this;
  }
  
  public belx b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Bemg.jdField_a_of_type_Char = '-';
    this.jdField_a_of_type_Bemg.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Bemg.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Bemg.b = paramInt2;
    this.jdField_a_of_type_Bemj.a(this.jdField_a_of_type_Bemg);
    return this;
  }
  
  public String toString()
  {
    this.jdField_a_of_type_Bemj.a();
    int i = this.jdField_a_of_type_Int;
    int j = this.jdField_a_of_type_Bemj.a();
    return belm.a(this.jdField_a_of_type_Int, i + j, this.jdField_a_of_type_Bemj.toString(), this.jdField_a_of_type_JavaLangStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     belx
 * JD-Core Version:    0.7.0.1
 */