package com.tencent.av.wtogether.gles;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
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
  private int jdField_a_of_type_Int = ImmersiveUtils.getScreenWidth();
  private Context jdField_a_of_type_AndroidContentContext;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private BitmapTexture jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = ImmersiveUtils.getScreenHeight();
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private BitmapTexture jdField_b_of_type_ComTencentAvOpenglTextureBitmapTexture;
  private BitmapTexture c;
  private BitmapTexture d;
  
  public WatchTogetherVideoBgRender(VideoAppInterface paramVideoAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private Bitmap a(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    Bitmap localBitmap = ((VideoController)localObject).a(String.valueOf(paramLong), String.valueOf(((VideoController)localObject).a().f), ((VideoController)localObject).a().E, true, false);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      localObject = localBitmap;
      if (localBitmap.getConfig() != null) {}
    }
    else
    {
      localObject = UITools.a(this.jdField_a_of_type_AndroidContentContext, 2130840582);
    }
    return ImageUtil.a((Bitmap)localObject, ImageUtil.a(((Bitmap)localObject).getWidth()));
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture == null)
    {
      this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture = new BitmapTexture(UITools.a(this.jdField_a_of_type_AndroidContentContext, 2130842399));
      this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture.a(false);
    }
    if (this.c == null)
    {
      this.c = new BitmapTexture(a(paramLong1));
      this.c.a(false);
    }
    if (this.jdField_b_of_type_ComTencentAvOpenglTextureBitmapTexture == null)
    {
      this.jdField_b_of_type_ComTencentAvOpenglTextureBitmapTexture = new BitmapTexture(UITools.a(this.jdField_a_of_type_AndroidContentContext, 2130842398));
      this.jdField_b_of_type_ComTencentAvOpenglTextureBitmapTexture.a(false);
    }
    if (this.d == null)
    {
      this.d = new BitmapTexture(a(paramLong2));
      this.d.a(false);
    }
  }
  
  private void a(GLCanvas paramGLCanvas, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    BitmapTexture localBitmapTexture1;
    if (paramBoolean) {
      localBitmapTexture1 = this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture;
    } else {
      localBitmapTexture1 = this.jdField_b_of_type_ComTencentAvOpenglTextureBitmapTexture;
    }
    BitmapTexture localBitmapTexture2;
    if (paramBoolean) {
      localBitmapTexture2 = this.c;
    } else {
      localBitmapTexture2 = this.d;
    }
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298044);
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298044);
    paramInt3 -= paramInt1;
    paramInt1 += paramInt3 / 2;
    paramInt4 -= paramInt2;
    paramInt2 += paramInt4 / 2;
    paramGLCanvas.a(paramInt1, paramInt2);
    paramGLCanvas.a(localBitmapTexture1, 0, 0, paramInt3, paramInt4);
    paramGLCanvas.a(localBitmapTexture2, 0, 0, i, j);
    paramGLCanvas.a(-paramInt1, -paramInt2);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    int m = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298045);
    int i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298043);
    int n = (this.jdField_a_of_type_Int - m * 2 - 2) / 2;
    int j = this.jdField_b_of_type_Int - i1 - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298046);
    int k = AIOUtils.b(64.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) + WTogetherUtil.a(this.jdField_a_of_type_AndroidContentContext) + WTogetherUtil.a();
    int i = j;
    if (j < k) {
      i = k;
    }
    j = n + m;
    k = i1 + i;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(n, i, j, k);
    j += 2;
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect(j, i, m + j, k);
  }
  
  public void a()
  {
    BitmapTexture localBitmapTexture = this.c;
    if (localBitmapTexture != null)
    {
      localBitmapTexture.a();
      this.c = null;
    }
    localBitmapTexture = this.d;
    if (localBitmapTexture != null)
    {
      localBitmapTexture.a();
      this.d = null;
    }
    localBitmapTexture = this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture;
    if (localBitmapTexture != null)
    {
      localBitmapTexture.a();
      this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture = null;
    }
    localBitmapTexture = this.jdField_b_of_type_ComTencentAvOpenglTextureBitmapTexture;
    if (localBitmapTexture != null)
    {
      localBitmapTexture.a();
      this.jdField_b_of_type_ComTencentAvOpenglTextureBitmapTexture = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void a(GLCanvas paramGLCanvas, boolean paramBoolean1, long paramLong1, boolean paramBoolean2, long paramLong2)
  {
    b();
    a(paramLong1, paramLong2);
    if (!paramBoolean1) {
      a(paramGLCanvas, true, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    }
    if (!paramBoolean2) {
      a(paramGLCanvas, false, this.jdField_b_of_type_AndroidGraphicsRect.left, this.jdField_b_of_type_AndroidGraphicsRect.top, this.jdField_b_of_type_AndroidGraphicsRect.right, this.jdField_b_of_type_AndroidGraphicsRect.bottom);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.gles.WatchTogetherVideoBgRender
 * JD-Core Version:    0.7.0.1
 */