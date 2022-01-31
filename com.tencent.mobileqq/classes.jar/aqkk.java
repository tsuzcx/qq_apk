import com.tencent.qphone.base.util.QLog;
import java.io.File;

class aqkk
  implements ayxp
{
  aqkk(aqkh paramaqkh) {}
  
  public void a(ayxo paramayxo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("onPreDownloadStart url=%s", new Object[] { paramayxo.a.a }));
    }
  }
  
  public void onResp(aysx paramaysx)
  {
    Object localObject = ((ayrv)paramaysx.jdField_a_of_type_Aysw).a;
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("onResp url=%s result=%s", new Object[] { localObject, Integer.valueOf(paramaysx.jdField_a_of_type_Int) }));
    }
    switch (paramaysx.jdField_a_of_type_Int)
    {
    }
    do
    {
      boolean bool1;
      boolean bool2;
      do
      {
        return;
        if (aqkh.a(this.a) != null) {
          aqkh.a(this.a).a((String)localObject, paramaysx.jdField_a_of_type_Long);
        }
        paramaysx = (ayrv)paramaysx.jdField_a_of_type_Aysw;
        if (!aqkh.a(this.a, paramaysx.c, aqkh.a(this.a))) {
          break;
        }
        localObject = new File(aqkh.a());
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        bool1 = aqkh.b(this.a, paramaysx.c, aqkh.a());
        bool2 = aqkh.a(this.a);
      } while (!QLog.isColorLevel());
      QLog.d("IntimateInfoManager", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      return;
      if (QLog.isColorLevel()) {
        QLog.e("IntimateInfoManager", 2, "onResp ResultOk file check invalid.");
      }
      aqkh.a(this.a, paramaysx.c);
      return;
    } while (aqkh.a(this.a) == null);
    aqkh.a(this.a).a((String)localObject, -1L);
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", new Object[] { ((ayrv)paramaysw).a, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqkk
 * JD-Core Version:    0.7.0.1
 */