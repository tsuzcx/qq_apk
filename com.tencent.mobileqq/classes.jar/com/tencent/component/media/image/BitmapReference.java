package com.tencent.component.media.image;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.component.media.utils.ImageManagerLog;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class BitmapReference
{
  static int jdField_a_of_type_Int = 0;
  private static Releaser jdField_a_of_type_ComTencentComponentMediaImageReleaser;
  private static Set jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  @TargetApi(19)
  public static BitmapReference getBitmapReference(Bitmap paramBitmap)
  {
    Object localObject;
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      localObject = null;
    }
    BitmapReference localBitmapReference;
    do
    {
      do
      {
        return localObject;
        localBitmapReference = new BitmapReference();
        localBitmapReference.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
        localObject = localBitmapReference;
      } while (ImageManager.sCloseNativeAndCache);
      localObject = localBitmapReference;
    } while (!paramBitmap.isMutable());
    jdField_a_of_type_JavaUtilSet.add(paramBitmap);
    return localBitmapReference;
  }
  
  public static void setGlobalReleaser(Releaser paramReleaser)
  {
    jdField_a_of_type_ComTencentComponentMediaImageReleaser = paramReleaser;
  }
  
  protected void finalize()
  {
    try
    {
      release();
      return;
    }
    catch (Throwable localThrowable)
    {
      ImageManagerLog.e("BitmapReference", "catch an exception:" + Log.getStackTraceString(localThrowable));
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public final int getAllocSize()
  {
    return BitmapUtils.getBitmapAllocSize(this.jdField_a_of_type_AndroidGraphicsBitmap);
  }
  
  public Bitmap getBitmap()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
      return null;
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public final Bitmap.Config getConfig()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap.getConfig();
  }
  
  public final int getHeight()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
  }
  
  public final int getRowBytes()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap.getRowBytes();
  }
  
  public final int getWidth()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
  }
  
  public final boolean hasAlpha()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap.hasAlpha();
  }
  
  public final boolean isMutable()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap.isMutable();
  }
  
  public final boolean isRecycled()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled();
  }
  
  @TargetApi(19)
  public void release()
  {
    if ((this.jdField_a_of_type_Boolean) || (ImageManager.sCloseNativeAndCache)) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
    } while ((!jdField_a_of_type_JavaUtilSet.remove(this.jdField_a_of_type_AndroidGraphicsBitmap)) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) || (!this.jdField_a_of_type_AndroidGraphicsBitmap.isMutable()));
    if (jdField_a_of_type_ComTencentComponentMediaImageReleaser != null)
    {
      jdField_a_of_type_ComTencentComponentMediaImageReleaser.release(this.jdField_a_of_type_AndroidGraphicsBitmap);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.BitmapReference
 * JD-Core Version:    0.7.0.1
 */