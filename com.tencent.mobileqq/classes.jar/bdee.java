import androidx.annotation.Nullable;

public class bdee
{
  public String a;
  public String b;
  
  public bdee(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof bdee)) {
        return false;
      }
      paramObject = (bdee)paramObject;
    } while ((bdfn.a(this.a, paramObject.a)) && (bdfn.a(this.b, paramObject.b)));
    return false;
  }
  
  public String toString()
  {
    return "AText{text='" + this.a + '\'' + ", attribs='" + this.b + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdee
 * JD-Core Version:    0.7.0.1
 */