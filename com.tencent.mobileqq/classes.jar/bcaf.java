public class bcaf
{
  public String a;
  public boolean a;
  public boolean b = true;
  public boolean c = true;
  public boolean d = false;
  public boolean e = true;
  
  public bcaf(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, String paramString)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramBoolean3;
    this.d = paramBoolean4;
    this.e = paramBoolean5;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static bcaf a()
  {
    return new bcaf(true, false, true, true, true, null);
  }
  
  public static bcaf a(String paramString)
  {
    return new bcaf(false, true, true, false, true, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcaf
 * JD-Core Version:    0.7.0.1
 */