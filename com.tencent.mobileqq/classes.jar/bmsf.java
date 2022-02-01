public final class bmsf
{
  private static final bmsf jdField_a_of_type_Bmsf = new bmsf();
  private static volatile bmsi jdField_a_of_type_Bmsi = new bmsh(null);
  private static volatile boolean jdField_a_of_type_Boolean = true;
  private Throwable jdField_a_of_type_JavaLangThrowable;
  
  public static bmsf a()
  {
    if (!jdField_a_of_type_Boolean) {
      return jdField_a_of_type_Bmsf;
    }
    return new bmsf();
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
    if ((this == jdField_a_of_type_Bmsf) || (!jdField_a_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_JavaLangThrowable = new Throwable("Explicit termination method '" + paramString + "' not called");
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaLangThrowable == null) || (!jdField_a_of_type_Boolean)) {
      return;
    }
    jdField_a_of_type_Bmsi.a("A resource was acquired at attached stack trace but never released. See java.io.Closeable for information on avoiding resource leaks.", this.jdField_a_of_type_JavaLangThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmsf
 * JD-Core Version:    0.7.0.1
 */