import com.tencent.mobileqq.listentogether.ListenTogetherManager;

public class awme
  implements awoc
{
  public Object a;
  
  private awme(ListenTogetherManager paramListenTogetherManager)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangObject == null) {}
    while (paramInt == 0) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awme
 * JD-Core Version:    0.7.0.1
 */