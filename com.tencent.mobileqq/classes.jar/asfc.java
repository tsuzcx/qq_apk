import java.io.File;

public class asfc
{
  public static void a(File paramFile)
  {
    if ((paramFile == null) || (paramFile.exists())) {}
    do
    {
      return;
      paramFile = paramFile.getParentFile();
    } while ((paramFile == null) || (paramFile.exists()));
    a(paramFile);
    paramFile.mkdirs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asfc
 * JD-Core Version:    0.7.0.1
 */