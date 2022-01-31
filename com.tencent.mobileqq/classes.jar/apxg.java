import com.tencent.qphone.base.util.QLog;
import java.io.File;

class apxg
  implements bavq
{
  apxg(apxd paramapxd) {}
  
  public void a(bavp parambavp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("onPreDownloadStart url=%s", new Object[] { parambavp.a.jdField_a_of_type_JavaLangString }));
    }
  }
  
  public void onResp(baqw parambaqw)
  {
    int i = 1;
    Object localObject = ((baps)parambaqw.jdField_a_of_type_Baqv).jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("onResp url=%s result=%s", new Object[] { localObject, Integer.valueOf(parambaqw.jdField_a_of_type_Int) }));
    }
    switch (parambaqw.jdField_a_of_type_Int)
    {
    }
    label277:
    label282:
    label303:
    label308:
    do
    {
      return;
      if (apxd.a(this.a) != null) {
        apxd.a(this.a).a((String)localObject, parambaqw.jdField_a_of_type_Long);
      }
      parambaqw = (baps)parambaqw.jdField_a_of_type_Baqv;
      boolean bool2 = apxd.a(this.a, parambaqw.c, apxd.a(this.a));
      boolean bool1;
      if (bool2)
      {
        localObject = new File(apxd.a());
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        boolean bool4 = apxd.b(this.a, parambaqw.c, apxd.a());
        boolean bool3 = apxd.a(this.a);
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendResourceDownloader", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool3) }));
        }
        if (apxd.a(this.a) != null)
        {
          parambaqw = apxd.a(this.a);
          if ((bool4) && (bool3))
          {
            bool1 = true;
            parambaqw.a(bool1);
          }
        }
        else
        {
          parambaqw = aqcx.a();
          if ((!bool4) || (!bool3)) {
            break label303;
          }
          bool1 = true;
          if (bool3) {
            break label308;
          }
          parambaqw.b(bool1, i);
        }
      }
      for (;;)
      {
        aqcx.a().a(bool2, 0);
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
        apxd.a(this.a, parambaqw.c);
        if (apxd.a(this.a) != null) {
          apxd.a(this.a).a(false);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("ExtendFriendResourceDownloader", 2, "download fail " + parambaqw.jdField_a_of_type_JavaLangString);
      }
    } while (apxd.a(this.a) == null);
    apxd.a(this.a).a((String)localObject, -1L);
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", new Object[] { ((baps)parambaqv).jdField_a_of_type_JavaLangString, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apxg
 * JD-Core Version:    0.7.0.1
 */