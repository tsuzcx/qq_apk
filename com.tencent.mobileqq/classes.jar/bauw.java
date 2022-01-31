import java.io.File;
import java.io.FilenameFilter;

class bauw
  implements FilenameFilter
{
  bauw(baus parambaus, String paramString) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.startsWith(this.jdField_a_of_type_JavaLangString)) && (paramString.endsWith(".localstorage"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bauw
 * JD-Core Version:    0.7.0.1
 */