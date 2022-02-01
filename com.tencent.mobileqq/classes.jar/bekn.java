import androidx.annotation.Nullable;

public class bekn
{
  public String a;
  public String b;
  
  public bekn(String paramString1, String paramString2)
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
      if (!(paramObject instanceof bekn)) {
        return false;
      }
      paramObject = (bekn)paramObject;
    } while ((belw.a(this.a, paramObject.a)) && (belw.a(this.b, paramObject.b)));
    return false;
  }
  
  public String toString()
  {
    return "AText{text='" + this.a + '\'' + ", attribs='" + this.b + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bekn
 * JD-Core Version:    0.7.0.1
 */