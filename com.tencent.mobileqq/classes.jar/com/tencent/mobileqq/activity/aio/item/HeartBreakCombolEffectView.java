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
import vfc;

public class HeartBreakCombolEffectView
  extends View
  implements Runnable
{
  static boolean jdField_a_of_type_Boolean;
  int jdField_a_of_type_Int = 0;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
  Handler jdField_a_of_type_AndroidOsHandler;
  HeartBreakCombolEffectView.DecodeRunnable jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView$DecodeRunnable;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Vector jdField_a_of_type_JavaUtilVector = new Vector();
  int jdField_b_of_type_Int = 0;
  Handler jdField_b_of_type_AndroidOsHandler;
  public ArrayList b;
  
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
    setOnTouchListener(new vfc(this));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    e();
    HandlerThread localHandlerThread = new HandlerThread("decode");
    localHandlerThread.start();
    this.jdField_b_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper());
  }
  
  private void e()
  {
    String str = PokeBigResHandler.b + "/xinsui_caidan/xinsui_caidan_";
    int i = 0;
    if (i < 55)
    {
      if (i + 1 < 10) {
        a(str + "0" + (i + 1) + ".png", 30);
      }
      for (;;)
      {
        i += 1;
        break;
        a(str + (i + 1) + ".png", 30);
      }
    }
  }
  
  public Bitmap a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_b_of_type_JavaUtilArrayList != null)
    {
      localObject1 = localObject2;
      if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0) {
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
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    Iterator localIterator;
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
    {
      localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((Bitmap)localIterator.next()).recycle();
      }
      this.jdField_b_of_type_JavaUtilArrayList.clear();
    }
    if (this.jdField_a_of_type_JavaUtilVector.size() > 0)
    {
      localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
      while (localIterator.hasNext()) {
        ((Bitmap)localIterator.next()).recycle();
      }
      this.jdField_a_of_type_JavaUtilVector.clear();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      int i = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      int j = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      int k = getWidth();
      int m = getHeight();
      float f = k * 1.0F / i;
      paramCanvas.translate(0.0F, (int)(m / 2 - j * f / 2.0F) + 50);
      Rect localRect1 = new Rect(0, 0, i, j);
      Rect localRect2 = new Rect(0, 0, k, (int)(j * f));
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, localRect1, localRect2, this.jdField_a_of_type_AndroidGraphicsPaint);
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
      Bitmap localBitmap;
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
      {
        localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
        if (this.jdField_a_of_type_JavaUtilVector.size() > 2) {
          break label150;
        }
        this.jdField_a_of_type_JavaUtilVector.add(localBitmap);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = a();
        invalidate();
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, localOneFrame.jdField_a_of_type_Int);
        return;
        label150:
        localBitmap.recycle();
      }
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.HeartBreakCombolEffectView
 * JD-Core Version:    0.7.0.1
 */