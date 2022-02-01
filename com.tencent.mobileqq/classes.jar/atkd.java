import android.os.Bundle;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class atkd
  extends anrc
{
  atkd(atkb paramatkb) {}
  
  protected void a(Object paramObject)
  {
    Object localObject1 = (bfjs)paramObject;
    if (localObject1 == null) {}
    aucg localaucg;
    do
    {
      do
      {
        return;
        paramObject = ((bfjs)localObject1).jdField_b_of_type_Long + "";
        localObject2 = ((bfjs)localObject1).e;
        localaucg = this.a.a("1", paramObject, (String)localObject2);
      } while (localaucg == null);
      switch (((bfjs)localObject1).jdField_b_of_type_Int)
      {
      default: 
        return;
      }
    } while (localaucg.a() == null);
    Object localObject2 = new Bundle();
    int i = (int)((float)((bfjs)localObject1).d * 1.0F / ((float)((bfjs)localObject1).c * 1.0F) * 100.0F);
    localaucg.a().a(0, Integer.parseInt("1"), paramObject, i, (Bundle)localObject2);
    return;
    QLog.i("QFileMultiControlManager<QFile>", 1, "troop file download is finish. fileId[" + (String)localObject2 + "]");
    if (localaucg.a() != null)
    {
      localObject2 = new Bundle();
      boolean bool = FileUtils.fileExistsAndNotEmpty(((bfjs)localObject1).a);
      localaucg.a().a(bool, Integer.parseInt("1"), paramObject, (Bundle)localObject2);
    }
    this.a.b(localaucg);
    return;
    QLog.i("QFileMultiControlManager<QFile>", 1, "troop file download is stop. fileId[" + (String)localObject2 + "]");
    if (localaucg.a() != null)
    {
      localObject1 = new Bundle();
      localaucg.a().a(false, Integer.parseInt("1"), paramObject, (Bundle)localObject1);
    }
    this.a.b(localaucg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atkd
 * JD-Core Version:    0.7.0.1
 */