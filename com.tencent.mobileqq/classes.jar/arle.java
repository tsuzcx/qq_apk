import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class arle
  implements arkx<bbnr>
{
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public arle(QQAppInterface paramQQAppInterface, Activity paramActivity, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private void a(List<bbnr> paramList)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bbnr localbbnr = (bbnr)paramList.next();
      bbpe localbbpe = bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, localbbnr.jdField_a_of_type_JavaUtilUUID.toString(), localbbnr.b, localbbnr.c, localbbnr.jdField_a_of_type_Long, localbbnr.jdField_a_of_type_Int);
      if ((localbbpe != null) && (localbbpe.jdField_a_of_type_JavaUtilUUID != null) && ((localbbpe.b == 10) || (localbbpe.b == 9))) {
        localTroopFileTransferManager.c(localbbpe.jdField_a_of_type_JavaUtilUUID);
      } else {
        localTroopFileTransferManager.a(localbbnr.b, localbbnr.c, localbbnr.jdField_a_of_type_Long, localbbnr.jdField_a_of_type_Int);
      }
    }
  }
  
  private void a(List<bbnr> paramList, arld paramarld)
  {
    if (bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Long) == 0) {}
    do
    {
      return;
      paramarld = bcil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    } while (paramarld == null);
    boolean bool1 = bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      bbnr localbbnr = (bbnr)paramList.next();
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localbbnr.b());
      if ((!localbbnr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, true)) || ((!bool2) && (!bool1))) {
        break label159;
      }
      paramarld.b(localbbnr);
      i = 1;
    }
    label159:
    for (;;)
    {
      break;
      if (bool1)
      {
        armz.b(2131692605);
        return;
      }
      if (i != 0)
      {
        armz.b(2131692607);
        return;
      }
      armz.c(2131692606);
      return;
    }
  }
  
  private void b(List<bbnr> paramList)
  {
    if (!bdee.d(this.jdField_a_of_type_AndroidAppActivity))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694829, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298914));
      return;
    }
    Iterator localIterator = paramList.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (bbnr)localIterator.next();
      localObject = aroo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, (bbnr)localObject);
      if (localObject == null) {
        break label146;
      }
      bool = aroo.a(false, ((bbpe)localObject).c, ((bbpe)localObject).e);
    }
    label146:
    for (;;)
    {
      break;
      if (bool)
      {
        armv.a(this.jdField_a_of_type_AndroidAppActivity, 2131692752, 2131692757, new arlh(this, paramList));
        return;
      }
      aroo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Long);
      return;
    }
  }
  
  private void b(List<bbnr> paramList, arld paramarld)
  {
    if (!bdee.d(this.jdField_a_of_type_AndroidAppActivity)) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694829, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298914));
    }
    do
    {
      do
      {
        return;
        Iterator localIterator = paramList.iterator();
        for (long l = 0L; localIterator.hasNext(); l = ((bbnr)localIterator.next()).jdField_a_of_type_Long + l) {}
        TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
        if ((!arni.a()) || (l <= 3145728L)) {
          break;
        }
      } while (!bevd.a(this.jdField_a_of_type_AndroidAppActivity, 1, new arlf(this, paramList, paramarld)));
      paramList = new arlg(this, paramList, paramarld);
      paramarld = this.jdField_a_of_type_AndroidAppActivity.getString(2131697822);
      bdcd.a(this.jdField_a_of_type_AndroidAppActivity, 230, this.jdField_a_of_type_AndroidAppActivity.getString(2131698037), paramarld, 2131690648, 2131697759, paramList, paramList).show();
      return;
      a(paramList);
    } while (paramarld == null);
    paramarld.a(1, 0);
  }
  
  private void c(List<bbnr> paramList)
  {
    if (!bdee.d(this.jdField_a_of_type_AndroidAppActivity))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694829, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298914));
      return;
    }
    Iterator localIterator = paramList.iterator();
    boolean bool = false;
    label46:
    if (localIterator.hasNext())
    {
      Object localObject = (bbnr)localIterator.next();
      localObject = aroo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, (bbnr)localObject);
      if (localObject == null) {
        break label174;
      }
      bool = aroo.a(false, ((bbpe)localObject).c, ((bbpe)localObject).e);
    }
    label174:
    for (;;)
    {
      break label46;
      if (bool)
      {
        if (!bevd.a(this.jdField_a_of_type_AndroidAppActivity, 5, new arli(this, paramList))) {
          break;
        }
        armv.a(this.jdField_a_of_type_AndroidAppActivity, 2131692752, 2131692755, new arlj(this, paramList));
        return;
      }
      armz.d(this.jdField_a_of_type_AndroidAppActivity.getString(2131692912));
      bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, paramList);
      return;
    }
  }
  
  public void a(List<bbnr> paramList, int paramInt, arld paramarld)
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
      b(paramList, paramarld);
      return;
    case 2: 
      b(paramList);
      return;
    case 4: 
      c(paramList);
      return;
    }
    a(paramList, paramarld);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arle
 * JD-Core Version:    0.7.0.1
 */