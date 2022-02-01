package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.R.styleable;
import java.io.PrintStream;
import java.util.HashMap;

public class KeyPosition
  extends KeyPositionBase
{
  static final int KEY_TYPE = 2;
  static final String NAME = "KeyPosition";
  private static final String PERCENT_X = "percentX";
  private static final String PERCENT_Y = "percentY";
  private static final String TAG = "KeyPosition";
  public static final int TYPE_CARTESIAN = 0;
  public static final int TYPE_PATH = 1;
  public static final int TYPE_SCREEN = 2;
  float mAltPercentX = (0.0F / 0.0F);
  float mAltPercentY = (0.0F / 0.0F);
  private float mCalculatedPositionX = (0.0F / 0.0F);
  private float mCalculatedPositionY = (0.0F / 0.0F);
  int mDrawPath = 0;
  int mPathMotionArc = UNSET;
  float mPercentHeight = (0.0F / 0.0F);
  float mPercentWidth = (0.0F / 0.0F);
  float mPercentX = (0.0F / 0.0F);
  float mPercentY = (0.0F / 0.0F);
  int mPositionType = 0;
  String mTransitionEasing = null;
  
  public KeyPosition()
  {
    this.mType = 2;
  }
  
  private void calcCartesianPosition(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f3 = paramFloat3 - paramFloat1;
    float f4 = paramFloat4 - paramFloat2;
    boolean bool = Float.isNaN(this.mPercentX);
    float f2 = 0.0F;
    if (bool) {
      paramFloat3 = 0.0F;
    } else {
      paramFloat3 = this.mPercentX;
    }
    if (Float.isNaN(this.mAltPercentY)) {
      paramFloat4 = 0.0F;
    } else {
      paramFloat4 = this.mAltPercentY;
    }
    float f1;
    if (Float.isNaN(this.mPercentY)) {
      f1 = 0.0F;
    } else {
      f1 = this.mPercentY;
    }
    if (!Float.isNaN(this.mAltPercentX)) {
      f2 = this.mAltPercentX;
    }
    this.mCalculatedPositionX = ((int)(paramFloat1 + paramFloat3 * f3 + f2 * f4));
    this.mCalculatedPositionY = ((int)(paramFloat2 + f3 * paramFloat4 + f4 * f1));
  }
  
  private void calcPathPosition(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat3 -= paramFloat1;
    paramFloat4 -= paramFloat2;
    float f1 = -paramFloat4;
    float f2 = this.mPercentX;
    float f3 = this.mPercentY;
    this.mCalculatedPositionX = (paramFloat1 + paramFloat3 * f2 + f1 * f3);
    this.mCalculatedPositionY = (paramFloat2 + paramFloat4 * f2 + paramFloat3 * f3);
  }
  
  private void calcScreenPosition(int paramInt1, int paramInt2)
  {
    float f1 = paramInt1 - 0;
    float f2 = this.mPercentX;
    float f3 = 0;
    this.mCalculatedPositionX = (f1 * f2 + f3);
    this.mCalculatedPositionY = ((paramInt2 - 0) * f2 + f3);
  }
  
  public void addValues(HashMap<String, SplineSet> paramHashMap) {}
  
  void calcPosition(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int i = this.mPositionType;
    if (i != 1)
    {
      if (i != 2)
      {
        calcCartesianPosition(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
        return;
      }
      calcScreenPosition(paramInt1, paramInt2);
      return;
    }
    calcPathPosition(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  float getPositionX()
  {
    return this.mCalculatedPositionX;
  }
  
  float getPositionY()
  {
    return this.mCalculatedPositionY;
  }
  
  public boolean intersects(int paramInt1, int paramInt2, RectF paramRectF1, RectF paramRectF2, float paramFloat1, float paramFloat2)
  {
    calcPosition(paramInt1, paramInt2, paramRectF1.centerX(), paramRectF1.centerY(), paramRectF2.centerX(), paramRectF2.centerY());
    return (Math.abs(paramFloat1 - this.mCalculatedPositionX) < 20.0F) && (Math.abs(paramFloat2 - this.mCalculatedPositionY) < 20.0F);
  }
  
  public void load(Context paramContext, AttributeSet paramAttributeSet)
  {
    KeyPosition.Loader.access$000(this, paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.KeyPosition));
  }
  
  public void positionAttributes(View paramView, RectF paramRectF1, RectF paramRectF2, float paramFloat1, float paramFloat2, String[] paramArrayOfString, float[] paramArrayOfFloat)
  {
    int i = this.mPositionType;
    if (i != 1)
    {
      if (i != 2)
      {
        positionCartAttributes(paramRectF1, paramRectF2, paramFloat1, paramFloat2, paramArrayOfString, paramArrayOfFloat);
        return;
      }
      positionScreenAttributes(paramView, paramRectF1, paramRectF2, paramFloat1, paramFloat2, paramArrayOfString, paramArrayOfFloat);
      return;
    }
    positionPathAttributes(paramRectF1, paramRectF2, paramFloat1, paramFloat2, paramArrayOfString, paramArrayOfFloat);
  }
  
  void positionCartAttributes(RectF paramRectF1, RectF paramRectF2, float paramFloat1, float paramFloat2, String[] paramArrayOfString, float[] paramArrayOfFloat)
  {
    float f1 = paramRectF1.centerX();
    float f2 = paramRectF1.centerY();
    float f4 = paramRectF2.centerX();
    float f3 = paramRectF2.centerY();
    f4 -= f1;
    f3 -= f2;
    if (paramArrayOfString[0] != null)
    {
      if ("percentX".equals(paramArrayOfString[0]))
      {
        paramArrayOfFloat[0] = ((paramFloat1 - f1) / f4);
        paramArrayOfFloat[1] = ((paramFloat2 - f2) / f3);
        return;
      }
      paramArrayOfFloat[1] = ((paramFloat1 - f1) / f4);
      paramArrayOfFloat[0] = ((paramFloat2 - f2) / f3);
      return;
    }
    paramArrayOfString[0] = "percentX";
    paramArrayOfFloat[0] = ((paramFloat1 - f1) / f4);
    paramArrayOfString[1] = "percentY";
    paramArrayOfFloat[1] = ((paramFloat2 - f2) / f3);
  }
  
  void positionPathAttributes(RectF paramRectF1, RectF paramRectF2, float paramFloat1, float paramFloat2, String[] paramArrayOfString, float[] paramArrayOfFloat)
  {
    float f1 = paramRectF1.centerX();
    float f3 = paramRectF1.centerY();
    float f4 = paramRectF2.centerX();
    float f2 = paramRectF2.centerY();
    f4 -= f1;
    float f5 = f2 - f3;
    f2 = (float)Math.hypot(f4, f5);
    if (f2 < 0.0001D)
    {
      System.out.println("distance ~ 0");
      paramArrayOfFloat[0] = 0.0F;
      paramArrayOfFloat[1] = 0.0F;
      return;
    }
    f4 /= f2;
    f5 /= f2;
    paramFloat2 -= f3;
    f1 = paramFloat1 - f1;
    paramFloat1 = (f4 * paramFloat2 - f1 * f5) / f2;
    paramFloat2 = (f4 * f1 + f5 * paramFloat2) / f2;
    if (paramArrayOfString[0] != null)
    {
      if ("percentX".equals(paramArrayOfString[0]))
      {
        paramArrayOfFloat[0] = paramFloat2;
        paramArrayOfFloat[1] = paramFloat1;
      }
    }
    else
    {
      paramArrayOfString[0] = "percentX";
      paramArrayOfString[1] = "percentY";
      paramArrayOfFloat[0] = paramFloat2;
      paramArrayOfFloat[1] = paramFloat1;
    }
  }
  
  void positionScreenAttributes(View paramView, RectF paramRectF1, RectF paramRectF2, float paramFloat1, float paramFloat2, String[] paramArrayOfString, float[] paramArrayOfFloat)
  {
    paramRectF1.centerX();
    paramRectF1.centerY();
    paramRectF2.centerX();
    paramRectF2.centerY();
    paramView = (ViewGroup)paramView.getParent();
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    if (paramArrayOfString[0] != null)
    {
      if ("percentX".equals(paramArrayOfString[0]))
      {
        paramArrayOfFloat[0] = (paramFloat1 / i);
        paramArrayOfFloat[1] = (paramFloat2 / j);
        return;
      }
      paramArrayOfFloat[1] = (paramFloat1 / i);
      paramArrayOfFloat[0] = (paramFloat2 / j);
      return;
    }
    paramArrayOfString[0] = "percentX";
    paramArrayOfFloat[0] = (paramFloat1 / i);
    paramArrayOfString[1] = "percentY";
    paramArrayOfFloat[1] = (paramFloat2 / j);
  }
  
  public void setValue(String paramString, Object paramObject)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 428090548: 
      if (paramString.equals("percentY")) {
        i = 6;
      }
      break;
    case 428090547: 
      if (paramString.equals("percentX")) {
        i = 5;
      }
      break;
    case -200259324: 
      if (paramString.equals("sizePercent")) {
        i = 4;
      }
      break;
    case -827014263: 
      if (paramString.equals("drawPath")) {
        i = 1;
      }
      break;
    case -1017587252: 
      if (paramString.equals("percentHeight")) {
        i = 3;
      }
      break;
    case -1127236479: 
      if (paramString.equals("percentWidth")) {
        i = 2;
      }
      break;
    case -1812823328: 
      if (paramString.equals("transitionEasing")) {
        i = 0;
      }
      break;
    }
    int i = -1;
    switch (i)
    {
    default: 
      return;
    case 6: 
      this.mPercentY = toFloat(paramObject);
      return;
    case 5: 
      this.mPercentX = toFloat(paramObject);
      return;
    case 4: 
      float f = toFloat(paramObject);
      this.mPercentWidth = f;
      this.mPercentHeight = f;
      return;
    case 3: 
      this.mPercentHeight = toFloat(paramObject);
      return;
    case 2: 
      this.mPercentWidth = toFloat(paramObject);
      return;
    case 1: 
      this.mDrawPath = toInt(paramObject);
      return;
    }
    this.mTransitionEasing = paramObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.KeyPosition
 * JD-Core Version:    0.7.0.1
 */