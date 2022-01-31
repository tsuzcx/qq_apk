import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class apry
  implements aprr<azpg>
{
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public apry(QQAppInterface paramQQAppInterface, Activity paramActivity, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private void a(List<azpg> paramList)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      azpg localazpg = (azpg)paramList.next();
      azqt localazqt = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, localazpg.jdField_a_of_type_JavaUtilUUID.toString(), localazpg.b, localazpg.c, localazpg.jdField_a_of_type_Long, localazpg.jdField_a_of_type_Int);
      if ((localazqt != null) && (localazqt.jdField_a_of_type_JavaUtilUUID != null) && ((localazqt.b == 10) || (localazqt.b == 9))) {
        localTroopFileTransferManager.c(localazqt.jdField_a_of_type_JavaUtilUUID);
      } else {
        localTroopFileTransferManager.a(localazpg.b, localazpg.c, localazpg.jdField_a_of_type_Long, localazpg.jdField_a_of_type_Int);
      }
    }
  }
  
  private void a(List<azpg> paramList, aprx paramaprx)
  {
    if (bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Long) == 0) {}
    do
    {
      return;
      paramaprx = bajk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    } while (paramaprx == null);
    boolean bool1 = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      azpg localazpg = (azpg)paramList.next();
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localazpg.b());
      if ((!localazpg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, true)) || ((!bool2) && (!bool1))) {
        break label159;
      }
      paramaprx.b(localazpg);
      i = 1;
    }
    label159:
    for (;;)
    {
      break;
      if (bool1)
      {
        aptv.b(2131692528);
        return;
      }
      if (i != 0)
      {
        aptv.b(2131692530);
        return;
      }
      aptv.c(2131692529);
      return;
    }
  }
  
  private void b(List<azpg> paramList)
  {
    if (!bbev.d(this.jdField_a_of_type_AndroidAppActivity))
    {
      bcpw.a(this.jdField_a_of_type_AndroidAppActivity, 2131694672, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298865));
      return;
    }
    Iterator localIterator = paramList.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (azpg)localIterator.next();
      localObject = apvk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, (azpg)localObject);
      if (localObject == null) {
        break label146;
      }
      bool = apvk.a(false, ((azqt)localObject).c, ((azqt)localObject).e);
    }
    label146:
    for (;;)
    {
      break;
      if (bool)
      {
        aptr.a(this.jdField_a_of_type_AndroidAppActivity, 2131692672, 2131692677, new apsb(this, paramList));
        return;
      }
      apvk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Long);
      return;
    }
  }
  
  private void b(List<azpg> paramList, aprx paramaprx)
  {
    if (!bbev.d(this.jdField_a_of_type_AndroidAppActivity)) {
      bcpw.a(this.jdField_a_of_type_AndroidAppActivity, 2131694672, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298865));
    }
    do
    {
      do
      {
        return;
        Iterator localIterator = paramList.iterator();
        for (long l = 0L; localIterator.hasNext(); l = ((azpg)localIterator.next()).jdField_a_of_type_Long + l) {}
        TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
        if ((!apue.a()) || (l <= 3145728L)) {
          break;
        }
      } while (!bcvm.a(this.jdField_a_of_type_AndroidAppActivity, 1, new aprz(this, paramList, paramaprx)));
      paramList = new apsa(this, paramList, paramaprx);
      paramaprx = this.jdField_a_of_type_AndroidAppActivity.getString(2131697646);
      bbcv.a(this.jdField_a_of_type_AndroidAppActivity, 230, this.jdField_a_of_type_AndroidAppActivity.getString(2131697850), paramaprx, 2131690596, 2131697583, paramList, paramList).show();
      return;
      a(paramList);
    } while (paramaprx == null);
    paramaprx.a(1, 0);
  }
  
  private void c(List<azpg> paramList)
  {
    if (!bbev.d(this.jdField_a_of_type_AndroidAppActivity))
    {
      bcpw.a(this.jdField_a_of_type_AndroidAppActivity, 2131694672, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298865));
      return;
    }
    Iterator localIterator = paramList.iterator();
    boolean bool = false;
    label46:
    if (localIterator.hasNext())
    {
      Object localObject = (azpg)localIterator.next();
      localObject = apvk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, (azpg)localObject);
      if (localObject == null) {
        break label174;
      }
      bool = apvk.a(false, ((azqt)localObject).c, ((azqt)localObject).e);
    }
    label174:
    for (;;)
    {
      break label46;
      if (bool)
      {
        if (!bcvm.a(this.jdField_a_of_type_AndroidAppActivity, 5, new apsc(this, paramList))) {
          break;
        }
        aptr.a(this.jdField_a_of_type_AndroidAppActivity, 2131692672, 2131692675, new apsd(this, paramList));
        return;
      }
      aptv.d(this.jdField_a_of_type_AndroidAppActivity.getString(2131692829));
      bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, paramList);
      return;
    }
  }
  
  public void a(List<azpg> paramList, int paramInt, aprx paramaprx)
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
      b(paramList, paramaprx);
      return;
    case 2: 
      b(paramList);
      return;
    case 4: 
      c(paramList);
      return;
    }
    a(paramList, paramaprx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apry
 * JD-Core Version:    0.7.0.1
 */