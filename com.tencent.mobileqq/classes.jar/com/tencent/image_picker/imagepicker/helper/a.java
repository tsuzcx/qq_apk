package com.tencent.image_picker.imagepicker.helper;

import android.content.Context;
import com.tencent.image_picker.imagepicker.features.h;
import java.io.Serializable;

public class a
{
  public static com.tencent.image_picker.imagepicker.features.c a(com.tencent.image_picker.imagepicker.features.c paramc)
  {
    if (paramc != null)
    {
      if ((paramc.b() != 1) && ((paramc.o() == h.d) || (paramc.o() == h.b))) {
        throw new IllegalStateException("ReturnMode.GALLERY_ONLY and ReturnMode.ALL is only applicable in Single Mode!");
      }
      if (paramc.m() != null)
      {
        if ((paramc.m() instanceof Serializable)) {
          return paramc;
        }
        throw new IllegalStateException("Custom image loader must be a class that implement ImageLoader. This limitation due to Serializeable");
      }
      return paramc;
    }
    throw new IllegalStateException("ImagePickerConfig cannot be null");
  }
  
  public static String a(Context paramContext, com.tencent.image_picker.imagepicker.features.c paramc)
  {
    String str = paramc.f();
    paramc = str;
    if (c.a(str)) {
      paramc = paramContext.getString(2131918057);
    }
    return paramc;
  }
  
  public static boolean a(com.tencent.luggage.wxa.av.a parama, boolean paramBoolean)
  {
    parama = parama.o();
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramBoolean)
    {
      if (parama != h.b)
      {
        paramBoolean = bool1;
        if (parama != h.c) {}
      }
      else
      {
        paramBoolean = true;
      }
      return paramBoolean;
    }
    if (parama != h.b)
    {
      paramBoolean = bool2;
      if (parama != h.d) {}
    }
    else
    {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public static String b(Context paramContext, com.tencent.image_picker.imagepicker.features.c paramc)
  {
    String str = paramc.g();
    paramc = str;
    if (c.a(str)) {
      paramc = paramContext.getString(2131918058);
    }
    return paramc;
  }
  
  public static String c(Context paramContext, com.tencent.image_picker.imagepicker.features.c paramc)
  {
    String str = paramc.h();
    paramc = str;
    if (c.a(str)) {
      paramc = paramContext.getString(2131918043);
    }
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image_picker.imagepicker.helper.a
 * JD-Core Version:    0.7.0.1
 */