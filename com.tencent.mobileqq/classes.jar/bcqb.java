import java.util.List;

public class bcqb
{
  public int a;
  public long a;
  public String a;
  public List<String> a;
  public boolean a;
  public int b = 0;
  public String b;
  
  public String a(int paramInt)
  {
    if ((this.a == null) || (this.a.size() == 0)) {
      return "";
    }
    if (paramInt < this.a.size()) {
      return (String)this.a.get(paramInt);
    }
    return (String)this.a.get(this.a.size() - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcqb
 * JD-Core Version:    0.7.0.1
 */