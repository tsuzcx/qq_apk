package com.tencent.mobileqq.apollo.barrage;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.text.StaticLayout;

public class Barrage
{
  public float a;
  public int a;
  public long a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  public StaticLayout a;
  private AbsBarrageCache jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsBarrageCache;
  public CharSequence a;
  public String a;
  public boolean a;
  public float b;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public float c;
  public int c;
  private boolean c;
  public float d;
  public int d;
  public float e;
  public int e;
  public float f;
  public int f;
  public float g;
  public int g;
  public float h;
  public int h;
  
  public Barrage(AbsBarrageCache paramAbsBarrageCache, float paramFloat1, float paramFloat2, float paramFloat3, String paramString1, String paramString2)
  {
    this.jdField_b_of_type_Int = -16777216;
    this.jdField_g_of_type_Float = 24.0F;
    this.jdField_c_of_type_Int = 20000;
    this.jdField_d_of_type_Int = 255;
    this.jdField_h_of_type_Float = 1.0F;
    this.jdField_a_of_type_JavaLangCharSequence = paramString2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_g_of_type_Int = ((int)(12.0F * paramFloat1));
    this.jdField_h_of_type_Int = ((int)(paramFloat1 * 6.0F));
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(0.0F, 0.0F, paramFloat2, paramFloat3);
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_Long = l;
    this.jdField_b_of_type_Long = l;
    this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsBarrageCache = paramAbsBarrageCache;
  }
  
  public Bitmap a()
  {
    Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
      return this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsBarrageCache;
    if (localObject != null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = ((AbsBarrageCache)localObject).a(this);
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public void a()
  {
    AbsBarrageCache localAbsBarrageCache = this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsBarrageCache;
    if (localAbsBarrageCache != null)
    {
      localAbsBarrageCache.a(this);
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsBarrageCache.a(this);
    }
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void b()
  {
    long l1 = System.currentTimeMillis();
    float f1 = this.jdField_e_of_type_Float;
    float f2 = this.jdField_c_of_type_Float;
    long l2 = this.jdField_b_of_type_Long;
    this.jdField_e_of_type_Float = (f1 + f2 * (float)(l1 - l2));
    this.jdField_f_of_type_Float += this.jdField_d_of_type_Float * (float)(l1 - l2);
    this.jdField_b_of_type_Long = l1;
    if (this.jdField_e_of_type_Float + this.jdField_e_of_type_Int >= 0.0F)
    {
      this.jdField_c_of_type_Boolean = true;
    }
    else if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_e_of_type_Float = this.jdField_a_of_type_AndroidGraphicsRectF.width();
      this.jdField_c_of_type_Boolean = true;
    }
    else
    {
      this.jdField_c_of_type_Boolean = false;
    }
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= this.jdField_c_of_type_Int) {
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mIsAlive: ");
    localStringBuilder.append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append(" mText: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangCharSequence);
    localStringBuilder.append(" mMeasured: ");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" mBgFilePath: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" mActionId: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" mStartX: ");
    localStringBuilder.append(this.jdField_a_of_type_Float);
    localStringBuilder.append(" mStartY: ");
    localStringBuilder.append(this.jdField_b_of_type_Float);
    localStringBuilder.append(" mSpeedX: ");
    localStringBuilder.append(this.jdField_c_of_type_Float);
    localStringBuilder.append(" mSpeedY: ");
    localStringBuilder.append(this.jdField_d_of_type_Float);
    localStringBuilder.append(" mCurrentX: ");
    localStringBuilder.append(this.jdField_e_of_type_Float);
    localStringBuilder.append(" mCurrentY: ");
    localStringBuilder.append(this.jdField_f_of_type_Float);
    localStringBuilder.append(" mTextColor: ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(" mTextSize: ");
    localStringBuilder.append(this.jdField_g_of_type_Float);
    localStringBuilder.append(" mStartTime: ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" mAlpha: ");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(" mWidth: ");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append(" mHeight: ");
    localStringBuilder.append(this.jdField_f_of_type_Int);
    localStringBuilder.append(" mLeftPadding: ");
    localStringBuilder.append(this.jdField_g_of_type_Int);
    localStringBuilder.append(" mTopPadding: ");
    localStringBuilder.append(this.jdField_h_of_type_Int);
    localStringBuilder.append(" mViewRect: ");
    localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsRectF);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.barrage.Barrage
 * JD-Core Version:    0.7.0.1
 */