package com.tencent.map.sdk.a;

import android.content.Context;
import android.graphics.Bitmap;

public final class hf
{
  public int a = -1;
  public String b = "";
  public String c = "";
  public String d = "";
  public float e = -1.0F;
  public Bitmap f = null;
  public String g = null;
  private final String h = "marker_default.png";
  private int i = -1;
  
  public hf(int paramInt)
  {
    this.i = paramInt;
  }
  
  public final Bitmap a(Context paramContext)
  {
    Object localObject = this.f;
    if ((localObject != null) && (this.g != null)) {
      return localObject;
    }
    localObject = null;
    if (paramContext == null) {
      return null;
    }
    switch (this.i)
    {
    default: 
      break;
    case 7: 
      if (this.f != null)
      {
        StringBuilder localStringBuilder = new StringBuilder("bitmap_");
        Bitmap localBitmap = this.f;
        localObject = localBitmap.toString();
        paramContext = (Context)localObject;
        if (localObject == null) {
          paramContext = "";
        }
        paramContext = paramContext.replace("android.graphics.Bitmap", "");
        int j = localBitmap.getWidth();
        int k = localBitmap.getHeight();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramContext);
        ((StringBuilder)localObject).append("@");
        ((StringBuilder)localObject).append(localBitmap.hashCode());
        ((StringBuilder)localObject).append("@");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append("@");
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append("@");
        ((StringBuilder)localObject).append(localBitmap.getRowBytes());
        paramContext = ((StringBuilder)localObject).toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramContext);
        ((StringBuilder)localObject).append("@");
        ((StringBuilder)localObject).append(localBitmap.getPixel(j / 2, k / 2));
        localStringBuilder.append(((StringBuilder)localObject).toString());
        this.g = localStringBuilder.toString();
        if ((fy.b != null) && (this.f != null)) {
          fy.b.a(this.g, this.f);
        }
      }
      break;
    case 6: 
      float f1 = this.e;
      if (f1 < 30.0F) {
        localObject = "RED.png";
      } else if ((f1 >= 30.0F) && (f1 < 60.0F)) {
        localObject = "ORANGE.png";
      } else if ((f1 >= 60.0F) && (f1 < 120.0F)) {
        localObject = "YELLOW.png";
      } else if ((f1 >= 120.0F) && (f1 < 180.0F)) {
        localObject = "GREEN.png";
      } else if ((f1 >= 180.0F) && (f1 < 210.0F)) {
        localObject = "CYAN.png";
      } else if ((f1 >= 210.0F) && (f1 < 240.0F)) {
        localObject = "AZURE.png";
      } else if ((f1 >= 240.0F) && (f1 < 270.0F)) {
        localObject = "BLUE.png";
      } else if ((f1 >= 270.0F) && (f1 < 300.0F)) {
        localObject = "VIOLET.png";
      } else if ((f1 >= 300.0F) && (f1 < 330.0F)) {
        localObject = "MAGENTAV.png";
      } else if (f1 >= 330.0F) {
        localObject = "ROSE.png";
      }
      if (localObject != null)
      {
        this.g = "asset_".concat(String.valueOf(localObject));
        if (fy.b != null) {
          this.f = fy.b.a(this.g);
        }
        if (this.f == null)
        {
          this.f = fy.b(paramContext, (String)localObject);
          if ((fy.b != null) && (this.f != null)) {
            fy.b.a(this.g, this.f);
          }
        }
      }
      break;
    case 5: 
      this.g = "asset_marker_default.png";
      if (fy.b != null) {
        this.f = fy.b.a(this.g);
      }
      if (this.f == null)
      {
        this.f = fy.b(paramContext, "marker_default.png");
        if ((fy.b != null) && (this.f != null)) {
          fy.b.a(this.g, this.f);
        }
      }
      break;
    case 4: 
      paramContext = new StringBuilder("path_");
      paramContext.append(this.d);
      this.g = paramContext.toString();
      if (fy.b != null) {
        this.f = fy.b.a(this.g);
      }
      if (this.f == null)
      {
        this.f = fy.a(this.d);
        if ((fy.b != null) && (this.f != null)) {
          fy.b.a(this.g, this.f);
        }
      }
      break;
    case 3: 
      localObject = new StringBuilder("file_");
      ((StringBuilder)localObject).append(this.c);
      this.g = ((StringBuilder)localObject).toString();
      if (fy.b != null) {
        this.f = fy.b.a(this.g);
      }
      if (this.f == null) {
        this.f = fy.a(paramContext, this.c);
      }
      break;
    case 2: 
      localObject = new StringBuilder("asset_");
      ((StringBuilder)localObject).append(this.b);
      this.g = ((StringBuilder)localObject).toString();
      if (fy.b != null) {
        this.f = fy.b.a(this.g);
      }
      if (this.f == null)
      {
        this.f = fy.c(paramContext, this.b);
        if (this.f == null)
        {
          this.f = fy.b(paramContext, this.b);
          paramContext = this.f;
          if ((paramContext != null) && (this.b != "color_texture_flat_style.png")) {
            this.f = fy.c(paramContext);
          }
        }
        if ((fy.b != null) && (this.f != null)) {
          fy.b.a(this.g, this.f);
        }
      }
      break;
    case 1: 
      localObject = new StringBuilder("res_");
      ((StringBuilder)localObject).append(this.a);
      this.g = ((StringBuilder)localObject).toString();
      if (fy.b != null) {
        this.f = fy.b.a(this.g);
      }
      if (this.f == null)
      {
        this.f = fy.a(paramContext, this.a);
        if ((fy.b != null) && (this.f != null)) {
          fy.b.a(this.g, this.f);
        }
      }
      break;
    }
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.hf
 * JD-Core Version:    0.7.0.1
 */