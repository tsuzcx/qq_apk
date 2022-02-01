import android.support.annotation.Nullable;
import com.tencent.mobileqq.utils.StringUtil;

public class blvc
{
  private String a;
  private String b;
  
  public blvc(@Nullable String paramString1, @Nullable String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  @Nullable
  public String a()
  {
    return this.a;
  }
  
  @Nullable
  public String b()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof blvc))) {}
    do
    {
      return false;
      paramObject = (blvc)paramObject;
    } while ((StringUtil.isEmpty(this.a)) || (StringUtil.isEmpty(this.b)) || (paramObject == null) || (!this.a.equals(paramObject.a())) || (!this.b.equals(paramObject.b())));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blvc
 * JD-Core Version:    0.7.0.1
 */