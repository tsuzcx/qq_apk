package com.tencent.mobileqq.activity.aio.item;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import com.immersion.stickersampleapp.HapticManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ZanCombolEffectView
  extends View
{
  private long a = 0L;
  private long b = 0L;
  private long c = 0L;
  private List<ZanCombolEffectView.Node> d = new ArrayList();
  private List<ZanCombolEffectView.Node> e = new ArrayList();
  private List<Bitmap> f = new ArrayList(5);
  private Random g = new Random(System.currentTimeMillis());
  private boolean h = false;
  private boolean i = false;
  private Matrix j = new Matrix();
  private int k = 1000;
  private float l = 0.0F;
  private int m = 0;
  private float n = 0.0F;
  private float o = 10.0F;
  private float p = 1.0F;
  private float q = 0.0F;
  private int r = 0;
  private String s = "chat_item_for_likeplus";
  private int t;
  private boolean u = false;
  
  public ZanCombolEffectView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ZanCombolEffectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ZanCombolEffectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(int paramInt)
  {
    if (this.f.size() == 0) {
      return;
    }
    int i1 = 0;
    while (i1 < paramInt)
    {
      ZanCombolEffectView.Node localNode = new ZanCombolEffectView.Node(null);
      localNode.a = (getWidth() / 2);
      localNode.c = this.g.nextInt(360);
      float f1 = this.g.nextFloat();
      float f2 = this.n;
      double d1 = this.g.nextFloat();
      int i3 = -1;
      if (d1 > 0.5D) {
        i2 = 1;
      } else {
        i2 = -1;
      }
      localNode.f = (f1 * f2 * i2);
      List localList = this.f;
      localNode.h = ((Bitmap)localList.get(this.g.nextInt(localList.size())));
      localNode.g = 1.0F;
      localNode.e = (this.g.nextFloat() * this.q + this.o);
      d1 = this.g.nextFloat() * this.q;
      Double.isNaN(d1);
      f1 = (float)(d1 * 0.2D);
      int i2 = i3;
      if (this.g.nextFloat() > 0.5D) {
        i2 = 1;
      }
      f2 = i2;
      float f3 = this.p;
      localNode.d = (f1 * f2 + f3 * f3);
      d1 = -this.r;
      Double.isNaN(d1);
      localNode.b = ((int)(d1 * 0.12D));
      this.d.add(localNode);
      i1 += 1;
    }
  }
  
  @TargetApi(11)
  public void a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt3, boolean paramBoolean)
  {
    this.k = paramInt1;
    this.l = paramFloat1;
    this.m = paramInt2;
    this.n = paramFloat2;
    this.o = paramFloat3;
    this.q = paramFloat5;
    this.r = paramInt3;
    this.p = paramFloat4;
    this.u = paramBoolean;
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(2, null);
    }
  }
  
  public void a(Integer... paramVarArgs)
  {
    post(new ZanCombolEffectView.1(this, paramVarArgs));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.i)
    {
      if (!this.h) {
        return;
      }
      super.onDraw(paramCanvas);
      long l1 = System.currentTimeMillis();
      if ((l1 - this.a < 800L) && (l1 - this.b > 10L))
      {
        a(1);
        this.b = l1;
      }
      double d1 = l1 - this.c;
      Double.isNaN(d1);
      float f1 = (float)(d1 * 1.0D / 1000.0D);
      this.c = l1;
      int i3 = this.d.size();
      int i2 = 0;
      int i1 = 0;
      ZanCombolEffectView.Node localNode;
      while (i1 < i3)
      {
        localNode = (ZanCombolEffectView.Node)this.d.get(i1);
        localNode.b = ((int)(localNode.b + localNode.e * f1));
        if (localNode.b > this.r)
        {
          this.e.add(localNode);
        }
        else
        {
          d1 = localNode.a;
          double d2 = 2.0F * f1 * localNode.d;
          double d3 = localNode.d;
          Double.isNaN(d3);
          Double.isNaN(d2);
          Double.isNaN(d1);
          localNode.a = ((int)(d1 + (d2 + d3 * 0.02D)));
          localNode.c += localNode.f * f1;
        }
        i1 += 1;
      }
      this.d.removeAll(this.e);
      this.e.clear();
      i3 = this.d.size();
      i1 = i2;
      if (i3 == 0)
      {
        this.h = false;
        if (this.u)
        {
          HapticManager.b().d(this.t);
          this.t = 0;
        }
        return;
      }
      while (i1 < i3)
      {
        localNode = (ZanCombolEffectView.Node)this.d.get(i1);
        this.j.reset();
        this.j.setTranslate(-localNode.h.getWidth() / 2, -localNode.h.getHeight() / 2);
        this.j.postRotate(localNode.c);
        this.j.preScale(localNode.g, localNode.g);
        this.j.postTranslate(localNode.a, localNode.b);
        paramCanvas.drawBitmap(localNode.h, this.j, null);
        i1 += 1;
      }
      invalidate();
    }
  }
  
  public void setPause(boolean paramBoolean)
  {
    this.i = paramBoolean;
    if (this.i) {
      this.d.clear();
    }
    if (this.i)
    {
      if (this.u) {
        HapticManager.b().b(this.t);
      }
    }
    else if (this.u) {
      HapticManager.b().c(this.t);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ZanCombolEffectView
 * JD-Core Version:    0.7.0.1
 */