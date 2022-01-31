import java.lang.ref.WeakReference;

public class bgrl
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static int jdField_b_of_type_Int;
  private static bgrl jdField_b_of_type_Bgrl;
  public int a;
  private bgrl jdField_a_of_type_Bgrl;
  public String a;
  public WeakReference<bgrm> a;
  public String b;
  public String c;
  public String d;
  
  public bgrl(String paramString1, int paramInt, String paramString2, WeakReference<bgrm> paramWeakReference)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + " " + paramString2);
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  public static bgrl a(String paramString1, int paramInt, String paramString2, WeakReference<bgrm> paramWeakReference)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Bgrl != null)
      {
        bgrl localbgrl = jdField_b_of_type_Bgrl;
        jdField_b_of_type_Bgrl = localbgrl.jdField_a_of_type_Bgrl;
        localbgrl.jdField_a_of_type_Bgrl = null;
        localbgrl.jdField_b_of_type_JavaLangString = paramString1;
        localbgrl.d = paramString2;
        localbgrl.jdField_a_of_type_Int = paramInt;
        localbgrl.jdField_a_of_type_JavaLangString = (paramString1 + " " + paramString2);
        localbgrl.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
        jdField_b_of_type_Int -= 1;
        return localbgrl;
      }
      return new bgrl(paramString1, paramInt, paramString2, paramWeakReference);
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
        this.jdField_a_of_type_Bgrl = jdField_b_of_type_Bgrl;
        jdField_b_of_type_Bgrl = this;
        jdField_b_of_type_Int += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgrl
 * JD-Core Version:    0.7.0.1
 */