import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager.2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

public class aqhs
{
  private static File jdField_a_of_type_JavaIoFile;
  public int a;
  public long a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ArrayList<WeakReference<aqhu>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ConcurrentHashMap<String, bevl> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    if ("mounted".equals(Environment.getExternalStorageState())) {}
    for (File localFile = new File(antf.bL);; localFile = BaseApplicationImpl.getApplication().getCacheDir())
    {
      jdField_a_of_type_JavaIoFile = new File(localFile, "_dynamic");
      return;
    }
  }
  
  public aqhs(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    c();
  }
  
  public static File a(String paramString)
  {
    paramString = a(paramString);
    return new File(jdField_a_of_type_JavaIoFile, paramString);
  }
  
  public static String a(String paramString)
  {
    return "cache_" + Utils.Crc64String(paramString) + ".mp4";
  }
  
  private boolean a()
  {
    long l = System.currentTimeMillis();
    if ((l - this.jdField_a_of_type_Long > 86400000L) || (l - this.jdField_a_of_type_Long < 0L)) {
      return true;
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
    {
      aqhr localaqhr = ((aqib)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(180)).a();
      if (this.jdField_a_of_type_Int + 1 > localaqhr.b)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.dynamicAvatar", 2, "isLoadCountSatisfy not satisfy.");
        }
        return false;
      }
      return true;
    }
    return true;
  }
  
  public static String b(String paramString)
  {
    return a(paramString).getAbsolutePath();
  }
  
  public static boolean b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = a(paramString);
      if ((paramString.exists()) && (paramString.isFile())) {
        return true;
      }
    }
    return false;
  }
  
  private void c()
  {
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("dynamic_avatar", 4).getString("dynamic_load_count_one_day", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("#");
      if ((localObject == null) || (localObject.length != 2)) {}
    }
    try
    {
      this.jdField_a_of_type_Long = Long.valueOf(localObject[0]).longValue();
      this.jdField_a_of_type_Int = Integer.valueOf(localObject[1]).intValue();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean c(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bhnv.h(BaseApplicationImpl.getContext()))
    {
      bool1 = bool2;
      if (!a())
      {
        synchronized (this.jdField_a_of_type_JavaUtilArrayList)
        {
          if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
          {
            Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (localIterator.hasNext())
            {
              WeakReference localWeakReference = (WeakReference)localIterator.next();
              if ((localWeakReference != null) && (localWeakReference.get() != null)) {
                ((aqhu)localWeakReference.get()).a(paramString, false, false);
              }
            }
          }
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void d()
  {
    this.jdField_a_of_type_Int += 1;
    long l = System.currentTimeMillis();
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 86400000L)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Int = 0;
    }
    ThreadManager.executeOnFileThread(new DynamicAvatarDownloadManager.2(this, l));
  }
  
  private boolean d(String paramString)
  {
    ??? = a(paramString);
    if ((??? != null) && (((File)???).exists()) && (((File)???).isFile()))
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext())
          {
            WeakReference localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((aqhu)localWeakReference.get()).a(paramString, true, true);
            }
          }
        }
      }
      return true;
    }
    return false;
  }
  
  public final void a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values();
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {
      return;
    }
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      bevl localbevl = (bevl)((Iterator)localObject).next();
      if ((localbevl != null) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)) {
        this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0).b(localbevl);
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void a(aqhu paramaqhu)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if ((localWeakReference == null) || (localWeakReference.get() == null) || (localWeakReference.get() != paramaqhu)) {
            continue;
          }
          i = 1;
          if (i == 0) {
            this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramaqhu));
          }
          return;
        }
      }
      int i = 0;
    }
  }
  
  public final void a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
        {
          bevl localbevl = (bevl)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
          if ((localbevl != null) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)) {
            this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0).b(localbevl);
          }
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    beum localbeum;
    do
    {
      do
      {
        do
        {
          return false;
          if (d(paramString)) {
            return true;
          }
        } while (c(paramString));
        if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("Q.dynamicAvatar", 2, "url:" + paramString + " has contains");
      return false;
      localbeum = new beum();
      localbeum.jdField_a_of_type_Beuq = new aqht(this);
      localbeum.jdField_a_of_type_JavaLangString = paramString;
      localbeum.jdField_a_of_type_Int = 0;
      localbeum.c = a(paramString).getPath();
      localbeum.b = 1;
    } while (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0).a(localbeum);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localbeum);
    QLog.i("Q.dynamicAvatar", 2, "startDownloadDynamicAvatar, url: " + paramString + ", uin:" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    return false;
  }
  
  public void b()
  {
    a();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
  
  public void b(aqhu paramaqhu)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null) && (localWeakReference.get() == paramaqhu)) {
          localIterator.remove();
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqhs
 * JD-Core Version:    0.7.0.1
 */