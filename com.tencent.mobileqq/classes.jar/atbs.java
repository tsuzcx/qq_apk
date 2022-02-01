import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class atbs
  extends anif
{
  atbs(atbq paramatbq) {}
  
  protected void a(Object paramObject)
  {
    Object localObject1 = (bety)paramObject;
    if (localObject1 == null) {}
    attu localattu;
    do
    {
      do
      {
        return;
        paramObject = ((bety)localObject1).jdField_b_of_type_Long + "";
        localObject2 = ((bety)localObject1).e;
        localattu = this.a.a("1", paramObject, (String)localObject2);
      } while (localattu == null);
      switch (((bety)localObject1).jdField_b_of_type_Int)
      {
      default: 
        return;
      }
    } while (localattu.a() == null);
    Object localObject2 = new Bundle();
    int i = (int)((float)((bety)localObject1).d * 1.0F / ((float)((bety)localObject1).c * 1.0F) * 100.0F);
    localattu.a().a(0, Integer.parseInt("1"), paramObject, i, (Bundle)localObject2);
    return;
    QLog.i("QFileMultiControlManager<QFile>", 1, "troop file download is finish. fileId[" + (String)localObject2 + "]");
    if (localattu.a() != null)
    {
      localObject2 = new Bundle();
      boolean bool = bgmg.b(((bety)localObject1).a);
      localattu.a().a(bool, Integer.parseInt("1"), paramObject, (Bundle)localObject2);
    }
    this.a.b(localattu);
    return;
    QLog.i("QFileMultiControlManager<QFile>", 1, "troop file download is stop. fileId[" + (String)localObject2 + "]");
    if (localattu.a() != null)
    {
      localObject1 = new Bundle();
      localattu.a().a(false, Integer.parseInt("1"), paramObject, (Bundle)localObject1);
    }
    this.a.b(localattu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atbs
 * JD-Core Version:    0.7.0.1
 */