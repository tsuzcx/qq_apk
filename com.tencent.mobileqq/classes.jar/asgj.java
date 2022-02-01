import com.tencent.qphone.base.util.QLog;
import java.io.File;

class asgj
  implements beav
{
  asgj(asgg paramasgg) {}
  
  public void a(beau parambeau)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("onPreDownloadStart url=%s", new Object[] { parambeau.a.jdField_a_of_type_JavaLangString }));
    }
  }
  
  public void onResp(bdwt parambdwt)
  {
    int i = 1;
    Object localObject = ((bdvs)parambdwt.jdField_a_of_type_Bdws).jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("onResp url=%s result=%s", new Object[] { localObject, Integer.valueOf(parambdwt.jdField_a_of_type_Int) }));
    }
    switch (parambdwt.jdField_a_of_type_Int)
    {
    }
    label277:
    label282:
    label303:
    label308:
    do
    {
      return;
      if (asgg.a(this.a) != null) {
        asgg.a(this.a).a((String)localObject, parambdwt.jdField_a_of_type_Long);
      }
      parambdwt = (bdvs)parambdwt.jdField_a_of_type_Bdws;
      boolean bool2 = asgg.a(this.a, parambdwt.c, asgg.a(this.a));
      boolean bool1;
      if (bool2)
      {
        localObject = new File(asgg.a());
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        boolean bool4 = asgg.b(this.a, parambdwt.c, asgg.a());
        boolean bool3 = asgg.a(this.a);
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendResourceDownloader", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool3) }));
        }
        if (asgg.a(this.a) != null)
        {
          parambdwt = asgg.a(this.a);
          if ((bool4) && (bool3))
          {
            bool1 = true;
            parambdwt.a(bool1);
          }
        }
        else
        {
          parambdwt = asmj.a();
          if ((!bool4) || (!bool3)) {
            break label303;
          }
          bool1 = true;
          if (bool3) {
            break label308;
          }
          parambdwt.b(bool1, i);
        }
      }
      for (;;)
      {
        asmj.a().a(bool2, 0);
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
        asgg.a(this.a, parambdwt.c);
        if (asgg.a(this.a) != null) {
          asgg.a(this.a).a(false);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("ExtendFriendResourceDownloader", 2, "download fail " + parambdwt.jdField_a_of_type_JavaLangString);
      }
    } while (asgg.a(this.a) == null);
    asgg.a(this.a).a((String)localObject, -1L);
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", new Object[] { ((bdvs)parambdws).jdField_a_of_type_JavaLangString, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asgj
 * JD-Core Version:    0.7.0.1
 */