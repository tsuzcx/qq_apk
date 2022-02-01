import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class aunb
{
  private int jdField_a_of_type_Int;
  protected String a;
  private Matcher jdField_a_of_type_JavaUtilRegexMatcher;
  private Pattern jdField_a_of_type_JavaUtilRegexPattern;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = -1;
  private String jdField_b_of_type_JavaLangString;
  
  protected aunb(Pattern paramPattern)
  {
    this.jdField_a_of_type_JavaUtilRegexPattern = paramPattern;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_JavaUtilRegexMatcher.find();
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilRegexMatcher.start();
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public abstract HashMap<String, Object> a(int paramInt, boolean paramBoolean, CharSequence paramCharSequence);
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilRegexMatcher = this.jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString);
    a();
  }
  
  public boolean a(int paramInt)
  {
    if ((this.jdField_b_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaUtilRegexMatcher == null)) {}
    while ((this.jdField_b_of_type_Int > paramInt) || (!this.jdField_a_of_type_Boolean)) {
      return false;
    }
    if (this.jdField_b_of_type_Int == paramInt)
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaUtilRegexMatcher.group();
      this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilRegexMatcher.end();
      a();
      return true;
    }
    a();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aunb
 * JD-Core Version:    0.7.0.1
 */