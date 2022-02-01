package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.PaintDrawable;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.VirtualViewUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public abstract class Layout
  extends ViewBase
{
  private static final String TAG = "Layout_TMTEST";
  protected Layout.GradientColorBg mGradientColorBg;
  protected List<ViewBase> mSubViews = new ArrayList();
  
  public Layout(VafContext paramVafContext)
  {
    super(paramVafContext);
  }
  
  public static int getChildMeasureSpec(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = Math.max(0, View.MeasureSpec.getSize(paramInt1) - paramInt2);
    int i = 1073741824;
    if (j != -2147483648)
    {
      if (j != 0)
      {
        if (j != 1073741824) {
          break label142;
        }
        if (paramInt3 >= 0)
        {
          paramInt2 = paramInt3;
          if (paramInt1 > 0)
          {
            paramInt2 = paramInt3;
            if (paramInt3 > paramInt1) {
              paramInt2 = paramInt1;
            }
          }
        }
        else
        {
          if (paramInt3 == -1)
          {
            paramInt2 = i;
            break label146;
          }
          if (paramInt3 != -2) {
            break label142;
          }
          break label127;
        }
      }
      else if (paramInt3 >= 0)
      {
        paramInt2 = paramInt3;
      }
      else
      {
        if (paramInt3 == -1) {
          break label144;
        }
        while (paramInt3 == -2) {}
      }
    }
    else
    {
      if (paramInt3 < 0) {
        break label122;
      }
      paramInt2 = paramInt3;
    }
    paramInt1 = paramInt2;
    paramInt2 = i;
    break label146;
    label122:
    if (paramInt3 == -1) {}
    label127:
    while (paramInt3 == -2)
    {
      paramInt2 = -2147483648;
      break;
    }
    label142:
    paramInt1 = 0;
    label144:
    paramInt2 = 0;
    label146:
    return View.MeasureSpec.makeMeasureSpec(paramInt1, paramInt2);
  }
  
  public void addView(ViewBase paramViewBase)
  {
    if (LogUtils.shouldLog())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[addView] ");
      localStringBuilder.append(paramViewBase.mName);
      LogUtils.d("Layout_TMTEST", localStringBuilder.toString());
    }
    if (paramViewBase != null)
    {
      this.mSubViews.add(paramViewBase);
      paramViewBase.mParent = this;
    }
  }
  
  public void comDraw(Canvas paramCanvas)
  {
    super.comDraw(paramCanvas);
    Iterator localIterator = this.mSubViews.iterator();
    while (localIterator.hasNext())
    {
      ViewBase localViewBase = (ViewBase)localIterator.next();
      if (localViewBase.shouldDraw()) {
        localViewBase.comDraw(paramCanvas);
      }
    }
  }
  
  public void destroy()
  {
    super.destroy();
    Iterator localIterator = this.mSubViews.iterator();
    while (localIterator.hasNext()) {
      ((ViewBase)localIterator.next()).destroy();
    }
    this.mSubViews.clear();
  }
  
  public ViewBase findViewBaseByName(String paramString)
  {
    ViewBase localViewBase2 = super.findViewBaseByName(paramString);
    ViewBase localViewBase1 = localViewBase2;
    if (localViewBase2 == null)
    {
      Iterator localIterator = this.mSubViews.iterator();
      localViewBase1 = localViewBase2;
      while (localIterator.hasNext())
      {
        localViewBase2 = ((ViewBase)localIterator.next()).findViewBaseByName(paramString);
        localViewBase1 = localViewBase2;
        if (localViewBase2 != null) {
          localViewBase1 = localViewBase2;
        }
      }
    }
    return localViewBase1;
  }
  
  public Layout.Params generateParams()
  {
    return new Layout.Params();
  }
  
  public ViewBase getChild(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < this.mSubViews.size())) {
      return (ViewBase)this.mSubViews.get(paramInt);
    }
    return null;
  }
  
  public final List<ViewBase> getSubViews()
  {
    return this.mSubViews;
  }
  
  protected void measureComChild(ViewBase paramViewBase, int paramInt1, int paramInt2)
  {
    Layout.Params localParams = paramViewBase.getComLayoutParams();
    paramViewBase.measureComponent(getChildMeasureSpec(paramInt1, this.mPaddingLeft + this.mPaddingRight + (this.mBorderWidth << 1) + localParams.mLayoutMarginLeft + localParams.mLayoutMarginRight, localParams.mLayoutWidth), getChildMeasureSpec(paramInt2, this.mPaddingTop + this.mPaddingBottom + (this.mBorderWidth << 1) + localParams.mLayoutMarginTop + localParams.mLayoutMarginBottom, localParams.mLayoutHeight));
  }
  
  protected void onComDraw(Canvas paramCanvas)
  {
    super.onComDraw(paramCanvas);
    if (this.mBorderWidth > 0)
    {
      if (this.mBorderPaint == null)
      {
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
      }
      this.mBorderPaint.setColor(this.mBorderColor);
      this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
      VirtualViewUtils.drawBorder(paramCanvas, this.mBorderPaint, this.mMeasuredWidth, this.mMeasuredHeight, this.mBorderWidth, this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
    }
    paramCanvas = this.mGradientColorBg;
    if (paramCanvas != null) {
      setBackgroundColor(paramCanvas);
    }
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    if (this.mPaint == null)
    {
      this.mPaint = new Paint();
      this.mPaint.setStyle(Paint.Style.FILL);
    }
    if (this.mBorderWidth > 0)
    {
      if (this.mBorderPaint == null)
      {
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
      }
      this.mBorderPaint.setColor(this.mBorderColor);
      this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
    }
  }
  
  public void reset()
  {
    super.reset();
    Iterator localIterator = this.mSubViews.iterator();
    while (localIterator.hasNext()) {
      ((ViewBase)localIterator.next()).reset();
    }
  }
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    if ((paramInt == 56) || (paramInt == 57))
    {
      try
      {
        if (!(paramObject instanceof JSONArray)) {
          break label295;
        }
        localJSONArray = (JSONArray)paramObject;
        if (localJSONArray.length() < 3) {
          break label295;
        }
        localGradientColorBg = new Layout.GradientColorBg();
        localGradientColorBg.isHorizontal = "0".equals(localJSONArray.get(2).toString());
        i = Utils.parseColor(localJSONArray.get(0).toString());
        j = Utils.parseColor(localJSONArray.get(1).toString());
        localGradientColorBg.startColor = i;
        localGradientColorBg.endColor = j;
        this.mGradientColorBg = localGradientColorBg;
        return true;
      }
      catch (Exception localException)
      {
        JSONArray localJSONArray;
        Layout.GradientColorBg localGradientColorBg;
        int i;
        int j;
        Float localFloat1;
        Float localFloat2;
        localException.printStackTrace();
      }
      if ((paramObject instanceof JSONArray))
      {
        localJSONArray = (JSONArray)paramObject;
        if (localJSONArray.length() >= 4)
        {
          localGradientColorBg = new Layout.GradientColorBg();
          localFloat1 = Utils.toFloat(localJSONArray.get(0));
          localFloat2 = Utils.toFloat(localJSONArray.get(1));
          j = Utils.parseColor(localJSONArray.get(2).toString());
          localGradientColorBg.isHorizontal = "0".equals(localJSONArray.get(3).toString());
          i = Color.argb((int)(localFloat1.floatValue() * 255.0F), Color.red(j), Color.green(j), Color.blue(j));
          j = Color.argb((int)(localFloat2.floatValue() * 255.0F), Color.red(j), Color.green(j), Color.blue(j));
          localGradientColorBg.startColor = i;
          localGradientColorBg.endColor = j;
          this.mGradientColorBg = localGradientColorBg;
        }
      }
      return true;
    }
    else
    {
      return super.setAttribute(paramInt, paramObject);
    }
    label295:
    return true;
  }
  
  protected boolean setAttribute(int paramInt, String paramString)
  {
    boolean bool2 = super.setAttribute(paramInt, paramString);
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = false;
    }
    return bool1;
  }
  
  protected void setBackgroundColor(Layout.GradientColorBg paramGradientColorBg)
  {
    if (paramGradientColorBg != null)
    {
      if (paramGradientColorBg.hasSetBg) {
        return;
      }
      paramGradientColorBg.hasSetBg = true;
      View localView = getNativeView();
      if (localView != null)
      {
        PaintDrawable localPaintDrawable = new PaintDrawable();
        int i;
        int j;
        if (paramGradientColorBg.isHorizontal)
        {
          i = getWidth();
          j = 0;
        }
        else
        {
          j = getHeight();
          i = 0;
        }
        localPaintDrawable.setCornerRadii(new float[] { this.mBorderTopLeftRadius, this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderTopRightRadius, this.mBorderBottomRightRadius, this.mBorderBottomRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomLeftRadius });
        paramGradientColorBg = new LinearGradient(0.0F, 0.0F, i, j, paramGradientColorBg.startColor, paramGradientColorBg.endColor, Shader.TileMode.CLAMP);
        Paint localPaint = localPaintDrawable.getPaint();
        if (localPaint != null) {
          localPaint.setShader(paramGradientColorBg);
        }
        localView.setBackgroundDrawable(localPaintDrawable);
      }
    }
  }
  
  public void setVisibility(int paramInt)
  {
    if (getNativeView() != null) {
      super.setVisibility(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout
 * JD-Core Version:    0.7.0.1
 */