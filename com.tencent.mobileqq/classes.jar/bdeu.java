import com.tencent.util.Pair;
import java.util.List;

public class bdeu
{
  int jdField_a_of_type_Int;
  bdfd jdField_a_of_type_Bdfd = new bdfd();
  bdfg jdField_a_of_type_Bdfg = new bdfg();
  StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  
  public bdeu(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public bdeu a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Bdfd.jdField_a_of_type_Char = '=';
    this.jdField_a_of_type_Bdfd.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Bdfd.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Bdfd.b = Math.max(paramInt2, 0);
    this.jdField_a_of_type_Bdfg.a(this.jdField_a_of_type_Bdfd);
    return this;
  }
  
  public bdeu a(String paramString, List<Pair<String, String>> paramList, bdef parambdef)
  {
    this.jdField_a_of_type_Bdfg.a('+', paramString, paramList, parambdef);
    this.jdField_a_of_type_JavaLangStringBuilder.append(paramString);
    return this;
  }
  
  public bdeu b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Bdfd.jdField_a_of_type_Char = '-';
    this.jdField_a_of_type_Bdfd.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Bdfd.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Bdfd.b = paramInt2;
    this.jdField_a_of_type_Bdfg.a(this.jdField_a_of_type_Bdfd);
    return this;
  }
  
  public String toString()
  {
    this.jdField_a_of_type_Bdfg.a();
    int i = this.jdField_a_of_type_Int;
    int j = this.jdField_a_of_type_Bdfg.a();
    return bdej.a(this.jdField_a_of_type_Int, i + j, this.jdField_a_of_type_Bdfg.toString(), this.jdField_a_of_type_JavaLangStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdeu
 * JD-Core Version:    0.7.0.1
 */