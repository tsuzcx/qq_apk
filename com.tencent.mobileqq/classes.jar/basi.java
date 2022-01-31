import java.io.File;

public class basi
{
  File a;
  
  public basi(File paramFile)
  {
    this.a = paramFile;
  }
  
  basj a(String paramString)
  {
    return new basj(this, paramString);
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
 * Qualified Name:     basi
 * JD-Core Version:    0.7.0.1
 */