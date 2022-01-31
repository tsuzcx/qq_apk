package com.tencent.component.media.image.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.annotation.Public;
import pmx;

@Public
public class SpecifiedDrawable
  extends DrawableContainer
{
  private pmx a;
  
  @Public
  public SpecifiedDrawable(Drawable paramDrawable)
  {
    this(paramDrawable, -1, -1);
  }
  
  @Public
  public SpecifiedDrawable(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    this.a = new pmx(paramDrawable, this);
    this.a.b = paramInt1;
    this.a.c = paramInt2;
    setConstantState(this.a);
  }
  
  private SpecifiedDrawable(pmx parampmx, Resources paramResources)
  {
    this.a = new pmx(parampmx, this, paramResources);
    setConstantState(this.a);
  }
  
  public int getIntrinsicHeight()
  {
    int i = this.a.c;
    if (i > 0) {
      return i;
    }
    return super.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    int i = this.a.b;
    if (i > 0) {
      return i;
    }
    return super.getIntrinsicWidth();
  }
  
  public int getOrginalWidth()
  {
    return super.getIntrinsicWidth();
  }
  
  public int getOriginalHeight()
  {
    return super.getIntrinsicHeight();
  }
  
  @Public
  public void resize(int paramInt1, int paramInt2)
  {
    if ((this.a.b != paramInt1) || (this.a.c != paramInt2))
    {
      this.a.b = paramInt1;
      this.a.c = paramInt2;
      invalidateSelf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.SpecifiedDrawable
 * JD-Core Version:    0.7.0.1
 */