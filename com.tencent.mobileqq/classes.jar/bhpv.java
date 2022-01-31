import java.lang.ref.WeakReference;

public class bhpv
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static int jdField_b_of_type_Int;
  private static bhpv jdField_b_of_type_Bhpv;
  public int a;
  private bhpv jdField_a_of_type_Bhpv;
  public String a;
  public WeakReference<bhpu> a;
  public String b;
  public String c;
  public String d;
  
  public bhpv(int paramInt, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = (paramInt + " " + paramString);
  }
  
  public static bhpv a(int paramInt, String paramString)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Bhpv != null)
      {
        bhpv localbhpv = jdField_b_of_type_Bhpv;
        jdField_b_of_type_Bhpv = localbhpv.jdField_a_of_type_Bhpv;
        localbhpv.jdField_a_of_type_Bhpv = null;
        localbhpv.jdField_a_of_type_JavaLangString = (paramInt + " " + paramString);
        localbhpv.jdField_a_of_type_Int = paramInt;
        jdField_b_of_type_Int -= 1;
        return localbhpv;
      }
      return new bhpv(paramInt, paramString);
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
        this.jdField_a_of_type_Bhpv = jdField_b_of_type_Bhpv;
        jdField_b_of_type_Bhpv = this;
        jdField_b_of_type_Int += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhpv
 * JD-Core Version:    0.7.0.1
 */