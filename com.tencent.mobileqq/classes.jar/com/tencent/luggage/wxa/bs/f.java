package com.tencent.luggage.wxa.bs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qz.o;

public class f
  extends FrameLayout
{
  private f.b a = null;
  private f.a b = null;
  
  public f(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public f(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public f(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private f.b a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            o.b("MicroMsg.WAContainerView", "hy: invalid rotate: %d!", new Object[] { Integer.valueOf(paramInt) });
            return f.b.a;
          }
          return f.b.e;
        }
        return f.b.d;
      }
      return f.b.c;
    }
    return f.b.b;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((getContext() instanceof Activity))
    {
      f.b localb = a(((Activity)getContext()).getWindowManager().getDefaultDisplay().getRotation());
      f.a locala = this.b;
      if (locala != null) {
        locala.a(this.a, localb);
      }
      this.a = localb;
    }
  }
  
  public void setOnConfigurationChangedListener(f.a parama)
  {
    this.b = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bs.f
 * JD-Core Version:    0.7.0.1
 */