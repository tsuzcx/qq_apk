import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.event.ForeBackgroundEvent;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class anue
{
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private List<WeakReference<anug>> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public static anue a()
  {
    return anuh.a();
  }
  
  public final void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForeBackgroundSwitch", 2, "onAppBackground: invoked. ");
    }
    vbw.a().a(new ForeBackgroundEvent(true));
    QLog.i("QzoneVerticalVideoPluginApk", 1, "============== onAppBackground ==============");
    vmc.a().a();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        anug localanug = (anug)((WeakReference)localIterator.next()).get();
        if (localanug != null) {
          localanug.b();
        }
      }
    }
  }
  
  public void a(anug paramanug)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          anug localanug = (anug)((WeakReference)localIterator.next()).get();
          if ((localanug == null) || (paramanug != localanug)) {
            continue;
          }
          i = 1;
          if (i == 0) {
            this.jdField_a_of_type_JavaUtilList.add(new WeakReference(paramanug));
          }
          return;
        }
      }
      int i = 0;
    }
  }
  
  public final void a(String arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForeBackgroundSwitch", 2, "onAppForeground: invoked. " + ???);
    }
    if (aauu.b <= 0L)
    {
      aauu.b = System.currentTimeMillis();
      QLog.d("ForeBackgroundSwitch", 1, new Object[] { "onAppForeground: invoked. ", " sFirstForegroundTimestamp: ", Long.valueOf(aauu.b) });
    }
    awnk.a();
    if ((TextUtils.equals("com.tencent.mobileqq:qzone", ???)) || ((!TextUtils.isEmpty(???)) && (???.contains("mini")))) {
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      QLog.i("QzoneVerticalVideoPluginApk", 1, "============== onAppForeground ==============");
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        anug localanug;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localanug = (anug)((WeakReference)localIterator.next()).get();
        } while (localanug == null);
        localanug.a();
      }
      ??? = new ForeBackgroundEvent(false);
      vbw.a().a(???);
      continue;
      ??? = new ForeBackgroundEvent(false);
      vbw.a().a(???);
    }
  }
  
  public void b(anug paramanug)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          anug localanug = (anug)((WeakReference)this.jdField_a_of_type_JavaUtilList.get(i)).get();
          if ((localanug == null) || (paramanug != localanug)) {
            break label83;
          }
          if (i != -1) {
            this.jdField_a_of_type_JavaUtilList.remove(i);
          }
          return;
        }
      }
      finally {}
      i = -1;
      continue;
      label83:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anue
 * JD-Core Version:    0.7.0.1
 */