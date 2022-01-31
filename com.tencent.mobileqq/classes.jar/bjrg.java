import java.lang.ref.WeakReference;

public class bjrg
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static int jdField_b_of_type_Int;
  private static bjrg jdField_b_of_type_Bjrg;
  public int a;
  private bjrg jdField_a_of_type_Bjrg;
  public String a;
  public WeakReference<bjrf> a;
  public String b;
  public String c;
  public String d;
  
  public bjrg(int paramInt, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = (paramInt + " " + paramString);
  }
  
  public static bjrg a(int paramInt, String paramString)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Bjrg != null)
      {
        bjrg localbjrg = jdField_b_of_type_Bjrg;
        jdField_b_of_type_Bjrg = localbjrg.jdField_a_of_type_Bjrg;
        localbjrg.jdField_a_of_type_Bjrg = null;
        localbjrg.jdField_a_of_type_JavaLangString = (paramInt + " " + paramString);
        localbjrg.jdField_a_of_type_Int = paramInt;
        jdField_b_of_type_Int -= 1;
        return localbjrg;
      }
      return new bjrg(paramInt, paramString);
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
        this.jdField_a_of_type_Bjrg = jdField_b_of_type_Bjrg;
        jdField_b_of_type_Bjrg = this;
        jdField_b_of_type_Int += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjrg
 * JD-Core Version:    0.7.0.1
 */