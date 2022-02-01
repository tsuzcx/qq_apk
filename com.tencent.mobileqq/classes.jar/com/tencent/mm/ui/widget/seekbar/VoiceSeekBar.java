package com.tencent.mm.ui.widget.seekbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class VoiceSeekBar
  extends RelativeLayout
{
  protected View a = null;
  protected ImageView b;
  protected ImageView c = null;
  protected ImageView d = null;
  protected float e = 0.0F;
  protected int f = 0;
  
  public VoiceSeekBar(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public VoiceSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public VoiceSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  protected void a()
  {
    this.a = View.inflate(getContext(), 2131629659, this);
    this.b = ((ImageView)this.a.findViewById(2131445505));
    this.c = ((ImageView)this.a.findViewById(2131445504));
    this.d = ((ImageView)this.a.findViewById(2131445503));
    this.c.getViewTreeObserver().addOnPreDrawListener(new VoiceSeekBar.1(this));
  }
  
  public void seek(float paramFloat)
  {
    this.e = paramFloat;
    if (this.c != null)
    {
      Object localObject = this.b;
      if (localObject == null) {
        return;
      }
      localObject = (FrameLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).topMargin = ((int)((1.0F - this.e) * this.f));
      this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
      requestLayout();
      if (this.e <= 0.0F)
      {
        localObject = this.d;
        if (localObject != null)
        {
          ((ImageView)localObject).setImageResource(2131230845);
          return;
        }
      }
      this.d.setImageResource(2131230844);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.seekbar.VoiceSeekBar
 * JD-Core Version:    0.7.0.1
 */