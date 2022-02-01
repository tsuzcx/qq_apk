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
import com.tencent.biz.qqcircle.bizparts.danmaku.model.QzoneBarrageEffectData.BarrageEffectInfo;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;
import com.tencent.mobileqq.biz.qcircle.R.styleable;
import java.util.ArrayList;
import java.util.Iterator;

public class CellTextView
  extends View
  implements TextLayoutBase, TouchBehaviorListener
{
  protected Paint a = new Paint(1);
  protected ArrayList<TextCell> b;
  protected boolean c = false;
  protected int d = -16777216;
  protected int e = -16711936;
  protected ColorStateList f = null;
  protected ColorStateList g = null;
  protected TextCell h;
  protected boolean i = false;
  protected TextCellLayout.OnCellClickListener j;
  protected View.OnClickListener k;
  protected boolean l = true;
  protected boolean m = false;
  protected TextCellLayout n;
  protected String o = null;
  protected int p = -1;
  protected int q = -1;
  protected CellTextView.OnTextOperater r = new CellTextView.1(this);
  protected Context s = null;
  private Handler t = new CellTextView.3(this, Looper.getMainLooper());
  private boolean u = false;
  
  public CellTextView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null, 0);
  }
  
  public CellTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0);
  }
  
  public CellTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  private void e()
  {
    TextCellLayout localTextCellLayout = this.n;
    if (localTextCellLayout != null) {
      localTextCellLayout.y();
    }
  }
  
  private void f()
  {
    TextCellLayout localTextCellLayout = this.n;
    if (localTextCellLayout != null) {
      localTextCellLayout.z();
    }
  }
  
  private String getCopiedText()
  {
    a();
    return this.n.e();
  }
  
  public static void setCanCopy(ArrayList<TextCell> paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList == null) {
      return;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      ((TextCell)paramArrayList.next()).setCanCopy(paramBoolean);
    }
  }
  
  public ArrayList<TextCell> a(CharSequence paramCharSequence)
  {
    return a(paramCharSequence, true);
  }
  
  public ArrayList<TextCell> a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    paramCharSequence = b(paramCharSequence, paramBoolean);
    if (this.b == null) {
      this.b = new ArrayList();
    }
    this.b.clear();
    this.b.addAll(paramCharSequence);
    a();
    this.n.a(this.b);
    requestLayout();
    invalidate();
    return paramCharSequence;
  }
  
  protected void a()
  {
    if (this.n == null) {
      this.n = new TextCellLayout(this);
    }
    this.n.a(this);
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    a();
    setDrawBackground(this.m);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.C, paramInt, 0);
    int i9 = paramAttributeSet.getIndexCount();
    int i3 = 0;
    int i4 = 0;
    int i2 = 0;
    int i1 = 0;
    int i8;
    for (paramInt = 0; i3 < i9; paramInt = i8)
    {
      int i10 = paramAttributeSet.getIndex(i3);
      int i5;
      int i6;
      int i7;
      if (i10 == R.styleable.D)
      {
        setTextSize(paramAttributeSet.getDimensionPixelSize(i10, (int)ViewUtils.c(13.0F)));
        i5 = i4;
        i6 = i2;
        i7 = i1;
        i8 = paramInt;
      }
      else if (i10 == R.styleable.G)
      {
        setTextColor(paramAttributeSet.getColor(i10, this.d));
        i5 = i4;
        i6 = i2;
        i7 = i1;
        i8 = paramInt;
      }
      else if (i10 == R.styleable.O)
      {
        i5 = i4;
        i6 = i2;
        i7 = i1;
        i8 = paramInt;
        if (paramAttributeSet.getBoolean(i10, false))
        {
          setMaxLine(1);
          i5 = i4;
          i6 = i2;
          i7 = i1;
          i8 = paramInt;
        }
      }
      else if (i10 == R.styleable.L)
      {
        setMaxWidth(paramAttributeSet.getDimensionPixelSize(i10, -1));
        i5 = i4;
        i6 = i2;
        i7 = i1;
        i8 = paramInt;
      }
      else if (i10 == R.styleable.N)
      {
        setMaxLine(paramAttributeSet.getInt(i10, -1));
        i5 = i4;
        i6 = i2;
        i7 = i1;
        i8 = paramInt;
      }
      else if (i10 == R.styleable.M)
      {
        setText(paramAttributeSet.getString(i10));
        i5 = i4;
        i6 = i2;
        i7 = i1;
        i8 = paramInt;
      }
      else if (i10 == R.styleable.F)
      {
        this.q = paramAttributeSet.getInt(i10, -1);
        i5 = i4;
        i6 = i2;
        i7 = i1;
        i8 = paramInt;
      }
      else if (i10 == R.styleable.E)
      {
        this.p = paramAttributeSet.getInt(i10, -1);
        i5 = i4;
        i6 = i2;
        i7 = i1;
        i8 = paramInt;
      }
      else if (i10 == R.styleable.P)
      {
        this.o = paramAttributeSet.getString(i10);
        i5 = i4;
        i6 = i2;
        i7 = i1;
        i8 = paramInt;
      }
      else if (i10 == R.styleable.H)
      {
        i5 = paramAttributeSet.getDimensionPixelSize(i10, 0);
        i6 = i2;
        i7 = i1;
        i8 = paramInt;
      }
      else if (i10 == R.styleable.J)
      {
        i7 = paramAttributeSet.getDimensionPixelSize(i10, 0);
        i5 = i4;
        i6 = i2;
        i8 = paramInt;
      }
      else if (i10 == R.styleable.I)
      {
        i6 = paramAttributeSet.getDimensionPixelSize(i10, 0);
        i5 = i4;
        i7 = i1;
        i8 = paramInt;
      }
      else
      {
        i5 = i4;
        i6 = i2;
        i7 = i1;
        i8 = paramInt;
        if (i10 == R.styleable.K)
        {
          i8 = paramAttributeSet.getDimensionPixelSize(i10, 0);
          i7 = i1;
          i6 = i2;
          i5 = i4;
        }
      }
      i3 += 1;
      i4 = i5;
      i2 = i6;
      i1 = i7;
    }
    setPadding(i4, i2, i1, paramInt);
    paramAttributeSet.recycle();
    setTextStyle(this.o, this.p, this.q);
    this.s = paramContext;
  }
  
  public void a(TextCell paramTextCell)
  {
    if (paramTextCell == null)
    {
      paramTextCell = this.k;
      if (paramTextCell != null) {
        paramTextCell.onClick(this);
      }
    }
    else
    {
      TextCellLayout.OnCellClickListener localOnCellClickListener = this.j;
      if (localOnCellClickListener != null) {
        localOnCellClickListener.a(paramTextCell, this);
      }
    }
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
      label24:
      Object localObject;
      break label24;
    }
    if (6 == paramInt1)
    {
      bool = performLongClick();
      return bool;
      localObject.printStackTrace();
    }
    return false;
  }
  
  public ArrayList<TextCell> b(CharSequence paramCharSequence, boolean paramBoolean)
  {
    return TextCellParser.a(this, paramCharSequence, this.n.c(getTextSize()), this.l, paramBoolean);
  }
  
  public void b()
  {
    Handler localHandler = this.t;
    localHandler.sendMessageDelayed(localHandler.obtainMessage(0), 600L);
  }
  
  public void c()
  {
    requestLayout();
  }
  
  public boolean d()
  {
    return this.i;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    ColorStateList localColorStateList = this.g;
    if (localColorStateList != null)
    {
      this.e = localColorStateList.getColorForState(getDrawableState(), this.e);
      invalidate();
    }
    localColorStateList = this.f;
    if (localColorStateList != null)
    {
      this.d = localColorStateList.getColorForState(getDrawableState(), this.d);
      invalidate();
    }
  }
  
  public View getAttachedView()
  {
    return this;
  }
  
  public String getDisplayedText()
  {
    a();
    return this.n.f();
  }
  
  public int getLineCount()
  {
    TextCellLayout localTextCellLayout = this.n;
    if (localTextCellLayout != null) {
      return localTextCellLayout.m();
    }
    return 0;
  }
  
  public CellTextView.OnTextOperater getOnTextOperator()
  {
    return this.r;
  }
  
  public Paint getPaint()
  {
    a();
    return this.n.q();
  }
  
  public String getText()
  {
    a();
    return this.n.j();
  }
  
  public float getTextSize()
  {
    a();
    return this.n.g();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a();
    this.n.a(this, paramCanvas);
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    a();
    int i2 = View.MeasureSpec.getMode(paramInt1);
    int i3 = View.MeasureSpec.getSize(paramInt1);
    int i1 = paramInt1;
    if (i2 == 0)
    {
      i1 = paramInt1;
      if (i3 == 0) {
        i1 = -2147483648;
      }
    }
    this.n.a(i1, paramInt2);
    setMeasuredDimension(this.n.c(), this.n.d());
    setContentDescription(getDisplayedText());
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    a();
    return this.n.a(paramMotionEvent, this.t);
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    if (paramInt == 0)
    {
      f();
      return;
    }
    if (paramInt == 8) {
      e();
    }
  }
  
  public void requestLayout()
  {
    a();
    this.n.h();
    super.requestLayout();
  }
  
  public void setBarrageEffect(boolean paramBoolean, QzoneBarrageEffectData.BarrageEffectInfo paramBarrageEffectInfo)
  {
    a();
    this.n.a(paramBoolean, paramBarrageEffectInfo);
  }
  
  public void setCellClickable(boolean paramBoolean)
  {
    this.l = paramBoolean;
    a();
    this.n.c(paramBoolean);
  }
  
  public void setClickable(boolean paramBoolean)
  {
    super.setClickable(paramBoolean);
    a();
    this.n.f(paramBoolean);
  }
  
  public void setColorBackground(int paramInt)
  {
    a();
    this.n.a(this.m);
  }
  
  public void setDrawBackground(boolean paramBoolean)
  {
    a();
    this.n.a(paramBoolean);
  }
  
  public void setDrawablePadding(int paramInt)
  {
    a();
    this.n.b(paramInt);
  }
  
  public void setEllipsisStr(String paramString)
  {
    a();
    this.n.a(paramString);
  }
  
  public void setFakeFeed(boolean paramBoolean)
  {
    a();
    this.n.j(paramBoolean);
  }
  
  public void setFont(int paramInt1, String paramString, int paramInt2)
  {
    setFont(paramInt1, paramString, paramInt2, null);
  }
  
  public void setFont(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    a();
    this.n.a(paramInt1, paramString1, paramInt2, paramString2);
  }
  
  public void setGradientColor(int[] paramArrayOfInt, float[] paramArrayOfFloat, GradientDrawable.Orientation paramOrientation)
  {
    a();
    this.n.a(paramArrayOfInt, paramArrayOfFloat, paramOrientation);
  }
  
  public void setHasMore(boolean paramBoolean)
  {
    a();
    this.n.k(paramBoolean);
  }
  
  public void setLineBreakInContent(boolean paramBoolean)
  {
    a();
    this.n.e(paramBoolean);
  }
  
  public void setLineBreakNeeded(boolean paramBoolean)
  {
    a();
    this.n.d(paramBoolean);
  }
  
  public void setLineSpace(int paramInt)
  {
    a();
    this.n.g(paramInt);
    invalidate();
  }
  
  public void setLongClickTrig(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setLongclickable(boolean paramBoolean)
  {
    this.n.g(paramBoolean);
    if (paramBoolean) {
      setOnLongClickListener(new CellTextView.2(this));
    }
  }
  
  public void setMaxCommentLine(int paramInt)
  {
    TextCellLayout localTextCellLayout = this.n;
    if (localTextCellLayout != null) {
      localTextCellLayout.a(paramInt, true);
    }
  }
  
  public void setMaxLine(int paramInt)
  {
    a();
    this.n.c(paramInt);
  }
  
  public void setMaxWidth(int paramInt)
  {
    a();
    this.n.j(paramInt);
  }
  
  public void setMeasuredTextCacheEnabled(boolean paramBoolean)
  {
    a();
    this.n.i(paramBoolean);
  }
  
  public void setNinePatchBackground(int paramInt)
  {
    this.n.a(paramInt);
  }
  
  public void setOnCellClickListener(TextCellLayout.OnCellClickListener paramOnCellClickListener)
  {
    this.j = paramOnCellClickListener;
    a();
    this.n.a(paramOnCellClickListener);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
    this.k = paramOnClickListener;
  }
  
  public void setOnSideDrawableClickListener(TextCellLayout.OnSideDrawableClickListener paramOnSideDrawableClickListener)
  {
    a();
    this.n.a(paramOnSideDrawableClickListener);
  }
  
  public void setOnTextOperateListener(CellTextView.OnTextOperater paramOnTextOperater)
  {
    this.r = paramOnTextOperater;
  }
  
  public void setOuterListener(ImageLoader.ImageLoadListener paramImageLoadListener)
  {
    TextCellLayout localTextCellLayout = this.n;
    if (localTextCellLayout != null) {
      localTextCellLayout.a(paramImageLoadListener);
    }
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    a();
    this.n.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setParseUrl(boolean paramBoolean) {}
  
  public void setRichText(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramCharSequence);
  }
  
  public void setShadowLayer(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a();
    this.n.b(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setShowMore(boolean paramBoolean)
  {
    a();
    this.n.b(paramBoolean);
  }
  
  public void setText(int paramInt)
  {
    setText(getResources().getString(paramInt));
  }
  
  public void setText(TextCell paramTextCell)
  {
    this.b = new ArrayList();
    this.b.add(paramTextCell);
    a();
    this.n.a(paramTextCell);
    requestLayout();
    invalidate();
  }
  
  public void setText(String paramString)
  {
    this.b = new ArrayList();
    this.b.add(new TextCell(0, paramString));
    a();
    this.n.a(this.b);
    requestLayout();
    invalidate();
  }
  
  public void setText(ArrayList<TextCell> paramArrayList)
  {
    this.b = paramArrayList;
    a();
    this.n.a(paramArrayList);
    requestLayout();
    invalidate();
  }
  
  public void setTextBold(boolean paramBoolean)
  {
    a();
    this.n.h(paramBoolean);
  }
  
  public void setTextColor(int paramInt)
  {
    a();
    this.n.f(paramInt);
    invalidate();
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    a();
    this.n.a(paramColorStateList);
    drawableStateChanged();
    invalidate();
  }
  
  public void setTextColorAnimation(ArrayList<Integer> paramArrayList, int paramInt)
  {
    a();
    this.n.a(paramArrayList, paramInt);
  }
  
  public void setTextColorLink(int paramInt)
  {
    a();
    this.e = paramInt;
    this.n.h(paramInt);
    invalidate();
  }
  
  public void setTextColorLink(ColorStateList paramColorStateList)
  {
    a();
    this.n.b(paramColorStateList);
    drawableStateChanged();
    invalidate();
  }
  
  public void setTextColorLinkBackground(int paramInt)
  {
    a();
    this.n.i(paramInt);
  }
  
  public void setTextGravity(int paramInt)
  {
    a();
    this.n.e(paramInt);
  }
  
  public void setTextSize(float paramFloat)
  {
    a();
    this.n.a(paramFloat);
    requestLayout();
    invalidate();
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    Object localObject = getContext();
    if (localObject == null) {
      localObject = Resources.getSystem();
    } else {
      localObject = ((Context)localObject).getResources();
    }
    paramFloat = TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics());
    if (paramFloat != getTextSize()) {
      setTextSize(paramFloat);
    }
  }
  
  public void setTextStyle(String paramString, int paramInt1, int paramInt2)
  {
    this.n.a(paramString, paramInt1, paramInt2);
  }
  
  public void setUrlColorRes(int paramInt) {}
  
  public void setUseSoftLineBreak(boolean paramBoolean)
  {
    TextCellLayout localTextCellLayout = this.n;
    if (localTextCellLayout != null) {
      localTextCellLayout.l(paramBoolean);
    }
  }
  
  public void setUserNameRichText(TextCell paramTextCell, CharSequence paramCharSequence)
  {
    a(paramCharSequence);
    paramCharSequence = this.b;
    if (paramCharSequence != null)
    {
      paramCharSequence.add(0, paramTextCell);
      requestLayout();
      invalidate();
    }
  }
  
  public void setmutiRichText(ArrayList<TextCell> paramArrayList, CharSequence paramCharSequence)
  {
    a(paramCharSequence);
    paramCharSequence = this.b;
    if (paramCharSequence != null)
    {
      paramCharSequence.addAll(0, paramArrayList);
      requestLayout();
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.CellTextView
 * JD-Core Version:    0.7.0.1
 */