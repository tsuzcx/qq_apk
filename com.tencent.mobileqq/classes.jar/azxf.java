import androidx.annotation.NonNull;

public class azxf
{
  public String a = "";
  public String b = "";
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("oriUrl").append("=").append(this.a).append("|");
    localStringBuilder.append("mediumUrl").append("=").append(this.b).append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azxf
 * JD-Core Version:    0.7.0.1
 */