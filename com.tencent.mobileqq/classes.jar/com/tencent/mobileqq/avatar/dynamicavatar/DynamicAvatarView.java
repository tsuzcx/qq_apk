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
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
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
  public boolean a;
  public boolean b;
  public DynamicFaceDrawable c;
  public String d;
  public int e;
  public String f;
  public ThemeImageWrapper g;
  private Runnable h = new DynamicAvatarView.1(this);
  private VideoDrawable.OnPlayRepeatListener i = new DynamicAvatarView.2(this);
  
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
    if ((this.c != null) && (this.a))
    {
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        setImageDrawable(this.c.b());
        return;
      }
      ThreadManager.getUIHandler().post(this.h);
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateImageDrawable null == mDynamicFaceDrawable: ");
      boolean bool;
      if (this.c == null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append(" isAttachToWindow: ");
      localStringBuilder.append(this.a);
      QLog.w("Q.dynamicAvatar", 2, localStringBuilder.toString());
    }
  }
  
  public void a(Drawable paramDrawable)
  {
    DynamicFaceDrawable localDynamicFaceDrawable = this.c;
    if (localDynamicFaceDrawable != null)
    {
      localDynamicFaceDrawable.c = paramDrawable;
      if (localDynamicFaceDrawable.b() != this.c.d) {
        setImageDrawable(this.c.b());
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
    this.a = true;
    DynamicFaceDrawable localDynamicFaceDrawable = this.c;
    if (localDynamicFaceDrawable != null) {
      setImageDrawable(localDynamicFaceDrawable.b());
    }
  }
  
  protected void onDetachedFromWindow()
  {
    Object localObject = getDrawable();
    if (((localObject instanceof URLDrawable)) && ((((URLDrawable)localObject).getCurrDrawable() instanceof VideoDrawable)))
    {
      localObject = this.c;
      if (localObject != null) {
        ((DynamicFaceDrawable)localObject).u.b(this.c, true);
      }
      if (QLog.isColorLevel()) {
        QLog.e("Q.dynamicAvatar", 2, "removeOnPlayRepeatListener.01");
      }
    }
    super.onDetachedFromWindow();
    removeCallbacks(this.h);
    this.a = false;
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
    if ((!this.b) && (this.a) && (VideoDrawable.class.isInstance(paramURLDrawable))) {
      ((VideoDrawable)paramURLDrawable).setOnPlayRepeatListener(this.i);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadSuccessed, curDrawable ");
    localStringBuilder.append(paramURLDrawable);
    QLog.i("Q.dynamicAvatar", 1, localStringBuilder.toString());
  }
  
  public void setFaceDrawable(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, byte paramByte, int paramInt3, boolean paramBoolean1, Drawable paramDrawable1, Drawable paramDrawable2, FaceDrawable.OnLoadingStateChangeListener paramOnLoadingStateChangeListener, int paramInt4, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt5)
  {
    this.e = paramInt5;
    this.f = paramString;
    this.b = paramBoolean3;
    Object localObject = this.c;
    if (localObject != null) {
      localObject = DynamicAvatarManager.a((DynamicFaceDrawable)localObject, false);
    } else {
      localObject = null;
    }
    if (DynamicAvatarManager.b(paramInt1, paramInt2, paramString, paramInt4).equals(localObject))
    {
      boolean bool = this.c.a();
      this.c.a(paramAppInterface, null, paramInt1, paramInt2, paramString, paramInt4, paramInt3, paramBoolean3, paramInt5, paramBoolean2, paramBoolean5, paramBoolean1, null, true);
      if (paramInt2 == 205)
      {
        this.c.c = ((IQQGuildAvatarApi)paramAppInterface.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(paramString, paramInt4, true);
        setImageDrawable(this.c.b());
        return;
      }
      if ((paramAppInterface instanceof QQAppInterface)) {
        this.c.c = new FaceDrawableImpl(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, paramInt4, paramBoolean1, paramDrawable1, paramDrawable2, paramOnLoadingStateChangeListener, paramBoolean4);
      } else {
        this.c.c = new NearByFaceDrawable(paramAppInterface, paramInt1, paramInt2, paramString, (byte)1, paramInt3, paramBoolean1, paramDrawable1, paramDrawable2, paramOnLoadingStateChangeListener, paramBoolean4);
      }
      this.c.a(paramBoolean4, null);
      if (!bool) {
        setImageDrawable(this.c.b());
      }
    }
    else
    {
      this.d = "";
      localObject = this.c;
      if (localObject != null)
      {
        ((DynamicFaceDrawable)localObject).a(paramAppInterface, null, paramInt1, paramInt2, paramString, paramInt4, paramInt3, paramBoolean3, paramInt5, paramBoolean2, paramBoolean5, paramBoolean1, null, false);
        if (paramInt2 == 205)
        {
          this.c.c = ((IQQGuildAvatarApi)paramAppInterface.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(paramString, paramInt4, true);
        }
        else
        {
          localObject = this;
          if ((paramAppInterface instanceof QQAppInterface)) {
            ((DynamicAvatarView)localObject).c.c = new FaceDrawableImpl(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, paramInt4, paramBoolean1, paramDrawable1, paramDrawable2, paramOnLoadingStateChangeListener, paramBoolean4);
          } else {
            ((DynamicAvatarView)localObject).c.c = new NearByFaceDrawable(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, paramBoolean1, paramDrawable1, paramDrawable2, paramOnLoadingStateChangeListener, paramBoolean4);
          }
        }
        this.c.a(paramBoolean4, null);
      }
      else
      {
        this.c = new DynamicFaceDrawable(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, paramBoolean1, paramDrawable1, paramDrawable2, paramOnLoadingStateChangeListener, paramInt4, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramInt5);
      }
      paramAppInterface = this;
      paramAppInterface.c.v = new WeakReference(paramAppInterface);
      paramAppInterface.setImageDrawable(paramAppInterface.c.b());
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
    this.e = paramInt4;
    this.f = paramString;
    this.b = paramBoolean1;
    Object localObject = this.c;
    if (localObject != null) {
      localObject = DynamicAvatarManager.a((DynamicFaceDrawable)localObject, false);
    } else {
      localObject = null;
    }
    if (DynamicAvatarManager.b(paramInt1, paramInt2, paramString, paramInt3).equals(localObject))
    {
      boolean bool = this.c.a();
      this.c.a(paramAppInterface, paramDrawable, paramInt1, paramInt2, paramString, paramInt3, 3, paramBoolean1, paramInt4, paramBoolean5, paramBoolean4, paramBoolean2, paramDynamicAvatar, true);
      this.c.a(paramBoolean3, paramDynamicAvatar);
      if (!bool) {
        setImageDrawable(this.c.b());
      }
    }
    else
    {
      this.d = "";
      localObject = this.c;
      if (localObject == null)
      {
        this.c = new DynamicFaceDrawable(paramAppInterface, paramDrawable, paramInt1, paramInt2, paramString, paramInt3, paramBoolean1, paramDynamicAvatar, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramInt4);
      }
      else
      {
        ((DynamicFaceDrawable)localObject).a(paramAppInterface, paramDrawable, paramInt1, paramInt2, paramString, paramInt3, 3, paramBoolean1, paramInt4, paramBoolean5, paramBoolean4, paramBoolean2, paramDynamicAvatar, false);
        this.c.a(paramBoolean3, paramDynamicAvatar);
      }
      this.c.v = new WeakReference(this);
      setImageDrawable(this.c.b());
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
    int m;
    int k;
    if ((localDrawable instanceof URLDrawable))
    {
      localObject1 = ((URLDrawable)localDrawable).getCurrDrawable();
      if ((localObject1 instanceof VideoDrawable))
      {
        localObject1 = (VideoDrawable)localObject1;
        j = 1;
      }
      else
      {
        localObject1 = null;
        j = 0;
      }
      m = 1;
      k = j;
    }
    else
    {
      localObject1 = null;
      k = 0;
      m = 0;
    }
    if ((paramDrawable instanceof URLDrawable))
    {
      localObject2 = ((URLDrawable)paramDrawable).getCurrDrawable();
      if (VideoDrawable.class.isInstance(localObject2))
      {
        localObject2 = (VideoDrawable)localObject2;
        j = 1;
        n = 1;
        break label132;
      }
      j = 1;
    }
    else
    {
      j = 0;
    }
    int i1 = 0;
    Object localObject2 = null;
    int n = j;
    int j = i1;
    label132:
    if (QLog.isDevelopLevel())
    {
      Object localObject4 = toString();
      i1 = ((String)localObject4).indexOf("{");
      Object localObject3 = localObject4;
      if (i1 >= 0) {
        localObject3 = ((String)localObject4).substring(i1);
      }
      if (this.c != null)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append((String)localObject3);
        ((StringBuilder)localObject4).append(this.c.t);
        localObject3 = ((StringBuilder)localObject4).toString();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("setImageDrawable isStatic: ");
        boolean bool;
        if (paramDrawable == this.c.c) {
          bool = true;
        } else {
          bool = false;
        }
        ((StringBuilder)localObject4).append(bool);
        ((StringBuilder)localObject4).append(" isDynamic: ");
        if (paramDrawable == this.c.d) {
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
        ((StringBuilder)localObject4).append(this.f);
        QLog.d("Q.dynamicAvatar", 2, ((StringBuilder)localObject4).toString());
      }
    }
    if (k != 0)
    {
      if (j == 0)
      {
        ((VideoDrawable)localObject1).removeOnPlayRepeatListener(this.i);
        if (QLog.isColorLevel()) {
          QLog.e("Q.dynamicAvatar", 2, "removeOnPlayRepeatListener.02");
        }
      }
    }
    else if ((j != 0) && (!this.b)) {
      ((VideoDrawable)localObject2).setOnPlayRepeatListener(this.i);
    }
    if (((m != 0) && (n == 0)) || (localDrawable == null))
    {
      localObject1 = this.c;
      if (localObject1 != null) {
        ((DynamicFaceDrawable)localObject1).u.b(this.c, false);
      }
    }
    Object localObject1 = this.c;
    if ((localObject1 != null) && (paramDrawable != ((DynamicFaceDrawable)localObject1).d) && (paramDrawable != this.c.c))
    {
      this.f = "";
      this.d = "";
      this.b = false;
      this.c = null;
    }
    super.setImageDrawable(paramDrawable);
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setImageDrawable drawable is: ");
      ((StringBuilder)localObject1).append(paramDrawable);
      ((StringBuilder)localObject1).append(" id: ");
      ((StringBuilder)localObject1).append(this.f);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView
 * JD-Core Version:    0.7.0.1
 */