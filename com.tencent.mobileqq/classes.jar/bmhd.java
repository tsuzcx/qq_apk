import android.content.Context;
import android.view.View.OnClickListener;

public class bmhd
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = true;
  private String d;
  
  public bmhd(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public bmha a()
  {
    return new bmha(this, null);
  }
  
  public bmhd a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public bmhd a(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.d = paramString;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    return this;
  }
  
  public bmhd b(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmhd
 * JD-Core Version:    0.7.0.1
 */