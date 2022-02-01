import android.text.TextUtils;

public class amhn
{
  int jdField_a_of_type_Int;
  private amhx jdField_a_of_type_Amhx;
  private amhy jdField_a_of_type_Amhy;
  private amia jdField_a_of_type_Amia;
  String jdField_a_of_type_JavaLangString;
  int b = 30000;
  
  public amhl a()
  {
    if (this.jdField_a_of_type_Amia == null) {
      this.jdField_a_of_type_Amia = new amhw();
    }
    if (this.jdField_a_of_type_Amhy == null) {
      this.jdField_a_of_type_Amhy = new amhv();
    }
    if (this.jdField_a_of_type_Amhx == null) {
      this.jdField_a_of_type_Amhx = new amhj();
    }
    if (this.jdField_a_of_type_Int == 0) {
      throw new IllegalArgumentException("appId required.");
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      throw new IllegalArgumentException("current account uid is required.");
    }
    return new amhl(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Amia, this.jdField_a_of_type_Amhy, this.jdField_a_of_type_Amhx, null);
  }
  
  public amhn a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public amhn a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amhn
 * JD-Core Version:    0.7.0.1
 */