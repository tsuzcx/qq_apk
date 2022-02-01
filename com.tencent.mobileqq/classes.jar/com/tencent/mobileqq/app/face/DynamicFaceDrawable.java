package com.tencent.mobileqq.app.face;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class DynamicFaceDrawable
{
  public static int[] a = { 2, 3, 5, 0, 4, 6, 1 };
  public static long b;
  public static boolean f = false;
  public static Object w = new Object();
  public Drawable c;
  public URLDrawable d;
  public boolean e = true;
  public boolean g;
  public boolean h;
  public int i;
  public String j;
  public int k;
  public int l;
  public int m;
  public String n;
  public String o;
  public boolean p;
  public boolean q;
  public boolean r;
  public int s;
  public String t;
  public DynamicAvatarManager u;
  public WeakReference<DynamicAvatarView> v;
  public WeakReference<DynamicFaceDrawable> x;
  
  public DynamicFaceDrawable() {}
  
  public DynamicFaceDrawable(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, byte paramByte, int paramInt3, boolean paramBoolean1, Drawable paramDrawable1, Drawable paramDrawable2, FaceDrawable.OnLoadingStateChangeListener paramOnLoadingStateChangeListener, int paramInt4, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt5)
  {
    a(paramAppInterface, null, paramInt1, paramInt2, paramString, paramInt4, paramInt3, paramBoolean3, paramInt5, paramBoolean2, paramBoolean5, paramBoolean1, null, false);
    if ((paramAppInterface instanceof QQAppInterface)) {
      this.c = new FaceDrawableImpl(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, paramInt4, paramBoolean1, paramDrawable1, paramDrawable2, paramOnLoadingStateChangeListener, paramBoolean4);
    } else {
      this.c = new NearByFaceDrawable(paramAppInterface, paramInt1, paramInt2, paramString, (byte)1, paramInt3, paramBoolean1, paramDrawable1, paramDrawable2, paramOnLoadingStateChangeListener, paramBoolean4);
    }
    this.x = new WeakReference(this);
    if (paramInt2 != 205) {
      a(paramBoolean4, null);
    }
  }
  
  public DynamicFaceDrawable(AppInterface paramAppInterface, Drawable paramDrawable, int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean1, DynamicAvatar paramDynamicAvatar, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt4)
  {
    a(paramAppInterface, paramDrawable, paramInt1, paramInt2, paramString, paramInt3, 0, paramBoolean1, paramInt4, paramBoolean5, paramBoolean4, paramBoolean2, paramDynamicAvatar, false);
    this.x = new WeakReference(this);
    if (paramInt2 != 205) {
      a(paramBoolean3, paramDynamicAvatar);
    }
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    synchronized (w)
    {
      f = true;
      AbstractVideoImage.pauseAll();
      paramAppInterface = (DynamicAvatarManager)paramAppInterface.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER);
      if (paramAppInterface != null)
      {
        paramAppInterface.g();
        ThreadManager.getSubThreadHandler().removeCallbacks(paramAppInterface.o);
      }
      return;
    }
  }
  
  public static void b(AppInterface paramAppInterface)
  {
    if (b <= 0L)
    {
      int i1 = DeviceInfoUtil.h();
      if (i1 >= 8) {
        b = 100L;
      } else if (i1 >= 4) {
        b = 200L;
      } else if (i1 >= 3) {
        b = 400L;
      } else if (i1 >= 2) {
        b = 800L;
      } else {
        b = 1000L;
      }
    }
    paramAppInterface = (DynamicAvatarManager)paramAppInterface.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER);
    ThreadManager.getSubThreadHandler().postDelayed(paramAppInterface.o, b);
  }
  
  public void a(AppInterface paramAppInterface, Drawable paramDrawable, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, boolean paramBoolean1, int paramInt5, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, DynamicAvatar paramDynamicAvatar, boolean paramBoolean5)
  {
    this.j = paramString;
    this.i = paramInt4;
    this.s = paramInt5;
    this.h = paramBoolean3;
    this.g = paramBoolean4;
    this.r = paramBoolean2;
    this.c = paramDrawable;
    if (paramInt2 == 200) {
      this.l = 17;
    } else {
      this.l = 18;
    }
    if (paramInt1 == 32) {
      this.k = 18;
    } else {
      this.k = 17;
    }
    this.m = paramInt3;
    this.q = paramBoolean1;
    this.n = "";
    this.o = "";
    this.p = false;
    this.t = DynamicAvatarManager.b(paramInt1, paramInt2, paramString, paramInt3);
    if (!paramBoolean5) {
      this.d = null;
    }
    this.u = ((DynamicAvatarManager)paramAppInterface.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER));
  }
  
  public void a(boolean paramBoolean, DynamicAvatar paramDynamicAvatar)
  {
    this.u.a(this);
    if ((paramBoolean) && (this.u.a(this.s)) && (this.u.c())) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    this.e = paramBoolean;
    if (!this.e) {
      return;
    }
    if ((!this.r) && (!NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext())) && (this.h)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDynamicAvatar uin: ");
      localStringBuilder.append(this.j);
      localStringBuilder.append(" source: ");
      localStringBuilder.append(this.s);
      QLog.i("Q.dynamicAvatar", 2, localStringBuilder.toString());
    }
    if ((!this.r) && (paramDynamicAvatar != null))
    {
      if (paramDynamicAvatar != null)
      {
        this.n = DynamicAvatarManager.a(this.k, this.m, paramDynamicAvatar);
        this.o = DynamicAvatarManager.a(this.k, 640, paramDynamicAvatar);
        if ((this.g) && (TextUtils.isEmpty(this.n)))
        {
          this.n = DynamicAvatarManager.a(17, this.m, paramDynamicAvatar);
          this.o = DynamicAvatarManager.a(17, 640, paramDynamicAvatar);
        }
        if (!TextUtils.isEmpty(this.n)) {
          this.p = true;
        }
        if (QLog.isColorLevel())
        {
          paramDynamicAvatar = new StringBuilder();
          paramDynamicAvatar.append("initValue url: ");
          paramDynamicAvatar.append(this.n);
          QLog.i("Q.dynamicAvatar", 2, paramDynamicAvatar.toString());
        }
      }
      if (!TextUtils.isEmpty(this.n)) {
        this.u.b(this);
      }
    }
    else
    {
      this.u.b(this);
    }
  }
  
  public boolean a()
  {
    return b() == this.d;
  }
  
  public boolean a(URLDrawable paramURLDrawable)
  {
    if (!d()) {
      return false;
    }
    if (this.n.equals(((DynamicAvatarView)this.v.get()).d))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.dynamicAvatar", 2, "setVideoDrawable url equals currentUrl");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.dynamicAvatar", 2, "truly setVideoDrawable");
    }
    ((DynamicAvatarView)this.v.get()).d = this.n;
    this.d = paramURLDrawable;
    if (!f)
    {
      c();
      return true;
    }
    return false;
  }
  
  public Drawable b()
  {
    Object localObject;
    if (this.e)
    {
      URLDrawable localURLDrawable = this.d;
      localObject = localURLDrawable;
      if (localURLDrawable != null) {}
    }
    else
    {
      localObject = this.c;
    }
    return localObject;
  }
  
  public void c()
  {
    if (!d()) {
      return;
    }
    if (this.v.get() != null) {
      ((DynamicAvatarView)this.v.get()).a();
    }
  }
  
  public boolean d()
  {
    Object localObject = this.v;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return false;
      }
      localObject = (DynamicAvatarView)this.v.get();
      if (((DynamicAvatarView)localObject).c != this)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mDynamicFaceDrawable is changed : ");
        localStringBuilder.append(this);
        localStringBuilder.append(" ");
        localStringBuilder.append(((DynamicAvatarView)localObject).c);
        QLog.e("Q.dynamicAvatar", 1, localStringBuilder.toString());
        return false;
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.DynamicFaceDrawable
 * JD-Core Version:    0.7.0.1
 */