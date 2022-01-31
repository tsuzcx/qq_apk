import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class avzf
{
  private String a;
  private String b;
  
  public avzf(@Nullable String paramString1, @Nullable String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  @NonNull
  public String a()
  {
    return this.a;
  }
  
  @NonNull
  public String b()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof avzf)) {}
    do
    {
      return false;
      paramObject = (avzf)paramObject;
    } while ((baip.a(this.a)) || (baip.a(this.b)) || (!this.a.equals(paramObject.a())) || (!this.b.equals(paramObject.b())));
    return true;
  }
  
  public int hashCode()
  {
    int j = 0;
    int i;
    if (this.b == null)
    {
      i = 0;
      if (this.a != null) {
        break label40;
      }
    }
    for (;;)
    {
      return (i + 527) * 31 + j;
      i = this.b.hashCode();
      break;
      label40:
      j = this.a.hashCode();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avzf
 * JD-Core Version:    0.7.0.1
 */