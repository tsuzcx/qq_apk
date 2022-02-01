import java.io.File;

public class bdua
{
  File a;
  
  public bdua(File paramFile)
  {
    this.a = paramFile;
  }
  
  bdub a(String paramString)
  {
    return new bdub(this, paramString);
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
 * Qualified Name:     bdua
 * JD-Core Version:    0.7.0.1
 */