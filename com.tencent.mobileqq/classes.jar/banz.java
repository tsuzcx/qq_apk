import java.io.File;

public class banz
{
  File a;
  
  public banz(File paramFile)
  {
    this.a = paramFile;
  }
  
  baoa a(String paramString)
  {
    return new baoa(this, paramString);
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
 * Qualified Name:     banz
 * JD-Core Version:    0.7.0.1
 */