import java.lang.ref.WeakReference;

public class biak
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static int jdField_b_of_type_Int;
  private static biak jdField_b_of_type_Biak;
  public int a;
  private biak jdField_a_of_type_Biak;
  public String a;
  public WeakReference<bial> a;
  public String b;
  public String c;
  public String d;
  
  public biak(String paramString1, int paramInt, String paramString2, WeakReference<bial> paramWeakReference)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + " " + paramString2);
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  public static biak a(String paramString1, int paramInt, String paramString2, WeakReference<bial> paramWeakReference)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Biak != null)
      {
        biak localbiak = jdField_b_of_type_Biak;
        jdField_b_of_type_Biak = localbiak.jdField_a_of_type_Biak;
        localbiak.jdField_a_of_type_Biak = null;
        localbiak.jdField_b_of_type_JavaLangString = paramString1;
        localbiak.d = paramString2;
        localbiak.jdField_a_of_type_Int = paramInt;
        localbiak.jdField_a_of_type_JavaLangString = (paramString1 + " " + paramString2);
        localbiak.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
        jdField_b_of_type_Int -= 1;
        return localbiak;
      }
      return new biak(paramString1, paramInt, paramString2, paramWeakReference);
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
        this.jdField_a_of_type_Biak = jdField_b_of_type_Biak;
        jdField_b_of_type_Biak = this;
        jdField_b_of_type_Int += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     biak
 * JD-Core Version:    0.7.0.1
 */