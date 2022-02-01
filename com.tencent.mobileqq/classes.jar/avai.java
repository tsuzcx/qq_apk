import java.io.File;

public class avai
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avai
 * JD-Core Version:    0.7.0.1
 */