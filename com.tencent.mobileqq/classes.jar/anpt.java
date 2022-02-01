import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;

public class anpt
{
  private Intent jdField_a_of_type_AndroidContentIntent;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private String jdField_a_of_type_JavaLangString = "";
  private String b = "";
  private String c = "";
  private String d;
  
  public anpt() {}
  
  public anpt(Intent paramIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public Intent a()
  {
    return this.jdField_a_of_type_AndroidContentIntent;
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public String a()
  {
    return this.d;
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public void c(String paramString)
  {
    this.b = paramString;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public void d(String paramString)
  {
    this.c = paramString;
  }
  
  @NonNull
  public String toString()
  {
    Bundle localBundle = null;
    if (a() != null) {
      localBundle = a().getExtras();
    }
    if ((localBundle != null) && (localBundle.containsKey("KEY_NOTIFY_ID_FROM_PROCESSOR")))
    {
      localBundle = new Bundle(localBundle);
      localBundle.remove("KEY_NOTIFY_ID_FROM_PROCESSOR");
    }
    for (;;)
    {
      if (a() != null) {}
      for (String str = String.valueOf(a().getHeight());; str = "using default bitmap") {
        return "NotificationElement{contentIntentExtras=" + localBundle + ", ticker='" + this.jdField_a_of_type_JavaLangString + '\'' + ", contentTitle='" + this.b + '\'' + ", notificationContentText='" + this.c + '\'' + ", notificationIconBitmap=" + str + ", briefOfMessage='" + this.d + '\'' + '}' + '\n';
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anpt
 * JD-Core Version:    0.7.0.1
 */