import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.util.WeakReference;

class axsz
  implements bezu
{
  axsz(axsw paramaxsw, String paramString, String[] paramArrayOfString, axtb paramaxtb) {}
  
  public void a(bezt parambezt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("onPreDownloadStart url=%s", new Object[] { parambezt.a.jdField_a_of_type_JavaLangString }));
    }
  }
  
  public void onResp(bevm parambevm)
  {
    String str = ((beum)parambevm.jdField_a_of_type_Bevl).jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("onResp url=%s result=%s", new Object[] { str, Integer.valueOf(parambevm.jdField_a_of_type_Int) }));
    }
    switch (parambevm.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      if (this.jdField_a_of_type_Axsw.a == null) {
        break;
      }
    }
    for (Object localObject = (bezv)this.jdField_a_of_type_Axsw.a.get();; localObject = null)
    {
      if (localObject != null) {
        ((bezv)localObject).a(str, parambevm.jdField_a_of_type_Long);
      }
      parambevm = (beum)parambevm.jdField_a_of_type_Bevl;
      if (axsw.a(parambevm.c, this.jdField_a_of_type_JavaLangString))
      {
        localObject = new File(axsw.a(this.jdField_a_of_type_JavaLangString));
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        boolean bool1 = axsw.b(parambevm.c, axsw.a(this.jdField_a_of_type_JavaLangString));
        boolean bool2 = axsw.b(str, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfJavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("ZipResourcesDownloader", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
        }
        axsw.a(this.jdField_a_of_type_Axsw, str, this.jdField_a_of_type_JavaLangString, bool2, this.jdField_a_of_type_Axtb);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ZipResourcesDownloader", 2, "onResp ResultOk file check invalid.");
      }
      axsw.a(parambevm.c);
      axsw.a(this.jdField_a_of_type_Axsw, str, this.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_Axtb);
      return;
      if (this.jdField_a_of_type_Axsw.a != null) {}
      for (parambevm = (bezv)this.jdField_a_of_type_Axsw.a.get();; parambevm = null)
      {
        if (parambevm != null) {
          parambevm.a(str, -1L);
        }
        axsw.a(this.jdField_a_of_type_Axsw, str, this.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_Axtb);
        return;
      }
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", new Object[] { ((beum)parambevl).jdField_a_of_type_JavaLangString, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axsz
 * JD-Core Version:    0.7.0.1
 */