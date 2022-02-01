package com.tencent.luggage.wxa.kz;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.luggage.wxa.rc.b;

public final class e
  extends a
{
  public static final int CTRL_INDEX = 217;
  public static final String NAME = "saveImageToPhotosAlbum";
  
  boolean a(String paramString)
  {
    return af.b(paramString).toLowerCase().contains("image");
  }
  
  @NonNull
  String c(String paramString)
  {
    return b.a(paramString);
  }
  
  void d(String paramString)
  {
    t.a(new e.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kz.e
 * JD-Core Version:    0.7.0.1
 */