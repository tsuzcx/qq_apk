import java.lang.ref.WeakReference;

public class bmpd
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static int jdField_b_of_type_Int;
  private static bmpd jdField_b_of_type_Bmpd;
  public int a;
  private bmpd jdField_a_of_type_Bmpd;
  public String a;
  public WeakReference<bmpe> a;
  public String b;
  public String c;
  public String d;
  
  public bmpd(String paramString1, int paramInt, String paramString2, WeakReference<bmpe> paramWeakReference)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + " " + paramString2);
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  public static bmpd a(String paramString1, int paramInt, String paramString2, WeakReference<bmpe> paramWeakReference)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Bmpd != null)
      {
        bmpd localbmpd = jdField_b_of_type_Bmpd;
        jdField_b_of_type_Bmpd = localbmpd.jdField_a_of_type_Bmpd;
        localbmpd.jdField_a_of_type_Bmpd = null;
        localbmpd.jdField_b_of_type_JavaLangString = paramString1;
        localbmpd.d = paramString2;
        localbmpd.jdField_a_of_type_Int = paramInt;
        localbmpd.jdField_a_of_type_JavaLangString = (paramString1 + " " + paramString2);
        localbmpd.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
        jdField_b_of_type_Int -= 1;
        return localbmpd;
      }
      return new bmpd(paramString1, paramInt, paramString2, paramWeakReference);
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
        this.jdField_a_of_type_Bmpd = jdField_b_of_type_Bmpd;
        jdField_b_of_type_Bmpd = this;
        jdField_b_of_type_Int += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmpd
 * JD-Core Version:    0.7.0.1
 */