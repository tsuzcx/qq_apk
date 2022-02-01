import android.os.Bundle;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class asfx
  extends amop
{
  asfx(asfv paramasfv) {}
  
  protected void a(Object paramObject)
  {
    Object localObject1 = (becp)paramObject;
    if (localObject1 == null) {}
    asxz localasxz;
    do
    {
      do
      {
        return;
        paramObject = ((becp)localObject1).jdField_b_of_type_Long + "";
        localObject2 = ((becp)localObject1).e;
        localasxz = this.a.a("1", paramObject, (String)localObject2);
      } while (localasxz == null);
      switch (((becp)localObject1).jdField_b_of_type_Int)
      {
      default: 
        return;
      }
    } while (localasxz.a() == null);
    Object localObject2 = new Bundle();
    int i = (int)((float)((becp)localObject1).d * 1.0F / ((float)((becp)localObject1).c * 1.0F) * 100.0F);
    localasxz.a().a(0, Integer.parseInt("1"), paramObject, i, (Bundle)localObject2);
    return;
    QLog.i("QFileMultiControlManager<QFile>", 1, "troop file download is finish. fileId[" + (String)localObject2 + "]");
    if (localasxz.a() != null)
    {
      localObject2 = new Bundle();
      boolean bool = FileUtils.fileExistsAndNotEmpty(((becp)localObject1).a);
      localasxz.a().a(bool, Integer.parseInt("1"), paramObject, (Bundle)localObject2);
    }
    this.a.b(localasxz);
    return;
    QLog.i("QFileMultiControlManager<QFile>", 1, "troop file download is stop. fileId[" + (String)localObject2 + "]");
    if (localasxz.a() != null)
    {
      localObject1 = new Bundle();
      localasxz.a().a(false, Integer.parseInt("1"), paramObject, (Bundle)localObject1);
    }
    this.a.b(localasxz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asfx
 * JD-Core Version:    0.7.0.1
 */