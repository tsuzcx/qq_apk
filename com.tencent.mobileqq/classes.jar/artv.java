import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class artv
  implements artx
{
  artv(artu paramartu) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    boolean bool = this.a.c();
    QLog.i(artu.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadStart. start:" + bool + "progress:" + paramInt);
    if (bool) {}
    for (;;)
    {
      return;
      this.a.a(true);
      Object localObject = artu.a(this.a);
      if (paramBundle != null) {
        paramBundle.putBundle("_CB_USERDATA", artu.a(this.a));
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        artx localartx = (artx)((Iterator)localObject).next();
        if (localartx != null) {
          localartx.a(paramInt, paramBundle);
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    QLog.i(artu.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadFailed. errcode:" + paramInt + "errStr:" + paramString);
    if ((artu.b(this.a) < 1) && (1 == artu.a(this.a)))
    {
      QLog.i(artu.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadFailed. errorRetry");
      artu.c(this.a);
      artu.a(this.a, paramInt, paramString, paramBundle);
    }
    for (;;)
    {
      return;
      if (paramBundle != null) {
        paramBundle.putBundle("_CB_USERDATA", artu.a(this.a));
      }
      Iterator localIterator = artu.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        artx localartx = (artx)localIterator.next();
        if (localartx != null) {
          localartx.a(paramInt, paramString, paramBundle);
        }
      }
    }
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    QLog.i(artu.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadSucess. filePath:" + paramString);
    paramBundle = new Bundle();
    paramBundle.putInt("_CB_SID", artu.a(this.a));
    paramBundle.putString("_CB_URL", artu.a(this.a));
    paramBundle.putBundle("_CB_USERDATA", artu.a(this.a));
    Iterator localIterator = artu.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      artx localartx = (artx)localIterator.next();
      if (localartx != null) {
        localartx.a(paramString, paramLong, paramBundle);
      }
    }
  }
  
  public void b(int paramInt, Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", artu.a(this.a));
    }
    Iterator localIterator = artu.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      artx localartx = (artx)localIterator.next();
      if (localartx != null) {
        localartx.b(paramInt, paramBundle);
      }
    }
  }
  
  public void c(int paramInt, Bundle paramBundle)
  {
    QLog.i(artu.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadPause. progress:" + paramInt);
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", artu.a(this.a));
    }
    Iterator localIterator = artu.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      artx localartx = (artx)localIterator.next();
      if (localartx != null) {
        localartx.c(paramInt, paramBundle);
      }
    }
  }
  
  public void d(int paramInt, Bundle paramBundle)
  {
    QLog.i(artu.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadResume. progress:" + paramInt);
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", artu.a(this.a));
    }
    Iterator localIterator = artu.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      artx localartx = (artx)localIterator.next();
      if (localartx != null) {
        localartx.d(paramInt, paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     artv
 * JD-Core Version:    0.7.0.1
 */