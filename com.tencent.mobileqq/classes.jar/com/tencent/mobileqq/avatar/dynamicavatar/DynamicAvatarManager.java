package com.tencent.mobileqq.avatar.dynamicavatar;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.VideoDrawable.VideoDrawableParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.DynamicFaceDrawable;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.avatar.api.IQQAvatarManagerService;
import com.tencent.mobileqq.config.business.avatar.DynamicAvatarConfBean;
import com.tencent.mobileqq.config.business.avatar.DynamicAvatarConfBean.DynamicAvatarConfig;
import com.tencent.mobileqq.config.business.avatar.DynamicAvatarConfProcessor;
import com.tencent.mobileqq.config.business.avatar.DynamicAvatarConfProcessor.Companion;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyManagerHelper;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.api.INearbyProxy;
import com.tencent.mobileqq.nearby.ipc.INearbyProcManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.util.IPCFaceHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.RspBody;

public class DynamicAvatarManager
  implements Manager
{
  public static int a = 8;
  public String b;
  public String c;
  public DynamicAvatarDownloadManager d;
  public ConcurrentHashMap<String, DynamicAvatar> e;
  public SparseArray<ArrayList<String>> f = new SparseArray();
  public ArrayList<WeakReference<DynamicFaceDrawable>> g;
  public ArrayList<WeakReference<DynamicFaceDrawable>> h;
  public ArrayList<WeakReference<DynamicFaceDrawable>> i;
  public ArrayList<WeakReference<DynamicFaceDrawable>> j;
  public volatile boolean k = true;
  public long l = 0L;
  public volatile int m;
  DPCObserver n = new DynamicAvatarManager.MyDPCObserver(this);
  public Runnable o = new DynamicAvatarManager.8(this);
  private DynamicAvatarConfig p;
  private AppInterface q;
  private Resources r;
  private Runnable s = new DynamicAvatarManager.1(this);
  private DynamicAvatarInfoObserver t = new DynamicAvatarManager.2(this);
  private DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback u = new DynamicAvatarManager.5(this);
  
  public DynamicAvatarManager(AppInterface paramAppInterface)
  {
    int i1 = 2;
    if (paramAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "new DynamicAvatarManager param app is null.");
      }
      return;
    }
    this.q = paramAppInterface;
    this.q.addObserver(this.t, true);
    this.j = new ArrayList();
    this.i = new ArrayList();
    this.g = new ArrayList();
    this.h = new ArrayList();
    this.e = new ConcurrentHashMap();
    this.d = new DynamicAvatarDownloadManager(paramAppInterface);
    this.d.a(this.u);
    this.r = BaseApplicationImpl.getContext().getResources();
    a();
    a = this.p.j;
    ((IDPCApi)QRoute.api(IDPCApi.class)).addObserver(this.n);
    if (!ShortVideoUtils.isVideoSoLibLoaded()) {
      i1 = 0;
    }
    this.m = i1;
  }
  
  public static String a(int paramInt1, int paramInt2, DynamicAvatar paramDynamicAvatar)
  {
    if (paramDynamicAvatar == null) {
      return null;
    }
    if (paramInt1 == 17)
    {
      if (paramInt2 == 100) {
        return paramDynamicAvatar.basicSmallUrl;
      }
      if (paramInt2 == 200) {
        return paramDynamicAvatar.basicMiddleUrl;
      }
      if (paramInt2 == 640) {
        return paramDynamicAvatar.basicBigUrl;
      }
    }
    else if (paramInt1 == 18)
    {
      if (paramInt2 == 100) {
        return paramDynamicAvatar.nearbySmallUrl;
      }
      if (paramInt2 == 200) {
        return paramDynamicAvatar.nearbyMiddleUrl;
      }
      if (paramInt2 == 640) {
        return paramDynamicAvatar.nearbyBigUrl;
      }
    }
    return "";
  }
  
  public static String a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String a(DynamicFaceDrawable paramDynamicFaceDrawable, boolean paramBoolean)
  {
    if (paramDynamicFaceDrawable == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramDynamicFaceDrawable.k);
    localStringBuilder.append("_");
    localStringBuilder.append(paramDynamicFaceDrawable.l);
    localStringBuilder.append("_");
    localStringBuilder.append(paramDynamicFaceDrawable.j);
    if ((paramBoolean) || ((paramDynamicFaceDrawable.p) && (!TextUtils.isEmpty(paramDynamicFaceDrawable.n))))
    {
      localStringBuilder.append("_");
      localStringBuilder.append(paramDynamicFaceDrawable.n);
    }
    return localStringBuilder.toString();
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    int i1;
    int i2;
    int i3;
    label245:
    synchronized (this.i)
    {
      i1 = this.i.size() - 1;
      i2 = 0;
      if (i1 >= 0)
      {
        WeakReference localWeakReference = (WeakReference)this.i.get(i1);
        if (localWeakReference == null)
        {
          this.i.remove(i1);
          i3 = i2;
          break label245;
        }
        DynamicFaceDrawable localDynamicFaceDrawable = (DynamicFaceDrawable)localWeakReference.get();
        if (localDynamicFaceDrawable == null)
        {
          this.i.remove(i1);
          i3 = i2;
          break label245;
        }
        i3 = i2;
        if (!paramString1.equals(localDynamicFaceDrawable.t)) {
          break label245;
        }
        if (TextUtils.isEmpty(paramString2))
        {
          localDynamicFaceDrawable.d = null;
          localDynamicFaceDrawable.c();
          this.i.remove(i1);
          i3 = i2;
          break label245;
        }
        localDynamicFaceDrawable.n = paramString2;
        localDynamicFaceDrawable.o = paramString3;
        if ((localDynamicFaceDrawable.v != null) && (localDynamicFaceDrawable.v.get() != null) && (paramString2.equals(((DynamicAvatarView)localDynamicFaceDrawable.v.get()).d)))
        {
          this.i.remove(localWeakReference);
          i3 = i2;
          break label245;
        }
      }
      else
      {
        if (i2 != 0) {
          c(paramString2);
        }
        return;
      }
    }
  }
  
  private boolean a(DynamicAvatar paramDynamicAvatar, Setting paramSetting, int paramInt)
  {
    if ((paramDynamicAvatar != null) && (paramSetting != null))
    {
      long l1 = System.currentTimeMillis() / 1000L;
      if ((l1 - paramDynamicAvatar.getTimeStamp >= 0L) && (l1 - paramDynamicAvatar.getTimeStamp < 86400L))
      {
        StringBuilder localStringBuilder;
        if (paramInt == 17)
        {
          if ((paramDynamicAvatar.getTimeStamp + 5 < paramSetting.headImgTimestamp) && ((paramDynamicAvatar.basicSetTimeStamp + 5) * 1000 < paramSetting.updateTimestamp))
          {
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("isNeed2GetDynamicAvatarInfo: ");
              localStringBuilder.append(paramDynamicAvatar.getTimeStamp);
              localStringBuilder.append(" ");
              localStringBuilder.append(paramSetting.headImgTimestamp);
              localStringBuilder.append(" ");
              localStringBuilder.append(paramDynamicAvatar.basicSetTimeStamp);
              localStringBuilder.append(" ");
              localStringBuilder.append(paramSetting.updateTimestamp);
              QLog.i("Q.dynamicAvatar", 2, localStringBuilder.toString());
            }
            return true;
          }
        }
        else if ((paramInt == 18) && (paramDynamicAvatar.getTimeStamp + 5 < paramSetting.headImgTimestamp) && ((paramDynamicAvatar.nearbySetTimeStamp + 5) * 1000 < paramSetting.updateTimestamp))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("isNeed2GetDynamicAvatarInfo: ");
            localStringBuilder.append(paramDynamicAvatar.getTimeStamp);
            localStringBuilder.append(" ");
            localStringBuilder.append(paramSetting.headImgTimestamp);
            localStringBuilder.append(" ");
            localStringBuilder.append(paramDynamicAvatar.basicSetTimeStamp);
            localStringBuilder.append(" ");
            localStringBuilder.append(paramSetting.updateTimestamp);
            QLog.i("Q.dynamicAvatar", 2, localStringBuilder.toString());
          }
          return true;
        }
        return false;
      }
      if (QLog.isColorLevel())
      {
        paramSetting = new StringBuilder();
        paramSetting.append("isNeed2GetDynamicAvatarInfo beyond 24h, stamp: ");
        paramSetting.append(paramDynamicAvatar.getTimeStamp);
        QLog.i("Q.dynamicAvatar", 2, paramSetting.toString());
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.dynamicAvatar", 2, "isNeed2GetDynamicAvatarInfo dynamicAvatrInfo or setting info is null.");
    }
    return true;
  }
  
  public static String b(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    int i1 = 17;
    if (paramInt2 == 200) {
      paramInt2 = 17;
    } else {
      paramInt2 = 18;
    }
    if (paramInt1 == 32) {
      i1 = 18;
    }
    return a(i1, paramInt2, paramString, paramInt3);
  }
  
  private Setting c(int paramInt, String paramString)
  {
    Setting localSetting = null;
    if (paramInt == 18)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stranger_");
      ((StringBuilder)localObject).append(Integer.toString(paramInt));
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramString);
      paramString = ((StringBuilder)localObject).toString();
      localObject = this.q;
      if ((localObject instanceof INearbyAppInterface)) {}
      for (paramString = ((IQQAvatarManagerService)((AppInterface)localObject).getRuntimeService(IQQAvatarManagerService.class, "nearby")).getFaceSetting(paramString);; paramString = ((IPCFaceHelper)NearbyManagerHelper.a((QQAppInterface)localObject).a(true)).a(paramString))
      {
        return paramString;
        if (!(localObject instanceof QQAppInterface)) {
          break;
        }
      }
    }
    Object localObject = this.q;
    if ((localObject instanceof INearbyAppInterface)) {
      return null;
    }
    if ((localObject instanceof QQAppInterface))
    {
      localObject = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager();
      localSetting = (Setting)((EntityManager)localObject).find(Setting.class, paramString);
      ((EntityManager)localObject).close();
    }
    return localSetting;
  }
  
  private void h()
  {
    if (this.m == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "loadVideoSo called");
      }
      ThreadManager.getSubThreadHandler().postDelayed(this.s, 10000L);
      this.m = 1;
    }
  }
  
  public DynamicAvatar a(int paramInt, String paramString)
  {
    AppInterface localAppInterface = this.q;
    boolean bool1 = localAppInterface instanceof QQAppInterface;
    boolean bool2 = true;
    Object localObject1 = null;
    Object localObject2 = null;
    if (bool1)
    {
      if (this.e.containsKey(paramString))
      {
        localObject1 = (DynamicAvatar)this.e.get(paramString);
        localObject2 = localObject1;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getDynamicAvatarInfo cache is null: ");
          if (localObject1 == null) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          ((StringBuilder)localObject2).append(bool1);
          QLog.i("Q.dynamicAvatar", 2, ((StringBuilder)localObject2).toString());
          localObject2 = localObject1;
        }
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = b(paramInt, paramString);
        localObject2 = this.e;
        if (localObject1 != null) {}
        try
        {
          this.e.put(paramString, localObject1);
        }
        finally {}
      }
    }
    else if ((localAppInterface instanceof INearbyAppInterface))
    {
      localObject1 = (DynamicAvatar)((INearbyAppInterface)localAppInterface).getNearbyProcManager().a(paramInt, paramString);
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("db find dynamic avatarInfo is null: ");
      if (localObject1 == null) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      paramString.append(bool1);
      QLog.i("Q.dynamicAvatar", 2, paramString.toString());
    }
    return localObject1;
  }
  
  public DynamicAvatar a(String paramString)
  {
    if (((this.q instanceof QQAppInterface)) && (this.e.containsKey(paramString))) {
      paramString = (DynamicAvatar)this.e.get(paramString);
    } else {
      paramString = null;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDynamicAvatarInfoFromCache: ");
      boolean bool;
      if (paramString == null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.i("Q.dynamicAvatar", 2, localStringBuilder.toString());
    }
    return paramString;
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    this.p = new DynamicAvatarConfig();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DynamicAvatarConfig|init config:");
      localStringBuilder.append(this.p);
      localStringBuilder.append(",costTime:");
      localStringBuilder.append(System.currentTimeMillis() - l1);
      QLog.d("Q.dynamicAvatar", 2, localStringBuilder.toString());
    }
  }
  
  public void a(DynamicFaceDrawable paramDynamicFaceDrawable)
  {
    if (paramDynamicFaceDrawable == null) {
      return;
    }
    synchronized (this.j)
    {
      this.j.remove(paramDynamicFaceDrawable.x);
      synchronized (this.g)
      {
        this.g.remove(paramDynamicFaceDrawable.x);
        this.h.remove(paramDynamicFaceDrawable.x);
        synchronized (this.i)
        {
          this.i.remove(paramDynamicFaceDrawable.x);
          return;
        }
      }
    }
  }
  
  public void a(DynamicFaceDrawable paramDynamicFaceDrawable, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.i.size() >= a) && (!paramBoolean1)) {
      synchronized (this.j)
      {
        this.j.add(paramDynamicFaceDrawable.x);
        return;
      }
    }
    ??? = paramDynamicFaceDrawable.t;
    synchronized (this.i)
    {
      this.i.add(paramDynamicFaceDrawable.x);
      if (!paramBoolean1) {
        synchronized (this.j)
        {
          this.j.remove(paramDynamicFaceDrawable.x);
        }
      }
      ??? = new DynamicAvatarManager.3(this, paramDynamicFaceDrawable, (String)???);
      long l1;
      if (!paramBoolean2) {
        l1 = 0L;
      } else if (paramDynamicFaceDrawable.s == 0) {
        l1 = 1500L;
      } else {
        l1 = 400L;
      }
      long l2 = l1;
      if (DeviceInfoUtil.h() <= 2) {
        l2 = l1 * 2L;
      }
      ThreadManager.getSubThreadHandler().postDelayed(new DynamicAvatarManager.4(this, (Runnable)???), l2);
      return;
    }
  }
  
  public void a(DynamicAvatarInfo paramDynamicAvatarInfo)
  {
    if (paramDynamicAvatarInfo == null) {
      return;
    }
    Object localObject1 = this.q;
    if ((localObject1 instanceof QQAppInterface))
    {
      EntityManager localEntityManager = ((AppInterface)localObject1).getEntityManagerFactory().createEntityManager();
      localEntityManager.getTransaction().begin();
      localObject1 = null;
      try
      {
        Cursor localCursor = localEntityManager.query(false, DynamicAvatar.class.getSimpleName(), null, null, null, null, null, null, null);
        int i1;
        Object localObject2;
        if (localCursor != null)
        {
          localObject1 = localCursor;
          i1 = localCursor.getCount();
          localObject1 = localCursor;
          localCursor.moveToFirst();
          if (i1 >= 1000)
          {
            while (i1 > 333)
            {
              localObject1 = localCursor;
              localCursor.moveToNext();
              i1 -= 1;
            }
            localObject1 = localCursor;
            i1 = localCursor.getInt(localCursor.getColumnIndex("_id"));
            localObject1 = localCursor;
            localObject2 = new StringBuilder();
            localObject1 = localCursor;
            ((StringBuilder)localObject2).append("delete from ");
            localObject1 = localCursor;
            ((StringBuilder)localObject2).append(DynamicAvatar.class.getSimpleName());
            localObject1 = localCursor;
            ((StringBuilder)localObject2).append(" where ");
            localObject1 = localCursor;
            ((StringBuilder)localObject2).append("_id");
            localObject1 = localCursor;
            ((StringBuilder)localObject2).append(" < ");
            localObject1 = localCursor;
            ((StringBuilder)localObject2).append(i1);
            localObject1 = localCursor;
            ((StringBuilder)localObject2).append(";");
            localObject1 = localCursor;
            localEntityManager.execSQL(((StringBuilder)localObject2).toString());
          }
        }
        if (paramDynamicAvatarInfo != null)
        {
          localObject1 = localCursor;
          if (paramDynamicAvatarInfo.a != null)
          {
            localObject1 = localCursor;
            if (!paramDynamicAvatarInfo.a.isEmpty())
            {
              localObject1 = localCursor;
              paramDynamicAvatarInfo = paramDynamicAvatarInfo.a.iterator();
              for (;;)
              {
                localObject1 = localCursor;
                if (paramDynamicAvatarInfo.hasNext())
                {
                  localObject1 = localCursor;
                  localObject2 = DynamicAvatar.convertFrom((DynamicAvatarInfo.OneUinHeadInfo)paramDynamicAvatarInfo.next());
                  if (localObject2 == null) {
                    continue;
                  }
                  localObject1 = localCursor;
                  long l1 = ((DynamicAvatar)localObject2).uin;
                  i1 = 0;
                  localObject1 = localCursor;
                  Object localObject3 = (DynamicAvatar)localEntityManager.find(DynamicAvatar.class, "uin=?", new String[] { String.valueOf(l1) });
                  if (localObject3 != null)
                  {
                    localObject1 = localCursor;
                    ((DynamicAvatar)localObject2).setStatus(((DynamicAvatar)localObject3).getStatus());
                    localObject1 = localCursor;
                    ((DynamicAvatar)localObject2).setId(((DynamicAvatar)localObject3).getId());
                  }
                  localObject1 = localCursor;
                  if (((DynamicAvatar)localObject2).getStatus() == 1000)
                  {
                    localObject1 = localCursor;
                    localEntityManager.persistOrReplace((Entity)localObject2);
                  }
                  else
                  {
                    localObject1 = localCursor;
                    localEntityManager.update((Entity)localObject2);
                  }
                  localObject1 = localCursor;
                  localObject3 = this.e;
                  localObject1 = localCursor;
                  try
                  {
                    if (this.e.size() > 200)
                    {
                      localObject1 = this.e.entrySet().iterator();
                      int i2;
                      do
                      {
                        if (!((Iterator)localObject1).hasNext()) {
                          break;
                        }
                        ((Iterator)localObject1).remove();
                        i2 = i1 + 1;
                        i1 = i2;
                      } while (i2 < 100);
                    }
                    if (((DynamicAvatar)localObject2).uin > 0L) {
                      this.e.put(String.valueOf(((DynamicAvatar)localObject2).uin), localObject2);
                    }
                    if (((DynamicAvatar)localObject2).tinyId > 0L) {
                      this.e.put(String.valueOf(((DynamicAvatar)localObject2).tinyId), localObject2);
                    }
                  }
                  finally
                  {
                    localObject1 = localCursor;
                  }
                }
              }
            }
          }
        }
        localObject1 = localCursor;
        localEntityManager.getTransaction().commit();
        if (localCursor != null) {
          localCursor.close();
        }
        localEntityManager.getTransaction().end();
        localEntityManager.close();
        return;
      }
      finally
      {
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
        localEntityManager.getTransaction().end();
        localEntityManager.close();
      }
    }
  }
  
  public void a(DynamicAvatar paramDynamicAvatar)
  {
    Object localObject = this.q;
    if ((localObject instanceof QQAppInterface))
    {
      EntityManager localEntityManager = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager();
      localObject = (DynamicAvatar)localEntityManager.find(DynamicAvatar.class, "uin=?", new String[] { String.valueOf(paramDynamicAvatar.uin) });
      if (localObject != null)
      {
        paramDynamicAvatar.setStatus(((DynamicAvatar)localObject).getStatus());
        paramDynamicAvatar.setId(((DynamicAvatar)localObject).getId());
      }
      if (paramDynamicAvatar.getStatus() == 1000) {
        localEntityManager.persistOrReplace(paramDynamicAvatar);
      } else {
        localEntityManager.update(paramDynamicAvatar);
      }
      localEntityManager.close();
      if (QLog.isColorLevel())
      {
        paramDynamicAvatar = new StringBuilder();
        paramDynamicAvatar.append("updateDynamicAvatarInfo: avatarInfo is : ");
        paramDynamicAvatar.append(localObject);
        QLog.d("Q.dynamicAvatar", 2, paramDynamicAvatar.toString());
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ??? = this.p;
      if ((??? != null) && (((DynamicAvatarConfig)???).b)) {
        synchronized (this.p)
        {
          this.p.a();
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("---onDpcPullFinished---|mDynamicAvatarConfig:");
            localStringBuilder.append(this.p);
            QLog.d("Q.dynamicAvatar", 2, localStringBuilder.toString());
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("---onDpcPullFinished---|isSuccess:");
      ((StringBuilder)???).append(paramBoolean);
      QLog.d("Q.dynamicAvatar", 2, ((StringBuilder)???).toString());
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 0) {
        return;
      }
      Object localObject = this.q;
      if ((localObject instanceof QQAppInterface))
      {
        localObject = new oidb_0x74b.RspBody();
        try
        {
          ((oidb_0x74b.RspBody)localObject).mergeFrom(paramArrayOfByte);
          a(DynamicAvatarInfo.a((oidb_0x74b.RspBody)localObject));
          return;
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          if (!QLog.isDevelopLevel()) {
            return;
          }
        }
        paramArrayOfByte.printStackTrace();
      }
      else if ((localObject instanceof INearbyAppInterface))
      {
        ((INearbyAppInterface)localObject).getNearbyProcManager().a(paramArrayOfByte);
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    Object localObject = this.p;
    if (localObject != null) {
      switch (paramInt)
      {
      default: 
        break;
      case 7: 
        bool = ((DynamicAvatarConfig)localObject).g;
        break;
      case 6: 
      case 8: 
        bool = true;
        break;
      case 5: 
        bool = ((DynamicAvatarConfig)localObject).i;
        break;
      case 4: 
        bool = ((DynamicAvatarConfig)localObject).h;
        break;
      case 3: 
        bool = ((DynamicAvatarConfig)localObject).g;
        break;
      case 2: 
        bool = ((DynamicAvatarConfig)localObject).f;
        break;
      case 1: 
        bool = ((DynamicAvatarConfig)localObject).e;
        break;
      case 0: 
        bool = ((DynamicAvatarConfig)localObject).d;
        break;
      }
    }
    boolean bool = false;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isPlayDynamicAvatar|source:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",isPlay:");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append(this.p);
      QLog.d("Q.dynamicAvatar", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public boolean a(FaceInfo paramFaceInfo, Setting paramSetting, int paramInt)
  {
    if (paramFaceInfo == null) {
      return false;
    }
    paramFaceInfo = a(paramFaceInfo.d, paramFaceInfo.c);
    if (paramFaceInfo != null)
    {
      if (paramSetting == null) {
        return true;
      }
      StringBuilder localStringBuilder;
      if (paramInt == 17)
      {
        if ((paramFaceInfo.getTimeStamp - 5 > paramSetting.headImgTimestamp) && ((paramFaceInfo.basicSetTimeStamp - 5) * 1000 > paramSetting.updateTimestamp))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("isNeed2UpdateSettingInfo basic: ");
            localStringBuilder.append(paramFaceInfo.getTimeStamp);
            localStringBuilder.append(" ");
            localStringBuilder.append(paramSetting.headImgTimestamp);
            localStringBuilder.append(" ");
            localStringBuilder.append(paramFaceInfo.basicSetTimeStamp);
            localStringBuilder.append(" ");
            localStringBuilder.append(paramSetting.updateTimestamp);
            QLog.i("Q.dynamicAvatar", 2, localStringBuilder.toString());
          }
          return true;
        }
      }
      else if ((paramInt == 18) && (paramFaceInfo.getTimeStamp - 5 > paramSetting.headImgTimestamp) && ((paramFaceInfo.nearbySetTimeStamp - 5) * 1000 > paramSetting.updateTimestamp))
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("isNeed2UpdateSettingInfo nearby: ");
          localStringBuilder.append(paramFaceInfo.getTimeStamp);
          localStringBuilder.append(" ");
          localStringBuilder.append(paramSetting.headImgTimestamp);
          localStringBuilder.append(" ");
          localStringBuilder.append(paramFaceInfo.basicSetTimeStamp);
          localStringBuilder.append(" ");
          localStringBuilder.append(paramSetting.updateTimestamp);
          QLog.i("Q.dynamicAvatar", 2, localStringBuilder.toString());
        }
        return true;
      }
      return false;
    }
    return true;
  }
  
  public DynamicAvatarConfig b()
  {
    if (this.p == null) {
      a();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getConfig DynamicAvatarConfig|");
      localStringBuilder.append(this.p);
      QLog.d("Q.dynamicAvatar", 2, localStringBuilder.toString());
    }
    return this.p;
  }
  
  public DynamicAvatar b(int paramInt, String paramString)
  {
    Object localObject = this.q;
    boolean bool = true;
    if (localObject != null)
    {
      EntityManager localEntityManager = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager();
      if (paramInt == 18) {
        localObject = "tinyId=?";
      } else {
        localObject = "uin=?";
      }
      paramString = (DynamicAvatar)localEntityManager.find(DynamicAvatar.class, (String)localObject, new String[] { paramString });
      localEntityManager.close();
    }
    else
    {
      paramString = null;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getAvatarInfoFromDb: avatarInfo is null: ");
      if (paramString != null) {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      QLog.d("Q.dynamicAvatar", 2, ((StringBuilder)localObject).toString());
    }
    return paramString;
  }
  
  public void b(DynamicFaceDrawable paramDynamicFaceDrawable)
  {
    if (paramDynamicFaceDrawable == null) {
      return;
    }
    if (this.m != 2)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.dynamicAvatar", 2, "getDynamicAvatar isVideoSoLibLoaded false.");
      }
      h();
      return;
    }
    if (!paramDynamicFaceDrawable.q)
    {
      ??? = a(paramDynamicFaceDrawable, false);
      ArrayList localArrayList = (ArrayList)this.f.get(paramDynamicFaceDrawable.s);
      if ((localArrayList != null) && (localArrayList.contains(???))) {
        return;
      }
    }
    if (DynamicFaceDrawable.f) {
      synchronized (this.j)
      {
        this.j.add(paramDynamicFaceDrawable.x);
        return;
      }
    }
    a(paramDynamicFaceDrawable, true, true);
  }
  
  public void b(DynamicFaceDrawable paramDynamicFaceDrawable, boolean paramBoolean)
  {
    if (paramDynamicFaceDrawable == null) {
      return;
    }
    if (paramBoolean)
    {
      String str = a(paramDynamicFaceDrawable, false);
      ArrayList localArrayList2 = (ArrayList)this.f.get(paramDynamicFaceDrawable.s);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.f.put(paramDynamicFaceDrawable.s, localArrayList1);
      }
      localArrayList1.add(str);
      localArrayList1.add(a(paramDynamicFaceDrawable, true));
      if ((paramDynamicFaceDrawable.s == 1) || (paramDynamicFaceDrawable.s == 0)) {
        ThreadManager.post(new DynamicAvatarManager.6(this, paramDynamicFaceDrawable, System.currentTimeMillis()), 5, null, true);
      }
      if (paramDynamicFaceDrawable.v.get() != null) {
        ((DynamicAvatarView)paramDynamicFaceDrawable.v.get()).d = "";
      }
    }
    ThreadManager.postImmediately(new DynamicAvatarManager.7(this, paramDynamicFaceDrawable), null, true);
  }
  
  public void b(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions2;
    if (!TextUtils.isEmpty(paramString.basicSmallUrl))
    {
      Object localObject1 = DynamicAvatarDownloadManager.d(paramString.basicSmallUrl);
      try
      {
        localObject1 = ((File)localObject1).toURI().toURL().toString();
        localURLDrawableOptions2 = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions2.mRequestWidth = 100;
        localURLDrawableOptions2.mRequestHeight = 100;
        URLDrawable.removeMemoryCacheByUrl((String)localObject1, localURLDrawableOptions2);
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.dynamicAvatar", 2, QLog.getStackTraceString(localException1));
        }
      }
    }
    if (!TextUtils.isEmpty(paramString.basicMiddleUrl))
    {
      Object localObject2 = DynamicAvatarDownloadManager.d(paramString.basicMiddleUrl);
      try
      {
        localObject2 = ((File)localObject2).toURI().toURL().toString();
        localURLDrawableOptions2 = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions2.mRequestWidth = 200;
        localURLDrawableOptions2.mRequestHeight = 200;
        URLDrawable.removeMemoryCacheByUrl((String)localObject2, localURLDrawableOptions2);
      }
      catch (Exception localException2)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.dynamicAvatar", 2, QLog.getStackTraceString(localException2));
        }
      }
    }
    if (!TextUtils.isEmpty(paramString.basicBigUrl))
    {
      paramString = DynamicAvatarDownloadManager.d(paramString.basicBigUrl);
      try
      {
        paramString = paramString.toURI().toURL().toString();
        URLDrawable.URLDrawableOptions localURLDrawableOptions1 = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions1.mRequestWidth = 640;
        localURLDrawableOptions1.mRequestHeight = 640;
        URLDrawable.removeMemoryCacheByUrl(paramString, localURLDrawableOptions1);
        return;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.dynamicAvatar", 2, QLog.getStackTraceString(paramString));
        }
      }
    }
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    DynamicAvatarDownloadManager localDynamicAvatarDownloadManager = this.d;
    if (localDynamicAvatarDownloadManager != null) {
      localDynamicAvatarDownloadManager.a(paramString);
    }
  }
  
  public boolean c()
  {
    if (NetConnInfoCenter.getServerTimeMillis() - this.l < 60000L)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isSupportDynamicAvatar: use old value, isSupportDynamicAvatar is ");
        ((StringBuilder)localObject).append(this.k);
        QLog.d("Q.dynamicAvatar", 2, ((StringBuilder)localObject).toString());
      }
      return this.k;
    }
    this.l = NetConnInfoCenter.getServerTimeMillis();
    Object localObject = DynamicAvatarConfProcessor.a.a().a();
    if (localObject == null)
    {
      QLog.e("Q.dynamicAvatar", 2, "isSupportDynamicAvatar config is null");
      this.k = true;
      return this.k;
    }
    this.k = ((DynamicAvatarConfBean.DynamicAvatarConfig)localObject).a();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isSupportDynamicAvatar: use new value, isSupportDynamicAvatar is ");
      ((StringBuilder)localObject).append(this.k);
      QLog.d("Q.dynamicAvatar", 2, ((StringBuilder)localObject).toString());
    }
    return this.k;
  }
  
  @TargetApi(11)
  public boolean c(DynamicFaceDrawable paramDynamicFaceDrawable)
  {
    if (!paramDynamicFaceDrawable.q)
    {
      localObject1 = a(paramDynamicFaceDrawable, false);
      localObject2 = (ArrayList)this.f.get(paramDynamicFaceDrawable.s);
      if ((localObject2 != null) && (((ArrayList)localObject2).contains(localObject1))) {
        return false;
      }
    }
    File localFile = DynamicAvatarDownloadManager.d(paramDynamicFaceDrawable.n);
    int i2 = paramDynamicFaceDrawable.m;
    int i1 = 200;
    if (i2 == 640) {
      i1 = 640;
    } else if (paramDynamicFaceDrawable.m != 200) {
      i1 = 100;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = i1;
    localURLDrawableOptions.mRequestHeight = i1;
    Object localObject2 = paramDynamicFaceDrawable.c;
    Object localObject1 = localObject2;
    if ((localObject2 instanceof FaceDrawable)) {
      localObject1 = ((FaceDrawable)localObject2).getCurrDrawable();
    }
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
    localObject1 = new VideoDrawable.VideoDrawableParams();
    ((VideoDrawable.VideoDrawableParams)localObject1).mPlayVideoFrame = true;
    ((VideoDrawable.VideoDrawableParams)localObject1).mRequestedFPS = this.p.l;
    ((VideoDrawable.VideoDrawableParams)localObject1).mVideoRoundCorner = i1;
    ((VideoDrawable.VideoDrawableParams)localObject1).mEnableAntiAlias = true;
    ((VideoDrawable.VideoDrawableParams)localObject1).mEnableFilter = true;
    localURLDrawableOptions.mExtraInfo = localObject1;
    boolean bool = paramDynamicFaceDrawable.a(URLDrawable.getDrawable(localFile, localURLDrawableOptions));
    if ((bool) && (paramDynamicFaceDrawable.s >= 0) && (DynamicFaceDrawable.a.length > paramDynamicFaceDrawable.s))
    {
      localObject1 = this.q;
      if (localObject1 != null) {
        DynamicUtils.a((AppInterface)localObject1, "0X800711C", DynamicFaceDrawable.a[paramDynamicFaceDrawable.s]);
      }
    }
    return bool;
  }
  
  public void d()
  {
    this.f.clear();
    synchronized (this.g)
    {
      this.h.clear();
      this.g.clear();
      return;
    }
  }
  
  public DynamicAvatarDownloadManager e()
  {
    return this.d;
  }
  
  public void f()
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("resumeAll pausedSize: ");
      ((StringBuilder)???).append(this.j.size());
      ((StringBuilder)???).append(" loadinging size: ");
      ((StringBuilder)???).append(this.i.size());
      ((StringBuilder)???).append(" playing size");
      ((StringBuilder)???).append(this.g.size());
      ((StringBuilder)???).append(" waiting play size: ");
      ((StringBuilder)???).append(this.h.size());
      QLog.w("Q.dynamicAvatar", 2, ((StringBuilder)???).toString());
    }
    if (DynamicFaceDrawable.f) {
      return;
    }
    int i1;
    int i2;
    synchronized (this.j)
    {
      i1 = this.j.size() - 1;
      Object localObject2;
      if (i1 >= 0)
      {
        localObject2 = (WeakReference)this.j.get(i1);
        if ((localObject2 != null) && (((WeakReference)localObject2).get() != null)) {
          ((DynamicFaceDrawable)((WeakReference)localObject2).get()).c();
        } else {
          this.j.remove(i1);
        }
      }
      else
      {
        int i4 = Math.min(a, this.j.size());
        synchronized (this.i)
        {
          int i3 = this.i.size();
          if (i4 >= a) {
            i1 = i3;
          } else {
            i1 = i3 - (a - i4);
          }
          localObject2 = new ArrayList();
          i2 = i3 - 1;
          if (i2 >= i3 - i1)
          {
            WeakReference localWeakReference = (WeakReference)this.i.remove(i2);
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((ArrayList)localObject2).add(((DynamicFaceDrawable)localWeakReference.get()).n);
            }
          }
          else
          {
            if (this.d != null) {
              this.d.a((ArrayList)localObject2);
            }
            synchronized (this.j)
            {
              i1 = Math.min(this.j.size() - 1, i4 - 1);
              if (i1 >= 0)
              {
                localObject2 = (WeakReference)this.j.get(i1);
                if ((localObject2 != null) && (((WeakReference)localObject2).get() != null)) {
                  a((DynamicFaceDrawable)((WeakReference)localObject2).get(), false, false);
                } else {
                  this.j.remove(i1);
                }
              }
              else
              {
                return;
              }
            }
          }
        }
      }
    }
  }
  
  public void g() {}
  
  public void onDestroy()
  {
    ThreadManager.getSubThreadHandler().removeCallbacks(this.s);
    ((IDPCApi)QRoute.api(IDPCApi.class)).removeObserver(this.n);
    this.q.removeObserver(this.t);
    this.d.b();
    this.d = null;
    this.t = null;
    this.q = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager
 * JD-Core Version:    0.7.0.1
 */