import java.io.File;
import java.io.FilenameFilter;

class bcym
  implements FilenameFilter
{
  bcym(bcyj parambcyj, String paramString) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.startsWith(this.jdField_a_of_type_JavaLangString)) && (paramString.endsWith(".localstorage"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcym
 * JD-Core Version:    0.7.0.1
 */