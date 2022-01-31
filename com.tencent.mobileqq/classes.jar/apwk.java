import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class apwk
  implements apwm
{
  apwk(apwj paramapwj) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    boolean bool = this.a.c();
    QLog.i(apwj.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadStart. start:" + bool + "progress:" + paramInt);
    if (bool) {}
    for (;;)
    {
      return;
      this.a.a(true);
      Object localObject = apwj.a(this.a);
      if (paramBundle != null) {
        paramBundle.putBundle("_CB_USERDATA", apwj.a(this.a));
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        apwm localapwm = (apwm)((Iterator)localObject).next();
        if (localapwm != null) {
          localapwm.a(paramInt, paramBundle);
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    QLog.i(apwj.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadFailed. errcode:" + paramInt + "errStr:" + paramString);
    if ((apwj.b(this.a) < 1) && (1 == apwj.a(this.a)))
    {
      QLog.i(apwj.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadFailed. errorRetry");
      apwj.c(this.a);
      apwj.a(this.a, paramInt, paramString, paramBundle);
    }
    for (;;)
    {
      return;
      if (paramBundle != null) {
        paramBundle.putBundle("_CB_USERDATA", apwj.a(this.a));
      }
      Iterator localIterator = apwj.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        apwm localapwm = (apwm)localIterator.next();
        if (localapwm != null) {
          localapwm.a(paramInt, paramString, paramBundle);
        }
      }
    }
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    QLog.i(apwj.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadSucess. filePath:" + paramString);
    paramBundle = new Bundle();
    paramBundle.putInt("_CB_SID", apwj.a(this.a));
    paramBundle.putString("_CB_URL", apwj.a(this.a));
    paramBundle.putBundle("_CB_USERDATA", apwj.a(this.a));
    Iterator localIterator = apwj.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      apwm localapwm = (apwm)localIterator.next();
      if (localapwm != null) {
        localapwm.a(paramString, paramLong, paramBundle);
      }
    }
  }
  
  public void b(int paramInt, Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", apwj.a(this.a));
    }
    Iterator localIterator = apwj.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      apwm localapwm = (apwm)localIterator.next();
      if (localapwm != null) {
        localapwm.b(paramInt, paramBundle);
      }
    }
  }
  
  public void c(int paramInt, Bundle paramBundle)
  {
    QLog.i(apwj.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadPause. progress:" + paramInt);
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", apwj.a(this.a));
    }
    Iterator localIterator = apwj.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      apwm localapwm = (apwm)localIterator.next();
      if (localapwm != null) {
        localapwm.c(paramInt, paramBundle);
      }
    }
  }
  
  public void d(int paramInt, Bundle paramBundle)
  {
    QLog.i(apwj.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadResume. progress:" + paramInt);
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", apwj.a(this.a));
    }
    Iterator localIterator = apwj.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      apwm localapwm = (apwm)localIterator.next();
      if (localapwm != null) {
        localapwm.d(paramInt, paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apwk
 * JD-Core Version:    0.7.0.1
 */