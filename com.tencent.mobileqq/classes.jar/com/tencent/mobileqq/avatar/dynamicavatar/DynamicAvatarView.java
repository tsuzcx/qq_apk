package com.tencent.mobileqq.avatar.dynamicavatar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import anug;
import anur;
import bdar;
import bdbk;
import bdbl;
import bdbm;
import bdcx;
import bibv;
import bibw;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.VideoDrawable;
import com.tencent.image.VideoDrawable.OnPlayRepeatListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.mobileqq.widget.URLTextImageView;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class DynamicAvatarView
  extends URLTextImageView
  implements bibw
{
  public int a;
  public bdar a;
  public bibv a;
  private VideoDrawable.OnPlayRepeatListener jdField_a_of_type_ComTencentImageVideoDrawable$OnPlayRepeatListener = new anur(this);
  private Runnable jdField_a_of_type_JavaLangRunnable = new DynamicAvatarView.1(this);
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  
  public DynamicAvatarView(Context paramContext)
  {
    super(paramContext);
  }
  
  public DynamicAvatarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DynamicAvatarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(AppInterface paramAppInterface, Drawable paramDrawable, int paramInt1, int paramInt2, String paramString, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt4)
  {
    setFaceDrawable(paramAppInterface, paramDrawable, paramInt1, paramInt2, paramString, paramInt3, paramBoolean3, null, paramBoolean1, paramBoolean4, paramBoolean5, paramBoolean2, paramInt4);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bdar == null) || (!this.jdField_a_of_type_Boolean))
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("updateImageDrawable null == mDynamicFaceDrawable: ");
        if (this.jdField_a_of_type_Bdar != null) {
          break label69;
        }
      }
      label69:
      for (boolean bool = true;; bool = false)
      {
        QLog.w("Q.dynamicAvatar", 2, bool + " isAttachToWindow: " + this.jdField_a_of_type_Boolean);
        return;
      }
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      setImageDrawable(this.jdField_a_of_type_Bdar.a());
      return;
    }
    ThreadManager.getUIHandler().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bdar != null)
    {
      this.jdField_a_of_type_Bdar.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      if (this.jdField_a_of_type_Bdar.a() != this.jdField_a_of_type_Bdar.jdField_a_of_type_ComTencentImageURLDrawable) {
        setImageDrawable(this.jdField_a_of_type_Bdar.a());
      }
      return;
    }
    setImageDrawable(paramDrawable);
  }
  
  public void a_(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bdar != null) {
      setImageDrawable(this.jdField_a_of_type_Bdar.a());
    }
  }
  
  protected void onDetachedFromWindow()
  {
    Drawable localDrawable = getDrawable();
    if (((localDrawable instanceof URLDrawable)) && ((((URLDrawable)localDrawable).getCurrDrawable() instanceof VideoDrawable)))
    {
      if (this.jdField_a_of_type_Bdar != null) {
        this.jdField_a_of_type_Bdar.jdField_a_of_type_Anug.a(this.jdField_a_of_type_Bdar, true);
      }
      if (QLog.isColorLevel()) {
        QLog.e("Q.dynamicAvatar", 2, "removeOnPlayRepeatListener.01");
      }
    }
    super.onDetachedFromWindow();
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      if (this.jdField_a_of_type_Bibv != null)
      {
        this.jdField_a_of_type_Bibv.a(paramCanvas, this);
        return;
      }
      super.onDraw(paramCanvas);
      return;
    }
    catch (Exception paramCanvas)
    {
      if (QLog.isColorLevel()) {
        QLog.w("DynamicAvatarView", 2, QLog.getStackTraceString(paramCanvas));
      }
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFialed(paramURLDrawable, paramThrowable);
    QLog.e("Q.dynamicAvatar", 1, "onLoadFailed", paramThrowable);
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    super.onLoadSuccessed(paramURLDrawable);
    paramURLDrawable = paramURLDrawable.getCurrDrawable();
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean) && (VideoDrawable.class.isInstance(paramURLDrawable))) {
      ((VideoDrawable)paramURLDrawable).setOnPlayRepeatListener(this.jdField_a_of_type_ComTencentImageVideoDrawable$OnPlayRepeatListener);
    }
    QLog.i("Q.dynamicAvatar", 1, "onLoadSuccessed, curDrawable " + paramURLDrawable);
  }
  
  public void setFaceDrawable(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, byte paramByte, int paramInt3, boolean paramBoolean1, Drawable paramDrawable1, Drawable paramDrawable2, bdbl parambdbl, int paramInt4, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt5)
  {
    this.jdField_a_of_type_Int = paramInt5;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Boolean = paramBoolean3;
    String str = null;
    if (this.jdField_a_of_type_Bdar != null) {
      str = anug.a(this.jdField_a_of_type_Bdar, false);
    }
    if (anug.b(paramInt1, paramInt2, paramString, paramInt4).equals(str))
    {
      boolean bool = this.jdField_a_of_type_Bdar.a();
      this.jdField_a_of_type_Bdar.a(paramAppInterface, null, paramInt1, paramInt2, paramString, paramInt4, paramInt3, paramBoolean3, paramInt5, paramBoolean2, paramBoolean5, paramBoolean1, null, true);
      if ((paramAppInterface instanceof QQAppInterface)) {}
      for (this.jdField_a_of_type_Bdar.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new bdbm(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, paramInt4, paramBoolean1, paramDrawable1, paramDrawable2, parambdbl, paramBoolean4);; this.jdField_a_of_type_Bdar.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new bdcx(paramAppInterface, paramInt1, paramInt2, paramString, (byte)1, paramInt3, paramBoolean1, paramDrawable1, paramDrawable2, parambdbl, paramBoolean4))
      {
        this.jdField_a_of_type_Bdar.a(paramBoolean4, null);
        if (!bool) {
          setImageDrawable(this.jdField_a_of_type_Bdar.a());
        }
        return;
      }
    }
    this.jdField_a_of_type_JavaLangString = "";
    if (this.jdField_a_of_type_Bdar != null)
    {
      this.jdField_a_of_type_Bdar.a(paramAppInterface, null, paramInt1, paramInt2, paramString, paramInt4, paramInt3, paramBoolean3, paramInt5, paramBoolean2, paramBoolean5, paramBoolean1, null, false);
      if ((paramAppInterface instanceof QQAppInterface))
      {
        this.jdField_a_of_type_Bdar.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new bdbm(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, paramInt4, paramBoolean1, paramDrawable1, paramDrawable2, parambdbl, paramBoolean4);
        this.jdField_a_of_type_Bdar.a(paramBoolean4, null);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bdar.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(this);
      setImageDrawable(this.jdField_a_of_type_Bdar.a());
      return;
      this.jdField_a_of_type_Bdar.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new bdcx(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, paramBoolean1, paramDrawable1, paramDrawable2, parambdbl, paramBoolean4);
      break;
      this.jdField_a_of_type_Bdar = new bdar(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, paramBoolean1, paramDrawable1, paramDrawable2, parambdbl, paramInt4, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramInt5);
    }
  }
  
  public void setFaceDrawable(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3)
  {
    Drawable localDrawable = bdbk.a(paramInt1, 3);
    setFaceDrawable(paramAppInterface, paramInt1, 200, paramString, (byte)0, 3, false, localDrawable, localDrawable, null, paramInt2, false, paramBoolean1, paramBoolean2, false, paramInt3);
  }
  
  public void setFaceDrawable(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt3)
  {
    Drawable localDrawable = bdbk.a(paramInt1, 3);
    setFaceDrawable(paramAppInterface, paramInt1, 200, paramString, (byte)0, 3, false, localDrawable, localDrawable, null, paramInt2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramInt3);
  }
  
  public void setFaceDrawable(AppInterface paramAppInterface, Drawable paramDrawable, int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean1, DynamicAvatar paramDynamicAvatar, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt4)
  {
    this.jdField_a_of_type_Int = paramInt4;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Boolean = paramBoolean1;
    String str = null;
    if (this.jdField_a_of_type_Bdar != null) {
      str = anug.a(this.jdField_a_of_type_Bdar, false);
    }
    if (anug.b(paramInt1, paramInt2, paramString, paramInt3).equals(str))
    {
      boolean bool = this.jdField_a_of_type_Bdar.a();
      this.jdField_a_of_type_Bdar.a(paramAppInterface, paramDrawable, paramInt1, paramInt2, paramString, paramInt3, 3, paramBoolean1, paramInt4, paramBoolean5, paramBoolean4, paramBoolean2, paramDynamicAvatar, true);
      this.jdField_a_of_type_Bdar.a(paramBoolean3, paramDynamicAvatar);
      if (!bool) {
        setImageDrawable(this.jdField_a_of_type_Bdar.a());
      }
      if (QLog.isDevelopLevel()) {
        QLog.w("Q.dynamicAvatar", 2, "setFaceDrwable bitmapDrawable is: " + paramDrawable + " id: " + paramString);
      }
      return;
    }
    this.jdField_a_of_type_JavaLangString = "";
    if (this.jdField_a_of_type_Bdar == null) {
      this.jdField_a_of_type_Bdar = new bdar(paramAppInterface, paramDrawable, paramInt1, paramInt2, paramString, paramInt3, paramBoolean1, paramDynamicAvatar, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramInt4);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bdar.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(this);
      setImageDrawable(this.jdField_a_of_type_Bdar.a());
      break;
      this.jdField_a_of_type_Bdar.a(paramAppInterface, paramDrawable, paramInt1, paramInt2, paramString, paramInt3, 3, paramBoolean1, paramInt4, paramBoolean5, paramBoolean4, paramBoolean2, paramDynamicAvatar, false);
      this.jdField_a_of_type_Bdar.a(paramBoolean3, paramDynamicAvatar);
    }
  }
  
  public void setFaceDrawable(AppInterface paramAppInterface, Drawable paramDrawable, int paramInt1, String paramString, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3)
  {
    bdbk.a(paramInt1, 3);
    a(paramAppInterface, paramDrawable, paramInt1, 200, paramString, false, paramInt2, false, paramBoolean1, paramBoolean2, false, paramInt3);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    Drawable localDrawable = getDrawable();
    if (paramDrawable == localDrawable) {
      return;
    }
    int m = 0;
    VideoDrawable localVideoDrawable = null;
    int i;
    Object localObject1;
    if ((localDrawable instanceof URLDrawable))
    {
      i = 1;
      localObject1 = ((URLDrawable)localDrawable).getCurrDrawable();
      k = i;
      if ((localObject1 instanceof VideoDrawable))
      {
        localVideoDrawable = (VideoDrawable)localObject1;
        m = 1;
      }
    }
    for (int k = i;; k = 0)
    {
      int j;
      if ((paramDrawable instanceof URLDrawable))
      {
        localObject1 = ((URLDrawable)paramDrawable).getCurrDrawable();
        if (VideoDrawable.class.isInstance(localObject1))
        {
          localObject1 = (VideoDrawable)localObject1;
          j = 1;
          i = 1;
        }
      }
      for (;;)
      {
        Object localObject2;
        boolean bool;
        if (QLog.isDevelopLevel())
        {
          Object localObject3 = toString();
          int n = ((String)localObject3).indexOf("{");
          localObject2 = localObject3;
          if (n >= 0) {
            localObject2 = ((String)localObject3).substring(n);
          }
          if (this.jdField_a_of_type_Bdar == null) {
            break label418;
          }
          localObject2 = (String)localObject2 + this.jdField_a_of_type_Bdar.d;
          localObject3 = new StringBuilder().append("setImageDrawable isStatic: ");
          if (paramDrawable == this.jdField_a_of_type_Bdar.jdField_a_of_type_AndroidGraphicsDrawableDrawable)
          {
            bool = true;
            label203:
            localObject3 = ((StringBuilder)localObject3).append(bool).append(" isDynamic: ");
            if (paramDrawable != this.jdField_a_of_type_Bdar.jdField_a_of_type_ComTencentImageURLDrawable) {
              break label412;
            }
            bool = true;
            label232:
            QLog.d("Q.dynamicAvatar", 2, bool + " " + (String)localObject2);
          }
        }
        else
        {
          label259:
          if (m == 0) {
            break label488;
          }
          if (j == 0) {
            break label461;
          }
        }
        for (;;)
        {
          if (((k != 0) && (i == 0)) || ((localDrawable == null) && (this.jdField_a_of_type_Bdar != null))) {
            this.jdField_a_of_type_Bdar.jdField_a_of_type_Anug.a(this.jdField_a_of_type_Bdar, false);
          }
          if ((this.jdField_a_of_type_Bdar != null) && (paramDrawable != this.jdField_a_of_type_Bdar.jdField_a_of_type_ComTencentImageURLDrawable) && (paramDrawable != this.jdField_a_of_type_Bdar.jdField_a_of_type_AndroidGraphicsDrawableDrawable))
          {
            this.jdField_b_of_type_JavaLangString = "";
            this.jdField_a_of_type_JavaLangString = "";
            this.jdField_b_of_type_Boolean = false;
            this.jdField_a_of_type_Bdar = null;
          }
          super.setImageDrawable(paramDrawable);
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.w("Q.dynamicAvatar", 2, "setImageDrawable drawable is: " + paramDrawable + " id: " + this.jdField_b_of_type_JavaLangString);
          return;
          bool = false;
          break label203;
          label412:
          bool = false;
          break label232;
          label418:
          QLog.d("Q.dynamicAvatar", 2, "setImageDrawable isNotDynamicDrawable. " + (String)localObject2 + " " + this.jdField_b_of_type_JavaLangString);
          break label259;
          label461:
          localVideoDrawable.removeOnPlayRepeatListener(this.jdField_a_of_type_ComTencentImageVideoDrawable$OnPlayRepeatListener);
          if (QLog.isColorLevel())
          {
            QLog.e("Q.dynamicAvatar", 2, "removeOnPlayRepeatListener.02");
            continue;
            label488:
            if ((j != 0) && (!this.jdField_b_of_type_Boolean)) {
              ((VideoDrawable)localObject1).setOnPlayRepeatListener(this.jdField_a_of_type_ComTencentImageVideoDrawable$OnPlayRepeatListener);
            }
          }
        }
        localObject1 = null;
        i = 1;
        j = 0;
        continue;
        j = 0;
        localObject1 = null;
        i = 0;
      }
    }
  }
  
  public void setStrangerFaceDrawable(AppInterface paramAppInterface, int paramInt1, String paramString, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt3)
  {
    Drawable localDrawable = bdbk.a(32, 3);
    setFaceDrawable(paramAppInterface, 32, paramInt1, paramString, (byte)1, 3, paramBoolean1, localDrawable, localDrawable, null, paramInt2, false, paramBoolean2, paramBoolean3, paramBoolean4, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView
 * JD-Core Version:    0.7.0.1
 */