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
  public int a;
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  BaseAnimHolder jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder;
  ImageSwitchAnim jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim;
  ImageSwitchAnimView jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView = null;
  public SaQianView a;
  int jdField_b_of_type_Int;
  BaseAnimHolder jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder;
  private boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  BaseAnimHolder jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder;
  private int o = 0;
  
  public SpringNomalPendantHolder(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView = new SaQianView(paramView.getContext(), 0, 0, paramView);
    this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView.a(paramView.getWidth(), paramView.getHeight(), 0, 0);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SpringNomalPendantHolder mContext = ");
      localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext);
      localStringBuilder.append(",parentView.getContext() = ");
      localStringBuilder.append(paramView.getContext());
      QLog.d("SpringNomalPendantHolder", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView = new ImageSwitchAnimView(paramView.getContext());
  }
  
  public RectF a(int paramInt)
  {
    Object localObject = this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder;
    if (localObject != null)
    {
      float f = ((BaseAnimHolder)localObject).l;
      this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.j - f, this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.k - f + this.g, this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.j + this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.l + f, this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.k + this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.m + f + this.g);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getCloseBtnTouchRect debug click event, span = ");
        ((StringBuilder)localObject).append(f);
        ((StringBuilder)localObject).append(", closeBtnHolder.x = ");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.j);
        ((StringBuilder)localObject).append(", closeBtnHolder.y = ");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.k);
        ((StringBuilder)localObject).append(", closeBtnHolder.width = ");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.l);
        ((StringBuilder)localObject).append(", closeBtnHolder.height = ");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.m);
        ((StringBuilder)localObject).append(", offsetY = ");
        ((StringBuilder)localObject).append(this.g);
        ((StringBuilder)localObject).append(", listViewScrollY = ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(", closeBtnTouchRect = ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidGraphicsRectF);
        QLog.d("SpringNomalPendantHolder", 2, ((StringBuilder)localObject).toString());
      }
      return this.jdField_a_of_type_AndroidGraphicsRectF;
    }
    return null;
  }
  
  public void a()
  {
    ValueAnimation localValueAnimation = new ValueAnimation(Float.valueOf(1.0F), Float.valueOf(1.07F), new SpringNomalPendantHolder.1(this));
    localValueAnimation.setDuration(500L);
    localValueAnimation.setRepeatCount(-1);
    localValueAnimation.setRepeatMode(2);
    a(localValueAnimation);
    this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView.b();
  }
  
  public void a(int paramInt)
  {
    float f1 = paramInt;
    int i = this.jdField_c_of_type_Int;
    f1 = f1 * 1.0F / i;
    float f2 = this.jdField_b_of_type_Int - i;
    this.k = paramInt;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder;
    if (localObject != null) {
      ((BaseAnimHolder)localObject).m = ((int)(f2 * f1) + paramInt);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim;
    if (localObject != null) {
      ((ImageSwitchAnim)localObject).d = paramInt;
    }
    localObject = this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder;
    if (localObject != null) {
      ((BaseAnimHolder)localObject).k = (paramInt + this.m + this.o);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView != null)
    {
      paramInt = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298317);
      this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView.a(paramInt + this.j + this.l / 2, this.k);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    this.d = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder = new BaseAnimHolder();
    paramInt2 = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298322);
    this.jdField_b_of_type_Int = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298321));
    paramInt3 = this.l / 2;
    paramInt4 = paramInt2 / 2;
    this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845438);
    this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder.a(paramInt1 + paramInt3 - paramInt4, 0, paramInt2, this.jdField_b_of_type_Int, paramView);
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updatePendantLogo ,pendantLogoBitmap = ");
      ((StringBuilder)localObject).append(paramBitmap);
      ((StringBuilder)localObject).append(",switchAnim = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim);
      QLog.d("SpringNomalPendantHolder", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim;
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
      int i = (int)this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131298302);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130845272).copy(Bitmap.Config.ARGB_8888, true));
      }
      int j = (int)this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131298319);
      int m = (int)this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131298314);
      int k = (int)this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131298318);
      m = ViewUtils.a() - j - m;
      this.jdField_c_of_type_Int = k;
      paramBitmap = localBitmap;
      if (localBitmap == null) {
        try
        {
          if (this.jdField_a_of_type_Int == 1) {
            paramBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130845455);
          } else {
            paramBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130845273);
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
      if (this.jdField_a_of_type_Int == 1)
      {
        f3 = this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131298305);
        f2 = paramBitmap.getHeight() * f3 / paramBitmap.getWidth();
        f4 = i;
        f5 = this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131298309);
        f1 = this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131298308);
        f4 = f4 - f2 - f5;
        f5 = f1;
      }
      else
      {
        f1 = this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131298304);
        f2 = i;
        f3 = this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131298307);
        f5 = (j - f1) / 2.0F;
        f4 = f2 - f1 - f3;
        f3 = f1;
        f2 = f1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim = new ImageSwitchAnim(this.jdField_a_of_type_AndroidContentContext, j, i, m, k, (int)f5, (int)f4, (int)f3, (int)f2);
        this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.i = ((int)this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131298316));
        this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.j = ((int)this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131298315));
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.c(BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130845274));
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localOutOfMemoryError.printStackTrace();
        }
      }
      ImageSwitchAnim localImageSwitchAnim = this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim;
      localImageSwitchAnim.e = ((int)f5);
      localImageSwitchAnim.f = ((int)f4);
      localImageSwitchAnim.g = ((int)f3);
      localImageSwitchAnim.h = ((int)f2);
      if (this.jdField_a_of_type_Int == 1)
      {
        localImageSwitchAnim.k = ((int)this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131298312));
        this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.l = ((int)this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131298310));
      }
      else
      {
        localImageSwitchAnim.k = ((int)this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131298313));
        this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.l = 0;
      }
      if (this.jdField_a_of_type_Int == 3)
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.a(paramBitmap);
        this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.a();
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.b(paramBitmap);
      }
      a(m, k, j, i, this.jdField_a_of_type_AndroidViewView);
      this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder = null;
      if (paramBoolean)
      {
        this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder = new BaseAnimHolder();
        i = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298301);
        j = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298298);
        m = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298299);
        k = this.jdField_a_of_type_AndroidViewView.getWidth() - m - i;
        if (QLog.isColorLevel())
        {
          paramBitmap = new StringBuilder();
          paramBitmap.append("init close Btn, mParentView.getWidth() = ");
          paramBitmap.append(this.jdField_a_of_type_AndroidViewView.getWidth());
          paramBitmap.append("closeBtnRightMargin = ");
          paramBitmap.append(m);
          paramBitmap.append("closeBtnWidth = ");
          paramBitmap.append(i);
          paramBitmap.append("closeBtnLeft = ");
          paramBitmap.append(k);
          QLog.d("SpringNomalPendantHolder", 2, paramBitmap.toString());
        }
        m = (int)this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131298300);
        this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845408);
        this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.a(k, m, i, j, this.jdField_a_of_type_AndroidViewView);
      }
      else
      {
        this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder = null;
      }
      d();
      return;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(Canvas paramCanvas)
  {
    boolean bool3 = super.b();
    d();
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.g);
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder != null) && (this.n != 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder.n = this.n;
      this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder.a(paramCanvas);
    }
    super.c(paramCanvas);
    Object localObject = this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder;
    if (localObject != null) {
      ((BaseAnimHolder)localObject).a(paramCanvas);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim;
    boolean bool2 = false;
    boolean bool1;
    if (localObject != null) {
      bool1 = ((ImageSwitchAnim)localObject).a(paramCanvas);
    } else {
      bool1 = false;
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder != null) && (this.n != 0))
    {
      this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder.n = this.n;
      this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder.a(paramCanvas);
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView.a(paramCanvas);
    paramCanvas.restore();
    if ((this.jdField_a_of_type_Boolean) || (bool3) || (bool1)) {
      bool2 = true;
    }
    return bool2;
  }
  
  public void b()
  {
    super.b();
    ImageSwitchAnim localImageSwitchAnim = this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim;
    if (localImageSwitchAnim != null)
    {
      localImageSwitchAnim.b = 1.0F;
      localImageSwitchAnim.a = 1.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.ui.SpringNomalPendantHolder
 * JD-Core Version:    0.7.0.1
 */