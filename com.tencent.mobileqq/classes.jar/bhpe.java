import java.lang.ref.WeakReference;

public class bhpe
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static int jdField_b_of_type_Int;
  private static bhpe jdField_b_of_type_Bhpe;
  public int a;
  private bhpe jdField_a_of_type_Bhpe;
  public String a;
  public WeakReference<bhpd> a;
  public String b;
  public String c;
  public String d;
  
  public bhpe(int paramInt, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = (paramInt + " " + paramString);
  }
  
  public static bhpe a(int paramInt, String paramString)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Bhpe != null)
      {
        bhpe localbhpe = jdField_b_of_type_Bhpe;
        jdField_b_of_type_Bhpe = localbhpe.jdField_a_of_type_Bhpe;
        localbhpe.jdField_a_of_type_Bhpe = null;
        localbhpe.jdField_a_of_type_JavaLangString = (paramInt + " " + paramString);
        localbhpe.jdField_a_of_type_Int = paramInt;
        jdField_b_of_type_Int -= 1;
        return localbhpe;
      }
      return new bhpe(paramInt, paramString);
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
        this.jdField_a_of_type_Bhpe = jdField_b_of_type_Bhpe;
        jdField_b_of_type_Bhpe = this;
        jdField_b_of_type_Int += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhpe
 * JD-Core Version:    0.7.0.1
 */