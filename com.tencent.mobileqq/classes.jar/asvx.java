import com.tencent.qphone.base.util.QLog;
import java.io.File;

class asvx
  implements bezu
{
  asvx(asvu paramasvu) {}
  
  public void a(bezt parambezt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("onPreDownloadStart url=%s", new Object[] { parambezt.a.jdField_a_of_type_JavaLangString }));
    }
  }
  
  public void onResp(bevm parambevm)
  {
    int i = 1;
    Object localObject = ((beum)parambevm.jdField_a_of_type_Bevl).jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("onResp url=%s result=%s", new Object[] { localObject, Integer.valueOf(parambevm.jdField_a_of_type_Int) }));
    }
    switch (parambevm.jdField_a_of_type_Int)
    {
    }
    label277:
    label282:
    label303:
    label308:
    do
    {
      return;
      if (asvu.a(this.a) != null) {
        asvu.a(this.a).a((String)localObject, parambevm.jdField_a_of_type_Long);
      }
      parambevm = (beum)parambevm.jdField_a_of_type_Bevl;
      boolean bool2 = asvu.a(this.a, parambevm.c, asvu.a(this.a));
      boolean bool1;
      if (bool2)
      {
        localObject = new File(asvu.a());
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        boolean bool4 = asvu.b(this.a, parambevm.c, asvu.a());
        boolean bool3 = asvu.a(this.a);
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendResourceDownloader", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool3) }));
        }
        if (asvu.a(this.a) != null)
        {
          parambevm = asvu.a(this.a);
          if ((bool4) && (bool3))
          {
            bool1 = true;
            parambevm.a(bool1);
          }
        }
        else
        {
          parambevm = atci.a();
          if ((!bool4) || (!bool3)) {
            break label303;
          }
          bool1 = true;
          if (bool3) {
            break label308;
          }
          parambevm.b(bool1, i);
        }
      }
      for (;;)
      {
        atci.a().a(bool2, 0);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label277;
        i = 0;
        break label282;
        if (QLog.isColorLevel()) {
          QLog.e("ExtendFriendResourceDownloader", 2, "onResp ResultOk file check invalid.");
        }
        asvu.a(this.a, parambevm.c);
        if (asvu.a(this.a) != null) {
          asvu.a(this.a).a(false);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("ExtendFriendResourceDownloader", 2, "download fail " + parambevm.jdField_a_of_type_JavaLangString);
      }
    } while (asvu.a(this.a) == null);
    asvu.a(this.a).a((String)localObject, -1L);
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", new Object[] { ((beum)parambevl).jdField_a_of_type_JavaLangString, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asvx
 * JD-Core Version:    0.7.0.1
 */