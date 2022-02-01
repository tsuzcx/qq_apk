import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class attk
  implements attd<besl>
{
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public attk(QQAppInterface paramQQAppInterface, Activity paramActivity, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private void a(List<besl> paramList)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      besl localbesl = (besl)paramList.next();
      bety localbety = bfsj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, localbesl.jdField_a_of_type_JavaUtilUUID.toString(), localbesl.jdField_b_of_type_JavaLangString, localbesl.jdField_c_of_type_JavaLangString, localbesl.jdField_a_of_type_Long, localbesl.jdField_a_of_type_Int);
      if ((localbety != null) && (localbety.jdField_a_of_type_JavaUtilUUID != null) && ((localbety.jdField_b_of_type_Int == 10) || (localbety.jdField_b_of_type_Int == 9))) {
        localTroopFileTransferManager.c(localbety.jdField_a_of_type_JavaUtilUUID);
      } else {
        localTroopFileTransferManager.a(localbesl.jdField_b_of_type_JavaLangString, localbesl.jdField_c_of_type_JavaLangString, localbesl.jdField_a_of_type_Long, localbesl.jdField_a_of_type_Int);
      }
    }
  }
  
  private void a(List<besl> paramList, attj paramattj)
  {
    if (paramList == null) {
      QLog.w("TroopFileMultiOperate", 1, "fileList == null");
    }
    label314:
    label315:
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      int i = 0;
      if (paramList.hasNext())
      {
        paramattj = (besl)paramList.next();
        Object localObject = new bety();
        ((bety)localObject).g = paramattj.jdField_c_of_type_JavaLangString;
        ((bety)localObject).jdField_a_of_type_JavaLangString = paramattj.h;
        ((bety)localObject).jdField_c_of_type_Long = paramattj.jdField_a_of_type_Long;
        ((bety)localObject).jdField_d_of_type_Long = paramattj.jdField_d_of_type_Long;
        ((bety)localObject).jdField_a_of_type_JavaUtilUUID = paramattj.jdField_a_of_type_JavaUtilUUID;
        ((bety)localObject).jdField_b_of_type_Long = this.jdField_a_of_type_Long;
        ((bety)localObject).h = paramattj.jdField_a_of_type_Int;
        ((bety)localObject).e = paramattj.jdField_b_of_type_JavaLangString;
        ((bety)localObject).f = paramattj.jdField_d_of_type_JavaLangString;
        ((bety)localObject).jdField_b_of_type_JavaLangString = paramattj.i;
        ((bety)localObject).jdField_c_of_type_JavaLangString = paramattj.j;
        ((bety)localObject).jdField_d_of_type_JavaLangString = paramattj.k;
        ((bety)localObject).jdField_b_of_type_Int = paramattj.e;
        bfrm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(((bety)localObject).jdField_a_of_type_JavaUtilUUID);
        localObject = atvo.a((bety)localObject);
        if (paramattj.jdField_b_of_type_Long != 0L) {
          ((FileManagerEntity)localObject).selfUin = ("" + paramattj.jdField_b_of_type_Long);
        }
        if (paramattj.jdField_c_of_type_Int != 0) {
          ((FileManagerEntity)localObject).lastTime = paramattj.jdField_c_of_type_Int;
        }
        ((FileManagerEntity)localObject).bSend = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount().equals(((FileManagerEntity)localObject).selfUin);
        if (new bljl(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject, null, false)) {
          break label314;
        }
        i = 1;
      }
      for (;;)
      {
        break;
        if (i == 0) {
          break label315;
        }
        atvo.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131697395));
        return;
      }
    }
  }
  
  private void b(List<besl> paramList)
  {
    if (!bgnt.d(this.jdField_a_of_type_AndroidAppActivity))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131693991, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298998));
      return;
    }
    Iterator localIterator = paramList.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (besl)localIterator.next();
      localObject = atwt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, (besl)localObject);
      if (localObject == null) {
        break label146;
      }
      bool = atwt.a(false, ((bety)localObject).jdField_c_of_type_Long, ((bety)localObject).e);
    }
    label146:
    for (;;)
    {
      break;
      if (bool)
      {
        atvb.a(this.jdField_a_of_type_AndroidAppActivity, 2131692321, 2131692326, new attn(this, paramList));
        return;
      }
      atwt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Long);
      return;
    }
  }
  
  private void b(List<besl> paramList, attj paramattj)
  {
    if (bfsj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Long) == 0) {}
    do
    {
      return;
      paramattj = bfrm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    } while (paramattj == null);
    boolean bool1 = bfsj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      besl localbesl = (besl)paramList.next();
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localbesl.b());
      if ((!localbesl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, true)) || ((!bool2) && (!bool1))) {
        break label162;
      }
      paramattj.b(localbesl);
      i = 1;
    }
    label162:
    for (;;)
    {
      break;
      if (bool1)
      {
        atvf.b(2131692193);
        return;
      }
      if (i != 0)
      {
        atvf.b(2131692195);
        return;
      }
      atvf.c(2131692194);
      return;
    }
  }
  
  private void c(List<besl> paramList)
  {
    if (!bgnt.d(this.jdField_a_of_type_AndroidAppActivity))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131693991, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298998));
      return;
    }
    Iterator localIterator = paramList.iterator();
    boolean bool = false;
    label46:
    if (localIterator.hasNext())
    {
      Object localObject = (besl)localIterator.next();
      localObject = atwt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, (besl)localObject);
      if (localObject == null) {
        break label176;
      }
      bool = atwt.a(false, ((bety)localObject).jdField_c_of_type_Long, ((bety)localObject).e);
    }
    label176:
    for (;;)
    {
      break label46;
      if (bool)
      {
        if (!bigl.a(this.jdField_a_of_type_AndroidAppActivity, 5, new atto(this, paramList))) {
          break;
        }
        atvb.a(this.jdField_a_of_type_AndroidAppActivity, 2131692321, 2131692324, new attp(this, paramList));
        return;
      }
      atvf.d(this.jdField_a_of_type_AndroidAppActivity.getString(2131692439));
      bfsj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, paramList);
      return;
    }
  }
  
  private void c(List<besl> paramList, attj paramattj)
  {
    if (!bgnt.d(this.jdField_a_of_type_AndroidAppActivity)) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131693991, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298998));
    }
    do
    {
      do
      {
        return;
        Iterator localIterator = paramList.iterator();
        for (long l = 0L; localIterator.hasNext(); l = ((besl)localIterator.next()).jdField_a_of_type_Long + l) {}
        TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
        if ((!atvo.a()) || (l <= 3145728L)) {
          break;
        }
      } while (!bigl.a(this.jdField_a_of_type_AndroidAppActivity, 1, new attl(this, paramList, paramattj)));
      paramList = new attm(this, paramList, paramattj);
      paramattj = this.jdField_a_of_type_AndroidAppActivity.getString(2131696666);
      bglp.a(this.jdField_a_of_type_AndroidAppActivity, 230, this.jdField_a_of_type_AndroidAppActivity.getString(2131696885), paramattj, 2131690582, 2131696603, paramList, paramList).show();
      return;
      a(paramList);
    } while (paramattj == null);
    paramattj.a(1, 0);
  }
  
  public void a(List<besl> paramList, int paramInt, attj paramattj)
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
      c(paramList, paramattj);
      return;
    case 2: 
      b(paramList);
      return;
    case 4: 
      c(paramList);
      return;
    case 3: 
      b(paramList, paramattj);
      return;
    }
    a(paramList, paramattj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     attk
 * JD-Core Version:    0.7.0.1
 */