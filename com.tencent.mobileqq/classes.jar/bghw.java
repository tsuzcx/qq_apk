public class bghw
  implements bghv
{
  private int jdField_a_of_type_Int;
  private Object jdField_a_of_type_JavaLangObject;
  
  public static bghw a(int paramInt)
  {
    return a(paramInt, null);
  }
  
  public static bghw a(int paramInt, Object paramObject)
  {
    bghw localbghw = new bghw();
    localbghw.jdField_a_of_type_Int = paramInt;
    localbghw.jdField_a_of_type_JavaLangObject = paramObject;
    return localbghw;
  }
  
  public Object perform(bghl parambghl)
  {
    parambghl.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangObject);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bghw
 * JD-Core Version:    0.7.0.1
 */