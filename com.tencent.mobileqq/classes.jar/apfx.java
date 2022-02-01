import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import android.util.StateSet;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.VipBubbleDrawable.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class apfx
  extends Drawable
{
  private static final ColorFilter jdField_a_of_type_AndroidGraphicsColorFilter = new ColorMatrixColorFilter(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, -26.0F, 0.0F, 1.0F, 0.0F, 0.0F, -26.0F, 0.0F, 0.0F, 1.0F, 0.0F, -26.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F });
  private static int[] jdField_a_of_type_ArrayOfInt = { 16842919 };
  private int jdField_a_of_type_Int = 160;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private NinePatch jdField_a_of_type_AndroidGraphicsNinePatch;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public String a;
  public boolean a;
  private int jdField_b_of_type_Int;
  private NinePatch jdField_b_of_type_AndroidGraphicsNinePatch;
  private String jdField_b_of_type_JavaLangString;
  public boolean b;
  private int[] jdField_b_of_type_ArrayOfInt;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  
  public apfx(Resources paramResources, NinePatch paramNinePatch1, NinePatch paramNinePatch2, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentResResources = paramResources;
    this.jdField_a_of_type_AndroidGraphicsNinePatch = paramNinePatch1;
    this.jdField_b_of_type_AndroidGraphicsNinePatch = paramNinePatch2;
    this.jdField_d_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    if (paramResources != null)
    {
      this.jdField_a_of_type_Int = paramResources.getDisplayMetrics().densityDpi;
      this.jdField_b_of_type_Int = AIOUtils.dp2px(65.0F, paramResources);
      this.jdField_c_of_type_Int = AIOUtils.dp2px(57.0F, paramResources);
    }
  }
  
  private int a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return 0;
    }
    if (Build.VERSION.SDK_INT >= 12) {
      return paramBitmap.getByteCount();
    }
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  private void a(Canvas paramCanvas)
  {
    if (paramCanvas == null) {}
    label261:
    for (;;)
    {
      return;
      String str = "bubblebg://" + "0_local_default_" + this.jdField_b_of_type_Boolean;
      Object localObject1;
      if (BaseApplicationImpl.sImageCache != null)
      {
        localObject1 = (Pair)BaseApplicationImpl.sImageCache.get(str);
        if (localObject1 != null)
        {
          localObject1 = (NinePatch)((Pair)localObject1).first;
          if (localObject1 != null) {
            ((NinePatch)localObject1).draw(paramCanvas, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label261;
        }
        if (this.jdField_b_of_type_Boolean) {}
        for (i = 2130849741;; i = 2130849917) {
          for (;;)
          {
            localObject1 = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject1).inDensity = 320;
            ((BitmapFactory.Options)localObject1).inTargetDensity = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi;
            try
            {
              localObject1 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentResResources, i, (BitmapFactory.Options)localObject1);
              if (localObject1 == null) {
                break;
              }
              Object localObject2 = ((Bitmap)localObject1).getNinePatchChunk();
              if (localObject2 == null) {
                break;
              }
              localObject2 = new NinePatch((Bitmap)localObject1, (byte[])localObject2, null);
              ((NinePatch)localObject2).draw(paramCanvas, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
              if (BaseApplicationImpl.sImageCache == null) {
                break;
              }
              paramCanvas = new Pair(localObject2, Integer.valueOf(a((Bitmap)localObject1)));
              BaseApplicationImpl.sImageCache.put(str, paramCanvas);
              return;
            }
            catch (OutOfMemoryError paramCanvas)
            {
              QLog.e("VipBubbleDrawable", 1, "drawDefaultBubbleBg, decode default bubble bg error, bubbleId=" + this.jdField_d_of_type_Int, paramCanvas);
              return;
            }
          }
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    invalidateSelf();
  }
  
  public void a(boolean paramBoolean, String paramString1, int[] paramArrayOfInt, String paramString2)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    this.e = paramBoolean;
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_b_of_type_JavaLangString = paramString1;
      this.jdField_b_of_type_ArrayOfInt = paramArrayOfInt;
      this.jdField_c_of_type_JavaLangString = paramString2;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.f = paramBoolean2;
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(jdField_a_of_type_AndroidGraphicsColorFilter);
    }
    for (;;)
    {
      invalidateSelf();
      return;
      this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(null);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (!this.e) {
      return;
    }
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new VipBubbleDrawable.1(this));
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    int i = paramCanvas.save();
    Object localObject;
    if ((this.f) && (this.jdField_b_of_type_AndroidGraphicsNinePatch != null))
    {
      localObject = this.jdField_b_of_type_AndroidGraphicsNinePatch;
      if (localObject == null) {
        break label153;
      }
      if (this.jdField_b_of_type_Boolean) {
        paramCanvas.scale(-1.0F, 1.0F, localRect.centerX(), localRect.centerY());
      }
      ((NinePatch)localObject).draw(paramCanvas, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    for (;;)
    {
      paramCanvas.restoreToCount(i);
      localObject = (HashMap)apec.a().a.get(Integer.valueOf(this.jdField_d_of_type_Int));
      if ((localObject == null) || (((HashMap)localObject).size() <= 0)) {
        return;
      }
      localObject = ((HashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((apfj)((Iterator)localObject).next()).a(this, paramCanvas);
      }
      localObject = this.jdField_a_of_type_AndroidGraphicsNinePatch;
      break;
      label153:
      QLog.e("VipBubbleDrawable", 1, "draw, ninePatch null, use default, mUseAnimationBg=" + this.f + ", mNormalNinePatch=" + this.jdField_a_of_type_AndroidGraphicsNinePatch + ", mAnimationNinePath" + this.jdField_b_of_type_AndroidGraphicsNinePatch + ", bubbleId=" + this.jdField_d_of_type_Int + ", drawable=" + this);
      a(paramCanvas);
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public int getIntrinsicWidth()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int getOpacity()
  {
    if (this.jdField_a_of_type_AndroidGraphicsNinePatch != null) {
      if (!this.jdField_a_of_type_AndroidGraphicsNinePatch.hasAlpha()) {}
    }
    while ((this.jdField_a_of_type_AndroidGraphicsPaint != null) && (this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha() < 255))
    {
      return -3;
      return -1;
    }
    return -1;
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool1 = false;
    boolean bool2 = StateSet.stateSetMatches(jdField_a_of_type_ArrayOfInt, paramArrayOfInt);
    if (this.jdField_c_of_type_Boolean != bool2)
    {
      this.jdField_c_of_type_Boolean = bool2;
      if ((!this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {
        break label61;
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(jdField_a_of_type_AndroidGraphicsColorFilter);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      invalidateSelf();
      bool1 = true;
      return bool1;
      label61:
      this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(null);
    }
  }
  
  public void setAlpha(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apfx
 * JD-Core Version:    0.7.0.1
 */