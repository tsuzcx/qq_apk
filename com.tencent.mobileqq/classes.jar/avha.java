import com.tencent.qphone.base.util.QLog;
import java.io.File;

class avha
  implements bezu
{
  avha(avgx paramavgx) {}
  
  public void a(bezt parambezt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("onPreDownloadStart url=%s", new Object[] { parambezt.a.a }));
    }
  }
  
  public void onResp(bevm parambevm)
  {
    Object localObject = ((beum)parambevm.jdField_a_of_type_Bevl).a;
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("onResp url=%s result=%s", new Object[] { localObject, Integer.valueOf(parambevm.jdField_a_of_type_Int) }));
    }
    switch (parambevm.jdField_a_of_type_Int)
    {
    }
    do
    {
      boolean bool1;
      boolean bool2;
      do
      {
        return;
        if (avgx.a(this.a) != null) {
          avgx.a(this.a).a((String)localObject, parambevm.jdField_a_of_type_Long);
        }
        parambevm = (beum)parambevm.jdField_a_of_type_Bevl;
        if (!avgx.a(this.a, parambevm.c, avgx.a(this.a))) {
          break;
        }
        localObject = new File(avgx.a());
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        bool1 = avgx.b(this.a, parambevm.c, avgx.a());
        bool2 = avgx.a(this.a);
      } while (!QLog.isColorLevel());
      QLog.d("IntimateInfoManager", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      return;
      if (QLog.isColorLevel()) {
        QLog.e("IntimateInfoManager", 2, "onResp ResultOk file check invalid.");
      }
      avgx.a(this.a, parambevm.c);
      return;
    } while (avgx.a(this.a) == null);
    avgx.a(this.a).a((String)localObject, -1L);
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", new Object[] { ((beum)parambevl).a, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avha
 * JD-Core Version:    0.7.0.1
 */