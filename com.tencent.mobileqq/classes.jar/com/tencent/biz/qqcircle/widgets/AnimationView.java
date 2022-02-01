package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.util.ArrayList;

public class AnimationView
  extends RoundImageView
{
  protected AnimationView.AnimationInfo a;
  protected AnimationView.Player b;
  protected AnimationView.MyAnimationListener c;
  
  public AnimationView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    AnimationView.Player localPlayer = this.b;
    if (localPlayer == null) {
      return;
    }
    localPlayer.b();
  }
  
  public void b()
  {
    AnimationView.Player localPlayer = this.b;
    if (localPlayer == null) {
      return;
    }
    localPlayer.d();
  }
  
  public AnimationView.AnimationInfo getAnimationFromInfo()
  {
    return this.a;
  }
  
  public AnimationView.Player getPlayer()
  {
    return this.b;
  }
  
  public void setAnimationFromBitmaps(ArrayList<Bitmap> paramArrayList, int paramInt1, int paramInt2)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() <= 0) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramArrayList.size())
      {
        localArrayList.add(new BitmapDrawable(getResources(), (Bitmap)paramArrayList.get(i)));
        i += 1;
      }
      setAnimationFromDrawabs(localArrayList, paramInt1, paramInt2);
    }
  }
  
  public void setAnimationFromDrawabs(ArrayList<Drawable> paramArrayList, int paramInt1, int paramInt2)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (paramInt1 <= 0) {
        return;
      }
      this.a = AnimationView.AnimationInfo.a(paramArrayList, paramInt1, paramInt2);
      if (this.b == null) {
        this.b = new AnimationView.Player(this);
      }
    }
  }
  
  public void setAnimationFromDrawabs(Drawable[] paramArrayOfDrawable, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfDrawable != null) && (paramArrayOfDrawable.length > 0))
    {
      if (paramInt1 <= 0) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramArrayOfDrawable.length)
      {
        localArrayList.add(paramArrayOfDrawable[i]);
        i += 1;
      }
      setAnimationFromDrawabs(localArrayList, paramInt1, paramInt2);
    }
  }
  
  public void setAnimationFromInfo(AnimationView.AnimationInfo paramAnimationInfo)
  {
    this.a = paramAnimationInfo;
    if (this.b == null) {
      this.b = new AnimationView.Player(this);
    }
  }
  
  public void setAnimationListener(AnimationView.MyAnimationListener paramMyAnimationListener)
  {
    this.c = paramMyAnimationListener;
  }
  
  public void setPlayer(AnimationView.Player paramPlayer)
  {
    this.b = paramPlayer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.AnimationView
 * JD-Core Version:    0.7.0.1
 */