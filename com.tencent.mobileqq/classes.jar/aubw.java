import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class aubw
  implements aubp<bfif>
{
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public aubw(QQAppInterface paramQQAppInterface, Activity paramActivity, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private void a(List<bfif> paramList)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bfif localbfif = (bfif)paramList.next();
      bfjs localbfjs = bgke.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, localbfif.jdField_a_of_type_JavaUtilUUID.toString(), localbfif.jdField_b_of_type_JavaLangString, localbfif.jdField_c_of_type_JavaLangString, localbfif.jdField_a_of_type_Long, localbfif.jdField_a_of_type_Int);
      if ((localbfjs != null) && (localbfjs.jdField_a_of_type_JavaUtilUUID != null) && ((localbfjs.jdField_b_of_type_Int == 10) || (localbfjs.jdField_b_of_type_Int == 9))) {
        localTroopFileTransferManager.c(localbfjs.jdField_a_of_type_JavaUtilUUID);
      } else {
        localTroopFileTransferManager.a(localbfif.jdField_b_of_type_JavaLangString, localbfif.jdField_c_of_type_JavaLangString, localbfif.jdField_a_of_type_Long, localbfif.jdField_a_of_type_Int);
      }
    }
  }
  
  private void a(List<bfif> paramList, aubv paramaubv)
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
        paramaubv = (bfif)paramList.next();
        Object localObject = new bfjs();
        ((bfjs)localObject).g = paramaubv.jdField_c_of_type_JavaLangString;
        ((bfjs)localObject).jdField_a_of_type_JavaLangString = paramaubv.i;
        ((bfjs)localObject).jdField_c_of_type_Long = paramaubv.jdField_a_of_type_Long;
        ((bfjs)localObject).jdField_d_of_type_Long = paramaubv.jdField_d_of_type_Long;
        ((bfjs)localObject).jdField_a_of_type_JavaUtilUUID = paramaubv.jdField_a_of_type_JavaUtilUUID;
        ((bfjs)localObject).jdField_b_of_type_Long = this.jdField_a_of_type_Long;
        ((bfjs)localObject).h = paramaubv.jdField_a_of_type_Int;
        ((bfjs)localObject).e = paramaubv.jdField_b_of_type_JavaLangString;
        ((bfjs)localObject).f = paramaubv.jdField_d_of_type_JavaLangString;
        ((bfjs)localObject).jdField_b_of_type_JavaLangString = paramaubv.j;
        ((bfjs)localObject).jdField_c_of_type_JavaLangString = paramaubv.k;
        ((bfjs)localObject).jdField_d_of_type_JavaLangString = paramaubv.l;
        ((bfjs)localObject).jdField_b_of_type_Int = paramaubv.e;
        bgjh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(((bfjs)localObject).jdField_a_of_type_JavaUtilUUID);
        localObject = auea.a((bfjs)localObject);
        if (paramaubv.jdField_b_of_type_Long != 0L) {
          ((FileManagerEntity)localObject).selfUin = ("" + paramaubv.jdField_b_of_type_Long);
        }
        if (paramaubv.jdField_c_of_type_Int != 0) {
          ((FileManagerEntity)localObject).lastTime = paramaubv.jdField_c_of_type_Int;
        }
        ((FileManagerEntity)localObject).bSend = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount().equals(((FileManagerEntity)localObject).selfUin);
        if (new bmad(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject, null, false)) {
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
        auea.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131697901));
        return;
      }
    }
  }
  
  private void b(List<bfif> paramList)
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidAppActivity))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694305, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299080));
      return;
    }
    Iterator localIterator = paramList.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (bfif)localIterator.next();
      localObject = aufd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, (bfif)localObject);
      if (localObject == null) {
        break label146;
      }
      bool = aufd.a(false, ((bfjs)localObject).jdField_c_of_type_Long, ((bfjs)localObject).e);
    }
    label146:
    for (;;)
    {
      break;
      if (bool)
      {
        audn.a(this.jdField_a_of_type_AndroidAppActivity, 2131692476, 2131692481, new aubz(this, paramList));
        return;
      }
      aufd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Long);
      return;
    }
  }
  
  private void b(List<bfif> paramList, aubv paramaubv)
  {
    if (bgke.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Long) == 0) {}
    do
    {
      return;
      paramaubv = bgjh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    } while (paramaubv == null);
    boolean bool1 = bgke.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      bfif localbfif = (bfif)paramList.next();
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localbfif.b());
      if ((!localbfif.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, true)) || ((!bool2) && (!bool1))) {
        break label162;
      }
      paramaubv.b(localbfif);
      i = 1;
    }
    label162:
    for (;;)
    {
      break;
      if (bool1)
      {
        audr.b(2131692336);
        return;
      }
      if (i != 0)
      {
        audr.b(2131692338);
        return;
      }
      audr.c(2131692337);
      return;
    }
  }
  
  private void c(List<bfif> paramList)
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidAppActivity))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694305, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299080));
      return;
    }
    Iterator localIterator = paramList.iterator();
    boolean bool = false;
    label46:
    if (localIterator.hasNext())
    {
      Object localObject = (bfif)localIterator.next();
      localObject = aufd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, (bfif)localObject);
      if (localObject == null) {
        break label176;
      }
      bool = aufd.a(false, ((bfjs)localObject).jdField_c_of_type_Long, ((bfjs)localObject).e);
    }
    label176:
    for (;;)
    {
      break label46;
      if (bool)
      {
        if (!bixr.a(this.jdField_a_of_type_AndroidAppActivity, 5, new auca(this, paramList))) {
          break;
        }
        audn.a(this.jdField_a_of_type_AndroidAppActivity, 2131692476, 2131692479, new aucb(this, paramList));
        return;
      }
      audr.d(this.jdField_a_of_type_AndroidAppActivity.getString(2131692595));
      bgke.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, paramList);
      return;
    }
  }
  
  private void c(List<bfif> paramList, aubv paramaubv)
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidAppActivity)) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694305, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299080));
    }
    do
    {
      do
      {
        return;
        Iterator localIterator = paramList.iterator();
        for (long l = 0L; localIterator.hasNext(); l = ((bfif)localIterator.next()).jdField_a_of_type_Long + l) {}
        TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
        if ((!auea.a()) || (l <= 3145728L)) {
          break;
        }
      } while (!bixr.a(this.jdField_a_of_type_AndroidAppActivity, 1, new aubx(this, paramList, paramaubv)));
      paramList = new auby(this, paramList, paramaubv);
      paramaubv = this.jdField_a_of_type_AndroidAppActivity.getString(2131697124);
      bhdj.a(this.jdField_a_of_type_AndroidAppActivity, 230, this.jdField_a_of_type_AndroidAppActivity.getString(2131697353), paramaubv, 2131690697, 2131697060, paramList, paramList).show();
      return;
      a(paramList);
    } while (paramaubv == null);
    paramaubv.a(1, 0);
  }
  
  public void a(List<bfif> paramList, int paramInt, aubv paramaubv)
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
      c(paramList, paramaubv);
      return;
    case 2: 
      b(paramList);
      return;
    case 4: 
      c(paramList);
      return;
    case 3: 
      b(paramList, paramaubv);
      return;
    }
    a(paramList, paramaubv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aubw
 * JD-Core Version:    0.7.0.1
 */