import android.content.Context;
import android.content.res.Resources;
import com.tencent.qphone.base.util.QLog;

public class anow
{
  private Resources jdField_a_of_type_AndroidContentResResources;
  private String jdField_a_of_type_JavaLangString;
  private Resources b;
  
  public anow(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
  }
  
  public int a(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidContentResResources == null) || (this.b == null)) {}
    String str1;
    int i;
    do
    {
      return paramInt;
      str1 = this.jdField_a_of_type_AndroidContentResResources.getResourceEntryName(paramInt);
      String str2 = this.jdField_a_of_type_AndroidContentResResources.getResourceTypeName(paramInt);
      i = this.b.getIdentifier(str1, str2, this.jdField_a_of_type_JavaLangString);
    } while (i <= 0);
    if (QLog.isColorLevel()) {
      QLog.d("MultiLanguageEngine", 2, new Object[] { "resourceName:", str1, " ,lanResID:", Integer.valueOf(i), " ,oldId:", Integer.valueOf(paramInt) });
    }
    return i;
  }
  
  public Resources a()
  {
    if (this.b == null) {
      return this.jdField_a_of_type_AndroidContentResResources;
    }
    return this.b;
  }
  
  public void a(Resources paramResources, String paramString)
  {
    this.b = paramResources;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public Resources b()
  {
    return this.jdField_a_of_type_AndroidContentResResources;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anow
 * JD-Core Version:    0.7.0.1
 */