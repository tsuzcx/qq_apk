public class amrg
{
  public int a;
  public int b;
  public int c;
  public int d;
  public int e;
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof amrg))) {}
    do
    {
      return false;
      paramObject = (amrg)paramObject;
    } while ((this.a != paramObject.a) || (this.b != paramObject.b) || (this.c != paramObject.c) || (this.d != paramObject.d) || (this.e != paramObject.e));
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("{");
    localStringBuilder.append("positionX:").append(this.a);
    localStringBuilder.append(", positionY:").append(this.b);
    localStringBuilder.append(", width:").append(this.c);
    localStringBuilder.append(", height:").append(this.d);
    localStringBuilder.append(", align:").append(this.e);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amrg
 * JD-Core Version:    0.7.0.1
 */