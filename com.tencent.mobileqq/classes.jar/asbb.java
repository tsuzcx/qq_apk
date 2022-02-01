import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.download.unite.DownloadDialogFragment;
import com.tencent.open.downloadnew.DownloadInfo;
import java.lang.ref.WeakReference;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class asbb
{
  private static Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new asbc());
  private static ConcurrentHashMap<Long, WeakReference<asbd>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public static Handler a()
  {
    return jdField_a_of_type_AndroidOsHandler;
  }
  
  public static void a(DownloadInfo paramDownloadInfo, asbd paramasbd)
  {
    Random localRandom = new Random();
    for (Long localLong = Long.valueOf(localRandom.nextLong()); jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localLong); localLong = Long.valueOf(localRandom.nextLong())) {}
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localLong, new WeakReference(paramasbd));
    DownloadDialogFragment.a(paramDownloadInfo, localLong.longValue());
  }
  
  public static void a(String paramString)
  {
    azcl.a("0X800B538", 0, "", paramString);
  }
  
  public static void b(String paramString)
  {
    azcl.a("0X800B539", 0, "", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asbb
 * JD-Core Version:    0.7.0.1
 */