import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class atgt
  implements atgv
{
  atgt(atgs paramatgs) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    boolean bool = this.a.c();
    QLog.i(atgs.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadStart. start:" + bool + "progress:" + paramInt);
    if (bool) {}
    for (;;)
    {
      return;
      this.a.a(true);
      Object localObject = atgs.a(this.a);
      if (paramBundle != null) {
        paramBundle.putBundle("_CB_USERDATA", atgs.a(this.a));
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        atgv localatgv = (atgv)((Iterator)localObject).next();
        if (localatgv != null) {
          localatgv.a(paramInt, paramBundle);
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    QLog.i(atgs.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadFailed. errcode:" + paramInt + "errStr:" + paramString);
    if ((atgs.b(this.a) < 1) && (1 == atgs.a(this.a)))
    {
      QLog.i(atgs.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadFailed. errorRetry");
      atgs.c(this.a);
      atgs.a(this.a, paramInt, paramString, paramBundle);
    }
    for (;;)
    {
      return;
      if (paramBundle != null) {
        paramBundle.putBundle("_CB_USERDATA", atgs.a(this.a));
      }
      Iterator localIterator = atgs.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        atgv localatgv = (atgv)localIterator.next();
        if (localatgv != null) {
          localatgv.a(paramInt, paramString, paramBundle);
        }
      }
    }
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    QLog.i(atgs.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadSucess. filePath:" + paramString);
    paramBundle = new Bundle();
    paramBundle.putInt("_CB_SID", atgs.a(this.a));
    paramBundle.putString("_CB_URL", atgs.a(this.a));
    paramBundle.putBundle("_CB_USERDATA", atgs.a(this.a));
    Iterator localIterator = atgs.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      atgv localatgv = (atgv)localIterator.next();
      if (localatgv != null) {
        localatgv.a(paramString, paramLong, paramBundle);
      }
    }
  }
  
  public void b(int paramInt, Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", atgs.a(this.a));
    }
    Iterator localIterator = atgs.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      atgv localatgv = (atgv)localIterator.next();
      if (localatgv != null) {
        localatgv.b(paramInt, paramBundle);
      }
    }
  }
  
  public void c(int paramInt, Bundle paramBundle)
  {
    QLog.i(atgs.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadPause. progress:" + paramInt);
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", atgs.a(this.a));
    }
    Iterator localIterator = atgs.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      atgv localatgv = (atgv)localIterator.next();
      if (localatgv != null) {
        localatgv.c(paramInt, paramBundle);
      }
    }
  }
  
  public void d(int paramInt, Bundle paramBundle)
  {
    QLog.i(atgs.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadResume. progress:" + paramInt);
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", atgs.a(this.a));
    }
    Iterator localIterator = atgs.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      atgv localatgv = (atgv)localIterator.next();
      if (localatgv != null) {
        localatgv.d(paramInt, paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atgt
 * JD-Core Version:    0.7.0.1
 */