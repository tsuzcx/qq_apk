import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class arpn
  implements arpg<bbsa>
{
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public arpn(QQAppInterface paramQQAppInterface, Activity paramActivity, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private void a(List<bbsa> paramList)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bbsa localbbsa = (bbsa)paramList.next();
      bbtn localbbtn = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, localbbsa.jdField_a_of_type_JavaUtilUUID.toString(), localbbsa.b, localbbsa.c, localbbsa.jdField_a_of_type_Long, localbbsa.jdField_a_of_type_Int);
      if ((localbbtn != null) && (localbbtn.jdField_a_of_type_JavaUtilUUID != null) && ((localbbtn.b == 10) || (localbbtn.b == 9))) {
        localTroopFileTransferManager.c(localbbtn.jdField_a_of_type_JavaUtilUUID);
      } else {
        localTroopFileTransferManager.a(localbbsa.b, localbbsa.c, localbbsa.jdField_a_of_type_Long, localbbsa.jdField_a_of_type_Int);
      }
    }
  }
  
  private void a(List<bbsa> paramList, arpm paramarpm)
  {
    if (bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Long) == 0) {}
    do
    {
      return;
      paramarpm = bcmu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    } while (paramarpm == null);
    boolean bool1 = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      bbsa localbbsa = (bbsa)paramList.next();
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localbbsa.b());
      if ((!localbbsa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, true)) || ((!bool2) && (!bool1))) {
        break label159;
      }
      paramarpm.b(localbbsa);
      i = 1;
    }
    label159:
    for (;;)
    {
      break;
      if (bool1)
      {
        arri.b(2131692606);
        return;
      }
      if (i != 0)
      {
        arri.b(2131692608);
        return;
      }
      arri.c(2131692607);
      return;
    }
  }
  
  private void b(List<bbsa> paramList)
  {
    if (!bdin.d(this.jdField_a_of_type_AndroidAppActivity))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694831, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298914));
      return;
    }
    Iterator localIterator = paramList.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (bbsa)localIterator.next();
      localObject = arsx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, (bbsa)localObject);
      if (localObject == null) {
        break label146;
      }
      bool = arsx.a(false, ((bbtn)localObject).c, ((bbtn)localObject).e);
    }
    label146:
    for (;;)
    {
      break;
      if (bool)
      {
        arre.a(this.jdField_a_of_type_AndroidAppActivity, 2131692754, 2131692759, new arpq(this, paramList));
        return;
      }
      arsx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Long);
      return;
    }
  }
  
  private void b(List<bbsa> paramList, arpm paramarpm)
  {
    if (!bdin.d(this.jdField_a_of_type_AndroidAppActivity)) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694831, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298914));
    }
    do
    {
      do
      {
        return;
        Iterator localIterator = paramList.iterator();
        for (long l = 0L; localIterator.hasNext(); l = ((bbsa)localIterator.next()).jdField_a_of_type_Long + l) {}
        TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
        if ((!arrr.a()) || (l <= 3145728L)) {
          break;
        }
      } while (!bezm.a(this.jdField_a_of_type_AndroidAppActivity, 1, new arpo(this, paramList, paramarpm)));
      paramList = new arpp(this, paramList, paramarpm);
      paramarpm = this.jdField_a_of_type_AndroidAppActivity.getString(2131697824);
      bdgm.a(this.jdField_a_of_type_AndroidAppActivity, 230, this.jdField_a_of_type_AndroidAppActivity.getString(2131698039), paramarpm, 2131690648, 2131697761, paramList, paramList).show();
      return;
      a(paramList);
    } while (paramarpm == null);
    paramarpm.a(1, 0);
  }
  
  private void c(List<bbsa> paramList)
  {
    if (!bdin.d(this.jdField_a_of_type_AndroidAppActivity))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694831, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298914));
      return;
    }
    Iterator localIterator = paramList.iterator();
    boolean bool = false;
    label46:
    if (localIterator.hasNext())
    {
      Object localObject = (bbsa)localIterator.next();
      localObject = arsx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, (bbsa)localObject);
      if (localObject == null) {
        break label174;
      }
      bool = arsx.a(false, ((bbtn)localObject).c, ((bbtn)localObject).e);
    }
    label174:
    for (;;)
    {
      break label46;
      if (bool)
      {
        if (!bezm.a(this.jdField_a_of_type_AndroidAppActivity, 5, new arpr(this, paramList))) {
          break;
        }
        arre.a(this.jdField_a_of_type_AndroidAppActivity, 2131692754, 2131692757, new arps(this, paramList));
        return;
      }
      arri.d(this.jdField_a_of_type_AndroidAppActivity.getString(2131692914));
      bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, paramList);
      return;
    }
  }
  
  public void a(List<bbsa> paramList, int paramInt, arpm paramarpm)
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
      b(paramList, paramarpm);
      return;
    case 2: 
      b(paramList);
      return;
    case 4: 
      c(paramList);
      return;
    }
    a(paramList, paramarpm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arpn
 * JD-Core Version:    0.7.0.1
 */