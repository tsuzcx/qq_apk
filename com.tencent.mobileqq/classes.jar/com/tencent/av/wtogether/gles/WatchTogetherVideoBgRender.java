package com.tencent.av.wtogether.gles;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.texture.BitmapTexture;
import com.tencent.av.utils.UITools;
import com.tencent.av.wtogether.util.WTogetherUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.widget.immersive.ImmersiveUtils;

public class WatchTogetherVideoBgRender
{
  private int a = ImmersiveUtils.getScreenWidth();
  private int b = ImmersiveUtils.getScreenHeight();
  private boolean c = false;
  private BitmapTexture d;
  private BitmapTexture e;
  private BitmapTexture f;
  private BitmapTexture g;
  private Rect h;
  private Rect i;
  private VideoAppInterface j;
  private Context k;
  
  public WatchTogetherVideoBgRender(VideoAppInterface paramVideoAppInterface, Context paramContext)
  {
    this.j = paramVideoAppInterface;
    this.k = paramContext;
  }
  
  private Bitmap a(long paramLong)
  {
    Object localObject = this.j.b();
    Bitmap localBitmap = ((VideoController)localObject).a(String.valueOf(paramLong), String.valueOf(((VideoController)localObject).k().aN), ((VideoController)localObject).k().aQ, true, false);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      localObject = localBitmap;
      if (localBitmap.getConfig() != null) {}
    }
    else
    {
      localObject = UITools.a(this.k, 2130841348);
    }
    return ImageUtil.a((Bitmap)localObject, ImageUtil.a(((Bitmap)localObject).getWidth()));
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    if (this.d == null)
    {
      this.d = new BitmapTexture(UITools.a(this.k, 2130843352));
      this.d.b(false);
    }
    if (this.f == null)
    {
      this.f = new BitmapTexture(a(paramLong1));
      this.f.b(false);
    }
    if (this.e == null)
    {
      this.e = new BitmapTexture(UITools.a(this.k, 2130843351));
      this.e.b(false);
    }
    if (this.g == null)
    {
      this.g = new BitmapTexture(a(paramLong2));
      this.g.b(false);
    }
  }
  
  private void a(GLCanvas paramGLCanvas, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    BitmapTexture localBitmapTexture1;
    if (paramBoolean) {
      localBitmapTexture1 = this.d;
    } else {
      localBitmapTexture1 = this.e;
    }
    BitmapTexture localBitmapTexture2;
    if (paramBoolean) {
      localBitmapTexture2 = this.f;
    } else {
      localBitmapTexture2 = this.g;
    }
    int m = this.k.getResources().getDimensionPixelSize(2131298714);
    int n = this.k.getResources().getDimensionPixelSize(2131298714);
    paramInt3 -= paramInt1;
    paramInt1 += paramInt3 / 2;
    paramInt4 -= paramInt2;
    paramInt2 += paramInt4 / 2;
    paramGLCanvas.a(paramInt1, paramInt2);
    paramGLCanvas.a(localBitmapTexture1, 0, 0, paramInt3, paramInt4);
    paramGLCanvas.a(localBitmapTexture2, 0, 0, m, n);
    paramGLCanvas.a(-paramInt1, -paramInt2);
  }
  
  private void b()
  {
    if (this.c) {
      return;
    }
    this.c = true;
    int i2 = this.k.getResources().getDimensionPixelSize(2131298715);
    int i4 = this.k.getResources().getDimensionPixelSize(2131298713);
    int i3 = (this.a - i2 * 2 - 2) / 2;
    int n = this.b - i4 - this.k.getResources().getDimensionPixelSize(2131298716);
    int i1 = AIOUtils.b(64.0F, this.k.getResources()) + WTogetherUtil.a(this.k) + WTogetherUtil.b();
    int m = n;
    if (n < i1) {
      m = i1;
    }
    if (!Build.MODEL.equalsIgnoreCase("VTR-AL00"))
    {
      n = m;
      if (!Build.MODEL.equalsIgnoreCase("VKY-AL00")) {}
    }
    else
    {
      n = m + AIOUtils.b(40.0F, this.k.getResources());
    }
    m = i3 + i2;
    i1 = i4 + n;
    this.h = new Rect(i3, n, m, i1);
    m += 2;
    this.i = new Rect(m, n, i2 + m, i1);
  }
  
  public void a()
  {
    BitmapTexture localBitmapTexture = this.f;
    if (localBitmapTexture != null)
    {
      localBitmapTexture.n();
      this.f = null;
    }
    localBitmapTexture = this.g;
    if (localBitmapTexture != null)
    {
      localBitmapTexture.n();
      this.g = null;
    }
    localBitmapTexture = this.d;
    if (localBitmapTexture != null)
    {
      localBitmapTexture.n();
      this.d = null;
    }
    localBitmapTexture = this.e;
    if (localBitmapTexture != null)
    {
      localBitmapTexture.n();
      this.e = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public void a(GLCanvas paramGLCanvas, boolean paramBoolean1, long paramLong1, boolean paramBoolean2, long paramLong2)
  {
    b();
    a(paramLong1, paramLong2);
    if (!paramBoolean1) {
      a(paramGLCanvas, true, this.h.left, this.h.top, this.h.right, this.h.bottom);
    }
    if (!paramBoolean2) {
      a(paramGLCanvas, false, this.i.left, this.i.top, this.i.right, this.i.bottom);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.gles.WatchTogetherVideoBgRender
 * JD-Core Version:    0.7.0.1
 */