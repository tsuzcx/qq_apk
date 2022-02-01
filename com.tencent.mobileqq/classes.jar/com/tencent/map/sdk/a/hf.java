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
    if ((this.f != null) && (this.g != null)) {
      return this.f;
    }
    if (paramContext == null) {
      return null;
    }
    switch (this.i)
    {
    }
    for (;;)
    {
      return this.f;
      this.g = ("res_" + this.a);
      if (fy.b != null) {
        this.f = fy.b.a(this.g);
      }
      if (this.f == null)
      {
        this.f = fy.a(paramContext, this.a);
        if ((fy.b != null) && (this.f != null))
        {
          fy.b.a(this.g, this.f);
          continue;
          this.g = ("asset_" + this.b);
          if (fy.b != null) {
            this.f = fy.b.a(this.g);
          }
          if (this.f == null)
          {
            this.f = fy.c(paramContext, this.b);
            if (this.f == null)
            {
              this.f = fy.b(paramContext, this.b);
              if ((this.f != null) && (this.b != "color_texture_flat_style.png")) {
                this.f = fy.c(this.f);
              }
            }
            if ((fy.b != null) && (this.f != null))
            {
              fy.b.a(this.g, this.f);
              continue;
              this.g = ("file_" + this.c);
              if (fy.b != null) {
                this.f = fy.b.a(this.g);
              }
              if (this.f == null)
              {
                this.f = fy.a(paramContext, this.c);
                continue;
                this.g = ("path_" + this.d);
                if (fy.b != null) {
                  this.f = fy.b.a(this.g);
                }
                if (this.f == null)
                {
                  this.f = fy.a(this.d);
                  if ((fy.b != null) && (this.f != null))
                  {
                    fy.b.a(this.g, this.f);
                    continue;
                    this.g = "asset_marker_default.png";
                    if (fy.b != null) {
                      this.f = fy.b.a(this.g);
                    }
                    if (this.f == null)
                    {
                      this.f = fy.b(paramContext, "marker_default.png");
                      if ((fy.b != null) && (this.f != null))
                      {
                        fy.b.a(this.g, this.f);
                        continue;
                        float f1 = this.e;
                        String str = null;
                        if (f1 < 30.0F) {
                          str = "RED.png";
                        }
                        while (str != null)
                        {
                          this.g = "asset_".concat(String.valueOf(str));
                          if (fy.b != null) {
                            this.f = fy.b.a(this.g);
                          }
                          if (this.f != null) {
                            break;
                          }
                          this.f = fy.b(paramContext, str);
                          if ((fy.b == null) || (this.f == null)) {
                            break;
                          }
                          fy.b.a(this.g, this.f);
                          break;
                          if ((f1 >= 30.0F) && (f1 < 60.0F)) {
                            str = "ORANGE.png";
                          } else if ((f1 >= 60.0F) && (f1 < 120.0F)) {
                            str = "YELLOW.png";
                          } else if ((f1 >= 120.0F) && (f1 < 180.0F)) {
                            str = "GREEN.png";
                          } else if ((f1 >= 180.0F) && (f1 < 210.0F)) {
                            str = "CYAN.png";
                          } else if ((f1 >= 210.0F) && (f1 < 240.0F)) {
                            str = "AZURE.png";
                          } else if ((f1 >= 240.0F) && (f1 < 270.0F)) {
                            str = "BLUE.png";
                          } else if ((f1 >= 270.0F) && (f1 < 300.0F)) {
                            str = "VIOLET.png";
                          } else if ((f1 >= 300.0F) && (f1 < 330.0F)) {
                            str = "MAGENTAV.png";
                          } else if (f1 >= 330.0F) {
                            str = "ROSE.png";
                          }
                        }
                        if (this.f != null)
                        {
                          StringBuilder localStringBuilder = new StringBuilder("bitmap_");
                          Bitmap localBitmap = this.f;
                          str = localBitmap.toString();
                          paramContext = str;
                          if (str == null) {
                            paramContext = "";
                          }
                          paramContext = paramContext.replace("android.graphics.Bitmap", "");
                          int j = localBitmap.getWidth();
                          int k = localBitmap.getHeight();
                          paramContext = paramContext + "@" + localBitmap.hashCode() + "@" + j + "@" + k + "@" + localBitmap.getRowBytes();
                          this.g = new StringBuilder().append(paramContext).append("@").append(localBitmap.getPixel(j / 2, k / 2)).toString();
                          if ((fy.b != null) && (this.f != null)) {
                            fy.b.a(this.g, this.f);
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.hf
 * JD-Core Version:    0.7.0.1
 */