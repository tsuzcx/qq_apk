import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.util.Pair;
import java.io.File;
import java.util.ArrayList;

public class angh
{
  public static Pair<Long, String> a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AROnlineVideoUtil", 2, "parseFileSize, str=" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      paramString = paramString.split("\\|");
      if ((paramString == null) || (paramString.length != 2)) {
        continue;
      }
      try
      {
        l = Long.parseLong(paramString[0]);
        if (l == -1L) {
          continue;
        }
        return new Pair(Long.valueOf(l), paramString[1]);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            localException.printStackTrace();
          }
          long l = -1L;
        }
      }
    }
  }
  
  private static String a()
  {
    if (bdep.a()) {
      return bdzf.a(alof.aX + "iar" + File.separator);
    }
    return BaseApplicationImpl.getApplication().getFilesDir() + File.separator + "iar" + File.separator;
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = bflr.d(paramString);
      paramString = a() + paramString;
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("AROnlineVideoUtil", 2, "getStorageDir, Exception");
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    boolean bool;
    if (bdin.b(BaseApplication.getContext()) == 1)
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("AROnlineVideoUtil", 2, "preload, isWifi=" + bool);
      }
      if (bool) {
        break label53;
      }
    }
    label53:
    Object localObject1;
    label127:
    Object localObject2;
    label157:
    label191:
    int i;
    label193:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                bool = false;
                break;
              } while (paramQQAppInterface == null);
              paramQQAppInterface = (amxm)paramQQAppInterface.getManager(168);
            } while (paramQQAppInterface == null);
            paramQQAppInterface = paramQQAppInterface.a();
          } while ((paramQQAppInterface == null) || (paramQQAppInterface.aREnd < NetConnInfoCenter.getServerTimeMillis()) || (paramQQAppInterface.mArCloudConfigInfos.size() == 0));
          localObject1 = TVK_SDKMgr.getProxyFactory();
          if (localObject1 != null) {
            break label127;
          }
        } while (!QLog.isColorLevel());
        QLog.d("AROnlineVideoUtil", 2, "preload, factory == null");
        return;
        localObject1 = ((TVK_IProxyFactory)localObject1).getCacheMgr(paramContext);
        if (localObject1 != null) {
          break label157;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AROnlineVideoUtil", 2, "preload, factory == null");
      return;
      localObject2 = new File(a());
      if ((!((File)localObject2).exists()) || (!((File)localObject2).isFile())) {
        break label271;
      }
      ((File)localObject2).delete();
      i = 0;
      if (i >= paramQQAppInterface.mArCloudConfigInfos.size()) {
        break label269;
      }
      localObject2 = (ArCloudConfigInfo)paramQQAppInterface.mArCloudConfigInfos.get(i);
    } while (localObject2 == null);
    if ((((ArCloudConfigInfo)localObject2).jdField_d_of_type_Int != 4) || ((((ArCloudConfigInfo)localObject2).a.size() < 1) && (!TextUtils.isEmpty(((ArVideoResourceInfo)((ArCloudConfigInfo)localObject2).a.get(0)).jdField_d_of_type_JavaLangString)))) {}
    for (;;)
    {
      i += 1;
      break label193;
      label269:
      break;
      label271:
      if (((File)localObject2).exists()) {
        break label191;
      }
      ((File)localObject2).mkdirs();
      break label191;
      localObject2 = ((ArVideoResourceInfo)((ArCloudConfigInfo)localObject2).a.get(0)).jdField_d_of_type_JavaLangString;
      String str = a((String)localObject2);
      bool = a(str);
      if (QLog.isColorLevel()) {
        QLog.d("AROnlineVideoUtil", 2, "preload, url=" + (String)localObject2 + ", videoPath=" + str + ", isCached=" + bool);
      }
      if (!bool)
      {
        TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
        localTVK_PlayerVideoInfo.setConfigMap("file_dir", str);
        localTVK_PlayerVideoInfo.setConfigMap("cache_duration", "60");
        localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", "20161009");
        localTVK_PlayerVideoInfo.setVid(bflr.d((String)localObject2));
        ((TVK_ICacheMgr)localObject1).preLoadVideoByUrl(paramContext, (String)localObject2, null, localTVK_PlayerVideoInfo);
      }
    }
  }
  
  public static void a(Context paramContext, ArVideoResourceInfo paramArVideoResourceInfo)
  {
    boolean bool = true;
    if ((paramArVideoResourceInfo == null) || (TextUtils.isEmpty(paramArVideoResourceInfo.jdField_d_of_type_JavaLangString)) || (paramArVideoResourceInfo.jdField_d_of_type_Int != 4)) {}
    label312:
    for (;;)
    {
      return;
      if (bdin.b(BaseApplication.getContext()) == 1) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AROnlineVideoUtil", 2, "preload for multi, isWifi=" + bool);
        }
        if (!bool) {
          break;
        }
        localObject1 = TVK_SDKMgr.getProxyFactory();
        if (localObject1 != null) {
          break label98;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AROnlineVideoUtil", 2, "preload for multi, factory == null");
        return;
        bool = false;
      }
      label98:
      Object localObject1 = ((TVK_IProxyFactory)localObject1).getCacheMgr(paramContext);
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AROnlineVideoUtil", 2, "preload for multi, factory == null");
        }
      }
      else
      {
        Object localObject2 = new File(a());
        if ((((File)localObject2).exists()) && (((File)localObject2).isFile())) {
          ((File)localObject2).delete();
        }
        for (;;)
        {
          if (TextUtils.isEmpty(paramArVideoResourceInfo.jdField_d_of_type_JavaLangString)) {
            break label312;
          }
          paramArVideoResourceInfo = paramArVideoResourceInfo.jdField_d_of_type_JavaLangString;
          localObject2 = a(paramArVideoResourceInfo);
          bool = a((String)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("AROnlineVideoUtil", 2, "preload for multi, url=" + paramArVideoResourceInfo + ", videoPath=" + (String)localObject2 + ", isCached=" + bool);
          }
          if (bool) {
            break;
          }
          TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
          localTVK_PlayerVideoInfo.setConfigMap("file_dir", (String)localObject2);
          localTVK_PlayerVideoInfo.setConfigMap("cache_duration", "60");
          localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", "20161009");
          localTVK_PlayerVideoInfo.setVid(bflr.d(paramArVideoResourceInfo));
          ((TVK_ICacheMgr)localObject1).preLoadVideoByUrl(paramContext, paramArVideoResourceInfo, null, localTVK_PlayerVideoInfo);
          return;
          if (!((File)localObject2).exists()) {
            ((File)localObject2).mkdirs();
          }
        }
      }
    }
  }
  
  private static boolean a(String paramString)
  {
    paramString = new File(paramString);
    return (paramString.exists()) && (paramString.length() > 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     angh
 * JD-Core Version:    0.7.0.1
 */