package com.bumptech.glide.load.model;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.bumptech.glide.load.Options;

public class ResourceLoader<Data>
  implements ModelLoader<Integer, Data>
{
  private final ModelLoader<Uri, Data> a;
  private final Resources b;
  
  public ResourceLoader(Resources paramResources, ModelLoader<Uri, Data> paramModelLoader)
  {
    this.b = paramResources;
    this.a = paramModelLoader;
  }
  
  @Nullable
  private Uri b(Integer paramInteger)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("android.resource://");
      ((StringBuilder)localObject).append(this.b.getResourcePackageName(paramInteger.intValue()));
      ((StringBuilder)localObject).append('/');
      ((StringBuilder)localObject).append(this.b.getResourceTypeName(paramInteger.intValue()));
      ((StringBuilder)localObject).append('/');
      ((StringBuilder)localObject).append(this.b.getResourceEntryName(paramInteger.intValue()));
      localObject = Uri.parse(((StringBuilder)localObject).toString());
      return localObject;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      if (Log.isLoggable("ResourceLoader", 5))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Received invalid resource id: ");
        localStringBuilder.append(paramInteger);
        Log.w("ResourceLoader", localStringBuilder.toString(), localNotFoundException);
      }
    }
    return null;
  }
  
  public ModelLoader.LoadData<Data> a(@NonNull Integer paramInteger, int paramInt1, int paramInt2, @NonNull Options paramOptions)
  {
    paramInteger = b(paramInteger);
    if (paramInteger == null) {
      return null;
    }
    return this.a.a(paramInteger, paramInt1, paramInt2, paramOptions);
  }
  
  public boolean a(@NonNull Integer paramInteger)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.ResourceLoader
 * JD-Core Version:    0.7.0.1
 */