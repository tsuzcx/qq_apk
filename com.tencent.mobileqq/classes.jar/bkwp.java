import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class bkwp
{
  public String a;
  public String b = "null";
  public String c = "null";
  
  public bkwp(@NonNull String paramString)
  {
    this.a = paramString;
  }
  
  public bkwp(@NonNull String paramString1, @Nullable String paramString2, @Nullable String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  @NonNull
  public String toString()
  {
    return "cmd=" + this.a + ", state=" + this.b + ", result=" + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkwp
 * JD-Core Version:    0.7.0.1
 */