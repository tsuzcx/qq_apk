import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class auul
  implements auun
{
  auul(auuk paramauuk) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    boolean bool = this.a.c();
    QLog.i(auuk.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadStart. start:" + bool + "progress:" + paramInt);
    if (bool) {}
    for (;;)
    {
      return;
      this.a.a(true);
      Object localObject = auuk.a(this.a);
      if (paramBundle != null) {
        paramBundle.putBundle("_CB_USERDATA", auuk.a(this.a));
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        auun localauun = (auun)((Iterator)localObject).next();
        if (localauun != null) {
          localauun.a(paramInt, paramBundle);
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    QLog.i(auuk.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadFailed. errcode:" + paramInt + "errStr:" + paramString);
    if ((auuk.b(this.a) < 1) && (1 == auuk.a(this.a)))
    {
      QLog.i(auuk.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadFailed. errorRetry");
      auuk.c(this.a);
      auuk.a(this.a, paramInt, paramString, paramBundle);
    }
    for (;;)
    {
      return;
      if (paramBundle != null) {
        paramBundle.putBundle("_CB_USERDATA", auuk.a(this.a));
      }
      Iterator localIterator = auuk.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        auun localauun = (auun)localIterator.next();
        if (localauun != null) {
          localauun.a(paramInt, paramString, paramBundle);
        }
      }
    }
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    QLog.i(auuk.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadSucess. filePath:" + paramString);
    paramBundle = new Bundle();
    paramBundle.putInt("_CB_SID", auuk.a(this.a));
    paramBundle.putString("_CB_URL", auuk.a(this.a));
    paramBundle.putBundle("_CB_USERDATA", auuk.a(this.a));
    Iterator localIterator = auuk.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      auun localauun = (auun)localIterator.next();
      if (localauun != null) {
        localauun.a(paramString, paramLong, paramBundle);
      }
    }
  }
  
  public void b(int paramInt, Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", auuk.a(this.a));
    }
    Iterator localIterator = auuk.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      auun localauun = (auun)localIterator.next();
      if (localauun != null) {
        localauun.b(paramInt, paramBundle);
      }
    }
  }
  
  public void c(int paramInt, Bundle paramBundle)
  {
    QLog.i(auuk.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadPause. progress:" + paramInt);
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", auuk.a(this.a));
    }
    Iterator localIterator = auuk.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      auun localauun = (auun)localIterator.next();
      if (localauun != null) {
        localauun.c(paramInt, paramBundle);
      }
    }
  }
  
  public void d(int paramInt, Bundle paramBundle)
  {
    QLog.i(auuk.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadResume. progress:" + paramInt);
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", auuk.a(this.a));
    }
    Iterator localIterator = auuk.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      auun localauun = (auun)localIterator.next();
      if (localauun != null) {
        localauun.d(paramInt, paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auul
 * JD-Core Version:    0.7.0.1
 */