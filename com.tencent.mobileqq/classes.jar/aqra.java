import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class aqra
  extends alkl
{
  aqra(aqqy paramaqqy) {}
  
  protected void a(Object paramObject)
  {
    Object localObject1 = (bbpe)paramObject;
    if (localObject1 == null) {}
    arlo localarlo;
    do
    {
      do
      {
        return;
        paramObject = ((bbpe)localObject1).jdField_b_of_type_Long + "";
        localObject2 = ((bbpe)localObject1).e;
        localarlo = this.a.a("1", paramObject, (String)localObject2);
      } while (localarlo == null);
      switch (((bbpe)localObject1).jdField_b_of_type_Int)
      {
      default: 
        return;
      }
    } while (localarlo.a() == null);
    Object localObject2 = new Bundle();
    int i = (int)((float)((bbpe)localObject1).d * 1.0F / ((float)((bbpe)localObject1).c * 1.0F) * 100.0F);
    localarlo.a().a(0, Integer.parseInt("1"), paramObject, i, (Bundle)localObject2);
    return;
    QLog.i("QFileMultiControlManager<QFile>", 1, "troop file download is finish. fileId[" + (String)localObject2 + "]");
    if (localarlo.a() != null)
    {
      localObject2 = new Bundle();
      boolean bool = bdcs.b(((bbpe)localObject1).a);
      localarlo.a().a(bool, Integer.parseInt("1"), paramObject, (Bundle)localObject2);
    }
    this.a.b(localarlo);
    return;
    QLog.i("QFileMultiControlManager<QFile>", 1, "troop file download is stop. fileId[" + (String)localObject2 + "]");
    if (localarlo.a() != null)
    {
      localObject1 = new Bundle();
      localarlo.a().a(false, Integer.parseInt("1"), paramObject, (Bundle)localObject1);
    }
    this.a.b(localarlo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqra
 * JD-Core Version:    0.7.0.1
 */