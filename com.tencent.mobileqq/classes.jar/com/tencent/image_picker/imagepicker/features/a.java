package com.tencent.image_picker.imagepicker.features;

import android.content.Context;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.av.c;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class a
{
  private Context a;
  private ExecutorService b;
  private final String[] c = { "_id", "_display_name", "_data", "bucket_display_name" };
  
  public a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  @Nullable
  private static File b(String paramString)
  {
    if (paramString != null) {
      if (paramString.isEmpty()) {
        return null;
      }
    }
    try
    {
      paramString = new File(paramString);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
    return null;
  }
  
  private ExecutorService b()
  {
    if (this.b == null) {
      this.b = Executors.newSingleThreadExecutor();
    }
    return this.b;
  }
  
  public void a()
  {
    ExecutorService localExecutorService = this.b;
    if (localExecutorService != null)
    {
      localExecutorService.shutdown();
      this.b = null;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, ArrayList<File> paramArrayList, c paramc)
  {
    b().execute(new a.a(this, paramBoolean1, paramBoolean2, paramArrayList, paramc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image_picker.imagepicker.features.a
 * JD-Core Version:    0.7.0.1
 */