package com.tencent.mobileqq.apollo.store.openbox;

import aldt;
import alfa;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.image.Utils;
import java.util.Iterator;
import java.util.List;

public class MultiURLImageView
  extends LinearLayout
{
  private List<alfa> a;
  
  public MultiURLImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.a != null)
    {
      Iterator localIterator = this.a.iterator();
      paramInt1 = 0;
      paramInt2 = 0;
      if (localIterator.hasNext())
      {
        alfa localalfa = (alfa)localIterator.next();
        int i;
        if (super.getOrientation() == 1)
        {
          i = localalfa.jdField_b_of_type_Int;
          paramInt2 = Math.max(paramInt2, localalfa.jdField_a_of_type_Int);
          paramInt1 += i;
        }
        for (;;)
        {
          break;
          i = localalfa.jdField_a_of_type_Int;
          int j = localalfa.c;
          paramInt1 = Math.max(paramInt1, localalfa.jdField_b_of_type_Int);
          paramInt2 += i + j;
        }
      }
      super.setMeasuredDimension(paramInt2, paramInt1);
    }
  }
  
  public void setOrientation(int paramInt)
  {
    super.setOrientation(paramInt);
    if (paramInt == 1)
    {
      super.setGravity(1);
      return;
    }
    super.setGravity(16);
  }
  
  public void setViewLayoutDatas(List<alfa> paramList)
  {
    this.a = paramList;
    int i;
    alfa localalfa;
    Object localObject;
    if (this.a != null)
    {
      i = 0;
      if (i < this.a.size())
      {
        localalfa = (alfa)this.a.get(i);
        if (!TextUtils.isEmpty(localalfa.jdField_a_of_type_JavaLangString)) {}
      }
      else
      {
        if (super.getChildCount() <= this.a.size()) {
          break label253;
        }
        i = this.a.size();
        while (i < super.getChildCount())
        {
          super.getChildAt(i).setVisibility(8);
          i += 1;
        }
      }
      localObject = localalfa.jdField_b_of_type_JavaLangString;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label266;
      }
      localObject = Utils.Crc64String(localalfa.jdField_a_of_type_JavaLangString);
    }
    label266:
    for (;;)
    {
      if (super.getChildCount() > i)
      {
        paramList = super.getChildAt(i);
        if (!(paramList instanceof URLImageView)) {}
      }
      for (paramList = (URLImageView)paramList;; paramList = null)
      {
        if (paramList == null)
        {
          paramList = new URLImageView(super.getContext());
          super.addView(paramList);
        }
        for (;;)
        {
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramList.getLayoutParams();
          localLayoutParams.width = localalfa.jdField_a_of_type_Int;
          localLayoutParams.height = localalfa.jdField_b_of_type_Int;
          localLayoutParams.leftMargin = localalfa.c;
          localObject = aldt.a((String)localObject, null, localalfa.jdField_a_of_type_JavaLangString);
          ((URLDrawable)localObject).startDownload();
          paramList.setImageDrawable((Drawable)localObject);
          paramList.setScaleType(localalfa.jdField_a_of_type_AndroidWidgetImageView$ScaleType);
          paramList.setVisibility(0);
          i += 1;
          break;
          label253:
          super.requestLayout();
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.MultiURLImageView
 * JD-Core Version:    0.7.0.1
 */