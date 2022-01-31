import com.tencent.qphone.base.util.QLog;
import java.io.File;

class asec
  implements bavq
{
  asec(asdz paramasdz) {}
  
  public void a(bavp parambavp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("onPreDownloadStart url=%s", new Object[] { parambavp.a.a }));
    }
  }
  
  public void onResp(baqw parambaqw)
  {
    Object localObject = ((baps)parambaqw.jdField_a_of_type_Baqv).a;
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("onResp url=%s result=%s", new Object[] { localObject, Integer.valueOf(parambaqw.jdField_a_of_type_Int) }));
    }
    switch (parambaqw.jdField_a_of_type_Int)
    {
    }
    do
    {
      boolean bool1;
      boolean bool2;
      do
      {
        return;
        if (asdz.a(this.a) != null) {
          asdz.a(this.a).a((String)localObject, parambaqw.jdField_a_of_type_Long);
        }
        parambaqw = (baps)parambaqw.jdField_a_of_type_Baqv;
        if (!asdz.a(this.a, parambaqw.c, asdz.a(this.a))) {
          break;
        }
        localObject = new File(asdz.a());
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        bool1 = asdz.b(this.a, parambaqw.c, asdz.a());
        bool2 = asdz.a(this.a);
      } while (!QLog.isColorLevel());
      QLog.d("IntimateInfoManager", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      return;
      if (QLog.isColorLevel()) {
        QLog.e("IntimateInfoManager", 2, "onResp ResultOk file check invalid.");
      }
      asdz.a(this.a, parambaqw.c);
      return;
    } while (asdz.a(this.a) == null);
    asdz.a(this.a).a((String)localObject, -1L);
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", new Object[] { ((baps)parambaqv).a, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asec
 * JD-Core Version:    0.7.0.1
 */