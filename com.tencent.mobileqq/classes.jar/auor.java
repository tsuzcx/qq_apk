import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.util.WeakReference;

class auor
  implements bavq
{
  auor(auoo paramauoo, String paramString, String[] paramArrayOfString, auot paramauot) {}
  
  public void a(bavp parambavp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("onPreDownloadStart url=%s", new Object[] { parambavp.a.jdField_a_of_type_JavaLangString }));
    }
  }
  
  public void onResp(baqw parambaqw)
  {
    String str = ((baps)parambaqw.jdField_a_of_type_Baqv).jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("onResp url=%s result=%s", new Object[] { str, Integer.valueOf(parambaqw.jdField_a_of_type_Int) }));
    }
    switch (parambaqw.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      if (this.jdField_a_of_type_Auoo.a == null) {
        break;
      }
    }
    for (Object localObject = (bavr)this.jdField_a_of_type_Auoo.a.get();; localObject = null)
    {
      if (localObject != null) {
        ((bavr)localObject).a(str, parambaqw.jdField_a_of_type_Long);
      }
      parambaqw = (baps)parambaqw.jdField_a_of_type_Baqv;
      if (auoo.a(parambaqw.c, this.jdField_a_of_type_JavaLangString))
      {
        localObject = new File(auoo.a(this.jdField_a_of_type_JavaLangString));
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        boolean bool1 = auoo.b(parambaqw.c, auoo.a(this.jdField_a_of_type_JavaLangString));
        boolean bool2 = auoo.b(str, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfJavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("ZipResourcesDownloader", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
        }
        auoo.a(this.jdField_a_of_type_Auoo, str, this.jdField_a_of_type_JavaLangString, bool2, this.jdField_a_of_type_Auot);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ZipResourcesDownloader", 2, "onResp ResultOk file check invalid.");
      }
      auoo.a(parambaqw.c);
      auoo.a(this.jdField_a_of_type_Auoo, str, this.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_Auot);
      return;
      if (this.jdField_a_of_type_Auoo.a != null) {}
      for (parambaqw = (bavr)this.jdField_a_of_type_Auoo.a.get();; parambaqw = null)
      {
        if (parambaqw != null) {
          parambaqw.a(str, -1L);
        }
        auoo.a(this.jdField_a_of_type_Auoo, str, this.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_Auot);
        return;
      }
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", new Object[] { ((baps)parambaqv).jdField_a_of_type_JavaLangString, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auor
 * JD-Core Version:    0.7.0.1
 */