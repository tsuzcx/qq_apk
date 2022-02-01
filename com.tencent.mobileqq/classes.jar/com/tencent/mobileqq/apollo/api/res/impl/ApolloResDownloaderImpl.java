package com.tencent.mobileqq.apollo.api.res.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.opengl.utils.IntArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloDress;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader.OnAudioDownloadListener;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader.OnFaceDataDownloadListener;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApolloResDownloaderImpl
  implements IApolloResDownloader
{
  public static final int[] DEFAULT_DRESSIDS_ROLE0 = { 1, 2, 3, 4, 5, 6, 7 };
  public static final int[] DEFAULT_DRESSIDS_ROLE1 = { 53, 54, 55, 56, 86, 87, 88 };
  public static final int[] DEFAULT_DRESSIDS_ROLE2 = { 91, 90, 63, 64, 65, 102, 103 };
  public static int FACE_ERROR_CODE_DOWNLOAD_FAIL = -5013;
  public static int FACE_ERROR_CODE_UNZIP_FAIL = 0;
  public static int FACE_ERROR_CODE_ZIP_NOT_EXISTX = 0;
  private static final String TAG = "ApolloResDownloader";
  public static ConcurrentHashMap<Integer, Boolean> sActionSoundMap;
  public static ConcurrentHashMap<Integer, IntArray> sRoleDefaultDress = new ConcurrentHashMap();
  
  static
  {
    sActionSoundMap = new ConcurrentHashMap();
    FACE_ERROR_CODE_UNZIP_FAIL = -5011;
    FACE_ERROR_CODE_ZIP_NOT_EXISTX = -5012;
  }
  
  public static void downloadApolloResInner(AppInterface paramAppInterface, String paramString, ApolloResDownloaderImpl.OnApolloDownLoadListenerForTaskList paramOnApolloDownLoadListenerForTaskList, List<ApolloResDownloaderImpl.ApolloLoadResTask> paramList, boolean paramBoolean)
  {
    IApolloManagerService localIApolloManagerService = (IApolloManagerService)paramAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    Object localObject1;
    if (localIApolloManagerService != null)
    {
      localObject1 = localIApolloManagerService.getApolloBaseInfo(paramString);
      if (localObject1 != null) {
        break label164;
      }
      localObject1 = null;
      if ((localObject1 != null) && (((ApolloDress)localObject1).roleId >= 0) && (localIApolloManagerService.getApolloResLocalTimestamp(1, ((ApolloDress)localObject1).roleId) / 1000L != ((ApolloDress)localObject1).roleTimeStamp))
      {
        QLog.i("ApolloPet", 1, "update pet role :" + ((ApolloDress)localObject1).roleId + " to:" + ((ApolloDress)localObject1).roleTimeStamp);
        paramList.add(new ApolloResDownloaderImpl.ApolloLoadResTask(1, ((ApolloDress)localObject1).roleId));
      }
    }
    if ((paramList == null) || (paramList.isEmpty())) {
      if (paramOnApolloDownLoadListenerForTaskList != null) {
        paramOnApolloDownLoadListenerForTaskList.a(false, paramString, paramList);
      }
    }
    label164:
    label205:
    do
    {
      do
      {
        return;
        localObject1 = ((ApolloBaseInfo)localObject1).getApolloPetDress();
        break;
        localObject1 = (DownloaderFactory)paramAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY);
        if (localObject1 != null) {
          break label205;
        }
      } while (paramOnApolloDownLoadListenerForTaskList == null);
      paramOnApolloDownLoadListenerForTaskList.a(false, paramString, paramList);
      return;
      localObject1 = ((DownloaderFactory)localObject1).a(3);
      if (localObject1 != null) {
        break label232;
      }
    } while (paramOnApolloDownLoadListenerForTaskList == null);
    paramOnApolloDownLoadListenerForTaskList.a(false, paramString, paramList);
    return;
    label232:
    AtomicInteger localAtomicInteger1 = new AtomicInteger(paramList.size());
    AtomicInteger localAtomicInteger2 = new AtomicInteger(0);
    AtomicInteger localAtomicInteger3 = new AtomicInteger(0);
    int j = paramList.size();
    int i = 0;
    Object localObject3;
    int k;
    int m;
    Object localObject2;
    label377:
    boolean bool;
    for (;;)
    {
      if (i < j)
      {
        localObject3 = (ApolloResDownloaderImpl.ApolloLoadResTask)paramList.get(i);
        k = ((ApolloResDownloaderImpl.ApolloLoadResTask)localObject3).a;
        m = ((ApolloResDownloaderImpl.ApolloLoadResTask)localObject3).b;
        localObject2 = getRealResUrl(k, m);
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloResDownloader", 2, "downloadApolloRes url is empty resType->" + k + " id->" + m);
          }
          localAtomicInteger1.decrementAndGet();
          i += 1;
        }
        else if (!paramBoolean)
        {
          if (k == 1) {
            bool = ApolloUtilImpl.checkRoleRes(m);
          }
        }
      }
    }
    for (;;)
    {
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloResDownloader", 2, "file exsit resType->" + k + " id->" + m);
        }
        localAtomicInteger1.decrementAndGet();
        break label377;
        if (k == 2)
        {
          bool = ApolloUtilImpl.checkDressRes(m);
          continue;
        }
        if (k != 3) {
          break label778;
        }
        if ((ApolloUtilImpl.isActionResDone(m, ((ApolloResDownloaderImpl.ApolloLoadResTask)localObject3).c)) || (ApolloUtilImpl.isQzoneActionRscDone(m)))
        {
          bool = true;
          continue;
        }
        bool = false;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "file not exsit resType->" + k + " id->" + m);
      }
      if (!NetworkUtil.g(paramAppInterface.getApplication()))
      {
        if (paramOnApolloDownLoadListenerForTaskList != null) {
          paramOnApolloDownLoadListenerForTaskList.a(false, paramString, paramList);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloResDownloader", 2, "downloadApolloRes NetworkUtil.isNetworkAvailable is false!");
        return;
      }
      localObject3 = new File(getRealResDir(k, m), "res.zip");
      ((File)localObject3).getParentFile().mkdirs();
      localObject2 = new DownloadTask((String)localObject2, (File)localObject3);
      ((DownloadTask)localObject2).p = true;
      ((DownloadTask)localObject2).n = true;
      ((DownloadTask)localObject2).f = "apollo_res";
      ((DownloadTask)localObject2).b = 1;
      ((DownloadTask)localObject2).q = true;
      ((DownloadTask)localObject2).r = true;
      ((DownloaderInterface)localObject1).a((DownloadTask)localObject2, new ApolloResDownloaderImpl.2((File)localObject3, localIApolloManagerService, k, m, localAtomicInteger3, localAtomicInteger2, localAtomicInteger1, paramOnApolloDownLoadListenerForTaskList, paramString, paramList), null);
      break label377;
      if (localAtomicInteger1.get() != 0) {
        break;
      }
      if (paramOnApolloDownLoadListenerForTaskList != null) {
        paramOnApolloDownLoadListenerForTaskList.a(true, paramString, paramList);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloResDownloader", 2, "downloadApolloRes local dress ok uin:" + paramString + ", all cnt: " + localAtomicInteger1.get());
      return;
      label778:
      bool = false;
    }
  }
  
  public static String getRealResDir(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (paramInt1 == 1) {
      if (paramInt2 == 0) {
        localObject = ApolloConstant.a + "/def/role/0/";
      }
    }
    String str;
    do
    {
      return localObject;
      return "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/" + paramInt2 + File.separator;
      if (paramInt1 == 2) {
        return "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/" + paramInt2 + File.separator;
      }
      if (paramInt1 == 3) {
        return "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/" + paramInt2 + File.separator;
      }
      if (paramInt1 == 4) {
        return "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/audio/" + paramInt2 + File.separator;
      }
      str = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/unknow/" + paramInt2 + File.separator;
      localObject = str;
    } while (!QLog.isColorLevel());
    QLog.d("ApolloResDownloader", 2, "getRealResFile unknow Type->" + paramInt1 + " id->" + paramInt2);
    return str;
  }
  
  public static String getRealResUrl(int paramInt1, int paramInt2)
  {
    String str2 = "";
    String str1;
    if (paramInt2 > ApolloConstant.b)
    {
      str1 = "/android.zip";
      if (paramInt1 != 1) {
        break label54;
      }
      str1 = "https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_role_" + paramInt2 + str1;
    }
    label54:
    do
    {
      return str1;
      str1 = "/d.zip";
      break;
      if (paramInt1 == 2) {
        return "https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_item_" + paramInt2 + str1;
      }
      if (paramInt1 == 3) {
        return "https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_action_" + paramInt2 + "/d.zip";
      }
      if (paramInt1 == 4) {
        return "https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_common_data/apollo_audio_" + paramInt2 + ".amr";
      }
      str1 = str2;
    } while (!QLog.isColorLevel());
    QLog.d("ApolloResDownloader", 2, "getRealResUrl recognize Type->" + paramInt1 + " id->" + paramInt2);
    return "";
  }
  
  public static boolean hasSound(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1;
    if (sActionSoundMap.containsKey(Integer.valueOf(paramInt))) {
      bool1 = ((Boolean)sActionSoundMap.get(Integer.valueOf(paramInt))).booleanValue();
    }
    Object localObject;
    do
    {
      return bool1;
      localObject = new File(getRealResDir(3, paramInt), "config.json");
      bool1 = bool2;
    } while (!((File)localObject).exists());
    for (;;)
    {
      try
      {
        localObject = new JSONObject(FileUtils.b((File)localObject)).optJSONObject("audio");
        if (localObject == null) {
          break label166;
        }
        bool1 = ((JSONObject)localObject).optBoolean("hasSound");
        sActionSoundMap.put(Integer.valueOf(paramInt), Boolean.valueOf(bool1));
        return bool1;
      }
      catch (Exception localException)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloResDownloader", 2, "saveResTimestamp ex!" + localException.getMessage());
        return false;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        bool1 = bool2;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloResDownloader", 2, "saveResTimestamp OOM!");
      return false;
      label166:
      bool1 = false;
    }
  }
  
  public static String readRoleBubbleTips(int paramInt)
  {
    Object localObject = new File(getRealResDir(1, paramInt), "config.json");
    if (!((File)localObject).exists()) {}
    do
    {
      for (;;)
      {
        return null;
        try
        {
          localObject = new JSONObject(FileUtils.b((File)localObject)).optString("bubbleTips");
          return localObject;
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloResDownloader", 2, "saveResTimestamp ex!" + localException.getMessage());
            return null;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloResDownloader", 2, "saveResTimestamp OOM!");
    return null;
  }
  
  static void saveResTimestamp(IApolloManagerService paramIApolloManagerService, int paramInt1, int paramInt2)
  {
    Object localObject = new File(getRealResDir(paramInt1, paramInt2), "config.json");
    if ((!((File)localObject).exists()) || (paramIApolloManagerService == null)) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          localObject = new JSONObject(FileUtils.b((File)localObject));
          long l = ((JSONObject)localObject).optLong("version");
          ((ApolloManagerServiceImpl)paramIApolloManagerService).saveApolloResLocalTimestamp(paramInt1, paramInt2, l);
          if (paramInt1 == 1)
          {
            paramIApolloManagerService = ((JSONObject)localObject).optJSONArray("dressIds");
            if ((paramIApolloManagerService != null) && (paramIApolloManagerService.length() > 0))
            {
              int i = paramIApolloManagerService.length();
              localObject = new IntArray();
              paramInt1 = 0;
              while (paramInt1 < i)
              {
                ((IntArray)localObject).a(paramIApolloManagerService.optInt(paramInt1));
                paramInt1 += 1;
              }
              sRoleDefaultDress.put(Integer.valueOf(paramInt2), localObject);
              return;
            }
          }
        }
        catch (Exception paramIApolloManagerService)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloResDownloader", 2, "saveResTimestamp ex!" + paramIApolloManagerService.getMessage());
            return;
          }
        }
        catch (OutOfMemoryError paramIApolloManagerService) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloResDownloader", 2, "saveResTimestamp oom!");
  }
  
  public void checkDownloadFaceData(AppRuntime paramAppRuntime, String paramString, IApolloResDownloader.OnFaceDataDownloadListener paramOnFaceDataDownloadListener)
  {
    if ((paramAppRuntime == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = MD5Utils.toMD5(paramString);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/").mkdir();
          new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress//face/").mkdir();
          localObject = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress//face/" + (String)localObject + File.separator + (String)localObject + ".zip");
          if (((File)localObject).exists())
          {
            QLog.i("ApolloResDownloader", 1, "checkDownloadFaceData url data is exists:" + paramString);
            if (paramOnFaceDataDownloadListener == null) {
              continue;
            }
            paramOnFaceDataDownloadListener.a(true, 0);
          }
        }
      }
      catch (Exception localException)
      {
        File localFile;
        for (;;)
        {
          QLog.e("ApolloResDownloader", 1, "checkDownloadFaceData e" + localException);
          localFile = null;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData url:" + paramString);
        }
        localFile.getParentFile().mkdir();
        DownloadTask localDownloadTask = new DownloadTask(paramString, localFile);
        localDownloadTask.p = true;
        localDownloadTask.n = true;
        localDownloadTask.f = "apollo_res";
        localDownloadTask.b = 1;
        localDownloadTask.q = true;
        localDownloadTask.r = true;
        ((DownloaderFactory)paramAppRuntime.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(3).a(localDownloadTask, new ApolloResDownloaderImpl.5(this, paramString, localFile, paramOnFaceDataDownloadListener), null);
      }
    }
  }
  
  public void downLoadCmshowRes(AppRuntime paramAppRuntime, String paramString1, String paramString2, Bundle paramBundle, DownloadListener paramDownloadListener)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramString1 = new File(paramString1);
    paramString1.getParentFile().mkdirs();
    paramString1 = new DownloadTask(paramString2, paramString1);
    paramString1.p = true;
    paramString1.n = true;
    paramString1.f = "apollo_res";
    paramString1.b = 1;
    paramString1.q = true;
    paramString1.r = true;
    ((DownloaderFactory)paramAppRuntime.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(3).a(paramString1, paramDownloadListener, paramBundle);
  }
  
  public void downLoadSpecialAction(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramString1 = new File(paramString1);
    paramString1.getParentFile().mkdirs();
    paramString2 = new DownloadTask(paramString2, paramString1);
    paramString2.p = true;
    paramString2.n = true;
    paramString2.f = "apollo_res";
    paramString2.b = 1;
    paramString2.q = true;
    paramString2.r = true;
    ((DownloaderFactory)paramAppRuntime.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(3).a(paramString2, new ApolloResDownloaderImpl.4(this, paramString1), null);
  }
  
  public void downloadApolloAudio(AppInterface paramAppInterface, IApolloResDownloader.OnAudioDownloadListener paramOnAudioDownloadListener, int paramInt, boolean paramBoolean)
  {
    if ((paramAppInterface == null) || (!NetworkUtil.g(paramAppInterface.getApplication())))
    {
      if (paramOnAudioDownloadListener != null) {
        paramOnAudioDownloadListener.a(false, paramInt);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloRes null Parameters!");
      }
    }
    String str;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject = new File(getAudioFilePath(paramInt));
            if ((paramBoolean) || (!((File)localObject).exists())) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ApolloResDownloader", 2, "file exsit resType->4 id->" + paramInt);
            }
          } while (paramOnAudioDownloadListener == null);
          paramOnAudioDownloadListener.a(true, paramInt);
          return;
          str = getRealResUrl(4, paramInt);
          if (!TextUtils.isEmpty(str)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloResDownloader", 2, "downloadApolloRes url is empty resType->4 id->" + paramInt);
          }
        } while (paramOnAudioDownloadListener == null);
        paramOnAudioDownloadListener.a(false, paramInt);
        return;
        paramAppInterface = (DownloaderFactory)paramAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY);
        if (paramAppInterface != null) {
          break;
        }
      } while (paramOnAudioDownloadListener == null);
      paramOnAudioDownloadListener.a(false, paramInt);
      return;
      paramAppInterface = paramAppInterface.a(3);
      if (paramAppInterface != null) {
        break;
      }
    } while (paramOnAudioDownloadListener == null);
    paramOnAudioDownloadListener.a(false, paramInt);
    return;
    ((File)localObject).getParentFile().mkdirs();
    Object localObject = new DownloadTask(str, (File)localObject);
    ((DownloadTask)localObject).p = true;
    ((DownloadTask)localObject).n = true;
    ((DownloadTask)localObject).f = "apollo_res";
    ((DownloadTask)localObject).b = 1;
    ((DownloadTask)localObject).q = true;
    ((DownloadTask)localObject).r = true;
    paramAppInterface.a((DownloadTask)localObject, new ApolloResDownloaderImpl.6(this, paramInt, paramOnAudioDownloadListener), null);
  }
  
  public void downloadApolloRes(AppRuntime paramAppRuntime, String paramString, IApolloResDownloader.OnApolloDownLoadListener paramOnApolloDownLoadListener, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramAppRuntime == null)
    {
      if (paramOnApolloDownLoadListener != null) {
        paramOnApolloDownLoadListener.a(false, paramString, paramInt1, paramArrayOfInt, paramInt2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloRes null Parameters!");
      }
    }
    label260:
    AtomicInteger localAtomicInteger1;
    label438:
    do
    {
      do
      {
        ArrayList localArrayList;
        IApolloManagerService localIApolloManagerService;
        Object localObject1;
        do
        {
          do
          {
            do
            {
              return;
              localArrayList = new ArrayList();
              localIApolloManagerService = (IApolloManagerService)paramAppRuntime.getRuntimeService(IApolloManagerService.class, "all");
              if (localIApolloManagerService != null)
              {
                localObject1 = localIApolloManagerService.getApolloBaseInfo(paramString);
                if (localObject1 != null) {
                  break label260;
                }
              }
              for (localObject1 = null;; localObject1 = ((ApolloBaseInfo)localObject1).getApolloPetDress())
              {
                if ((localObject1 != null) && (((ApolloDress)localObject1).roleId >= 0) && (localIApolloManagerService.getApolloResLocalTimestamp(1, ((ApolloDress)localObject1).roleId) / 1000L != ((ApolloDress)localObject1).roleTimeStamp))
                {
                  QLog.i("ApolloPet", 1, "update pet role :" + ((ApolloDress)localObject1).roleId + " to:" + ((ApolloDress)localObject1).roleTimeStamp);
                  localArrayList.add(new ApolloResDownloaderImpl.ApolloLoadResTask(1, ((ApolloDress)localObject1).roleId));
                }
                if (paramInt1 >= 0) {
                  localArrayList.add(new ApolloResDownloaderImpl.ApolloLoadResTask(1, paramInt1));
                }
                if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {
                  break;
                }
                i = 0;
                while (i < paramArrayOfInt.length)
                {
                  localArrayList.add(new ApolloResDownloaderImpl.ApolloLoadResTask(2, paramArrayOfInt[i]));
                  i += 1;
                }
              }
              if (paramInt2 > 0) {
                localArrayList.add(new ApolloResDownloaderImpl.ApolloLoadResTask(3, paramInt2));
              }
              if (!localArrayList.isEmpty()) {
                break;
              }
            } while (paramOnApolloDownLoadListener == null);
            paramOnApolloDownLoadListener.a(false, paramString, paramInt1, paramArrayOfInt, paramInt2);
            return;
            localObject1 = (DownloaderFactory)paramAppRuntime.getManager(QQManagerFactory.DOWNLOADER_FACTORY);
            if (localObject1 != null) {
              break;
            }
          } while (paramOnApolloDownLoadListener == null);
          paramOnApolloDownLoadListener.a(false, paramString, paramInt1, paramArrayOfInt, paramInt2);
          return;
          localObject1 = ((DownloaderFactory)localObject1).a(3);
          if (localObject1 != null) {
            break;
          }
        } while (paramOnApolloDownLoadListener == null);
        paramOnApolloDownLoadListener.a(false, paramString, paramInt1, paramArrayOfInt, paramInt2);
        return;
        localAtomicInteger1 = new AtomicInteger(localArrayList.size());
        AtomicInteger localAtomicInteger2 = new AtomicInteger(0);
        AtomicInteger localAtomicInteger3 = new AtomicInteger(0);
        int j = localArrayList.size();
        int i = 0;
        if (i < j)
        {
          Object localObject2 = (ApolloResDownloaderImpl.ApolloLoadResTask)localArrayList.get(i);
          int k = ((ApolloResDownloaderImpl.ApolloLoadResTask)localObject2).a;
          int m = ((ApolloResDownloaderImpl.ApolloLoadResTask)localObject2).b;
          Object localObject3 = getRealResUrl(k, m);
          if (TextUtils.isEmpty((CharSequence)localObject3))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloResDownloader", 2, "downloadApolloRes url is empty resType->" + k + " id->" + m);
            }
            localAtomicInteger1.decrementAndGet();
          }
          for (;;)
          {
            i += 1;
            break label438;
            if (!paramBoolean)
            {
              boolean bool = false;
              if (k == 1) {
                bool = ApolloUtilImpl.checkRoleRes(m);
              }
              for (;;)
              {
                if (!bool) {
                  break label658;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloResDownloader", 2, "file exsit resType->" + k + " id->" + m);
                }
                localAtomicInteger1.decrementAndGet();
                break;
                if (k == 2) {
                  bool = ApolloUtilImpl.checkDressRes(m);
                } else if (k == 3) {
                  bool = ApolloUtilImpl.isActionResDone(m, paramInt3);
                }
              }
              if (QLog.isColorLevel()) {
                QLog.d("ApolloResDownloader", 2, "file not exsit resType->" + k + " id->" + m);
              }
            }
            if (!NetworkUtil.g(paramAppRuntime.getApplication()))
            {
              if (paramOnApolloDownLoadListener != null) {
                paramOnApolloDownLoadListener.a(false, paramString, paramInt1, paramArrayOfInt, paramInt2);
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("ApolloResDownloader", 2, "downloadApolloRes NetworkUtil.isNetworkAvailable is false!");
              return;
            }
            localObject2 = new File(getRealResDir(k, m), System.currentTimeMillis() + "res.zip");
            ((File)localObject2).getParentFile().mkdirs();
            localObject3 = new DownloadTask((String)localObject3, (File)localObject2);
            ((DownloadTask)localObject3).p = true;
            ((DownloadTask)localObject3).n = true;
            ((DownloadTask)localObject3).f = "apollo_res";
            ((DownloadTask)localObject3).b = 1;
            ((DownloadTask)localObject3).q = true;
            ((DownloadTask)localObject3).r = true;
            ((DownloaderInterface)localObject1).a((DownloadTask)localObject3, new ApolloResDownloaderImpl.3(this, (File)localObject2, localIApolloManagerService, k, m, localAtomicInteger3, localAtomicInteger2, localAtomicInteger1, paramOnApolloDownLoadListener, paramString, paramInt1, paramArrayOfInt, paramInt2), null);
          }
        }
      } while (localAtomicInteger1.get() != 0);
      if (paramOnApolloDownLoadListener != null) {
        paramOnApolloDownLoadListener.a(true, paramString, paramInt1, paramArrayOfInt, paramInt2);
      }
    } while (!QLog.isColorLevel());
    label658:
    QLog.d("ApolloResDownloader", 2, "downloadApolloRes local dress ok uin:" + paramString + ", all cnt: " + localAtomicInteger1.get());
  }
  
  public void downloadApolloResOrder(AppRuntime paramAppRuntime, String paramString, IApolloResDownloader.OnApolloDownLoadListener paramOnApolloDownLoadListener, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramInt1 >= 0) {
      if (paramAppRuntime != null) {}
    }
    while (paramAppRuntime == null)
    {
      return;
      downloadApolloRes(paramAppRuntime, paramString, new ApolloResDownloaderImpl.1(this, paramArrayOfInt, (ApolloManagerServiceImpl)paramAppRuntime.getRuntimeService(IApolloManagerService.class, "all"), paramInt1, paramAppRuntime, paramOnApolloDownLoadListener, paramBoolean), paramInt1, null, paramInt2, paramInt3, paramBoolean);
      return;
    }
    downloadApolloRes(paramAppRuntime, paramString, paramOnApolloDownLoadListener, -1, paramArrayOfInt, paramInt2, paramInt3, paramBoolean);
  }
  
  public String getAudioFilePath(int paramInt)
  {
    return getRealResDir(4, paramInt) + "music.amr";
  }
  
  public int[] readRoleDefaultDressIds(int paramInt)
  {
    Object localObject1 = null;
    Object localObject4 = null;
    if (sRoleDefaultDress.containsKey(Integer.valueOf(paramInt)))
    {
      localObject1 = (IntArray)sRoleDefaultDress.get(Integer.valueOf(paramInt));
      if (localObject1 == null) {
        return null;
      }
      return ((IntArray)localObject1).a(null);
    }
    for (;;)
    {
      try
      {
        Object localObject5 = new File(getRealResDir(1, paramInt), "config.json");
        Object localObject3 = localObject4;
        if (((File)localObject5).exists())
        {
          localObject5 = new JSONObject(FileUtils.b((File)localObject5)).optJSONArray("dressIds");
          localObject3 = localObject4;
          if (localObject5 != null)
          {
            localObject3 = localObject4;
            if (((JSONArray)localObject5).length() > 0)
            {
              int j = ((JSONArray)localObject5).length();
              localObject3 = new IntArray();
              int i = 0;
              if (i < j)
              {
                ((IntArray)localObject3).a(((JSONArray)localObject5).optInt(i));
                i += 1;
                continue;
              }
              sRoleDefaultDress.put(Integer.valueOf(paramInt), localObject3);
              localObject3 = ((IntArray)localObject3).a(null);
            }
          }
        }
        if (localObject3 != null)
        {
          localObject1 = localObject3;
          if (localObject3.length != 0) {}
        }
        else
        {
          if (paramInt != 1) {
            continue;
          }
          localObject1 = DEFAULT_DRESSIDS_ROLE1;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloResDownloader", 2, "readRoleDefaultDressIds ex!" + localException.getMessage());
        if ((0 != 0) && (null.length != 0)) {
          continue;
        }
        if (paramInt != 1) {
          continue;
        }
        localObject1 = DEFAULT_DRESSIDS_ROLE1;
        continue;
        if (2 != paramInt) {
          continue;
        }
        localObject1 = DEFAULT_DRESSIDS_ROLE2;
        continue;
        localObject1 = DEFAULT_DRESSIDS_ROLE0;
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloResDownloader", 2, "readRoleDefaultDressIds OOM!");
        if ((0 != 0) && (null.length != 0)) {
          continue;
        }
        if (paramInt != 1) {
          continue;
        }
        localObject1 = DEFAULT_DRESSIDS_ROLE1;
        continue;
        if (2 != paramInt) {
          continue;
        }
        localObject1 = DEFAULT_DRESSIDS_ROLE2;
        continue;
        localObject1 = DEFAULT_DRESSIDS_ROLE0;
        continue;
      }
      finally
      {
        if ((0 != 0) && (null.length != 0)) {
          break label390;
        }
        if (paramInt != 1) {
          break label393;
        }
        arrayOfInt = DEFAULT_DRESSIDS_ROLE1;
      }
      return localObject1;
      if (2 == paramInt) {
        localObject1 = DEFAULT_DRESSIDS_ROLE2;
      } else {
        localObject1 = DEFAULT_DRESSIDS_ROLE0;
      }
    }
    for (;;)
    {
      int[] arrayOfInt;
      label390:
      throw localObject2;
      label393:
      if (2 == paramInt) {
        arrayOfInt = DEFAULT_DRESSIDS_ROLE2;
      } else {
        arrayOfInt = DEFAULT_DRESSIDS_ROLE0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.res.impl.ApolloResDownloaderImpl
 * JD-Core Version:    0.7.0.1
 */