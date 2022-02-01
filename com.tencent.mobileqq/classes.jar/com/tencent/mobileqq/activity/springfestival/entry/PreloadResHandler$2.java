package com.tencent.mobileqq.activity.springfestival.entry;

import com.tencent.mobileqq.activity.springfestival.report.SpringHbMonitorReporter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;

class PreloadResHandler$2
  implements Runnable
{
  PreloadResHandler$2(PreloadResHandler paramPreloadResHandler, boolean paramBoolean, String paramString, Object paramObject) {}
  
  public void run()
  {
    try
    {
      Object localObject2 = new ArrayList(this.this$0.a.size() + 1);
      synchronized (this.this$0.a)
      {
        ((List)localObject2).addAll(this.this$0.a);
        ??? = ((List)localObject2).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = (IPreloadRes.OnDownloadCallback)((WeakReference)((Iterator)???).next()).get();
          if (localObject2 != null) {
            ((IPreloadRes.OnDownloadCallback)localObject2).a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangObject);
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      SpringHbMonitorReporter.a(110, localException, new String[0]);
      QLog.e("shua2021_PreloadResHandler", 1, localException.getMessage(), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.PreloadResHandler.2
 * JD-Core Version:    0.7.0.1
 */