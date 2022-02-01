package android.content.res;

public class XResources$ResourceNames
{
  public final String fullName;
  public final int id;
  public final String name;
  public final String pkg;
  public final String type;
  
  private XResources$ResourceNames(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.id = paramInt;
    this.pkg = paramString1;
    this.name = paramString2;
    this.type = paramString3;
    this.fullName = (paramString1 + ":" + paramString3 + "/" + paramString2);
  }
  
  public boolean equals(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    return ((paramString1 == null) || (paramString1.equals(this.pkg))) && ((paramString2 == null) || (paramString2.equals(this.name))) && ((paramString3 == null) || (paramString3.equals(this.type))) && ((paramInt == 0) || (paramInt == this.id));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.content.res.XResources.ResourceNames
 * JD-Core Version:    0.7.0.1
 */