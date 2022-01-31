package com.tencent.mobileqq.avatar.dynamicavatar;

import abjd;
import abje;
import abjf;
import abjg;
import abjh;
import abji;
import abjj;
import abjk;
import abjm;
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
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DPCObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.util.DynamicFaceDrawable;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.FaceManager;
import com.tencent.mobileqq.util.IPCFaceHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.RspBody;

public class DynamicAvatarManager
  implements Manager
{
  public static int a;
  private Resources jdField_a_of_type_AndroidContentResResources;
  public SparseArray a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  DeviceProfileManager.DPCObserver jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$DPCObserver = new abjm(this);
  private DynamicAvatarConfig jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig;
  private DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager$IDynamicAvatarDownloadCallback = new abjh(this);
  public DynamicAvatarDownloadManager a;
  private DynamicAvatarInfoObserver jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarInfoObserver = new abje(this);
  public Runnable a;
  public String a;
  public ArrayList a;
  public ConcurrentHashMap a;
  public Executor a;
  public volatile boolean a;
  public String b;
  public ArrayList b;
  public ArrayList c;
  public ArrayList d;
  
  static
  {
    jdField_a_of_type_Int = 8;
  }
  
  public DynamicAvatarManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_JavaLangRunnable = new abjk(this);
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
    this.b = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager = new DynamicAvatarDownloadManager(paramAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager.a(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager$IDynamicAvatarDownloadCallback);
    paramAppInterface = new ThreadPoolParams();
    paramAppInterface.jdField_a_of_type_JavaLangString = "dynamic_avatar";
    paramAppInterface.jdField_b_of_type_Int = 2;
    paramAppInterface.jdField_c_of_type_Int = 8;
    this.jdField_a_of_type_JavaUtilConcurrentExecutor = ThreadManager.newFreeThreadPool(paramAppInterface);
    this.jdField_a_of_type_AndroidContentResResources = BaseApplicationImpl.getContext().getResources();
    a();
    jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig.jdField_a_of_type_Int;
    DeviceProfileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$DPCObserver);
  }
  
  private Setting a(int paramInt, String paramString)
  {
    Object localObject2 = null;
    if (paramInt == 18)
    {
      paramString = "stranger_" + Integer.toString(paramInt) + "_" + paramString;
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof NearbyAppInterface)) {
        localObject1 = ((FaceManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(215)).a(paramString);
      }
    }
    do
    {
      do
      {
        do
        {
          return localObject1;
          localObject1 = localObject2;
        } while (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface));
        return ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).a().a(true).a(paramString);
        localObject1 = localObject2;
      } while ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof NearbyAppInterface));
      localObject1 = localObject2;
    } while (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface));
    Object localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager();
    paramString = (Setting)((EntityManager)localObject1).a(Setting.class, paramString);
    ((EntityManager)localObject1).a();
    return paramString;
  }
  
  public static String a(int paramInt1, int paramInt2, DynamicAvatar paramDynamicAvatar)
  {
    Object localObject;
    if (paramDynamicAvatar == null) {
      localObject = null;
    }
    do
    {
      String str;
      do
      {
        do
        {
          return localObject;
          str = "";
          if (paramInt1 != 17) {
            break;
          }
          if (paramInt2 == 100) {
            return paramDynamicAvatar.basicSmallUrl;
          }
          if (paramInt2 == 200) {
            return paramDynamicAvatar.basicMiddleUrl;
          }
          localObject = str;
        } while (paramInt2 != 640);
        return paramDynamicAvatar.basicBigUrl;
        localObject = str;
      } while (paramInt1 != 18);
      if (paramInt2 == 100) {
        return paramDynamicAvatar.nearbySmallUrl;
      }
      if (paramInt2 == 200) {
        return paramDynamicAvatar.nearbyMiddleUrl;
      }
      localObject = str;
    } while (paramInt2 != 640);
    return paramDynamicAvatar.nearbyBigUrl;
  }
  
  public static String a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1).append("_").append(paramInt2).append("_").append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String a(DynamicFaceDrawable paramDynamicFaceDrawable, boolean paramBoolean)
  {
    if (paramDynamicFaceDrawable == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramDynamicFaceDrawable.jdField_b_of_type_Int).append("_").append(paramDynamicFaceDrawable.jdField_c_of_type_Int).append("_").append(paramDynamicFaceDrawable.jdField_a_of_type_JavaLangString);
    if ((paramBoolean) || ((paramDynamicFaceDrawable.jdField_e_of_type_Boolean) && (!TextUtils.isEmpty(paramDynamicFaceDrawable.jdField_b_of_type_JavaLangString)))) {
      localStringBuilder.append("_").append(paramDynamicFaceDrawable.jdField_b_of_type_JavaLangString);
    }
    return localStringBuilder.toString();
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    int i = 0;
    int j;
    synchronized (this.c)
    {
      j = this.c.size() - 1;
      if (j >= 0)
      {
        WeakReference localWeakReference = (WeakReference)this.c.get(j);
        if (localWeakReference == null)
        {
          this.c.remove(j);
        }
        else
        {
          DynamicFaceDrawable localDynamicFaceDrawable = (DynamicFaceDrawable)localWeakReference.get();
          if (localDynamicFaceDrawable == null) {
            this.c.remove(j);
          } else if (paramString1.equals(localDynamicFaceDrawable.jdField_d_of_type_JavaLangString)) {
            if (TextUtils.isEmpty(paramString2))
            {
              localDynamicFaceDrawable.jdField_a_of_type_ComTencentImageURLDrawable = null;
              localDynamicFaceDrawable.a();
              this.c.remove(j);
            }
            else
            {
              localDynamicFaceDrawable.jdField_b_of_type_JavaLangString = paramString2;
              localDynamicFaceDrawable.jdField_c_of_type_JavaLangString = paramString3;
              if ((localDynamicFaceDrawable.jdField_a_of_type_MqqUtilWeakReference == null) || (localDynamicFaceDrawable.jdField_a_of_type_MqqUtilWeakReference.get() == null) || (!paramString2.equals(((DynamicAvatarView)localDynamicFaceDrawable.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_JavaLangString))) {
                break label225;
              }
              this.c.remove(localWeakReference);
            }
          }
        }
      }
      else
      {
        if (i != 0) {
          a(paramString2);
        }
        return;
      }
    }
    for (;;)
    {
      j -= 1;
      break;
      label225:
      i = 1;
    }
  }
  
  public static String b(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    int i = 18;
    if (paramInt2 == 200)
    {
      paramInt2 = 17;
      if (paramInt1 != 32) {
        break label37;
      }
    }
    label37:
    for (paramInt1 = i;; paramInt1 = 17)
    {
      return a(paramInt1, paramInt2, paramString, paramInt3);
      paramInt2 = 18;
      break;
    }
  }
  
  private boolean b(DynamicAvatar paramDynamicAvatar, Setting paramSetting, int paramInt)
  {
    if ((paramDynamicAvatar == null) || (paramSetting == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "isNeed2GetDynamicAvatarInfo dynamicAvatrInfo or setting info is null.");
      }
    }
    do
    {
      do
      {
        do
        {
          return true;
          long l = System.currentTimeMillis() / 1000L;
          if ((l - paramDynamicAvatar.getTimeStamp >= 0L) && (l - paramDynamicAvatar.getTimeStamp < 86400L)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("Q.dynamicAvatar", 2, "isNeed2GetDynamicAvatarInfo beyond 24h, stamp: " + paramDynamicAvatar.getTimeStamp);
        return true;
        if (paramInt != 17) {
          break;
        }
        if ((paramDynamicAvatar.getTimeStamp + 5 >= paramSetting.headImgTimestamp) || ((paramDynamicAvatar.basicSetTimeStamp + 5) * 1000 >= paramSetting.updateTimestamp)) {
          break label331;
        }
      } while (!QLog.isColorLevel());
      QLog.i("Q.dynamicAvatar", 2, "isNeed2GetDynamicAvatarInfo: " + paramDynamicAvatar.getTimeStamp + " " + paramSetting.headImgTimestamp + " " + paramDynamicAvatar.basicSetTimeStamp + " " + paramSetting.updateTimestamp);
      return true;
      if ((paramInt != 18) || (paramDynamicAvatar.getTimeStamp + 5 >= paramSetting.headImgTimestamp) || ((paramDynamicAvatar.nearbySetTimeStamp + 5) * 1000 >= paramSetting.updateTimestamp)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.dynamicAvatar", 2, "isNeed2GetDynamicAvatarInfo: " + paramDynamicAvatar.getTimeStamp + " " + paramSetting.headImgTimestamp + " " + paramDynamicAvatar.basicSetTimeStamp + " " + paramSetting.updateTimestamp);
    return true;
    label331:
    return false;
  }
  
  public DynamicAvatarConfig a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig == null) {
      a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.dynamicAvatar", 2, "getConfig DynamicAvatarConfig|" + this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig);
    }
    return this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig;
  }
  
  public DynamicAvatarDownloadManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager;
  }
  
  public DynamicAvatar a(int paramInt, String paramString)
  {
    boolean bool2 = true;
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
      {
        localObject1 = (DynamicAvatar)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject2 = localObject1;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("getDynamicAvatarInfo cache is null: ");
          if (localObject1 != null) {
            break label184;
          }
          bool1 = true;
          QLog.i("Q.dynamicAvatar", 2, bool1);
          localObject2 = localObject1;
        }
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = b(paramInt, paramString);
        localObject2 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
        if (localObject1 == null) {}
      }
    }
    for (;;)
    {
      label184:
      try
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject1);
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder().append("db find dynamic avatarInfo is null: ");
          if (localObject1 != null) {
            break label225;
          }
          bool1 = bool2;
          QLog.i("Q.dynamicAvatar", 2, bool1);
        }
        return localObject1;
      }
      finally {}
      bool1 = false;
      break;
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof NearbyAppInterface))
      {
        localObject1 = ((NearbyAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).a().a(paramInt, paramString);
        continue;
        label225:
        bool1 = false;
      }
    }
  }
  
  public DynamicAvatar a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
        localObject1 = (DynamicAvatar)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      }
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("getDynamicAvatarInfoFromCache: ");
      if (localObject1 != null) {
        break label84;
      }
    }
    label84:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("Q.dynamicAvatar", 2, bool);
      return localObject1;
    }
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig = new DynamicAvatarConfig();
    if (QLog.isColorLevel()) {
      QLog.d("Q.dynamicAvatar", 2, "DynamicAvatarConfig|init config:" + this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig + ",costTime:" + (System.currentTimeMillis() - l));
    }
  }
  
  public void a(DynamicAvatarInfo paramDynamicAvatarInfo)
  {
    if (paramDynamicAvatarInfo == null) {}
    while (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
      return;
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager();
    localEntityManager.a().a();
    for (;;)
    {
      try
      {
        localCursor = localEntityManager.a(false, DynamicAvatar.class.getSimpleName(), null, null, null, null, null, null, null);
        if (localCursor != null) {}
        try
        {
          int i = localCursor.getCount();
          localCursor.moveToFirst();
          if (i >= 1000)
          {
            if (i > 333)
            {
              localCursor.moveToNext();
              i -= 1;
              continue;
            }
            i = localCursor.getInt(localCursor.getColumnIndex("_id"));
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("delete from ");
            ((StringBuilder)localObject1).append(DynamicAvatar.class.getSimpleName());
            ((StringBuilder)localObject1).append(" where ");
            ((StringBuilder)localObject1).append("_id");
            ((StringBuilder)localObject1).append(" < ");
            ((StringBuilder)localObject1).append(i);
            ((StringBuilder)localObject1).append(";");
            localEntityManager.b(((StringBuilder)localObject1).toString());
          }
          if ((paramDynamicAvatarInfo == null) || (paramDynamicAvatarInfo.jdField_a_of_type_JavaUtilArrayList == null) || (paramDynamicAvatarInfo.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
            continue;
          }
          paramDynamicAvatarInfo = paramDynamicAvatarInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (!paramDynamicAvatarInfo.hasNext()) {
            continue;
          }
          localObject1 = DynamicAvatar.convertFrom((DynamicAvatarInfo.OneUinHeadInfo)paramDynamicAvatarInfo.next());
          if (localObject1 == null) {
            continue;
          }
          ??? = (DynamicAvatar)localEntityManager.a(DynamicAvatar.class, "uin=?", new String[] { String.valueOf(((DynamicAvatar)localObject1).uin) });
          if (??? != null)
          {
            ((DynamicAvatar)localObject1).setStatus(((DynamicAvatar)???).getStatus());
            ((DynamicAvatar)localObject1).setId(((DynamicAvatar)???).getId());
          }
          if (((DynamicAvatar)localObject1).getStatus() != 1000) {
            continue;
          }
          localEntityManager.b((Entity)localObject1);
          synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
          {
            if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 200)
            {
              Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
              i = 0;
              if (localIterator.hasNext())
              {
                localIterator.remove();
                int j = i + 1;
                i = j;
                if (j < 100) {
                  continue;
                }
              }
            }
            if (((DynamicAvatar)localObject1).uin > 0L) {
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(String.valueOf(((DynamicAvatar)localObject1).uin), localObject1);
            }
            if (((DynamicAvatar)localObject1).tinyId > 0L) {
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(String.valueOf(((DynamicAvatar)localObject1).tinyId), localObject1);
            }
          }
          if (localCursor == null) {
            continue;
          }
        }
        finally {}
      }
      finally
      {
        Object localObject1;
        Cursor localCursor = null;
        continue;
      }
      localCursor.close();
      localEntityManager.a().b();
      localEntityManager.a();
      throw paramDynamicAvatarInfo;
      localEntityManager.a((Entity)localObject1);
    }
    localEntityManager.a().c();
    if (localCursor != null) {
      localCursor.close();
    }
    localEntityManager.a().b();
    localEntityManager.a();
  }
  
  public void a(DynamicAvatar paramDynamicAvatar)
  {
    EntityManager localEntityManager;
    DynamicAvatar localDynamicAvatar;
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
    {
      localEntityManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager();
      localDynamicAvatar = (DynamicAvatar)localEntityManager.a(DynamicAvatar.class, "uin=?", new String[] { String.valueOf(paramDynamicAvatar.uin) });
      if (localDynamicAvatar != null)
      {
        paramDynamicAvatar.setStatus(localDynamicAvatar.getStatus());
        paramDynamicAvatar.setId(localDynamicAvatar.getId());
      }
      if (paramDynamicAvatar.getStatus() != 1000) {
        break label120;
      }
      localEntityManager.b(paramDynamicAvatar);
    }
    for (;;)
    {
      localEntityManager.a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.dynamicAvatar", 2, "updateDynamicAvatarInfo: avatarInfo is : " + localDynamicAvatar);
      }
      return;
      label120:
      localEntityManager.a(paramDynamicAvatar);
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
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference);
      this.b.remove(paramDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference);
      synchronized (this.c)
      {
        this.c.remove(paramDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference);
        return;
      }
      paramDynamicFaceDrawable = finally;
      throw paramDynamicFaceDrawable;
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
        ThreadManager.post(new abji(this, paramDynamicFaceDrawable, System.currentTimeMillis()), 5, null, true);
      }
      if (paramDynamicFaceDrawable.jdField_a_of_type_MqqUtilWeakReference.get() != null) {
        ((DynamicAvatarView)paramDynamicFaceDrawable.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_JavaLangString = "";
      }
    }
    ThreadManager.postImmediately(new abjj(this, paramDynamicFaceDrawable), null, true);
  }
  
  public void a(DynamicFaceDrawable paramDynamicFaceDrawable, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.c.size() < jdField_a_of_type_Int) || (paramBoolean1))
    {
      ??? = paramDynamicFaceDrawable.jdField_d_of_type_JavaLangString;
      synchronized (this.c)
      {
        this.c.add(paramDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference);
        if (paramBoolean1) {}
      }
      for (;;)
      {
        long l1;
        synchronized (this.d)
        {
          this.d.remove(paramDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference);
          ??? = new abjf(this, paramDynamicFaceDrawable, (String)???);
          if (!paramBoolean2)
          {
            l1 = 0L;
            long l2 = l1;
            if (DeviceInfoUtil.b() <= 2) {
              l2 = l1 * 2L;
            }
            ThreadManager.getSubThreadHandler().postDelayed(new abjg(this, (Runnable)???), l2);
            return;
            paramDynamicFaceDrawable = finally;
            throw paramDynamicFaceDrawable;
          }
        }
        if (paramDynamicFaceDrawable.jdField_e_of_type_Int == 0) {
          l1 = 1500L;
        } else {
          l1 = 400L;
        }
      }
    }
    synchronized (this.d)
    {
      this.d.add(paramDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference);
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager.a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig.jdField_a_of_type_Boolean)) {}
    synchronized (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig)
    {
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig.a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.dynamicAvatar", 2, "---onDpcPullFinished---|mDynamicAvatarConfig:" + this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.dynamicAvatar", 2, "---onDpcPullFinished---|isSuccess:" + paramBoolean);
      }
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {}
    do
    {
      do
      {
        return;
        if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
          break;
        }
        oidb_0x74b.RspBody localRspBody = new oidb_0x74b.RspBody();
        try
        {
          localRspBody.mergeFrom(paramArrayOfByte);
          a(DynamicAvatarInfo.a(localRspBody));
          return;
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
      } while (!QLog.isDevelopLevel());
      paramArrayOfByte.printStackTrace();
      return;
    } while (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof NearbyAppInterface));
    ((NearbyAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).a().a(paramArrayOfByte);
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig != null) {}
    switch (paramInt)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.dynamicAvatar", 2, "isPlayDynamicAvatar|source:" + paramInt + ",isPlay:" + bool + "\n" + this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig);
      }
      return bool;
      bool = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig.jdField_c_of_type_Boolean;
      continue;
      bool = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig.d;
      continue;
      bool = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig.f;
      continue;
      bool = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig.g;
      continue;
      bool = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig.jdField_e_of_type_Boolean;
      continue;
      bool = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig.h;
      continue;
      bool = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig.f;
    }
  }
  
  public boolean a(DynamicAvatar paramDynamicAvatar, Setting paramSetting, int paramInt)
  {
    if ((paramDynamicAvatar == null) || (paramSetting == null)) {}
    do
    {
      do
      {
        return true;
        if (paramInt != 17) {
          break;
        }
        if ((paramDynamicAvatar.getTimeStamp - 5 <= paramSetting.headImgTimestamp) || ((paramDynamicAvatar.basicSetTimeStamp - 5) * 1000 <= paramSetting.updateTimestamp)) {
          break label242;
        }
      } while (!QLog.isColorLevel());
      QLog.i("Q.dynamicAvatar", 2, "isNeed2UpdateSettingInfo basic: " + paramDynamicAvatar.getTimeStamp + " " + paramSetting.headImgTimestamp + " " + paramDynamicAvatar.basicSetTimeStamp + " " + paramSetting.updateTimestamp);
      return true;
      if ((paramInt != 18) || (paramDynamicAvatar.getTimeStamp - 5 <= paramSetting.headImgTimestamp) || ((paramDynamicAvatar.nearbySetTimeStamp - 5) * 1000 <= paramSetting.updateTimestamp)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.dynamicAvatar", 2, "isNeed2UpdateSettingInfo nearby: " + paramDynamicAvatar.getTimeStamp + " " + paramSetting.headImgTimestamp + " " + paramDynamicAvatar.basicSetTimeStamp + " " + paramSetting.updateTimestamp);
    return true;
    label242:
    return false;
  }
  
  @TargetApi(11)
  public boolean a(DynamicFaceDrawable paramDynamicFaceDrawable)
  {
    int i = 640;
    Object localObject1;
    Object localObject2;
    boolean bool1;
    if (!paramDynamicFaceDrawable.f)
    {
      localObject1 = a(paramDynamicFaceDrawable, false);
      localObject2 = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramDynamicFaceDrawable.jdField_e_of_type_Int);
      if ((localObject2 != null) && (((ArrayList)localObject2).contains(localObject1)))
      {
        bool1 = false;
        return bool1;
      }
    }
    File localFile = DynamicAvatarDownloadManager.a(paramDynamicFaceDrawable.jdField_b_of_type_JavaLangString);
    if (paramDynamicFaceDrawable.jdField_d_of_type_Int == 640) {}
    for (;;)
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = i;
      localURLDrawableOptions.mRequestHeight = i;
      localObject2 = paramDynamicFaceDrawable.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      localObject1 = localObject2;
      if ((localObject2 instanceof FaceDrawable)) {
        localObject1 = ((FaceDrawable)localObject2).a();
      }
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
      localObject1 = new VideoDrawable.VideoDrawableParams();
      ((VideoDrawable.VideoDrawableParams)localObject1).mPlayVideoFrame = true;
      ((VideoDrawable.VideoDrawableParams)localObject1).mRequestedFPS = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig.jdField_c_of_type_Int;
      ((VideoDrawable.VideoDrawableParams)localObject1).mVideoRoundCorner = i;
      ((VideoDrawable.VideoDrawableParams)localObject1).mEnableAntiAlias = true;
      ((VideoDrawable.VideoDrawableParams)localObject1).mEnableFilter = true;
      localURLDrawableOptions.mExtraInfo = localObject1;
      boolean bool2 = paramDynamicFaceDrawable.a(URLDrawable.getDrawable(localFile, localURLDrawableOptions), false);
      bool1 = bool2;
      if (!bool2) {
        break;
      }
      bool1 = bool2;
      if (paramDynamicFaceDrawable.jdField_e_of_type_Int < 0) {
        break;
      }
      bool1 = bool2;
      if (DynamicFaceDrawable.jdField_a_of_type_ArrayOfInt.length <= paramDynamicFaceDrawable.jdField_e_of_type_Int) {
        break;
      }
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
        break;
      }
      DynamicUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "0X800711C", DynamicFaceDrawable.jdField_a_of_type_ArrayOfInt[paramDynamicFaceDrawable.jdField_e_of_type_Int]);
      return bool2;
      if (paramDynamicFaceDrawable.jdField_d_of_type_Int == 200) {
        i = 200;
      } else {
        i = 100;
      }
    }
  }
  
  public DynamicAvatar b(int paramInt, String paramString)
  {
    boolean bool = true;
    Object localObject = null;
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
    {
      EntityManager localEntityManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager();
      if (paramInt == 18)
      {
        localObject = "tinyId=?";
        localObject = (DynamicAvatar)localEntityManager.a(DynamicAvatar.class, (String)localObject, new String[] { paramString });
        localEntityManager.a();
      }
    }
    else if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("getAvatarInfoFromDb: avatarInfo is null: ");
      if (localObject != null) {
        break label112;
      }
    }
    for (;;)
    {
      QLog.d("Q.dynamicAvatar", 2, bool);
      return localObject;
      localObject = "uin=?";
      break;
      label112:
      bool = false;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.b.clear();
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
  }
  
  public void b(DynamicFaceDrawable paramDynamicFaceDrawable)
  {
    if (paramDynamicFaceDrawable == null) {}
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
        if (ShortVideoUtils.a()) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.w("Q.dynamicAvatar", 2, "getDynamicAvatar isVideoSoLibLoaded false.");
        }
      } while (this.jdField_a_of_type_Boolean);
      ThreadManager.getSubThreadHandler().postDelayed(new abjd(this), 10000L);
      this.jdField_a_of_type_Boolean = true;
      return;
      if (paramDynamicFaceDrawable.f) {
        break;
      }
      ??? = a(paramDynamicFaceDrawable, false);
      localArrayList = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramDynamicFaceDrawable.jdField_e_of_type_Int);
    } while ((localArrayList != null) && (localArrayList.contains(???)));
    if (DynamicFaceDrawable.jdField_b_of_type_Boolean) {
      synchronized (this.d)
      {
        this.d.add(paramDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference);
        return;
      }
    }
    a(paramDynamicFaceDrawable, true, true);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.dynamicAvatar", 2, "resumeAll pausedSize: " + this.d.size() + " loadinging size: " + this.c.size() + " playing size" + this.jdField_a_of_type_JavaUtilArrayList.size() + " waiting play size: " + this.b.size());
    }
    if (DynamicFaceDrawable.jdField_b_of_type_Boolean) {
      return;
    }
    int i;
    synchronized (this.d)
    {
      i = this.d.size() - 1;
      if (i >= 0)
      {
        WeakReference localWeakReference1 = (WeakReference)this.d.get(i);
        if ((localWeakReference1 != null) && (localWeakReference1.get() != null)) {
          ((DynamicFaceDrawable)localWeakReference1.get()).a();
        } else {
          this.d.remove(i);
        }
      }
    }
    int m = Math.min(jdField_a_of_type_Int, this.d.size());
    for (;;)
    {
      Object localObject2;
      int j;
      synchronized (this.c)
      {
        int k = this.c.size();
        if (m >= jdField_a_of_type_Int)
        {
          i = k;
          localObject2 = new ArrayList();
          j = k - 1;
          if (j >= k - i)
          {
            WeakReference localWeakReference2 = (WeakReference)this.c.remove(j);
            if ((localWeakReference2 == null) || (localWeakReference2.get() == null)) {
              break label434;
            }
            ((ArrayList)localObject2).add(((DynamicFaceDrawable)localWeakReference2.get()).jdField_b_of_type_JavaLangString);
            break label434;
          }
        }
        else
        {
          i = k - (jdField_a_of_type_Int - m);
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager != null) {
          this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager.a((ArrayList)localObject2);
        }
      }
      synchronized (this.d)
      {
        i = Math.min(this.d.size() - 1, m - 1);
        while (i >= 0)
        {
          localObject2 = (WeakReference)this.d.get(i);
          if ((localObject2 != null) && (((WeakReference)localObject2).get() != null))
          {
            a((DynamicFaceDrawable)((WeakReference)localObject2).get(), false, false);
            i -= 1;
            continue;
            localObject3 = finally;
            throw localObject3;
          }
          else
          {
            this.d.remove(i);
          }
        }
      }
      return;
      i -= 1;
      break;
      label434:
      j -= 1;
    }
  }
  
  public void d() {}
  
  public void onDestroy()
  {
    DeviceProfileManager.b(this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$DPCObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarInfoObserver);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager.b();
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager = null;
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarInfoObserver = null;
    this.jdField_a_of_type_JavaUtilConcurrentExecutor = null;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager
 * JD-Core Version:    0.7.0.1
 */