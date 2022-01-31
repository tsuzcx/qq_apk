import com.tencent.qphone.base.util.QLog;
import java.io.File;

class aqbp
  implements bazz
{
  aqbp(aqbm paramaqbm) {}
  
  public void a(bazy parambazy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("onPreDownloadStart url=%s", new Object[] { parambazy.a.jdField_a_of_type_JavaLangString }));
    }
  }
  
  public void onResp(bavf parambavf)
  {
    int i = 1;
    Object localObject = ((baub)parambavf.jdField_a_of_type_Bave).jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("onResp url=%s result=%s", new Object[] { localObject, Integer.valueOf(parambavf.jdField_a_of_type_Int) }));
    }
    switch (parambavf.jdField_a_of_type_Int)
    {
    }
    label277:
    label282:
    label303:
    label308:
    do
    {
      return;
      if (aqbm.a(this.a) != null) {
        aqbm.a(this.a).a((String)localObject, parambavf.jdField_a_of_type_Long);
      }
      parambavf = (baub)parambavf.jdField_a_of_type_Bave;
      boolean bool2 = aqbm.a(this.a, parambavf.c, aqbm.a(this.a));
      boolean bool1;
      if (bool2)
      {
        localObject = new File(aqbm.a());
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        boolean bool4 = aqbm.b(this.a, parambavf.c, aqbm.a());
        boolean bool3 = aqbm.a(this.a);
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendResourceDownloader", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool3) }));
        }
        if (aqbm.a(this.a) != null)
        {
          parambavf = aqbm.a(this.a);
          if ((bool4) && (bool3))
          {
            bool1 = true;
            parambavf.a(bool1);
          }
        }
        else
        {
          parambavf = aqhg.a();
          if ((!bool4) || (!bool3)) {
            break label303;
          }
          bool1 = true;
          if (bool3) {
            break label308;
          }
          parambavf.b(bool1, i);
        }
      }
      for (;;)
      {
        aqhg.a().a(bool2, 0);
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
        aqbm.a(this.a, parambavf.c);
        if (aqbm.a(this.a) != null) {
          aqbm.a(this.a).a(false);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("ExtendFriendResourceDownloader", 2, "download fail " + parambavf.jdField_a_of_type_JavaLangString);
      }
    } while (aqbm.a(this.a) == null);
    aqbm.a(this.a).a((String)localObject, -1L);
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", new Object[] { ((baub)parambave).jdField_a_of_type_JavaLangString, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqbp
 * JD-Core Version:    0.7.0.1
 */