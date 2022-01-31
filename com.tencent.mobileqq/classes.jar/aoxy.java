import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class aoxy
  extends ajta
{
  aoxy(aoxw paramaoxw) {}
  
  protected void a(Object paramObject)
  {
    Object localObject1 = (azqt)paramObject;
    if (localObject1 == null) {}
    apsi localapsi;
    do
    {
      do
      {
        return;
        paramObject = ((azqt)localObject1).jdField_b_of_type_Long + "";
        localObject2 = ((azqt)localObject1).e;
        localapsi = this.a.a("1", paramObject, (String)localObject2);
      } while (localapsi == null);
      switch (((azqt)localObject1).jdField_b_of_type_Int)
      {
      default: 
        return;
      }
    } while (localapsi.a() == null);
    Object localObject2 = new Bundle();
    int i = (int)((float)((azqt)localObject1).d * 1.0F / ((float)((azqt)localObject1).c * 1.0F) * 100.0F);
    localapsi.a().a(0, Integer.parseInt("1"), paramObject, i, (Bundle)localObject2);
    return;
    QLog.i("QFileMultiControlManager<QFile>", 1, "troop file download is finish. fileId[" + (String)localObject2 + "]");
    if (localapsi.a() != null)
    {
      localObject2 = new Bundle();
      boolean bool = bbdj.b(((azqt)localObject1).a);
      localapsi.a().a(bool, Integer.parseInt("1"), paramObject, (Bundle)localObject2);
    }
    this.a.b(localapsi);
    return;
    QLog.i("QFileMultiControlManager<QFile>", 1, "troop file download is stop. fileId[" + (String)localObject2 + "]");
    if (localapsi.a() != null)
    {
      localObject1 = new Bundle();
      localapsi.a().a(false, Integer.parseInt("1"), paramObject, (Bundle)localObject1);
    }
    this.a.b(localapsi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoxy
 * JD-Core Version:    0.7.0.1
 */