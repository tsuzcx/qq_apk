import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class aqvj
  extends alpa
{
  aqvj(aqvh paramaqvh) {}
  
  protected void a(Object paramObject)
  {
    Object localObject1 = (bbtn)paramObject;
    if (localObject1 == null) {}
    arpx localarpx;
    do
    {
      do
      {
        return;
        paramObject = ((bbtn)localObject1).jdField_b_of_type_Long + "";
        localObject2 = ((bbtn)localObject1).e;
        localarpx = this.a.a("1", paramObject, (String)localObject2);
      } while (localarpx == null);
      switch (((bbtn)localObject1).jdField_b_of_type_Int)
      {
      default: 
        return;
      }
    } while (localarpx.a() == null);
    Object localObject2 = new Bundle();
    int i = (int)((float)((bbtn)localObject1).d * 1.0F / ((float)((bbtn)localObject1).c * 1.0F) * 100.0F);
    localarpx.a().a(0, Integer.parseInt("1"), paramObject, i, (Bundle)localObject2);
    return;
    QLog.i("QFileMultiControlManager<QFile>", 1, "troop file download is finish. fileId[" + (String)localObject2 + "]");
    if (localarpx.a() != null)
    {
      localObject2 = new Bundle();
      boolean bool = bdhb.b(((bbtn)localObject1).a);
      localarpx.a().a(bool, Integer.parseInt("1"), paramObject, (Bundle)localObject2);
    }
    this.a.b(localarpx);
    return;
    QLog.i("QFileMultiControlManager<QFile>", 1, "troop file download is stop. fileId[" + (String)localObject2 + "]");
    if (localarpx.a() != null)
    {
      localObject1 = new Bundle();
      localarpx.a().a(false, Integer.parseInt("1"), paramObject, (Bundle)localObject1);
    }
    this.a.b(localarpx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqvj
 * JD-Core Version:    0.7.0.1
 */