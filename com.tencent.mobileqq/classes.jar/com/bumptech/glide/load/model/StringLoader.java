package com.bumptech.glide.load.model;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.bumptech.glide.load.Options;
import java.io.File;

public class StringLoader<Data>
  implements ModelLoader<String, Data>
{
  private final ModelLoader<Uri, Data> a;
  
  public StringLoader(ModelLoader<Uri, Data> paramModelLoader)
  {
    this.a = paramModelLoader;
  }
  
  @Nullable
  private static Uri b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (paramString.charAt(0) == '/') {
      return c(paramString);
    }
    Uri localUri = Uri.parse(paramString);
    if (localUri.getScheme() == null) {
      return c(paramString);
    }
    return localUri;
  }
  
  private static Uri c(String paramString)
  {
    return Uri.fromFile(new File(paramString));
  }
  
  public ModelLoader.LoadData<Data> a(@NonNull String paramString, int paramInt1, int paramInt2, @NonNull Options paramOptions)
  {
    paramString = b(paramString);
    if (paramString == null) {
      return null;
    }
    return this.a.a(paramString, paramInt1, paramInt2, paramOptions);
  }
  
  public boolean a(@NonNull String paramString)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.StringLoader
 * JD-Core Version:    0.7.0.1
 */