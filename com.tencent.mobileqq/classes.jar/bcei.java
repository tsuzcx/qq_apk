import java.util.ArrayList;
import java.util.List;

public abstract class bcei
  extends bcdy
{
  public List<Integer> b = new ArrayList();
  public int g = 0;
  
  public bcei()
  {
    this.b.add(Integer.valueOf(0));
    this.b.add(Integer.valueOf(3));
    this.b.add(Integer.valueOf(1));
    this.b.add(Integer.valueOf(2));
  }
  
  public int e()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcei
 * JD-Core Version:    0.7.0.1
 */