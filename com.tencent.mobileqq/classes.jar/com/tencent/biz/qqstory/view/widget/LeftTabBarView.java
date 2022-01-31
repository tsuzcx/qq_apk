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
import oqx;
import oqy;

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
    if ((paramInt < 0) || (paramInt > getChildCount())) {
      throw new IllegalArgumentException("position is not legal, please check!");
    }
    LinearLayout localLinearLayout1 = new LinearLayout(getContext());
    RedDotTextView localRedDotTextView = new RedDotTextView(getContext());
    localRedDotTextView.setText(paramString);
    localRedDotTextView.setTextSize(2, this.g);
    localRedDotTextView.setTextColor(this.jdField_b_of_type_Int);
    localRedDotTextView.setPadding(this.jdField_c_of_type_Int, this.e, this.d, this.f);
    localRedDotTextView.setSingleLine();
    localRedDotTextView.setFocusable(true);
    localRedDotTextView.setContentDescription(paramString);
    localRedDotTextView.setGravity(17);
    if (!TextUtils.isEmpty(paramString)) {
      localLinearLayout1.setOnClickListener(new oqx(this, paramInt));
    }
    ViewCompat.setAccessibilityDelegate(localRedDotTextView, new oqy(this));
    this.jdField_a_of_type_JavaUtilList.add(localRedDotTextView);
    this.jdField_b_of_type_JavaUtilList.add(localLinearLayout1);
    this.jdField_c_of_type_JavaUtilList.add(paramString);
    int m = this.jdField_a_of_type_JavaUtilList.size();
    HashMap localHashMap = new HashMap();
    if ((m == 2) || (m == 1)) {
      localHashMap.put("width", Integer.valueOf((int)(jdField_a_of_type_Int / getResources().getDisplayMetrics().density / 3.0F + 0.5F)));
    }
    int i;
    int j;
    int k;
    if (m == 6)
    {
      i = 0;
      paramString = Boolean.valueOf(true);
      j = 0;
      if (j < m)
      {
        k = ((String)this.jdField_c_of_type_JavaUtilList.get(j)).toString().length();
        if (j == 0) {
          i = k;
        }
      }
    }
    for (;;)
    {
      j += 1;
      break;
      if (i != k)
      {
        paramString = Boolean.valueOf(false);
        continue;
        label404:
        LinearLayout localLinearLayout2;
        if (paramString.booleanValue())
        {
          localHashMap.put("width", Integer.valueOf(69));
          if (m > 6)
          {
            localHashMap.put("paddingLeft", Integer.valueOf(8));
            localHashMap.put("paddingRight", Integer.valueOf(8));
          }
          paramString = new LinearLayout.LayoutParams(-2, -1);
          i = 0;
          if (i >= m) {
            break label660;
          }
          localLinearLayout2 = (LinearLayout)this.jdField_b_of_type_JavaUtilList.get(i);
          if ((localHashMap == null) || (localHashMap.get("width") == null)) {
            break label536;
          }
          paramString.width = ((int)(Integer.parseInt(localHashMap.get("width").toString()) * getResources().getDisplayMetrics().density + 0.5F));
        }
        for (;;)
        {
          paramString.gravity = 8388627;
          localLinearLayout2.setLayoutParams(paramString);
          localLinearLayout2.setGravity(17);
          i += 1;
          break label404;
          localHashMap.put("paddingLeft", Integer.valueOf(8));
          localHashMap.put("paddingRight", Integer.valueOf(8));
          break;
          label536:
          if ((localHashMap != null) && (localHashMap.get("paddingLeft") != null) && (localHashMap.get("paddingRight") != null))
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
        }
        label660:
        localRedDotTextView.setId(2131362344);
        if ((localHashMap != null) && (localHashMap.get("paddingLeft") != null)) {
          localLinearLayout1.addView(localRedDotTextView, paramString);
        }
        for (;;)
        {
          setGravity(8388627);
          addView(localLinearLayout1, paramInt);
          return localRedDotTextView;
          localLinearLayout1.addView(localRedDotTextView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.LeftTabBarView
 * JD-Core Version:    0.7.0.1
 */