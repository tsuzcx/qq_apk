package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import cooperation.qqcircle.helpers.QCircleSkinHelper;

public class QCircleMarqueeTextView
  extends View
{
  private float a;
  private boolean b;
  private Paint c;
  private String d;
  private float e;
  private float f;
  private float g;
  private int h;
  private float i;
  private float j;
  private int k;
  
  public QCircleMarqueeTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleMarqueeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  /* Error */
  public QCircleMarqueeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 32	android/view/View:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: iconst_1
    //   9: putfield 34	com/tencent/biz/qqcircle/widgets/QCircleMarqueeTextView:b	Z
    //   12: aconst_null
    //   13: astore 4
    //   15: aconst_null
    //   16: astore 5
    //   18: aload_1
    //   19: aload_2
    //   20: getstatic 40	com/tencent/mobileqq/biz/qcircle/R$styleable:cG	[I
    //   23: invokevirtual 46	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   26: astore_2
    //   27: aload_2
    //   28: astore 5
    //   30: aload_2
    //   31: astore 4
    //   33: aload_0
    //   34: aload_2
    //   35: getstatic 49	com/tencent/mobileqq/biz/qcircle/R$styleable:cJ	I
    //   38: ldc 50
    //   40: invokestatic 55	com/tencent/biz/qqcircle/utils/ViewUtils:a	(F)I
    //   43: invokevirtual 61	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   46: i2f
    //   47: putfield 63	com/tencent/biz/qqcircle/widgets/QCircleMarqueeTextView:j	F
    //   50: aload_2
    //   51: astore 5
    //   53: aload_2
    //   54: astore 4
    //   56: aload_0
    //   57: aload_2
    //   58: getstatic 66	com/tencent/mobileqq/biz/qcircle/R$styleable:cI	I
    //   61: ldc 67
    //   63: invokevirtual 70	android/content/res/TypedArray:getResourceId	(II)I
    //   66: putfield 72	com/tencent/biz/qqcircle/widgets/QCircleMarqueeTextView:k	I
    //   69: aload_2
    //   70: astore 5
    //   72: aload_2
    //   73: astore 4
    //   75: aload_0
    //   76: aload_2
    //   77: getstatic 75	com/tencent/mobileqq/biz/qcircle/R$styleable:cK	I
    //   80: fconst_1
    //   81: invokevirtual 79	android/content/res/TypedArray:getFloat	(IF)F
    //   84: invokestatic 55	com/tencent/biz/qqcircle/utils/ViewUtils:a	(F)I
    //   87: i2f
    //   88: putfield 81	com/tencent/biz/qqcircle/widgets/QCircleMarqueeTextView:a	F
    //   91: aload_2
    //   92: astore 5
    //   94: aload_2
    //   95: astore 4
    //   97: aload_0
    //   98: aload_2
    //   99: getstatic 84	com/tencent/mobileqq/biz/qcircle/R$styleable:cH	I
    //   102: invokevirtual 88	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   105: putfield 90	com/tencent/biz/qqcircle/widgets/QCircleMarqueeTextView:d	Ljava/lang/String;
    //   108: aload_2
    //   109: ifnull +31 -> 140
    //   112: goto +24 -> 136
    //   115: astore_1
    //   116: goto +30 -> 146
    //   119: astore_2
    //   120: aload 4
    //   122: astore 5
    //   124: aload_2
    //   125: invokevirtual 94	java/lang/Exception:printStackTrace	()V
    //   128: aload 4
    //   130: ifnull +10 -> 140
    //   133: aload 4
    //   135: astore_2
    //   136: aload_2
    //   137: invokevirtual 97	android/content/res/TypedArray:recycle	()V
    //   140: aload_0
    //   141: aload_1
    //   142: invokespecial 99	com/tencent/biz/qqcircle/widgets/QCircleMarqueeTextView:a	(Landroid/content/Context;)V
    //   145: return
    //   146: aload 5
    //   148: ifnull +8 -> 156
    //   151: aload 5
    //   153: invokevirtual 97	android/content/res/TypedArray:recycle	()V
    //   156: aload_1
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	QCircleMarqueeTextView
    //   0	158	1	paramContext	Context
    //   0	158	2	paramAttributeSet	AttributeSet
    //   0	158	3	paramInt	int
    //   13	121	4	localAttributeSet1	AttributeSet
    //   16	136	5	localAttributeSet2	AttributeSet
    // Exception table:
    //   from	to	target	type
    //   18	27	115	finally
    //   33	50	115	finally
    //   56	69	115	finally
    //   75	91	115	finally
    //   97	108	115	finally
    //   124	128	115	finally
    //   18	27	119	java/lang/Exception
    //   33	50	119	java/lang/Exception
    //   56	69	119	java/lang/Exception
    //   75	91	119	java/lang/Exception
    //   97	108	119	java/lang/Exception
  }
  
  private int a(int paramInt)
  {
    int m = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (m == 1073741824) {
      return paramInt;
    }
    int n = (int)this.c.measureText(this.d);
    if (m == -2147483648) {
      return Math.min(n, paramInt);
    }
    return n;
  }
  
  private void a(Context paramContext)
  {
    if (TextUtils.isEmpty(this.d)) {
      this.d = "";
    }
    this.c = new Paint();
    this.c.setAntiAlias(true);
    this.c.setTextSize(this.j);
    this.c.setColor(QCircleSkinHelper.getInstance().getColor(this.k));
  }
  
  private int b(int paramInt)
  {
    int m = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (m == 1073741824) {
      return paramInt;
    }
    int n = (int)this.c.getTextSize() + getPaddingTop() + getPaddingBottom();
    if (m == -2147483648) {
      return Math.min(n, paramInt);
    }
    return n;
  }
  
  public float getTextSpeed()
  {
    return this.a;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (paramCanvas != null)
    {
      String str = this.d;
      if (str != null)
      {
        Paint localPaint = this.c;
        if (localPaint == null) {
          return;
        }
        if (!this.b) {
          return;
        }
        paramCanvas.drawText(str, this.e, this.f, localPaint);
        float f1 = this.e;
        float f2 = this.g;
        float f3 = this.h;
        float f4 = this.i;
        if ((f1 + f2 < f3 + f4) && (f1 < 0.0F)) {
          paramCanvas.drawText(this.d, f1 + f2 + f4, this.f, this.c);
        }
        this.e -= this.a;
        f1 = this.e;
        if ((this.g + f1 + this.i < 0.0F) && (f1 < 0.0F)) {
          this.e = 0.0F;
        }
        invalidate();
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.e = 0.0F;
    this.g = this.c.measureText(this.d);
    this.h = a(paramInt1);
    this.f = (getPaddingTop() + Math.abs(this.c.ascent()));
    paramInt2 = b(paramInt2);
    int m;
    for (;;)
    {
      float f1 = this.g;
      m = this.h;
      if (f1 > m) {
        break;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.d);
      localStringBuilder.append("     ");
      localStringBuilder.append(this.d);
      this.d = localStringBuilder.toString();
      this.g = this.c.measureText(this.d);
      this.h = a(paramInt1);
    }
    setMeasuredDimension(m, paramInt2);
  }
  
  public void setScroll(boolean paramBoolean)
  {
    this.b = paramBoolean;
    invalidate();
  }
  
  public void setText(String paramString)
  {
    this.d = paramString;
    if (TextUtils.isEmpty(this.d)) {
      this.d = "";
    }
    this.i = this.c.measureText("     ");
    this.e = 0.0F;
    requestLayout();
    invalidate();
  }
  
  public void setTextColor(int paramInt)
  {
    this.k = paramInt;
    this.c.setColor(paramInt);
    invalidate();
  }
  
  public void setTextSize(float paramFloat)
  {
    this.j = paramFloat;
    this.c.setTextSize(paramFloat);
    requestLayout();
    invalidate();
  }
  
  public void setTextSpeed(float paramFloat)
  {
    this.a = paramFloat;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleMarqueeTextView
 * JD-Core Version:    0.7.0.1
 */