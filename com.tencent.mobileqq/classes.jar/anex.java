import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.data.ApolloDress;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

public class anex
{
  public static int a;
  public static ConcurrentHashMap<Integer, lsp> a;
  public static final int[] a;
  public static int b;
  public static ConcurrentHashMap<Integer, Boolean> b;
  public static final int[] b;
  public static int c;
  public static final int[] c;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 1, 2, 3, 4, 5, 6, 7 };
    jdField_b_of_type_ArrayOfInt = new int[] { 53, 54, 55, 56, 86, 87, 88 };
    jdField_c_of_type_ArrayOfInt = new int[] { 91, 90, 63, 64, 65, 102, 103 };
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_Int = -5011;
    jdField_b_of_type_Int = -5012;
    jdField_c_of_type_Int = -5013;
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
          localObject = new JSONObject(FileUtils.readFileToString((File)localObject)).optString("bubbleTips");
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
        localObject = anka.a + "/def/role/0/";
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
  
  static void a(amme paramamme, int paramInt1, int paramInt2)
  {
    Object localObject = new File(a(paramInt1, paramInt2), "config.json");
    if ((!((File)localObject).exists()) || (paramamme == null)) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          localObject = new JSONObject(FileUtils.readFileToString((File)localObject));
          paramamme.a(paramInt1, paramInt2, ((JSONObject)localObject).optLong("version"));
          if (paramInt1 == 1)
          {
            paramamme = ((JSONObject)localObject).optJSONArray("dressIds");
            if ((paramamme != null) && (paramamme.length() > 0))
            {
              int i = paramamme.length();
              localObject = new lsp();
              paramInt1 = 0;
              while (paramInt1 < i)
              {
                ((lsp)localObject).a(paramamme.optInt(paramInt1));
                paramInt1 += 1;
              }
              jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt2), localObject);
              return;
            }
          }
        }
        catch (Exception paramamme)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloResDownloader", 2, "saveResTimestamp ex!" + paramamme.getMessage());
            return;
          }
        }
        catch (OutOfMemoryError paramamme) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloResDownloader", 2, "saveResTimestamp oom!");
  }
  
  public static void a(AppInterface paramAppInterface, anfi paramanfi, int paramInt, boolean paramBoolean)
  {
    if ((paramAppInterface == null) || (!NetworkUtil.isNetworkAvailable(paramAppInterface.getApplication())))
    {
      if (paramanfi != null) {
        paramanfi.onDownloadFinish(false, paramInt);
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
          } while (paramanfi == null);
          paramanfi.onDownloadFinish(true, paramInt);
          return;
          str = b(4, paramInt);
          if (!TextUtils.isEmpty(str)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloResDownloader", 2, "downloadApolloRes url is empty resType->4 id->" + paramInt);
          }
        } while (paramanfi == null);
        paramanfi.onDownloadFinish(false, paramInt);
        return;
        paramAppInterface = (bhyq)paramAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY);
        if (paramAppInterface != null) {
          break;
        }
      } while (paramanfi == null);
      paramanfi.onDownloadFinish(false, paramInt);
      return;
      paramAppInterface = paramAppInterface.a(3);
      if (paramAppInterface != null) {
        break;
      }
    } while (paramanfi == null);
    paramanfi.onDownloadFinish(false, paramInt);
    return;
    ((File)localObject).getParentFile().mkdirs();
    Object localObject = new bhyo(str, (File)localObject);
    ((bhyo)localObject).p = true;
    ((bhyo)localObject).n = true;
    ((bhyo)localObject).f = "apollo_res";
    ((bhyo)localObject).jdField_b_of_type_Int = 1;
    ((bhyo)localObject).q = true;
    ((bhyo)localObject).r = true;
    paramAppInterface.a((bhyo)localObject, new anfe(paramInt, paramanfi), null);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, anfg paramanfg, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramInt1 >= 0) {
      if (paramAppInterface != null) {}
    }
    while (paramAppInterface == null)
    {
      return;
      b(paramAppInterface, paramString, new aney(paramArrayOfInt, (amme)paramAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER), paramInt1, paramAppInterface, paramanfg, paramBoolean), paramInt1, null, paramInt2, paramInt3, paramBoolean);
      return;
    }
    b(paramAppInterface, paramString, paramanfg, -1, paramArrayOfInt, paramInt2, paramInt3, paramBoolean);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, anfh paramanfh, List<anff> paramList, boolean paramBoolean)
  {
    amme localamme = (amme)paramAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER);
    Object localObject1;
    if (localamme != null)
    {
      localObject1 = localamme.b(paramString);
      if (localObject1 != null) {
        break label162;
      }
      localObject1 = null;
      if ((localObject1 != null) && (((ApolloDress)localObject1).jdField_a_of_type_Int >= 0) && (localamme.a(1, ((ApolloDress)localObject1).jdField_a_of_type_Int) / 1000L != ((ApolloDress)localObject1).jdField_a_of_type_Long))
      {
        QLog.i("ApolloPet", 1, "update pet role :" + ((ApolloDress)localObject1).jdField_a_of_type_Int + " to:" + ((ApolloDress)localObject1).jdField_a_of_type_Long);
        paramList.add(new anff(1, ((ApolloDress)localObject1).jdField_a_of_type_Int));
      }
    }
    if ((paramList == null) || (paramList.isEmpty())) {
      if (paramanfh != null) {
        paramanfh.a(false, paramString, paramList);
      }
    }
    label162:
    label203:
    do
    {
      do
      {
        return;
        localObject1 = ((ApolloBaseInfo)localObject1).getApolloPetDress();
        break;
        localObject1 = (bhyq)paramAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY);
        if (localObject1 != null) {
          break label203;
        }
      } while (paramanfh == null);
      paramanfh.a(false, paramString, paramList);
      return;
      localObject1 = ((bhyq)localObject1).a(3);
      if (localObject1 != null) {
        break label230;
      }
    } while (paramanfh == null);
    paramanfh.a(false, paramString, paramList);
    return;
    label230:
    AtomicInteger localAtomicInteger1 = new AtomicInteger(paramList.size());
    AtomicInteger localAtomicInteger2 = new AtomicInteger(0);
    AtomicInteger localAtomicInteger3 = new AtomicInteger(0);
    int j = paramList.size();
    int i = 0;
    Object localObject3;
    int k;
    int m;
    Object localObject2;
    label376:
    boolean bool;
    for (;;)
    {
      if (i < j)
      {
        localObject3 = (anff)paramList.get(i);
        k = ((anff)localObject3).jdField_a_of_type_Int;
        m = ((anff)localObject3).jdField_b_of_type_Int;
        localObject2 = b(k, m);
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
            bool = ApolloUtil.d(m);
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
        break label376;
        if (k == 2)
        {
          bool = ApolloUtil.c(m);
          continue;
        }
        if (k != 3) {
          break label780;
        }
        if ((ApolloUtil.a(m, ((anff)localObject3).jdField_c_of_type_Int)) || (ApolloUtil.b(m)))
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
      if (!NetworkUtil.isNetworkAvailable(paramAppInterface.getApplication()))
      {
        if (paramanfh != null) {
          paramanfh.a(false, paramString, paramList);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloResDownloader", 2, "downloadApolloRes NetworkUtil.isNetworkAvailable is false!");
        return;
      }
      localObject3 = new File(a(k, m), "res.zip");
      ((File)localObject3).getParentFile().mkdirs();
      localObject2 = new bhyo((String)localObject2, (File)localObject3);
      ((bhyo)localObject2).p = true;
      ((bhyo)localObject2).n = true;
      ((bhyo)localObject2).f = "apollo_res";
      ((bhyo)localObject2).jdField_b_of_type_Int = 1;
      ((bhyo)localObject2).q = true;
      ((bhyo)localObject2).r = true;
      ((bhyt)localObject1).a((bhyo)localObject2, new anfa((File)localObject3, localamme, k, m, localAtomicInteger3, localAtomicInteger2, localAtomicInteger1, paramanfh, paramString, paramList), null);
      break label376;
      if (localAtomicInteger1.get() != 0) {
        break;
      }
      if (paramanfh != null) {
        paramanfh.a(true, paramString, paramList);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloResDownloader", 2, "downloadApolloRes local dress ok uin:" + paramString + ", all cnt: " + localAtomicInteger1.get());
      return;
      label780:
      bool = false;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, anfj paramanfj)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
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
            if (paramanfj == null) {
              continue;
            }
            paramanfj.onDownloadFinish(true, 0);
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
        bhyo localbhyo = new bhyo(paramString, localFile);
        localbhyo.p = true;
        localbhyo.n = true;
        localbhyo.f = "apollo_res";
        localbhyo.jdField_b_of_type_Int = 1;
        localbhyo.q = true;
        localbhyo.r = true;
        ((bhyq)paramAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(3).a(localbhyo, new anfd(paramString, localFile, paramanfj), null);
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramString1 = new File(paramString1);
    paramString1.getParentFile().mkdirs();
    paramString2 = new bhyo(paramString2, paramString1);
    paramString2.p = true;
    paramString2.n = true;
    paramString2.f = "apollo_res";
    paramString2.jdField_b_of_type_Int = 1;
    paramString2.q = true;
    paramString2.r = true;
    ((bhyq)paramAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(3).a(paramString2, new anfc(paramString1), null);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, Bundle paramBundle, bhyn parambhyn)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramString1 = new File(paramString1);
    paramString1.getParentFile().mkdirs();
    paramString1 = new bhyo(paramString2, paramString1);
    paramString1.p = true;
    paramString1.n = true;
    paramString1.f = "apollo_res";
    paramString1.jdField_b_of_type_Int = 1;
    paramString1.q = true;
    paramString1.r = true;
    ((bhyq)paramAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(3).a(paramString1, parambhyn, paramBundle);
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
        localObject = new JSONObject(FileUtils.readFileToString((File)localObject)).optJSONObject("audio");
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
    Object localObject1 = null;
    Object localObject4 = null;
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt)))
    {
      localObject1 = (lsp)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
      if (localObject1 == null) {
        return null;
      }
      return ((lsp)localObject1).a(null);
    }
    for (;;)
    {
      try
      {
        Object localObject5 = new File(a(1, paramInt), "config.json");
        Object localObject3 = localObject4;
        if (((File)localObject5).exists())
        {
          localObject5 = new JSONObject(FileUtils.readFileToString((File)localObject5)).optJSONArray("dressIds");
          localObject3 = localObject4;
          if (localObject5 != null)
          {
            localObject3 = localObject4;
            if (((JSONArray)localObject5).length() > 0)
            {
              int j = ((JSONArray)localObject5).length();
              localObject3 = new lsp();
              int i = 0;
              if (i < j)
              {
                ((lsp)localObject3).a(((JSONArray)localObject5).optInt(i));
                i += 1;
                continue;
              }
              jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localObject3);
              localObject3 = ((lsp)localObject3).a(null);
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
          localObject1 = jdField_b_of_type_ArrayOfInt;
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
        localObject1 = jdField_b_of_type_ArrayOfInt;
        continue;
        if (2 != paramInt) {
          continue;
        }
        localObject1 = jdField_c_of_type_ArrayOfInt;
        continue;
        localObject1 = jdField_a_of_type_ArrayOfInt;
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
        localObject1 = jdField_b_of_type_ArrayOfInt;
        continue;
        if (2 != paramInt) {
          continue;
        }
        localObject1 = jdField_c_of_type_ArrayOfInt;
        continue;
        localObject1 = jdField_a_of_type_ArrayOfInt;
        continue;
      }
      finally
      {
        if ((0 != 0) && (null.length != 0)) {
          break label372;
        }
        if (paramInt != 1) {
          break label374;
        }
        arrayOfInt = jdField_b_of_type_ArrayOfInt;
      }
      return localObject1;
      if (2 == paramInt) {
        localObject1 = jdField_c_of_type_ArrayOfInt;
      } else {
        localObject1 = jdField_a_of_type_ArrayOfInt;
      }
    }
    for (;;)
    {
      int[] arrayOfInt;
      label372:
      throw localObject2;
      label374:
      if (2 == paramInt) {
        arrayOfInt = jdField_c_of_type_ArrayOfInt;
      } else {
        arrayOfInt = jdField_a_of_type_ArrayOfInt;
      }
    }
  }
  
  public static String b(int paramInt)
  {
    return a(4, paramInt) + "music.amr";
  }
  
  public static String b(int paramInt1, int paramInt2)
  {
    String str2 = "";
    String str1;
    if (paramInt2 > anka.jdField_b_of_type_Int)
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
  
  public static void b(AppInterface paramAppInterface, String paramString, anfg paramanfg, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramAppInterface == null)
    {
      if (paramanfg != null) {
        paramanfg.onDownLoadFinish(false, paramString, paramInt1, paramArrayOfInt, paramInt2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloRes null Parameters!");
      }
    }
    label254:
    AtomicInteger localAtomicInteger1;
    label429:
    do
    {
      do
      {
        ArrayList localArrayList;
        amme localamme;
        Object localObject1;
        do
        {
          do
          {
            do
            {
              return;
              localArrayList = new ArrayList();
              localamme = (amme)paramAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER);
              if (localamme != null)
              {
                localObject1 = localamme.b(paramString);
                if (localObject1 != null) {
                  break label254;
                }
              }
              for (localObject1 = null;; localObject1 = ((ApolloBaseInfo)localObject1).getApolloPetDress())
              {
                if ((localObject1 != null) && (((ApolloDress)localObject1).jdField_a_of_type_Int >= 0) && (localamme.a(1, ((ApolloDress)localObject1).jdField_a_of_type_Int) / 1000L != ((ApolloDress)localObject1).jdField_a_of_type_Long))
                {
                  QLog.i("ApolloPet", 1, "update pet role :" + ((ApolloDress)localObject1).jdField_a_of_type_Int + " to:" + ((ApolloDress)localObject1).jdField_a_of_type_Long);
                  localArrayList.add(new anff(1, ((ApolloDress)localObject1).jdField_a_of_type_Int));
                }
                if (paramInt1 >= 0) {
                  localArrayList.add(new anff(1, paramInt1));
                }
                if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {
                  break;
                }
                i = 0;
                while (i < paramArrayOfInt.length)
                {
                  localArrayList.add(new anff(2, paramArrayOfInt[i]));
                  i += 1;
                }
              }
              if (paramInt2 > 0) {
                localArrayList.add(new anff(3, paramInt2));
              }
              if (!localArrayList.isEmpty()) {
                break;
              }
            } while (paramanfg == null);
            paramanfg.onDownLoadFinish(false, paramString, paramInt1, paramArrayOfInt, paramInt2);
            return;
            localObject1 = (bhyq)paramAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY);
            if (localObject1 != null) {
              break;
            }
          } while (paramanfg == null);
          paramanfg.onDownLoadFinish(false, paramString, paramInt1, paramArrayOfInt, paramInt2);
          return;
          localObject1 = ((bhyq)localObject1).a(3);
          if (localObject1 != null) {
            break;
          }
        } while (paramanfg == null);
        paramanfg.onDownLoadFinish(false, paramString, paramInt1, paramArrayOfInt, paramInt2);
        return;
        localAtomicInteger1 = new AtomicInteger(localArrayList.size());
        AtomicInteger localAtomicInteger2 = new AtomicInteger(0);
        AtomicInteger localAtomicInteger3 = new AtomicInteger(0);
        int j = localArrayList.size();
        int i = 0;
        if (i < j)
        {
          Object localObject2 = (anff)localArrayList.get(i);
          int k = ((anff)localObject2).jdField_a_of_type_Int;
          int m = ((anff)localObject2).jdField_b_of_type_Int;
          Object localObject3 = b(k, m);
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
            break label429;
            if (!paramBoolean)
            {
              boolean bool = false;
              if (k == 1) {
                bool = ApolloUtil.d(m);
              }
              for (;;)
              {
                if (!bool) {
                  break label651;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloResDownloader", 2, "file exsit resType->" + k + " id->" + m);
                }
                localAtomicInteger1.decrementAndGet();
                break;
                if (k == 2) {
                  bool = ApolloUtil.c(m);
                } else if (k == 3) {
                  bool = ApolloUtil.a(m, paramInt3);
                }
              }
              if (QLog.isColorLevel()) {
                QLog.d("ApolloResDownloader", 2, "file not exsit resType->" + k + " id->" + m);
              }
            }
            if (!NetworkUtil.isNetworkAvailable(paramAppInterface.getApplication()))
            {
              if (paramanfg != null) {
                paramanfg.onDownLoadFinish(false, paramString, paramInt1, paramArrayOfInt, paramInt2);
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("ApolloResDownloader", 2, "downloadApolloRes NetworkUtil.isNetworkAvailable is false!");
              return;
            }
            localObject2 = new File(a(k, m), System.currentTimeMillis() + "res.zip");
            ((File)localObject2).getParentFile().mkdirs();
            localObject3 = new bhyo((String)localObject3, (File)localObject2);
            ((bhyo)localObject3).p = true;
            ((bhyo)localObject3).n = true;
            ((bhyo)localObject3).f = "apollo_res";
            ((bhyo)localObject3).jdField_b_of_type_Int = 1;
            ((bhyo)localObject3).q = true;
            ((bhyo)localObject3).r = true;
            ((bhyt)localObject1).a((bhyo)localObject3, new anfb((File)localObject2, localamme, k, m, localAtomicInteger3, localAtomicInteger2, localAtomicInteger1, paramanfg, paramString, paramInt1, paramArrayOfInt, paramInt2), null);
          }
        }
      } while (localAtomicInteger1.get() != 0);
      if (paramanfg != null) {
        paramanfg.onDownLoadFinish(true, paramString, paramInt1, paramArrayOfInt, paramInt2);
      }
    } while (!QLog.isColorLevel());
    label651:
    QLog.d("ApolloResDownloader", 2, "downloadApolloRes local dress ok uin:" + paramString + ", all cnt: " + localAtomicInteger1.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anex
 * JD-Core Version:    0.7.0.1
 */