package com.tencent.biz.pubaccount.ecshopassit.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EcShopRainView
  extends View
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private final List<EcShopRainView.RainIcon> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Random jdField_a_of_type_JavaUtilRandom;
  private boolean jdField_a_of_type_Boolean;
  private float b;
  
  public EcShopRainView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public EcShopRainView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public EcShopRainView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private boolean a(int paramInt)
  {
    return ((EcShopRainView.RainIcon)this.jdField_a_of_type_JavaUtilList.get(paramInt)).c > getHeight();
  }
  
  private void b()
  {
    setVisibility(8);
    setWillNotDraw(false);
    c();
    d();
  }
  
  private void b(EcShopRainView.Conf paramConf)
  {
    if (paramConf == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Float = paramConf.jdField_a_of_type_Int;
      this.b = paramConf.b;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramConf.jdField_a_of_type_AndroidGraphicsBitmap;
      this.jdField_a_of_type_JavaUtilList.clear();
      int i = 0;
      int j = 0;
      while (i < 8)
      {
        paramConf = new EcShopRainView.RainIcon(this.jdField_a_of_type_AndroidGraphicsBitmap);
        int n = (getWidth() - this.jdField_a_of_type_Int * 2) / 4;
        int m = n - (int)this.b;
        int i1 = new int[] { 1, 2, 0, 3, 2, 1, 3, 0 }[i];
        Random localRandom = this.jdField_a_of_type_JavaUtilRandom;
        int k = m;
        if (m <= 0) {
          k = 1;
        }
        paramConf.b = (localRandom.nextInt(k) + n * i1 + this.jdField_a_of_type_Int);
        k = (int)-Math.ceil(this.jdField_a_of_type_Float);
        paramConf.c = k;
        m = getHeight();
        m = (int)((-k + m) * 16.0F / (this.jdField_a_of_type_JavaUtilRandom.nextInt(501) + 1500));
        k = m;
        if (m == 0) {
          k = 1;
        }
        paramConf.d = k;
        paramConf.jdField_a_of_type_Int = j;
        this.jdField_a_of_type_JavaUtilList.add(paramConf);
        j += this.jdField_a_of_type_JavaUtilRandom.nextInt(300);
        i += 1;
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilRandom = new Random();
    this.jdField_a_of_type_Int = AIOUtils.a(20.0F, getContext().getResources());
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    setVisibility(8);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {}
    while (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
  }
  
  public void a(EcShopRainView.Conf paramConf)
  {
    if ((paramConf == null) || (paramConf.jdField_a_of_type_AndroidGraphicsBitmap == null)) {
      return;
    }
    a();
    setVisibility(0);
    post(new EcShopRainView.1(this, paramConf));
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    int k;
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      int j = 0;
      int i = 0;
      k = i;
      if (j < this.jdField_a_of_type_JavaUtilList.size())
      {
        EcShopRainView.RainIcon localRainIcon = (EcShopRainView.RainIcon)this.jdField_a_of_type_JavaUtilList.get(j);
        Bitmap localBitmap = localRainIcon.jdField_a_of_type_AndroidGraphicsBitmap;
        k = i;
        if (!localBitmap.isRecycled())
        {
          k = i;
          if (!a(j))
          {
            if (l1 - l2 >= localRainIcon.jdField_a_of_type_Int) {
              break label140;
            }
            k = i;
          }
        }
        for (;;)
        {
          j += 1;
          i = k;
          break;
          label140:
          k = 1;
          this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
          float f1 = this.jdField_a_of_type_Float / localBitmap.getHeight();
          float f2 = this.b / localBitmap.getWidth();
          this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(f2, f1);
          localRainIcon.c += localRainIcon.d;
          this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(localRainIcon.b, localRainIcon.c);
          paramCanvas.drawBitmap(localBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
      }
    }
    else
    {
      k = 0;
    }
    if (k == 0)
    {
      a();
      return;
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.EcShopRainView
 * JD-Core Version:    0.7.0.1
 */