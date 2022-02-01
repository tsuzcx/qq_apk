import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class aula
  implements aulc
{
  aula(aukz paramaukz) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    boolean bool = this.a.c();
    QLog.i(aukz.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadStart. start:" + bool + "progress:" + paramInt);
    if (bool) {}
    for (;;)
    {
      return;
      this.a.a(true);
      Object localObject = aukz.a(this.a);
      if (paramBundle != null) {
        paramBundle.putBundle("_CB_USERDATA", aukz.a(this.a));
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        aulc localaulc = (aulc)((Iterator)localObject).next();
        if (localaulc != null) {
          localaulc.a(paramInt, paramBundle);
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    QLog.i(aukz.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadFailed. errcode:" + paramInt + "errStr:" + paramString);
    if ((aukz.b(this.a) < 1) && (1 == aukz.a(this.a)))
    {
      QLog.i(aukz.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadFailed. errorRetry");
      aukz.c(this.a);
      aukz.a(this.a, paramInt, paramString, paramBundle);
    }
    for (;;)
    {
      return;
      if (paramBundle != null) {
        paramBundle.putBundle("_CB_USERDATA", aukz.a(this.a));
      }
      Iterator localIterator = aukz.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        aulc localaulc = (aulc)localIterator.next();
        if (localaulc != null) {
          localaulc.a(paramInt, paramString, paramBundle);
        }
      }
    }
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    QLog.i(aukz.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadSucess. filePath:" + paramString);
    paramBundle = new Bundle();
    paramBundle.putInt("_CB_SID", aukz.a(this.a));
    paramBundle.putString("_CB_URL", aukz.a(this.a));
    paramBundle.putBundle("_CB_USERDATA", aukz.a(this.a));
    Iterator localIterator = aukz.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      aulc localaulc = (aulc)localIterator.next();
      if (localaulc != null) {
        localaulc.a(paramString, paramLong, paramBundle);
      }
    }
  }
  
  public void b(int paramInt, Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", aukz.a(this.a));
    }
    Iterator localIterator = aukz.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      aulc localaulc = (aulc)localIterator.next();
      if (localaulc != null) {
        localaulc.b(paramInt, paramBundle);
      }
    }
  }
  
  public void c(int paramInt, Bundle paramBundle)
  {
    QLog.i(aukz.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadPause. progress:" + paramInt);
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", aukz.a(this.a));
    }
    Iterator localIterator = aukz.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      aulc localaulc = (aulc)localIterator.next();
      if (localaulc != null) {
        localaulc.c(paramInt, paramBundle);
      }
    }
  }
  
  public void d(int paramInt, Bundle paramBundle)
  {
    QLog.i(aukz.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadResume. progress:" + paramInt);
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", aukz.a(this.a));
    }
    Iterator localIterator = aukz.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      aulc localaulc = (aulc)localIterator.next();
      if (localaulc != null) {
        localaulc.d(paramInt, paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aula
 * JD-Core Version:    0.7.0.1
 */