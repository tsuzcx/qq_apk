import java.lang.ref.WeakReference;

public class bggk
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static int jdField_b_of_type_Int;
  private static bggk jdField_b_of_type_Bggk;
  public int a;
  private bggk jdField_a_of_type_Bggk;
  public String a;
  public WeakReference<bggj> a;
  public String b;
  public String c;
  public String d;
  
  public bggk(int paramInt, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = (paramInt + " " + paramString);
  }
  
  public static bggk a(int paramInt, String paramString)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Bggk != null)
      {
        bggk localbggk = jdField_b_of_type_Bggk;
        jdField_b_of_type_Bggk = localbggk.jdField_a_of_type_Bggk;
        localbggk.jdField_a_of_type_Bggk = null;
        localbggk.jdField_a_of_type_JavaLangString = (paramInt + " " + paramString);
        localbggk.jdField_a_of_type_Int = paramInt;
        jdField_b_of_type_Int -= 1;
        return localbggk;
      }
      return new bggk(paramInt, paramString);
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
        this.jdField_a_of_type_Bggk = jdField_b_of_type_Bggk;
        jdField_b_of_type_Bggk = this;
        jdField_b_of_type_Int += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bggk
 * JD-Core Version:    0.7.0.1
 */