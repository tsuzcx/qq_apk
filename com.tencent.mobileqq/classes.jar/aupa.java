import com.tencent.qphone.base.util.QLog;
import java.io.File;

class aupa
  implements beav
{
  aupa(auox paramauox) {}
  
  public void a(beau parambeau)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("onPreDownloadStart url=%s", new Object[] { parambeau.a.a }));
    }
  }
  
  public void onResp(bdwt parambdwt)
  {
    Object localObject = ((bdvs)parambdwt.jdField_a_of_type_Bdws).a;
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("onResp url=%s result=%s", new Object[] { localObject, Integer.valueOf(parambdwt.jdField_a_of_type_Int) }));
    }
    switch (parambdwt.jdField_a_of_type_Int)
    {
    }
    do
    {
      boolean bool1;
      boolean bool2;
      do
      {
        return;
        if (auox.a(this.a) != null) {
          auox.a(this.a).a((String)localObject, parambdwt.jdField_a_of_type_Long);
        }
        parambdwt = (bdvs)parambdwt.jdField_a_of_type_Bdws;
        if (!auox.a(this.a, parambdwt.c, auox.a(this.a))) {
          break;
        }
        localObject = new File(auox.a());
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        bool1 = auox.b(this.a, parambdwt.c, auox.a());
        bool2 = auox.a(this.a);
      } while (!QLog.isColorLevel());
      QLog.d("IntimateInfoManager", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      return;
      if (QLog.isColorLevel()) {
        QLog.e("IntimateInfoManager", 2, "onResp ResultOk file check invalid.");
      }
      auox.a(this.a, parambdwt.c);
      return;
    } while (auox.a(this.a) == null);
    auox.a(this.a).a((String)localObject, -1L);
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", new Object[] { ((bdvs)parambdws).a, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aupa
 * JD-Core Version:    0.7.0.1
 */