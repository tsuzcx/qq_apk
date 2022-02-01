import java.util.ArrayList;
import java.util.List;

public class bemi
{
  int jdField_a_of_type_Int = 0;
  char[] jdField_a_of_type_ArrayOfChar;
  
  private int a()
  {
    int i = 0;
    while (this.jdField_a_of_type_Int + i < this.jdField_a_of_type_ArrayOfChar.length)
    {
      int j = this.jdField_a_of_type_ArrayOfChar[(this.jdField_a_of_type_Int + i)];
      if (((j < 48) || (j > 57)) && ((j < 97) || (j > 122))) {
        break;
      }
      i += 1;
    }
    return i;
  }
  
  List<bemg> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_ArrayOfChar = paramString.toCharArray();
    bemg localbemg = new bemg();
    StringBuilder localStringBuilder = new StringBuilder();
    while (this.jdField_a_of_type_Int < this.jdField_a_of_type_ArrayOfChar.length)
    {
      int i;
      switch (this.jdField_a_of_type_ArrayOfChar[this.jdField_a_of_type_Int])
      {
      default: 
        this.jdField_a_of_type_Int += 1;
        localbemg.a();
        break;
      case '*': 
        this.jdField_a_of_type_Int += 1;
        i = a();
        if (i == 0) {
          localbemg.a();
        }
        for (;;)
        {
          this.jdField_a_of_type_Int = (i + this.jdField_a_of_type_Int);
          break;
          localStringBuilder.append(paramString.substring(this.jdField_a_of_type_Int - 1, this.jdField_a_of_type_Int + i));
        }
      case '|': 
        this.jdField_a_of_type_Int += 1;
        i = a();
        if (i == 0) {
          localbemg.a();
        }
        for (;;)
        {
          this.jdField_a_of_type_Int = (i + this.jdField_a_of_type_Int);
          break;
          localbemg.b = belm.a(paramString.substring(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + i));
        }
      case '+': 
      case '-': 
      case '=': 
        localbemg.jdField_a_of_type_Char = this.jdField_a_of_type_ArrayOfChar[this.jdField_a_of_type_Int];
        this.jdField_a_of_type_Int += 1;
        i = a();
        if (i == 0) {
          localbemg.a();
        }
        for (;;)
        {
          this.jdField_a_of_type_Int = (i + this.jdField_a_of_type_Int);
          break;
          localbemg.jdField_a_of_type_Int = belm.a(paramString.substring(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + i));
          localbemg.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
          localArrayList.add(localbemg);
          localStringBuilder.delete(0, localStringBuilder.length());
          localbemg = new bemg();
        }
      case '?': 
        throw new IllegalArgumentException("Hit error opcode in op stream: " + paramString);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bemi
 * JD-Core Version:    0.7.0.1
 */