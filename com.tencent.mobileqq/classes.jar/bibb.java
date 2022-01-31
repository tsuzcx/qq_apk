import java.lang.ref.WeakReference;

public class bibb
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static int jdField_b_of_type_Int;
  private static bibb jdField_b_of_type_Bibb;
  public int a;
  private bibb jdField_a_of_type_Bibb;
  public String a;
  public WeakReference<bibc> a;
  public String b;
  public String c;
  public String d;
  
  public bibb(String paramString1, int paramInt, String paramString2, WeakReference<bibc> paramWeakReference)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + " " + paramString2);
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  public static bibb a(String paramString1, int paramInt, String paramString2, WeakReference<bibc> paramWeakReference)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Bibb != null)
      {
        bibb localbibb = jdField_b_of_type_Bibb;
        jdField_b_of_type_Bibb = localbibb.jdField_a_of_type_Bibb;
        localbibb.jdField_a_of_type_Bibb = null;
        localbibb.jdField_b_of_type_JavaLangString = paramString1;
        localbibb.d = paramString2;
        localbibb.jdField_a_of_type_Int = paramInt;
        localbibb.jdField_a_of_type_JavaLangString = (paramString1 + " " + paramString2);
        localbibb.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
        jdField_b_of_type_Int -= 1;
        return localbibb;
      }
      return new bibb(paramString1, paramInt, paramString2, paramWeakReference);
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
        this.jdField_a_of_type_Bibb = jdField_b_of_type_Bibb;
        jdField_b_of_type_Bibb = this;
        jdField_b_of_type_Int += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bibb
 * JD-Core Version:    0.7.0.1
 */