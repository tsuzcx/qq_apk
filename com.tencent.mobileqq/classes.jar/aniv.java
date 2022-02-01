import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

public class aniv
{
  public static ConcurrentHashMap<Integer, lsu> a;
  public static final int[] a;
  public static ConcurrentHashMap<Integer, Boolean> b;
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
          localObject = new JSONObject(bhmi.b((File)localObject)).optString("bubbleTips");
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
        localObject = annv.c + "/def/role/0/";
      }
    }
    String str;
    do
    {
      return localObject;
      return annv.g + paramInt2 + File.separator;
      if (paramInt1 == 2) {
        return annv.f + paramInt2 + File.separator;
      }
      if (paramInt1 == 3) {
        return annv.d + paramInt2 + File.separator;
      }
      if (paramInt1 == 4) {
        return annv.e + paramInt2 + File.separator;
      }
      str = annv.jdField_a_of_type_JavaLangString + "/unknow/" + paramInt2 + File.separator;
      localObject = str;
    } while (!QLog.isColorLevel());
    QLog.d("ApolloResDownloader", 2, "getRealResFile unknow Type->" + paramInt1 + " id->" + paramInt2);
    return str;
  }
  
  static void a(amsx paramamsx, int paramInt1, int paramInt2)
  {
    Object localObject = new File(a(paramInt1, paramInt2), "config.json");
    if ((!((File)localObject).exists()) || (paramamsx == null)) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          localObject = new JSONObject(bhmi.b((File)localObject));
          paramamsx.a(paramInt1, paramInt2, ((JSONObject)localObject).optLong("version"));
          if (paramInt1 == 1)
          {
            paramamsx = ((JSONObject)localObject).optJSONArray("dressIds");
            if ((paramamsx != null) && (paramamsx.length() > 0))
            {
              int i = paramamsx.length();
              localObject = new lsu();
              paramInt1 = 0;
              while (paramInt1 < i)
              {
                ((lsu)localObject).a(paramamsx.optInt(paramInt1));
                paramInt1 += 1;
              }
              jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt2), localObject);
              return;
            }
          }
        }
        catch (Exception paramamsx)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloResDownloader", 2, "saveResTimestamp ex!" + paramamsx.getMessage());
            return;
          }
        }
        catch (OutOfMemoryError paramamsx) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloResDownloader", 2, "saveResTimestamp oom!");
  }
  
  public static void a(AppInterface paramAppInterface, anjg paramanjg, int paramInt, boolean paramBoolean)
  {
    if ((paramAppInterface == null) || (!bhnv.g(paramAppInterface.getApplication())))
    {
      if (paramanjg != null) {
        paramanjg.a(false, paramInt);
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
          } while (paramanjg == null);
          paramanjg.a(true, paramInt);
          return;
          str = b(4, paramInt);
          if (!TextUtils.isEmpty(str)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloResDownloader", 2, "downloadApolloRes url is empty resType->4 id->" + paramInt);
          }
        } while (paramanjg == null);
        paramanjg.a(false, paramInt);
        return;
        paramAppInterface = (bihw)paramAppInterface.getManager(47);
        if (paramAppInterface != null) {
          break;
        }
      } while (paramanjg == null);
      paramanjg.a(false, paramInt);
      return;
      paramAppInterface = paramAppInterface.a(3);
      if (paramAppInterface != null) {
        break;
      }
    } while (paramanjg == null);
    paramanjg.a(false, paramInt);
    return;
    ((File)localObject).getParentFile().mkdirs();
    Object localObject = new bihu(str, (File)localObject);
    ((bihu)localObject).p = true;
    ((bihu)localObject).n = true;
    ((bihu)localObject).f = "apollo_res";
    ((bihu)localObject).b = 1;
    ((bihu)localObject).q = true;
    ((bihu)localObject).r = true;
    paramAppInterface.a((bihu)localObject, new anjc(paramInt, paramanjg), null);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, anje paramanje, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramInt1 >= 0) {
      if (paramAppInterface != null) {}
    }
    while (paramAppInterface == null)
    {
      return;
      b(paramAppInterface, paramString, new aniw(paramArrayOfInt, (amsx)paramAppInterface.getManager(153), paramInt1, paramAppInterface, paramanje, paramBoolean), paramInt1, null, paramInt2, paramInt3, paramBoolean);
      return;
    }
    b(paramAppInterface, paramString, paramanje, -1, paramArrayOfInt, paramInt2, paramInt3, paramBoolean);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, anjf paramanjf, List<anjd> paramList, boolean paramBoolean)
  {
    amsx localamsx = (amsx)paramAppInterface.getManager(153);
    Object localObject1;
    if (localamsx != null)
    {
      localObject1 = localamsx.b(paramString);
      if (localObject1 != null) {
        break label162;
      }
      localObject1 = null;
      if ((localObject1 != null) && (((amxm)localObject1).jdField_a_of_type_Int >= 0) && (localamsx.a(1, ((amxm)localObject1).jdField_a_of_type_Int) / 1000L != ((amxm)localObject1).jdField_a_of_type_Long))
      {
        QLog.i("ApolloPet", 1, "update pet role :" + ((amxm)localObject1).jdField_a_of_type_Int + " to:" + ((amxm)localObject1).jdField_a_of_type_Long);
        paramList.add(new anjd(1, ((amxm)localObject1).jdField_a_of_type_Int));
      }
    }
    if ((paramList == null) || (paramList.isEmpty())) {
      if (paramanjf != null) {
        paramanjf.a(false, paramString, paramList);
      }
    }
    label162:
    label202:
    do
    {
      do
      {
        return;
        localObject1 = ((ApolloBaseInfo)localObject1).getApolloPetDress();
        break;
        localObject1 = (bihw)paramAppInterface.getManager(47);
        if (localObject1 != null) {
          break label202;
        }
      } while (paramanjf == null);
      paramanjf.a(false, paramString, paramList);
      return;
      localObject1 = ((bihw)localObject1).a(3);
      if (localObject1 != null) {
        break label229;
      }
    } while (paramanjf == null);
    paramanjf.a(false, paramString, paramList);
    return;
    label229:
    AtomicInteger localAtomicInteger1 = new AtomicInteger(paramList.size());
    AtomicInteger localAtomicInteger2 = new AtomicInteger(0);
    AtomicInteger localAtomicInteger3 = new AtomicInteger(0);
    int j = paramList.size();
    int i = 0;
    Object localObject3;
    int k;
    int m;
    Object localObject2;
    label375:
    boolean bool;
    for (;;)
    {
      if (i < j)
      {
        localObject3 = (anjd)paramList.get(i);
        k = ((anjd)localObject3).jdField_a_of_type_Int;
        m = ((anjd)localObject3).b;
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
        break label375;
        if (k == 2)
        {
          bool = ApolloUtil.c(m);
          continue;
        }
        if (k != 3) {
          break label779;
        }
        if ((ApolloUtil.a(m, ((anjd)localObject3).c)) || (ApolloUtil.b(m)))
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
      if (!bhnv.g(paramAppInterface.getApplication()))
      {
        if (paramanjf != null) {
          paramanjf.a(false, paramString, paramList);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloResDownloader", 2, "downloadApolloRes NetworkUtil.isNetworkAvailable is false!");
        return;
      }
      localObject3 = new File(a(k, m), "res.zip");
      ((File)localObject3).getParentFile().mkdirs();
      localObject2 = new bihu((String)localObject2, (File)localObject3);
      ((bihu)localObject2).p = true;
      ((bihu)localObject2).n = true;
      ((bihu)localObject2).f = "apollo_res";
      ((bihu)localObject2).b = 1;
      ((bihu)localObject2).q = true;
      ((bihu)localObject2).r = true;
      ((bihz)localObject1).a((bihu)localObject2, new aniy((File)localObject3, localamsx, k, m, localAtomicInteger3, localAtomicInteger2, localAtomicInteger1, paramanjf, paramString, paramList), null);
      break label375;
      if (localAtomicInteger1.get() != 0) {
        break;
      }
      if (paramanjf != null) {
        paramanjf.a(true, paramString, paramList);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloResDownloader", 2, "downloadApolloRes local dress ok uin:" + paramString + ", all cnt: " + localAtomicInteger1.get());
      return;
      label779:
      bool = false;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, anjh paramanjh)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = bjtz.d(paramString);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          new File(annv.f).mkdir();
          new File(annv.j).mkdir();
          localObject = new File(annv.j + (String)localObject + File.separator + (String)localObject + ".zip");
          if (((File)localObject).exists())
          {
            QLog.i("ApolloResDownloader", 1, "checkDownloadFaceData url data is exists:" + paramString);
            if (paramanjh == null) {
              continue;
            }
            paramanjh.a(true, 0);
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
        bihu localbihu = new bihu(paramString, localFile);
        localbihu.p = true;
        localbihu.n = true;
        localbihu.f = "apollo_res";
        localbihu.b = 1;
        localbihu.q = true;
        localbihu.r = true;
        ((bihw)paramAppInterface.getManager(47)).a(3).a(localbihu, new anjb(paramString, localFile, paramanjh), null);
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
    paramString2 = new bihu(paramString2, paramString1);
    paramString2.p = true;
    paramString2.n = true;
    paramString2.f = "apollo_res";
    paramString2.b = 1;
    paramString2.q = true;
    paramString2.r = true;
    ((bihw)paramAppInterface.getManager(47)).a(3).a(paramString2, new anja(paramString1), null);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, Bundle paramBundle, biht parambiht)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramString1 = new File(paramString1);
    paramString1.getParentFile().mkdirs();
    paramString1 = new bihu(paramString2, paramString1);
    paramString1.p = true;
    paramString1.n = true;
    paramString1.f = "apollo_res";
    paramString1.b = 1;
    paramString1.q = true;
    paramString1.r = true;
    ((bihw)paramAppInterface.getManager(47)).a(3).a(paramString1, parambiht, paramBundle);
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
        localObject = new JSONObject(bhmi.b((File)localObject)).optJSONObject("audio");
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
      localObject1 = (lsu)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
      if (localObject1 == null) {
        return null;
      }
      return ((lsu)localObject1).a(null);
    }
    for (;;)
    {
      try
      {
        Object localObject5 = new File(a(1, paramInt), "config.json");
        Object localObject3 = localObject4;
        if (((File)localObject5).exists())
        {
          localObject5 = new JSONObject(bhmi.b((File)localObject5)).optJSONArray("dressIds");
          localObject3 = localObject4;
          if (localObject5 != null)
          {
            localObject3 = localObject4;
            if (((JSONArray)localObject5).length() > 0)
            {
              int j = ((JSONArray)localObject5).length();
              localObject3 = new lsu();
              int i = 0;
              if (i < j)
              {
                ((lsu)localObject3).a(((JSONArray)localObject5).optInt(i));
                i += 1;
                continue;
              }
              jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localObject3);
              localObject3 = ((lsu)localObject3).a(null);
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
        localObject1 = c;
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
        localObject1 = c;
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
        localObject1 = c;
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
        arrayOfInt = c;
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
    if (paramInt2 > annv.jdField_a_of_type_Int)
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
  
  public static void b(AppInterface paramAppInterface, String paramString, anje paramanje, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramAppInterface == null)
    {
      if (paramanje != null) {
        paramanje.onDownLoadFinish(false, paramString, paramInt1, paramArrayOfInt, paramInt2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloRes null Parameters!");
      }
    }
    label254:
    AtomicInteger localAtomicInteger1;
    label428:
    do
    {
      do
      {
        ArrayList localArrayList;
        amsx localamsx;
        Object localObject1;
        do
        {
          do
          {
            do
            {
              return;
              localArrayList = new ArrayList();
              localamsx = (amsx)paramAppInterface.getManager(153);
              if (localamsx != null)
              {
                localObject1 = localamsx.b(paramString);
                if (localObject1 != null) {
                  break label254;
                }
              }
              for (localObject1 = null;; localObject1 = ((ApolloBaseInfo)localObject1).getApolloPetDress())
              {
                if ((localObject1 != null) && (((amxm)localObject1).jdField_a_of_type_Int >= 0) && (localamsx.a(1, ((amxm)localObject1).jdField_a_of_type_Int) / 1000L != ((amxm)localObject1).jdField_a_of_type_Long))
                {
                  QLog.i("ApolloPet", 1, "update pet role :" + ((amxm)localObject1).jdField_a_of_type_Int + " to:" + ((amxm)localObject1).jdField_a_of_type_Long);
                  localArrayList.add(new anjd(1, ((amxm)localObject1).jdField_a_of_type_Int));
                }
                if (paramInt1 >= 0) {
                  localArrayList.add(new anjd(1, paramInt1));
                }
                if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {
                  break;
                }
                i = 0;
                while (i < paramArrayOfInt.length)
                {
                  localArrayList.add(new anjd(2, paramArrayOfInt[i]));
                  i += 1;
                }
              }
              if (paramInt2 > 0) {
                localArrayList.add(new anjd(3, paramInt2));
              }
              if (!localArrayList.isEmpty()) {
                break;
              }
            } while (paramanje == null);
            paramanje.onDownLoadFinish(false, paramString, paramInt1, paramArrayOfInt, paramInt2);
            return;
            localObject1 = (bihw)paramAppInterface.getManager(47);
            if (localObject1 != null) {
              break;
            }
          } while (paramanje == null);
          paramanje.onDownLoadFinish(false, paramString, paramInt1, paramArrayOfInt, paramInt2);
          return;
          localObject1 = ((bihw)localObject1).a(3);
          if (localObject1 != null) {
            break;
          }
        } while (paramanje == null);
        paramanje.onDownLoadFinish(false, paramString, paramInt1, paramArrayOfInt, paramInt2);
        return;
        localAtomicInteger1 = new AtomicInteger(localArrayList.size());
        AtomicInteger localAtomicInteger2 = new AtomicInteger(0);
        AtomicInteger localAtomicInteger3 = new AtomicInteger(0);
        int j = localArrayList.size();
        int i = 0;
        if (i < j)
        {
          Object localObject2 = (anjd)localArrayList.get(i);
          int k = ((anjd)localObject2).jdField_a_of_type_Int;
          int m = ((anjd)localObject2).b;
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
            break label428;
            if (!paramBoolean)
            {
              boolean bool = false;
              if (k == 1) {
                bool = ApolloUtil.d(m);
              }
              for (;;)
              {
                if (!bool) {
                  break label650;
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
            if (!bhnv.g(paramAppInterface.getApplication()))
            {
              if (paramanje != null) {
                paramanje.onDownLoadFinish(false, paramString, paramInt1, paramArrayOfInt, paramInt2);
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("ApolloResDownloader", 2, "downloadApolloRes NetworkUtil.isNetworkAvailable is false!");
              return;
            }
            localObject2 = new File(a(k, m), System.currentTimeMillis() + "res.zip");
            ((File)localObject2).getParentFile().mkdirs();
            localObject3 = new bihu((String)localObject3, (File)localObject2);
            ((bihu)localObject3).p = true;
            ((bihu)localObject3).n = true;
            ((bihu)localObject3).f = "apollo_res";
            ((bihu)localObject3).b = 1;
            ((bihu)localObject3).q = true;
            ((bihu)localObject3).r = true;
            ((bihz)localObject1).a((bihu)localObject3, new aniz((File)localObject2, localamsx, k, m, localAtomicInteger3, localAtomicInteger2, localAtomicInteger1, paramanje, paramString, paramInt1, paramArrayOfInt, paramInt2), null);
          }
        }
      } while (localAtomicInteger1.get() != 0);
      if (paramanje != null) {
        paramanje.onDownLoadFinish(true, paramString, paramInt1, paramArrayOfInt, paramInt2);
      }
    } while (!QLog.isColorLevel());
    label650:
    QLog.d("ApolloResDownloader", 2, "downloadApolloRes local dress ok uin:" + paramString + ", all cnt: " + localAtomicInteger1.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aniv
 * JD-Core Version:    0.7.0.1
 */