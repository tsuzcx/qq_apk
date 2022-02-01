package com.tencent.map.sdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;

public final class hu
  implements gh
{
  public hv.a a;
  private Context b;
  private TextView c;
  
  public hu(Context paramContext)
  {
    this.b = paramContext;
    this.c = new pc(this.b);
  }
  
  public final void a() {}
  
  public final void a(int paramInt1, int paramInt2) {}
  
  public final boolean a(ViewGroup paramViewGroup)
  {
    if ((paramViewGroup != null) && (this.c != null))
    {
      Object localObject = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
      int i = paramViewGroup.getMeasuredWidth();
      int j = paramViewGroup.getMeasuredHeight();
      this.c.setTextSize(18.0F);
      this.c.setTextColor(-16777216);
      this.c.setText("鉴权失败,请检查你的key");
      localObject = fy.a(this.c);
      paramViewGroup.addView(this.c);
      paramViewGroup = this.a;
      if (paramViewGroup != null) {
        paramViewGroup.a((Bitmap)localObject, i, j);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.hu
 * JD-Core Version:    0.7.0.1
 */