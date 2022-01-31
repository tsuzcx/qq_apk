import com.tencent.qphone.base.util.QLog;

public class avdu
{
  private int jdField_a_of_type_Int = -1;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString = "";
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString = "";
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString = "";
  private String f = "";
  private String g = "";
  private String h = "";
  private String i;
  private String j;
  
  public avdt a()
  {
    for (;;)
    {
      try
      {
        switch (this.jdField_a_of_type_Int)
        {
        case 0: 
          if (this.jdField_a_of_type_Boolean) {
            this.jdField_b_of_type_Boolean = false;
          }
          return new avdt(this.j, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_d_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_e_of_type_JavaLangString, this.jdField_c_of_type_Int, this.f, this.jdField_a_of_type_Boolean, this.jdField_c_of_type_Boolean, this.jdField_b_of_type_Boolean, this.i, this.jdField_d_of_type_Int, this.g, this.h, this.jdField_e_of_type_Int);
        }
      }
      catch (Exception localException)
      {
        QLog.e("QSplash@SplashItem", 1, localException, new Object[0]);
        return null;
      }
      this.i = (bbuv.a(avds.jdField_a_of_type_JavaLangString) + "pic/" + this.jdField_d_of_type_JavaLangString.hashCode());
      continue;
      this.i = (bbuv.a(avds.jdField_a_of_type_JavaLangString) + "gif/" + this.jdField_d_of_type_JavaLangString.hashCode());
      this.i = (bbuv.a(avds.jdField_a_of_type_JavaLangString) + "video/" + this.jdField_d_of_type_JavaLangString.hashCode());
    }
  }
  
  public avdu a(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
    return this;
  }
  
  public avdu a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public avdu a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public avdu b(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    return this;
  }
  
  public avdu b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public avdu b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public avdu c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public avdu c(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    return this;
  }
  
  public avdu d(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public avdu d(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    return this;
  }
  
  public avdu e(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    return this;
  }
  
  public avdu e(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
    return this;
  }
  
  public avdu f(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public avdu g(String paramString)
  {
    this.j = paramString;
    return this;
  }
  
  public avdu h(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public avdu i(String paramString)
  {
    this.h = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     avdu
 * JD-Core Version:    0.7.0.1
 */