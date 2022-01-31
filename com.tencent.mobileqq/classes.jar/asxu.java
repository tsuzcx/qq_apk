import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.util.WeakReference;

class asxu
  implements ayxr
{
  asxu(asxr paramasxr, String paramString, String[] paramArrayOfString, asxw paramasxw) {}
  
  public void a(ayxq paramayxq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("onPreDownloadStart url=%s", new Object[] { paramayxq.a.jdField_a_of_type_JavaLangString }));
    }
  }
  
  public void onResp(aysz paramaysz)
  {
    String str = ((ayrx)paramaysz.jdField_a_of_type_Aysy).jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("onResp url=%s result=%s", new Object[] { str, Integer.valueOf(paramaysz.jdField_a_of_type_Int) }));
    }
    switch (paramaysz.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      if (this.jdField_a_of_type_Asxr.a == null) {
        break;
      }
    }
    for (Object localObject = (ayxs)this.jdField_a_of_type_Asxr.a.get();; localObject = null)
    {
      if (localObject != null) {
        ((ayxs)localObject).a(str, paramaysz.jdField_a_of_type_Long);
      }
      paramaysz = (ayrx)paramaysz.jdField_a_of_type_Aysy;
      if (asxr.a(paramaysz.c, this.jdField_a_of_type_JavaLangString))
      {
        localObject = new File(asxr.a(this.jdField_a_of_type_JavaLangString));
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        boolean bool1 = asxr.b(paramaysz.c, asxr.a(this.jdField_a_of_type_JavaLangString));
        boolean bool2 = asxr.b(str, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfJavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("ZipResourcesDownloader", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
        }
        asxr.a(this.jdField_a_of_type_Asxr, str, this.jdField_a_of_type_JavaLangString, bool2, this.jdField_a_of_type_Asxw);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ZipResourcesDownloader", 2, "onResp ResultOk file check invalid.");
      }
      asxr.a(paramaysz.c);
      asxr.a(this.jdField_a_of_type_Asxr, str, this.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_Asxw);
      return;
      if (this.jdField_a_of_type_Asxr.a != null) {}
      for (paramaysz = (ayxs)this.jdField_a_of_type_Asxr.a.get();; paramaysz = null)
      {
        if (paramaysz != null) {
          paramaysz.a(str, -1L);
        }
        asxr.a(this.jdField_a_of_type_Asxr, str, this.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_Asxw);
        return;
      }
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", new Object[] { ((ayrx)paramaysy).jdField_a_of_type_JavaLangString, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asxu
 * JD-Core Version:    0.7.0.1
 */