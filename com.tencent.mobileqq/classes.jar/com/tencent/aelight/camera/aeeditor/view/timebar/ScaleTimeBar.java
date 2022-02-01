package com.tencent.aelight.camera.aeeditor.view.timebar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.aelight.camera.aeeditor.view.timebar.scale.ScaleAdapter;
import com.tencent.aelight.camera.aeeditor.view.timebar.scale.Scaler;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;

public class ScaleTimeBar
  extends ScaleView
{
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 2147483647L;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private String jdField_a_of_type_JavaLangString = "";
  private int jdField_b_of_type_Int = 0;
  private Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  private int jdField_c_of_type_Int = 3;
  private Paint jdField_c_of_type_AndroidGraphicsPaint = new Paint();
  private int d;
  
  public ScaleTimeBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ScaleTimeBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScaleTimeBar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.d = getResources().getDimensionPixelSize(2063990825);
    this.jdField_c_of_type_Int = getResources().getDimensionPixelSize(2063990806);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.d);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(getResources().getColor(2063925278));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).getTypeface(getContext(), "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf"));
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(this.d);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(getResources().getColor(2063925279));
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
    this.jdField_b_of_type_AndroidGraphicsPaint.setTypeface(((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).getTypeface(getContext(), "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf"));
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setTextSize(this.d);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(getResources().getColor(2063925278));
  }
  
  private int b()
  {
    return getMeasuredWidth() / 2;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter == null) {
      return;
    }
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_Int = b();
    }
    if (this.jdField_b_of_type_Int == 0) {
      this.jdField_b_of_type_Int = (getHeight() / 2);
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a() == null) {
      return;
    }
    Object localObject2 = null;
    int j = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a().size();
    Object localObject1 = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetrics();
    float f1 = this.jdField_b_of_type_Int + (((Paint.FontMetrics)localObject1).bottom - ((Paint.FontMetrics)localObject1).top) / 2.0F - ((Paint.FontMetrics)localObject1).bottom;
    int i = 0;
    float f2;
    float f3;
    while (i < j)
    {
      Scaler localScaler = (Scaler)this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a().get(i);
      f2 = this.jdField_a_of_type_Int + this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a() * localScaler.a();
      if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a(localScaler) == this.jdField_a_of_type_Long)
      {
        localObject1 = localObject2;
        if (i < j - 1) {
          localObject1 = (Scaler)this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a().get(i + 1);
        }
      }
      else
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a(localScaler) > this.jdField_a_of_type_Long) {
          break;
        }
      }
      if (this.jdField_a_of_type_Float == 0.0F) {
        this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidGraphicsPaint.measureText("a");
      }
      f3 = this.jdField_a_of_type_Float * 5.0F;
      if ((f2 >= getScrollX() - f3) && (f2 <= getScrollX() + getWidth() + f3))
      {
        f3 = this.jdField_b_of_type_Int;
        if (localScaler.b() == 1)
        {
          paramCanvas.drawCircle(f2, f3, this.jdField_c_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
        else if (localScaler.b() == 0)
        {
          localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a(localScaler);
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            int k = ((String)localObject2).length();
            if ((this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a(localScaler) == this.jdField_a_of_type_Long) && (i < j - 1)) {
              paramCanvas.drawText((String)localObject2, 0, k, f2 - this.jdField_a_of_type_Float * k / 2.0F, f1, this.jdField_b_of_type_AndroidGraphicsPaint);
            } else {
              paramCanvas.drawText((String)localObject2, 0, k, f2 - this.jdField_a_of_type_Float * k / 2.0F, f1, this.jdField_a_of_type_AndroidGraphicsPaint);
            }
          }
        }
      }
      i += 1;
      localObject2 = localObject1;
    }
    if (localObject2 != null)
    {
      f2 = this.jdField_a_of_type_Int;
      f3 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a();
      float f4 = ((Scaler)localObject2).a();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        i = this.jdField_a_of_type_JavaLangString.length();
        paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, 0, i, f2 + f3 * f4, f1, this.jdField_c_of_type_AndroidGraphicsPaint);
      }
    }
  }
  
  public void setMaxDurationLimit(long paramLong)
  {
    if (paramLong > 0L) {
      this.jdField_a_of_type_Long = paramLong;
    }
  }
  
  public void setMaxDurationLimitTip(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setTextSize(int paramInt)
  {
    this.d = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.timebar.ScaleTimeBar
 * JD-Core Version:    0.7.0.1
 */