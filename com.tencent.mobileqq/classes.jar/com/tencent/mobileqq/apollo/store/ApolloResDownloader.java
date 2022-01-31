package com.tencent.mobileqq.apollo.store;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.opengl.utils.IntArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.data.ApolloDress;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;
import yql;
import yqm;
import yqn;
import yqo;
import yqp;

public class ApolloResDownloader
{
  public static ConcurrentHashMap a;
  public static final int[] a;
  public static ConcurrentHashMap b;
  public static final int[] b;
  public static final int[] c;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 1, 2, 3, 4, 5, 6, 7 };
    jdField_b_of_type_ArrayOfInt = new int[] { 53, 54, 55, 56, 86, 87, 88 };
    c = new int[] { 91, 90, 63, 64, 65, 102, 103 };
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static String a(int paramInt)
  {
    Object localObject = new File(a(1, paramInt), "config.json");
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
  
  public static String a(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (paramInt1 == 1) {
      if (paramInt2 == 0) {
        localObject = ApolloConstant.b + "/def/role/0/";
      }
    }
    String str;
    do
    {
      return localObject;
      return ApolloConstant.f + paramInt2 + File.separator;
      if (paramInt1 == 2) {
        return ApolloConstant.e + paramInt2 + File.separator;
      }
      if (paramInt1 == 3) {
        return ApolloConstant.c + paramInt2 + File.separator;
      }
      if (paramInt1 == 4) {
        return ApolloConstant.d + paramInt2 + File.separator;
      }
      str = ApolloConstant.a + "/unknow/" + paramInt2 + File.separator;
      localObject = str;
    } while (!QLog.isColorLevel());
    QLog.d("ApolloResDownloader", 2, "getRealResFile unknow Type->" + paramInt1 + " id->" + paramInt2);
    return str;
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt1, int paramInt2)
  {
    Object localObject = new File(a(paramInt1, paramInt2), "config.json");
    if ((!((File)localObject).exists()) || (paramAppInterface == null)) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          localObject = new JSONObject(FileUtils.b((File)localObject));
          long l = ((JSONObject)localObject).optLong("version");
          paramAppInterface = (ApolloManager)paramAppInterface.getManager(152);
          if (paramAppInterface != null) {
            paramAppInterface.a(paramInt1, paramInt2, l);
          }
          if (paramInt1 == 1)
          {
            paramAppInterface = ((JSONObject)localObject).optJSONArray("dressIds");
            if ((paramAppInterface != null) && (paramAppInterface.length() > 0))
            {
              int i = paramAppInterface.length();
              localObject = new IntArray();
              paramInt1 = 0;
              while (paramInt1 < i)
              {
                ((IntArray)localObject).a(paramAppInterface.optInt(paramInt1));
                paramInt1 += 1;
              }
              jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt2), localObject);
              return;
            }
          }
        }
        catch (Exception paramAppInterface)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloResDownloader", 2, "saveResTimestamp ex!" + paramAppInterface.getMessage());
            return;
          }
        }
        catch (OutOfMemoryError paramAppInterface) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloResDownloader", 2, "saveResTimestamp oom!");
  }
  
  public static void a(AppInterface paramAppInterface, ApolloResDownloader.OnAudioDownloadListener paramOnAudioDownloadListener, int paramInt, boolean paramBoolean)
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
            localObject = new File(b(paramInt));
            if ((paramBoolean) || (!((File)localObject).exists())) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ApolloResDownloader", 2, "file exsit resType->4 id->" + paramInt);
            }
          } while (paramOnAudioDownloadListener == null);
          paramOnAudioDownloadListener.a(true, paramInt);
          return;
          str = b(4, paramInt);
          if (!TextUtils.isEmpty(str)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloResDownloader", 2, "downloadApolloRes url is empty resType->4 id->" + paramInt);
          }
        } while (paramOnAudioDownloadListener == null);
        paramOnAudioDownloadListener.a(false, paramInt);
        return;
        paramAppInterface = (DownloaderFactory)paramAppInterface.getManager(46);
        if (paramAppInterface != null) {
          break;
        }
      } while (paramOnAudioDownloadListener == null);
      paramOnAudioDownloadListener.a(false, paramInt);
      return;
      paramAppInterface = paramAppInterface.a(1);
      if (paramAppInterface != null) {
        break;
      }
    } while (paramOnAudioDownloadListener == null);
    paramOnAudioDownloadListener.a(false, paramInt);
    return;
    ((File)localObject).getParentFile().mkdirs();
    Object localObject = new DownloadTask(str, (File)localObject);
    ((DownloadTask)localObject).n = false;
    ((DownloadTask)localObject).l = true;
    ((DownloadTask)localObject).f = "apollo_res";
    ((DownloadTask)localObject).b = 1;
    ((DownloadTask)localObject).o = true;
    ((DownloadTask)localObject).p = true;
    paramAppInterface.a((DownloadTask)localObject, new yqo(paramInt, paramOnAudioDownloadListener), null);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, ApolloResDownloader.OnApolloDownLoadListener paramOnApolloDownLoadListener, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramInt1 >= 0) {
      b(paramAppInterface, paramString, new yql(paramAppInterface, paramArrayOfInt, paramOnApolloDownLoadListener, paramBoolean, paramInt1), paramInt1, null, paramInt2, paramInt3, paramBoolean);
    }
    while (paramAppInterface == null) {
      return;
    }
    b(paramAppInterface, paramString, paramOnApolloDownLoadListener, -1, paramArrayOfInt, paramInt2, paramInt3, paramBoolean);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramString1 = new File(paramString1);
    paramString1.getParentFile().mkdirs();
    paramString2 = new DownloadTask(paramString2, paramString1);
    paramString2.n = false;
    paramString2.l = true;
    paramString2.f = "apollo_res";
    paramString2.b = 1;
    paramString2.o = true;
    paramString2.p = true;
    ((DownloaderFactory)paramAppInterface.getManager(46)).a(1).a(paramString2, new yqn(paramString1), null);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, Bundle paramBundle, DownloadListener paramDownloadListener)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramString1 = new File(paramString1);
    paramString1.getParentFile().mkdirs();
    paramString1 = new DownloadTask(paramString2, paramString1);
    paramString1.n = false;
    paramString1.l = true;
    paramString1.f = "apollo_res";
    paramString1.b = 1;
    paramString1.o = true;
    paramString1.p = true;
    ((DownloaderFactory)paramAppInterface.getManager(46)).a(1).a(paramString1, paramDownloadListener, paramBundle);
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1;
    if (jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt))) {
      bool1 = ((Boolean)jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt))).booleanValue();
    }
    Object localObject;
    do
    {
      return bool1;
      localObject = new File(a(3, paramInt), "config.json");
      bool1 = bool2;
    } while (!((File)localObject).exists());
    for (;;)
    {
      try
      {
        localObject = new JSONObject(FileUtils.b((File)localObject)).optJSONObject("audio");
        if (localObject == null) {
          break label163;
        }
        bool1 = ((JSONObject)localObject).optBoolean("hasSound");
        jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), Boolean.valueOf(bool1));
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
      label163:
      bool1 = false;
    }
  }
  
  public static int[] a(int paramInt)
  {
    Object localObject4;
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt)))
    {
      localObject4 = ((IntArray)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt))).a(null);
      return localObject4;
    }
    for (;;)
    {
      try
      {
        Object localObject1 = new File(a(1, paramInt), "config.json");
        if (!((File)localObject1).exists()) {
          break label336;
        }
        localObject1 = new JSONObject(FileUtils.b((File)localObject1)).optJSONArray("dressIds");
        if ((localObject1 == null) || (((JSONArray)localObject1).length() <= 0)) {
          break label336;
        }
        int j = ((JSONArray)localObject1).length();
        localObject4 = new IntArray();
        int i = 0;
        if (i < j)
        {
          ((IntArray)localObject4).a(((JSONArray)localObject1).optInt(i));
          i += 1;
          continue;
        }
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localObject4);
        localObject1 = ((IntArray)localObject4).a(null);
        if (localObject1 != null)
        {
          localObject4 = localObject1;
          if (localObject1.length != 0) {
            break;
          }
        }
        if (paramInt == 1) {
          return jdField_b_of_type_ArrayOfInt;
        }
        if (2 == paramInt) {
          return c;
        }
        return jdField_a_of_type_ArrayOfInt;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloResDownloader", 2, "readRoleDefaultDressIds ex!" + localException.getMessage());
        }
        if ((0 != 0) && (null.length != 0)) {
          break label334;
        }
        if (paramInt == 1) {
          return jdField_b_of_type_ArrayOfInt;
        }
        if (2 == paramInt) {
          return c;
        }
        return jdField_a_of_type_ArrayOfInt;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloResDownloader", 2, "readRoleDefaultDressIds OOM!");
        }
        if ((0 != 0) && (null.length != 0)) {
          break label334;
        }
        if (paramInt == 1) {
          return jdField_b_of_type_ArrayOfInt;
        }
        if (2 == paramInt) {
          return c;
        }
        return jdField_a_of_type_ArrayOfInt;
      }
      finally
      {
        if ((0 == 0) || (null.length == 0))
        {
          if (paramInt != 1) {
            break label313;
          }
          localObject4 = jdField_b_of_type_ArrayOfInt;
        }
      }
      label313:
      if (2 == paramInt)
      {
        localObject4 = c;
      }
      else
      {
        localObject4 = jdField_a_of_type_ArrayOfInt;
        continue;
        label334:
        return null;
        label336:
        Object localObject3 = null;
      }
    }
  }
  
  public static String b(int paramInt)
  {
    return a(4, paramInt) + "music.amr";
  }
  
  public static String b(int paramInt1, int paramInt2)
  {
    String str = "";
    if (paramInt1 == 1) {
      str = "http://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_role_" + paramInt2 + "/d.zip";
    }
    do
    {
      return str;
      if (paramInt1 == 2) {
        return "http://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_item_" + paramInt2 + "/d.zip";
      }
      if (paramInt1 == 3) {
        return "http://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_action_" + paramInt2 + "/d.zip";
      }
      if (paramInt1 == 4) {
        return "http://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_common_data/apollo_audio_" + paramInt2 + ".amr";
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloResDownloader", 2, "getRealResUrl recognize Type->" + paramInt1 + " id->" + paramInt2);
    return "";
  }
  
  public static void b(AppInterface paramAppInterface, String paramString, ApolloResDownloader.OnApolloDownLoadListener paramOnApolloDownLoadListener, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramAppInterface == null)
    {
      if (paramOnApolloDownLoadListener != null) {
        paramOnApolloDownLoadListener.onDownLoadFinish(false, paramString, paramInt1, paramArrayOfInt, paramInt2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloRes null Parameters!");
      }
    }
    Object localObject2;
    label254:
    do
    {
      do
      {
        ArrayList localArrayList;
        Object localObject1;
        do
        {
          do
          {
            do
            {
              return;
              localArrayList = new ArrayList();
              localObject2 = (ApolloManager)paramAppInterface.getManager(152);
              if (localObject2 != null)
              {
                localObject1 = ((ApolloManager)localObject2).b(paramString);
                if (localObject1 != null) {
                  break label254;
                }
              }
              for (localObject1 = null;; localObject1 = ((ApolloBaseInfo)localObject1).getApolloPetDress())
              {
                if ((localObject1 != null) && (((ApolloDress)localObject1).jdField_a_of_type_Int >= 0) && (((ApolloManager)localObject2).a(1, ((ApolloDress)localObject1).jdField_a_of_type_Int) / 1000L != ((ApolloDress)localObject1).jdField_a_of_type_Long))
                {
                  QLog.i("ApolloPet", 1, "update pet role :" + ((ApolloDress)localObject1).jdField_a_of_type_Int + " to:" + ((ApolloDress)localObject1).jdField_a_of_type_Long);
                  localArrayList.add(new yqp(1, ((ApolloDress)localObject1).jdField_a_of_type_Int));
                }
                if (paramInt1 >= 0) {
                  localArrayList.add(new yqp(1, paramInt1));
                }
                if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {
                  break;
                }
                i = 0;
                while (i < paramArrayOfInt.length)
                {
                  localArrayList.add(new yqp(2, paramArrayOfInt[i]));
                  i += 1;
                }
              }
              if (paramInt2 > 0) {
                localArrayList.add(new yqp(3, paramInt2));
              }
              if (!localArrayList.isEmpty()) {
                break;
              }
            } while (paramOnApolloDownLoadListener == null);
            paramOnApolloDownLoadListener.onDownLoadFinish(false, paramString, paramInt1, paramArrayOfInt, paramInt2);
            return;
            localObject1 = (DownloaderFactory)paramAppInterface.getManager(46);
            if (localObject1 != null) {
              break;
            }
          } while (paramOnApolloDownLoadListener == null);
          paramOnApolloDownLoadListener.onDownLoadFinish(false, paramString, paramInt1, paramArrayOfInt, paramInt2);
          return;
          localObject1 = ((DownloaderFactory)localObject1).a(1);
          if (localObject1 != null) {
            break;
          }
        } while (paramOnApolloDownLoadListener == null);
        paramOnApolloDownLoadListener.onDownLoadFinish(false, paramString, paramInt1, paramArrayOfInt, paramInt2);
        return;
        localObject2 = new AtomicInteger(localArrayList.size());
        AtomicInteger localAtomicInteger1 = new AtomicInteger(0);
        AtomicInteger localAtomicInteger2 = new AtomicInteger(0);
        int j = localArrayList.size();
        int i = 0;
        if (i < j)
        {
          Object localObject3 = (yqp)localArrayList.get(i);
          int k = ((yqp)localObject3).jdField_a_of_type_Int;
          int m = ((yqp)localObject3).b;
          Object localObject4 = b(k, m);
          if (TextUtils.isEmpty((CharSequence)localObject4))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloResDownloader", 2, "downloadApolloRes url is empty resType->" + k + " id->" + m);
            }
            ((AtomicInteger)localObject2).decrementAndGet();
          }
          for (;;)
          {
            i += 1;
            break label428;
            if (!paramBoolean)
            {
              boolean bool = false;
              if (k == 1) {
                bool = ApolloUtil.c(m);
              }
              for (;;)
              {
                if (!bool) {
                  break label650;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloResDownloader", 2, "file exsit resType->" + k + " id->" + m);
                }
                ((AtomicInteger)localObject2).decrementAndGet();
                break;
                if (k == 2) {
                  bool = ApolloUtil.b(m);
                } else if (k == 3) {
                  bool = ApolloUtil.a(m, paramInt3);
                }
              }
              if (QLog.isColorLevel()) {
                QLog.d("ApolloResDownloader", 2, "file not exsit resType->" + k + " id->" + m);
              }
            }
            if (!NetworkUtil.g(paramAppInterface.getApplication()))
            {
              if (paramOnApolloDownLoadListener != null) {
                paramOnApolloDownLoadListener.onDownLoadFinish(false, paramString, paramInt1, paramArrayOfInt, paramInt2);
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("ApolloResDownloader", 2, "downloadApolloRes NetworkUtil.isNetworkAvailable is false!");
              return;
            }
            localObject3 = new File(a(k, m), "res.zip");
            ((File)localObject3).getParentFile().mkdirs();
            localObject4 = new DownloadTask((String)localObject4, (File)localObject3);
            ((DownloadTask)localObject4).n = false;
            ((DownloadTask)localObject4).l = true;
            ((DownloadTask)localObject4).f = "apollo_res";
            ((DownloadTask)localObject4).b = 1;
            ((DownloadTask)localObject4).o = true;
            ((DownloadTask)localObject4).p = true;
            ((DownloaderInterface)localObject1).a((DownloadTask)localObject4, new yqm((File)localObject3, paramAppInterface, k, m, localAtomicInteger2, localAtomicInteger1, (AtomicInteger)localObject2, paramOnApolloDownLoadListener, paramString, paramInt1, paramArrayOfInt, paramInt2), null);
          }
        }
      } while (((AtomicInteger)localObject2).get() != 0);
      if (paramOnApolloDownLoadListener != null) {
        paramOnApolloDownLoadListener.onDownLoadFinish(true, paramString, paramInt1, paramArrayOfInt, paramInt2);
      }
    } while (!QLog.isColorLevel());
    label428:
    QLog.d("ApolloResDownloader", 2, "downloadApolloRes local dress ok uin:" + paramString + ", all cnt: " + ((AtomicInteger)localObject2).get());
    label650:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloResDownloader
 * JD-Core Version:    0.7.0.1
 */