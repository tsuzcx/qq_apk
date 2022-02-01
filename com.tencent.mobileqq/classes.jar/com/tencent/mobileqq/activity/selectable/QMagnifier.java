package com.tencent.mobileqq.activity.selectable;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;

public class QMagnifier
  implements SelectableMagnifier
{
  private static final int a = ScreenUtil.dip2px(172.0F);
  private static final int b = ScreenUtil.dip2px(31.5F);
  private static final int c = a + ScreenUtil.dip2px(16.0F);
  private static final int d = b + ScreenUtil.dip2px(14.0F);
  private static final int e = c / 2;
  private static final int f = ScreenUtil.dip2px(65.0F);
  private static final int g = ScreenUtil.dip2px(10.0F);
  private static final int h = ViewUtils.dpToPx(30.0F);
  private static final int i = ViewUtils.dpToPx(8.0F);
  private static final int j = ViewUtils.dpToPx(12.0F);
  private static final int k = ScreenUtil.dip2px(4.0F);
  private boolean l;
  private PopupWindow m;
  private RoundImageView n;
  private Bitmap o;
  private Canvas p;
  private long q;
  private final Rect r = new Rect();
  private int s = -1;
  private int t = -1;
  private int u = -1;
  
  private int a(int paramInt)
  {
    int i3 = this.s;
    int i2 = 0;
    int i1 = i2;
    if (i3 != -1)
    {
      int i4 = this.t;
      i1 = i2;
      if (i4 != -1)
      {
        i1 = j;
        if ((paramInt > i4 + i1) && (i3 > i4 + i1)) {
          return 2;
        }
        i3 = j;
        i4 = this.t;
        i1 = i2;
        if (paramInt + i3 < i4)
        {
          i1 = i2;
          if (this.s + i3 < i4) {
            i1 = 1;
          }
        }
      }
    }
    return i1;
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    this.t = this.s;
    this.s = paramInt1;
    if (paramInt2 == 0)
    {
      int i1 = this.u;
      if (i1 != -1)
      {
        if (i1 > paramInt1)
        {
          if (i1 - paramInt1 < i)
          {
            paramInt1 = i1;
            break label94;
          }
          this.u = paramInt1;
          break label94;
        }
        if (i1 >= paramInt1) {
          break label94;
        }
        if (paramInt1 - i1 < i)
        {
          paramInt1 = i1;
          break label94;
        }
        this.u = paramInt1;
        break label94;
      }
    }
    this.u = paramInt1;
    label94:
    if (paramInt2 == 0) {
      return paramInt1 - h;
    }
    float f2;
    float f3;
    float f1;
    if (paramInt2 == 1)
    {
      f2 = paramInt1;
      f3 = h;
      f1 = 1.5F;
    }
    else
    {
      f2 = paramInt1;
      f3 = h;
      f1 = 0.5F;
    }
    return (int)(f2 - f3 * f1);
  }
  
  public static RectF a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return new RectF(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    this.p.setBitmap(this.o);
    RectF localRectF = a(paramView);
    a("start update ");
    a(paramInt1 - localRectF.left, paramInt2 - localRectF.top, 1.5F);
    this.p.drawColor(-1);
    this.p.scale(1.5F, 1.5F);
    this.p.translate(-this.r.left, -this.r.top);
    paramView.draw(this.p);
    a("get Drawing cache ");
    this.p.setBitmap(null);
    this.n.setImageBitmap(this.o);
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(System.currentTimeMillis() - this.q);
      QLog.d("QMagnifier", 2, localStringBuilder.toString());
    }
    this.q = System.currentTimeMillis();
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramFloat2 -= g;
    Rect localRect = this.r;
    int i1 = a;
    int i2 = (int)(paramFloat1 - i1 / 2 / paramFloat3);
    int i3 = b;
    localRect.set(i2, (int)(paramFloat2 - i3 / 2 / paramFloat3), (int)(paramFloat1 + i1 / 2 / paramFloat3), (int)(paramFloat2 + i3 / 2 / paramFloat3));
  }
  
  public void a(@NonNull View paramView1, int paramInt1, int paramInt2, @NonNull View paramView2, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    if (this.m == null)
    {
      this.q = System.currentTimeMillis();
      this.m = new PopupWindow(BaseApplicationImpl.getContext());
      this.m.setClippingEnabled(false);
      a("create popWindow ");
      paramView2 = ((LayoutInflater)paramView1.getContext().getSystemService("layout_inflater")).inflate(2131625208, null, false);
      this.n = ((RoundImageView)paramView2.findViewById(2131428032));
      this.n.setmRadius(k, false);
      this.m.setContentView(paramView2);
      this.m.setWidth(c);
      this.m.setHeight(d);
      this.m.setBackgroundDrawable(null);
      this.o = Bitmap.createBitmap(a, b, Bitmap.Config.ARGB_8888);
      this.p = new Canvas();
      a("create magnifier bitmap and canvas");
    }
    if ((paramBoolean) || (!this.l)) {
      a(paramView1, paramInt1, paramInt2);
    }
    paramInt2 = a(paramInt2, a(paramInt2));
    if (this.l) {
      this.m.update(paramInt1 - e, paramInt2 - f, c, d);
    } else {
      this.m.showAtLocation(paramView1, 0, paramInt1 - e, paramInt2 - f);
    }
    this.l = true;
  }
  
  public boolean a()
  {
    return this.l;
  }
  
  public void b()
  {
    this.m.dismiss();
    this.l = false;
    this.s = -1;
    this.t = -1;
    this.u = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.QMagnifier
 * JD-Core Version:    0.7.0.1
 */