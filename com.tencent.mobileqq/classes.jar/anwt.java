import dov.com.qq.im.capture.text.MidNightTextItem;

public class anwt
{
  public int a;
  public String a;
  public int b = 0;
  
  private anwt(MidNightTextItem paramMidNightTextItem)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (anwt)paramObject;
      if ((this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int) || (this.b != paramObject.b)) {
        break;
      }
      if (this.jdField_a_of_type_JavaLangString == null) {
        break label74;
      }
    } while (this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString));
    label74:
    while (paramObject.jdField_a_of_type_JavaLangString != null) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int j = this.jdField_a_of_type_Int;
    int k = this.b;
    if (this.jdField_a_of_type_JavaLangString != null) {}
    for (int i = this.jdField_a_of_type_JavaLangString.hashCode();; i = 0) {
      return i + (j * 31 + k) * 31;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anwt
 * JD-Core Version:    0.7.0.1
 */