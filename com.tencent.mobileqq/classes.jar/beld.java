import com.tencent.util.Pair;
import java.util.List;

public class beld
{
  int jdField_a_of_type_Int;
  belm jdField_a_of_type_Belm = new belm();
  belp jdField_a_of_type_Belp = new belp();
  StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  
  public beld(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public beld a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Belm.jdField_a_of_type_Char = '=';
    this.jdField_a_of_type_Belm.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Belm.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Belm.b = Math.max(paramInt2, 0);
    this.jdField_a_of_type_Belp.a(this.jdField_a_of_type_Belm);
    return this;
  }
  
  public beld a(String paramString, List<Pair<String, String>> paramList, beko parambeko)
  {
    this.jdField_a_of_type_Belp.a('+', paramString, paramList, parambeko);
    this.jdField_a_of_type_JavaLangStringBuilder.append(paramString);
    return this;
  }
  
  public beld b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Belm.jdField_a_of_type_Char = '-';
    this.jdField_a_of_type_Belm.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Belm.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Belm.b = paramInt2;
    this.jdField_a_of_type_Belp.a(this.jdField_a_of_type_Belm);
    return this;
  }
  
  public String toString()
  {
    this.jdField_a_of_type_Belp.a();
    int i = this.jdField_a_of_type_Int;
    int j = this.jdField_a_of_type_Belp.a();
    return beks.a(this.jdField_a_of_type_Int, i + j, this.jdField_a_of_type_Belp.toString(), this.jdField_a_of_type_JavaLangStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beld
 * JD-Core Version:    0.7.0.1
 */