import java.lang.ref.WeakReference;

public class blcm
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static int jdField_b_of_type_Int;
  private static blcm jdField_b_of_type_Blcm;
  public int a;
  private blcm jdField_a_of_type_Blcm;
  public String a;
  public WeakReference<blcn> a;
  public String b;
  public String c;
  public String d;
  
  public blcm(String paramString1, int paramInt, String paramString2, WeakReference<blcn> paramWeakReference)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + " " + paramString2);
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  public static blcm a(String paramString1, int paramInt, String paramString2, WeakReference<blcn> paramWeakReference)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Blcm != null)
      {
        blcm localblcm = jdField_b_of_type_Blcm;
        jdField_b_of_type_Blcm = localblcm.jdField_a_of_type_Blcm;
        localblcm.jdField_a_of_type_Blcm = null;
        localblcm.jdField_b_of_type_JavaLangString = paramString1;
        localblcm.d = paramString2;
        localblcm.jdField_a_of_type_Int = paramInt;
        localblcm.jdField_a_of_type_JavaLangString = (paramString1 + " " + paramString2);
        localblcm.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
        jdField_b_of_type_Int -= 1;
        return localblcm;
      }
      return new blcm(paramString1, paramInt, paramString2, paramWeakReference);
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
        this.jdField_a_of_type_Blcm = jdField_b_of_type_Blcm;
        jdField_b_of_type_Blcm = this;
        jdField_b_of_type_Int += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blcm
 * JD-Core Version:    0.7.0.1
 */