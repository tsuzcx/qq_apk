package com.tencent.mobileqq.avatar.api.impl;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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
  private MemoryCache<Setting> mAvatarSettingCache;
  private EntityManager mEntityManager;
  
  private void checkAndCreateFaceSettingCache()
  {
    if (this.mAvatarSettingCache == null) {
      this.mAvatarSettingCache = new LruAvatarSettingCache();
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
    if (paramInt == 32) {
      if (SystemUtil.a()) {
        localStringBuilder.append(AppConstants.PATH_HEAD_STRANGER);
      }
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("/data/data/com.tencent.mobileqq/files/head/_stranger/");
      continue;
      if (paramInt == 116)
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
    }
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
                if (paramInt != 4) {
                  break label106;
                }
                i = -56;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      return new Object[] { Integer.valueOf(i), str };
      label106:
      if (paramInt == 16) {
        i = 16;
      } else {
        i = -55;
      }
    }
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
    switch (((Integer)localObject[0]).intValue())
    {
    }
    for (;;)
    {
      localObject = MD5.a(paramString);
      localObject = MD5.a((String)localObject + paramString);
      paramSetting.append(MD5.a((String)localObject + paramString));
      paramSetting.append(".jpg_");
      return paramSetting.toString();
      paramSetting.append("troop_sys_b_");
      paramString = (String)localObject[1];
      continue;
      paramSetting.append("sys_");
      paramString = (String)localObject[1];
      continue;
      paramSetting.append("dis_g_");
      paramString = this.mApp.getAccount() + paramString;
      continue;
      paramSetting.append("dis_pstn_g_");
      paramString = this.mApp.getAccount() + paramString;
      continue;
      paramSetting.append("troop_");
      continue;
      paramSetting.append("new_troop_b_");
      continue;
      paramSetting.append("stranger_").append(Integer.toString(paramInt2)).append("_");
      continue;
      paramSetting.append("qcall_").append(Integer.toString(paramInt2)).append("_");
      continue;
      paramSetting.append("apollo_").append(paramInt3).append("_");
    }
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
    if ((!this.mApp.isLogin()) || (this.mApp.getAccount() == null)) {
      return null;
    }
    return this.mApp.getEntityManagerFactory(this.mApp.getAccount()).createEntityManager();
  }
  
  public String getFaceBitmapCacheKey(int paramInt1, String paramString, byte paramByte, int paramInt2)
  {
    return getFaceBitmapCacheKey(paramInt1, paramString, paramByte, paramInt2, 100, false);
  }
  
  public String getFaceBitmapCacheKey(int paramInt1, String paramString, byte paramByte, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder(16);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt1 != 101)
    {
      localObject1 = localObject2;
      if (paramInt1 != 1001)
      {
        localObject1 = localObject2;
        if (paramString != null)
        {
          if (!paramBoolean) {
            break label201;
          }
          localObject1 = getFaceSetting(AvatarUtil.a(paramInt1, paramString, paramInt2));
        }
      }
    }
    localObject1 = getNewFaceTypeBySetting((Setting)localObject1, paramString, paramInt1);
    switch (((Integer)localObject1[0]).intValue())
    {
    }
    for (;;)
    {
      localStringBuilder.append(paramString);
      if (paramByte > 0) {
        localStringBuilder.append("_").append(paramByte);
      }
      return localStringBuilder.toString();
      label201:
      localObject1 = (Setting)getQQHeadSetting(paramInt1, paramString, paramInt2).second;
      break;
      localStringBuilder.append("troop_sys_b_");
      paramString = (String)localObject1[1];
      continue;
      localStringBuilder.append("sys_");
      paramString = (String)localObject1[1];
      continue;
      localStringBuilder.append("dis_g_");
      continue;
      localStringBuilder.append("dis_pstn_g_");
      continue;
      localStringBuilder.append("troop_");
      continue;
      localStringBuilder.append("sub_");
      continue;
      localStringBuilder.append("stranger_").append(Integer.toString(paramInt2)).append("_");
      continue;
      localStringBuilder.append("qcall_").append(Integer.toString(paramInt2)).append("_");
      continue;
      localStringBuilder.append("new_troop_b_");
      continue;
      localStringBuilder.append("apollo_").append(paramInt3).append("_");
    }
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
    Object localObject = MD5.a(paramString);
    localObject = MD5.a((String)localObject + paramString);
    paramString = MD5.a((String)localObject + paramString);
    localObject = new StringBuilder(256);
    if (paramInt == 4) {
      if (SystemUtil.a()) {
        ((StringBuilder)localObject).append(AppConstants.PATH_HEAD_THD);
      }
    }
    for (;;)
    {
      if (paramInt == 101) {
        ((StringBuilder)localObject).append("discussion_");
      }
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(".png");
      return ((StringBuilder)localObject).toString();
      ((StringBuilder)localObject).append("/data/data/com.tencent.mobileqq/files/head/_thd/");
      continue;
      if (SystemUtil.a()) {
        ((StringBuilder)localObject).append(AppConstants.PATH_HEAD_HD);
      } else {
        ((StringBuilder)localObject).append("/data/data/com.tencent.mobileqq/files/head/_hd/");
      }
    }
  }
  
  public Pair<Boolean, Setting> getQQHeadSetting(int paramInt1, String paramString, int paramInt2)
  {
    Object localObject2 = null;
    String str = AvatarUtil.a(paramInt1, paramString, paramInt2);
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(str))
    {
      localObject1 = localObject2;
      if (this.mAvatarSettingCache != null) {
        localObject1 = (Setting)this.mAvatarSettingCache.a(str);
      }
    }
    localObject2 = localObject1;
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
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.", 2, "getQQHeadSetting. qqset is null, | uin=" + paramString);
      }
      return new Pair(Boolean.valueOf(true), localObject2);
    }
    boolean bool;
    switch (paramInt1)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      if ((QLog.isColorLevel()) && (bool)) {
        QLog.i("Q.qqhead.", 2, "getQQHeadSetting. | uin=" + paramString + ", isNeedCheckQQHead=" + bool + ", updateTimestamp=" + localObject2.updateTimestamp + ", headImgTimestamp=" + localObject2.headImgTimestamp + ", status=" + localObject2.getStatus() + ", id=" + localObject2.getId() + ", currentTimeMillis=" + System.currentTimeMillis());
      }
      return new Pair(Boolean.valueOf(bool), localObject2);
      if ((localObject2 == null) || (System.currentTimeMillis() - localObject2.updateTimestamp > 86400000L)) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public Setting getQQHeadSettingFromDB(String paramString)
  {
    try
    {
      if (this.mEntityManager == null) {
        this.mEntityManager = getEntityManager();
      }
      paramString = (Setting)this.mEntityManager.find(Setting.class, paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    finally
    {
      if (this.mEntityManager != null) {
        this.mEntityManager.close();
      }
    }
    return null;
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
    if (this.mEntityManager == null) {
      return null;
    }
    return (Setting)this.mEntityManager.find(Setting.class, paramString);
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
    int k = 0;
    int i1 = 0;
    checkAndCreateFaceSettingCache();
    this.mAvatarSettingCache.a();
    if (this.mEntityManager == null) {
      this.mEntityManager = getEntityManager();
    }
    if (this.mEntityManager == null) {
      return;
    }
    Object localObject = this.mEntityManager.query(Setting.class, new Setting().getTableName(), false, null, null, null, null, "updateTimestamp desc", null);
    int j;
    int i;
    int n;
    if (localObject != null)
    {
      k = ((List)localObject).size();
      if (k > 0)
      {
        ArrayList localArrayList = new ArrayList();
        int m = 0;
        j = 0;
        i = 0;
        if (m < k)
        {
          Setting localSetting = (Setting)((List)localObject).get(m);
          if ((localSetting != null) && (!TextUtils.isEmpty(localSetting.uin)))
          {
            if (i >= 4000)
            {
              n = j;
              j = i;
              i = n;
            }
            for (;;)
            {
              n = m + 1;
              m = j;
              j = i;
              i = m;
              m = n;
              break;
              localSetting.url = null;
              if (((localSetting.bSourceType == 1) || (localSetting.bUsrType == 32)) && (j <= 100))
              {
                localArrayList.add(localSetting);
                n = j + 1;
                j = i;
                i = n;
              }
              else
              {
                this.mAvatarSettingCache.a(localSetting.uin, localSetting);
                n = i + 1;
                i = j;
                j = n;
              }
            }
          }
        }
        else
        {
          n = Math.min(100, Math.min(4000 - i, localArrayList.size()));
          if (n > 0)
          {
            m = i1;
            if (m < n)
            {
              localObject = (Setting)localArrayList.get(m);
              if ((localObject == null) || (TextUtils.isEmpty(((Setting)localObject).uin))) {}
              for (;;)
              {
                m += 1;
                break;
                this.mAvatarSettingCache.a(((Setting)localObject).uin, localObject);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      QLog.d("QQAvatarDataServiceImpl", 1, "initFaceSettingCache," + k + "," + i + "," + j);
      return;
      n = i;
      i = j;
      j = n;
      break;
      j = 0;
      i = 0;
      continue;
      j = 0;
      i = 0;
    }
  }
  
  public boolean isFaceFileExist(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    if (paramInt1 == 101) {}
    String str = getFaceBitmapCacheKey(paramInt1, paramString, (byte)3, paramInt2, paramInt3, false);
    checkAndInitAvatarCache();
    if ((this.mAvatarCache != null) && (this.mAvatarCache.a(str) != null)) {
      return true;
    }
    paramString = new File(getCustomFaceFilePath(paramInt1, paramString, paramInt2, paramInt3));
    boolean bool1 = bool2;
    if (paramString.exists())
    {
      bool1 = bool2;
      if (paramString.isFile()) {
        bool1 = true;
      }
    }
    return bool1;
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
      if (paramBitmap == null) {
        break label129;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.", 2, "getFaceBitmap decode success, faceType=" + paramInt1 + ", uin=" + paramString1 + ", shape=" + paramByte + ", headType=" + paramInt2 + ", path=" + paramString3 + ", bmp=" + paramBitmap);
      }
      putBitmapToCache(paramString2, paramBitmap, AvatarImplUtil.a(paramInt1));
      localBitmap = paramBitmap;
    }
    label129:
    do
    {
      do
      {
        return localBitmap;
        localBitmap = paramBitmap;
      } while (!QLog.isColorLevel());
      localBitmap = paramBitmap;
    } while (paramBitmapDecodeResult.a != 0);
    QLog.i("Q.qqhead.", 2, "getFaceBitmap decode shape fail, faceType=" + paramInt1 + ", uin=" + paramString1 + ", shape=" + paramByte + ", headType=" + paramInt2);
    return paramBitmap;
  }
  
  public void removeBitmapFromCache(String paramString)
  {
    checkAndInitAvatarCache();
    this.mAvatarCache.a(paramString);
  }
  
  public void removeFaceIconCache(int paramInt1, String paramString, int paramInt2)
  {
    int i = 0;
    paramString = getFaceBitmapCacheKey(paramInt1, paramString, (byte)0, paramInt2);
    paramInt1 = i;
    while (paramInt1 <= 5)
    {
      removeBitmapFromCache(paramString + "_" + paramInt1);
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
  
  public void updateSettingTableCache(Setting paramSetting)
  {
    if (paramSetting != null)
    {
      paramSetting = paramSetting.clone();
      if (paramSetting != null)
      {
        paramSetting.url = null;
        if (!TextUtils.isEmpty(paramSetting.uin))
        {
          checkAndCreateFaceSettingCache();
          this.mAvatarSettingCache.a(paramSetting.uin, paramSetting);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.impl.QQAvatarDataServiceImpl
 * JD-Core Version:    0.7.0.1
 */