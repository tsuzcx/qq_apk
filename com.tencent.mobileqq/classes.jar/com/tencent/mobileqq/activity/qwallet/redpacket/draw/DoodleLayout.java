package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import agej;
import agpd;
import agpy;
import alfz;
import alga;
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
import bbxu;
import bhgm;
import bjae;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class DoodleLayout
  extends RelativeLayout
  implements bbxu
{
  private int jdField_a_of_type_Int;
  private alga jdField_a_of_type_Alga;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private DoodleView jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDoodleView;
  private QQToast jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
  private ImageView b;
  
  public DoodleLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public DoodleLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private Drawable a(int paramInt1, int paramInt2)
  {
    bjae localbjae = new bjae(a(), 0, false);
    localbjae.setBounds(new Rect(0, 0, paramInt1, paramInt2));
    return localbjae;
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
    int i = agej.a(50.0F, getResources());
    int j = agej.a(37.0F, getResources());
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
  
  private void b()
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      addView(this.jdField_a_of_type_AndroidWidgetImageView);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDoodleView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDoodleView = new DoodleView(getContext(), null);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDoodleView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDoodleView.setBackgroundColor(getResources().getColor(2131167247));
      addView(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDoodleView);
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDoodleView.a(new alfz(this));
    }
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    setBackgroundColor(-1);
    a(true, false);
  }
  
  public int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    int i = 1;
    int k = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDoodleView != null)
    {
      j = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDoodleView.a(paramBoolean2);
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
  
  public agpd a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDoodleView == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDoodleView.a(false);
  }
  
  protected Bitmap a()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.sImageCache != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.sImageCache.get("aio_doodle_progress_list");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = bhgm.a(BaseApplicationImpl.getContext().getResources(), 2130839415);
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
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDoodleView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDoodleView.a(false) > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDoodleView.a();
    }
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
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a(getContext(), getResources().getString(2131689842), 0);
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.c());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a();
      return;
    } while (4 != paramInt2);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDoodleView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDoodleView.a(paramBoolean2);
    }
    if (paramBoolean1)
    {
      this.jdField_a_of_type_Int = 0;
      setTemplateVisible(Boolean.valueOf(false));
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDoodleView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDoodleView.setLineColor(paramInt);
    }
  }
  
  public void setDoodleLayoutListener(alga paramalga)
  {
    this.jdField_a_of_type_Alga = paramalga;
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
        localObject = agpy.a().a(3, this.jdField_a_of_type_Int);
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
        if (!agpy.a().b(3, this.jdField_a_of_type_Int))
        {
          if (QLog.isColorLevel()) {
            QLog.d("DoodleLayout", 2, "file not exist, start download:" + this.jdField_a_of_type_Int);
          }
          a(true);
          setTemplateVisible(Boolean.valueOf(false));
          agpy.a().b(1, paramInt, this, this);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DoodleLayout", 2, "try use drawable:" + this.jdField_a_of_type_Int);
        }
        localObject = agpy.a().a(3, this.jdField_a_of_type_Int, false);
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDoodleView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDoodleView.setLineTexture(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DoodleLayout
 * JD-Core Version:    0.7.0.1
 */