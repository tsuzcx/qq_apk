package com.tencent.comic.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.redtouch.RedDisplayInfo;
import com.tencent.mobileqq.redtouch.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class RedTouchUI
  extends RedTouch
{
  public RedAppInfo a;
  private List<RedTypeInfo> b;
  private int x = -1;
  private int y = -1;
  
  public RedTouchUI(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedTouchUI(Context paramContext, View paramView)
  {
    super(paramContext, paramView);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedAppInfo = null;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(RedTypeInfo paramRedTypeInfo)
  {
    if (paramRedTypeInfo == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    int m = 0;
    int k = 0;
    ((LinearLayout)localObject).setVisibility(0);
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramRedTypeInfo.getRedDesc())) {
          localObject = new JSONObject();
        } else {
          localObject = new JSONObject(paramRedTypeInfo.getRedDesc());
        }
        if (((JSONObject)localObject).has("bg"))
        {
          i = a(((JSONObject)localObject).getString("bg"));
          j = paramRedTypeInfo.getRedType();
          if (j != 0)
          {
            if (j != 9)
            {
              if (j != 3)
              {
                if ((j != 4) && (j != 5)) {
                  return;
                }
                j = -1;
                if (((JSONObject)localObject).has("cr")) {
                  j = a(((JSONObject)localObject).getString("cr"));
                }
                if (((JSONObject)localObject).has("cn")) {
                  k = a(((JSONObject)localObject).getString("cn"));
                }
                localObject = a(paramRedTypeInfo.getRedContent(), j, k, i);
                if (localObject != null)
                {
                  if (paramRedTypeInfo.getRedType() == 4)
                  {
                    i = this.c;
                    this.c = (i + 1);
                  }
                  else
                  {
                    i = this.d;
                    this.d = (i + 1);
                  }
                  ((View)localObject).setId(i);
                  this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
                }
              }
              else
              {
                if (!((JSONObject)localObject).has("av")) {
                  break label383;
                }
                j = ((JSONObject)localObject).getInt("av");
                k = m;
                if (((JSONObject)localObject).has("dot")) {
                  k = ((JSONObject)localObject).getInt("dot");
                }
                paramRedTypeInfo = a(paramRedTypeInfo.getRedContent(), j, k, i);
                if (paramRedTypeInfo != null)
                {
                  i = this.jdField_b_of_type_Int;
                  this.jdField_b_of_type_Int = (i + 1);
                  paramRedTypeInfo.setId(i);
                  this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramRedTypeInfo);
                }
              }
            }
            else
            {
              paramRedTypeInfo = a(paramRedTypeInfo.getRedContent());
              if (paramRedTypeInfo != null) {
                this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramRedTypeInfo);
              }
            }
          }
          else
          {
            paramRedTypeInfo = a(i);
            if (paramRedTypeInfo != null)
            {
              i = this.jdField_a_of_type_Int;
              this.jdField_a_of_type_Int = (i + 1);
              paramRedTypeInfo.setId(i);
              this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramRedTypeInfo);
            }
          }
          return;
        }
      }
      catch (Exception paramRedTypeInfo)
      {
        return;
      }
      int i = 0;
      continue;
      label383:
      int j = 0;
    }
  }
  
  private boolean a(RedTypeInfo paramRedTypeInfo1, RedTypeInfo paramRedTypeInfo2)
  {
    if (paramRedTypeInfo1.getRedType() != paramRedTypeInfo2.getRedType()) {
      return false;
    }
    if (!paramRedTypeInfo1.getRedContent().equals(paramRedTypeInfo2.getRedContent())) {
      return false;
    }
    if (!paramRedTypeInfo1.getRedDesc().equals(paramRedTypeInfo2.getRedDesc())) {
      return false;
    }
    return paramRedTypeInfo1.getRedPriority() == paramRedTypeInfo2.getRedPriority();
  }
  
  private boolean a(List<RedTypeInfo> paramList)
  {
    if (this.jdField_b_of_type_JavaUtilList.size() == 0) {
      return false;
    }
    if (this.jdField_b_of_type_JavaUtilList.size() != paramList.size()) {
      return false;
    }
    int i = 0;
    while (i < this.jdField_b_of_type_JavaUtilList.size())
    {
      if (!a((RedTypeInfo)this.jdField_b_of_type_JavaUtilList.get(i), (RedTypeInfo)paramList.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public View a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
    ((URLImageView)localObject).setBackgroundColor(paramInt3);
    a(paramString, (URLImageView)localObject, paramInt1);
    if (paramInt2 == 1)
    {
      if (this.x != -1)
      {
        paramString = new FrameLayout(getContext());
        ((URLImageView)localObject).setLayoutParams(new FrameLayout.LayoutParams(a(36), a(36)));
        ((URLImageView)localObject).setPadding(a(3), a(3), a(3), a(3));
        paramString.addView((View)localObject);
        localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        ((ImageView)localObject).setImageResource(this.x);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
        localLayoutParams.gravity = 53;
        ((ImageView)localObject).setLayoutParams(localLayoutParams);
        paramString.addView((View)localObject);
        paramString.setLayoutParams(a());
        return paramString;
      }
      throw new RuntimeException("must set the redpoint imageresource");
    }
    paramString = a();
    paramString.width = a(36);
    paramString.height = a(36);
    ((URLImageView)localObject).setLayoutParams(paramString);
    ((URLImageView)localObject).setPadding(a(3), a(3), a(3), a(3));
    return localObject;
  }
  
  protected ImageView a(int paramInt)
  {
    if (this.x != -1)
    {
      ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localImageView.setImageResource(this.x);
      localImageView.setBackgroundColor(paramInt);
      localImageView.setLayoutParams(a());
      return localImageView;
    }
    throw new RuntimeException("must set the redpoint imageresource");
  }
  
  protected TextView a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    TextView localTextView;
    if (this.y != -1) {
      localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    }
    try
    {
      if (Integer.parseInt(paramString) > this.p)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.p);
        localStringBuilder.append("+");
        localTextView.setText(localStringBuilder.toString());
      }
      else
      {
        localTextView.setText(paramString);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label81:
      break label81;
    }
    localTextView.setText(paramString);
    localTextView.setTextColor(paramInt1);
    localTextView.setGravity(17);
    localTextView.setSingleLine(true);
    if (paramInt2 != 0)
    {
      localTextView.setTextSize(11.0F);
      localTextView.setBackgroundResource(this.y);
    }
    else
    {
      localTextView.setTextSize(13.0F);
    }
    localTextView.setLayoutParams(a());
    if (this.jdField_b_of_type_Boolean)
    {
      localTextView.measure(0, 0);
      this.l = (localTextView.getMeasuredWidth() / 2);
      c();
    }
    return localTextView;
    throw new RuntimeException("must set the redpoint imageresource");
  }
  
  public void a(RedAppInfo paramRedAppInfo)
  {
    d();
    if (paramRedAppInfo == null) {
      return;
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    if (paramRedAppInfo.b() == 0) {
      return;
    }
    if (paramRedAppInfo.a() != null)
    {
      if (paramRedAppInfo.a().a() == null) {
        return;
      }
      if (a(paramRedAppInfo.a().a())) {
        return;
      }
      this.jdField_b_of_type_JavaUtilList.addAll(paramRedAppInfo.a().a());
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        a((RedTypeInfo)localIterator.next());
      }
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedAppInfo = paramRedAppInfo;
    }
  }
  
  public void setRedpointImgResID(int paramInt)
  {
    this.x = paramInt;
  }
  
  public void setTextOrNumImgRedID(int paramInt)
  {
    this.y = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.ui.RedTouchUI
 * JD-Core Version:    0.7.0.1
 */