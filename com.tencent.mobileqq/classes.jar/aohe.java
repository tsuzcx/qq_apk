import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class aohe
  extends ajey
{
  aohe(aohc paramaohc) {}
  
  protected void a(Object paramObject)
  {
    Object localObject1 = (ayqd)paramObject;
    if (localObject1 == null) {}
    apao localapao;
    do
    {
      do
      {
        return;
        paramObject = ((ayqd)localObject1).jdField_b_of_type_Long + "";
        localObject2 = ((ayqd)localObject1).e;
        localapao = this.a.a("1", paramObject, (String)localObject2);
      } while (localapao == null);
      switch (((ayqd)localObject1).jdField_b_of_type_Int)
      {
      default: 
        return;
      }
    } while (localapao.a() == null);
    Object localObject2 = new Bundle();
    int i = (int)((float)((ayqd)localObject1).d * 1.0F / ((float)((ayqd)localObject1).c * 1.0F) * 100.0F);
    localapao.a().a(0, Integer.parseInt("1"), paramObject, i, (Bundle)localObject2);
    return;
    QLog.i("QFileMultiControlManager<QFile>", 1, "troop file download is finish. fileId[" + (String)localObject2 + "]");
    if (localapao.a() != null)
    {
      localObject2 = new Bundle();
      boolean bool = bace.b(((ayqd)localObject1).a);
      localapao.a().a(bool, Integer.parseInt("1"), paramObject, (Bundle)localObject2);
    }
    this.a.b(localapao);
    return;
    QLog.i("QFileMultiControlManager<QFile>", 1, "troop file download is stop. fileId[" + (String)localObject2 + "]");
    if (localapao.a() != null)
    {
      localObject1 = new Bundle();
      localapao.a().a(false, Integer.parseInt("1"), paramObject, (Bundle)localObject1);
    }
    this.a.b(localapao);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aohe
 * JD-Core Version:    0.7.0.1
 */