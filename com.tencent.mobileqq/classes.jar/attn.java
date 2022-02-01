import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class attn
  extends anua
{
  attn(attl paramattl) {}
  
  protected void a(Object paramObject)
  {
    Object localObject1 = (bftf)paramObject;
    if (localObject1 == null) {}
    aulp localaulp;
    do
    {
      do
      {
        return;
        paramObject = ((bftf)localObject1).jdField_b_of_type_Long + "";
        localObject2 = ((bftf)localObject1).e;
        localaulp = this.a.a("1", paramObject, (String)localObject2);
      } while (localaulp == null);
      switch (((bftf)localObject1).jdField_b_of_type_Int)
      {
      default: 
        return;
      }
    } while (localaulp.a() == null);
    Object localObject2 = new Bundle();
    int i = (int)((float)((bftf)localObject1).d * 1.0F / ((float)((bftf)localObject1).c * 1.0F) * 100.0F);
    localaulp.a().a(0, Integer.parseInt("1"), paramObject, i, (Bundle)localObject2);
    return;
    QLog.i("QFileMultiControlManager<QFile>", 1, "troop file download is finish. fileId[" + (String)localObject2 + "]");
    if (localaulp.a() != null)
    {
      localObject2 = new Bundle();
      boolean bool = bhmi.b(((bftf)localObject1).a);
      localaulp.a().a(bool, Integer.parseInt("1"), paramObject, (Bundle)localObject2);
    }
    this.a.b(localaulp);
    return;
    QLog.i("QFileMultiControlManager<QFile>", 1, "troop file download is stop. fileId[" + (String)localObject2 + "]");
    if (localaulp.a() != null)
    {
      localObject1 = new Bundle();
      localaulp.a().a(false, Integer.parseInt("1"), paramObject, (Bundle)localObject1);
    }
    this.a.b(localaulp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     attn
 * JD-Core Version:    0.7.0.1
 */