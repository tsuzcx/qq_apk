import com.tencent.mobileqq.utils.StringUtil;

public class aseq
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = true;
  int b;
  int c = 0;
  
  public aseq(int paramInt)
  {
    this(paramInt, null);
  }
  
  public aseq(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    if (paramInt == this.jdField_a_of_type_Int)
    {
      paramInt = 1;
      if (!StringUtil.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label40;
      }
    }
    label40:
    for (boolean bool = StringUtil.isEmpty(paramString);; bool = this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString))
    {
      if ((paramInt == 0) || (!bool)) {
        break label52;
      }
      return true;
      paramInt = 0;
      break;
    }
    label52:
    return false;
  }
  
  public boolean a(aseq paramaseq)
  {
    if (paramaseq == null) {
      return false;
    }
    return a(paramaseq.jdField_a_of_type_Int, paramaseq.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aseq
 * JD-Core Version:    0.7.0.1
 */