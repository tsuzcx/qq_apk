import android.content.Context;
import android.support.annotation.NonNull;

public class arfo
{
  final Context jdField_a_of_type_AndroidContentContext;
  final String jdField_a_of_type_JavaLangString;
  String b = "";
  String c = "";
  String d = "";
  String e;
  String f;
  String g;
  String h;
  
  public arfo(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public void c(String paramString)
  {
    this.d = paramString;
  }
  
  public void d(String paramString)
  {
    this.e = paramString;
  }
  
  public void e(String paramString)
  {
    this.g = paramString;
  }
  
  public void f(String paramString)
  {
    this.h = paramString;
  }
  
  @NonNull
  public String toString()
  {
    return "uin: " + this.jdField_a_of_type_JavaLangString + " roomId: " + this.b + " roomGroupCode: " + this.c + " roomShowNumber: " + this.d + " fromId: " + this.e + " openType: " + this.f + " fromGroupId: " + this.g + " fromGroupOwnerUin: " + this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arfo
 * JD-Core Version:    0.7.0.1
 */