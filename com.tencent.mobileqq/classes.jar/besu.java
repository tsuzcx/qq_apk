import java.io.File;

public class besu
{
  File a;
  
  public besu(File paramFile)
  {
    this.a = paramFile;
  }
  
  besv a(String paramString)
  {
    return new besv(this, paramString);
  }
  
  File a(String paramString)
  {
    if (!this.a.exists()) {
      this.a.mkdirs();
    }
    return new File(this.a, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     besu
 * JD-Core Version:    0.7.0.1
 */