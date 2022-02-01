package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class HeartBreakCombolEffectView
  extends View
  implements Runnable
{
  static boolean jdField_a_of_type_Boolean = false;
  int jdField_a_of_type_Int = 0;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
  Handler jdField_a_of_type_AndroidOsHandler;
  HeartBreakCombolEffectView.DecodeRunnable jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView$DecodeRunnable;
  ArrayList<HeartBreakCombolEffectView.OneFrame> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Vector<Bitmap> jdField_a_of_type_JavaUtilVector = new Vector();
  int jdField_b_of_type_Int = 0;
  Handler jdField_b_of_type_AndroidOsHandler;
  public ArrayList<Bitmap> b;
  
  public HeartBreakCombolEffectView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HeartBreakCombolEffectView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HeartBreakCombolEffectView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    d();
  }
  
  private void d()
  {
    setOnTouchListener(new HeartBreakCombolEffectView.1(this));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    e();
    HandlerThread localHandlerThread = new HandlerThread("decode");
    localHandlerThread.start();
    this.jdField_b_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper());
  }
  
  private void e()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(PokeBigResHandler.b);
    ((StringBuilder)localObject).append("/xinsui_caidan/xinsui_caidan_");
    localObject = ((StringBuilder)localObject).toString();
    int i = 0;
    while (i < 55)
    {
      i += 1;
      StringBuilder localStringBuilder;
      if (i < 10)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("0");
        localStringBuilder.append(i);
        localStringBuilder.append(".png");
        a(localStringBuilder.toString(), 30);
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(i);
        localStringBuilder.append(".png");
        a(localStringBuilder.toString(), 30);
      }
    }
  }
  
  public Bitmap a()
  {
    ArrayList localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localArrayList != null)
    {
      localObject1 = localObject2;
      if (localArrayList.size() > 0) {
        localObject1 = (Bitmap)this.jdField_b_of_type_JavaUtilArrayList.remove(0);
      }
    }
    return localObject1;
  }
  
  public void a()
  {
    if (jdField_a_of_type_Boolean == true) {
      return;
    }
    setVisibility(0);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this);
    this.jdField_a_of_type_AndroidOsHandler.post(this);
    this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a(((HeartBreakCombolEffectView.OneFrame)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).jdField_a_of_type_JavaLangString, null);
    jdField_a_of_type_Boolean = true;
  }
  
  public void a(String paramString, int paramInt)
  {
    HeartBreakCombolEffectView.OneFrame localOneFrame = new HeartBreakCombolEffectView.OneFrame(this);
    localOneFrame.jdField_a_of_type_JavaLangString = paramString;
    localOneFrame.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilArrayList.add(localOneFrame);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this);
    this.jdField_b_of_type_AndroidOsHandler.post(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView$DecodeRunnable);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView$DecodeRunnable = null;
    setVisibility(8);
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
    {
      localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Bitmap)((Iterator)localObject).next()).recycle();
      }
      this.jdField_b_of_type_JavaUtilArrayList.clear();
    }
    if (this.jdField_a_of_type_JavaUtilVector.size() > 0)
    {
      localObject = this.jdField_a_of_type_JavaUtilVector.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Bitmap)((Iterator)localObject).next()).recycle();
      }
      this.jdField_a_of_type_JavaUtilVector.clear();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localObject != null)
    {
      int i = ((Bitmap)localObject).getWidth();
      int j = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      int k = getWidth();
      int m = getHeight();
      float f2 = k * 1.0F / i;
      float f1 = m / 2;
      f2 = j * f2;
      paramCanvas.translate(0.0F, (int)(f1 - f2 / 2.0F) + 50);
      localObject = new Rect(0, 0, i, j);
      Rect localRect = new Rect(0, 0, k, (int)f2);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, (Rect)localObject, localRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public void run()
  {
    int i = this.jdField_a_of_type_Int + 1;
    if (i < 55)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView$DecodeRunnable == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView$DecodeRunnable = new HeartBreakCombolEffectView.DecodeRunnable(this, this.jdField_b_of_type_JavaUtilArrayList);
      }
      HeartBreakCombolEffectView.OneFrame localOneFrame = (HeartBreakCombolEffectView.OneFrame)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView$DecodeRunnable);
      this.jdField_b_of_type_AndroidOsHandler.post(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView$DecodeRunnable);
      this.jdField_a_of_type_Int += 1;
      Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
        if (this.jdField_a_of_type_JavaUtilVector.size() <= 2) {
          this.jdField_a_of_type_JavaUtilVector.add(localBitmap);
        } else {
          localBitmap.recycle();
        }
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = a();
      invalidate();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, localOneFrame.jdField_a_of_type_Int);
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.HeartBreakCombolEffectView
 * JD-Core Version:    0.7.0.1
 */