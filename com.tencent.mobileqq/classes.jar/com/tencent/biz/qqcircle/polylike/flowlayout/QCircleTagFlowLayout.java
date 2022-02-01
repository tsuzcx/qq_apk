package com.tencent.biz.qqcircle.polylike.flowlayout;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mobileqq.R.styleable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import vsn;
import vso;
import vsp;
import vsq;
import vsr;

public class QCircleTagFlowLayout
  extends QCircleFlowLayout
  implements vso
{
  private int jdField_a_of_type_Int = -1;
  private Set<Integer> jdField_a_of_type_JavaUtilSet = new HashSet();
  private vsn jdField_a_of_type_Vsn;
  private vsq jdField_a_of_type_Vsq;
  private vsr jdField_a_of_type_Vsr;
  
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
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QCircleTagFlowLayout);
    this.jdField_a_of_type_Int = paramContext.getInt(0, -1);
    paramContext.recycle();
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void a()
  {
    removeAllViews();
    vsn localvsn = this.jdField_a_of_type_Vsn;
    HashSet localHashSet = this.jdField_a_of_type_Vsn.a();
    int i = 0;
    if (i < localvsn.a())
    {
      View localView = localvsn.a(this, i, localvsn.a(i));
      QCircleFlowLayoutItemView localQCircleFlowLayoutItemView = new QCircleFlowLayoutItemView(getContext());
      localView.setDuplicateParentStateEnabled(true);
      if (localView.getLayoutParams() != null) {
        localQCircleFlowLayoutItemView.setLayoutParams(localView.getLayoutParams());
      }
      for (;;)
      {
        localView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        localQCircleFlowLayoutItemView.addView(localView);
        addView(localQCircleFlowLayoutItemView);
        if (localHashSet.contains(Integer.valueOf(i))) {
          a(i, localQCircleFlowLayoutItemView);
        }
        if (this.jdField_a_of_type_Vsn.a(i, localvsn.a(i))) {
          a(i, localQCircleFlowLayoutItemView);
        }
        localView.setClickable(false);
        localQCircleFlowLayoutItemView.setOnClickListener(new vsp(this, localQCircleFlowLayoutItemView, i));
        i += 1;
        break;
        ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        localMarginLayoutParams.setMargins(a(getContext(), 5.0F), a(getContext(), 5.0F), a(getContext(), 5.0F), a(getContext(), 5.0F));
        localQCircleFlowLayoutItemView.setLayoutParams(localMarginLayoutParams);
      }
    }
    this.jdField_a_of_type_JavaUtilSet.addAll(localHashSet);
  }
  
  private void a(int paramInt, QCircleFlowLayoutItemView paramQCircleFlowLayoutItemView)
  {
    paramQCircleFlowLayoutItemView.setChecked(true);
    this.jdField_a_of_type_Vsn.a(paramInt, paramQCircleFlowLayoutItemView.a());
  }
  
  private void a(QCircleFlowLayoutItemView paramQCircleFlowLayoutItemView, int paramInt)
  {
    if (!paramQCircleFlowLayoutItemView.isChecked()) {
      if ((this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_JavaUtilSet.size() == 1))
      {
        Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilSet.iterator().next();
        QCircleFlowLayoutItemView localQCircleFlowLayoutItemView = (QCircleFlowLayoutItemView)getChildAt(localInteger.intValue());
        b(localInteger.intValue(), localQCircleFlowLayoutItemView);
        a(paramInt, paramQCircleFlowLayoutItemView);
        this.jdField_a_of_type_JavaUtilSet.remove(localInteger);
        this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(paramInt));
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Vsq != null) {
        this.jdField_a_of_type_Vsq.a(new HashSet(this.jdField_a_of_type_JavaUtilSet));
      }
      do
      {
        return;
      } while ((this.jdField_a_of_type_Int > 0) && (this.jdField_a_of_type_JavaUtilSet.size() >= this.jdField_a_of_type_Int));
      a(paramInt, paramQCircleFlowLayoutItemView);
      this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(paramInt));
      continue;
      b(paramInt, paramQCircleFlowLayoutItemView);
      this.jdField_a_of_type_JavaUtilSet.remove(Integer.valueOf(paramInt));
    }
  }
  
  private void b(int paramInt, QCircleFlowLayoutItemView paramQCircleFlowLayoutItemView)
  {
    paramQCircleFlowLayoutItemView.setChecked(false);
    this.jdField_a_of_type_Vsn.b(paramInt, paramQCircleFlowLayoutItemView.a());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      QCircleFlowLayoutItemView localQCircleFlowLayoutItemView = (QCircleFlowLayoutItemView)getChildAt(i);
      if (localQCircleFlowLayoutItemView.getVisibility() == 8) {}
      for (;;)
      {
        i += 1;
        break;
        if (localQCircleFlowLayoutItemView.a().getVisibility() == 8) {
          localQCircleFlowLayoutItemView.setVisibility(8);
        }
      }
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
          this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(k));
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
    String str = "";
    if (this.jdField_a_of_type_JavaUtilSet.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
      int i;
      for (str = ""; localIterator.hasNext(); str = str + i + "|") {
        i = ((Integer)localIterator.next()).intValue();
      }
      str = str.substring(0, str.length() - 1);
    }
    localBundle.putString("key_choose_pos", str);
    return localBundle;
  }
  
  public void setAdapter(vsn paramvsn)
  {
    this.jdField_a_of_type_Vsn = paramvsn;
    this.jdField_a_of_type_Vsn.a(this);
    this.jdField_a_of_type_JavaUtilSet.clear();
    a();
  }
  
  public void setMaxSelectCount(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilSet.size() > paramInt)
    {
      Log.w("TagFlowLayout", "you has already select more than " + paramInt + " views , so it will be clear .");
      this.jdField_a_of_type_JavaUtilSet.clear();
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setOnSelectListener(vsq paramvsq)
  {
    this.jdField_a_of_type_Vsq = paramvsq;
  }
  
  public void setOnTagClickListener(vsr paramvsr)
  {
    this.jdField_a_of_type_Vsr = paramvsr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.flowlayout.QCircleTagFlowLayout
 * JD-Core Version:    0.7.0.1
 */