package com.tencent.mobileqq.activity.qcircle.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class QCircleGiftRecordView
  extends LinearLayout
{
  private ViewGroup a;
  private FrameLayout b;
  private URLImageView c;
  private TextView d;
  private String e;
  private GradientDrawable f;
  
  public QCircleGiftRecordView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleGiftRecordView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleGiftRecordView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.a = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2131626845, this));
    this.b = ((FrameLayout)this.a.findViewById(2131433236));
    this.f = new GradientDrawable();
    this.f.setColor(-986894);
    this.f.setCornerRadius(ImmersiveUtils.dpToPx(9.0F));
    this.b.setBackgroundDrawable(this.f);
    this.c = ((URLImageView)this.a.findViewById(2131436394));
    this.d = ((TextView)this.a.findViewById(2131448491));
  }
  
  public void setGiftCount(int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("x");
    localStringBuilder.append(paramInt);
    this.e = localStringBuilder.toString();
    if (this.d != null)
    {
      ((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).setNumberTypeface(this.d, paramBoolean);
      this.d.setText(this.e);
    }
  }
  
  public void setIconUrl(String paramString)
  {
    URLImageView localURLImageView = this.c;
    if (localURLImageView != null) {
      localURLImageView.setImageURL(paramString);
    }
  }
  
  public void setUIStyle(String paramString1, String paramString2)
  {
    try
    {
      if (this.d != null) {
        this.d.setTextColor(Color.parseColor(paramString1));
      }
      if (this.f == null) {
        break label65;
      }
      this.f.setColor(Color.parseColor(paramString2));
      return;
    }
    catch (Exception localException)
    {
      label37:
      label65:
      break label37;
    }
    QLog.e("QCircleGiftRecordView", 1, new Object[] { "setUIStyle numColor:", paramString1, ",backColor:", paramString2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.widget.QCircleGiftRecordView
 * JD-Core Version:    0.7.0.1
 */