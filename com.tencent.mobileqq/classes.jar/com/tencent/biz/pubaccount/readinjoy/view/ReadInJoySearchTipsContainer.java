package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import bbdv;
import bbll;
import com.tencent.biz.lebasearch.SearchProtocol.WordItem;
import java.util.Iterator;
import java.util.List;
import rfb;
import rfc;

public class ReadInJoySearchTipsContainer
  extends ViewGroup
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = bbll.a(260.0F);
  private List<ReadInJoySearchTipsContainer.TipsInfo> jdField_a_of_type_JavaUtilList;
  public rfc a;
  private int jdField_b_of_type_Int = 5;
  private List<SearchProtocol.WordItem> jdField_b_of_type_JavaUtilList;
  
  public ReadInJoySearchTipsContainer(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ReadInJoySearchTipsContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Int = (getResources().getDisplayMetrics().widthPixels / 2);
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if ((paramString1 != null) && (TextUtils.isEmpty(paramString1.trim()))) {
      return;
    }
    Button localButton = new Button(getContext());
    localButton.setBackgroundResource(2130848476);
    GradientDrawable localGradientDrawable = (GradientDrawable)((android.graphics.drawable.DrawableContainer.DrawableContainerState)((android.graphics.drawable.StateListDrawable)localButton.getBackground()).getConstantState()).getChildren()[1];
    if (paramInt2 != 0)
    {
      localGradientDrawable.setStroke(1, paramInt2);
      localButton.setPadding(bbll.a(15.0F), bbll.a(5.0F), bbll.a(15.0F), bbll.a(6.0F));
      localButton.setText(paramString1);
      localButton.setTextSize(14.0F);
      localButton.setSingleLine();
      localButton.setEllipsize(TextUtils.TruncateAt.valueOf("MIDDLE"));
      localButton.setMaxWidth(this.jdField_a_of_type_Int);
      if (paramInt1 == 0) {
        break label182;
      }
    }
    for (;;)
    {
      localButton.setTextColor(paramInt1);
      localButton.setOnClickListener(this);
      localButton.setTag(paramString1);
      if (!TextUtils.isEmpty(paramString2)) {
        localButton.setContentDescription(paramString2);
      }
      super.addView(localButton);
      return;
      paramInt2 = -3355444;
      break;
      label182:
      paramInt1 = -16777216;
    }
  }
  
  protected int a(int paramInt)
  {
    int i6 = (int)bbdv.a(getContext(), 7.0F);
    int i1 = (int)bbdv.a(getContext(), 10.0F);
    int i7 = (int)bbdv.a(getContext(), 10.0F);
    int i8 = (int)bbdv.a(getContext(), 4.0F);
    int m = (int)bbdv.a(getContext(), 12.0F);
    int i9 = (int)bbdv.a(getContext(), 12.0F);
    int i10 = getChildCount();
    int n = 0;
    int k = m;
    int i = i1;
    int i2 = 1;
    for (;;)
    {
      int j = i;
      int i11;
      int i12;
      int i4;
      if (n < i10)
      {
        View localView = getChildAt(n);
        i11 = localView.getMeasuredWidth();
        i12 = localView.getMeasuredHeight();
        j = i;
        if (n == 0) {
          j = i + i12;
        }
        i = j;
        i4 = i2;
        i3 = i1;
        i5 = k;
        if (k + i11 <= paramInt - i9) {
          break label207;
        }
        i4 = i2 + 1;
        if ((this.jdField_b_of_type_Int <= 0) || (i4 <= this.jdField_b_of_type_Int)) {}
      }
      else
      {
        return j + i7;
      }
      int i3 = i1 + (i12 + i6);
      i = i3 + i12;
      int i5 = m;
      label207:
      n += 1;
      k = i8 + i11 + i5;
      i2 = i4;
      i1 = i3;
    }
  }
  
  public void a(List<ReadInJoySearchTipsContainer.TipsInfo> paramList)
  {
    removeAllViews();
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ReadInJoySearchTipsContainer.TipsInfo localTipsInfo = (ReadInJoySearchTipsContainer.TipsInfo)paramList.next();
      a(localTipsInfo.word, localTipsInfo.textColor, localTipsInfo.frameColor, localTipsInfo.contentDescription);
    }
  }
  
  public void b(List<SearchProtocol.WordItem> paramList)
  {
    removeAllViews();
    this.jdField_b_of_type_JavaUtilList = paramList;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SearchProtocol.WordItem localWordItem = (SearchProtocol.WordItem)paramList.next();
      a(localWordItem.word, localWordItem.textColor, localWordItem.frameColor, localWordItem.contentDescription);
    }
  }
  
  public void onClick(View paramView)
  {
    rfb localrfb = new rfb(this, Looper.getMainLooper());
    Message localMessage = localrfb.obtainMessage();
    localMessage.obj = paramView.getTag();
    localrfb.sendMessage(localMessage);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i2 = (int)bbdv.a(getContext(), 7.0F);
    int k = (int)bbdv.a(getContext(), 10.0F);
    int i3 = (int)bbdv.a(getContext(), 4.0F);
    paramInt4 = (int)bbdv.a(getContext(), 12.0F);
    int i4 = (int)bbdv.a(getContext(), 12.0F);
    int i5 = getChildCount();
    int i = 0;
    int j = 1;
    paramInt2 = paramInt4;
    for (;;)
    {
      View localView;
      int i6;
      int i7;
      int i1;
      int m;
      if (i < i5)
      {
        localView = getChildAt(i);
        i6 = localView.getMeasuredWidth();
        i7 = localView.getMeasuredHeight();
        i1 = j;
        m = k;
        n = paramInt2;
        if (paramInt2 + i6 <= paramInt3 - paramInt1 - i4) {
          break label166;
        }
        m = k + (i7 + i2);
        i1 = j + 1;
        if ((this.jdField_b_of_type_Int <= 0) || (i1 <= this.jdField_b_of_type_Int)) {}
      }
      else
      {
        return;
      }
      int n = paramInt4;
      label166:
      localView.layout(n, m, i6 + n, i7 + m);
      i += 1;
      paramInt2 = i3 + i6 + n;
      j = i1;
      k = m;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = 0;
    int n = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt2);
    super.measureChildren(paramInt1, paramInt2);
    switch (n)
    {
    default: 
      paramInt2 = k;
      paramInt1 = j;
      switch (m)
      {
      }
      break;
    }
    for (paramInt1 = a(i);; paramInt1 = a(i))
    {
      super.setMeasuredDimension(paramInt2, paramInt1);
      return;
      paramInt2 = i;
      break;
    }
  }
  
  public void setOnTipsClickListener(rfc paramrfc)
  {
    this.jdField_a_of_type_Rfc = paramrfc;
  }
  
  public void setmMaxLines(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySearchTipsContainer
 * JD-Core Version:    0.7.0.1
 */