public final class bjcr
{
  private static final bjcr jdField_a_of_type_Bjcr = new bjcr();
  private static volatile bjcu jdField_a_of_type_Bjcu = new bjct(null);
  private static volatile boolean jdField_a_of_type_Boolean = true;
  private Throwable jdField_a_of_type_JavaLangThrowable;
  
  public static bjcr a()
  {
    if (!jdField_a_of_type_Boolean) {
      return jdField_a_of_type_Bjcr;
    }
    return new bjcr();
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangThrowable = null;
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("closer == null");
    }
    if ((this == jdField_a_of_type_Bjcr) || (!jdField_a_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_JavaLangThrowable = new Throwable("Explicit termination method '" + paramString + "' not called");
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaLangThrowable == null) || (!jdField_a_of_type_Boolean)) {
      return;
    }
    jdField_a_of_type_Bjcu.a("A resource was acquired at attached stack trace but never released. See java.io.Closeable for information on avoiding resource leaks.", this.jdField_a_of_type_JavaLangThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjcr
 * JD-Core Version:    0.7.0.1
 */