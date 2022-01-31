import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class arpm
  implements arpo
{
  arpm(arpl paramarpl) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    boolean bool = this.a.c();
    QLog.i(arpl.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadStart. start:" + bool + "progress:" + paramInt);
    if (bool) {}
    for (;;)
    {
      return;
      this.a.a(true);
      Object localObject = arpl.a(this.a);
      if (paramBundle != null) {
        paramBundle.putBundle("_CB_USERDATA", arpl.a(this.a));
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        arpo localarpo = (arpo)((Iterator)localObject).next();
        if (localarpo != null) {
          localarpo.a(paramInt, paramBundle);
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    QLog.i(arpl.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadFailed. errcode:" + paramInt + "errStr:" + paramString);
    if ((arpl.b(this.a) < 1) && (1 == arpl.a(this.a)))
    {
      QLog.i(arpl.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadFailed. errorRetry");
      arpl.c(this.a);
      arpl.a(this.a, paramInt, paramString, paramBundle);
    }
    for (;;)
    {
      return;
      if (paramBundle != null) {
        paramBundle.putBundle("_CB_USERDATA", arpl.a(this.a));
      }
      Iterator localIterator = arpl.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        arpo localarpo = (arpo)localIterator.next();
        if (localarpo != null) {
          localarpo.a(paramInt, paramString, paramBundle);
        }
      }
    }
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    QLog.i(arpl.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadSucess. filePath:" + paramString);
    paramBundle = new Bundle();
    paramBundle.putInt("_CB_SID", arpl.a(this.a));
    paramBundle.putString("_CB_URL", arpl.a(this.a));
    paramBundle.putBundle("_CB_USERDATA", arpl.a(this.a));
    Iterator localIterator = arpl.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      arpo localarpo = (arpo)localIterator.next();
      if (localarpo != null) {
        localarpo.a(paramString, paramLong, paramBundle);
      }
    }
  }
  
  public void b(int paramInt, Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", arpl.a(this.a));
    }
    Iterator localIterator = arpl.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      arpo localarpo = (arpo)localIterator.next();
      if (localarpo != null) {
        localarpo.b(paramInt, paramBundle);
      }
    }
  }
  
  public void c(int paramInt, Bundle paramBundle)
  {
    QLog.i(arpl.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadPause. progress:" + paramInt);
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", arpl.a(this.a));
    }
    Iterator localIterator = arpl.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      arpo localarpo = (arpo)localIterator.next();
      if (localarpo != null) {
        localarpo.c(paramInt, paramBundle);
      }
    }
  }
  
  public void d(int paramInt, Bundle paramBundle)
  {
    QLog.i(arpl.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadResume. progress:" + paramInt);
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", arpl.a(this.a));
    }
    Iterator localIterator = arpl.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      arpo localarpo = (arpo)localIterator.next();
      if (localarpo != null) {
        localarpo.d(paramInt, paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arpm
 * JD-Core Version:    0.7.0.1
 */