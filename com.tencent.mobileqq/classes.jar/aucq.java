import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class aucq
  implements aucs
{
  aucq(aucp paramaucp) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    boolean bool = this.a.c();
    QLog.i(aucp.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadStart. start:" + bool + "progress:" + paramInt);
    if (bool) {}
    for (;;)
    {
      return;
      this.a.a(true);
      Object localObject = aucp.a(this.a);
      if (paramBundle != null) {
        paramBundle.putBundle("_CB_USERDATA", aucp.a(this.a));
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        aucs localaucs = (aucs)((Iterator)localObject).next();
        if (localaucs != null) {
          localaucs.a(paramInt, paramBundle);
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    QLog.i(aucp.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadFailed. errcode:" + paramInt + "errStr:" + paramString);
    if ((aucp.b(this.a) < 1) && (1 == aucp.a(this.a)))
    {
      QLog.i(aucp.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadFailed. errorRetry");
      aucp.c(this.a);
      aucp.a(this.a, paramInt, paramString, paramBundle);
    }
    for (;;)
    {
      return;
      if (paramBundle != null) {
        paramBundle.putBundle("_CB_USERDATA", aucp.a(this.a));
      }
      Iterator localIterator = aucp.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        aucs localaucs = (aucs)localIterator.next();
        if (localaucs != null) {
          localaucs.a(paramInt, paramString, paramBundle);
        }
      }
    }
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    QLog.i(aucp.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadSucess. filePath:" + paramString);
    paramBundle = new Bundle();
    paramBundle.putInt("_CB_SID", aucp.a(this.a));
    paramBundle.putString("_CB_URL", aucp.a(this.a));
    paramBundle.putBundle("_CB_USERDATA", aucp.a(this.a));
    Iterator localIterator = aucp.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      aucs localaucs = (aucs)localIterator.next();
      if (localaucs != null) {
        localaucs.a(paramString, paramLong, paramBundle);
      }
    }
  }
  
  public void b(int paramInt, Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", aucp.a(this.a));
    }
    Iterator localIterator = aucp.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      aucs localaucs = (aucs)localIterator.next();
      if (localaucs != null) {
        localaucs.b(paramInt, paramBundle);
      }
    }
  }
  
  public void c(int paramInt, Bundle paramBundle)
  {
    QLog.i(aucp.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadPause. progress:" + paramInt);
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", aucp.a(this.a));
    }
    Iterator localIterator = aucp.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      aucs localaucs = (aucs)localIterator.next();
      if (localaucs != null) {
        localaucs.c(paramInt, paramBundle);
      }
    }
  }
  
  public void d(int paramInt, Bundle paramBundle)
  {
    QLog.i(aucp.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadResume. progress:" + paramInt);
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", aucp.a(this.a));
    }
    Iterator localIterator = aucp.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      aucs localaucs = (aucs)localIterator.next();
      if (localaucs != null) {
        localaucs.d(paramInt, paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aucq
 * JD-Core Version:    0.7.0.1
 */