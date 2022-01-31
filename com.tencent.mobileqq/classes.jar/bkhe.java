import java.lang.ref.WeakReference;

public class bkhe
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static int jdField_b_of_type_Int;
  private static bkhe jdField_b_of_type_Bkhe;
  public int a;
  private bkhe jdField_a_of_type_Bkhe;
  public String a;
  public WeakReference<bkhf> a;
  public String b;
  public String c;
  public String d;
  
  public bkhe(String paramString1, int paramInt, String paramString2, WeakReference<bkhf> paramWeakReference)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + " " + paramString2);
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  public static bkhe a(String paramString1, int paramInt, String paramString2, WeakReference<bkhf> paramWeakReference)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Bkhe != null)
      {
        bkhe localbkhe = jdField_b_of_type_Bkhe;
        jdField_b_of_type_Bkhe = localbkhe.jdField_a_of_type_Bkhe;
        localbkhe.jdField_a_of_type_Bkhe = null;
        localbkhe.jdField_b_of_type_JavaLangString = paramString1;
        localbkhe.d = paramString2;
        localbkhe.jdField_a_of_type_Int = paramInt;
        localbkhe.jdField_a_of_type_JavaLangString = (paramString1 + " " + paramString2);
        localbkhe.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
        jdField_b_of_type_Int -= 1;
        return localbkhe;
      }
      return new bkhe(paramString1, paramInt, paramString2, paramWeakReference);
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
        this.jdField_a_of_type_Bkhe = jdField_b_of_type_Bkhe;
        jdField_b_of_type_Bkhe = this;
        jdField_b_of_type_Int += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkhe
 * JD-Core Version:    0.7.0.1
 */