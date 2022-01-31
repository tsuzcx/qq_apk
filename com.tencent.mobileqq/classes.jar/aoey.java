import com.tencent.qphone.base.util.QLog;
import java.io.File;

class aoey
  implements ayxp
{
  aoey(aoev paramaoev) {}
  
  public void a(ayxo paramayxo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("onPreDownloadStart url=%s", new Object[] { paramayxo.a.jdField_a_of_type_JavaLangString }));
    }
  }
  
  public void onResp(aysx paramaysx)
  {
    int i = 1;
    Object localObject = ((ayrv)paramaysx.jdField_a_of_type_Aysw).jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("onResp url=%s result=%s", new Object[] { localObject, Integer.valueOf(paramaysx.jdField_a_of_type_Int) }));
    }
    switch (paramaysx.jdField_a_of_type_Int)
    {
    }
    label277:
    label282:
    label303:
    label308:
    do
    {
      return;
      if (aoev.a(this.a) != null) {
        aoev.a(this.a).a((String)localObject, paramaysx.jdField_a_of_type_Long);
      }
      paramaysx = (ayrv)paramaysx.jdField_a_of_type_Aysw;
      boolean bool2 = aoev.a(this.a, paramaysx.c, aoev.a(this.a));
      boolean bool1;
      if (bool2)
      {
        localObject = new File(aoev.a());
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        boolean bool4 = aoev.b(this.a, paramaysx.c, aoev.a());
        boolean bool3 = aoev.a(this.a);
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendResourceDownloader", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool3) }));
        }
        if (aoev.a(this.a) != null)
        {
          paramaysx = aoev.a(this.a);
          if ((bool4) && (bool3))
          {
            bool1 = true;
            paramaysx.a(bool1);
          }
        }
        else
        {
          paramaysx = aokk.a();
          if ((!bool4) || (!bool3)) {
            break label303;
          }
          bool1 = true;
          if (bool3) {
            break label308;
          }
          paramaysx.b(bool1, i);
        }
      }
      for (;;)
      {
        aokk.a().a(bool2, 0);
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
        aoev.a(this.a, paramaysx.c);
        if (aoev.a(this.a) != null) {
          aoev.a(this.a).a(false);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("ExtendFriendResourceDownloader", 2, "download fail " + paramaysx.jdField_a_of_type_JavaLangString);
      }
    } while (aoev.a(this.a) == null);
    aoev.a(this.a).a((String)localObject, -1L);
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", new Object[] { ((ayrv)paramaysw).jdField_a_of_type_JavaLangString, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aoey
 * JD-Core Version:    0.7.0.1
 */