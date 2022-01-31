package com.tencent.mobileqq.activity.aio.doodle;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResCallback;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.widget.PhotoProgressDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import urf;

public class DoodleLayout
  extends RelativeLayout
  implements ScribbleResMgr.ResCallback
{
  private int jdField_a_of_type_Int;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private DoodleLayout.DoodleLayoutListener jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout$DoodleLayoutListener;
  private DoodleView jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleView;
  private QQToast jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
  private ImageView b;
  
  public DoodleLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public DoodleLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private Drawable a(int paramInt1, int paramInt2)
  {
    PhotoProgressDrawable localPhotoProgressDrawable = new PhotoProgressDrawable(b(), 0, false);
    localPhotoProgressDrawable.setBounds(new Rect(0, 0, paramInt1, paramInt2));
    return localPhotoProgressDrawable;
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (this.b != null) {
        this.b.setVisibility(8);
      }
      return false;
    }
    int i = AIOUtils.a(50.0F, getResources());
    int j = AIOUtils.a(37.0F, getResources());
    if (this.b == null)
    {
      this.b = new ImageView(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, j);
      localLayoutParams.addRule(13, -1);
      this.b.setLayoutParams(localLayoutParams);
      this.b.setImageDrawable(a(i, j));
      addView(this.b);
    }
    if (this.b != null) {
      this.b.setVisibility(0);
    }
    return true;
  }
  
  private void c()
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      addView(this.jdField_a_of_type_AndroidWidgetImageView);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleView = new DoodleView(getContext(), null);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleView.setBackgroundColor(getResources().getColor(2131492924));
      addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleView);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleView.a(new urf(this));
    }
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    setBackgroundColor(-1);
    a(true, false);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    int i = 1;
    int k = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleView != null)
    {
      j = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleView.a(paramBoolean2);
      if (this.jdField_a_of_type_Int > 0)
      {
        if (!paramBoolean1) {
          break label48;
        }
        i = j + i;
      }
    }
    label48:
    do
    {
      return i;
      i = 0;
      break;
      return j;
      i = k;
    } while (!paramBoolean1);
    if (this.jdField_a_of_type_Int > 0) {}
    for (i = j;; i = 0) {
      return i;
    }
  }
  
  public Bitmap a()
  {
    QLog.d("DoodleLayout", 2, "getDoodleBitmap begin");
    Bitmap localBitmap = a(20);
    QLog.d("DoodleLayout", 2, "getDoodleBitmap end");
    return localBitmap;
  }
  
  public Bitmap a(int paramInt)
  {
    if ((paramInt <= 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleView == null)) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleView.a(paramInt);
  }
  
  public DoodleItem a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleView == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleView.a(false);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleView.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout$DoodleLayoutListener = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(View paramView, int paramInt1, ScribbleResMgr.ResInfo paramResInfo, int paramInt2)
  {
    if ((paramInt1 != 2) || (paramResInfo == null) || (paramResInfo.sourceId != this.jdField_a_of_type_Int)) {}
    do
    {
      do
      {
        return;
        if (1 == paramInt2)
        {
          this.jdField_a_of_type_Int = -1;
          setTemplateID(paramResInfo.sourceId);
          return;
        }
        if ((2 != paramInt2) && (3 != paramInt2)) {
          break;
        }
        a(false);
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast == null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a(getContext(), getResources().getString(2131439082), 0);
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.c());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a();
      return;
    } while (4 != paramInt2);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleView.a(paramBoolean2);
    }
    if (paramBoolean1)
    {
      this.jdField_a_of_type_Int = 0;
      setTemplateVisible(Boolean.valueOf(false));
    }
  }
  
  protected Bitmap b()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.sImageCache != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.sImageCache.get("aio_doodle_progress_list");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.a(BaseApplicationImpl.getContext().getResources(), 2130838601);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (BaseApplicationImpl.sImageCache != null)
        {
          BaseApplicationImpl.sImageCache.put("aio_doodle_progress_list", localBitmap1, (byte)0);
          localBitmap2 = localBitmap1;
        }
      }
    }
    return localBitmap2;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleView.a(false) > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleView.b();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void setColor(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleView.setLineColor(paramInt);
    }
  }
  
  public void setDoodleLayoutListener(DoodleLayout.DoodleLayoutListener paramDoodleLayoutListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout$DoodleLayoutListener = paramDoodleLayoutListener;
  }
  
  public void setTemplateID(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleLayout", 2, "setTemplateID:" + paramInt);
    }
    if (this.jdField_a_of_type_Int == paramInt) {}
    do
    {
      Object localObject;
      do
      {
        return;
        this.jdField_a_of_type_Int = paramInt;
        if (this.jdField_a_of_type_Int <= 0) {
          break;
        }
        localObject = DoodleResHelper.a().a(3, this.jdField_a_of_type_Int);
        if ((localObject != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
          setTemplateVisible(Boolean.valueOf(true));
          a(false);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DoodleLayout", 2, "load bitmap failed:" + this.jdField_a_of_type_Int);
        }
        if (!DoodleResHelper.a().b(3, this.jdField_a_of_type_Int))
        {
          if (QLog.isColorLevel()) {
            QLog.d("DoodleLayout", 2, "file not exist, start download:" + this.jdField_a_of_type_Int);
          }
          a(true);
          setTemplateVisible(Boolean.valueOf(false));
          DoodleResHelper.a().b(1, paramInt, this, this);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DoodleLayout", 2, "try use drawable:" + this.jdField_a_of_type_Int);
        }
        localObject = DoodleResHelper.a().a(3, this.jdField_a_of_type_Int, false);
      } while ((localObject == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      setTemplateVisible(Boolean.valueOf(true));
      a(false);
    } while (!QLog.isColorLevel());
    QLog.d("DoodleLayout", 2, "use drawable succ:" + this.jdField_a_of_type_Int);
    return;
    setTemplateVisible(Boolean.valueOf(false));
    a(false);
  }
  
  public void setTemplateVisible(Boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      if (paramBoolean.booleanValue()) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void setTexture(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleView.setLineTexture(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleLayout
 * JD-Core Version:    0.7.0.1
 */