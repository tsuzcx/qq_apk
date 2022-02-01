public class bget
{
  public String a;
  public String b;
  public String c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BannerConfig: ").append("backgroudImgUrl=").append(this.a).append(";").append("cornerMarkLevel=").append(this.b).append(";").append("linkUrl=").append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bget
 * JD-Core Version:    0.7.0.1
 */