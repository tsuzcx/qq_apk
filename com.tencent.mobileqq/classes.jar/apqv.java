import com.tencent.qphone.base.util.QLog;
import java.io.File;

class apqv
  implements axxi
{
  apqv(apqs paramapqs) {}
  
  public void a(axxh paramaxxh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("onPreDownloadStart url=%s", new Object[] { paramaxxh.a.a }));
    }
  }
  
  public void onResp(axsq paramaxsq)
  {
    Object localObject = ((axro)paramaxsq.jdField_a_of_type_Axsp).a;
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("onResp url=%s result=%s", new Object[] { localObject, Integer.valueOf(paramaxsq.jdField_a_of_type_Int) }));
    }
    switch (paramaxsq.jdField_a_of_type_Int)
    {
    }
    do
    {
      boolean bool1;
      boolean bool2;
      do
      {
        return;
        if (apqs.a(this.a) != null) {
          apqs.a(this.a).a((String)localObject, paramaxsq.jdField_a_of_type_Long);
        }
        paramaxsq = (axro)paramaxsq.jdField_a_of_type_Axsp;
        if (!apqs.a(this.a, paramaxsq.c, apqs.a(this.a))) {
          break;
        }
        localObject = new File(apqs.a());
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        bool1 = apqs.b(this.a, paramaxsq.c, apqs.a());
        bool2 = apqs.a(this.a);
      } while (!QLog.isColorLevel());
      QLog.d("IntimateInfoManager", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      return;
      if (QLog.isColorLevel()) {
        QLog.e("IntimateInfoManager", 2, "onResp ResultOk file check invalid.");
      }
      apqs.a(this.a, paramaxsq.c);
      return;
    } while (apqs.a(this.a) == null);
    apqs.a(this.a).a((String)localObject, -1L);
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", new Object[] { ((axro)paramaxsp).a, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apqv
 * JD-Core Version:    0.7.0.1
 */