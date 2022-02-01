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
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.util.IPCFaceHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ImageUtil;
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
  public long a;
  private Resources jdField_a_of_type_AndroidContentResResources;
  public SparseArray<ArrayList<String>> a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private DynamicAvatarConfig jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig;
  private DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager$IDynamicAvatarDownloadCallback = new DynamicAvatarManager.5(this);
  public DynamicAvatarDownloadManager a;
  private DynamicAvatarInfoObserver jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarInfoObserver = new DynamicAvatarManager.2(this);
  DPCObserver jdField_a_of_type_ComTencentMobileqqDpcDPCObserver = new DynamicAvatarManager.MyDPCObserver(this);
  public Runnable a;
  public String a;
  public ArrayList<WeakReference<DynamicFaceDrawable>> a;
  public ConcurrentHashMap<String, DynamicAvatar> a;
  public volatile boolean a;
  public volatile int b;
  private Runnable b;
  public String b;
  public ArrayList<WeakReference<DynamicFaceDrawable>> b;
  public ArrayList<WeakReference<DynamicFaceDrawable>> c;
  public ArrayList<WeakReference<DynamicFaceDrawable>> d;
  
  public DynamicAvatarManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_JavaLangRunnable = new DynamicAvatarManager.1(this);
    this.jdField_a_of_type_JavaLangRunnable = new DynamicAvatarManager.8(this);
    int i = 2;
    if (paramAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "new DynamicAvatarManager param app is null.");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarInfoObserver, true);
    this.d = new ArrayList();
    this.c = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager = new DynamicAvatarDownloadManager(paramAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager.a(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager$IDynamicAvatarDownloadCallback);
    this.jdField_a_of_type_AndroidContentResResources = BaseApplicationImpl.getContext().getResources();
    a();
    jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig.jdField_a_of_type_Int;
    ((IDPCApi)QRoute.api(IDPCApi.class)).addObserver(this.jdField_a_of_type_ComTencentMobileqqDpcDPCObserver);
    if (!ShortVideoUtils.isVideoSoLibLoaded()) {
      i = 0;
    }
    this.jdField_b_of_type_Int = i;
  }
  
  private Setting a(int paramInt, String paramString)
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
      localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      if ((localObject instanceof INearbyAppInterface)) {}
      for (paramString = ((IQQAvatarManagerService)((AppInterface)localObject).getRuntimeService(IQQAvatarManagerService.class, "nearby")).getFaceSetting(paramString);; paramString = ((IPCFaceHelper)NearbyManagerHelper.a((QQAppInterface)localObject).a(true)).a(paramString))
      {
        return paramString;
        if (!(localObject instanceof QQAppInterface)) {
          break;
        }
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
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
    localStringBuilder.append(paramDynamicFaceDrawable.jdField_b_of_type_Int);
    localStringBuilder.append("_");
    localStringBuilder.append(paramDynamicFaceDrawable.jdField_c_of_type_Int);
    localStringBuilder.append("_");
    localStringBuilder.append(paramDynamicFaceDrawable.jdField_a_of_type_JavaLangString);
    if ((paramBoolean) || ((paramDynamicFaceDrawable.jdField_e_of_type_Boolean) && (!TextUtils.isEmpty(paramDynamicFaceDrawable.jdField_b_of_type_JavaLangString))))
    {
      localStringBuilder.append("_");
      localStringBuilder.append(paramDynamicFaceDrawable.jdField_b_of_type_JavaLangString);
    }
    return localStringBuilder.toString();
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    int i;
    int j;
    int k;
    label245:
    synchronized (this.c)
    {
      i = this.c.size() - 1;
      j = 0;
      if (i >= 0)
      {
        WeakReference localWeakReference = (WeakReference)this.c.get(i);
        if (localWeakReference == null)
        {
          this.c.remove(i);
          k = j;
          break label245;
        }
        DynamicFaceDrawable localDynamicFaceDrawable = (DynamicFaceDrawable)localWeakReference.get();
        if (localDynamicFaceDrawable == null)
        {
          this.c.remove(i);
          k = j;
          break label245;
        }
        k = j;
        if (!paramString1.equals(localDynamicFaceDrawable.jdField_d_of_type_JavaLangString)) {
          break label245;
        }
        if (TextUtils.isEmpty(paramString2))
        {
          localDynamicFaceDrawable.jdField_a_of_type_ComTencentImageURLDrawable = null;
          localDynamicFaceDrawable.a();
          this.c.remove(i);
          k = j;
          break label245;
        }
        localDynamicFaceDrawable.jdField_b_of_type_JavaLangString = paramString2;
        localDynamicFaceDrawable.jdField_c_of_type_JavaLangString = paramString3;
        if ((localDynamicFaceDrawable.jdField_a_of_type_MqqUtilWeakReference != null) && (localDynamicFaceDrawable.jdField_a_of_type_MqqUtilWeakReference.get() != null) && (paramString2.equals(((DynamicAvatarView)localDynamicFaceDrawable.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_JavaLangString)))
        {
          this.c.remove(localWeakReference);
          k = j;
          break label245;
        }
      }
      else
      {
        if (j != 0) {
          b(paramString2);
        }
        return;
      }
    }
  }
  
  private boolean a(DynamicAvatar paramDynamicAvatar, Setting paramSetting, int paramInt)
  {
    if ((paramDynamicAvatar != null) && (paramSetting != null))
    {
      long l = System.currentTimeMillis() / 1000L;
      if ((l - paramDynamicAvatar.getTimeStamp >= 0L) && (l - paramDynamicAvatar.getTimeStamp < 86400L))
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
    int i = 17;
    if (paramInt2 == 200) {
      paramInt2 = 17;
    } else {
      paramInt2 = 18;
    }
    if (paramInt1 == 32) {
      i = 18;
    }
    return a(i, paramInt2, paramString, paramInt3);
  }
  
  private void e()
  {
    if (this.jdField_b_of_type_Int == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "loadVideoSo called");
      }
      ThreadManager.getSubThreadHandler().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 10000L);
      this.jdField_b_of_type_Int = 1;
    }
  }
  
  public DynamicAvatarConfig a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig == null) {
      a();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getConfig DynamicAvatarConfig|");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig);
      QLog.d("Q.dynamicAvatar", 2, localStringBuilder.toString());
    }
    return this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig;
  }
  
  public DynamicAvatarDownloadManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager;
  }
  
  public DynamicAvatar a(int paramInt, String paramString)
  {
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    boolean bool1 = localAppInterface instanceof QQAppInterface;
    boolean bool2 = true;
    Object localObject1 = null;
    Object localObject2 = null;
    if (bool1)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
      {
        localObject1 = (DynamicAvatar)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
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
        localObject2 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
        if (localObject1 != null) {}
        try
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject1);
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
    if (((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))) {
      paramString = (DynamicAvatar)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
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
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig = new DynamicAvatarConfig();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DynamicAvatarConfig|init config:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig);
      localStringBuilder.append(",costTime:");
      localStringBuilder.append(System.currentTimeMillis() - l);
      QLog.d("Q.dynamicAvatar", 2, localStringBuilder.toString());
    }
  }
  
  public void a(DynamicFaceDrawable paramDynamicFaceDrawable)
  {
    if (paramDynamicFaceDrawable == null) {
      return;
    }
    synchronized (this.d)
    {
      this.d.remove(paramDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference);
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference);
        this.jdField_b_of_type_JavaUtilArrayList.remove(paramDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference);
        synchronized (this.c)
        {
          this.c.remove(paramDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference);
          return;
        }
      }
    }
  }
  
  public void a(DynamicFaceDrawable paramDynamicFaceDrawable, boolean paramBoolean)
  {
    if (paramDynamicFaceDrawable == null) {
      return;
    }
    if (paramBoolean)
    {
      String str = a(paramDynamicFaceDrawable, false);
      ArrayList localArrayList2 = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramDynamicFaceDrawable.jdField_e_of_type_Int);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramDynamicFaceDrawable.jdField_e_of_type_Int, localArrayList1);
      }
      localArrayList1.add(str);
      localArrayList1.add(a(paramDynamicFaceDrawable, true));
      if ((paramDynamicFaceDrawable.jdField_e_of_type_Int == 1) || (paramDynamicFaceDrawable.jdField_e_of_type_Int == 0)) {
        ThreadManager.post(new DynamicAvatarManager.6(this, paramDynamicFaceDrawable, System.currentTimeMillis()), 5, null, true);
      }
      if (paramDynamicFaceDrawable.jdField_a_of_type_MqqUtilWeakReference.get() != null) {
        ((DynamicAvatarView)paramDynamicFaceDrawable.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_JavaLangString = "";
      }
    }
    ThreadManager.postImmediately(new DynamicAvatarManager.7(this, paramDynamicFaceDrawable), null, true);
  }
  
  public void a(DynamicFaceDrawable paramDynamicFaceDrawable, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.c.size() >= jdField_a_of_type_Int) && (!paramBoolean1)) {
      synchronized (this.d)
      {
        this.d.add(paramDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference);
        return;
      }
    }
    ??? = paramDynamicFaceDrawable.jdField_d_of_type_JavaLangString;
    synchronized (this.c)
    {
      this.c.add(paramDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference);
      if (!paramBoolean1) {
        synchronized (this.d)
        {
          this.d.remove(paramDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference);
        }
      }
      ??? = new DynamicAvatarManager.3(this, paramDynamicFaceDrawable, (String)???);
      long l1;
      if (!paramBoolean2) {
        l1 = 0L;
      } else if (paramDynamicFaceDrawable.jdField_e_of_type_Int == 0) {
        l1 = 1500L;
      } else {
        l1 = 400L;
      }
      long l2 = l1;
      if (DeviceInfoUtil.b() <= 2) {
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
    Object localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if ((localObject1 instanceof QQAppInterface))
    {
      EntityManager localEntityManager = ((AppInterface)localObject1).getEntityManagerFactory().createEntityManager();
      localEntityManager.getTransaction().begin();
      localObject1 = null;
      try
      {
        Cursor localCursor = localEntityManager.query(false, DynamicAvatar.class.getSimpleName(), null, null, null, null, null, null, null);
        int i;
        Object localObject2;
        if (localCursor != null)
        {
          localObject1 = localCursor;
          i = localCursor.getCount();
          localObject1 = localCursor;
          localCursor.moveToFirst();
          if (i >= 1000)
          {
            while (i > 333)
            {
              localObject1 = localCursor;
              localCursor.moveToNext();
              i -= 1;
            }
            localObject1 = localCursor;
            i = localCursor.getInt(localCursor.getColumnIndex("_id"));
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
            ((StringBuilder)localObject2).append(i);
            localObject1 = localCursor;
            ((StringBuilder)localObject2).append(";");
            localObject1 = localCursor;
            localEntityManager.execSQL(((StringBuilder)localObject2).toString());
          }
        }
        if (paramDynamicAvatarInfo != null)
        {
          localObject1 = localCursor;
          if (paramDynamicAvatarInfo.jdField_a_of_type_JavaUtilArrayList != null)
          {
            localObject1 = localCursor;
            if (!paramDynamicAvatarInfo.jdField_a_of_type_JavaUtilArrayList.isEmpty())
            {
              localObject1 = localCursor;
              paramDynamicAvatarInfo = paramDynamicAvatarInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
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
                  long l = ((DynamicAvatar)localObject2).uin;
                  i = 0;
                  localObject1 = localCursor;
                  Object localObject3 = (DynamicAvatar)localEntityManager.find(DynamicAvatar.class, "uin=?", new String[] { String.valueOf(l) });
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
                  localObject3 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
                  localObject1 = localCursor;
                  try
                  {
                    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 200)
                    {
                      localObject1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
                      int j;
                      do
                      {
                        if (!((Iterator)localObject1).hasNext()) {
                          break;
                        }
                        ((Iterator)localObject1).remove();
                        j = i + 1;
                        i = j;
                      } while (j < 100);
                    }
                    if (((DynamicAvatar)localObject2).uin > 0L) {
                      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(String.valueOf(((DynamicAvatar)localObject2).uin), localObject2);
                    }
                    if (((DynamicAvatar)localObject2).tinyId > 0L) {
                      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(String.valueOf(((DynamicAvatar)localObject2).tinyId), localObject2);
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
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
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
  
  public void a(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions2;
    if (!TextUtils.isEmpty(paramString.basicSmallUrl))
    {
      Object localObject1 = DynamicAvatarDownloadManager.a(paramString.basicSmallUrl);
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
      Object localObject2 = DynamicAvatarDownloadManager.a(paramString.basicMiddleUrl);
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
      paramString = DynamicAvatarDownloadManager.a(paramString.basicBigUrl);
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
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ??? = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig;
      if ((??? != null) && (((DynamicAvatarConfig)???).jdField_a_of_type_Boolean)) {
        synchronized (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig)
        {
          this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig.a();
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("---onDpcPullFinished---|mDynamicAvatarConfig:");
            localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig);
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
      Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
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
  
  public boolean a()
  {
    if (NetConnInfoCenter.getServerTimeMillis() - this.jdField_a_of_type_Long < 60000L)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isSupportDynamicAvatar: use old value, isSupportDynamicAvatar is ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
        QLog.d("Q.dynamicAvatar", 2, ((StringBuilder)localObject).toString());
      }
      return this.jdField_a_of_type_Boolean;
    }
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    Object localObject = DynamicAvatarConfProcessor.a.a().a();
    if (localObject == null)
    {
      QLog.e("Q.dynamicAvatar", 2, "isSupportDynamicAvatar config is null");
      this.jdField_a_of_type_Boolean = true;
      return this.jdField_a_of_type_Boolean;
    }
    this.jdField_a_of_type_Boolean = ((DynamicAvatarConfBean.DynamicAvatarConfig)localObject).a();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isSupportDynamicAvatar: use new value, isSupportDynamicAvatar is ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      QLog.d("Q.dynamicAvatar", 2, ((StringBuilder)localObject).toString());
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig;
    if (localObject != null) {
      switch (paramInt)
      {
      default: 
        break;
      case 7: 
        bool = ((DynamicAvatarConfig)localObject).f;
        break;
      case 6: 
      case 8: 
        bool = true;
        break;
      case 5: 
        bool = ((DynamicAvatarConfig)localObject).h;
        break;
      case 4: 
        bool = ((DynamicAvatarConfig)localObject).g;
        break;
      case 3: 
        bool = ((DynamicAvatarConfig)localObject).f;
        break;
      case 2: 
        bool = ((DynamicAvatarConfig)localObject).jdField_e_of_type_Boolean;
        break;
      case 1: 
        bool = ((DynamicAvatarConfig)localObject).d;
        break;
      case 0: 
        bool = ((DynamicAvatarConfig)localObject).jdField_c_of_type_Boolean;
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
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig);
      QLog.d("Q.dynamicAvatar", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  @TargetApi(11)
  public boolean a(DynamicFaceDrawable paramDynamicFaceDrawable)
  {
    if (!paramDynamicFaceDrawable.f)
    {
      localObject1 = a(paramDynamicFaceDrawable, false);
      localObject2 = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramDynamicFaceDrawable.jdField_e_of_type_Int);
      if ((localObject2 != null) && (((ArrayList)localObject2).contains(localObject1))) {
        return false;
      }
    }
    File localFile = DynamicAvatarDownloadManager.a(paramDynamicFaceDrawable.jdField_b_of_type_JavaLangString);
    int j = paramDynamicFaceDrawable.jdField_d_of_type_Int;
    int i = 200;
    if (j == 640) {
      i = 640;
    } else if (paramDynamicFaceDrawable.jdField_d_of_type_Int != 200) {
      i = 100;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = i;
    Object localObject2 = paramDynamicFaceDrawable.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    Object localObject1 = localObject2;
    if ((localObject2 instanceof FaceDrawable)) {
      localObject1 = ((FaceDrawable)localObject2).getCurrDrawable();
    }
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
    localObject1 = new VideoDrawable.VideoDrawableParams();
    ((VideoDrawable.VideoDrawableParams)localObject1).mPlayVideoFrame = true;
    ((VideoDrawable.VideoDrawableParams)localObject1).mRequestedFPS = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig.jdField_c_of_type_Int;
    j = i;
    if (SimpleUIUtil.a()) {
      j = ImageUtil.a(i);
    }
    ((VideoDrawable.VideoDrawableParams)localObject1).mVideoRoundCorner = j;
    ((VideoDrawable.VideoDrawableParams)localObject1).mEnableAntiAlias = true;
    ((VideoDrawable.VideoDrawableParams)localObject1).mEnableFilter = true;
    localURLDrawableOptions.mExtraInfo = localObject1;
    boolean bool = paramDynamicFaceDrawable.a(URLDrawable.getDrawable(localFile, localURLDrawableOptions));
    if ((bool) && (paramDynamicFaceDrawable.jdField_e_of_type_Int >= 0) && (DynamicFaceDrawable.jdField_a_of_type_ArrayOfInt.length > paramDynamicFaceDrawable.jdField_e_of_type_Int))
    {
      localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      if (localObject1 != null) {
        DynamicUtils.a((AppInterface)localObject1, "0X800711C", DynamicFaceDrawable.jdField_a_of_type_ArrayOfInt[paramDynamicFaceDrawable.jdField_e_of_type_Int]);
      }
    }
    return bool;
  }
  
  public boolean a(FaceInfo paramFaceInfo, Setting paramSetting, int paramInt)
  {
    if (paramFaceInfo == null) {
      return false;
    }
    paramFaceInfo = a(paramFaceInfo.jdField_b_of_type_Int, paramFaceInfo.jdField_a_of_type_JavaLangString);
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
  
  public DynamicAvatar b(int paramInt, String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
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
  
  public void b()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
  }
  
  public void b(DynamicFaceDrawable paramDynamicFaceDrawable)
  {
    if (paramDynamicFaceDrawable == null) {
      return;
    }
    if (this.jdField_b_of_type_Int != 2)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.dynamicAvatar", 2, "getDynamicAvatar isVideoSoLibLoaded false.");
      }
      e();
      return;
    }
    if (!paramDynamicFaceDrawable.f)
    {
      ??? = a(paramDynamicFaceDrawable, false);
      ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramDynamicFaceDrawable.jdField_e_of_type_Int);
      if ((localArrayList != null) && (localArrayList.contains(???))) {
        return;
      }
    }
    if (DynamicFaceDrawable.jdField_b_of_type_Boolean) {
      synchronized (this.d)
      {
        this.d.add(paramDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference);
        return;
      }
    }
    a(paramDynamicFaceDrawable, true, true);
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    DynamicAvatarDownloadManager localDynamicAvatarDownloadManager = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager;
    if (localDynamicAvatarDownloadManager != null) {
      localDynamicAvatarDownloadManager.a(paramString);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("resumeAll pausedSize: ");
      ((StringBuilder)???).append(this.d.size());
      ((StringBuilder)???).append(" loadinging size: ");
      ((StringBuilder)???).append(this.c.size());
      ((StringBuilder)???).append(" playing size");
      ((StringBuilder)???).append(this.jdField_a_of_type_JavaUtilArrayList.size());
      ((StringBuilder)???).append(" waiting play size: ");
      ((StringBuilder)???).append(this.jdField_b_of_type_JavaUtilArrayList.size());
      QLog.w("Q.dynamicAvatar", 2, ((StringBuilder)???).toString());
    }
    if (DynamicFaceDrawable.jdField_b_of_type_Boolean) {
      return;
    }
    int i;
    int j;
    synchronized (this.d)
    {
      i = this.d.size() - 1;
      Object localObject2;
      if (i >= 0)
      {
        localObject2 = (WeakReference)this.d.get(i);
        if ((localObject2 != null) && (((WeakReference)localObject2).get() != null)) {
          ((DynamicFaceDrawable)((WeakReference)localObject2).get()).a();
        } else {
          this.d.remove(i);
        }
      }
      else
      {
        int m = Math.min(jdField_a_of_type_Int, this.d.size());
        synchronized (this.c)
        {
          int k = this.c.size();
          if (m >= jdField_a_of_type_Int) {
            i = k;
          } else {
            i = k - (jdField_a_of_type_Int - m);
          }
          localObject2 = new ArrayList();
          j = k - 1;
          if (j >= k - i)
          {
            WeakReference localWeakReference = (WeakReference)this.c.remove(j);
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((ArrayList)localObject2).add(((DynamicFaceDrawable)localWeakReference.get()).jdField_b_of_type_JavaLangString);
            }
          }
          else
          {
            if (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager != null) {
              this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager.a((ArrayList)localObject2);
            }
            synchronized (this.d)
            {
              i = Math.min(this.d.size() - 1, m - 1);
              if (i >= 0)
              {
                localObject2 = (WeakReference)this.d.get(i);
                if ((localObject2 != null) && (((WeakReference)localObject2).get() != null)) {
                  a((DynamicFaceDrawable)((WeakReference)localObject2).get(), false, false);
                } else {
                  this.d.remove(i);
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
  
  public void d() {}
  
  public void onDestroy()
  {
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    ((IDPCApi)QRoute.api(IDPCApi.class)).removeObserver(this.jdField_a_of_type_ComTencentMobileqqDpcDPCObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarInfoObserver);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager.b();
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager = null;
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarInfoObserver = null;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager
 * JD-Core Version:    0.7.0.1
 */