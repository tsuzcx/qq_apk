package com.tencent.image_picker.imagepicker.features;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.image_picker.imagepicker.helper.a;
import com.tencent.image_picker.imagepicker.helper.e;
import java.util.List;

public abstract class b
{
  private c a;
  
  public static b.a a(Activity paramActivity)
  {
    return new b.a(paramActivity);
  }
  
  public static List<com.tencent.luggage.wxa.az.b> a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    return paramIntent.getParcelableArrayListExtra("selectedImages");
  }
  
  public static com.tencent.luggage.wxa.au.b b()
  {
    return new com.tencent.luggage.wxa.au.b();
  }
  
  public Intent a(Context paramContext)
  {
    c localc = a.a(c());
    paramContext = new Intent(paramContext, TencentImagePickerActivity.class);
    paramContext.putExtra(c.class.getSimpleName(), localc);
    return paramContext;
  }
  
  public b a(int paramInt)
  {
    this.a.b(paramInt);
    return this;
  }
  
  public void a()
  {
    this.a = d.b();
  }
  
  protected c c()
  {
    e.a(this.a.n());
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image_picker.imagepicker.features.b
 * JD-Core Version:    0.7.0.1
 */