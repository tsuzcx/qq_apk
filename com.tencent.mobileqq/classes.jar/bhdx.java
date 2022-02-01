public class bhdx
{
  public final String a;
  public final String b;
  public final String c;
  
  public bhdx()
  {
    this.a = "0";
    this.b = "";
    this.c = "";
  }
  
  public bhdx(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (bhdx)paramObject;
    return this.b.equals(paramObject.b);
  }
  
  public String toString()
  {
    return "WallpaperConfig{itemId='" + this.a + '\'' + ", imgPath='" + this.b + '\'' + ", videoPath='" + this.c + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhdx
 * JD-Core Version:    0.7.0.1
 */