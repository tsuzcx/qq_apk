package com.tencent.mobileqq.activity.aio.item;

import ahoc;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import com.immersion.stickersampleapp.HapticManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ZanCombolEffectView
  extends View
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 1000;
  private long jdField_a_of_type_Long;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private String jdField_a_of_type_JavaLangString = "chat_item_for_likeplus";
  private List<ahoc> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Random jdField_a_of_type_JavaUtilRandom = new Random(System.currentTimeMillis());
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private List<ahoc> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float = 10.0F;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private List<Bitmap> jdField_c_of_type_JavaUtilList = new ArrayList(5);
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float = 1.0F;
  private int jdField_d_of_type_Int;
  private float e;
  
  public ZanCombolEffectView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ZanCombolEffectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ZanCombolEffectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_c_of_type_JavaUtilList.size() == 0) {
      return;
    }
    int i = 0;
    label16:
    ahoc localahoc;
    float f1;
    if (i < paramInt)
    {
      localahoc = new ahoc(null);
      localahoc.jdField_a_of_type_Int = (getWidth() / 2);
      localahoc.jdField_a_of_type_Float = this.jdField_a_of_type_JavaUtilRandom.nextInt(360);
      f1 = this.jdField_a_of_type_JavaUtilRandom.nextFloat();
      float f2 = this.jdField_b_of_type_Float;
      if (this.jdField_a_of_type_JavaUtilRandom.nextFloat() <= 0.5D) {
        break label257;
      }
      j = 1;
      label90:
      localahoc.jdField_d_of_type_Float = (j * (f2 * f1));
      localahoc.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)this.jdField_c_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilRandom.nextInt(this.jdField_c_of_type_JavaUtilList.size())));
      localahoc.e = 1.0F;
      localahoc.jdField_c_of_type_Float = (this.jdField_a_of_type_JavaUtilRandom.nextFloat() * this.e + this.jdField_c_of_type_Float);
      f1 = (float)(this.jdField_a_of_type_JavaUtilRandom.nextFloat() * this.e * 0.2D);
      if (this.jdField_a_of_type_JavaUtilRandom.nextFloat() <= 0.5D) {
        break label263;
      }
    }
    label257:
    label263:
    for (int j = 1;; j = -1)
    {
      localahoc.jdField_b_of_type_Float = (j * f1 + this.jdField_d_of_type_Float * this.jdField_d_of_type_Float);
      localahoc.jdField_b_of_type_Int = ((int)(-this.jdField_c_of_type_Int * 0.12D));
      this.jdField_a_of_type_JavaUtilList.add(localahoc);
      i += 1;
      break label16;
      break;
      j = -1;
      break label90;
    }
  }
  
  @TargetApi(11)
  public void a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt3, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_Float = paramFloat2;
    this.jdField_c_of_type_Float = paramFloat3;
    this.e = paramFloat5;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_d_of_type_Float = paramFloat4;
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(2, null);
    }
  }
  
  public void a(Integer... paramVarArgs)
  {
    post(new ZanCombolEffectView.1(this, paramVarArgs));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = 0;
    if ((this.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Boolean)) {}
    int k;
    int i;
    ahoc localahoc;
    do
    {
      return;
      super.onDraw(paramCanvas);
      long l = System.currentTimeMillis();
      if ((l - this.jdField_a_of_type_Long < 800L) && (l - this.jdField_b_of_type_Long > 10L))
      {
        a(1);
        this.jdField_b_of_type_Long = l;
      }
      float f = (float)((l - this.jdField_c_of_type_Long) * 1.0D / 1000.0D);
      this.jdField_c_of_type_Long = l;
      k = this.jdField_a_of_type_JavaUtilList.size();
      i = 0;
      if (i < k)
      {
        localahoc = (ahoc)this.jdField_a_of_type_JavaUtilList.get(i);
        localahoc.jdField_b_of_type_Int = ((int)(localahoc.jdField_b_of_type_Int + localahoc.jdField_c_of_type_Float * f));
        if (localahoc.jdField_b_of_type_Int > this.jdField_c_of_type_Int) {
          this.jdField_b_of_type_JavaUtilList.add(localahoc);
        }
        for (;;)
        {
          i += 1;
          break;
          localahoc.jdField_a_of_type_Int = ((int)(localahoc.jdField_a_of_type_Int + (2.0F * f * localahoc.jdField_b_of_type_Float + localahoc.jdField_b_of_type_Float * 0.02D)));
          localahoc.jdField_a_of_type_Float += localahoc.jdField_d_of_type_Float * f;
        }
      }
      this.jdField_a_of_type_JavaUtilList.removeAll(this.jdField_b_of_type_JavaUtilList);
      this.jdField_b_of_type_JavaUtilList.clear();
      k = this.jdField_a_of_type_JavaUtilList.size();
      i = j;
      if (k != 0) {
        break;
      }
      this.jdField_a_of_type_Boolean = false;
    } while (!this.jdField_c_of_type_Boolean);
    HapticManager.a().c(this.jdField_d_of_type_Int);
    this.jdField_d_of_type_Int = 0;
    return;
    while (i < k)
    {
      localahoc = (ahoc)this.jdField_a_of_type_JavaUtilList.get(i);
      this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
      this.jdField_a_of_type_AndroidGraphicsMatrix.setTranslate(-localahoc.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / 2, -localahoc.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / 2);
      this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(localahoc.jdField_a_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsMatrix.preScale(localahoc.e, localahoc.e);
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(localahoc.jdField_a_of_type_Int, localahoc.jdField_b_of_type_Int);
      paramCanvas.drawBitmap(localahoc.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, null);
      i += 1;
    }
    invalidate();
  }
  
  public void setPause(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if (this.jdField_b_of_type_Boolean) {
      if (this.jdField_c_of_type_Boolean) {
        HapticManager.a().a(this.jdField_d_of_type_Int);
      }
    }
    while (!this.jdField_c_of_type_Boolean) {
      return;
    }
    HapticManager.a().b(this.jdField_d_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ZanCombolEffectView
 * JD-Core Version:    0.7.0.1
 */