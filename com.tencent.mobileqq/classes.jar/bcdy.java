import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;

public class bcdy
{
  private static bcdy jdField_a_of_type_Bcdy = new bcdy();
  String jdField_a_of_type_JavaLangString;
  
  public static bcdy a()
  {
    return jdField_a_of_type_Bcdy;
  }
  
  public void a() {}
  
  public void a(BaseChatPie paramBaseChatPie) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, bcdz parambcdz) {}
  
  public void a(String paramString1, String paramString2, String paramString3) {}
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean a(String paramString)
  {
    return true;
  }
  
  public void b() {}
  
  public boolean b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      return false;
    }
    return paramString.equals(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcdy
 * JD-Core Version:    0.7.0.1
 */