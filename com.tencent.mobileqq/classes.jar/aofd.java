import com.tencent.qphone.base.util.QLog;
import java.io.File;

class aofd
  implements ayxr
{
  aofd(aofa paramaofa) {}
  
  public void a(ayxq paramayxq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("onPreDownloadStart url=%s", new Object[] { paramayxq.a.jdField_a_of_type_JavaLangString }));
    }
  }
  
  public void onResp(aysz paramaysz)
  {
    int i = 1;
    Object localObject = ((ayrx)paramaysz.jdField_a_of_type_Aysy).jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("onResp url=%s result=%s", new Object[] { localObject, Integer.valueOf(paramaysz.jdField_a_of_type_Int) }));
    }
    switch (paramaysz.jdField_a_of_type_Int)
    {
    }
    label277:
    label282:
    label303:
    label308:
    do
    {
      return;
      if (aofa.a(this.a) != null) {
        aofa.a(this.a).a((String)localObject, paramaysz.jdField_a_of_type_Long);
      }
      paramaysz = (ayrx)paramaysz.jdField_a_of_type_Aysy;
      boolean bool2 = aofa.a(this.a, paramaysz.c, aofa.a(this.a));
      boolean bool1;
      if (bool2)
      {
        localObject = new File(aofa.a());
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        boolean bool4 = aofa.b(this.a, paramaysz.c, aofa.a());
        boolean bool3 = aofa.a(this.a);
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendResourceDownloader", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool3) }));
        }
        if (aofa.a(this.a) != null)
        {
          paramaysz = aofa.a(this.a);
          if ((bool4) && (bool3))
          {
            bool1 = true;
            paramaysz.a(bool1);
          }
        }
        else
        {
          paramaysz = aokp.a();
          if ((!bool4) || (!bool3)) {
            break label303;
          }
          bool1 = true;
          if (bool3) {
            break label308;
          }
          paramaysz.b(bool1, i);
        }
      }
      for (;;)
      {
        aokp.a().a(bool2, 0);
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
        aofa.a(this.a, paramaysz.c);
        if (aofa.a(this.a) != null) {
          aofa.a(this.a).a(false);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("ExtendFriendResourceDownloader", 2, "download fail " + paramaysz.jdField_a_of_type_JavaLangString);
      }
    } while (aofa.a(this.a) == null);
    aofa.a(this.a).a((String)localObject, -1L);
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", new Object[] { ((ayrx)paramaysy).jdField_a_of_type_JavaLangString, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aofd
 * JD-Core Version:    0.7.0.1
 */