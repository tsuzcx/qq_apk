public class apji
{
  public int a = 3;
  public int b = 3;
  public int c = 1000;
  public int d = 1;
  public int e = 1;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ArDownloadDPC{");
    localStringBuilder.append("networkControl=").append(this.a);
    localStringBuilder.append(", dailyRetryTimes=").append(this.b);
    localStringBuilder.append(", countRetryTimes=").append(this.c);
    localStringBuilder.append(", entranceControl=").append(this.d);
    localStringBuilder.append(", autoPreDownload=").append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apji
 * JD-Core Version:    0.7.0.1
 */