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

public class aulf
  implements auky<bfrs>
{
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public aulf(QQAppInterface paramQQAppInterface, Activity paramActivity, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private void a(List<bfrs> paramList)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bfrs localbfrs = (bfrs)paramList.next();
      bftf localbftf = bgsk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, localbfrs.jdField_a_of_type_JavaUtilUUID.toString(), localbfrs.jdField_b_of_type_JavaLangString, localbfrs.jdField_c_of_type_JavaLangString, localbfrs.jdField_a_of_type_Long, localbfrs.jdField_a_of_type_Int);
      if ((localbftf != null) && (localbftf.jdField_a_of_type_JavaUtilUUID != null) && ((localbftf.jdField_b_of_type_Int == 10) || (localbftf.jdField_b_of_type_Int == 9))) {
        localTroopFileTransferManager.c(localbftf.jdField_a_of_type_JavaUtilUUID);
      } else {
        localTroopFileTransferManager.a(localbfrs.jdField_b_of_type_JavaLangString, localbfrs.jdField_c_of_type_JavaLangString, localbfrs.jdField_a_of_type_Long, localbfrs.jdField_a_of_type_Int);
      }
    }
  }
  
  private void a(List<bfrs> paramList, aule paramaule)
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
        paramaule = (bfrs)paramList.next();
        Object localObject = new bftf();
        ((bftf)localObject).g = paramaule.jdField_c_of_type_JavaLangString;
        ((bftf)localObject).jdField_a_of_type_JavaLangString = paramaule.h;
        ((bftf)localObject).jdField_c_of_type_Long = paramaule.jdField_a_of_type_Long;
        ((bftf)localObject).jdField_d_of_type_Long = paramaule.jdField_d_of_type_Long;
        ((bftf)localObject).jdField_a_of_type_JavaUtilUUID = paramaule.jdField_a_of_type_JavaUtilUUID;
        ((bftf)localObject).jdField_b_of_type_Long = this.jdField_a_of_type_Long;
        ((bftf)localObject).h = paramaule.jdField_a_of_type_Int;
        ((bftf)localObject).e = paramaule.jdField_b_of_type_JavaLangString;
        ((bftf)localObject).f = paramaule.jdField_d_of_type_JavaLangString;
        ((bftf)localObject).jdField_b_of_type_JavaLangString = paramaule.i;
        ((bftf)localObject).jdField_c_of_type_JavaLangString = paramaule.j;
        ((bftf)localObject).jdField_d_of_type_JavaLangString = paramaule.k;
        ((bftf)localObject).jdField_b_of_type_Int = paramaule.e;
        bgrn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(((bftf)localObject).jdField_a_of_type_JavaUtilUUID);
        localObject = aunj.a((bftf)localObject);
        if (paramaule.jdField_b_of_type_Long != 0L) {
          ((FileManagerEntity)localObject).selfUin = ("" + paramaule.jdField_b_of_type_Long);
        }
        if (paramaule.jdField_c_of_type_Int != 0) {
          ((FileManagerEntity)localObject).lastTime = paramaule.jdField_c_of_type_Int;
        }
        ((FileManagerEntity)localObject).bSend = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount().equals(((FileManagerEntity)localObject).selfUin);
        if (new bmko(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject, null, false)) {
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
        aunj.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131697475));
        return;
      }
    }
  }
  
  private void b(List<bfrs> paramList)
  {
    if (!bhnv.d(this.jdField_a_of_type_AndroidAppActivity))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694008, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299011));
      return;
    }
    Iterator localIterator = paramList.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (bfrs)localIterator.next();
      localObject = auoo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, (bfrs)localObject);
      if (localObject == null) {
        break label146;
      }
      bool = auoo.a(false, ((bftf)localObject).jdField_c_of_type_Long, ((bftf)localObject).e);
    }
    label146:
    for (;;)
    {
      break;
      if (bool)
      {
        aumw.a(this.jdField_a_of_type_AndroidAppActivity, 2131692326, 2131692331, new auli(this, paramList));
        return;
      }
      auoo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Long);
      return;
    }
  }
  
  private void b(List<bfrs> paramList, aule paramaule)
  {
    if (bgsk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Long) == 0) {}
    do
    {
      return;
      paramaule = bgrn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    } while (paramaule == null);
    boolean bool1 = bgsk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      bfrs localbfrs = (bfrs)paramList.next();
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localbfrs.b());
      if ((!localbfrs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, true)) || ((!bool2) && (!bool1))) {
        break label162;
      }
      paramaule.b(localbfrs);
      i = 1;
    }
    label162:
    for (;;)
    {
      break;
      if (bool1)
      {
        auna.b(2131692198);
        return;
      }
      if (i != 0)
      {
        auna.b(2131692200);
        return;
      }
      auna.c(2131692199);
      return;
    }
  }
  
  private void c(List<bfrs> paramList)
  {
    if (!bhnv.d(this.jdField_a_of_type_AndroidAppActivity))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694008, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299011));
      return;
    }
    Iterator localIterator = paramList.iterator();
    boolean bool = false;
    label46:
    if (localIterator.hasNext())
    {
      Object localObject = (bfrs)localIterator.next();
      localObject = auoo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, (bfrs)localObject);
      if (localObject == null) {
        break label176;
      }
      bool = auoo.a(false, ((bftf)localObject).jdField_c_of_type_Long, ((bftf)localObject).e);
    }
    label176:
    for (;;)
    {
      break label46;
      if (bool)
      {
        if (!bjhk.a(this.jdField_a_of_type_AndroidAppActivity, 5, new aulj(this, paramList))) {
          break;
        }
        aumw.a(this.jdField_a_of_type_AndroidAppActivity, 2131692326, 2131692329, new aulk(this, paramList));
        return;
      }
      auna.d(this.jdField_a_of_type_AndroidAppActivity.getString(2131692445));
      bgsk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, paramList);
      return;
    }
  }
  
  private void c(List<bfrs> paramList, aule paramaule)
  {
    if (!bhnv.d(this.jdField_a_of_type_AndroidAppActivity)) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694008, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299011));
    }
    do
    {
      do
      {
        return;
        Iterator localIterator = paramList.iterator();
        for (long l = 0L; localIterator.hasNext(); l = ((bfrs)localIterator.next()).jdField_a_of_type_Long + l) {}
        TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
        if ((!aunj.a()) || (l <= 3145728L)) {
          break;
        }
      } while (!bjhk.a(this.jdField_a_of_type_AndroidAppActivity, 1, new aulg(this, paramList, paramaule)));
      paramList = new aulh(this, paramList, paramaule);
      paramaule = this.jdField_a_of_type_AndroidAppActivity.getString(2131696715);
      bhlq.a(this.jdField_a_of_type_AndroidAppActivity, 230, this.jdField_a_of_type_AndroidAppActivity.getString(2131696934), paramaule, 2131690580, 2131696652, paramList, paramList).show();
      return;
      a(paramList);
    } while (paramaule == null);
    paramaule.a(1, 0);
  }
  
  public void a(List<bfrs> paramList, int paramInt, aule paramaule)
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
      c(paramList, paramaule);
      return;
    case 2: 
      b(paramList);
      return;
    case 4: 
      c(paramList);
      return;
    case 3: 
      b(paramList, paramaule);
      return;
    }
    a(paramList, paramaule);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aulf
 * JD-Core Version:    0.7.0.1
 */