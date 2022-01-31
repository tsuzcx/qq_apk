public class bgmd
  implements bgmc
{
  private int jdField_a_of_type_Int;
  private Object jdField_a_of_type_JavaLangObject;
  
  public static bgmd a(int paramInt)
  {
    return a(paramInt, null);
  }
  
  public static bgmd a(int paramInt, Object paramObject)
  {
    bgmd localbgmd = new bgmd();
    localbgmd.jdField_a_of_type_Int = paramInt;
    localbgmd.jdField_a_of_type_JavaLangObject = paramObject;
    return localbgmd;
  }
  
  public Object perform(bgls parambgls)
  {
    parambgls.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangObject);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgmd
 * JD-Core Version:    0.7.0.1
 */