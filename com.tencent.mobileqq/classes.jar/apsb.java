import java.util.ArrayList;

public abstract class apsb
  implements apsc
{
  protected long a;
  protected ArrayList<apsc> a;
  protected boolean a;
  public boolean b = true;
  
  public apsb()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Long = 350L;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = 350L;
  }
  
  public void a(apsc paramapsc)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramapsc)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramapsc);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public abstract boolean b();
  
  public abstract boolean c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apsb
 * JD-Core Version:    0.7.0.1
 */