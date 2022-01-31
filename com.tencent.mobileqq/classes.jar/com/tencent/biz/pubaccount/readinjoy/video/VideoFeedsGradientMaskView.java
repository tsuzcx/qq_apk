package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R.styleable;

public class VideoFeedsGradientMaskView
  extends View
{
  private int jdField_a_of_type_Int = 1;
  LinearGradient jdField_a_of_type_AndroidGraphicsLinearGradient;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private int b;
  
  public VideoFeedsGradientMaskView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoFeedsGradientMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoFeedsGradientMaskView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.VideoFeedsGradientMaskView);
    this.b = paramContext.getInt(0, 0);
    paramContext.recycle();
    this.jdField_a_of_type_Int = ((int)(getAlpha() * 255.0F));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    switch (this.b)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidGraphicsLinearGradient != null)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsLinearGradient);
        paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      return;
      if (this.jdField_a_of_type_AndroidGraphicsLinearGradient == null)
      {
        float f = getHeight();
        Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
        this.jdField_a_of_type_AndroidGraphicsLinearGradient = new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { 1118482, -1508830958, -1508830958 }, new float[] { 0.0F, 0.5F, 1.0F }, localTileMode);
        continue;
        if (this.jdField_a_of_type_AndroidGraphicsLinearGradient == null)
        {
          f = getHeight();
          localTileMode = Shader.TileMode.CLAMP;
          this.jdField_a_of_type_AndroidGraphicsLinearGradient = new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { -1508830958, -1508830958, 1118482 }, new float[] { 0.0F, 0.5F, 1.0F }, localTileMode);
          continue;
          if (this.jdField_a_of_type_AndroidGraphicsLinearGradient == null)
          {
            this.jdField_a_of_type_Int = 255;
            f = getHeight();
            localTileMode = Shader.TileMode.CLAMP;
            this.jdField_a_of_type_AndroidGraphicsLinearGradient = new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { -872415232, 1711276032, 0 }, new float[] { 0.0F, 0.4F, 1.0F }, localTileMode);
            continue;
            this.jdField_a_of_type_Int = 255;
            f = getHeight();
            localTileMode = Shader.TileMode.CLAMP;
            this.jdField_a_of_type_AndroidGraphicsLinearGradient = new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { 0, 1711276032, -872415232 }, new float[] { 0.0F, 0.6F, 1.0F }, localTileMode);
            continue;
            if (this.jdField_a_of_type_AndroidGraphicsLinearGradient == null)
            {
              this.jdField_a_of_type_Int = 255;
              f = getHeight();
              localTileMode = Shader.TileMode.CLAMP;
              this.jdField_a_of_type_AndroidGraphicsLinearGradient = new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { -1728053248, 0 }, new float[] { 0.0F, 1.0F }, localTileMode);
              continue;
              if (this.jdField_a_of_type_AndroidGraphicsLinearGradient == null)
              {
                this.jdField_a_of_type_Int = 255;
                f = getWidth();
                localTileMode = Shader.TileMode.CLAMP;
                this.jdField_a_of_type_AndroidGraphicsLinearGradient = new LinearGradient(0.0F, 0.0F, f, 0.0F, new int[] { -1728053248, 0 }, new float[] { 0.0F, 1.0F }, localTileMode);
                continue;
                if (this.jdField_a_of_type_AndroidGraphicsLinearGradient == null)
                {
                  this.jdField_a_of_type_Int = 255;
                  f = getWidth();
                  localTileMode = Shader.TileMode.CLAMP;
                  this.jdField_a_of_type_AndroidGraphicsLinearGradient = new LinearGradient(0.0F, 0.0F, f, 0.0F, new int[] { 0, -1728053248 }, new float[] { 0.0F, 1.0F }, localTileMode);
                  continue;
                  if (this.jdField_a_of_type_AndroidGraphicsLinearGradient == null)
                  {
                    this.jdField_a_of_type_Int = 255;
                    f = getHeight();
                    localTileMode = Shader.TileMode.CLAMP;
                    this.jdField_a_of_type_AndroidGraphicsLinearGradient = new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { 0, 855638016 }, new float[] { 0.0F, 1.0F }, localTileMode);
                    continue;
                    if (this.jdField_a_of_type_AndroidGraphicsLinearGradient == null)
                    {
                      this.jdField_a_of_type_Int = 255;
                      f = getHeight();
                      localTileMode = Shader.TileMode.CLAMP;
                      this.jdField_a_of_type_AndroidGraphicsLinearGradient = new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { 1711276032, 0 }, new float[] { 0.0F, 1.0F }, localTileMode);
                      continue;
                      if (this.jdField_a_of_type_AndroidGraphicsLinearGradient == null)
                      {
                        f = getHeight();
                        localTileMode = Shader.TileMode.CLAMP;
                        this.jdField_a_of_type_AndroidGraphicsLinearGradient = new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { 0, -16777216 }, new float[] { 0.0F, 1.0F }, localTileMode);
                        continue;
                        if (this.jdField_a_of_type_AndroidGraphicsLinearGradient == null) {
                          this.jdField_a_of_type_AndroidGraphicsLinearGradient = new LinearGradient(0.0F, 0.0F, getWidth(), 0.0F, 0, -16777216, Shader.TileMode.CLAMP);
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void setMaskAlpha(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGradientMaskView
 * JD-Core Version:    0.7.0.1
 */