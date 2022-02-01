package com.tencent.mobileqq.activity.springfestival.entry.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.tencent.mobileqq.armap.ConversationActivePendantHolderBase;
import com.tencent.mobileqq.portal.BaseAnimHolder;
import com.tencent.mobileqq.portal.ImageSwitchAnim;
import com.tencent.mobileqq.portal.ImageSwitchAnimView;
import com.tencent.mobileqq.portal.SaQianView;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class SpringNomalPendantHolder
  extends ConversationActivePendantHolderBase
{
  private int G = 0;
  private boolean H = false;
  BaseAnimHolder a;
  BaseAnimHolder b;
  public SaQianView c;
  BaseAnimHolder d;
  RectF e = new RectF();
  public int f = 2;
  ImageSwitchAnim g;
  int h;
  int i;
  ImageSwitchAnimView j = null;
  
  public SpringNomalPendantHolder(View paramView)
  {
    super(paramView);
    this.c = new SaQianView(paramView.getContext(), 0, 0, paramView);
    this.c.a(paramView.getWidth(), paramView.getHeight(), 0, 0);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SpringNomalPendantHolder mContext = ");
      localStringBuilder.append(this.m);
      localStringBuilder.append(",parentView.getContext() = ");
      localStringBuilder.append(paramView.getContext());
      QLog.d("SpringNomalPendantHolder", 2, localStringBuilder.toString());
    }
    this.j = new ImageSwitchAnimView(paramView.getContext());
  }
  
  public RectF a(int paramInt)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      float f1 = ((BaseAnimHolder)localObject).z;
      this.e.set(this.d.x - f1, this.d.y - f1 + this.s, this.d.x + this.d.z + f1, this.d.y + this.d.A + f1 + this.s);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getCloseBtnTouchRect debug click event, span = ");
        ((StringBuilder)localObject).append(f1);
        ((StringBuilder)localObject).append(", closeBtnHolder.x = ");
        ((StringBuilder)localObject).append(this.d.x);
        ((StringBuilder)localObject).append(", closeBtnHolder.y = ");
        ((StringBuilder)localObject).append(this.d.y);
        ((StringBuilder)localObject).append(", closeBtnHolder.width = ");
        ((StringBuilder)localObject).append(this.d.z);
        ((StringBuilder)localObject).append(", closeBtnHolder.height = ");
        ((StringBuilder)localObject).append(this.d.A);
        ((StringBuilder)localObject).append(", offsetY = ");
        ((StringBuilder)localObject).append(this.s);
        ((StringBuilder)localObject).append(", listViewScrollY = ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(", closeBtnTouchRect = ");
        ((StringBuilder)localObject).append(this.e);
        QLog.d("SpringNomalPendantHolder", 2, ((StringBuilder)localObject).toString());
      }
      return this.e;
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    this.l = paramInt2;
    this.a = new BaseAnimHolder();
    paramInt2 = (int)this.m.getResources().getDimension(2131299023);
    this.h = ((int)this.m.getResources().getDimension(2131299022));
    paramInt3 = this.z / 2;
    paramInt4 = paramInt2 / 2;
    this.a.B = this.m.getResources().getDrawable(2130846894);
    this.a.a(paramInt1 + paramInt3 - paramInt4, 0, paramInt2, this.h, paramView);
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updatePendantLogo ,pendantLogoBitmap = ");
      ((StringBuilder)localObject).append(paramBitmap);
      ((StringBuilder)localObject).append(",switchAnim = ");
      ((StringBuilder)localObject).append(this.g);
      QLog.d("SpringNomalPendantHolder", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.g;
    if (localObject != null) {
      ((ImageSwitchAnim)localObject).b(paramBitmap);
    }
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    Bitmap localBitmap = paramBitmap;
    if (QLog.isColorLevel())
    {
      paramBitmap = new StringBuilder();
      paramBitmap.append("updatePendant logoBitmap = ");
      paramBitmap.append(localBitmap);
      paramBitmap.append(",showCloseBtn = ");
      paramBitmap.append(paramBoolean);
      QLog.d("SpringNomalPendantHolder", 2, paramBitmap.toString());
    }
    try
    {
      int k = (int)this.n.getResources().getDimension(2131299003);
      if (this.B == null) {
        this.B = new BitmapDrawable(this.m.getResources(), BitmapFactory.decodeResource(this.m.getResources(), 2130846728).copy(Bitmap.Config.ARGB_8888, true));
      }
      int m = (int)this.n.getResources().getDimension(2131299020);
      int i1 = (int)this.n.getResources().getDimension(2131299015);
      int n = (int)this.n.getResources().getDimension(2131299019);
      i1 = ViewUtils.getScreenWidth() - m - i1;
      this.i = n;
      paramBitmap = localBitmap;
      if (localBitmap == null) {
        try
        {
          if (this.f == 1) {
            paramBitmap = BitmapFactory.decodeResource(this.m.getResources(), 2130846911);
          } else {
            paramBitmap = BitmapFactory.decodeResource(this.m.getResources(), 2130846729);
          }
        }
        catch (OutOfMemoryError paramBitmap)
        {
          paramBitmap.printStackTrace();
          paramBitmap = localBitmap;
        }
      }
      float f3;
      float f2;
      float f4;
      float f5;
      float f1;
      if (this.f == 1)
      {
        f3 = this.n.getResources().getDimension(2131299006);
        f2 = paramBitmap.getHeight() * f3 / paramBitmap.getWidth();
        f4 = k;
        f5 = this.n.getResources().getDimension(2131299010);
        f1 = this.n.getResources().getDimension(2131299009);
        f4 = f4 - f2 - f5;
        f5 = f1;
      }
      else
      {
        f1 = this.n.getResources().getDimension(2131299005);
        f2 = k;
        f3 = this.n.getResources().getDimension(2131299008);
        f5 = (m - f1) / 2.0F;
        f4 = f2 - f1 - f3;
        f3 = f1;
        f2 = f1;
      }
      if (this.g == null)
      {
        this.g = new ImageSwitchAnim(this.m, m, k, i1, n, (int)f5, (int)f4, (int)f3, (int)f2);
        this.g.n = ((int)this.n.getResources().getDimension(2131299017));
        this.g.o = ((int)this.n.getResources().getDimension(2131299016));
        try
        {
          this.g.c(BitmapFactory.decodeResource(this.m.getResources(), 2130846730));
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localOutOfMemoryError.printStackTrace();
        }
      }
      ImageSwitchAnim localImageSwitchAnim = this.g;
      localImageSwitchAnim.e = ((int)f5);
      localImageSwitchAnim.f = ((int)f4);
      localImageSwitchAnim.g = ((int)f3);
      localImageSwitchAnim.h = ((int)f2);
      if (this.f == 1)
      {
        localImageSwitchAnim.p = ((int)this.n.getResources().getDimension(2131299013));
        this.g.q = ((int)this.n.getResources().getDimension(2131299011));
      }
      else
      {
        localImageSwitchAnim.p = ((int)this.n.getResources().getDimension(2131299014));
        this.g.q = 0;
      }
      if (this.f == 3)
      {
        this.g.a(paramBitmap);
        this.g.b();
      }
      else
      {
        this.g.b(paramBitmap);
      }
      a(i1, n, m, k, this.n);
      this.b = null;
      if (paramBoolean)
      {
        this.d = new BaseAnimHolder();
        k = (int)this.m.getResources().getDimension(2131299002);
        m = (int)this.m.getResources().getDimension(2131298999);
        i1 = (int)this.m.getResources().getDimension(2131299000);
        n = this.n.getWidth() - i1 - k;
        if (QLog.isColorLevel())
        {
          paramBitmap = new StringBuilder();
          paramBitmap.append("init close Btn, mParentView.getWidth() = ");
          paramBitmap.append(this.n.getWidth());
          paramBitmap.append("closeBtnRightMargin = ");
          paramBitmap.append(i1);
          paramBitmap.append("closeBtnWidth = ");
          paramBitmap.append(k);
          paramBitmap.append("closeBtnLeft = ");
          paramBitmap.append(n);
          QLog.d("SpringNomalPendantHolder", 2, paramBitmap.toString());
        }
        i1 = (int)this.n.getResources().getDimension(2131299001);
        this.d.B = this.m.getResources().getDrawable(2130846864);
        this.d.a(n, i1, k, m, this.n);
      }
      else
      {
        this.d = null;
      }
      e();
      return;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.H = paramBoolean;
  }
  
  public boolean a()
  {
    return this.H;
  }
  
  public boolean a(Canvas paramCanvas)
  {
    boolean bool3 = super.i();
    e();
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.s);
    if ((this.a != null) && (this.E != 0))
    {
      this.a.E = this.E;
      this.a.a(paramCanvas);
    }
    super.d(paramCanvas);
    Object localObject = this.d;
    if (localObject != null) {
      ((BaseAnimHolder)localObject).a(paramCanvas);
    }
    localObject = this.g;
    boolean bool2 = false;
    boolean bool1;
    if (localObject != null) {
      bool1 = ((ImageSwitchAnim)localObject).a(paramCanvas);
    } else {
      bool1 = false;
    }
    if ((this.b != null) && (this.E != 0))
    {
      this.b.E = this.E;
      this.b.a(paramCanvas);
    }
    this.c.a(paramCanvas);
    paramCanvas.restore();
    if ((this.t) || (bool3) || (bool1)) {
      bool2 = true;
    }
    return bool2;
  }
  
  public void b()
  {
    ValueAnimation localValueAnimation = new ValueAnimation(Float.valueOf(1.0F), Float.valueOf(1.07F), new SpringNomalPendantHolder.1(this));
    localValueAnimation.setDuration(500L);
    localValueAnimation.setRepeatCount(-1);
    localValueAnimation.setRepeatMode(2);
    a(localValueAnimation);
    this.c.b();
  }
  
  public void b(int paramInt)
  {
    float f1 = paramInt;
    int k = this.i;
    f1 = f1 * 1.0F / k;
    float f2 = this.h - k;
    this.y = paramInt;
    Object localObject = this.a;
    if (localObject != null) {
      ((BaseAnimHolder)localObject).A = ((int)(f2 * f1) + paramInt);
    }
    localObject = this.g;
    if (localObject != null) {
      ((ImageSwitchAnim)localObject).d = paramInt;
    }
    localObject = this.b;
    if (localObject != null) {
      ((BaseAnimHolder)localObject).y = (paramInt + this.A + this.G);
    }
    if (this.c != null)
    {
      paramInt = (int)this.m.getResources().getDimension(2131299018);
      this.c.a(paramInt + this.x + this.z / 2, this.y);
    }
  }
  
  public void c()
  {
    super.c();
    ImageSwitchAnim localImageSwitchAnim = this.g;
    if (localImageSwitchAnim != null)
    {
      localImageSwitchAnim.j = 1.0F;
      localImageSwitchAnim.i = 1.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.ui.SpringNomalPendantHolder
 * JD-Core Version:    0.7.0.1
 */