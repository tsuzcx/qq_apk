import java.lang.ref.WeakReference;

public class bjvn
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static int jdField_b_of_type_Int;
  private static bjvn jdField_b_of_type_Bjvn;
  public int a;
  private bjvn jdField_a_of_type_Bjvn;
  public String a;
  public WeakReference<bjvm> a;
  public String b;
  public String c;
  public String d;
  
  public bjvn(int paramInt, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = (paramInt + " " + paramString);
  }
  
  public static bjvn a(int paramInt, String paramString)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Bjvn != null)
      {
        bjvn localbjvn = jdField_b_of_type_Bjvn;
        jdField_b_of_type_Bjvn = localbjvn.jdField_a_of_type_Bjvn;
        localbjvn.jdField_a_of_type_Bjvn = null;
        localbjvn.jdField_a_of_type_JavaLangString = (paramInt + " " + paramString);
        localbjvn.jdField_a_of_type_Int = paramInt;
        jdField_b_of_type_Int -= 1;
        return localbjvn;
      }
      return new bjvn(paramInt, paramString);
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
        this.jdField_a_of_type_Bjvn = jdField_b_of_type_Bjvn;
        jdField_b_of_type_Bjvn = this;
        jdField_b_of_type_Int += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjvn
 * JD-Core Version:    0.7.0.1
 */