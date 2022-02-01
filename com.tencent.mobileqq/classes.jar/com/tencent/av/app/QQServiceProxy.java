package com.tencent.av.app;

import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.ptu.PtuResChecker;
import com.tencent.av.service.IQQServiceCallback.Stub;
import com.tencent.av.service.IQQServiceForAV;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.av.ui.avatar.AvatarParam;
import com.tencent.av.utils.AudioHelper;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.util.LogUtil;

public class QQServiceProxy
{
  VideoAppInterface a;
  boolean b = false;
  IQQServiceForAV c = null;
  ServiceConnection d = new QQServiceProxy.QQServiceForAVConnection(this);
  IQQServiceCallback.Stub e = new QQServiceProxy.IQQServiceCallbackStub(this);
  public boolean f = false;
  int g = -1;
  private MQLruCache<String, Object> h = null;
  private QQLruCache<String, String> i = null;
  
  public QQServiceProxy(VideoAppInterface paramVideoAppInterface)
  {
    this.a = paramVideoAppInterface;
  }
  
  public Bitmap a(int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = a(paramInt, paramString1, paramString2, paramBoolean1);
    Object localObject2 = b(str);
    Object localObject3;
    if (localObject2 == null)
    {
      localObject3 = this.c;
      if (localObject3 != null) {
        localObject1 = localObject2;
      }
    }
    try
    {
      localObject3 = ((IQQServiceForAV)localObject3).a(paramInt, paramString1, paramString2, paramBoolean1, paramBoolean2);
      if (localObject3 != null)
      {
        localObject1 = localObject3;
        localObject2 = localObject3;
        a(str, (Bitmap)localObject3);
        j = 0;
        localObject1 = localObject3;
      }
      else
      {
        j = 1;
        localObject1 = localObject3;
      }
    }
    catch (RemoteException localRemoteException)
    {
      int j;
      int k;
      break label125;
    }
    catch (NullPointerException localNullPointerException)
    {
      label96:
      break label96;
    }
    k = 3;
    Object localObject1 = localObject2;
    j = k;
    if (paramBoolean2)
    {
      localObject1 = f();
      for (j = k;; j = k)
      {
        break;
        label125:
        k = 2;
        j = k;
        if (!paramBoolean2) {
          break;
        }
        localObject1 = f();
      }
      k = 4;
      localObject1 = localObject2;
      j = k;
      if (paramBoolean2)
      {
        localObject1 = f();
        j = k;
        break label187;
        j = -3;
        localObject1 = localObject2;
      }
    }
    label187:
    if (AudioHelper.e())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getFaceBitmap, uinType[");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("], uin[");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append("], extraUin[");
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append("], isNeedReturnDefaultValue[");
      ((StringBuilder)localObject2).append(paramBoolean2);
      ((StringBuilder)localObject2).append("], ret[");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append("]");
      QLog.w("QQServiceProxy", 1, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  public Bundle a(int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    IQQServiceForAV localIQQServiceForAV = this.c;
    if (localIQQServiceForAV != null) {}
    try
    {
      paramBundle = localIQQServiceForAV.a(paramInt1, paramInt2, paramInt3, null, paramBundle, paramResultReceiver);
      return paramBundle;
    }
    catch (RemoteException paramBundle)
    {
      label31:
      label192:
      break label31;
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("requestEvent, mainCmd[");
      paramBundle.append(paramInt1);
      paramBundle.append("], subType[");
      paramBundle.append(paramInt2);
      paramBundle.append("], seq[");
      paramBundle.append(paramInt3);
      paramBundle.append("]");
      QLog.d("QQServiceProxy", 2, paramBundle.toString());
      break label192;
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("requestEvent, fail, mainCmd[");
        paramBundle.append(paramInt1);
        paramBundle.append("], subType[");
        paramBundle.append(paramInt2);
        paramBundle.append("], seq[");
        paramBundle.append(paramInt3);
        paramBundle.append("]");
        QLog.w("QQServiceProxy", 1, paramBundle.toString());
      }
    }
    return null;
  }
  
  public String a(int paramInt, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public String a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    if (paramBoolean) {
      paramString1 = "0";
    } else {
      paramString1 = "1";
    }
    localStringBuilder.append(paramString1);
    return localStringBuilder.toString();
  }
  
  public String a(AvatarParam paramAvatarParam, int paramInt)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      StringBuilder localStringBuilder;
      String str;
      try
      {
        localObject = ((IQQServiceForAV)localObject).a(paramAvatarParam.a, paramAvatarParam.b, paramAvatarParam.c, paramInt);
      }
      catch (RemoteException localRemoteException)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getHDFacePath, param = ");
          localStringBuilder.append(paramAvatarParam);
          QLog.i("QQServiceProxy", 2, localStringBuilder.toString(), localRemoteException);
        }
        str = null;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getHDFacePath, param = ");
        localStringBuilder.append(paramAvatarParam);
        localStringBuilder.append(", path = ");
        localStringBuilder.append(str);
        QLog.i("QQServiceProxy", 2, localStringBuilder.toString());
      }
      return str;
    }
    throw new NullPointerException("mQQServiceForAV is null");
  }
  
  public void a()
  {
    this.h = GlobalImageCache.a;
    this.i = new QQLruCache(10001, 50, 10);
  }
  
  public void a(int paramInt, String paramString)
  {
    IQQServiceForAV localIQQServiceForAV = this.c;
    if (localIQQServiceForAV != null) {
      try
      {
        localIQQServiceForAV.a(paramInt, paramString);
        return;
      }
      catch (RemoteException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQServiceProxy", 2, "startPumpMessage", paramString);
        }
      }
    }
  }
  
  public void a(long paramLong1, String paramString, long paramLong2)
  {
    IQQServiceForAV localIQQServiceForAV = this.c;
    if (localIQQServiceForAV != null)
    {
      try
      {
        localIQQServiceForAV.a(paramLong1, paramString, paramLong2);
        return;
      }
      catch (RemoteException paramString)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.e("QQServiceProxy", 2, "addSharpMsgRecordList e = ", paramString);
    }
    else if (QLog.isColorLevel())
    {
      QLog.e("QQServiceProxy", 2, "addSharpMsgRecordList mQQServiceForAV==null");
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    MQLruCache localMQLruCache = this.h;
    if ((localMQLruCache != null) && (paramBitmap != null)) {
      localMQLruCache.put(paramString, paramBitmap);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.i != null) && (!TextUtils.isEmpty(paramString2))) {
      this.i.put(paramString1, paramString2);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    IQQServiceForAV localIQQServiceForAV = this.c;
    if (localIQQServiceForAV != null) {
      try
      {
        localIQQServiceForAV.d(paramBoolean);
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QQServiceProxy", 1, "keepVideoProcessAlive fail.", localThrowable);
      }
    }
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    IQQServiceForAV localIQQServiceForAV = this.c;
    if (localIQQServiceForAV != null) {
      try
      {
        boolean bool = localIQQServiceForAV.a(paramInt, paramLong);
        return bool;
      }
      catch (RemoteException localRemoteException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQServiceProxy", 2, "curGAInviteIsRight", localRemoteException);
        }
      }
    }
    return true;
  }
  
  public boolean a(long paramLong)
  {
    IQQServiceForAV localIQQServiceForAV = this.c;
    if (localIQQServiceForAV != null) {
      try
      {
        boolean bool = localIQQServiceForAV.b(paramLong);
        return bool;
      }
      catch (RemoteException localRemoteException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getTroopAdmins-->troopUin=");
        localStringBuilder.append(paramLong);
        QLog.e("QQServiceProxy", 2, localStringBuilder.toString(), localRemoteException);
      }
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    IQQServiceForAV localIQQServiceForAV = this.c;
    if (localIQQServiceForAV != null) {
      try
      {
        boolean bool = localIQQServiceForAV.a(paramString);
        return bool;
      }
      catch (RemoteException paramString)
      {
        QLog.e("QQServiceProxy", 2, "isFriend", paramString);
      }
    }
    return false;
  }
  
  public Bitmap b(String paramString)
  {
    MQLruCache localMQLruCache = this.h;
    if (localMQLruCache != null) {
      return (Bitmap)localMQLruCache.get(paramString);
    }
    return null;
  }
  
  public String b(int paramInt, String paramString1, String paramString2)
  {
    String str = a(paramInt, paramString1, paramString2);
    Object localObject3 = this.c;
    Object localObject1 = null;
    Object localObject2 = null;
    if (localObject3 != null) {
      try
      {
        localObject3 = ((IQQServiceForAV)localObject3).a(paramInt, paramString1, paramString2);
        localObject2 = localObject3;
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject2 = localObject3;
          a(str, (String)localObject3);
        }
        localObject2 = localObject3;
        localObject1 = localObject3;
        if (AudioHelper.e())
        {
          localObject2 = localObject3;
          localObject1 = new StringBuilder();
          localObject2 = localObject3;
          ((StringBuilder)localObject1).append("getDisplayName, uinType[");
          localObject2 = localObject3;
          ((StringBuilder)localObject1).append(paramInt);
          localObject2 = localObject3;
          ((StringBuilder)localObject1).append("], uin[");
          localObject2 = localObject3;
          ((StringBuilder)localObject1).append(LogUtil.getSafePrintUin(paramString1));
          localObject2 = localObject3;
          ((StringBuilder)localObject1).append("], extraUin[");
          localObject2 = localObject3;
          ((StringBuilder)localObject1).append(paramString2);
          localObject2 = localObject3;
          ((StringBuilder)localObject1).append("], name[");
          localObject2 = localObject3;
          ((StringBuilder)localObject1).append((String)localObject3);
          localObject2 = localObject3;
          ((StringBuilder)localObject1).append("]");
          localObject2 = localObject3;
          QLog.w("QQServiceProxy", 1, ((StringBuilder)localObject1).toString());
          localObject1 = localObject3;
        }
      }
      catch (RemoteException paramString2)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.w("QQServiceProxy", 2, "getDisplayName", paramString2);
          localObject1 = localObject2;
        }
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = c(str);
      paramString2 = (String)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return paramString1;
      }
    }
    else
    {
      paramString2 = (String)localObject1;
    }
    return paramString2;
  }
  
  public void b()
  {
    Object localObject = this.h;
    if (localObject != null) {
      ((MQLruCache)localObject).evictAll();
    }
    localObject = this.i;
    if (localObject != null) {
      ((QQLruCache)localObject).evictAll();
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    IQQServiceForAV localIQQServiceForAV = this.c;
    if (localIQQServiceForAV != null) {
      try
      {
        localIQQServiceForAV.b(paramInt, paramString);
        return;
      }
      catch (RemoteException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQServiceProxy", 2, "setBindInfo", paramString);
        }
      }
    }
  }
  
  public void b(long paramLong)
  {
    IQQServiceForAV localIQQServiceForAV = this.c;
    if (localIQQServiceForAV != null) {
      try
      {
        localIQQServiceForAV.a(paramLong);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQServiceProxy", 2, "syncChatingTime", localRemoteException);
        }
      }
    }
  }
  
  public int c(int paramInt, String paramString)
  {
    IQQServiceForAV localIQQServiceForAV = this.c;
    if (localIQQServiceForAV != null) {
      try
      {
        paramInt = localIQQServiceForAV.c(paramInt, paramString);
        return paramInt;
      }
      catch (RemoteException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQServiceProxy", 2, "getDiscussMemberNum", paramString);
        }
      }
    }
    return 0;
  }
  
  public String c(String paramString)
  {
    QQLruCache localQQLruCache = this.i;
    if (localQQLruCache != null) {
      return (String)localQQLruCache.get(paramString);
    }
    return "";
  }
  
  public void c(int paramInt, String paramString1, String paramString2)
  {
    IQQServiceForAV localIQQServiceForAV = this.c;
    if (localIQQServiceForAV != null) {
      try
      {
        localIQQServiceForAV.b(paramInt, paramString1, paramString2);
        return;
      }
      catch (RemoteException paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQServiceProxy", 2, "setPeerInfo", paramString1);
        }
      }
    }
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isQQServiceBind ");
      boolean bool;
      if (this.c != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d("QQServiceProxy", 2, localStringBuilder.toString());
    }
    return this.c != null;
  }
  
  public String d(String paramString)
  {
    Object localObject1 = c(paramString);
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = null;
      localObject1 = null;
      Object localObject3 = this.c;
      if (localObject3 != null) {
        try
        {
          localObject2 = ((IQQServiceForAV)localObject3).b(paramString);
          localObject1 = localObject2;
          a(paramString, (String)localObject2);
          localObject1 = localObject2;
          localObject3 = new StringBuilder();
          localObject1 = localObject2;
          ((StringBuilder)localObject3).append("getPhoneUserNameByPhoneNum, number[");
          localObject1 = localObject2;
          ((StringBuilder)localObject3).append(paramString);
          localObject1 = localObject2;
          ((StringBuilder)localObject3).append("], name[");
          localObject1 = localObject2;
          ((StringBuilder)localObject3).append((String)localObject2);
          localObject1 = localObject2;
          ((StringBuilder)localObject3).append("]");
          localObject1 = localObject2;
          QLog.w("QQServiceProxy", 1, ((StringBuilder)localObject3).toString());
          return localObject2;
        }
        catch (RemoteException paramString)
        {
          localObject2 = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.w("QQServiceProxy", 2, "getPhoneUserNameByPhoneNum", paramString);
            localObject2 = localObject1;
          }
        }
      }
    }
    return localObject2;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceProxy", 2, "bindQQService");
    }
    if ((this.c == null) && (!this.b))
    {
      this.b = true;
      Intent localIntent = new Intent(this.a.getApp(), QQServiceForAV.class);
      this.a.getApp().bindService(localIntent, this.d, 1);
    }
  }
  
  void e()
  {
    AVLog.printAllUserLog("QQServiceProxy", "unbindQQService");
    IQQServiceForAV localIQQServiceForAV = this.c;
    if (localIQQServiceForAV != null)
    {
      try
      {
        localIQQServiceForAV.a();
        this.c.a(this.e);
      }
      catch (Exception localException1)
      {
        QLog.e("QQServiceProxy", 2, "unbindQQService2 ", localException1);
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("QQServiceProxy", 2, "unbindQQService1 ", localRemoteException);
      }
      try
      {
        this.a.getApp().unbindService(this.d);
        return;
      }
      catch (Exception localException2)
      {
        QLog.e("QQServiceProxy", 2, "unbindService3 ", localException2);
      }
    }
  }
  
  public void e(String paramString)
  {
    if (this.c != null) {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("stopPumpMessage[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.w("QQServiceProxy", 1, localStringBuilder.toString());
        this.c.a();
        return;
      }
      catch (RemoteException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQServiceProxy", 2, "stopPumpMessage", paramString);
        }
      }
    }
  }
  
  public long f(String paramString)
  {
    IQQServiceForAV localIQQServiceForAV = this.c;
    if (localIQQServiceForAV != null) {
      try
      {
        long l = localIQQServiceForAV.c(paramString);
        return l;
      }
      catch (RemoteException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQServiceProxy", 2, "getDiscussMemberNum", paramString);
        }
      }
    }
    return 0L;
  }
  
  public Bitmap f()
  {
    return ImageUtil.b(true);
  }
  
  public String g()
  {
    if (this.c != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceProxy", 2, "We will get current user skey");
      }
      try
      {
        String str = this.c.d();
        return str;
      }
      catch (RemoteException localRemoteException)
      {
        if (!QLog.isColorLevel()) {
          break label69;
        }
      }
      QLog.w("QQServiceProxy", 2, "getSKey fail", localRemoteException);
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("QQServiceProxy", 2, "getSKey-->mQQServiceForAV is null");
    }
    label69:
    return null;
  }
  
  public long[] g(String paramString)
  {
    IQQServiceForAV localIQQServiceForAV = this.c;
    if (localIQQServiceForAV != null) {
      try
      {
        paramString = localIQQServiceForAV.d(paramString);
        return paramString;
      }
      catch (RemoteException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQServiceProxy", 2, "getDiscussMemberList", paramString);
        }
      }
    }
    return null;
  }
  
  public String h(String paramString)
  {
    IQQServiceForAV localIQQServiceForAV = this.c;
    if (localIQQServiceForAV != null) {
      try
      {
        paramString = localIQQServiceForAV.p(paramString);
        return paramString;
      }
      catch (RemoteException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQServiceProxy", 2, "getPhoneNumByUin", paramString);
        }
      }
    }
    return null;
  }
  
  public boolean h()
  {
    IQQServiceForAV localIQQServiceForAV = this.c;
    if (localIQQServiceForAV != null) {
      try
      {
        boolean bool = localIQQServiceForAV.b();
        return bool;
      }
      catch (RemoteException localRemoteException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQServiceProxy", 2, "isQQpaused", localRemoteException);
        }
      }
    }
    return false;
  }
  
  public boolean i()
  {
    IQQServiceForAV localIQQServiceForAV = this.c;
    if (localIQQServiceForAV != null) {
      try
      {
        boolean bool = localIQQServiceForAV.o();
        return bool;
      }
      catch (RemoteException localRemoteException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQServiceProxy", 2, "isPhoneCalling", localRemoteException);
        }
      }
    }
    return false;
  }
  
  public boolean i(String paramString)
  {
    IQQServiceForAV localIQQServiceForAV = this.c;
    if (localIQQServiceForAV != null) {
      try
      {
        boolean bool = localIQQServiceForAV.a(paramString, this.a.getCurrentAccountUin());
        return bool;
      }
      catch (RemoteException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return true;
  }
  
  public int j(String paramString)
  {
    IQQServiceForAV localIQQServiceForAV = this.c;
    if (localIQQServiceForAV != null) {
      try
      {
        int j = localIQQServiceForAV.t(paramString);
        return j;
      }
      catch (RemoteException paramString)
      {
        QLog.e("QQServiceProxy", 2, "convertUinTypeEx e = ", paramString);
      }
    } else {
      QLog.e("QQServiceProxy", 2, "convertUinTypeEx mQQServiceForAV == null");
    }
    return -1;
  }
  
  public boolean j()
  {
    IQQServiceForAV localIQQServiceForAV = this.c;
    if (localIQQServiceForAV != null) {
      try
      {
        boolean bool = localIQQServiceForAV.p();
        return bool;
      }
      catch (RemoteException localRemoteException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQServiceProxy", 2, "isQQSVIP remote call exception", localRemoteException);
        }
      }
    }
    return false;
  }
  
  public void k()
  {
    IQQServiceForAV localIQQServiceForAV = this.c;
    if (localIQQServiceForAV != null)
    {
      try
      {
        localIQQServiceForAV.e();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.e("QQServiceProxy", 2, "avStartAddFriendService", localRemoteException);
    }
    else
    {
      this.f = true;
    }
  }
  
  public void k(String paramString)
  {
    try
    {
      if (this.c != null)
      {
        this.c.r(paramString);
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQServiceProxy", 2, "[red dot] redTouchManagerClick", paramString);
      }
    }
  }
  
  public void l(String paramString)
  {
    try
    {
      if (this.c != null)
      {
        this.c.s(paramString);
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQServiceProxy", 2, "[red dot] redTouchManagerExposure", paramString);
      }
    }
  }
  
  public boolean l()
  {
    IQQServiceForAV localIQQServiceForAV = this.c;
    if (localIQQServiceForAV != null) {
      try
      {
        boolean bool = localIQQServiceForAV.g();
        return bool;
      }
      catch (RemoteException localRemoteException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQServiceProxy", 2, "getNearbyProfileData", localRemoteException);
        }
      }
    }
    return false;
  }
  
  public boolean m()
  {
    int j = this.g;
    boolean bool = false;
    IQQServiceForAV localIQQServiceForAV;
    if (j == -1)
    {
      localIQQServiceForAV = this.c;
      if (localIQQServiceForAV == null) {}
    }
    for (;;)
    {
      try
      {
        if (!localIQQServiceForAV.k()) {
          break label72;
        }
        j = 1;
        this.g = j;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQServiceProxy", 2, "getTalkBack", localException);
        }
      }
      if (this.g == 1) {
        bool = true;
      }
      return bool;
      label72:
      j = 0;
    }
  }
  
  public boolean n()
  {
    IQQServiceForAV localIQQServiceForAV = this.c;
    if (localIQQServiceForAV != null)
    {
      try
      {
        bool = localIQQServiceForAV.l();
      }
      catch (NullPointerException localNullPointerException)
      {
        PtuResChecker.a(this.a.getApp());
        QLog.e("PtuResChecker", 1, "getEffectsSoLoadIsOk", localNullPointerException);
        break label89;
      }
      catch (RemoteException localRemoteException)
      {
        PtuResChecker.a(this.a.getApp());
        QLog.e("PtuResChecker", 1, "getEffectsSoLoadIsOk", localRemoteException);
        break label89;
      }
    }
    else
    {
      PtuResChecker.a(this.a.getApp());
      QLog.i("PtuResChecker", 1, "getEffectsSoLoadIsOk, service not ready.");
    }
    label89:
    boolean bool = false;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getEffectsSoLoadIsOk, service[");
      localStringBuilder.append(this.c);
      localStringBuilder.append("], result[");
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.e("PtuResChecker", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public boolean o()
  {
    IQQServiceForAV localIQQServiceForAV = this.c;
    boolean bool;
    if (localIQQServiceForAV != null) {
      try
      {
        bool = localIQQServiceForAV.b(1);
      }
      catch (NullPointerException localNullPointerException)
      {
        AVLog.printErrorLog("getRealNameAuthed", localNullPointerException.getMessage());
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("getRealNameAuthed", 1, "getRealNameAuthed error", localRemoteException);
      }
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getEffectLibPagSoLoadIsOk  result ");
      localStringBuilder.append(this.c);
      localStringBuilder.append("   ");
      localStringBuilder.append(bool);
      QLog.e("getRealNameAuthed", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public boolean p()
  {
    IQQServiceForAV localIQQServiceForAV = this.c;
    boolean bool;
    if (localIQQServiceForAV != null) {
      try
      {
        bool = localIQQServiceForAV.b(2);
      }
      catch (NullPointerException localNullPointerException)
      {
        AVLog.printErrorLog("startRealNameAuth", localNullPointerException.getMessage());
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("startRealNameAuth", 1, "startRealNameAuth error", localRemoteException);
      }
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startRealNameAuth  result ");
      localStringBuilder.append(this.c);
      localStringBuilder.append("   ");
      localStringBuilder.append(bool);
      QLog.e("startRealNameAuth", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public boolean q()
  {
    boolean bool2 = false;
    boolean bool1;
    try
    {
      if (this.c != null)
      {
        bool1 = this.c.q();
      }
      else
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.i("QQServiceProxy", 2, "isInAVGameRoom, service is not ready.");
          bool1 = bool2;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.e("QQServiceProxy", 2, "isInAVGameRoom", localThrowable);
        bool1 = bool2;
      }
    }
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isInAVGameRoom, ret[");
      localStringBuilder.append(bool1);
      localStringBuilder.append("]");
      QLog.i("QQServiceProxy", 4, localStringBuilder.toString());
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.QQServiceProxy
 * JD-Core Version:    0.7.0.1
 */