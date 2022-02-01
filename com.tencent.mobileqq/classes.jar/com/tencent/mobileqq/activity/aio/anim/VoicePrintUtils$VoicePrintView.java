package com.tencent.mobileqq.activity.aio.anim;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.bubble.BubbleInfo.CommonAttrs;
import com.tencent.mobileqq.vas.ui.VipPngPlayAnimationDrawable;

public class VoicePrintUtils$VoicePrintView
  extends ImageView
{
  public int a;
  public int b;
  public int c;
  public int d;
  BitmapFactory.Options e = new BitmapFactory.Options();
  private String f;
  private VoicePrintUtils.VoicePrintDrawable g;
  private VipPngPlayAnimationDrawable h;
  private BubbleInfo.CommonAttrs i;
  private boolean j;
  
  public VoicePrintUtils$VoicePrintView(Context paramContext)
  {
    super(paramContext);
    paramContext = this.e;
    paramContext.inDensity = 320;
    paramContext.inTargetDensity = getResources().getDisplayMetrics().densityDpi;
  }
  
  private boolean a()
  {
    Object localObject = (Bitmap)GlobalImageCache.a.get(this.f);
    if (localObject != null)
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      if (localLayoutParams.height > ((Bitmap)localObject).getHeight())
      {
        localLayoutParams.height = ((Bitmap)localObject).getHeight();
        this.b = ((Bitmap)localObject).getHeight();
      }
      this.g.a((Bitmap)localObject, this.a);
      localObject = this.h;
      ((VipPngPlayAnimationDrawable)localObject).t = this.a;
      ((VipPngPlayAnimationDrawable)localObject).u = this.g.b.getHeight();
      localObject = this.h;
      ((VipPngPlayAnimationDrawable)localObject).D = this.a;
      ((VipPngPlayAnimationDrawable)localObject).E = this.b;
      ((VipPngPlayAnimationDrawable)localObject).a(this.i.k, this.i.d);
      localObject = this.h;
      ((VipPngPlayAnimationDrawable)localObject).A = -1;
      ((VipPngPlayAnimationDrawable)localObject).B = this.j;
      return true;
    }
    return false;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setImageDrawable(this.g);
      return;
    }
    setImageDrawable(this.h);
  }
  
  public void setBitmap(BubbleInfo.CommonAttrs paramCommonAttrs, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    this.j = paramBoolean;
    this.g = new VoicePrintUtils.VoicePrintDrawable();
    this.g.d = (paramInt1 + paramInt3 + paramInt4);
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.f = paramCommonAttrs.k[0];
    this.i = paramCommonAttrs;
    setPadding(paramInt3, 0, paramInt4, 0);
    this.h = new VipPngPlayAnimationDrawable(getResources());
    if (!a()) {
      new VoicePrintUtils.VoicePrintView.DecodePngTask(this).execute(new String[] { this.f });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils.VoicePrintView
 * JD-Core Version:    0.7.0.1
 */