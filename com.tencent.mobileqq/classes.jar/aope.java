public class aope
{
  public String a;
  public String b;
  public String c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("{");
    localStringBuilder.append("nickName:").append(this.a).append(",headID:").append(this.b).append(",headURL:").append(this.c).append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aope
 * JD-Core Version:    0.7.0.1
 */