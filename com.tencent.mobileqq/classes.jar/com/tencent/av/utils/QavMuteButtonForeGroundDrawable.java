package com.tencent.av.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public final class QavMuteButtonForeGroundDrawable
  extends Drawable
{
  private final int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private HashMap<Integer, ArrayList<Bitmap>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private final int jdField_b_of_type_Int;
  private Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  private int c = -1;
  private int d;
  
  public QavMuteButtonForeGroundDrawable(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(0.0F, 0.0F, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
  }
  
  private ArrayList<Bitmap> a()
  {
    return (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.c));
  }
  
  private void a(Canvas paramCanvas) {}
  
  private boolean a()
  {
    return (this.c == 1) || (this.c == 3);
  }
  
  public void a(int paramInt)
  {
    if (this.c == paramInt) {
      return;
    }
    int i = this.c;
    this.c = paramInt;
    invalidateSelf();
  }
  
  public void a(int paramInt, Bitmap paramBitmap)
  {
    ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localArrayList != null)
    {
      localArrayList.add(paramBitmap);
      return;
    }
    localArrayList = new ArrayList();
    localArrayList.add(paramBitmap);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localArrayList);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    a(paramCanvas);
    Object localObject = a();
    if (a())
    {
      localBitmap = (Bitmap)((ArrayList)localObject).get(0);
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
      paramCanvas.drawBitmap(localBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    do
    {
      return;
      if (this.c == 0)
      {
        localBitmap = (Bitmap)((ArrayList)localObject).get(0);
        localObject = (Bitmap)((ArrayList)localObject).get(1);
        this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
        paramCanvas.drawBitmap(localBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
        paramCanvas.save();
        int i = (int)(this.jdField_b_of_type_Int * (10000 - this.d) / 10000.0F);
        if (QLog.isColorLevel()) {
          QLog.d("huanxxiao", 1, "doUpdateAudioVolumeChange nexValue:=" + this.d);
        }
        this.jdField_b_of_type_AndroidGraphicsRect.set(0, i, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        paramCanvas.clipRect(this.jdField_b_of_type_AndroidGraphicsRect);
        paramCanvas.drawBitmap((Bitmap)localObject, null, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
        paramCanvas.restore();
        return;
      }
    } while (this.c != 2);
    if (this.jdField_a_of_type_Boolean) {}
    for (Bitmap localBitmap = (Bitmap)((ArrayList)localObject).get(1);; localBitmap = (Bitmap)((ArrayList)localObject).get(0))
    {
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
      paramCanvas.drawBitmap(localBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int getIntrinsicWidth()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
  }
  
  public void setAlpha(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha() == paramInt) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.utils.QavMuteButtonForeGroundDrawable
 * JD-Core Version:    0.7.0.1
 */