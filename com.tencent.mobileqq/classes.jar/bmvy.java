import java.lang.ref.WeakReference;

public class bmvy
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static int jdField_b_of_type_Int;
  private static bmvy jdField_b_of_type_Bmvy;
  public int a;
  private bmvy jdField_a_of_type_Bmvy;
  public String a;
  public WeakReference<bmvz> a;
  public String b;
  public String c;
  public String d;
  
  public bmvy(String paramString1, int paramInt, String paramString2, WeakReference<bmvz> paramWeakReference)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + " " + paramString2);
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  public static bmvy a(String paramString1, int paramInt, String paramString2, WeakReference<bmvz> paramWeakReference)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Bmvy != null)
      {
        bmvy localbmvy = jdField_b_of_type_Bmvy;
        jdField_b_of_type_Bmvy = localbmvy.jdField_a_of_type_Bmvy;
        localbmvy.jdField_a_of_type_Bmvy = null;
        localbmvy.jdField_b_of_type_JavaLangString = paramString1;
        localbmvy.d = paramString2;
        localbmvy.jdField_a_of_type_Int = paramInt;
        localbmvy.jdField_a_of_type_JavaLangString = (paramString1 + " " + paramString2);
        localbmvy.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
        jdField_b_of_type_Int -= 1;
        return localbmvy;
      }
      return new bmvy(paramString1, paramInt, paramString2, paramWeakReference);
    }
  }
  
  private void b()
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.c = null;
    this.d = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
  
  public void a()
  {
    b();
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Int < 100)
      {
        this.jdField_a_of_type_Bmvy = jdField_b_of_type_Bmvy;
        jdField_b_of_type_Bmvy = this;
        jdField_b_of_type_Int += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmvy
 * JD-Core Version:    0.7.0.1
 */