import java.io.File;

public class ayqe
{
  File a;
  
  public ayqe(File paramFile)
  {
    this.a = paramFile;
  }
  
  ayqf a(String paramString)
  {
    return new ayqf(this, paramString);
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
 * Qualified Name:     ayqe
 * JD-Core Version:    0.7.0.1
 */