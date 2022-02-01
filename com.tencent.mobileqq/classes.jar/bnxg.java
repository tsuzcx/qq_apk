import java.lang.ref.WeakReference;

public class bnxg
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static int jdField_b_of_type_Int;
  private static bnxg jdField_b_of_type_Bnxg;
  public int a;
  private bnxg jdField_a_of_type_Bnxg;
  public String a;
  public WeakReference<bnxh> a;
  public String b;
  public String c;
  public String d;
  
  public bnxg(String paramString1, int paramInt, String paramString2, WeakReference<bnxh> paramWeakReference)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + " " + paramString2);
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  public static bnxg a(String paramString1, int paramInt, String paramString2, WeakReference<bnxh> paramWeakReference)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Bnxg != null)
      {
        bnxg localbnxg = jdField_b_of_type_Bnxg;
        jdField_b_of_type_Bnxg = localbnxg.jdField_a_of_type_Bnxg;
        localbnxg.jdField_a_of_type_Bnxg = null;
        localbnxg.jdField_b_of_type_JavaLangString = paramString1;
        localbnxg.d = paramString2;
        localbnxg.jdField_a_of_type_Int = paramInt;
        localbnxg.jdField_a_of_type_JavaLangString = (paramString1 + " " + paramString2);
        localbnxg.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
        jdField_b_of_type_Int -= 1;
        return localbnxg;
      }
      return new bnxg(paramString1, paramInt, paramString2, paramWeakReference);
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
        this.jdField_a_of_type_Bnxg = jdField_b_of_type_Bnxg;
        jdField_b_of_type_Bnxg = this;
        jdField_b_of_type_Int += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnxg
 * JD-Core Version:    0.7.0.1
 */