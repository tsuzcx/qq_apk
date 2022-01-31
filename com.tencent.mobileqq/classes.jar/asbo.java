import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.util.WeakReference;

class asbo
  implements axxi
{
  asbo(asbl paramasbl, String paramString, String[] paramArrayOfString, asbq paramasbq) {}
  
  public void a(axxh paramaxxh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("onPreDownloadStart url=%s", new Object[] { paramaxxh.a.jdField_a_of_type_JavaLangString }));
    }
  }
  
  public void onResp(axsq paramaxsq)
  {
    String str = ((axro)paramaxsq.jdField_a_of_type_Axsp).jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("onResp url=%s result=%s", new Object[] { str, Integer.valueOf(paramaxsq.jdField_a_of_type_Int) }));
    }
    switch (paramaxsq.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      if (this.jdField_a_of_type_Asbl.a == null) {
        break;
      }
    }
    for (Object localObject = (axxj)this.jdField_a_of_type_Asbl.a.get();; localObject = null)
    {
      if (localObject != null) {
        ((axxj)localObject).a(str, paramaxsq.jdField_a_of_type_Long);
      }
      paramaxsq = (axro)paramaxsq.jdField_a_of_type_Axsp;
      if (asbl.a(paramaxsq.c, this.jdField_a_of_type_JavaLangString))
      {
        localObject = new File(asbl.a(this.jdField_a_of_type_JavaLangString));
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        boolean bool1 = asbl.b(paramaxsq.c, asbl.a(this.jdField_a_of_type_JavaLangString));
        boolean bool2 = asbl.b(str, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfJavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("ZipResourcesDownloader", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
        }
        asbl.a(this.jdField_a_of_type_Asbl, str, this.jdField_a_of_type_JavaLangString, bool2, this.jdField_a_of_type_Asbq);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ZipResourcesDownloader", 2, "onResp ResultOk file check invalid.");
      }
      asbl.a(paramaxsq.c);
      asbl.a(this.jdField_a_of_type_Asbl, str, this.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_Asbq);
      return;
      if (this.jdField_a_of_type_Asbl.a != null) {}
      for (paramaxsq = (axxj)this.jdField_a_of_type_Asbl.a.get();; paramaxsq = null)
      {
        if (paramaxsq != null) {
          paramaxsq.a(str, -1L);
        }
        asbl.a(this.jdField_a_of_type_Asbl, str, this.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_Asbq);
        return;
      }
    }
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", new Object[] { ((axro)paramaxsp).jdField_a_of_type_JavaLangString, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asbo
 * JD-Core Version:    0.7.0.1
 */