import java.util.Random;

public class bmhd
  extends bmhn
{
  protected int a;
  protected Random a;
  
  public bmhd(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilRandom = new Random(System.currentTimeMillis());
    this.jdField_a_of_type_Int = 1;
    a(paramInt);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 1) {
      i = 1;
    }
    this.jdField_a_of_type_Int = i;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilRandom.nextInt(this.jdField_a_of_type_Int) < 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmhd
 * JD-Core Version:    0.7.0.1
 */