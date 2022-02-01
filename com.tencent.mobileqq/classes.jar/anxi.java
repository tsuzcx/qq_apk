import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.event.ForeBackgroundEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class anxi
{
  private List<anxk> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public static anxi a()
  {
    return anxl.a();
  }
  
  public List<anxk> a()
  {
    try
    {
      List localList = this.jdField_a_of_type_JavaUtilList;
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForeBackgroundSwitch", 2, "onAppBackground: invoked. ");
    }
    aaak.a().a(new ForeBackgroundEvent(true));
    QLog.i("QzoneVerticalVideoPluginApk", 1, "============== onAppBackground ==============");
    ups.a().a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((anxk)localIterator.next()).b();
    }
  }
  
  public void a(anxk paramanxk)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.add(paramanxk);
      return;
    }
    finally
    {
      paramanxk = finally;
      throw paramanxk;
    }
  }
  
  public final void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForeBackgroundSwitch", 2, "onAppForeground: invoked. " + paramString);
    }
    if (abiz.b <= 0L)
    {
      abiz.b = System.currentTimeMillis();
      QLog.d("ForeBackgroundSwitch", 1, new Object[] { "onAppForeground: invoked. ", " sFirstForegroundTimestamp: ", Long.valueOf(abiz.b) });
    }
    awub.a();
    if ((TextUtils.equals("com.tencent.mobileqq:qzone", paramString)) || ((!TextUtils.isEmpty(paramString)) && (paramString.contains("mini")))) {
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      QLog.i("QzoneVerticalVideoPluginApk", 1, "============== onAppForeground ==============");
      paramString = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramString.hasNext()) {
        ((anxk)paramString.next()).a();
      }
      paramString = new ForeBackgroundEvent(false);
      aaak.a().a(paramString);
      continue;
      paramString = new ForeBackgroundEvent(false);
      aaak.a().a(paramString);
    }
  }
  
  public void b(anxk paramanxk)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramanxk);
      return;
    }
    finally
    {
      paramanxk = finally;
      throw paramanxk;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anxi
 * JD-Core Version:    0.7.0.1
 */