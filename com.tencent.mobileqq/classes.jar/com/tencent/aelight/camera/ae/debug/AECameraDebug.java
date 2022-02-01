package com.tencent.aelight.camera.ae.debug;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.opengl.GLES20;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.util.MustRunOnGLThread;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class AECameraDebug
{
  public static boolean a = false;
  public static boolean b = false;
  public static boolean c = false;
  public static String d = "aetest/test.png";
  public static boolean e = false;
  private static boolean f = false;
  private static boolean g = false;
  private static String h;
  private int i;
  private int j;
  private int k;
  private boolean l = false;
  private boolean m = false;
  
  public AECameraDebug()
  {
    a = false;
  }
  
  public static void a(boolean paramBoolean, String paramString)
  {
    f = paramBoolean;
    if (paramBoolean) {
      if ((paramString != null) && (a(paramString))) {
        h = paramString;
      } else if (b() == null) {
        f = false;
      }
    }
    g = true;
  }
  
  public static boolean a()
  {
    if ((f) && (!g))
    {
      if (b() == null) {
        f = false;
      }
      g = true;
    }
    return f;
  }
  
  private static boolean a(String paramString)
  {
    return new File(paramString).exists();
  }
  
  public static String b()
  {
    String str = h;
    if (str != null) {
      return str;
    }
    if (a("/sdcard/testVideoForQQ.mov")) {
      h = "/sdcard/testVideoForQQ.mov";
    } else if (a("/sdcard/testVideoForQQ.mp4")) {
      h = "/sdcard/testVideoForQQ.mp4";
    }
    return h;
  }
  
  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  @MustRunOnGLThread
  public void c()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    this.k = arrayOfInt[0];
    this.m = true;
  }
  
  @MustRunOnGLThread
  public void d()
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = this.k;
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    this.l = false;
    this.m = false;
    a = false;
  }
  
  @MustRunOnGLThread
  public void e()
  {
    if (this.m)
    {
      if (this.l) {
        return;
      }
      boolean bool;
      if (b)
      {
        if (!c) {
          bool = true;
        } else {
          bool = false;
        }
      }
      else {
        bool = a;
      }
      Object localObject1;
      if (bool)
      {
        Object localObject2 = AEModule.getContext().getAssets();
        localObject1 = null;
        try
        {
          localObject2 = ((AssetManager)localObject2).open(d);
          localObject1 = localObject2;
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
        }
        localObject1 = BitmapFactory.decodeStream((InputStream)localObject1);
      }
      else
      {
        localObject1 = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), d, 1);
      }
      if (BitmapUtils.isLegal((Bitmap)localObject1))
      {
        if (Math.abs(((Bitmap)localObject1).getHeight() / ((Bitmap)localObject1).getWidth() - 1.777778F) > 0.0001D)
        {
          int n = (int)(((Bitmap)localObject1).getWidth() * 16.0F / 9.0F);
          Bitmap localBitmap = Bitmap.createBitmap(((Bitmap)localObject1).getWidth(), n, Bitmap.Config.ARGB_8888);
          localBitmap.eraseColor(-1);
          Canvas localCanvas = new Canvas(localBitmap);
          Paint localPaint = new Paint(6);
          localPaint.setAntiAlias(true);
          localCanvas.drawBitmap((Bitmap)localObject1, 0.0F, (n - ((Bitmap)localObject1).getHeight()) / 2, localPaint);
          GlUtil.loadTexture(this.k, localBitmap);
          ((Bitmap)localObject1).recycle();
          localBitmap.recycle();
          this.i = localBitmap.getWidth();
          this.j = localBitmap.getHeight();
        }
        else
        {
          GlUtil.loadTexture(this.k, (Bitmap)localObject1);
          ((Bitmap)localObject1).recycle();
          this.i = ((Bitmap)localObject1).getWidth();
          this.j = ((Bitmap)localObject1).getHeight();
        }
        this.l = true;
      }
    }
  }
  
  public int f()
  {
    return this.i;
  }
  
  public int g()
  {
    return this.j;
  }
  
  public int h()
  {
    return this.k;
  }
  
  public boolean i()
  {
    return this.l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.debug.AECameraDebug
 * JD-Core Version:    0.7.0.1
 */