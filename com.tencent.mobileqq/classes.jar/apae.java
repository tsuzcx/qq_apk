import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class apae
  implements aozx<ayoq>
{
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public apae(QQAppInterface paramQQAppInterface, Activity paramActivity, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private void a(List<ayoq> paramList)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ayoq localayoq = (ayoq)paramList.next();
      ayqd localayqd = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, localayoq.jdField_a_of_type_JavaUtilUUID.toString(), localayoq.b, localayoq.c, localayoq.jdField_a_of_type_Long, localayoq.jdField_a_of_type_Int);
      if ((localayqd != null) && (localayqd.jdField_a_of_type_JavaUtilUUID != null) && ((localayqd.b == 10) || (localayqd.b == 9))) {
        localTroopFileTransferManager.c(localayqd.jdField_a_of_type_JavaUtilUUID);
      } else {
        localTroopFileTransferManager.a(localayoq.b, localayoq.c, localayoq.jdField_a_of_type_Long, localayoq.jdField_a_of_type_Int);
      }
    }
  }
  
  private void a(List<ayoq> paramList, apad paramapad)
  {
    if (azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Long) == 0) {}
    do
    {
      return;
      paramapad = azih.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    } while (paramapad == null);
    boolean bool1 = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      ayoq localayoq = (ayoq)paramList.next();
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localayoq.b());
      if ((!localayoq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, true)) || ((!bool2) && (!bool1))) {
        break label159;
      }
      paramapad.b(localayoq);
      i = 1;
    }
    label159:
    for (;;)
    {
      break;
      if (bool1)
      {
        apcb.b(2131626910);
        return;
      }
      if (i != 0)
      {
        apcb.b(2131626912);
        return;
      }
      apcb.c(2131626911);
      return;
    }
  }
  
  private void b(List<ayoq> paramList)
  {
    if (!badq.d(this.jdField_a_of_type_AndroidAppActivity))
    {
      bbmy.a(this.jdField_a_of_type_AndroidAppActivity, 2131629008, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131167766));
      return;
    }
    Iterator localIterator = paramList.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (ayoq)localIterator.next();
      localObject = apdq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, (ayoq)localObject);
      if (localObject == null) {
        break label146;
      }
      bool = apdq.a(false, ((ayqd)localObject).c, ((ayqd)localObject).e);
    }
    label146:
    for (;;)
    {
      break;
      if (bool)
      {
        apbx.a(this.jdField_a_of_type_AndroidAppActivity, 2131627035, 2131627040, new apah(this, paramList));
        return;
      }
      apdq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Long);
      return;
    }
  }
  
  private void b(List<ayoq> paramList, apad paramapad)
  {
    if (!badq.d(this.jdField_a_of_type_AndroidAppActivity)) {
      bbmy.a(this.jdField_a_of_type_AndroidAppActivity, 2131629008, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131167766));
    }
    do
    {
      do
      {
        return;
        Iterator localIterator = paramList.iterator();
        for (long l = 0L; localIterator.hasNext(); l = ((ayoq)localIterator.next()).jdField_a_of_type_Long + l) {}
        TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
        if ((!apck.a()) || (l <= 3145728L)) {
          break;
        }
      } while (!bbrm.a(this.jdField_a_of_type_AndroidAppActivity, 1, new apaf(this, paramList, paramapad)));
      paramList = new apag(this, paramList, paramapad);
      paramapad = this.jdField_a_of_type_AndroidAppActivity.getString(2131631932);
      babr.a(this.jdField_a_of_type_AndroidAppActivity, 230, this.jdField_a_of_type_AndroidAppActivity.getString(2131632130), paramapad, 2131625035, 2131631869, paramList, paramList).show();
      return;
      a(paramList);
    } while (paramapad == null);
    paramapad.a(1, 0);
  }
  
  private void c(List<ayoq> paramList)
  {
    if (!badq.d(this.jdField_a_of_type_AndroidAppActivity))
    {
      bbmy.a(this.jdField_a_of_type_AndroidAppActivity, 2131629008, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131167766));
      return;
    }
    Iterator localIterator = paramList.iterator();
    boolean bool = false;
    label46:
    if (localIterator.hasNext())
    {
      Object localObject = (ayoq)localIterator.next();
      localObject = apdq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, (ayoq)localObject);
      if (localObject == null) {
        break label174;
      }
      bool = apdq.a(false, ((ayqd)localObject).c, ((ayqd)localObject).e);
    }
    label174:
    for (;;)
    {
      break label46;
      if (bool)
      {
        if (!bbrm.a(this.jdField_a_of_type_AndroidAppActivity, 5, new apai(this, paramList))) {
          break;
        }
        apbx.a(this.jdField_a_of_type_AndroidAppActivity, 2131627035, 2131627038, new apaj(this, paramList));
        return;
      }
      apcb.d(this.jdField_a_of_type_AndroidAppActivity.getString(2131627191));
      azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, paramList);
      return;
    }
  }
  
  public void a(List<ayoq> paramList, int paramInt, apad paramapad)
  {
    QLog.i("TroopFileMultiOperate", 1, "doFileMultiOperate. operateType[" + paramInt + "]");
    if ((paramList == null) || (paramList.isEmpty()))
    {
      QLog.i("TroopFileMultiOperate", 1, "doFileMultiOperate. file list is null");
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      b(paramList, paramapad);
      return;
    case 2: 
      b(paramList);
      return;
    case 4: 
      c(paramList);
      return;
    }
    a(paramList, paramapad);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apae
 * JD-Core Version:    0.7.0.1
 */