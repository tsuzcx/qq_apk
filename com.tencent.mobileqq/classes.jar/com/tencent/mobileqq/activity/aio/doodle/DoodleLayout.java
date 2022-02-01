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
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.scribble.ResCallback;
import com.tencent.mobileqq.scribble.ResInfo;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.PhotoProgressDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class DoodleLayout
  extends RelativeLayout
  implements ResCallback
{
  private DoodleView a;
  private ImageView b;
  private int c = 0;
  private ImageView d;
  private DoodleLayout.DoodleLayoutListener e;
  private QQToast f;
  
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
    PhotoProgressDrawable localPhotoProgressDrawable = new PhotoProgressDrawable(getCommonProgressBitmap(), 0, false);
    localPhotoProgressDrawable.setBounds(new Rect(0, 0, paramInt1, paramInt2));
    return localPhotoProgressDrawable;
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      localObject = this.d;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      return false;
    }
    int i = Utils.a(50.0F, getResources());
    int j = Utils.a(37.0F, getResources());
    if (this.d == null)
    {
      this.d = new ImageView(getContext());
      localObject = new RelativeLayout.LayoutParams(i, j);
      ((RelativeLayout.LayoutParams)localObject).addRule(13, -1);
      this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.d.setImageDrawable(a(i, j));
      addView(this.d);
    }
    Object localObject = this.d;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
    return true;
  }
  
  private void c()
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.b == null)
    {
      this.b = new ImageView(getContext());
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.b.setLayoutParams(localLayoutParams);
      addView(this.b);
    }
    if (this.a == null)
    {
      this.a = new DoodleView(getContext(), null);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.a.setLayoutParams(localLayoutParams);
      this.a.setBackgroundColor(getResources().getColor(2131168376));
      addView(this.a);
      this.a.a(new DoodleLayout.1(this));
    }
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    setBackgroundColor(-1);
    a(true, false);
  }
  
  public Bitmap a(int paramInt)
  {
    if (paramInt > 0)
    {
      DoodleView localDoodleView = this.a;
      if (localDoodleView != null) {
        return localDoodleView.a(paramInt);
      }
    }
    return null;
  }
  
  public void a()
  {
    DoodleView localDoodleView = this.a;
    if (localDoodleView != null) {
      localDoodleView.a();
    }
    this.e = null;
    this.b = null;
    this.c = 0;
  }
  
  public void a(View paramView, int paramInt1, ResInfo paramResInfo, int paramInt2)
  {
    if ((paramInt1 == 2) && (paramResInfo != null))
    {
      if (paramResInfo.b != this.c) {
        return;
      }
      if (1 == paramInt2)
      {
        this.c = -1;
        setTemplateID(paramResInfo.b);
        return;
      }
      if ((2 == paramInt2) || (3 == paramInt2))
      {
        a(false);
        if (this.f == null) {
          this.f = QQToast.makeText(getContext(), getResources().getString(2131886479), 0);
        }
        if (!this.f.isShowing()) {
          this.f.show();
        }
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    DoodleView localDoodleView = this.a;
    if (localDoodleView != null) {
      localDoodleView.c(paramBoolean2);
    }
    if (paramBoolean1)
    {
      this.c = 0;
      setTemplateVisible(Boolean.valueOf(false));
    }
  }
  
  public int b(boolean paramBoolean1, boolean paramBoolean2)
  {
    DoodleView localDoodleView = this.a;
    int i = 1;
    if (localDoodleView != null)
    {
      int k = localDoodleView.a(paramBoolean2);
      if (this.c <= 0) {
        i = 0;
      }
      int j = k;
      if (paramBoolean1) {
        j = k + i;
      }
      return j;
    }
    if (!paramBoolean1) {
      return 0;
    }
    if (this.c > 0) {
      return 1;
    }
    return 0;
  }
  
  public void b()
  {
    DoodleView localDoodleView = this.a;
    if ((localDoodleView != null) && (localDoodleView.a(false) > 0)) {
      this.a.b();
    }
  }
  
  protected Bitmap getCommonProgressBitmap()
  {
    Bitmap localBitmap1;
    if (GlobalImageCache.a != null) {
      localBitmap1 = (Bitmap)GlobalImageCache.a.get("aio_doodle_progress_list");
    } else {
      localBitmap1 = null;
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.a(BaseApplication.getContext().getResources(), 2130839591);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (GlobalImageCache.a != null)
        {
          GlobalImageCache.a.put("aio_doodle_progress_list", localBitmap1, (byte)0);
          localBitmap2 = localBitmap1;
        }
      }
    }
    return localBitmap2;
  }
  
  public Bitmap getDoodleBitmap()
  {
    QLog.d("DoodleLayout", 2, "getDoodleBitmap begin");
    Bitmap localBitmap = a(20);
    QLog.d("DoodleLayout", 2, "getDoodleBitmap end");
    return localBitmap;
  }
  
  public DoodleItem getDoodleItem()
  {
    DoodleView localDoodleView = this.a;
    if (localDoodleView == null) {
      return null;
    }
    return localDoodleView.b(false);
  }
  
  public int getTemplateID()
  {
    return this.c;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    } else if ((i == 1) || (i == 3)) {
      getParent().requestDisallowInterceptTouchEvent(false);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setColor(int paramInt)
  {
    DoodleView localDoodleView = this.a;
    if (localDoodleView != null) {
      localDoodleView.setLineColor(paramInt);
    }
  }
  
  public void setDoodleLayoutListener(DoodleLayout.DoodleLayoutListener paramDoodleLayoutListener)
  {
    this.e = paramDoodleLayoutListener;
  }
  
  public void setTemplateID(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setTemplateID:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("DoodleLayout", 2, ((StringBuilder)localObject).toString());
    }
    if (this.c == paramInt) {
      return;
    }
    this.c = paramInt;
    if (this.c > 0)
    {
      localObject = DoodleResHelper.a().e(3, this.c);
      ImageView localImageView;
      if (localObject != null)
      {
        localImageView = this.b;
        if (localImageView != null)
        {
          localImageView.setImageBitmap((Bitmap)localObject);
          setTemplateVisible(Boolean.valueOf(true));
          a(false);
          return;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("load bitmap failed:");
        ((StringBuilder)localObject).append(this.c);
        QLog.d("DoodleLayout", 2, ((StringBuilder)localObject).toString());
      }
      if (!DoodleResHelper.a().b(3, this.c))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("file not exist, start download:");
          ((StringBuilder)localObject).append(this.c);
          QLog.d("DoodleLayout", 2, ((StringBuilder)localObject).toString());
        }
        a(true);
        setTemplateVisible(Boolean.valueOf(false));
        DoodleResHelper.a().b(1, paramInt, this, this);
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("try use drawable:");
        ((StringBuilder)localObject).append(this.c);
        QLog.d("DoodleLayout", 2, ((StringBuilder)localObject).toString());
      }
      localObject = DoodleResHelper.a().a(3, this.c, false);
      if (localObject != null)
      {
        localImageView = this.b;
        if (localImageView != null)
        {
          localImageView.setImageDrawable((Drawable)localObject);
          setTemplateVisible(Boolean.valueOf(true));
          a(false);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("use drawable succ:");
            ((StringBuilder)localObject).append(this.c);
            QLog.d("DoodleLayout", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
    }
    else
    {
      setTemplateVisible(Boolean.valueOf(false));
      a(false);
    }
  }
  
  public void setTemplateVisible(Boolean paramBoolean)
  {
    if (this.b != null)
    {
      if (paramBoolean.booleanValue())
      {
        this.b.setVisibility(0);
        return;
      }
      this.b.setVisibility(8);
    }
  }
  
  public void setTexture(int paramInt)
  {
    DoodleView localDoodleView = this.a;
    if (localDoodleView != null) {
      localDoodleView.setLineTexture(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleLayout
 * JD-Core Version:    0.7.0.1
 */