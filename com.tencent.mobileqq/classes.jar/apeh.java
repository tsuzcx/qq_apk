import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class apeh
{
  public static int a;
  private static long jdField_a_of_type_Long;
  private static ArrayList<WeiYunFileInfo> jdField_a_of_type_JavaUtilArrayList;
  private static Map<String, WeiYunFileInfo> jdField_a_of_type_JavaUtilMap;
  private static Set<FileInfo> jdField_a_of_type_JavaUtilSet = new HashSet();
  public static int b;
  private static ArrayList<OfflineFileInfo> jdField_b_of_type_JavaUtilArrayList;
  private static Map<String, apei> jdField_b_of_type_JavaUtilMap = new HashMap();
  private static int jdField_c_of_type_Int;
  private static ArrayList<FileManagerEntity> jdField_c_of_type_JavaUtilArrayList;
  private static int jdField_d_of_type_Int;
  private static ArrayList<FileInfo> jdField_d_of_type_JavaUtilArrayList;
  private static ArrayList<String> e;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    jdField_c_of_type_Int = 20;
    jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    e = new ArrayList();
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_Int = 2;
    jdField_b_of_type_Int = 4;
  }
  
  public static long a()
  {
    return jdField_a_of_type_Long;
  }
  
  public static WeiYunFileInfo a(String paramString)
  {
    return (WeiYunFileInfo)jdField_a_of_type_JavaUtilMap.remove(paramString);
  }
  
  public static ArrayList<FileInfo> a()
  {
    return jdField_d_of_type_JavaUtilArrayList;
  }
  
  public static Set<FileInfo> a()
  {
    return jdField_a_of_type_JavaUtilSet;
  }
  
  public static void a()
  {
    jdField_d_of_type_JavaUtilArrayList.clear();
  }
  
  public static void a(int paramInt)
  {
    jdField_c_of_type_Int = paramInt;
  }
  
  public static void a(long paramLong)
  {
    jdField_a_of_type_Long = paramLong;
  }
  
  public static void a(FileInfo paramFileInfo)
  {
    if (!a(paramFileInfo.a())) {}
    while (jdField_a_of_type_JavaUtilSet.contains(paramFileInfo)) {
      return;
    }
    jdField_a_of_type_JavaUtilSet.add(paramFileInfo);
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity)
  {
    if (!a(paramFileManagerEntity.fileSize)) {
      return;
    }
    jdField_c_of_type_JavaUtilArrayList.add(paramFileManagerEntity);
  }
  
  public static void a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    if (!a(paramWeiYunFileInfo.jdField_a_of_type_Long)) {
      return;
    }
    jdField_a_of_type_JavaUtilArrayList.add(paramWeiYunFileInfo);
  }
  
  public static void a(String paramString, WeiYunFileInfo paramWeiYunFileInfo)
  {
    jdField_a_of_type_JavaUtilMap.put(paramString, paramWeiYunFileInfo);
  }
  
  public static void a(String paramString, byte[] paramArrayOfByte)
  {
    apei localapei = new apei();
    localapei.jdField_a_of_type_JavaLangString = paramString;
    localapei.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    jdField_b_of_type_JavaUtilMap.put(paramString, localapei);
  }
  
  public static void a(ArrayList<FileInfo> paramArrayList)
  {
    jdField_d_of_type_JavaUtilArrayList.clear();
    jdField_d_of_type_JavaUtilArrayList.addAll(paramArrayList);
  }
  
  public static void a(List<FileInfo> paramList)
  {
    jdField_a_of_type_JavaUtilSet.addAll(paramList);
  }
  
  public static boolean a()
  {
    Iterator localIterator = jdField_c_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((FileManagerEntity)localIterator.next()).nFileType == 13) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(int paramInt)
  {
    return (jdField_d_of_type_Int & paramInt) == paramInt;
  }
  
  private static boolean a(long paramLong)
  {
    if ((jdField_c_of_type_Int > 0) && (b() >= jdField_c_of_type_Int))
    {
      aptv.a(0, String.format(BaseApplicationImpl.getApplication().getResources().getString(2131692662), new Object[] { Integer.valueOf(jdField_c_of_type_Int) }), 0);
      return false;
    }
    if ((jdField_a_of_type_Long > 0L) && (d() + paramLong > jdField_a_of_type_Long))
    {
      String str = BaseApplicationImpl.getApplication().getResources().getString(2131692669);
      aptv.a(0, str + apvb.a(jdField_a_of_type_Long), 0);
      return false;
    }
    return true;
  }
  
  public static boolean a(FileInfo paramFileInfo)
  {
    return jdField_a_of_type_JavaUtilSet.contains(paramFileInfo);
  }
  
  public static boolean a(FileManagerEntity paramFileManagerEntity)
  {
    return jdField_c_of_type_JavaUtilArrayList.contains(paramFileManagerEntity);
  }
  
  public static boolean a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((WeiYunFileInfo)localIterator.next()).jdField_a_of_type_JavaLangString.equals(paramWeiYunFileInfo.jdField_a_of_type_JavaLangString)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    return jdField_a_of_type_JavaUtilMap.containsKey(paramString);
  }
  
  public static long b()
  {
    return jdField_a_of_type_JavaUtilSet.size() + jdField_c_of_type_JavaUtilArrayList.size() + jdField_b_of_type_JavaUtilArrayList.size() + jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public static ArrayList<FileManagerEntity> b()
  {
    return jdField_c_of_type_JavaUtilArrayList;
  }
  
  public static void b()
  {
    jdField_a_of_type_JavaUtilSet.clear();
    jdField_c_of_type_JavaUtilArrayList.clear();
    jdField_b_of_type_JavaUtilArrayList.clear();
    jdField_a_of_type_JavaUtilArrayList.clear();
    c();
  }
  
  public static void b(int paramInt)
  {
    jdField_d_of_type_Int |= paramInt;
  }
  
  public static void b(FileInfo paramFileInfo)
  {
    jdField_a_of_type_JavaUtilSet.remove(paramFileInfo);
  }
  
  public static void b(FileManagerEntity paramFileManagerEntity)
  {
    jdField_c_of_type_JavaUtilArrayList.remove(paramFileManagerEntity);
  }
  
  public static void b(WeiYunFileInfo paramWeiYunFileInfo)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)localIterator.next();
      if (localWeiYunFileInfo.jdField_a_of_type_JavaLangString.equals(paramWeiYunFileInfo.jdField_a_of_type_JavaLangString)) {
        jdField_a_of_type_JavaUtilArrayList.remove(localWeiYunFileInfo);
      }
    }
  }
  
  public static boolean b()
  {
    if (b() == 0L) {
      return false;
    }
    if (jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      return false;
    }
    Iterator localIterator = jdField_a_of_type_JavaUtilSet.iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = apvb.a(((FileInfo)localIterator.next()).d());
      if ((str == null) || (str.length() == 0)) {
        return false;
      }
      str = str.toLowerCase();
      if (!ayfv.jdField_a_of_type_JavaLangString.contains(str)) {
        return false;
      }
    }
    localIterator = jdField_c_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      str = apvb.a(((FileManagerEntity)localIterator.next()).fileName);
      if ((str == null) || (str.length() == 0)) {
        return false;
      }
      str = str.toLowerCase();
      if (!ayfv.jdField_a_of_type_JavaLangString.contains(str)) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean b(FileInfo paramFileInfo)
  {
    paramFileInfo = apvb.a(paramFileInfo.d());
    if ((paramFileInfo == null) || (paramFileInfo.length() == 0)) {}
    do
    {
      return false;
      paramFileInfo = paramFileInfo.toLowerCase();
    } while (!ayfv.jdField_a_of_type_JavaLangString.contains(paramFileInfo));
    return true;
  }
  
  public static boolean b(FileManagerEntity paramFileManagerEntity)
  {
    paramFileManagerEntity = apvb.a(paramFileManagerEntity.fileName);
    if ((paramFileManagerEntity == null) || (paramFileManagerEntity.length() == 0)) {}
    do
    {
      return false;
      paramFileManagerEntity = paramFileManagerEntity.toLowerCase();
    } while (!ayfv.jdField_a_of_type_JavaLangString.contains(paramFileManagerEntity));
    return true;
  }
  
  public static long c()
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilSet.iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((FileInfo)localIterator.next()).a() + l) {}
    localIterator = jdField_c_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (apsz.a(localFileManagerEntity).a(false)) {
        l += apvb.a(localFileManagerEntity.getFilePath());
      }
    }
    return l;
  }
  
  public static ArrayList<OfflineFileInfo> c()
  {
    return jdField_b_of_type_JavaUtilArrayList;
  }
  
  public static void c()
  {
    jdField_d_of_type_Int = 0;
  }
  
  public static boolean c()
  {
    if (b() == 0L) {
      return false;
    }
    Iterator localIterator = jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      if (b((FileInfo)localIterator.next())) {
        return true;
      }
    }
    localIterator = jdField_c_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (b((FileManagerEntity)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
  
  public static long d()
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilSet.iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((FileInfo)localIterator.next()).a() + l) {}
    localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      l += ((WeiYunFileInfo)localIterator.next()).jdField_a_of_type_Long;
    }
    localIterator = jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      l += ((OfflineFileInfo)localIterator.next()).b;
    }
    localIterator = jdField_c_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      l += ((FileManagerEntity)localIterator.next()).fileSize;
    }
    return l;
  }
  
  public static ArrayList<WeiYunFileInfo> d()
  {
    return jdField_a_of_type_JavaUtilArrayList;
  }
  
  public static long e()
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((WeiYunFileInfo)localIterator.next()).jdField_a_of_type_Long + l) {}
    localIterator = jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      l += ((OfflineFileInfo)localIterator.next()).b;
    }
    localIterator = jdField_c_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      switch (localFileManagerEntity.getCloudType())
      {
      default: 
        break;
      case 1: 
      case 2: 
        l += localFileManagerEntity.fileSize;
      }
    }
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apeh
 * JD-Core Version:    0.7.0.1
 */