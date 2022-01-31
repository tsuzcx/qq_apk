package com.tencent.component.media.image;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.utils.BitmapUtils;
import java.util.LinkedList;
import pkw;

@TargetApi(19)
public class BitmapPool
  extends BucketPool
{
  public static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
  public static final int BYTES_PER_PIXEL = 4;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  
  public BitmapPool(PoolParams paramPoolParams)
  {
    super(paramPoolParams);
  }
  
  private static int a(int paramInt)
  {
    if (paramInt % 4 == 0) {
      return paramInt / 4;
    }
    return paramInt / 4 + 1;
  }
  
  protected Bitmap allocData(int paramInt)
  {
    return Bitmap.createBitmap(1, a(paramInt), BITMAP_CONFIG);
  }
  
  public int getHitCount()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int getMissCount()
  {
    return this.jdField_b_of_type_Int;
  }
  
  protected int getSizeForData(Bitmap paramBitmap)
  {
    return paramBitmap.getAllocationByteCount();
  }
  
  public long getTotalExpectSize()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public long getTotalRealSize()
  {
    return this.jdField_b_of_type_Long;
  }
  
  protected int handleBucketListEmpty(pkw parampkw)
  {
    parampkw.c += 1;
    return parampkw.jdField_b_of_type_Int;
  }
  
  protected boolean handleRecyleData(pkw parampkw, Bitmap paramBitmap)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (parampkw.jdField_a_of_type_JavaUtilLinkedList.size() < parampkw.jdField_a_of_type_Int) {
      if (parampkw.c > parampkw.jdField_a_of_type_Int + 2)
      {
        bool1 = bool2;
        if (parampkw.jdField_a_of_type_JavaUtilLinkedList.size() > parampkw.jdField_a_of_type_Int / 4 + 1) {}
      }
      else
      {
        parampkw.jdField_a_of_type_JavaUtilLinkedList.add(paramBitmap);
        bool1 = false;
      }
    }
    if (bool1) {
      parampkw.c -= 1;
    }
    return bool1;
  }
  
  protected void hit(int paramInt, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Int += 1;
    this.jdField_b_of_type_Long += BitmapUtils.getBitmapAllocSize(paramBitmap);
    this.jdField_a_of_type_Long += paramInt;
    ImageManagerEnv.getLogger();
  }
  
  protected void miss(int paramInt)
  {
    this.jdField_b_of_type_Int += 1;
    ImageManagerEnv.getLogger();
  }
  
  public void release(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {}
    for (;;)
    {
      return;
      try
      {
        if (!paramBitmap.isMutable()) {
          continue;
        }
        super.release(paramBitmap);
      }
      finally {}
    }
  }
  
  protected void releaseData(Bitmap paramBitmap)
  {
    paramBitmap.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.BitmapPool
 * JD-Core Version:    0.7.0.1
 */