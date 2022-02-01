package com.tencent.luggage.wxa.kz;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.luggage.wxa.rc.b;

public final class f
  extends a
{
  public static final int CTRL_INDEX = 216;
  public static final String NAME = "saveVideoToPhotosAlbum";
  
  boolean a(String paramString)
  {
    return af.b(paramString).toLowerCase().contains("video");
  }
  
  @NonNull
  String c(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "mp4";
    }
    return b.a(str);
  }
  
  void d(String paramString)
  {
    t.a(new f.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kz.f
 * JD-Core Version:    0.7.0.1
 */