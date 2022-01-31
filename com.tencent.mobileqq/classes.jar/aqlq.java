import java.util.ArrayList;

public abstract class aqlq
  implements aqlr
{
  protected long a;
  protected ArrayList<aqlr> a;
  protected boolean a;
  public boolean b = true;
  
  public aqlq()
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
  
  public void a(aqlr paramaqlr)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramaqlr)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramaqlr);
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
 * Qualified Name:     aqlq
 * JD-Core Version:    0.7.0.1
 */