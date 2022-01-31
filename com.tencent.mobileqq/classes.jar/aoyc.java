import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class aoyc
  extends ajsy
{
  aoyc(aoya paramaoya) {}
  
  protected void a(Object paramObject)
  {
    Object localObject1 = (azqv)paramObject;
    if (localObject1 == null) {}
    apsm localapsm;
    do
    {
      do
      {
        return;
        paramObject = ((azqv)localObject1).jdField_b_of_type_Long + "";
        localObject2 = ((azqv)localObject1).e;
        localapsm = this.a.a("1", paramObject, (String)localObject2);
      } while (localapsm == null);
      switch (((azqv)localObject1).jdField_b_of_type_Int)
      {
      default: 
        return;
      }
    } while (localapsm.a() == null);
    Object localObject2 = new Bundle();
    int i = (int)((float)((azqv)localObject1).d * 1.0F / ((float)((azqv)localObject1).c * 1.0F) * 100.0F);
    localapsm.a().a(0, Integer.parseInt("1"), paramObject, i, (Bundle)localObject2);
    return;
    QLog.i("QFileMultiControlManager<QFile>", 1, "troop file download is finish. fileId[" + (String)localObject2 + "]");
    if (localapsm.a() != null)
    {
      localObject2 = new Bundle();
      boolean bool = bbdx.b(((azqv)localObject1).a);
      localapsm.a().a(bool, Integer.parseInt("1"), paramObject, (Bundle)localObject2);
    }
    this.a.b(localapsm);
    return;
    QLog.i("QFileMultiControlManager<QFile>", 1, "troop file download is stop. fileId[" + (String)localObject2 + "]");
    if (localapsm.a() != null)
    {
      localObject1 = new Bundle();
      localapsm.a().a(false, Integer.parseInt("1"), paramObject, (Bundle)localObject1);
    }
    this.a.b(localapsm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoyc
 * JD-Core Version:    0.7.0.1
 */