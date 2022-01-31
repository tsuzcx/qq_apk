import com.tencent.mobileqq.listentogether.ListenTogetherManager;

public class arrg
  implements arte
{
  public Object a;
  
  private arrg(ListenTogetherManager paramListenTogetherManager)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arrg
 * JD-Core Version:    0.7.0.1
 */