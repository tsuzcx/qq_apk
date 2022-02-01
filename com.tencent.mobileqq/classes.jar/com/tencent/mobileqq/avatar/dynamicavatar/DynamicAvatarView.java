package com.tencent.mobileqq.avatar.dynamicavatar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.VideoDrawable;
import com.tencent.image.VideoDrawable.OnPlayRepeatListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.DynamicFaceDrawable;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.FaceDrawable.OnLoadingStateChangeListener;
import com.tencent.mobileqq.app.face.FaceDrawableImpl;
import com.tencent.mobileqq.app.face.NearByFaceDrawable;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.mobileqq.widget.URLTextImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageWrapper;
import com.tencent.widget.ThemeImageWrapper.DrawInterface;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class DynamicAvatarView
  extends URLTextImageView
  implements ThemeImageWrapper.DrawInterface
{
  public int a;
  private VideoDrawable.OnPlayRepeatListener jdField_a_of_type_ComTencentImageVideoDrawable$OnPlayRepeatListener = new DynamicAvatarView.2(this);
  public DynamicFaceDrawable a;
  public ThemeImageWrapper a;
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
    if ((this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable != null) && (this.jdField_a_of_type_Boolean))
    {
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.a());
        return;
      }
      ThreadManager.getUIHandler().post(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateImageDrawable null == mDynamicFaceDrawable: ");
      boolean bool;
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable == null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append(" isAttachToWindow: ");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      QLog.w("Q.dynamicAvatar", 2, localStringBuilder.toString());
    }
  }
  
  public void a(Drawable paramDrawable)
  {
    DynamicFaceDrawable localDynamicFaceDrawable = this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable;
    if (localDynamicFaceDrawable != null)
    {
      localDynamicFaceDrawable.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      if (localDynamicFaceDrawable.a() != this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.jdField_a_of_type_ComTencentImageURLDrawable) {
        setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.a());
      }
    }
    else
    {
      setImageDrawable(paramDrawable);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_a_of_type_Boolean = true;
    DynamicFaceDrawable localDynamicFaceDrawable = this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable;
    if (localDynamicFaceDrawable != null) {
      setImageDrawable(localDynamicFaceDrawable.a());
    }
  }
  
  protected void onDetachedFromWindow()
  {
    Object localObject = getDrawable();
    if (((localObject instanceof URLDrawable)) && ((((URLDrawable)localObject).getCurrDrawable() instanceof VideoDrawable)))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable;
      if (localObject != null) {
        ((DynamicFaceDrawable)localObject).jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable, true);
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
    super.onDraw(paramCanvas);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadSuccessed, curDrawable ");
    localStringBuilder.append(paramURLDrawable);
    QLog.i("Q.dynamicAvatar", 1, localStringBuilder.toString());
  }
  
  public void setFaceDrawable(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, byte paramByte, int paramInt3, boolean paramBoolean1, Drawable paramDrawable1, Drawable paramDrawable2, FaceDrawable.OnLoadingStateChangeListener paramOnLoadingStateChangeListener, int paramInt4, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt5)
  {
    this.jdField_a_of_type_Int = paramInt5;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Boolean = paramBoolean3;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable;
    if (localObject != null) {
      localObject = DynamicAvatarManager.a((DynamicFaceDrawable)localObject, false);
    } else {
      localObject = null;
    }
    if (DynamicAvatarManager.b(paramInt1, paramInt2, paramString, paramInt4).equals(localObject))
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.a();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.a(paramAppInterface, null, paramInt1, paramInt2, paramString, paramInt4, paramInt3, paramBoolean3, paramInt5, paramBoolean2, paramBoolean5, paramBoolean1, null, true);
      if ((paramAppInterface instanceof QQAppInterface)) {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new FaceDrawableImpl(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, paramInt4, paramBoolean1, paramDrawable1, paramDrawable2, paramOnLoadingStateChangeListener, paramBoolean4);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new NearByFaceDrawable(paramAppInterface, paramInt1, paramInt2, paramString, (byte)1, paramInt3, paramBoolean1, paramDrawable1, paramDrawable2, paramOnLoadingStateChangeListener, paramBoolean4);
      }
      paramAppInterface = this;
      paramAppInterface.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.a(paramBoolean4, null);
      if (!bool) {
        paramAppInterface.setImageDrawable(paramAppInterface.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.a());
      }
    }
    else
    {
      this.jdField_a_of_type_JavaLangString = "";
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable;
      if (localObject != null)
      {
        ((DynamicFaceDrawable)localObject).a(paramAppInterface, null, paramInt1, paramInt2, paramString, paramInt4, paramInt3, paramBoolean3, paramInt5, paramBoolean2, paramBoolean5, paramBoolean1, null, false);
        if ((paramAppInterface instanceof QQAppInterface)) {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new FaceDrawableImpl(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, paramInt4, paramBoolean1, paramDrawable1, paramDrawable2, paramOnLoadingStateChangeListener, paramBoolean4);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new NearByFaceDrawable(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, paramBoolean1, paramDrawable1, paramDrawable2, paramOnLoadingStateChangeListener, paramBoolean4);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.a(paramBoolean4, null);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable = new DynamicFaceDrawable(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, paramBoolean1, paramDrawable1, paramDrawable2, paramOnLoadingStateChangeListener, paramInt4, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramInt5);
      }
      paramAppInterface = this;
      paramAppInterface.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAppInterface);
      paramAppInterface.setImageDrawable(paramAppInterface.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.a());
    }
  }
  
  public void setFaceDrawable(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3)
  {
    Drawable localDrawable = FaceDrawable.getDefaultDrawable(paramInt1, 3);
    setFaceDrawable(paramAppInterface, paramInt1, 200, paramString, (byte)0, 3, false, localDrawable, localDrawable, null, paramInt2, false, paramBoolean1, paramBoolean2, false, paramInt3);
  }
  
  public void setFaceDrawable(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt3)
  {
    Drawable localDrawable = FaceDrawable.getDefaultDrawable(paramInt1, 3);
    setFaceDrawable(paramAppInterface, paramInt1, 200, paramString, (byte)0, 3, false, localDrawable, localDrawable, null, paramInt2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramInt3);
  }
  
  public void setFaceDrawable(AppInterface paramAppInterface, Drawable paramDrawable, int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean1, DynamicAvatar paramDynamicAvatar, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt4)
  {
    this.jdField_a_of_type_Int = paramInt4;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Boolean = paramBoolean1;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable;
    if (localObject != null) {
      localObject = DynamicAvatarManager.a((DynamicFaceDrawable)localObject, false);
    } else {
      localObject = null;
    }
    if (DynamicAvatarManager.b(paramInt1, paramInt2, paramString, paramInt3).equals(localObject))
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.a();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.a(paramAppInterface, paramDrawable, paramInt1, paramInt2, paramString, paramInt3, 3, paramBoolean1, paramInt4, paramBoolean5, paramBoolean4, paramBoolean2, paramDynamicAvatar, true);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.a(paramBoolean3, paramDynamicAvatar);
      if (!bool) {
        setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.a());
      }
    }
    else
    {
      this.jdField_a_of_type_JavaLangString = "";
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable;
      if (localObject == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable = new DynamicFaceDrawable(paramAppInterface, paramDrawable, paramInt1, paramInt2, paramString, paramInt3, paramBoolean1, paramDynamicAvatar, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramInt4);
      }
      else
      {
        ((DynamicFaceDrawable)localObject).a(paramAppInterface, paramDrawable, paramInt1, paramInt2, paramString, paramInt3, 3, paramBoolean1, paramInt4, paramBoolean5, paramBoolean4, paramBoolean2, paramDynamicAvatar, false);
        this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.a(paramBoolean3, paramDynamicAvatar);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(this);
      setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.a());
    }
    if (QLog.isDevelopLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("setFaceDrwable bitmapDrawable is: ");
      paramAppInterface.append(paramDrawable);
      paramAppInterface.append(" id: ");
      paramAppInterface.append(paramString);
      QLog.w("Q.dynamicAvatar", 2, paramAppInterface.toString());
    }
  }
  
  public void setFaceDrawable(AppInterface paramAppInterface, Drawable paramDrawable, int paramInt1, String paramString, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3)
  {
    FaceDrawable.getDefaultDrawable(paramInt1, 3);
    a(paramAppInterface, paramDrawable, paramInt1, 200, paramString, false, paramInt2, false, paramBoolean1, paramBoolean2, false, paramInt3);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    Drawable localDrawable = getDrawable();
    if (paramDrawable == localDrawable) {
      return;
    }
    int k;
    int j;
    if ((localDrawable instanceof URLDrawable))
    {
      localObject1 = ((URLDrawable)localDrawable).getCurrDrawable();
      if ((localObject1 instanceof VideoDrawable))
      {
        localObject1 = (VideoDrawable)localObject1;
        i = 1;
      }
      else
      {
        localObject1 = null;
        i = 0;
      }
      k = 1;
      j = i;
    }
    else
    {
      localObject1 = null;
      j = 0;
      k = 0;
    }
    if ((paramDrawable instanceof URLDrawable))
    {
      localObject2 = ((URLDrawable)paramDrawable).getCurrDrawable();
      if (VideoDrawable.class.isInstance(localObject2))
      {
        localObject2 = (VideoDrawable)localObject2;
        i = 1;
        m = 1;
        break label132;
      }
      i = 1;
    }
    else
    {
      i = 0;
    }
    int n = 0;
    Object localObject2 = null;
    int m = i;
    int i = n;
    label132:
    if (QLog.isDevelopLevel())
    {
      Object localObject4 = toString();
      n = ((String)localObject4).indexOf("{");
      Object localObject3 = localObject4;
      if (n >= 0) {
        localObject3 = ((String)localObject4).substring(n);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable != null)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append((String)localObject3);
        ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.d);
        localObject3 = ((StringBuilder)localObject4).toString();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("setImageDrawable isStatic: ");
        boolean bool;
        if (paramDrawable == this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.jdField_a_of_type_AndroidGraphicsDrawableDrawable) {
          bool = true;
        } else {
          bool = false;
        }
        ((StringBuilder)localObject4).append(bool);
        ((StringBuilder)localObject4).append(" isDynamic: ");
        if (paramDrawable == this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.jdField_a_of_type_ComTencentImageURLDrawable) {
          bool = true;
        } else {
          bool = false;
        }
        ((StringBuilder)localObject4).append(bool);
        ((StringBuilder)localObject4).append(" ");
        ((StringBuilder)localObject4).append((String)localObject3);
        QLog.d("Q.dynamicAvatar", 2, ((StringBuilder)localObject4).toString());
      }
      else
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("setImageDrawable isNotDynamicDrawable. ");
        ((StringBuilder)localObject4).append((String)localObject3);
        ((StringBuilder)localObject4).append(" ");
        ((StringBuilder)localObject4).append(this.jdField_b_of_type_JavaLangString);
        QLog.d("Q.dynamicAvatar", 2, ((StringBuilder)localObject4).toString());
      }
    }
    if (j != 0)
    {
      if (i == 0)
      {
        ((VideoDrawable)localObject1).removeOnPlayRepeatListener(this.jdField_a_of_type_ComTencentImageVideoDrawable$OnPlayRepeatListener);
        if (QLog.isColorLevel()) {
          QLog.e("Q.dynamicAvatar", 2, "removeOnPlayRepeatListener.02");
        }
      }
    }
    else if ((i != 0) && (!this.jdField_b_of_type_Boolean)) {
      ((VideoDrawable)localObject2).setOnPlayRepeatListener(this.jdField_a_of_type_ComTencentImageVideoDrawable$OnPlayRepeatListener);
    }
    if (((k != 0) && (m == 0)) || (localDrawable == null))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable;
      if (localObject1 != null) {
        ((DynamicFaceDrawable)localObject1).jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable, false);
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable;
    if ((localObject1 != null) && (paramDrawable != ((DynamicFaceDrawable)localObject1).jdField_a_of_type_ComTencentImageURLDrawable) && (paramDrawable != this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.jdField_a_of_type_AndroidGraphicsDrawableDrawable))
    {
      this.jdField_b_of_type_JavaLangString = "";
      this.jdField_a_of_type_JavaLangString = "";
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable = null;
    }
    super.setImageDrawable(paramDrawable);
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setImageDrawable drawable is: ");
      ((StringBuilder)localObject1).append(paramDrawable);
      ((StringBuilder)localObject1).append(" id: ");
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
      QLog.w("Q.dynamicAvatar", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void setStrangerFaceDrawable(AppInterface paramAppInterface, int paramInt1, String paramString, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt3)
  {
    Drawable localDrawable = FaceDrawable.getDefaultDrawable(32, 3);
    setFaceDrawable(paramAppInterface, 32, paramInt1, paramString, (byte)1, 3, paramBoolean1, localDrawable, localDrawable, null, paramInt2, false, paramBoolean2, paramBoolean3, paramBoolean4, paramInt3);
  }
  
  public void superOnDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView
 * JD-Core Version:    0.7.0.1
 */