import androidx.annotation.Nullable;

public class belh
{
  public String a;
  public String b;
  
  public belh(String paramString1, String paramString2)
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
      if (!(paramObject instanceof belh)) {
        return false;
      }
      paramObject = (belh)paramObject;
    } while ((bemq.a(this.a, paramObject.a)) && (bemq.a(this.b, paramObject.b)));
    return false;
  }
  
  public String toString()
  {
    return "AText{text='" + this.a + '\'' + ", attribs='" + this.b + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     belh
 * JD-Core Version:    0.7.0.1
 */