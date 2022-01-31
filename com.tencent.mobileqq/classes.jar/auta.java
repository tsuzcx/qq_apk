import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.util.WeakReference;

class auta
  implements bazz
{
  auta(ausx paramausx, String paramString, String[] paramArrayOfString, autc paramautc) {}
  
  public void a(bazy parambazy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("onPreDownloadStart url=%s", new Object[] { parambazy.a.jdField_a_of_type_JavaLangString }));
    }
  }
  
  public void onResp(bavf parambavf)
  {
    String str = ((baub)parambavf.jdField_a_of_type_Bave).jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("onResp url=%s result=%s", new Object[] { str, Integer.valueOf(parambavf.jdField_a_of_type_Int) }));
    }
    switch (parambavf.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      if (this.jdField_a_of_type_Ausx.a == null) {
        break;
      }
    }
    for (Object localObject = (bbaa)this.jdField_a_of_type_Ausx.a.get();; localObject = null)
    {
      if (localObject != null) {
        ((bbaa)localObject).a(str, parambavf.jdField_a_of_type_Long);
      }
      parambavf = (baub)parambavf.jdField_a_of_type_Bave;
      if (ausx.a(parambavf.c, this.jdField_a_of_type_JavaLangString))
      {
        localObject = new File(ausx.a(this.jdField_a_of_type_JavaLangString));
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        boolean bool1 = ausx.b(parambavf.c, ausx.a(this.jdField_a_of_type_JavaLangString));
        boolean bool2 = ausx.b(str, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfJavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("ZipResourcesDownloader", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
        }
        ausx.a(this.jdField_a_of_type_Ausx, str, this.jdField_a_of_type_JavaLangString, bool2, this.jdField_a_of_type_Autc);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ZipResourcesDownloader", 2, "onResp ResultOk file check invalid.");
      }
      ausx.a(parambavf.c);
      ausx.a(this.jdField_a_of_type_Ausx, str, this.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_Autc);
      return;
      if (this.jdField_a_of_type_Ausx.a != null) {}
      for (parambavf = (bbaa)this.jdField_a_of_type_Ausx.a.get();; parambavf = null)
      {
        if (parambavf != null) {
          parambavf.a(str, -1L);
        }
        ausx.a(this.jdField_a_of_type_Ausx, str, this.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_Autc);
        return;
      }
    }
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", new Object[] { ((baub)parambave).jdField_a_of_type_JavaLangString, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auta
 * JD-Core Version:    0.7.0.1
 */