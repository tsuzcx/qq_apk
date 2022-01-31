import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class apsc
  implements aprv<azpi>
{
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public apsc(QQAppInterface paramQQAppInterface, Activity paramActivity, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private void a(List<azpi> paramList)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      azpi localazpi = (azpi)paramList.next();
      azqv localazqv = bakx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, localazpi.jdField_a_of_type_JavaUtilUUID.toString(), localazpi.b, localazpi.c, localazpi.jdField_a_of_type_Long, localazpi.jdField_a_of_type_Int);
      if ((localazqv != null) && (localazqv.jdField_a_of_type_JavaUtilUUID != null) && ((localazqv.b == 10) || (localazqv.b == 9))) {
        localTroopFileTransferManager.c(localazqv.jdField_a_of_type_JavaUtilUUID);
      } else {
        localTroopFileTransferManager.a(localazpi.b, localazpi.c, localazpi.jdField_a_of_type_Long, localazpi.jdField_a_of_type_Int);
      }
    }
  }
  
  private void a(List<azpi> paramList, apsb paramapsb)
  {
    if (bakx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Long) == 0) {}
    do
    {
      return;
      paramapsb = bajy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    } while (paramapsb == null);
    boolean bool1 = bakx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      azpi localazpi = (azpi)paramList.next();
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localazpi.b());
      if ((!localazpi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, true)) || ((!bool2) && (!bool1))) {
        break label159;
      }
      paramapsb.b(localazpi);
      i = 1;
    }
    label159:
    for (;;)
    {
      break;
      if (bool1)
      {
        aptx.b(2131692529);
        return;
      }
      if (i != 0)
      {
        aptx.b(2131692531);
        return;
      }
      aptx.c(2131692530);
      return;
    }
  }
  
  private void b(List<azpi> paramList)
  {
    if (!bbfj.d(this.jdField_a_of_type_AndroidAppActivity))
    {
      bcql.a(this.jdField_a_of_type_AndroidAppActivity, 2131694673, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298865));
      return;
    }
    Iterator localIterator = paramList.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (azpi)localIterator.next();
      localObject = apvm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, (azpi)localObject);
      if (localObject == null) {
        break label146;
      }
      bool = apvm.a(false, ((azqv)localObject).c, ((azqv)localObject).e);
    }
    label146:
    for (;;)
    {
      break;
      if (bool)
      {
        aptt.a(this.jdField_a_of_type_AndroidAppActivity, 2131692673, 2131692678, new apsf(this, paramList));
        return;
      }
      apvm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Long);
      return;
    }
  }
  
  private void b(List<azpi> paramList, apsb paramapsb)
  {
    if (!bbfj.d(this.jdField_a_of_type_AndroidAppActivity)) {
      bcql.a(this.jdField_a_of_type_AndroidAppActivity, 2131694673, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298865));
    }
    do
    {
      do
      {
        return;
        Iterator localIterator = paramList.iterator();
        for (long l = 0L; localIterator.hasNext(); l = ((azpi)localIterator.next()).jdField_a_of_type_Long + l) {}
        TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
        if ((!apug.a()) || (l <= 3145728L)) {
          break;
        }
      } while (!bcwb.a(this.jdField_a_of_type_AndroidAppActivity, 1, new apsd(this, paramList, paramapsb)));
      paramList = new apse(this, paramList, paramapsb);
      paramapsb = this.jdField_a_of_type_AndroidAppActivity.getString(2131697647);
      bbdj.a(this.jdField_a_of_type_AndroidAppActivity, 230, this.jdField_a_of_type_AndroidAppActivity.getString(2131697860), paramapsb, 2131690596, 2131697584, paramList, paramList).show();
      return;
      a(paramList);
    } while (paramapsb == null);
    paramapsb.a(1, 0);
  }
  
  private void c(List<azpi> paramList)
  {
    if (!bbfj.d(this.jdField_a_of_type_AndroidAppActivity))
    {
      bcql.a(this.jdField_a_of_type_AndroidAppActivity, 2131694673, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298865));
      return;
    }
    Iterator localIterator = paramList.iterator();
    boolean bool = false;
    label46:
    if (localIterator.hasNext())
    {
      Object localObject = (azpi)localIterator.next();
      localObject = apvm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, (azpi)localObject);
      if (localObject == null) {
        break label174;
      }
      bool = apvm.a(false, ((azqv)localObject).c, ((azqv)localObject).e);
    }
    label174:
    for (;;)
    {
      break label46;
      if (bool)
      {
        if (!bcwb.a(this.jdField_a_of_type_AndroidAppActivity, 5, new apsg(this, paramList))) {
          break;
        }
        aptt.a(this.jdField_a_of_type_AndroidAppActivity, 2131692673, 2131692676, new apsh(this, paramList));
        return;
      }
      aptx.d(this.jdField_a_of_type_AndroidAppActivity.getString(2131692830));
      bakx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, paramList);
      return;
    }
  }
  
  public void a(List<azpi> paramList, int paramInt, apsb paramapsb)
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
      b(paramList, paramapsb);
      return;
    case 2: 
      b(paramList);
      return;
    case 4: 
      c(paramList);
      return;
    }
    a(paramList, paramapsb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apsc
 * JD-Core Version:    0.7.0.1
 */