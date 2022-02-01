import java.lang.ref.WeakReference;

public class bmjx
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static int jdField_b_of_type_Int;
  private static bmjx jdField_b_of_type_Bmjx;
  public int a;
  private bmjx jdField_a_of_type_Bmjx;
  public String a;
  public WeakReference<bmjw> a;
  public String b;
  public String c;
  public String d;
  
  public bmjx(int paramInt, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = (paramInt + " " + paramString);
  }
  
  public static bmjx a(int paramInt, String paramString)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Bmjx != null)
      {
        bmjx localbmjx = jdField_b_of_type_Bmjx;
        jdField_b_of_type_Bmjx = localbmjx.jdField_a_of_type_Bmjx;
        localbmjx.jdField_a_of_type_Bmjx = null;
        localbmjx.jdField_a_of_type_JavaLangString = (paramInt + " " + paramString);
        localbmjx.jdField_a_of_type_Int = paramInt;
        jdField_b_of_type_Int -= 1;
        return localbmjx;
      }
      return new bmjx(paramInt, paramString);
    }
  }
  
  private void b()
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.c = null;
    this.d = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
  
  public void a()
  {
    b();
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Int < 100)
      {
        this.jdField_a_of_type_Bmjx = jdField_b_of_type_Bmjx;
        jdField_b_of_type_Bmjx = this;
        jdField_b_of_type_Int += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmjx
 * JD-Core Version:    0.7.0.1
 */