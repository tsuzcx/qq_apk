package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import bhtq;
import com.tencent.biz.qqcircle.bizparts.danmaku.model.QzoneBarrageEffectData.BarrageEffectInfo;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;
import com.tencent.mobileqq.R.styleable;
import java.util.ArrayList;
import java.util.Iterator;
import vhp;
import vhq;
import vhr;
import vhs;
import vip;
import viw;
import vix;
import vje;
import vjg;

public class CellTextView
  extends View
  implements vjg
{
  protected int a;
  protected Context a;
  protected ColorStateList a;
  protected Paint a;
  private Handler a;
  protected View.OnClickListener a;
  public TextCell a;
  protected String a;
  protected ArrayList<TextCell> a;
  public vhs a;
  public vip a;
  public viw a;
  public boolean a;
  protected int b;
  protected ColorStateList b;
  public boolean b;
  protected int c;
  protected boolean c;
  protected int d;
  protected boolean d;
  
  public CellTextView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_Int = -16777216;
    this.jdField_b_of_type_Int = -16711936;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_Vhs = new vhp(this);
    this.jdField_a_of_type_AndroidOsHandler = new vhr(this, Looper.getMainLooper());
    a(paramContext, null, 0);
  }
  
  public CellTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_Int = -16777216;
    this.jdField_b_of_type_Int = -16711936;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_Vhs = new vhp(this);
    this.jdField_a_of_type_AndroidOsHandler = new vhr(this, Looper.getMainLooper());
    a(paramContext, paramAttributeSet, 0);
  }
  
  public CellTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_Int = -16777216;
    this.jdField_b_of_type_Int = -16711936;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_Vhs = new vhp(this);
    this.jdField_a_of_type_AndroidOsHandler = new vhr(this, Looper.getMainLooper());
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Vip != null) {
      this.jdField_a_of_type_Vip.l();
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Vip != null) {
      this.jdField_a_of_type_Vip.m();
    }
  }
  
  public static void setCanCopy(ArrayList<TextCell> paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        ((TextCell)paramArrayList.next()).setCanCopy(paramBoolean);
      }
    }
  }
  
  public float a()
  {
    a();
    return this.jdField_a_of_type_Vip.a();
  }
  
  public View a()
  {
    return this;
  }
  
  public String a()
  {
    a();
    return this.jdField_a_of_type_Vip.a();
  }
  
  public ArrayList<TextCell> a(CharSequence paramCharSequence)
  {
    return a(paramCharSequence, true);
  }
  
  public ArrayList<TextCell> a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    paramCharSequence = b(paramCharSequence, paramBoolean);
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramCharSequence);
    a();
    this.jdField_a_of_type_Vip.a(this.jdField_a_of_type_JavaUtilArrayList);
    requestLayout();
    invalidate();
    return paramCharSequence;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Vip == null) {
      this.jdField_a_of_type_Vip = new vip(this);
    }
    this.jdField_a_of_type_Vip.a(this);
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    a();
    setDrawBackground(this.jdField_d_of_type_Boolean);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CellTextView, paramInt, 0);
    int i4 = paramAttributeSet.getIndexCount();
    paramInt = 0;
    int m = 0;
    int k = 0;
    int j = 0;
    int i = 0;
    if (paramInt < i4)
    {
      int i5 = paramAttributeSet.getIndex(paramInt);
      int i3;
      int i2;
      int i1;
      int n;
      switch (i5)
      {
      default: 
        i3 = i;
        i2 = j;
        i1 = k;
        n = m;
      }
      for (;;)
      {
        paramInt += 1;
        m = n;
        k = i1;
        j = i2;
        i = i3;
        break;
        setTextSize(paramAttributeSet.getDimensionPixelSize(i5, (int)bhtq.a(13.0F)));
        n = m;
        i1 = k;
        i2 = j;
        i3 = i;
        continue;
        setTextColor(paramAttributeSet.getColor(i5, this.jdField_a_of_type_Int));
        n = m;
        i1 = k;
        i2 = j;
        i3 = i;
        continue;
        n = m;
        i1 = k;
        i2 = j;
        i3 = i;
        if (paramAttributeSet.getBoolean(i5, false))
        {
          setMaxLine(1);
          n = m;
          i1 = k;
          i2 = j;
          i3 = i;
          continue;
          setMaxWidth(paramAttributeSet.getDimensionPixelSize(i5, -1));
          n = m;
          i1 = k;
          i2 = j;
          i3 = i;
          continue;
          setMaxLine(paramAttributeSet.getInt(i5, -1));
          n = m;
          i1 = k;
          i2 = j;
          i3 = i;
          continue;
          setText(paramAttributeSet.getString(i5));
          n = m;
          i1 = k;
          i2 = j;
          i3 = i;
          continue;
          this.jdField_d_of_type_Int = paramAttributeSet.getInt(i5, -1);
          n = m;
          i1 = k;
          i2 = j;
          i3 = i;
          continue;
          this.jdField_c_of_type_Int = paramAttributeSet.getInt(i5, -1);
          n = m;
          i1 = k;
          i2 = j;
          i3 = i;
          continue;
          this.jdField_a_of_type_JavaLangString = paramAttributeSet.getString(i5);
          n = m;
          i1 = k;
          i2 = j;
          i3 = i;
          continue;
          i3 = paramAttributeSet.getDimensionPixelSize(i5, 0);
          n = m;
          i1 = k;
          i2 = j;
          continue;
          i2 = paramAttributeSet.getDimensionPixelSize(i5, 0);
          n = m;
          i1 = k;
          i3 = i;
          continue;
          i1 = paramAttributeSet.getDimensionPixelSize(i5, 0);
          n = m;
          i2 = j;
          i3 = i;
          continue;
          n = paramAttributeSet.getDimensionPixelSize(i5, 0);
          i1 = k;
          i2 = j;
          i3 = i;
        }
      }
    }
    setPadding(i, k, j, m);
    paramAttributeSet.recycle();
    setTextStyle(this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(TextCell paramTextCell)
  {
    if (paramTextCell == null) {
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
        this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(this);
      }
    }
    while (this.jdField_a_of_type_Viw == null) {
      return;
    }
    this.jdField_a_of_type_Viw.a(paramTextCell, this);
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2)
  {
    if (paramInt1 == 0) {}
    try
    {
      return performClick();
    }
    catch (Exception localException)
    {
      boolean bool;
      localException.printStackTrace();
    }
    if (6 == paramInt1)
    {
      bool = performLongClick();
      return bool;
    }
    return false;
  }
  
  public ArrayList<TextCell> b(CharSequence paramCharSequence, boolean paramBoolean)
  {
    return vje.a(this, paramCharSequence, this.jdField_a_of_type_Vip.a(a()), this.jdField_c_of_type_Boolean, paramBoolean);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0), 600L);
  }
  
  public void c()
  {
    requestLayout();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.jdField_b_of_type_AndroidContentResColorStateList != null)
    {
      this.jdField_b_of_type_Int = this.jdField_b_of_type_AndroidContentResColorStateList.getColorForState(getDrawableState(), this.jdField_b_of_type_Int);
      invalidate();
    }
    if (this.jdField_a_of_type_AndroidContentResColorStateList != null)
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentResColorStateList.getColorForState(getDrawableState(), this.jdField_a_of_type_Int);
      invalidate();
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a();
    this.jdField_a_of_type_Vip.a(this, paramCanvas);
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    a();
    int j = View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt1);
    int i = paramInt1;
    if (j == 0)
    {
      i = paramInt1;
      if (k == 0) {
        i = -2147483648;
      }
    }
    this.jdField_a_of_type_Vip.a(i, paramInt2);
    setMeasuredDimension(this.jdField_a_of_type_Vip.a(), this.jdField_a_of_type_Vip.b());
    setContentDescription(a());
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    a();
    return this.jdField_a_of_type_Vip.a(paramMotionEvent, this.jdField_a_of_type_AndroidOsHandler);
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    if (paramInt == 0) {
      e();
    }
    while (paramInt != 8) {
      return;
    }
    d();
  }
  
  public void requestLayout()
  {
    a();
    this.jdField_a_of_type_Vip.a();
    super.requestLayout();
  }
  
  public void setBarrageEffect(boolean paramBoolean, QzoneBarrageEffectData.BarrageEffectInfo paramBarrageEffectInfo)
  {
    a();
    this.jdField_a_of_type_Vip.a(paramBoolean, paramBarrageEffectInfo);
  }
  
  public void setCellClickable(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    a();
    this.jdField_a_of_type_Vip.c(paramBoolean);
  }
  
  public void setClickable(boolean paramBoolean)
  {
    super.setClickable(paramBoolean);
    a();
    this.jdField_a_of_type_Vip.f(paramBoolean);
  }
  
  public void setColorBackground(int paramInt)
  {
    a();
    this.jdField_a_of_type_Vip.a(this.jdField_d_of_type_Boolean);
  }
  
  public void setDrawBackground(boolean paramBoolean)
  {
    a();
    this.jdField_a_of_type_Vip.a(paramBoolean);
  }
  
  public void setDrawablePadding(int paramInt)
  {
    a();
    this.jdField_a_of_type_Vip.b(paramInt);
  }
  
  public void setEllipsisStr(String paramString)
  {
    a();
    this.jdField_a_of_type_Vip.a(paramString);
  }
  
  public void setFakeFeed(boolean paramBoolean)
  {
    a();
    this.jdField_a_of_type_Vip.j(paramBoolean);
  }
  
  public void setFont(int paramInt1, String paramString, int paramInt2)
  {
    setFont(paramInt1, paramString, paramInt2, null);
  }
  
  public void setFont(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    a();
    this.jdField_a_of_type_Vip.a(paramInt1, paramString1, paramInt2, paramString2);
  }
  
  public void setGradientColor(int[] paramArrayOfInt, float[] paramArrayOfFloat, GradientDrawable.Orientation paramOrientation)
  {
    a();
    this.jdField_a_of_type_Vip.a(paramArrayOfInt, paramArrayOfFloat, paramOrientation);
  }
  
  public void setHasMore(boolean paramBoolean)
  {
    a();
    this.jdField_a_of_type_Vip.k(paramBoolean);
  }
  
  public void setLineBreakInContent(boolean paramBoolean)
  {
    a();
    this.jdField_a_of_type_Vip.e(paramBoolean);
  }
  
  public void setLineBreakNeeded(boolean paramBoolean)
  {
    a();
    this.jdField_a_of_type_Vip.d(paramBoolean);
  }
  
  public void setLineSpace(int paramInt)
  {
    a();
    this.jdField_a_of_type_Vip.g(paramInt);
    invalidate();
  }
  
  public void setLongClickTrig(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setLongclickable(boolean paramBoolean)
  {
    this.jdField_a_of_type_Vip.g(paramBoolean);
    if (paramBoolean) {
      setOnLongClickListener(new vhq(this));
    }
  }
  
  public void setMaxCommentLine(int paramInt)
  {
    if (this.jdField_a_of_type_Vip != null) {
      this.jdField_a_of_type_Vip.a(paramInt, true);
    }
  }
  
  public void setMaxLine(int paramInt)
  {
    a();
    this.jdField_a_of_type_Vip.c(paramInt);
  }
  
  public void setMaxWidth(int paramInt)
  {
    a();
    this.jdField_a_of_type_Vip.j(paramInt);
  }
  
  public void setMeasuredTextCacheEnabled(boolean paramBoolean)
  {
    a();
    this.jdField_a_of_type_Vip.i(paramBoolean);
  }
  
  public void setNinePatchBackground(int paramInt)
  {
    this.jdField_a_of_type_Vip.a(paramInt);
  }
  
  public void setOnCellClickListener(viw paramviw)
  {
    this.jdField_a_of_type_Viw = paramviw;
    a();
    this.jdField_a_of_type_Vip.a(paramviw);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void setOnSideDrawableClickListener(vix paramvix)
  {
    a();
    this.jdField_a_of_type_Vip.a(paramvix);
  }
  
  public void setOnTextOperateListener(vhs paramvhs)
  {
    this.jdField_a_of_type_Vhs = paramvhs;
  }
  
  public void setOuterListener(ImageLoader.ImageLoadListener paramImageLoadListener)
  {
    if (this.jdField_a_of_type_Vip != null) {
      this.jdField_a_of_type_Vip.a(paramImageLoadListener);
    }
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    a();
    this.jdField_a_of_type_Vip.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setParseUrl(boolean paramBoolean) {}
  
  public void setRichText(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramCharSequence);
  }
  
  public void setShadowLayer(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a();
    this.jdField_a_of_type_Vip.b(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setShowMore(boolean paramBoolean)
  {
    a();
    this.jdField_a_of_type_Vip.b(paramBoolean);
  }
  
  public void setText(int paramInt)
  {
    setText(getResources().getString(paramInt));
  }
  
  public void setText(TextCell paramTextCell)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList.add(paramTextCell);
    a();
    this.jdField_a_of_type_Vip.a(paramTextCell);
    requestLayout();
    invalidate();
  }
  
  public void setText(String paramString)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList.add(new TextCell(0, paramString));
    a();
    this.jdField_a_of_type_Vip.a(this.jdField_a_of_type_JavaUtilArrayList);
    requestLayout();
    invalidate();
  }
  
  public void setText(ArrayList<TextCell> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    a();
    this.jdField_a_of_type_Vip.a(paramArrayList);
    requestLayout();
    invalidate();
  }
  
  public void setTextBold(boolean paramBoolean)
  {
    a();
    this.jdField_a_of_type_Vip.h(paramBoolean);
  }
  
  public void setTextColor(int paramInt)
  {
    a();
    this.jdField_a_of_type_Vip.f(paramInt);
    invalidate();
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    a();
    this.jdField_a_of_type_Vip.a(paramColorStateList);
    drawableStateChanged();
    invalidate();
  }
  
  public void setTextColorAnimation(ArrayList<Integer> paramArrayList, int paramInt)
  {
    a();
    this.jdField_a_of_type_Vip.a(paramArrayList, paramInt);
  }
  
  public void setTextColorLink(int paramInt)
  {
    a();
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Vip.h(paramInt);
    invalidate();
  }
  
  public void setTextColorLink(ColorStateList paramColorStateList)
  {
    a();
    this.jdField_a_of_type_Vip.b(paramColorStateList);
    drawableStateChanged();
    invalidate();
  }
  
  public void setTextColorLinkBackground(int paramInt)
  {
    a();
    this.jdField_a_of_type_Vip.i(paramInt);
  }
  
  public void setTextGravity(int paramInt)
  {
    a();
    this.jdField_a_of_type_Vip.e(paramInt);
  }
  
  public void setTextSize(float paramFloat)
  {
    a();
    this.jdField_a_of_type_Vip.a(paramFloat);
    requestLayout();
    invalidate();
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    Object localObject = getContext();
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources())
    {
      paramFloat = TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics());
      if (paramFloat != a()) {
        setTextSize(paramFloat);
      }
      return;
    }
  }
  
  public void setTextStyle(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Vip.a(paramString, paramInt1, paramInt2);
  }
  
  public void setUrlColorRes(int paramInt) {}
  
  public void setUseSoftLineBreak(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Vip != null) {
      this.jdField_a_of_type_Vip.l(paramBoolean);
    }
  }
  
  public void setUserNameRichText(TextCell paramTextCell, CharSequence paramCharSequence)
  {
    a(paramCharSequence);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(0, paramTextCell);
      requestLayout();
      invalidate();
    }
  }
  
  public void setmutiRichText(ArrayList<TextCell> paramArrayList, CharSequence paramCharSequence)
  {
    a(paramCharSequence);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(0, paramArrayList);
      requestLayout();
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.CellTextView
 * JD-Core Version:    0.7.0.1
 */