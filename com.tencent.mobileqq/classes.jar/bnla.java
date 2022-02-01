import java.lang.ref.WeakReference;

public class bnla
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static int jdField_b_of_type_Int;
  private static bnla jdField_b_of_type_Bnla;
  public int a;
  private bnla jdField_a_of_type_Bnla;
  public String a;
  public WeakReference<bnkz> a;
  public String b;
  public String c;
  public String d;
  
  public bnla(int paramInt, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = (paramInt + " " + paramString);
  }
  
  public static bnla a(int paramInt, String paramString)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Bnla != null)
      {
        bnla localbnla = jdField_b_of_type_Bnla;
        jdField_b_of_type_Bnla = localbnla.jdField_a_of_type_Bnla;
        localbnla.jdField_a_of_type_Bnla = null;
        localbnla.jdField_a_of_type_JavaLangString = (paramInt + " " + paramString);
        localbnla.jdField_a_of_type_Int = paramInt;
        jdField_b_of_type_Int -= 1;
        return localbnla;
      }
      return new bnla(paramInt, paramString);
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
        this.jdField_a_of_type_Bnla = jdField_b_of_type_Bnla;
        jdField_b_of_type_Bnla = this;
        jdField_b_of_type_Int += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnla
 * JD-Core Version:    0.7.0.1
 */