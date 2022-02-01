package com.tencent.luggage.wxa.au;

import android.content.Context;
import android.content.Intent;
import com.tencent.image_picker.imagepicker.features.TencentImagePickerActivity;
import com.tencent.image_picker.imagepicker.features.d;

public class b
{
  private a a = d.a();
  
  public Intent a(Context paramContext)
  {
    paramContext = new Intent(paramContext, TencentImagePickerActivity.class);
    paramContext.putExtra(a.class.getSimpleName(), this.a);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.au.b
 * JD-Core Version:    0.7.0.1
 */