import com.tencent.qphone.base.util.QLog;
import java.io.File;

class asil
  implements bazz
{
  asil(asii paramasii) {}
  
  public void a(bazy parambazy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("onPreDownloadStart url=%s", new Object[] { parambazy.a.a }));
    }
  }
  
  public void onResp(bavf parambavf)
  {
    Object localObject = ((baub)parambavf.jdField_a_of_type_Bave).a;
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("onResp url=%s result=%s", new Object[] { localObject, Integer.valueOf(parambavf.jdField_a_of_type_Int) }));
    }
    switch (parambavf.jdField_a_of_type_Int)
    {
    }
    do
    {
      boolean bool1;
      boolean bool2;
      do
      {
        return;
        if (asii.a(this.a) != null) {
          asii.a(this.a).a((String)localObject, parambavf.jdField_a_of_type_Long);
        }
        parambavf = (baub)parambavf.jdField_a_of_type_Bave;
        if (!asii.a(this.a, parambavf.c, asii.a(this.a))) {
          break;
        }
        localObject = new File(asii.a());
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        bool1 = asii.b(this.a, parambavf.c, asii.a());
        bool2 = asii.a(this.a);
      } while (!QLog.isColorLevel());
      QLog.d("IntimateInfoManager", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      return;
      if (QLog.isColorLevel()) {
        QLog.e("IntimateInfoManager", 2, "onResp ResultOk file check invalid.");
      }
      asii.a(this.a, parambavf.c);
      return;
    } while (asii.a(this.a) == null);
    asii.a(this.a).a((String)localObject, -1L);
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", new Object[] { ((baub)parambave).a, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asil
 * JD-Core Version:    0.7.0.1
 */