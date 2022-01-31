import com.tencent.qphone.base.util.QLog;
import java.io.File;

class aqkm
  implements ayxr
{
  aqkm(aqkj paramaqkj) {}
  
  public void a(ayxq paramayxq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("onPreDownloadStart url=%s", new Object[] { paramayxq.a.a }));
    }
  }
  
  public void onResp(aysz paramaysz)
  {
    Object localObject = ((ayrx)paramaysz.jdField_a_of_type_Aysy).a;
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("onResp url=%s result=%s", new Object[] { localObject, Integer.valueOf(paramaysz.jdField_a_of_type_Int) }));
    }
    switch (paramaysz.jdField_a_of_type_Int)
    {
    }
    do
    {
      boolean bool1;
      boolean bool2;
      do
      {
        return;
        if (aqkj.a(this.a) != null) {
          aqkj.a(this.a).a((String)localObject, paramaysz.jdField_a_of_type_Long);
        }
        paramaysz = (ayrx)paramaysz.jdField_a_of_type_Aysy;
        if (!aqkj.a(this.a, paramaysz.c, aqkj.a(this.a))) {
          break;
        }
        localObject = new File(aqkj.a());
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        bool1 = aqkj.b(this.a, paramaysz.c, aqkj.a());
        bool2 = aqkj.a(this.a);
      } while (!QLog.isColorLevel());
      QLog.d("IntimateInfoManager", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      return;
      if (QLog.isColorLevel()) {
        QLog.e("IntimateInfoManager", 2, "onResp ResultOk file check invalid.");
      }
      aqkj.a(this.a, paramaysz.c);
      return;
    } while (aqkj.a(this.a) == null);
    aqkj.a(this.a).a((String)localObject, -1L);
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", new Object[] { ((ayrx)paramaysy).a, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqkm
 * JD-Core Version:    0.7.0.1
 */