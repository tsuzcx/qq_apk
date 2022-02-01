package com.tencent.image_picker.imagepicker.helper;

import com.tencent.luggage.wxa.ry.b;

public class d
{
  private static d a;
  private boolean b = true;
  
  public static d a()
  {
    if (a == null) {
      a = new d();
    }
    return a;
  }
  
  public void a(String paramString)
  {
    if (this.b) {
      b.d("ImagePicker", paramString);
    }
  }
  
  public void b(String paramString)
  {
    if (this.b) {
      b.a("ImagePicker", paramString);
    }
  }
  
  public void c(String paramString)
  {
    if (this.b) {
      b.b("ImagePicker", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image_picker.imagepicker.helper.d
 * JD-Core Version:    0.7.0.1
 */