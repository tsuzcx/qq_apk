import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.cmshow.AECMShowResourceManager.1;
import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class bnjd
  extends bnuu
{
  private HashMap<String, AEEditorDownloadResBean> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
  
  private bnjd()
  {
    super("", bmwn.b, 4, "AECMShowResourceManager");
  }
  
  public static bnjd a()
  {
    return bnjg.a;
  }
  
  @Nullable
  private AEEditorDownloadResBean a(String paramString)
  {
    return (AEEditorDownloadResBean)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  private void e()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.getCount() <= 0L)
      {
        bnrh.a("AECMShowResourceManager", "[prepareResourceConfig], configured");
        return;
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashMap.putAll(bnji.a().a());
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
    }
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await();
      return;
      localObject = finally;
      throw localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        bnrh.a("AECMShowResourceManager", "[prepareResourceConfig], e=", localInterruptedException);
      }
    }
  }
  
  protected void a() {}
  
  protected void a(@NonNull List<AEEditorDownloadResBean> paramList) {}
  
  public void a(@NonNull List<String> paramList, @Nullable bnjf parambnjf)
  {
    ThreadManager.excute(new AECMShowResourceManager.1(this, paramList, parambnjf), 128, null, false);
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString) {}
  
  protected void b(@NonNull List<AEEditorDownloadResBean> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnjd
 * JD-Core Version:    0.7.0.1
 */