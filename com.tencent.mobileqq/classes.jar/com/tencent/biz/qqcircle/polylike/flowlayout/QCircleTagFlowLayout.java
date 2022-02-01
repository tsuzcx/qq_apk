package com.tencent.biz.qqcircle.polylike.flowlayout;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mobileqq.biz.qcircle.R.styleable;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class QCircleTagFlowLayout
  extends QCircleFlowLayout
  implements QCircleFlowLayoutAdapter.OnDataChangedListener
{
  private QCircleFlowLayoutAdapter d;
  private int e = -1;
  private Set<Integer> f = new HashSet();
  private QCircleTagFlowLayout.OnSelectListener g;
  private QCircleTagFlowLayout.OnTagClickListener h;
  
  public QCircleTagFlowLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleTagFlowLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleTagFlowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.da);
    this.e = paramContext.getInt(R.styleable.db, -1);
    paramContext.recycle();
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private void a()
  {
    removeAllViews();
    QCircleFlowLayoutAdapter localQCircleFlowLayoutAdapter = this.d;
    HashSet localHashSet = localQCircleFlowLayoutAdapter.a();
    int i = 0;
    while (i < localQCircleFlowLayoutAdapter.b())
    {
      View localView = localQCircleFlowLayoutAdapter.a(this, i, localQCircleFlowLayoutAdapter.a(i));
      QCircleFlowLayoutItemView localQCircleFlowLayoutItemView = new QCircleFlowLayoutItemView(getContext());
      localView.setDuplicateParentStateEnabled(true);
      if (localView.getLayoutParams() != null)
      {
        localQCircleFlowLayoutItemView.setLayoutParams(localView.getLayoutParams());
      }
      else
      {
        ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        localMarginLayoutParams.setMargins(a(getContext(), 5.0F), a(getContext(), 5.0F), a(getContext(), 5.0F), a(getContext(), 5.0F));
        localQCircleFlowLayoutItemView.setLayoutParams(localMarginLayoutParams);
      }
      localView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      localQCircleFlowLayoutItemView.addView(localView);
      addView(localQCircleFlowLayoutItemView);
      if (localHashSet.contains(Integer.valueOf(i))) {
        a(i, localQCircleFlowLayoutItemView);
      }
      if (this.d.a(i, localQCircleFlowLayoutAdapter.a(i))) {
        a(i, localQCircleFlowLayoutItemView);
      }
      localView.setClickable(false);
      localQCircleFlowLayoutItemView.setOnClickListener(new QCircleTagFlowLayout.1(this, localQCircleFlowLayoutItemView, i));
      i += 1;
    }
    this.f.addAll(localHashSet);
  }
  
  private void a(int paramInt, QCircleFlowLayoutItemView paramQCircleFlowLayoutItemView)
  {
    paramQCircleFlowLayoutItemView.setChecked(true);
    this.d.a(paramInt, paramQCircleFlowLayoutItemView.getTagView());
  }
  
  private void a(QCircleFlowLayoutItemView paramQCircleFlowLayoutItemView, int paramInt)
  {
    if (!paramQCircleFlowLayoutItemView.isChecked())
    {
      if ((this.e == 1) && (this.f.size() == 1))
      {
        Integer localInteger = (Integer)this.f.iterator().next();
        QCircleFlowLayoutItemView localQCircleFlowLayoutItemView = (QCircleFlowLayoutItemView)getChildAt(localInteger.intValue());
        b(localInteger.intValue(), localQCircleFlowLayoutItemView);
        a(paramInt, paramQCircleFlowLayoutItemView);
        this.f.remove(localInteger);
        this.f.add(Integer.valueOf(paramInt));
      }
      else
      {
        if ((this.e > 0) && (this.f.size() >= this.e)) {
          return;
        }
        a(paramInt, paramQCircleFlowLayoutItemView);
        this.f.add(Integer.valueOf(paramInt));
      }
    }
    else
    {
      b(paramInt, paramQCircleFlowLayoutItemView);
      this.f.remove(Integer.valueOf(paramInt));
    }
    paramQCircleFlowLayoutItemView = this.g;
    if (paramQCircleFlowLayoutItemView != null) {
      paramQCircleFlowLayoutItemView.a(new HashSet(this.f));
    }
  }
  
  private void b(int paramInt, QCircleFlowLayoutItemView paramQCircleFlowLayoutItemView)
  {
    paramQCircleFlowLayoutItemView.setChecked(false);
    this.d.b(paramInt, paramQCircleFlowLayoutItemView.getTagView());
  }
  
  public QCircleFlowLayoutAdapter getAdapter()
  {
    return this.d;
  }
  
  public Set<Integer> getSelectedList()
  {
    return new HashSet(this.f);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      QCircleFlowLayoutItemView localQCircleFlowLayoutItemView = (QCircleFlowLayoutItemView)getChildAt(i);
      if ((localQCircleFlowLayoutItemView.getVisibility() != 8) && (localQCircleFlowLayoutItemView.getTagView().getVisibility() == 8)) {
        localQCircleFlowLayoutItemView.setVisibility(8);
      }
      i += 1;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      Object localObject = paramParcelable.getString("key_choose_pos");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          int k = Integer.parseInt(localObject[i]);
          this.f.add(Integer.valueOf(k));
          QCircleFlowLayoutItemView localQCircleFlowLayoutItemView = (QCircleFlowLayoutItemView)getChildAt(k);
          if (localQCircleFlowLayoutItemView != null) {
            a(k, localQCircleFlowLayoutItemView);
          }
          i += 1;
        }
      }
      super.onRestoreInstanceState(paramParcelable.getParcelable("key_default"));
      return;
    }
    super.onRestoreInstanceState(paramParcelable);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_default", super.onSaveInstanceState());
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = localStringBuilder;
    if (this.f.size() > 0)
    {
      localObject = this.f.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localStringBuilder.append(((Integer)((Iterator)localObject).next()).intValue());
        localStringBuilder.append("|");
      }
      localObject = new StringBuilder(localStringBuilder.substring(0, localStringBuilder.length() - 1));
    }
    localBundle.putString("key_choose_pos", ((StringBuilder)localObject).toString());
    return localBundle;
  }
  
  public void setAdapter(QCircleFlowLayoutAdapter paramQCircleFlowLayoutAdapter)
  {
    this.d = paramQCircleFlowLayoutAdapter;
    this.d.a(this);
    this.f.clear();
    a();
  }
  
  public void setMaxSelectCount(int paramInt)
  {
    if (this.f.size() > paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("you has already select more than ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" views , so it will be clear .");
      QLog.w("TagFlowLayout", 1, localStringBuilder.toString());
      this.f.clear();
    }
    this.e = paramInt;
  }
  
  public void setOnSelectListener(QCircleTagFlowLayout.OnSelectListener paramOnSelectListener)
  {
    this.g = paramOnSelectListener;
  }
  
  public void setOnTagClickListener(QCircleTagFlowLayout.OnTagClickListener paramOnTagClickListener)
  {
    this.h = paramOnTagClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.flowlayout.QCircleTagFlowLayout
 * JD-Core Version:    0.7.0.1
 */