import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.util.WeakReference;

class asxs
  implements ayxp
{
  asxs(asxp paramasxp, String paramString, String[] paramArrayOfString, asxu paramasxu) {}
  
  public void a(ayxo paramayxo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("onPreDownloadStart url=%s", new Object[] { paramayxo.a.jdField_a_of_type_JavaLangString }));
    }
  }
  
  public void onResp(aysx paramaysx)
  {
    String str = ((ayrv)paramaysx.jdField_a_of_type_Aysw).jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("onResp url=%s result=%s", new Object[] { str, Integer.valueOf(paramaysx.jdField_a_of_type_Int) }));
    }
    switch (paramaysx.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      if (this.jdField_a_of_type_Asxp.a == null) {
        break;
      }
    }
    for (Object localObject = (ayxq)this.jdField_a_of_type_Asxp.a.get();; localObject = null)
    {
      if (localObject != null) {
        ((ayxq)localObject).a(str, paramaysx.jdField_a_of_type_Long);
      }
      paramaysx = (ayrv)paramaysx.jdField_a_of_type_Aysw;
      if (asxp.a(paramaysx.c, this.jdField_a_of_type_JavaLangString))
      {
        localObject = new File(asxp.a(this.jdField_a_of_type_JavaLangString));
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        boolean bool1 = asxp.b(paramaysx.c, asxp.a(this.jdField_a_of_type_JavaLangString));
        boolean bool2 = asxp.b(str, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfJavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("ZipResourcesDownloader", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
        }
        asxp.a(this.jdField_a_of_type_Asxp, str, this.jdField_a_of_type_JavaLangString, bool2, this.jdField_a_of_type_Asxu);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ZipResourcesDownloader", 2, "onResp ResultOk file check invalid.");
      }
      asxp.a(paramaysx.c);
      asxp.a(this.jdField_a_of_type_Asxp, str, this.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_Asxu);
      return;
      if (this.jdField_a_of_type_Asxp.a != null) {}
      for (paramaysx = (ayxq)this.jdField_a_of_type_Asxp.a.get();; paramaysx = null)
      {
        if (paramaysx != null) {
          paramaysx.a(str, -1L);
        }
        asxp.a(this.jdField_a_of_type_Asxp, str, this.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_Asxu);
        return;
      }
    }
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", new Object[] { ((ayrv)paramaysw).jdField_a_of_type_JavaLangString, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asxs
 * JD-Core Version:    0.7.0.1
 */