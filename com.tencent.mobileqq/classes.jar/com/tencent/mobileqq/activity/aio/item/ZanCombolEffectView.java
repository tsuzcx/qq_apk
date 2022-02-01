package com.tencent.mobileqq.activity.aio.item;

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
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 1000;
  private long jdField_a_of_type_Long = 0L;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private String jdField_a_of_type_JavaLangString = "chat_item_for_likeplus";
  private List<ZanCombolEffectView.Node> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Random jdField_a_of_type_JavaUtilRandom = new Random(System.currentTimeMillis());
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = 0.0F;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = 0L;
  private List<ZanCombolEffectView.Node> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float = 10.0F;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long = 0L;
  private List<Bitmap> jdField_c_of_type_JavaUtilList = new ArrayList(5);
  private boolean jdField_c_of_type_Boolean = false;
  private float jdField_d_of_type_Float = 1.0F;
  private int jdField_d_of_type_Int;
  private float e = 0.0F;
  
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
    while (i < paramInt)
    {
      ZanCombolEffectView.Node localNode = new ZanCombolEffectView.Node(null);
      localNode.jdField_a_of_type_Int = (getWidth() / 2);
      localNode.jdField_a_of_type_Float = this.jdField_a_of_type_JavaUtilRandom.nextInt(360);
      float f1 = this.jdField_a_of_type_JavaUtilRandom.nextFloat();
      float f2 = this.jdField_b_of_type_Float;
      double d1 = this.jdField_a_of_type_JavaUtilRandom.nextFloat();
      int k = -1;
      if (d1 > 0.5D) {
        j = 1;
      } else {
        j = -1;
      }
      localNode.jdField_d_of_type_Float = (f1 * f2 * j);
      List localList = this.jdField_c_of_type_JavaUtilList;
      localNode.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localList.get(this.jdField_a_of_type_JavaUtilRandom.nextInt(localList.size())));
      localNode.e = 1.0F;
      localNode.jdField_c_of_type_Float = (this.jdField_a_of_type_JavaUtilRandom.nextFloat() * this.e + this.jdField_c_of_type_Float);
      d1 = this.jdField_a_of_type_JavaUtilRandom.nextFloat() * this.e;
      Double.isNaN(d1);
      f1 = (float)(d1 * 0.2D);
      int j = k;
      if (this.jdField_a_of_type_JavaUtilRandom.nextFloat() > 0.5D) {
        j = 1;
      }
      f2 = j;
      float f3 = this.jdField_d_of_type_Float;
      localNode.jdField_b_of_type_Float = (f1 * f2 + f3 * f3);
      d1 = -this.jdField_c_of_type_Int;
      Double.isNaN(d1);
      localNode.jdField_b_of_type_Int = ((int)(d1 * 0.12D));
      this.jdField_a_of_type_JavaUtilList.add(localNode);
      i += 1;
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
    if (!this.jdField_b_of_type_Boolean)
    {
      if (!this.jdField_a_of_type_Boolean) {
        return;
      }
      super.onDraw(paramCanvas);
      long l = System.currentTimeMillis();
      if ((l - this.jdField_a_of_type_Long < 800L) && (l - this.jdField_b_of_type_Long > 10L))
      {
        a(1);
        this.jdField_b_of_type_Long = l;
      }
      double d1 = l - this.jdField_c_of_type_Long;
      Double.isNaN(d1);
      float f = (float)(d1 * 1.0D / 1000.0D);
      this.jdField_c_of_type_Long = l;
      int k = this.jdField_a_of_type_JavaUtilList.size();
      int j = 0;
      int i = 0;
      ZanCombolEffectView.Node localNode;
      while (i < k)
      {
        localNode = (ZanCombolEffectView.Node)this.jdField_a_of_type_JavaUtilList.get(i);
        localNode.jdField_b_of_type_Int = ((int)(localNode.jdField_b_of_type_Int + localNode.jdField_c_of_type_Float * f));
        if (localNode.jdField_b_of_type_Int > this.jdField_c_of_type_Int)
        {
          this.jdField_b_of_type_JavaUtilList.add(localNode);
        }
        else
        {
          d1 = localNode.jdField_a_of_type_Int;
          double d2 = 2.0F * f * localNode.jdField_b_of_type_Float;
          double d3 = localNode.jdField_b_of_type_Float;
          Double.isNaN(d3);
          Double.isNaN(d2);
          Double.isNaN(d1);
          localNode.jdField_a_of_type_Int = ((int)(d1 + (d2 + d3 * 0.02D)));
          localNode.jdField_a_of_type_Float += localNode.jdField_d_of_type_Float * f;
        }
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilList.removeAll(this.jdField_b_of_type_JavaUtilList);
      this.jdField_b_of_type_JavaUtilList.clear();
      k = this.jdField_a_of_type_JavaUtilList.size();
      i = j;
      if (k == 0)
      {
        this.jdField_a_of_type_Boolean = false;
        if (this.jdField_c_of_type_Boolean)
        {
          HapticManager.a().c(this.jdField_d_of_type_Int);
          this.jdField_d_of_type_Int = 0;
        }
        return;
      }
      while (i < k)
      {
        localNode = (ZanCombolEffectView.Node)this.jdField_a_of_type_JavaUtilList.get(i);
        this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
        this.jdField_a_of_type_AndroidGraphicsMatrix.setTranslate(-localNode.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / 2, -localNode.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / 2);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(localNode.jdField_a_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsMatrix.preScale(localNode.e, localNode.e);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(localNode.jdField_a_of_type_Int, localNode.jdField_b_of_type_Int);
        paramCanvas.drawBitmap(localNode.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, null);
        i += 1;
      }
      invalidate();
    }
  }
  
  public void setPause(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_c_of_type_Boolean) {
        HapticManager.a().a(this.jdField_d_of_type_Int);
      }
    }
    else if (this.jdField_c_of_type_Boolean) {
      HapticManager.a().b(this.jdField_d_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ZanCombolEffectView
 * JD-Core Version:    0.7.0.1
 */