import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.event.ForeBackgroundEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class amrq
{
  private List<amrs> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public static amrq a()
  {
    return amrt.a();
  }
  
  public List<amrs> a()
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
    unw.a().a(new ForeBackgroundEvent(true));
    QLog.i("QzoneVerticalVideoPluginApk", 1, "============== onAppBackground ==============");
    uxn.a().a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((amrs)localIterator.next()).b();
    }
  }
  
  public void a(amrs paramamrs)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.add(paramamrs);
      return;
    }
    finally
    {
      paramamrs = finally;
      throw paramamrs;
    }
  }
  
  public final void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForeBackgroundSwitch", 2, "onAppForeground: invoked. " + paramString);
    }
    if (aafi.b <= 0L)
    {
      aafi.b = System.currentTimeMillis();
      QLog.d("ForeBackgroundSwitch", 1, new Object[] { "onAppForeground: invoked. ", " sFirstForegroundTimestamp: ", Long.valueOf(aafi.b) });
    }
    avhh.a();
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
        ((amrs)paramString.next()).a();
      }
      paramString = new ForeBackgroundEvent(false);
      unw.a().a(paramString);
      continue;
      paramString = new ForeBackgroundEvent(false);
      unw.a().a(paramString);
    }
  }
  
  public void b(amrs paramamrs)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramamrs);
      return;
    }
    finally
    {
      paramamrs = finally;
      throw paramamrs;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amrq
 * JD-Core Version:    0.7.0.1
 */