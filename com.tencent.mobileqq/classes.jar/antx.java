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

public class antx
{
  private static File jdField_a_of_type_JavaIoFile;
  public int a;
  public long a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ArrayList<WeakReference<antz>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ConcurrentHashMap<String, bave> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    if ("mounted".equals(Environment.getExternalStorageState())) {}
    for (File localFile = new File(alof.bI);; localFile = BaseApplicationImpl.getApplication().getCacheDir())
    {
      jdField_a_of_type_JavaIoFile = new File(localFile, "_dynamic");
      return;
    }
  }
  
  public antx(AppInterface paramAppInterface)
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
      antw localantw = ((anug)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(180)).a();
      if (this.jdField_a_of_type_Int + 1 > localantw.b)
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
  
  public final void a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values();
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {
      return;
    }
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      bave localbave = (bave)((Iterator)localObject).next();
      if ((localbave != null) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)) {
        this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0).b(localbave);
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void a(antz paramantz)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if ((localWeakReference == null) || (localWeakReference.get() == null) || (localWeakReference.get() != paramantz)) {
            continue;
          }
          i = 1;
          if (i == 0) {
            this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramantz));
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
          bave localbave = (bave)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
          if ((localbave != null) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)) {
            this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0).b(localbave);
          }
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    ??? = a(paramString);
    Iterator localIterator;
    WeakReference localWeakReference;
    if ((??? != null) && (((File)???).exists()) && (((File)???).isFile()))
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext())
          {
            localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((antz)localWeakReference.get()).a(paramString, true, true);
            }
          }
        }
      }
      return true;
    }
    if ((!bdin.h(BaseApplicationImpl.getContext())) && (!a()))
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext())
          {
            localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((antz)localWeakReference.get()).a(paramString, false, false);
            }
          }
        }
      }
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "url:" + paramString + " has contains");
      }
      return false;
    }
    ??? = new baub();
    ((baub)???).jdField_a_of_type_Baug = new anty(this);
    ((baub)???).jdField_a_of_type_JavaLangString = paramString;
    ((baub)???).jdField_a_of_type_Int = 0;
    ((baub)???).jdField_c_of_type_JavaLangString = a(paramString).getPath();
    ((baub)???).jdField_c_of_type_Int = 1;
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0).a((bave)???);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, ???);
      QLog.i("Q.dynamicAvatar", 2, "startDownloadDynamicAvatar, url: " + paramString + ", uin:" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    }
    return false;
  }
  
  public void b()
  {
    a();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
  
  public void b(antz paramantz)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null) && (localWeakReference.get() == paramantz)) {
          localIterator.remove();
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     antx
 * JD-Core Version:    0.7.0.1
 */