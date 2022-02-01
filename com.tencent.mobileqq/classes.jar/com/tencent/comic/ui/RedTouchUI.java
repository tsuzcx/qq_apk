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
  private int Z = -1;
  public RedAppInfo a = null;
  private int aa = -1;
  private List<RedTypeInfo> ab = new ArrayList();
  
  public RedTouchUI(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedTouchUI(Context paramContext, View paramView)
  {
    super(paramContext, paramView);
  }
  
  private void a(RedTypeInfo paramRedTypeInfo)
  {
    if (paramRedTypeInfo == null) {
      return;
    }
    Object localObject = this.h;
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
                    i = this.d;
                    this.d = (i + 1);
                  }
                  else
                  {
                    i = this.e;
                    this.e = (i + 1);
                  }
                  ((View)localObject).setId(i);
                  this.h.addView((View)localObject);
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
                paramRedTypeInfo = b(paramRedTypeInfo.getRedContent(), j, k, i);
                if (paramRedTypeInfo != null)
                {
                  i = this.c;
                  this.c = (i + 1);
                  paramRedTypeInfo.setId(i);
                  this.h.addView(paramRedTypeInfo);
                }
              }
            }
            else
            {
              paramRedTypeInfo = b(paramRedTypeInfo.getRedContent());
              if (paramRedTypeInfo != null) {
                this.h.addView(paramRedTypeInfo);
              }
            }
          }
          else
          {
            paramRedTypeInfo = a(i);
            if (paramRedTypeInfo != null)
            {
              i = this.b;
              this.b = (i + 1);
              paramRedTypeInfo.setId(i);
              this.h.addView(paramRedTypeInfo);
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
    if (this.ab.size() == 0) {
      return false;
    }
    if (this.ab.size() != paramList.size()) {
      return false;
    }
    int i = 0;
    while (i < this.ab.size())
    {
      if (!a((RedTypeInfo)this.ab.get(i), (RedTypeInfo)paramList.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  protected ImageView a(int paramInt)
  {
    if (this.Z != -1)
    {
      ImageView localImageView = new ImageView(this.f);
      localImageView.setImageResource(this.Z);
      localImageView.setBackgroundColor(paramInt);
      localImageView.setLayoutParams(getRedTouchLayoutParams());
      return localImageView;
    }
    throw new RuntimeException("must set the redpoint imageresource");
  }
  
  protected TextView a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    TextView localTextView;
    if (this.aa != -1) {
      localTextView = new TextView(this.f);
    }
    try
    {
      if (Integer.parseInt(paramString) > this.w)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.w);
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
      localTextView.setBackgroundResource(this.aa);
    }
    else
    {
      localTextView.setTextSize(13.0F);
    }
    localTextView.setLayoutParams(getRedTouchLayoutParams());
    if (this.v)
    {
      localTextView.measure(0, 0);
      this.r = (localTextView.getMeasuredWidth() / 2);
      f();
    }
    return localTextView;
    throw new RuntimeException("must set the redpoint imageresource");
  }
  
  public void a(RedAppInfo paramRedAppInfo)
  {
    g();
    if (paramRedAppInfo == null) {
      return;
    }
    this.ab.clear();
    if (paramRedAppInfo.b() == 0) {
      return;
    }
    if (paramRedAppInfo.o() != null)
    {
      if (paramRedAppInfo.o().a() == null) {
        return;
      }
      if (a(paramRedAppInfo.o().a())) {
        return;
      }
      this.ab.addAll(paramRedAppInfo.o().a());
      Iterator localIterator = this.ab.iterator();
      while (localIterator.hasNext()) {
        a((RedTypeInfo)localIterator.next());
      }
      this.a = paramRedAppInfo;
    }
  }
  
  public View b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = new URLImageView(this.f);
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
    ((URLImageView)localObject).setBackgroundColor(paramInt3);
    a(paramString, (URLImageView)localObject, paramInt1);
    if (paramInt2 == 1)
    {
      if (this.Z != -1)
      {
        paramString = new FrameLayout(getContext());
        ((URLImageView)localObject).setLayoutParams(new FrameLayout.LayoutParams(a(36.0F), a(36.0F)));
        ((URLImageView)localObject).setPadding(a(3.0F), a(3.0F), a(3.0F), a(3.0F));
        paramString.addView((View)localObject);
        localObject = new ImageView(this.f);
        ((ImageView)localObject).setImageResource(this.Z);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
        localLayoutParams.gravity = 53;
        ((ImageView)localObject).setLayoutParams(localLayoutParams);
        paramString.addView((View)localObject);
        paramString.setLayoutParams(getRedTouchLayoutParams());
        return paramString;
      }
      throw new RuntimeException("must set the redpoint imageresource");
    }
    paramString = getRedTouchLayoutParams();
    paramString.width = a(36.0F);
    paramString.height = a(36.0F);
    ((URLImageView)localObject).setLayoutParams(paramString);
    ((URLImageView)localObject).setPadding(a(3.0F), a(3.0F), a(3.0F), a(3.0F));
    return localObject;
  }
  
  public void setRedpointImgResID(int paramInt)
  {
    this.Z = paramInt;
  }
  
  public void setTextOrNumImgRedID(int paramInt)
  {
    this.aa = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.ui.RedTouchUI
 * JD-Core Version:    0.7.0.1
 */