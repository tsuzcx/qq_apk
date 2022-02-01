package com.tencent.avgame.floatwindow;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class CommonGameFloatWindowLayout
  extends FloatWindowBaseLayout
  implements View.OnClickListener, IGameFloatWindow
{
  View a;
  ImageView b;
  CommonGameFloatWindowLayout.OnFloatWindowClickListener c;
  
  public CommonGameFloatWindowLayout(Context paramContext)
  {
    super(paramContext);
    h();
  }
  
  private void h()
  {
    this.f = ((int)getResources().getDimension(2131296912));
    this.e = ((int)getResources().getDimension(2131296913));
    this.a = LayoutInflater.from(getContext()).inflate(2131624273, null);
    this.b = ((ImageView)this.a.findViewById(2131436392));
    Bitmap localBitmap = AVGameUtil.c("avgame_float_waiting@2x.png");
    if (localBitmap != null) {
      this.b.setImageBitmap(localBitmap);
    }
    addView(this.a, new FrameLayout.LayoutParams(this.e, this.f));
    this.h.width = this.e;
    this.h.height = this.f;
    setOnClickListener(this);
  }
  
  public int a(FloatWindowParams paramFloatWindowParams)
  {
    return paramFloatWindowParams.b - this.e / 2;
  }
  
  public void a()
  {
    if (this.b != null)
    {
      Bitmap localBitmap = AVGameUtil.c("avgame_float_waiting@2x.png");
      if (localBitmap != null) {
        this.b.setImageBitmap(localBitmap);
      }
    }
  }
  
  public int b(FloatWindowParams paramFloatWindowParams)
  {
    return paramFloatWindowParams.c - this.f / 2;
  }
  
  public void b()
  {
    if (this.b != null)
    {
      Bitmap localBitmap = AVGameUtil.c("avgame_float_playing@2x.png");
      if (localBitmap != null) {
        this.b.setImageBitmap(localBitmap);
      }
    }
  }
  
  public void c()
  {
    if (this.b != null)
    {
      Bitmap localBitmap = AVGameUtil.c("avgame_float_you_play@2x.png");
      if (localBitmap != null) {
        this.b.setImageBitmap(localBitmap);
      }
    }
  }
  
  public boolean c(FloatWindowParams paramFloatWindowParams)
  {
    if (paramFloatWindowParams == null) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateFloatWindow isForeground: ");
      localStringBuilder.append(paramFloatWindowParams.a);
      QLog.d("FloatWindowBaseLayout", 2, localStringBuilder.toString());
    }
    boolean bool;
    if (paramFloatWindowParams.a) {
      bool = d();
    } else {
      bool = f();
    }
    return bool ^ true;
  }
  
  public void onClick(View paramView)
  {
    CommonGameFloatWindowLayout.OnFloatWindowClickListener localOnFloatWindowClickListener = this.c;
    if (localOnFloatWindowClickListener != null) {
      localOnFloatWindowClickListener.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setOnFloatWindowClickListener(CommonGameFloatWindowLayout.OnFloatWindowClickListener paramOnFloatWindowClickListener)
  {
    this.c = paramOnFloatWindowClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.floatwindow.CommonGameFloatWindowLayout
 * JD-Core Version:    0.7.0.1
 */