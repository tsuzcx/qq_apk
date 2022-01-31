import com.tencent.qphone.base.util.QLog;
import java.io.File;

class anon
  implements axxi
{
  anon(anok paramanok) {}
  
  public void a(axxh paramaxxh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("onPreDownloadStart url=%s", new Object[] { paramaxxh.a.jdField_a_of_type_JavaLangString }));
    }
  }
  
  public void onResp(axsq paramaxsq)
  {
    int i = 1;
    Object localObject = ((axro)paramaxsq.jdField_a_of_type_Axsp).jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("onResp url=%s result=%s", new Object[] { localObject, Integer.valueOf(paramaxsq.jdField_a_of_type_Int) }));
    }
    switch (paramaxsq.jdField_a_of_type_Int)
    {
    }
    label277:
    label282:
    label303:
    label308:
    do
    {
      return;
      if (anok.a(this.a) != null) {
        anok.a(this.a).a((String)localObject, paramaxsq.jdField_a_of_type_Long);
      }
      paramaxsq = (axro)paramaxsq.jdField_a_of_type_Axsp;
      boolean bool2 = anok.a(this.a, paramaxsq.c, anok.a(this.a));
      boolean bool1;
      if (bool2)
      {
        localObject = new File(anok.a());
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        boolean bool4 = anok.b(this.a, paramaxsq.c, anok.a());
        boolean bool3 = anok.a(this.a);
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendResourceDownloader", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool3) }));
        }
        if (anok.a(this.a) != null)
        {
          paramaxsq = anok.a(this.a);
          if ((bool4) && (bool3))
          {
            bool1 = true;
            paramaxsq.a(bool1);
          }
        }
        else
        {
          paramaxsq = anty.a();
          if ((!bool4) || (!bool3)) {
            break label303;
          }
          bool1 = true;
          if (bool3) {
            break label308;
          }
          paramaxsq.b(bool1, i);
        }
      }
      for (;;)
      {
        anty.a().a(bool2, 0);
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
        anok.a(this.a, paramaxsq.c);
        if (anok.a(this.a) != null) {
          anok.a(this.a).a(false);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("ExtendFriendResourceDownloader", 2, "download fail " + paramaxsq.jdField_a_of_type_JavaLangString);
      }
    } while (anok.a(this.a) == null);
    anok.a(this.a).a((String)localObject, -1L);
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", new Object[] { ((axro)paramaxsp).jdField_a_of_type_JavaLangString, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anon
 * JD-Core Version:    0.7.0.1
 */