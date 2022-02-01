package com.tencent.luggage.wxa.gd;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.constraintlayout.widget.ConstraintSet;
import com.tencent.luggage.wxa.fy.h;
import com.tencent.luggage.wxa.qz.o;

public class b
  extends ConstraintLayout
  implements h
{
  @NonNull
  private final FrameLayout a;
  @NonNull
  private final TextureView b;
  @NonNull
  private final ImageView c;
  
  public b(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public b(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public b(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setId(2131428569);
    setBackgroundColor(-16777216);
    this.a = new FrameLayout(paramContext);
    addView(this.a, -1, -1);
    this.a.setId(2131428568);
    this.b = new TextureView(paramContext);
    this.a.addView(this.b, -1, -1);
    this.c = new ImageView(paramContext);
    this.a.addView(this.c, -1, -1);
    this.c.setVisibility(4);
    paramContext = new ConstraintSet();
    paramContext.clone(this);
    paramContext.connect(2131428568, 3, 2131428569, 3, 0);
    paramContext.connect(2131428568, 4, 2131428569, 4, 0);
    paramContext.connect(2131428568, 1, 2131428569, 1, 0);
    paramContext.connect(2131428568, 2, 2131428569, 2, 0);
    paramContext.applyTo(this);
  }
  
  public Bitmap getBitmap()
  {
    return this.b.getBitmap();
  }
  
  @Nullable
  public SurfaceTexture getSurfaceTexture()
  {
    return this.b.getSurfaceTexture();
  }
  
  public TextureView.SurfaceTextureListener getSurfaceTextureListener()
  {
    return this.b.getSurfaceTextureListener();
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.c.setImageBitmap(paramBitmap);
      this.c.setVisibility(0);
      return;
    }
    this.c.setVisibility(4);
  }
  
  public void setSurfaceTextureListener(TextureView.SurfaceTextureListener paramSurfaceTextureListener)
  {
    this.b.setSurfaceTextureListener(paramSurfaceTextureListener);
  }
  
  @MainThread
  public void setTextureViewHeightWeight(float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setTextureViewHeightWeight, heightWeight: ");
    ((StringBuilder)localObject).append(paramFloat);
    o.d("MicroMsg.AppBrand.TextureImageViewLikeImpl", ((StringBuilder)localObject).toString());
    localObject = (ConstraintLayout.LayoutParams)this.a.getLayoutParams();
    ((ConstraintLayout.LayoutParams)localObject).height = 0;
    ((ConstraintLayout.LayoutParams)localObject).matchConstraintPercentHeight = paramFloat;
    ((ConstraintLayout.LayoutParams)localObject).width = -1;
    this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  @MainThread
  public void setTextureViewWidthWeight(float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setTextureViewWidthWeight, widthWeight: ");
    ((StringBuilder)localObject).append(paramFloat);
    o.d("MicroMsg.AppBrand.TextureImageViewLikeImpl", ((StringBuilder)localObject).toString());
    localObject = (ConstraintLayout.LayoutParams)this.a.getLayoutParams();
    ((ConstraintLayout.LayoutParams)localObject).width = 0;
    ((ConstraintLayout.LayoutParams)localObject).matchConstraintPercentWidth = paramFloat;
    ((ConstraintLayout.LayoutParams)localObject).height = -1;
    this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gd.b
 * JD-Core Version:    0.7.0.1
 */