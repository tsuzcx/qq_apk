import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class apwi
  implements apwk
{
  apwi(apwh paramapwh) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    boolean bool = this.a.c();
    QLog.i(apwh.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadStart. start:" + bool + "progress:" + paramInt);
    if (bool) {}
    for (;;)
    {
      return;
      this.a.a(true);
      Object localObject = apwh.a(this.a);
      if (paramBundle != null) {
        paramBundle.putBundle("_CB_USERDATA", apwh.a(this.a));
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        apwk localapwk = (apwk)((Iterator)localObject).next();
        if (localapwk != null) {
          localapwk.a(paramInt, paramBundle);
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    QLog.i(apwh.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadFailed. errcode:" + paramInt + "errStr:" + paramString);
    if ((apwh.b(this.a) < 1) && (1 == apwh.a(this.a)))
    {
      QLog.i(apwh.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadFailed. errorRetry");
      apwh.c(this.a);
      apwh.a(this.a, paramInt, paramString, paramBundle);
    }
    for (;;)
    {
      return;
      if (paramBundle != null) {
        paramBundle.putBundle("_CB_USERDATA", apwh.a(this.a));
      }
      Iterator localIterator = apwh.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        apwk localapwk = (apwk)localIterator.next();
        if (localapwk != null) {
          localapwk.a(paramInt, paramString, paramBundle);
        }
      }
    }
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    QLog.i(apwh.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadSucess. filePath:" + paramString);
    paramBundle = new Bundle();
    paramBundle.putInt("_CB_SID", apwh.a(this.a));
    paramBundle.putString("_CB_URL", apwh.a(this.a));
    paramBundle.putBundle("_CB_USERDATA", apwh.a(this.a));
    Iterator localIterator = apwh.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      apwk localapwk = (apwk)localIterator.next();
      if (localapwk != null) {
        localapwk.a(paramString, paramLong, paramBundle);
      }
    }
  }
  
  public void b(int paramInt, Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", apwh.a(this.a));
    }
    Iterator localIterator = apwh.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      apwk localapwk = (apwk)localIterator.next();
      if (localapwk != null) {
        localapwk.b(paramInt, paramBundle);
      }
    }
  }
  
  public void c(int paramInt, Bundle paramBundle)
  {
    QLog.i(apwh.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadPause. progress:" + paramInt);
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", apwh.a(this.a));
    }
    Iterator localIterator = apwh.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      apwk localapwk = (apwk)localIterator.next();
      if (localapwk != null) {
        localapwk.c(paramInt, paramBundle);
      }
    }
  }
  
  public void d(int paramInt, Bundle paramBundle)
  {
    QLog.i(apwh.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadResume. progress:" + paramInt);
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", apwh.a(this.a));
    }
    Iterator localIterator = apwh.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      apwk localapwk = (apwk)localIterator.next();
      if (localapwk != null) {
        localapwk.d(paramInt, paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apwi
 * JD-Core Version:    0.7.0.1
 */