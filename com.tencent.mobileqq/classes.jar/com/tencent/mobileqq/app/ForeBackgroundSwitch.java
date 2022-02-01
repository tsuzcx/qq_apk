package com.tencent.mobileqq.app;

import com.tencent.common.app.SafeModeUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ForeBackgroundSwitch
{
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private List<WeakReference<ForeBackgroundSwitch.Callback>> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public static ForeBackgroundSwitch a()
  {
    return ForeBackgroundSwitch.SingletonHolder.a();
  }
  
  public final void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForeBackgroundSwitch", 2, "onAppBackground: invoked. ");
    }
    QLog.i("QzoneVerticalVideoPluginApk", 1, "============== onAppBackground ==============");
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ForeBackgroundSwitch.Callback localCallback = (ForeBackgroundSwitch.Callback)((WeakReference)localIterator.next()).get();
        if (localCallback != null) {
          localCallback.b();
        }
      }
    }
  }
  
  public void a(ForeBackgroundSwitch.Callback paramCallback)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          ForeBackgroundSwitch.Callback localCallback = (ForeBackgroundSwitch.Callback)((WeakReference)localIterator.next()).get();
          if ((localCallback == null) || (paramCallback != localCallback)) {
            continue;
          }
          i = 1;
          if (i == 0) {
            this.jdField_a_of_type_JavaUtilList.add(new WeakReference(paramCallback));
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
    if (SafeModeUtil.b <= 0L)
    {
      SafeModeUtil.b = System.currentTimeMillis();
      QLog.d("ForeBackgroundSwitch", 1, new Object[] { "onAppForeground: invoked. ", " sFirstForegroundTimestamp: ", Long.valueOf(SafeModeUtil.b) });
    }
    QLog.i("QzoneVerticalVideoPluginApk", 1, "============== onAppForeground ==============");
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ForeBackgroundSwitch.Callback localCallback = (ForeBackgroundSwitch.Callback)((WeakReference)localIterator.next()).get();
        if (localCallback != null) {
          localCallback.a();
        }
      }
    }
  }
  
  public void b(ForeBackgroundSwitch.Callback paramCallback)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          ForeBackgroundSwitch.Callback localCallback = (ForeBackgroundSwitch.Callback)((WeakReference)this.jdField_a_of_type_JavaUtilList.get(i)).get();
          if ((localCallback == null) || (paramCallback != localCallback)) {
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
 * Qualified Name:     com.tencent.mobileqq.app.ForeBackgroundSwitch
 * JD-Core Version:    0.7.0.1
 */