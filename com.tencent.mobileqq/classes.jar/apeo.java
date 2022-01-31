import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class apeo
  implements apeq
{
  apeo(apen paramapen) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    boolean bool = this.a.c();
    QLog.i(apen.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadStart. start:" + bool + "progress:" + paramInt);
    if (bool) {}
    for (;;)
    {
      return;
      this.a.a(true);
      Object localObject = apen.a(this.a);
      if (paramBundle != null) {
        paramBundle.putBundle("_CB_USERDATA", apen.a(this.a));
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        apeq localapeq = (apeq)((Iterator)localObject).next();
        if (localapeq != null) {
          localapeq.a(paramInt, paramBundle);
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    QLog.i(apen.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadFailed. errcode:" + paramInt + "errStr:" + paramString);
    if ((apen.b(this.a) < 1) && (1 == apen.a(this.a)))
    {
      QLog.i(apen.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadFailed. errorRetry");
      apen.c(this.a);
      apen.a(this.a, paramInt, paramString, paramBundle);
    }
    for (;;)
    {
      return;
      if (paramBundle != null) {
        paramBundle.putBundle("_CB_USERDATA", apen.a(this.a));
      }
      Iterator localIterator = apen.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        apeq localapeq = (apeq)localIterator.next();
        if (localapeq != null) {
          localapeq.a(paramInt, paramString, paramBundle);
        }
      }
    }
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    QLog.i(apen.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadSucess. filePath:" + paramString);
    paramBundle = new Bundle();
    paramBundle.putInt("_CB_SID", apen.a(this.a));
    paramBundle.putString("_CB_URL", apen.a(this.a));
    paramBundle.putBundle("_CB_USERDATA", apen.a(this.a));
    Iterator localIterator = apen.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      apeq localapeq = (apeq)localIterator.next();
      if (localapeq != null) {
        localapeq.a(paramString, paramLong, paramBundle);
      }
    }
  }
  
  public void b(int paramInt, Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", apen.a(this.a));
    }
    Iterator localIterator = apen.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      apeq localapeq = (apeq)localIterator.next();
      if (localapeq != null) {
        localapeq.b(paramInt, paramBundle);
      }
    }
  }
  
  public void c(int paramInt, Bundle paramBundle)
  {
    QLog.i(apen.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadPause. progress:" + paramInt);
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", apen.a(this.a));
    }
    Iterator localIterator = apen.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      apeq localapeq = (apeq)localIterator.next();
      if (localapeq != null) {
        localapeq.c(paramInt, paramBundle);
      }
    }
  }
  
  public void d(int paramInt, Bundle paramBundle)
  {
    QLog.i(apen.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadResume. progress:" + paramInt);
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", apen.a(this.a));
    }
    Iterator localIterator = apen.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      apeq localapeq = (apeq)localIterator.next();
      if (localapeq != null) {
        localapeq.d(paramInt, paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apeo
 * JD-Core Version:    0.7.0.1
 */