import java.io.File;

public class axpv
{
  File a;
  
  public axpv(File paramFile)
  {
    this.a = paramFile;
  }
  
  axpw a(String paramString)
  {
    return new axpw(this, paramString);
  }
  
  File a(String paramString)
  {
    if (!this.a.exists()) {
      this.a.mkdirs();
    }
    return new File(this.a, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axpv
 * JD-Core Version:    0.7.0.1
 */