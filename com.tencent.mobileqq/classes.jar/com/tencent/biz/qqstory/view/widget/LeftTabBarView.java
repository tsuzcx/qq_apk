package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeftTabBarView
  extends TabBarView
{
  public LeftTabBarView(Context paramContext)
  {
    super(paramContext);
  }
  
  public LeftTabBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RedDotTextView a(int paramInt, String paramString)
  {
    if ((paramInt >= 0) && (paramInt <= getChildCount()))
    {
      LinearLayout localLinearLayout1 = new LinearLayout(getContext());
      RedDotTextView localRedDotTextView = new RedDotTextView(getContext());
      localRedDotTextView.setText(paramString);
      localRedDotTextView.setTextSize(2, this.n);
      localRedDotTextView.setTextColor(this.g);
      localRedDotTextView.setPadding(this.j, this.l, this.k, this.m);
      localRedDotTextView.setSingleLine();
      localRedDotTextView.setFocusable(true);
      localRedDotTextView.setContentDescription(paramString);
      localRedDotTextView.setGravity(17);
      if (!TextUtils.isEmpty(paramString)) {
        localLinearLayout1.setOnClickListener(new LeftTabBarView.1(this, paramInt));
      }
      ViewCompat.setAccessibilityDelegate(localRedDotTextView, new LeftTabBarView.2(this));
      this.v.add(localRedDotTextView);
      this.w.add(localLinearLayout1);
      this.x.add(paramString);
      int i1 = this.v.size();
      HashMap localHashMap = new HashMap();
      if ((i1 == 2) || (i1 == 1)) {
        localHashMap.put("width", Integer.valueOf((int)(a / getResources().getDisplayMetrics().density / 3.0F + 0.5F)));
      }
      int m = 0;
      int j;
      int k;
      if (i1 == 6)
      {
        paramString = Boolean.valueOf(true);
        i = 0;
        for (j = 0; i < i1; j = k)
        {
          int n = ((String)this.x.get(i)).toString().length();
          if (i == 0)
          {
            k = n;
          }
          else
          {
            k = j;
            if (j != n)
            {
              paramString = Boolean.valueOf(false);
              k = j;
            }
          }
          i += 1;
        }
        if (paramString.booleanValue())
        {
          localHashMap.put("width", Integer.valueOf(69));
        }
        else
        {
          localHashMap.put("paddingLeft", Integer.valueOf(8));
          localHashMap.put("paddingRight", Integer.valueOf(8));
        }
      }
      if (i1 > 6)
      {
        localHashMap.put("paddingLeft", Integer.valueOf(8));
        localHashMap.put("paddingRight", Integer.valueOf(8));
      }
      paramString = new LinearLayout.LayoutParams(-2, -1);
      int i = m;
      while (i < i1)
      {
        LinearLayout localLinearLayout2 = (LinearLayout)this.w.get(i);
        if (localHashMap.get("width") != null)
        {
          paramString.width = ((int)(Integer.parseInt(localHashMap.get("width").toString()) * getResources().getDisplayMetrics().density + 0.5F));
        }
        else if ((localHashMap.get("paddingLeft") != null) && (localHashMap.get("paddingRight") != null))
        {
          j = (int)(Integer.parseInt(localHashMap.get("paddingLeft").toString()) * getResources().getDisplayMetrics().density + 0.5F);
          k = (int)(Integer.parseInt(localHashMap.get("paddingRight").toString()) * getResources().getDisplayMetrics().density + 0.5F);
          paramString.leftMargin = j;
          paramString.rightMargin = k;
          paramString.width = -2;
        }
        else
        {
          paramString.weight = 1.0F;
        }
        paramString.gravity = 8388627;
        localLinearLayout2.setLayoutParams(paramString);
        localLinearLayout2.setGravity(17);
        i += 1;
      }
      localRedDotTextView.setId(2131447153);
      if (localHashMap.get("paddingLeft") != null) {
        localLinearLayout1.addView(localRedDotTextView, paramString);
      } else {
        localLinearLayout1.addView(localRedDotTextView);
      }
      setGravity(8388627);
      addView(localLinearLayout1, paramInt);
      return localRedDotTextView;
    }
    paramString = new IllegalArgumentException("position is not legal, please check!");
    for (;;)
    {
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.LeftTabBarView
 * JD-Core Version:    0.7.0.1
 */