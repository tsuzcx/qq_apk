import java.io.File;

public class ayqc
{
  File a;
  
  public ayqc(File paramFile)
  {
    this.a = paramFile;
  }
  
  ayqd a(String paramString)
  {
    return new ayqd(this, paramString);
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
 * Qualified Name:     ayqc
 * JD-Core Version:    0.7.0.1
 */