import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qg.loader.QGDownloader.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class bkfq
{
  public int a;
  private Map<String, List<bkfr>> a;
  
  @NonNull
  static bkfq a()
  {
    return new bkfv();
  }
  
  private void d(String paramString, boolean paramBoolean)
  {
    paramString = (List)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        bkfr localbkfr = (bkfr)paramString.next();
        if (paramBoolean) {
          localbkfr.a();
        } else {
          localbkfr.b();
        }
      }
    }
  }
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QGDownloader", 2, "onFail.");
    }
    this.jdField_a_of_type_Int = 1;
    c(paramString, false);
    d(paramString, false);
  }
  
  protected void a(String paramString, int paramInt) {}
  
  protected abstract void a(String paramString, boolean paramBoolean);
  
  public final void a(String paramString, boolean paramBoolean, bkfr parambkfr)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    }
    if (parambkfr != null)
    {
      List localList = (List)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      Object localObject = localList;
      if (localList == null) {
        localObject = new ArrayList(1);
      }
      parambkfr.a = System.currentTimeMillis();
      ((List)localObject).add(parambkfr);
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
    }
    a(paramString, paramBoolean);
  }
  
  protected void b(String paramString, boolean paramBoolean)
  {
    boolean bool = bkfs.b.get();
    if (QLog.isColorLevel()) {
      QLog.d("QGDownloader", 2, new Object[] { "onSuccess. loadSo=", Boolean.valueOf(paramBoolean), ", soLoaded=", Boolean.valueOf(bool) });
    }
    this.jdField_a_of_type_Int = 0;
    c(paramString, true);
    if (!paramBoolean)
    {
      d(paramString, true);
      return;
    }
    if (!bool)
    {
      ThreadManagerV2.excute(new QGDownloader.1(this, paramString), 16, null, true);
      return;
    }
    d(paramString, false);
  }
  
  protected void c(String paramString, boolean paramBoolean)
  {
    paramString = (List)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((paramString != null) && (!paramString.isEmpty())) {
      paramString = (bkfr)paramString.get(0);
    }
    for (long l = System.currentTimeMillis() - paramString.a;; l = 0L)
    {
      if (paramBoolean) {}
      for (paramString = "1";; paramString = "0")
      {
        yup.b("video_game_tech", "qg_so_download", 0, 0, new String[] { String.valueOf(l), paramString });
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkfq
 * JD-Core Version:    0.7.0.1
 */