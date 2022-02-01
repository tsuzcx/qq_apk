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
    this.jdField_h_of_type_Int = ((int)(6.0F * paramFloat1));
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(0.0F, 0.0F, paramFloat2, paramFloat3);
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_Long = l;
    this.jdField_b_of_type_Long = l;
    this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsBarrageCache = paramAbsBarrageCache;
  }
  
  public Bitmap a()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      return this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsBarrageCache != null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsBarrageCache.a(this);
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsBarrageCache != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsBarrageCache.a(this);
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsBarrageCache.a(this);
    }
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void b()
  {
    long l = System.currentTimeMillis();
    this.jdField_e_of_type_Float += this.jdField_c_of_type_Float * (float)(l - this.jdField_b_of_type_Long);
    this.jdField_f_of_type_Float += this.jdField_d_of_type_Float * (float)(l - this.jdField_b_of_type_Long);
    this.jdField_b_of_type_Long = l;
    if (this.jdField_e_of_type_Float + this.jdField_e_of_type_Int >= 0.0F) {
      this.jdField_c_of_type_Boolean = true;
    }
    for (;;)
    {
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= this.jdField_c_of_type_Int) {
        this.jdField_c_of_type_Boolean = false;
      }
      return;
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_e_of_type_Float = this.jdField_a_of_type_AndroidGraphicsRectF.width();
        this.jdField_c_of_type_Boolean = true;
      }
      else
      {
        this.jdField_c_of_type_Boolean = false;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mIsAlive: ").append(this.jdField_c_of_type_Boolean).append(" mText: ").append(this.jdField_a_of_type_JavaLangCharSequence).append(" mMeasured: ").append(this.jdField_a_of_type_Boolean).append(" mBgFilePath: ").append(this.jdField_a_of_type_JavaLangString).append(" mActionId: ").append(this.jdField_a_of_type_Int).append(" mStartX: ").append(this.jdField_a_of_type_Float).append(" mStartY: ").append(this.jdField_b_of_type_Float).append(" mSpeedX: ").append(this.jdField_c_of_type_Float).append(" mSpeedY: ").append(this.jdField_d_of_type_Float).append(" mCurrentX: ").append(this.jdField_e_of_type_Float).append(" mCurrentY: ").append(this.jdField_f_of_type_Float).append(" mTextColor: ").append(this.jdField_b_of_type_Int).append(" mTextSize: ").append(this.jdField_g_of_type_Float).append(" mStartTime: ").append(this.jdField_a_of_type_Long).append(" mAlpha: ").append(this.jdField_d_of_type_Int).append(" mWidth: ").append(this.jdField_e_of_type_Int).append(" mHeight: ").append(this.jdField_f_of_type_Int).append(" mLeftPadding: ").append(this.jdField_g_of_type_Int).append(" mTopPadding: ").append(this.jdField_h_of_type_Int).append(" mViewRect: ").append(this.jdField_a_of_type_AndroidGraphicsRectF);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.barrage.Barrage
 * JD-Core Version:    0.7.0.1
 */