package com.tencent.mobileqq.avatar.api.impl;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.face.FaceConstant.Apollo;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.cache.memory.MemoryCache;
import com.tencent.mobileqq.avatar.cache.memory.avatar.LruLimitTimeAvatarMemoryCache;
import com.tencent.mobileqq.avatar.cache.memory.avatarsetting.LruAvatarSettingCache;
import com.tencent.mobileqq.avatar.utils.AvatarImplUtil;
import com.tencent.mobileqq.avatar.utils.AvatarUtil;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.util.BitmapManager.BitmapDecodeResult;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.open.base.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class QQAvatarDataServiceImpl
  implements IQQAvatarDataService
{
  private static final String TAG = "QQAvatarDataServiceImpl";
  private AppRuntime mApp;
  private MemoryCache<Bitmap> mAvatarCache;
  private volatile MemoryCache<Setting> mAvatarSettingCache;
  private EntityManager mEntityManager;
  private volatile boolean mIsSettingDBInitFinish = false;
  private final Object mSettingCacheLock = new Object();
  private final Object mSettingDBInitLock = new Object();
  
  private void checkAndCreateFaceSettingCache()
  {
    if (this.mAvatarSettingCache == null)
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append(Thread.currentThread().getName());
      ((StringBuilder)???).append("尝试进行 mAvatarSettingCache new 的初始化，stack = ");
      QLog.i("Q.qqhead.", 1, ((StringBuilder)???).toString(), new RuntimeException("new mAvatarSettingCache"));
      synchronized (this.mSettingCacheLock)
      {
        if (this.mAvatarSettingCache == null)
        {
          this.mAvatarSettingCache = new LruAvatarSettingCache();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(Thread.currentThread().getName());
          localStringBuilder.append("完成了 mAvatarSettingCache new 的过程，stack = ");
          QLog.i("Q.qqhead.", 1, localStringBuilder.toString(), new RuntimeException("new mAvatarSettingCache"));
        }
        return;
      }
    }
  }
  
  private void checkAndInitAvatarCache()
  {
    if (this.mAvatarCache == null) {
      this.mAvatarCache = new LruLimitTimeAvatarMemoryCache();
    }
  }
  
  private String getFaceFilePathPrefix(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt == 32)
    {
      if (SystemUtil.a()) {
        localStringBuilder.append(AppConstants.PATH_HEAD_STRANGER);
      } else {
        localStringBuilder.append("/data/data/com.tencent.mobileqq/files/head/_stranger/");
      }
    }
    else if (paramInt == 116)
    {
      if (SystemUtil.a()) {
        localStringBuilder.append(AppConstants.PATH_HEAD_APOLLO);
      } else {
        localStringBuilder.append("/data/data/com.tencent.mobileqq/files/head/_apollo/");
      }
    }
    else if (SystemUtil.a()) {
      localStringBuilder.append(AppConstants.PATH_HEAD_HD);
    } else {
      localStringBuilder.append("/data/data/com.tencent.mobileqq/files/head/_hd/");
    }
    return localStringBuilder.toString();
  }
  
  private Object[] getNewFaceTypeBySetting(Setting paramSetting, String paramString, int paramInt)
  {
    String str = paramString;
    int i = paramInt;
    if (paramSetting != null)
    {
      str = paramString;
      i = paramInt;
      if (paramInt != 101)
      {
        str = paramString;
        i = paramInt;
        if (paramInt != 1001)
        {
          str = paramString;
          i = paramInt;
          if (paramInt != 116)
          {
            str = paramString;
            i = paramInt;
            if (paramString != null)
            {
              str = paramString;
              i = paramInt;
              if (paramSetting.bHeadType == 0)
              {
                str = String.valueOf(paramSetting.systemHeadID);
                if (paramInt == 4) {
                  i = -56;
                } else if (paramInt == 16) {
                  i = 16;
                } else {
                  i = -55;
                }
              }
            }
          }
        }
      }
    }
    return new Object[] { Integer.valueOf(i), str };
  }
  
  public Bitmap getBitmapFromCache(String paramString)
  {
    checkAndInitAvatarCache();
    return (Bitmap)this.mAvatarCache.a(paramString);
  }
  
  public String getCustomFaceFilePath(int paramInt1, String paramString, int paramInt2)
  {
    return getCustomFaceFilePath(null, paramInt1, paramString, paramInt2, 0);
  }
  
  public String getCustomFaceFilePath(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    return getCustomFaceFilePath(null, paramInt1, paramString, paramInt2, paramInt3);
  }
  
  public String getCustomFaceFilePath(Setting paramSetting, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    Object localObject = paramSetting;
    if (paramSetting == null)
    {
      localObject = paramSetting;
      if (paramString != null)
      {
        localObject = paramSetting;
        if (paramInt1 != 101)
        {
          localObject = paramSetting;
          if (paramInt1 != 1001)
          {
            localObject = paramSetting;
            if (paramInt1 != 116) {
              localObject = (Setting)getQQHeadSetting(paramInt1, paramString, paramInt2).second;
            }
          }
        }
      }
    }
    paramSetting = new StringBuilder(256);
    paramSetting.append(getFaceFilePathPrefix(paramInt1));
    localObject = getNewFaceTypeBySetting((Setting)localObject, paramString, paramInt1);
    paramInt1 = ((Integer)localObject[0]).intValue();
    if (paramInt1 != -56)
    {
      if (paramInt1 != -55)
      {
        if (paramInt1 != 4)
        {
          if (paramInt1 != 16)
          {
            if (paramInt1 != 32)
            {
              if (paramInt1 != 101)
              {
                if (paramInt1 != 113)
                {
                  if (paramInt1 != 116)
                  {
                    if (paramInt1 == 1001)
                    {
                      paramSetting.append("dis_pstn_g_");
                      localObject = new StringBuilder();
                      ((StringBuilder)localObject).append(this.mApp.getAccount());
                      ((StringBuilder)localObject).append(paramString);
                      paramString = ((StringBuilder)localObject).toString();
                    }
                  }
                  else
                  {
                    paramSetting.append("apollo_");
                    paramSetting.append(paramInt3);
                    paramSetting.append("_");
                  }
                }
                else {
                  paramSetting.append("new_troop_b_");
                }
              }
              else
              {
                paramSetting.append("dis_g_");
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(this.mApp.getAccount());
                ((StringBuilder)localObject).append(paramString);
                paramString = ((StringBuilder)localObject).toString();
              }
            }
            else
            {
              paramSetting.append("stranger_");
              paramSetting.append(Integer.toString(paramInt2));
              paramSetting.append("_");
            }
          }
          else
          {
            paramSetting.append("qcall_");
            paramSetting.append(Integer.toString(paramInt2));
            paramSetting.append("_");
          }
        }
        else {
          paramSetting.append("troop_");
        }
      }
      else
      {
        paramSetting.append("sys_");
        paramString = (String)localObject[1];
      }
    }
    else
    {
      paramSetting.append("troop_sys_b_");
      paramString = (String)localObject[1];
    }
    if (paramString != null)
    {
      localObject = MD5.b(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(paramString);
      localObject = MD5.b(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(paramString);
      paramSetting.append(MD5.b(localStringBuilder.toString()));
    }
    paramSetting.append(".jpg_");
    return paramSetting.toString();
  }
  
  public String getCustomFaceFilePath(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      return getCustomFaceFilePath(null, 4, paramString, 0, 0);
    }
    return getCustomFaceFilePath(null, 1, paramString, 0, 0);
  }
  
  public String getCustomFaceFilePathBySetting(Setting paramSetting, int paramInt1, int paramInt2)
  {
    if (paramSetting == null) {
      return "";
    }
    int i = paramSetting.bUsrType;
    String str = AvatarImplUtil.a(paramSetting.uin);
    if (TextUtils.isEmpty(str)) {
      return "";
    }
    return getCustomFaceFilePath(paramSetting, i, str, paramInt1, paramInt2);
  }
  
  protected EntityManager getEntityManager()
  {
    if ((this.mApp.isLogin()) && (this.mApp.getAccount() != null))
    {
      AppRuntime localAppRuntime = this.mApp;
      return localAppRuntime.getEntityManagerFactory(localAppRuntime.getAccount()).createEntityManager();
    }
    return null;
  }
  
  public String getFaceBitmapCacheKey(int paramInt1, String paramString, byte paramByte, int paramInt2)
  {
    return getFaceBitmapCacheKey(paramInt1, paramString, paramByte, paramInt2, 100, false);
  }
  
  public String getFaceBitmapCacheKey(int paramInt1, String paramString, byte paramByte, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder(16);
    if ((paramInt1 != 101) && (paramInt1 != 1001) && (paramString != null))
    {
      if (paramBoolean) {
        localObject = getFaceSetting(AvatarUtil.a(paramInt1, paramString, paramInt2));
      } else {
        localObject = (Setting)getQQHeadSetting(paramInt1, paramString, paramInt2).second;
      }
    }
    else {
      localObject = null;
    }
    Object localObject = getNewFaceTypeBySetting((Setting)localObject, paramString, paramInt1);
    paramInt1 = ((Integer)localObject[0]).intValue();
    if (paramInt1 != -56)
    {
      if (paramInt1 != -55)
      {
        if (paramInt1 != 4)
        {
          if (paramInt1 != 16)
          {
            if (paramInt1 != 32)
            {
              if (paramInt1 != 101)
              {
                if (paramInt1 != 103)
                {
                  if (paramInt1 != 113)
                  {
                    if (paramInt1 != 116)
                    {
                      if (paramInt1 == 1001) {
                        localStringBuilder.append("dis_pstn_g_");
                      }
                    }
                    else
                    {
                      localStringBuilder.append("apollo_");
                      localStringBuilder.append(paramInt3);
                      localStringBuilder.append("_");
                    }
                  }
                  else {
                    localStringBuilder.append("new_troop_b_");
                  }
                }
                else {
                  localStringBuilder.append("sub_");
                }
              }
              else {
                localStringBuilder.append("dis_g_");
              }
            }
            else
            {
              localStringBuilder.append("stranger_");
              localStringBuilder.append(Integer.toString(paramInt2));
              localStringBuilder.append("_");
            }
          }
          else
          {
            localStringBuilder.append("qcall_");
            localStringBuilder.append(Integer.toString(paramInt2));
            localStringBuilder.append("_");
          }
        }
        else {
          localStringBuilder.append("troop_");
        }
      }
      else
      {
        localStringBuilder.append("sys_");
        paramString = (String)localObject[1];
      }
    }
    else
    {
      localStringBuilder.append("troop_sys_b_");
      paramString = (String)localObject[1];
    }
    localStringBuilder.append(paramString);
    if (paramByte > 0)
    {
      localStringBuilder.append("_");
      localStringBuilder.append(paramByte);
    }
    return localStringBuilder.toString();
  }
  
  public Setting getFaceSetting(String paramString)
  {
    if (this.mAvatarSettingCache == null) {
      return null;
    }
    return (Setting)this.mAvatarSettingCache.a(paramString);
  }
  
  public String getOldCustomFaceFilePath(int paramInt, String paramString)
  {
    Object localObject = MD5.b(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramString);
    localObject = MD5.b(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramString);
    paramString = MD5.b(localStringBuilder.toString());
    localObject = new StringBuilder(256);
    if (paramInt == 4)
    {
      if (SystemUtil.a()) {
        ((StringBuilder)localObject).append(AppConstants.PATH_HEAD_THD);
      } else {
        ((StringBuilder)localObject).append("/data/data/com.tencent.mobileqq/files/head/_thd/");
      }
    }
    else if (SystemUtil.a()) {
      ((StringBuilder)localObject).append(AppConstants.PATH_HEAD_HD);
    } else {
      ((StringBuilder)localObject).append("/data/data/com.tencent.mobileqq/files/head/_hd/");
    }
    if (paramInt == 101) {
      ((StringBuilder)localObject).append("discussion_");
    }
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(".png");
    return ((StringBuilder)localObject).toString();
  }
  
  public Pair<Boolean, Setting> getQQHeadSetting(int paramInt1, String paramString, int paramInt2)
  {
    String str = AvatarUtil.a(paramInt1, paramString, paramInt2);
    Object localObject1;
    if ((!TextUtils.isEmpty(str)) && (this.mAvatarSettingCache != null)) {
      localObject1 = (Setting)this.mAvatarSettingCache.a(str);
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      if (this.mEntityManager == null) {
        this.mEntityManager = getEntityManager();
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(str))
      {
        localObject2 = localObject1;
        if (this.mEntityManager != null)
        {
          checkAndCreateFaceSettingCache();
          localObject1 = (Setting)this.mEntityManager.find(Setting.class, str);
          localObject2 = localObject1;
          if (localObject1 != null)
          {
            this.mAvatarSettingCache.a(str, localObject1);
            localObject2 = localObject1;
          }
        }
      }
    }
    if (localObject2 == null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getQQHeadSetting. qqset is null, | uin=");
        ((StringBuilder)localObject1).append(paramString);
        QLog.i("Q.qqhead.", 2, ((StringBuilder)localObject1).toString());
      }
      return new Pair(Boolean.valueOf(true), localObject2);
    }
    boolean bool = false;
    if (((paramInt1 == 1) || (paramInt1 == 4) || (paramInt1 == 11) || (paramInt1 == 16) || (paramInt1 == 32) || (paramInt1 == 116)) && ((localObject2 == null) || (System.currentTimeMillis() - localObject2.updateTimestamp > 86400000L))) {
      bool = true;
    }
    if ((QLog.isColorLevel()) && (bool))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getQQHeadSetting. | uin=");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(", isNeedCheckQQHead=");
      ((StringBuilder)localObject1).append(bool);
      ((StringBuilder)localObject1).append(", updateTimestamp=");
      ((StringBuilder)localObject1).append(localObject2.updateTimestamp);
      ((StringBuilder)localObject1).append(", headImgTimestamp=");
      ((StringBuilder)localObject1).append(localObject2.headImgTimestamp);
      ((StringBuilder)localObject1).append(", status=");
      ((StringBuilder)localObject1).append(localObject2.getStatus());
      ((StringBuilder)localObject1).append(", id=");
      ((StringBuilder)localObject1).append(localObject2.getId());
      ((StringBuilder)localObject1).append(", currentTimeMillis=");
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      QLog.i("Q.qqhead.", 2, ((StringBuilder)localObject1).toString());
    }
    return new Pair(Boolean.valueOf(bool), localObject2);
  }
  
  /* Error */
  public Setting getQQHeadSettingFromDB(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 273	com/tencent/mobileqq/avatar/api/impl/QQAvatarDataServiceImpl:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   4: ifnonnull +11 -> 15
    //   7: aload_0
    //   8: aload_0
    //   9: invokevirtual 275	com/tencent/mobileqq/avatar/api/impl/QQAvatarDataServiceImpl:getEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   12: putfield 273	com/tencent/mobileqq/avatar/api/impl/QQAvatarDataServiceImpl:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   15: aload_0
    //   16: getfield 273	com/tencent/mobileqq/avatar/api/impl/QQAvatarDataServiceImpl:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   19: ldc 115
    //   21: aload_1
    //   22: invokevirtual 283	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   25: checkcast 115	com/tencent/mobileqq/data/Setting
    //   28: astore_2
    //   29: aload_0
    //   30: getfield 273	com/tencent/mobileqq/avatar/api/impl/QQAvatarDataServiceImpl:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   33: astore_3
    //   34: aload_2
    //   35: astore_1
    //   36: aload_3
    //   37: ifnull +33 -> 70
    //   40: aload_3
    //   41: invokevirtual 351	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   44: aload_2
    //   45: areturn
    //   46: astore_1
    //   47: goto +25 -> 72
    //   50: astore_1
    //   51: aload_1
    //   52: invokevirtual 354	java/lang/Exception:printStackTrace	()V
    //   55: aload_0
    //   56: getfield 273	com/tencent/mobileqq/avatar/api/impl/QQAvatarDataServiceImpl:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +7 -> 68
    //   64: aload_1
    //   65: invokevirtual 351	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   68: aconst_null
    //   69: astore_1
    //   70: aload_1
    //   71: areturn
    //   72: aload_0
    //   73: getfield 273	com/tencent/mobileqq/avatar/api/impl/QQAvatarDataServiceImpl:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   76: astore_2
    //   77: aload_2
    //   78: ifnull +7 -> 85
    //   81: aload_2
    //   82: invokevirtual 351	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	QQAvatarDataServiceImpl
    //   0	87	1	paramString	String
    //   28	54	2	localObject	Object
    //   33	8	3	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   0	15	46	finally
    //   15	29	46	finally
    //   51	55	46	finally
    //   0	15	50	java/lang/Exception
    //   15	29	50	java/lang/Exception
  }
  
  public Drawable getRoundFaceDrawable(Bitmap paramBitmap)
  {
    return new BitmapDrawable(AvatarUtil.a(paramBitmap));
  }
  
  public Setting getSettingFromDb(String paramString)
  {
    if (this.mEntityManager == null) {
      this.mEntityManager = getEntityManager();
    }
    EntityManager localEntityManager = this.mEntityManager;
    if (localEntityManager == null) {
      return null;
    }
    return (Setting)localEntityManager.find(Setting.class, paramString);
  }
  
  void init(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    this.mEntityManager = getEntityManager();
    checkAndInitAvatarCache();
    checkAndCreateFaceSettingCache();
  }
  
  public void initFaceSettingCache()
  {
    long l1 = SystemClock.currentThreadTimeMillis();
    checkAndCreateFaceSettingCache();
    localObject1 = this.mSettingDBInitLock;
    j = 0;
    int i2 = 0;
    try
    {
      this.mIsSettingDBInitFinish = false;
      this.mAvatarSettingCache.a();
      if (this.mEntityManager == null) {
        this.mEntityManager = getEntityManager();
      }
      if (this.mEntityManager == null) {
        return;
      }
      localObject4 = this.mEntityManager.query(Setting.class, new Setting().getTableName(), false, null, null, null, null, "updateTimestamp desc", null);
      if (localObject4 == null) {
        break label546;
      }
      k = ((List)localObject4).size();
      i = k;
      if (k <= 0) {
        break label548;
      }
      localObject2 = new ArrayList();
      m = 0;
      j = 0;
      i = 0;
    }
    finally
    {
      for (;;)
      {
        Object localObject4;
        Object localObject2;
        Setting localSetting;
        int n;
        int i1;
        long l2;
        for (;;)
        {
          throw localObject3;
        }
        m += 1;
        j = n;
        int i = i1;
        continue;
        m += 1;
        continue;
        continue;
        i = 0;
        int m = 0;
        int k = i;
        i = m;
      }
    }
    if (m < k)
    {
      localSetting = (Setting)((List)localObject4).get(m);
      n = j;
      i1 = i;
      if (localSetting != null)
      {
        n = j;
        i1 = i;
        if (!TextUtils.isEmpty(localSetting.uin)) {
          if (j >= 4000)
          {
            n = j;
            i1 = i;
          }
          else
          {
            localSetting.url = null;
            if (((localSetting.bSourceType == 1) || (localSetting.bUsrType == 32)) && (i <= 100))
            {
              ((List)localObject2).add(localSetting);
              i1 = i + 1;
              n = j;
            }
            else
            {
              this.mAvatarSettingCache.a(localSetting.uin, localSetting);
              n = j + 1;
              i1 = i;
            }
          }
        }
      }
    }
    else
    {
      n = Math.min(100, Math.min(4000 - j, ((List)localObject2).size()));
      if (n <= 0) {
        break label543;
      }
      m = i2;
      if (m >= n) {
        break label543;
      }
      localObject4 = (Setting)((List)localObject2).get(m);
      if ((localObject4 == null) || (TextUtils.isEmpty(((Setting)localObject4).uin))) {
        break label534;
      }
      this.mAvatarSettingCache.a(((Setting)localObject4).uin, localObject4);
      break label534;
      this.mIsSettingDBInitFinish = true;
      l2 = SystemClock.currentThreadTimeMillis();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initFaceSettingCache,");
      ((StringBuilder)localObject2).append(k);
      ((StringBuilder)localObject2).append(",");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append(",");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("，耗时：");
      ((StringBuilder)localObject2).append(l2 - l1);
      ((StringBuilder)localObject2).append(", Thread name = ");
      ((StringBuilder)localObject2).append(Thread.currentThread().getName());
      ((StringBuilder)localObject2).append("，stack = ");
      QLog.d("QQAvatarDataServiceImpl", 1, ((StringBuilder)localObject2).toString(), new RuntimeException("initFaceSettingCache"));
      return;
    }
  }
  
  public boolean isFaceFileExist(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    String str = getFaceBitmapCacheKey(paramInt1, paramString, (byte)3, paramInt2, paramInt3, false);
    checkAndInitAvatarCache();
    MemoryCache localMemoryCache = this.mAvatarCache;
    if ((localMemoryCache != null) && (localMemoryCache.a(str) != null)) {
      return true;
    }
    paramString = new File(getCustomFaceFilePath(paramInt1, paramString, paramInt2, paramInt3));
    return (paramString.exists()) && (paramString.isFile());
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    init(paramAppRuntime);
  }
  
  public void onDestroy() {}
  
  public void putBitmapToCache(String paramString, Bitmap paramBitmap, byte paramByte)
  {
    checkAndInitAvatarCache();
    this.mAvatarCache.a(paramString, paramBitmap, paramByte);
  }
  
  public Bitmap putSdcardBitmapToCache(int paramInt1, String paramString1, byte paramByte, String paramString2, Bitmap paramBitmap, String paramString3, BitmapManager.BitmapDecodeResult paramBitmapDecodeResult, int paramInt2)
  {
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap != null)
    {
      paramBitmap = AvatarUtil.a(paramByte, paramBitmap, paramString1, paramInt2);
      if (paramBitmap != null)
      {
        if (QLog.isColorLevel())
        {
          paramBitmapDecodeResult = new StringBuilder();
          paramBitmapDecodeResult.append("getFaceBitmap decode success, faceType=");
          paramBitmapDecodeResult.append(paramInt1);
          paramBitmapDecodeResult.append(", uin=");
          paramBitmapDecodeResult.append(paramString1);
          paramBitmapDecodeResult.append(", shape=");
          paramBitmapDecodeResult.append(paramByte);
          paramBitmapDecodeResult.append(", headType=");
          paramBitmapDecodeResult.append(paramInt2);
          paramBitmapDecodeResult.append(", path=");
          paramBitmapDecodeResult.append(paramString3);
          paramBitmapDecodeResult.append(", bmp=");
          paramBitmapDecodeResult.append(paramBitmap);
          QLog.i("Q.qqhead.", 2, paramBitmapDecodeResult.toString());
        }
        putBitmapToCache(paramString2, paramBitmap, AvatarImplUtil.a(paramInt1));
        return paramBitmap;
      }
      localBitmap = paramBitmap;
      if (QLog.isColorLevel())
      {
        localBitmap = paramBitmap;
        if (paramBitmapDecodeResult.b == 0)
        {
          paramString2 = new StringBuilder();
          paramString2.append("getFaceBitmap decode shape fail, faceType=");
          paramString2.append(paramInt1);
          paramString2.append(", uin=");
          paramString2.append(paramString1);
          paramString2.append(", shape=");
          paramString2.append(paramByte);
          paramString2.append(", headType=");
          paramString2.append(paramInt2);
          QLog.i("Q.qqhead.", 2, paramString2.toString());
          localBitmap = paramBitmap;
        }
      }
    }
    return localBitmap;
  }
  
  public void removeBitmapFromCache(String paramString)
  {
    checkAndInitAvatarCache();
    this.mAvatarCache.b(paramString);
  }
  
  public void removeFaceIconCache(int paramInt1, String paramString, int paramInt2)
  {
    int i = 0;
    paramString = getFaceBitmapCacheKey(paramInt1, paramString, (byte)0, paramInt2);
    paramInt1 = i;
    while (paramInt1 <= 5)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_");
      localStringBuilder.append(paramInt1);
      removeBitmapFromCache(localStringBuilder.toString());
      paramInt1 += 1;
    }
  }
  
  public void removeFaceIconCacheApollo(int paramInt1, String paramString, int paramInt2)
  {
    int[] arrayOfInt1 = FaceConstant.Apollo.FACE_SPEC_ALL;
    int j = arrayOfInt1.length;
    paramInt2 = 0;
    while (paramInt2 < j)
    {
      int k = arrayOfInt1[paramInt2];
      int[] arrayOfInt2 = FaceConstant.Apollo.FACE_SHAPE_ALL;
      int m = arrayOfInt2.length;
      int i = 0;
      while (i < m)
      {
        removeBitmapFromCache(getFaceBitmapCacheKey(paramInt1, paramString, (byte)arrayOfInt2[i], 200, k, false));
        i += 1;
      }
      paramInt2 += 1;
    }
  }
  
  public void updateSettingTableCache(Setting arg1)
  {
    if (??? != null)
    {
      Object localObject1 = ???.clone();
      if (localObject1 != null)
      {
        ((Setting)localObject1).url = null;
        if (!TextUtils.isEmpty(((Setting)localObject1).uin))
        {
          checkAndCreateFaceSettingCache();
          if (this.mIsSettingDBInitFinish)
          {
            this.mAvatarSettingCache.a(((Setting)localObject1).uin, localObject1);
            return;
          }
          synchronized (this.mSettingDBInitLock)
          {
            this.mAvatarSettingCache.a(((Setting)localObject1).uin, localObject1);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("有线程在等待 initFaceSettingCache 完成。线程名：");
            ((StringBuilder)localObject1).append(Thread.currentThread().getName());
            ((StringBuilder)localObject1).append("，stack = ");
            QLog.i("Q.qqhead.", 1, ((StringBuilder)localObject1).toString(), new RuntimeException("等待 initFaceSettingCache 完成"));
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.impl.QQAvatarDataServiceImpl
 * JD-Core Version:    0.7.0.1
 */