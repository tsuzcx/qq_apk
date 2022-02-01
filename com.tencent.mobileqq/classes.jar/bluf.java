import java.util.concurrent.CountDownLatch;

public class bluf
{
  private final String jdField_a_of_type_JavaLangString;
  private final CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch;
  private volatile String b;
  private volatile String c;
  
  private bluf(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bluf
 * JD-Core Version:    0.7.0.1
 */