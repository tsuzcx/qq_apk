import android.os.Bundle;

public class bayl
{
  public int a;
  public long a;
  public Bundle a;
  public Object a;
  public String a;
  public String b;
  
  public bayl() {}
  
  public bayl(int paramInt, String paramString1, String paramString2, Object paramObject, Bundle paramBundle)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Int < 1) || (this.jdField_a_of_type_Int > 4)) {}
    while ((this.jdField_a_of_type_JavaLangString == null) || ("".equals(this.jdField_a_of_type_JavaLangString.trim())) || ((this.jdField_a_of_type_Int == 3) && ((this.b == null) || ("".equals(this.b))) && ((this.jdField_a_of_type_JavaLangObject == null) || ("".equals(this.jdField_a_of_type_JavaLangObject))))) {
      return false;
    }
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof bayl))
    {
      paramObject = (bayl)paramObject;
      if ((paramObject.jdField_a_of_type_Int == this.jdField_a_of_type_Int) && (bbbd.a(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) && ((3 != this.jdField_a_of_type_Int) || ((bbbd.a(this.b, paramObject.b)) && (bbbd.a(this.jdField_a_of_type_JavaLangObject, paramObject.jdField_a_of_type_JavaLangObject)) && (bbbd.a(this.jdField_a_of_type_AndroidOsBundle, paramObject.jdField_a_of_type_AndroidOsBundle))))) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    int m = 0;
    int n = this.jdField_a_of_type_Int;
    int i;
    int j;
    label27:
    int k;
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      i = 0;
      if (this.b != null) {
        break label66;
      }
      j = 0;
      if (this.jdField_a_of_type_JavaLangObject != null) {
        break label77;
      }
      k = 0;
      label36:
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        break label88;
      }
    }
    for (;;)
    {
      return k + (n + i + j) + m;
      i = this.jdField_a_of_type_JavaLangString.hashCode();
      break;
      label66:
      j = this.b.hashCode();
      break label27;
      label77:
      k = this.jdField_a_of_type_JavaLangObject.hashCode();
      break label36;
      label88:
      m = this.jdField_a_of_type_AndroidOsBundle.hashCode();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[iType = ").append(this.jdField_a_of_type_Int).append(", strKey = ").append(this.jdField_a_of_type_JavaLangString).append(", strSubKey = ").append(this.b).append(", obj = ").append(this.jdField_a_of_type_JavaLangObject).append(", extraUpdateTargetParams = ").append(this.jdField_a_of_type_AndroidOsBundle).append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bayl
 * JD-Core Version:    0.7.0.1
 */