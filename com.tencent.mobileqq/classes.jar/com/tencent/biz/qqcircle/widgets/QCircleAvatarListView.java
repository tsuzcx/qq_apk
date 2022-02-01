package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.qcircleshadow.lib.variation.HostFaceUtils;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.mobileqq.biz.qcircle.R.styleable;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.helpers.QCircleSkinHelper.OnThemeUpdateListener;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.ArrayList;
import java.util.List;

public class QCircleAvatarListView
  extends ViewGroup
  implements QCircleSkinHelper.OnThemeUpdateListener
{
  private int a;
  private float b;
  private boolean c;
  private int d;
  private int e;
  private int f;
  private boolean g;
  private int h;
  private List<String> i = new ArrayList();
  private List<String> j = new ArrayList();
  
  public QCircleAvatarListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleAvatarListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleAvatarListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    int k = 0;
    while (k < 3)
    {
      addView(b().a());
      k += 1;
    }
  }
  
  private void a(int paramInt)
  {
    int m = getChildCount();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addOrHideIconHolder  childCount = ");
    ((StringBuilder)localObject).append(m);
    ((StringBuilder)localObject).append(" , size = ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("QCircleAvatarListView", 1, ((StringBuilder)localObject).toString());
    int k = m;
    if (m >= paramInt) {
      while (paramInt < m)
      {
        localObject = getChildAt(paramInt);
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
        paramInt += 1;
      }
    }
    while (k < paramInt)
    {
      addView(b().a());
      k += 1;
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ce);
    if (paramContext != null)
    {
      this.a = paramContext.getInteger(R.styleable.cg, 90);
      this.b = paramContext.getFloat(R.styleable.cl, 0.8F);
      this.d = ((int)paramContext.getDimension(R.styleable.ch, 30.0F));
      this.e = ((int)paramContext.getDimension(R.styleable.cf, 30.0F));
      this.c = paramContext.getBoolean(R.styleable.ck, false);
      this.f = ((int)paramContext.getDimension(R.styleable.cj, 0.0F));
      this.g = paramContext.getBoolean(R.styleable.cm, false);
      this.h = paramContext.getResourceId(R.styleable.ci, 0);
      paramContext.recycle();
    }
    a();
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    if ((getChildAt(paramInt) instanceof FrameLayout)) {
      localObject = (FrameLayout)getChildAt(paramInt);
    } else {
      localObject = null;
    }
    if (localObject == null) {
      return;
    }
    ((FrameLayout)localObject).setVisibility(0);
    if ((((FrameLayout)localObject).getChildCount() > 0) && ((((FrameLayout)localObject).getChildAt(0) instanceof RoundCornerImageView)))
    {
      RoundCornerImageView localRoundCornerImageView = (RoundCornerImageView)((FrameLayout)localObject).getChildAt(0);
      if (this.g)
      {
        localRoundCornerImageView.setBackgroundColor(QCircleSkinHelper.getInstance().getColor(this.h));
      }
      else
      {
        Option localOption = new Option().setTargetView(localRoundCornerImageView).setRequestWidth(this.d + this.f * 2).setRequestHeight(this.e + this.f * 2).setUrl(paramString2);
        QCircleFeedPicLoader.g().loadImage(localOption, null);
        localRoundCornerImageView.setColorFilter(QCircleSkinHelper.getInstance().getColor(2131167059));
      }
    }
    if ((((FrameLayout)localObject).getChildCount() > 1) && ((((FrameLayout)localObject).getChildAt(1) instanceof RoundCornerImageView)))
    {
      localObject = (RoundCornerImageView)((FrameLayout)localObject).getChildAt(1);
      if (paramString1.contains("http")) {
        QCircleFeedPicLoader.g().loadImage(new Option().setTargetView((ImageView)localObject).setUrl(paramString1), null);
      } else {
        ((RoundCornerImageView)localObject).setImageDrawable(HostFaceUtils.getFaceDrawable(1, 4, paramString1));
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setIconHolderData  i = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" , picUrl = ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" , bgPicUrl = ");
    ((StringBuilder)localObject).append(paramString2);
    QLog.i("QCircleAvatarListView", 1, ((StringBuilder)localObject).toString());
  }
  
  private void a(List<String> paramList1, List<String> paramList2)
  {
    if ((paramList1 != null) && (paramList1.size() != 0))
    {
      int k = 0;
      setVisibility(0);
      int m = paramList1.size();
      a(m);
      while (k < m)
      {
        int n = paramList1.size();
        String str3 = "";
        String str1;
        if (n < k) {
          str1 = "";
        } else {
          str1 = (String)paramList1.get(k);
        }
        String str2 = str3;
        if (paramList2 != null) {
          if (paramList2.size() < k) {
            str2 = str3;
          } else {
            str2 = (String)paramList2.get(k);
          }
        }
        if (this.c) {
          a(str1, str2, m - 1 - k);
        } else {
          a(str1, str2, k);
        }
        k += 1;
      }
      return;
    }
    setVisibility(8);
  }
  
  private QCircleAvatarListView.SingleIconHolder b()
  {
    return new QCircleAvatarListView.SingleIconHolder(getContext(), this.d, this.e, this.f, this.a, this.g, this.h);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    QCircleSkinHelper.getInstance().registerOnThemeUpdateListener(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    QCircleSkinHelper.getInstance().unregisterOnThemeUpdateListener(this);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt4 = getChildCount();
    View localView;
    int k;
    int m;
    if (this.c)
    {
      paramInt1 = paramInt3 - paramInt1;
      paramInt4 -= 1;
      paramInt2 = paramInt4;
      paramInt3 = paramInt1;
      while (paramInt2 >= 0)
      {
        localView = getChildAt(paramInt4 - paramInt2);
        if (localView.getVisibility() != 8)
        {
          k = localView.getMeasuredWidth();
          m = localView.getMeasuredHeight();
          if (paramInt2 == paramInt4) {
            paramInt1 -= k;
          } else {
            paramInt1 = (int)(paramInt1 - k * this.b);
          }
          localView.layout(paramInt1, 0, paramInt3, m);
          paramInt3 = (int)(paramInt3 - k * this.b);
        }
        paramInt2 -= 1;
      }
    }
    paramInt2 = 0;
    paramInt1 = 0;
    paramInt3 = 0;
    while (paramInt2 < paramInt4)
    {
      localView = getChildAt(paramInt2);
      if (localView.getVisibility() != 8)
      {
        k = localView.getMeasuredWidth();
        m = localView.getMeasuredHeight();
        if (paramInt2 == 0) {
          paramInt1 += k;
        } else {
          paramInt1 = (int)(paramInt1 + k * this.b);
        }
        localView.layout(paramInt3, 0, paramInt1, m);
        paramInt3 = (int)(paramInt3 + k * this.b);
      }
      paramInt2 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i1 = View.MeasureSpec.getSize(paramInt2);
    int i3 = View.MeasureSpec.getMode(paramInt2);
    int i4 = View.MeasureSpec.getMode(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt1);
    int i5 = getChildCount();
    int n = 0;
    int m = 0;
    int k = 0;
    while (n < i5)
    {
      View localView = getChildAt(n);
      if (localView.getVisibility() != 8)
      {
        measureChild(localView, paramInt1, paramInt2);
        int i7 = localView.getMeasuredWidth();
        int i6 = localView.getMeasuredHeight();
        if (n == 0) {
          m += i7;
        } else {
          m = (int)(m + i7 * this.b);
        }
        k = Math.max(k, i6);
      }
      n += 1;
    }
    if (i4 == 1073741824) {
      paramInt1 = i2;
    } else {
      paramInt1 = m;
    }
    if (i3 == 1073741824) {
      k = i1;
    }
    setMeasuredDimension(paramInt1, k);
  }
  
  public void onThemeUpdate()
  {
    a(this.i, this.j);
  }
  
  public void setData(List<String> paramList)
  {
    setData(paramList, null);
  }
  
  public void setData(List<String> paramList1, List<String> paramList2)
  {
    if ((paramList1 != null) && (paramList1.size() != 0))
    {
      this.i.clear();
      this.i.addAll(paramList1);
    }
    if ((paramList2 != null) && (paramList2.size() != 0))
    {
      this.j.clear();
      this.j.addAll(paramList2);
    }
    a(paramList1, paramList2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleAvatarListView
 * JD-Core Version:    0.7.0.1
 */