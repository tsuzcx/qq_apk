import android.os.Bundle;
import android.text.TextUtils;

public abstract class apln
  implements aple
{
  private final long jdField_a_of_type_Long;
  private final String jdField_a_of_type_JavaLangString;
  
  public apln(String paramString, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localBundle.putString("Uin", this.jdField_a_of_type_JavaLangString);
    }
    localBundle.putLong("ViewHandle", this.jdField_a_of_type_Long);
    return localBundle;
  }
  
  public String a()
  {
    return "QQ.GetNickname";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apln
 * JD-Core Version:    0.7.0.1
 */