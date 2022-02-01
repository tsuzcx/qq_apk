package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R.styleable;

public class MotionTelltales
  extends MockView
{
  private static final String TAG = "MotionTelltales";
  Matrix mInvertMatrix = new Matrix();
  MotionLayout mMotionLayout;
  private Paint mPaintTelltales = new Paint();
  int mTailColor = -65281;
  float mTailScale = 0.25F;
  int mVelocityMode = 0;
  float[] velocity = new float[2];
  
  public MotionTelltales(Context paramContext)
  {
    super(paramContext);
    init(paramContext, null);
  }
  
  public MotionTelltales(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }
  
  public MotionTelltales(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MotionTelltales);
      int j = paramContext.getIndexCount();
      int i = 0;
      while (i < j)
      {
        int k = paramContext.getIndex(i);
        if (k == R.styleable.MotionTelltales_telltales_tailColor) {
          this.mTailColor = paramContext.getColor(k, this.mTailColor);
        } else if (k == R.styleable.MotionTelltales_telltales_velocityMode) {
          this.mVelocityMode = paramContext.getInt(k, this.mVelocityMode);
        } else if (k == R.styleable.MotionTelltales_telltales_tailScale) {
          this.mTailScale = paramContext.getFloat(k, this.mTailScale);
        }
        i += 1;
      }
    }
    this.mPaintTelltales.setColor(this.mTailColor);
    this.mPaintTelltales.setStrokeWidth(5.0F);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    getMatrix().invert(this.mInvertMatrix);
    if (this.mMotionLayout == null)
    {
      paramCanvas = getParent();
      if ((paramCanvas instanceof MotionLayout)) {
        this.mMotionLayout = ((MotionLayout)paramCanvas);
      }
      return;
    }
    int k = getWidth();
    int m = getHeight();
    float[] arrayOfFloat1 = new float[5];
    float[] tmp64_62 = arrayOfFloat1;
    tmp64_62[0] = 0.1F;
    float[] tmp69_64 = tmp64_62;
    tmp69_64[1] = 0.25F;
    float[] tmp74_69 = tmp69_64;
    tmp74_69[2] = 0.5F;
    float[] tmp79_74 = tmp74_69;
    tmp79_74[3] = 0.75F;
    float[] tmp84_79 = tmp79_74;
    tmp84_79[4] = 0.9F;
    tmp84_79;
    int i = 0;
    while (i < arrayOfFloat1.length)
    {
      float f1 = arrayOfFloat1[i];
      int j = 0;
      while (j < arrayOfFloat1.length)
      {
        float f2 = arrayOfFloat1[j];
        this.mMotionLayout.getViewVelocity(this, f2, f1, this.velocity, this.mVelocityMode);
        this.mInvertMatrix.mapVectors(this.velocity);
        f2 = k * f2;
        float f3 = m * f1;
        float[] arrayOfFloat2 = this.velocity;
        float f4 = arrayOfFloat2[0];
        float f5 = this.mTailScale;
        float f6 = arrayOfFloat2[1];
        this.mInvertMatrix.mapVectors(arrayOfFloat2);
        paramCanvas.drawLine(f2, f3, f2 - f4 * f5, f3 - f6 * f5, this.mPaintTelltales);
        j += 1;
      }
      i += 1;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    postInvalidate();
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    this.mText = paramCharSequence.toString();
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.utils.widget.MotionTelltales
 * JD-Core Version:    0.7.0.1
 */