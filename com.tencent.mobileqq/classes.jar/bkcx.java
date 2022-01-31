import java.lang.ref.WeakReference;

public class bkcx
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static int jdField_b_of_type_Int;
  private static bkcx jdField_b_of_type_Bkcx;
  public int a;
  private bkcx jdField_a_of_type_Bkcx;
  public String a;
  public WeakReference<bkcy> a;
  public String b;
  public String c;
  public String d;
  
  public bkcx(String paramString1, int paramInt, String paramString2, WeakReference<bkcy> paramWeakReference)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + " " + paramString2);
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  public static bkcx a(String paramString1, int paramInt, String paramString2, WeakReference<bkcy> paramWeakReference)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Bkcx != null)
      {
        bkcx localbkcx = jdField_b_of_type_Bkcx;
        jdField_b_of_type_Bkcx = localbkcx.jdField_a_of_type_Bkcx;
        localbkcx.jdField_a_of_type_Bkcx = null;
        localbkcx.jdField_b_of_type_JavaLangString = paramString1;
        localbkcx.d = paramString2;
        localbkcx.jdField_a_of_type_Int = paramInt;
        localbkcx.jdField_a_of_type_JavaLangString = (paramString1 + " " + paramString2);
        localbkcx.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
        jdField_b_of_type_Int -= 1;
        return localbkcx;
      }
      return new bkcx(paramString1, paramInt, paramString2, paramWeakReference);
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
        this.jdField_a_of_type_Bkcx = jdField_b_of_type_Bkcx;
        jdField_b_of_type_Bkcx = this;
        jdField_b_of_type_Int += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkcx
 * JD-Core Version:    0.7.0.1
 */