import java.io.File;
import java.io.FilenameFilter;

class bgll
  implements FilenameFilter
{
  bgll(bglk parambglk, String paramString) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgll
 * JD-Core Version:    0.7.0.1
 */