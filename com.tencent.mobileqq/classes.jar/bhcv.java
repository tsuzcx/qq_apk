import java.io.File;
import java.io.FilenameFilter;

class bhcv
  implements FilenameFilter
{
  bhcv(bhct parambhct, String paramString) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhcv
 * JD-Core Version:    0.7.0.1
 */