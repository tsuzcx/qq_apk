import android.content.Context;
import android.view.View.OnClickListener;

public class bgwy
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
  
  public bgwy(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public bgwv a()
  {
    return new bgwv(this, null);
  }
  
  public bgwy a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public bgwy a(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.d = paramString;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    return this;
  }
  
  public bgwy b(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgwy
 * JD-Core Version:    0.7.0.1
 */