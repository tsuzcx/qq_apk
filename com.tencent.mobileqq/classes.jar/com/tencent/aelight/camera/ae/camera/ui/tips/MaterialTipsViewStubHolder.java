package com.tencent.aelight.camera.ae.camera.ui.tips;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.camera.ui.BaseViewStubHolder;

public class MaterialTipsViewStubHolder
  extends BaseViewStubHolder
{
  private View a;
  private TextView b;
  private ImageView c;
  private AlphaAnimation d = new AlphaAnimation(1.0F, 0.0F);
  private Animation.AnimationListener e = new MaterialTipsViewStubHolder.1(this);
  
  public MaterialTipsViewStubHolder(ViewStub paramViewStub)
  {
    super(paramViewStub);
  }
  
  protected void a(View paramView)
  {
    this.a = paramView.findViewById(2063991285);
    this.c = ((ImageView)paramView.findViewById(2063991286));
    this.b = ((TextView)paramView.findViewById(2063991284));
  }
  
  public void a(String paramString, Bitmap paramBitmap, int paramInt)
  {
    c();
    this.a.setVisibility(0);
    this.b.setVisibility(0);
    this.b.setText(paramString);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.c.setImageBitmap(paramBitmap);
      this.c.setVisibility(0);
    }
    else
    {
      this.c.setVisibility(8);
    }
    this.d.reset();
    this.d.setAnimationListener(this.e);
    paramString = this.d;
    long l;
    if (paramInt > 0) {
      l = paramInt;
    } else {
      l = 3000L;
    }
    paramString.setStartOffset(l);
    this.d.setDuration(200L);
    this.a.setAnimation(this.d);
    this.d.startNow();
  }
  
  public void d()
  {
    if (!ap_()) {
      return;
    }
    this.d.setAnimationListener(null);
    this.d.cancel();
    this.a.clearAnimation();
    this.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.tips.MaterialTipsViewStubHolder
 * JD-Core Version:    0.7.0.1
 */