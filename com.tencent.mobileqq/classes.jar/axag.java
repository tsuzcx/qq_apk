import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.util.WeakReference;

class axag
  implements beav
{
  axag(axad paramaxad, String paramString, String[] paramArrayOfString, axai paramaxai) {}
  
  public void a(beau parambeau)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("onPreDownloadStart url=%s", new Object[] { parambeau.a.jdField_a_of_type_JavaLangString }));
    }
  }
  
  public void onResp(bdwt parambdwt)
  {
    String str = ((bdvs)parambdwt.jdField_a_of_type_Bdws).jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("onResp url=%s result=%s", new Object[] { str, Integer.valueOf(parambdwt.jdField_a_of_type_Int) }));
    }
    switch (parambdwt.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      if (this.jdField_a_of_type_Axad.a == null) {
        break;
      }
    }
    for (Object localObject = (beaw)this.jdField_a_of_type_Axad.a.get();; localObject = null)
    {
      if (localObject != null) {
        ((beaw)localObject).a(str, parambdwt.jdField_a_of_type_Long);
      }
      parambdwt = (bdvs)parambdwt.jdField_a_of_type_Bdws;
      if (axad.a(parambdwt.c, this.jdField_a_of_type_JavaLangString))
      {
        localObject = new File(axad.a(this.jdField_a_of_type_JavaLangString));
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        boolean bool1 = axad.b(parambdwt.c, axad.a(this.jdField_a_of_type_JavaLangString));
        boolean bool2 = axad.b(str, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfJavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("ZipResourcesDownloader", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
        }
        axad.a(this.jdField_a_of_type_Axad, str, this.jdField_a_of_type_JavaLangString, bool2, this.jdField_a_of_type_Axai);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ZipResourcesDownloader", 2, "onResp ResultOk file check invalid.");
      }
      axad.a(parambdwt.c);
      axad.a(this.jdField_a_of_type_Axad, str, this.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_Axai);
      return;
      if (this.jdField_a_of_type_Axad.a != null) {}
      for (parambdwt = (beaw)this.jdField_a_of_type_Axad.a.get();; parambdwt = null)
      {
        if (parambdwt != null) {
          parambdwt.a(str, -1L);
        }
        axad.a(this.jdField_a_of_type_Axad, str, this.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_Axai);
        return;
      }
    }
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", new Object[] { ((bdvs)parambdws).jdField_a_of_type_JavaLangString, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axag
 * JD-Core Version:    0.7.0.1
 */