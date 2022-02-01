package com.tencent.map.sdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.map.sdk.engine.jni.models.IconImageInfo;
import com.tencent.tencentmap.io.QStorageManager;
import java.io.Closeable;
import java.io.InputStream;

public final class pq
  implements lz
{
  private Context a;
  private final float b;
  private String c;
  
  public pq(Context paramContext, String paramString)
  {
    this.a = paramContext.getApplicationContext();
    this.b = pz.a(this.a);
    this.c = paramString;
  }
  
  private Bitmap a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(QStorageManager.getInstance(this.a).getConfigPath(this.c));
    ((StringBuilder)localObject1).append(paramString);
    Object localObject2 = on.b(((StringBuilder)localObject1).toString());
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(QStorageManager.getInstance(this.a).getAssetsLoadPath(this.c));
      ((StringBuilder)localObject1).append(paramString);
      localObject1 = on.b(((StringBuilder)localObject1).toString());
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(QStorageManager.getInstance(this.a).getAssetsDynamicPath());
      ((StringBuilder)localObject1).append(paramString);
      localObject2 = on.b(((StringBuilder)localObject1).toString());
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      if (gd.a != null)
      {
        localObject1 = this.a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(gd.a);
        ((StringBuilder)localObject2).append(paramString);
        localObject1 = gd.a((Context)localObject1, ((StringBuilder)localObject2).toString());
      }
      else
      {
        localObject1 = localObject2;
        if (gd.b != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(gd.b);
          ((StringBuilder)localObject1).append(paramString);
          localObject1 = on.b(((StringBuilder)localObject1).toString());
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = gd.a(this.a, "tencentmap/mapsdk_vector/", paramString);
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = gd.a(this.a, paramString);
    }
    if (localObject1 == null) {
      return null;
    }
    paramString = BitmapFactory.decodeStream((InputStream)localObject1);
    on.a((Closeable)localObject1);
    return paramString;
  }
  
  public final void a(String paramString, IconImageInfo paramIconImageInfo)
  {
    Object localObject = oi.a(paramString);
    if (localObject == null)
    {
      localObject = fy.b.a(paramString);
    }
    else
    {
      paramIconImageInfo.bitmap = ((Bitmap)localObject);
      paramIconImageInfo.scale = this.b;
    }
    if (this.a == null) {
      return;
    }
    if (localObject == null) {
      try
      {
        if ((paramString.startsWith("poi_icon")) || (paramString.startsWith("mapcfg_")))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(nl.b(paramString));
          ((StringBuilder)localObject).append("@2x.png");
          localObject = a(((StringBuilder)localObject).toString());
        }
        if (localObject != null)
        {
          paramIconImageInfo.bitmap = ((Bitmap)localObject);
          paramIconImageInfo.scale = 2.0F;
          return;
        }
        paramIconImageInfo.bitmap = a(paramString);
        if (paramString.equals("compass.png"))
        {
          paramIconImageInfo.scale = this.b;
          return;
        }
        paramIconImageInfo.scale = 1.0F;
        return;
      }
      catch (OutOfMemoryError paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.pq
 * JD-Core Version:    0.7.0.1
 */