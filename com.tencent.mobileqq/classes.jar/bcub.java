import java.io.File;
import java.io.FilenameFilter;

class bcub
  implements FilenameFilter
{
  bcub(bcua parambcua, String paramString) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcub
 * JD-Core Version:    0.7.0.1
 */