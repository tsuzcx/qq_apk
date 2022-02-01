import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.event.ForeBackgroundEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class anlm
{
  private List<anlo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public static anlm a()
  {
    return anlp.a();
  }
  
  public List<anlo> a()
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
    zwp.a().a(new ForeBackgroundEvent(true));
    QLog.i("QzoneVerticalVideoPluginApk", 1, "============== onAppBackground ==============");
    uot.a().a();
    awbj.b();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((anlo)localIterator.next()).b();
    }
  }
  
  public void a(anlo paramanlo)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.add(paramanlo);
      return;
    }
    finally
    {
      paramanlo = finally;
      throw paramanlo;
    }
  }
  
  public final void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForeBackgroundSwitch", 2, "onAppForeground: invoked. " + paramString);
    }
    if (abev.b <= 0L)
    {
      abev.b = System.currentTimeMillis();
      QLog.d("ForeBackgroundSwitch", 1, new Object[] { "onAppForeground: invoked. ", " sFirstForegroundTimestamp: ", Long.valueOf(abev.b) });
    }
    awbj.a();
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
        ((anlo)paramString.next()).a();
      }
      paramString = new ForeBackgroundEvent(false);
      zwp.a().a(paramString);
      continue;
      paramString = new ForeBackgroundEvent(false);
      zwp.a().a(paramString);
    }
  }
  
  public void b(anlo paramanlo)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramanlo);
      return;
    }
    finally
    {
      paramanlo = finally;
      throw paramanlo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anlm
 * JD-Core Version:    0.7.0.1
 */