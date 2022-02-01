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

public class asxp
  implements asxi<bebc>
{
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public asxp(QQAppInterface paramQQAppInterface, Activity paramActivity, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private void a(List<bebc> paramList)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bebc localbebc = (bebc)paramList.next();
      becp localbecp = bfby.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, localbebc.jdField_a_of_type_JavaUtilUUID.toString(), localbebc.jdField_b_of_type_JavaLangString, localbebc.jdField_c_of_type_JavaLangString, localbebc.jdField_a_of_type_Long, localbebc.jdField_a_of_type_Int);
      if ((localbecp != null) && (localbecp.jdField_a_of_type_JavaUtilUUID != null) && ((localbecp.jdField_b_of_type_Int == 10) || (localbecp.jdField_b_of_type_Int == 9))) {
        localTroopFileTransferManager.c(localbecp.jdField_a_of_type_JavaUtilUUID);
      } else {
        localTroopFileTransferManager.a(localbebc.jdField_b_of_type_JavaLangString, localbebc.jdField_c_of_type_JavaLangString, localbebc.jdField_a_of_type_Long, localbebc.jdField_a_of_type_Int);
      }
    }
  }
  
  private void a(List<bebc> paramList, asxo paramasxo)
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
        paramasxo = (bebc)paramList.next();
        Object localObject = new becp();
        ((becp)localObject).g = paramasxo.jdField_c_of_type_JavaLangString;
        ((becp)localObject).jdField_a_of_type_JavaLangString = paramasxo.h;
        ((becp)localObject).jdField_c_of_type_Long = paramasxo.jdField_a_of_type_Long;
        ((becp)localObject).jdField_d_of_type_Long = paramasxo.jdField_d_of_type_Long;
        ((becp)localObject).jdField_a_of_type_JavaUtilUUID = paramasxo.jdField_a_of_type_JavaUtilUUID;
        ((becp)localObject).jdField_b_of_type_Long = this.jdField_a_of_type_Long;
        ((becp)localObject).h = paramasxo.jdField_a_of_type_Int;
        ((becp)localObject).e = paramasxo.jdField_b_of_type_JavaLangString;
        ((becp)localObject).f = paramasxo.jdField_d_of_type_JavaLangString;
        ((becp)localObject).jdField_b_of_type_JavaLangString = paramasxo.i;
        ((becp)localObject).jdField_c_of_type_JavaLangString = paramasxo.j;
        ((becp)localObject).jdField_d_of_type_JavaLangString = paramasxo.k;
        ((becp)localObject).jdField_b_of_type_Int = paramasxo.e;
        bfbb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(((becp)localObject).jdField_a_of_type_JavaUtilUUID);
        localObject = aszt.a((becp)localObject);
        if (paramasxo.jdField_b_of_type_Long != 0L) {
          ((FileManagerEntity)localObject).selfUin = ("" + paramasxo.jdField_b_of_type_Long);
        }
        if (paramasxo.jdField_c_of_type_Int != 0) {
          ((FileManagerEntity)localObject).lastTime = paramasxo.jdField_c_of_type_Int;
        }
        ((FileManagerEntity)localObject).bSend = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount().equals(((FileManagerEntity)localObject).selfUin);
        if (new bkov(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject, null, false)) {
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
        aszt.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131697621));
        return;
      }
    }
  }
  
  private void b(List<bebc> paramList)
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidAppActivity))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694108, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299076));
      return;
    }
    Iterator localIterator = paramList.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (bebc)localIterator.next();
      localObject = ataw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, (bebc)localObject);
      if (localObject == null) {
        break label146;
      }
      bool = ataw.a(false, ((becp)localObject).jdField_c_of_type_Long, ((becp)localObject).e);
    }
    label146:
    for (;;)
    {
      break;
      if (bool)
      {
        aszg.a(this.jdField_a_of_type_AndroidAppActivity, 2131692374, 2131692379, new asxs(this, paramList));
        return;
      }
      ataw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Long);
      return;
    }
  }
  
  private void b(List<bebc> paramList, asxo paramasxo)
  {
    if (bfby.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Long) == 0) {}
    do
    {
      return;
      paramasxo = bfbb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    } while (paramasxo == null);
    boolean bool1 = bfby.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      bebc localbebc = (bebc)paramList.next();
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localbebc.b());
      if ((!localbebc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, true)) || ((!bool2) && (!bool1))) {
        break label162;
      }
      paramasxo.b(localbebc);
      i = 1;
    }
    label162:
    for (;;)
    {
      break;
      if (bool1)
      {
        aszk.b(2131692246);
        return;
      }
      if (i != 0)
      {
        aszk.b(2131692248);
        return;
      }
      aszk.c(2131692247);
      return;
    }
  }
  
  private void c(List<bebc> paramList)
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidAppActivity))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694108, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299076));
      return;
    }
    Iterator localIterator = paramList.iterator();
    boolean bool = false;
    label46:
    if (localIterator.hasNext())
    {
      Object localObject = (bebc)localIterator.next();
      localObject = ataw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, (bebc)localObject);
      if (localObject == null) {
        break label176;
      }
      bool = ataw.a(false, ((becp)localObject).jdField_c_of_type_Long, ((becp)localObject).e);
    }
    label176:
    for (;;)
    {
      break label46;
      if (bool)
      {
        if (!bhnb.a(this.jdField_a_of_type_AndroidAppActivity, 5, new asxt(this, paramList))) {
          break;
        }
        aszg.a(this.jdField_a_of_type_AndroidAppActivity, 2131692374, 2131692377, new asxu(this, paramList));
        return;
      }
      aszk.d(this.jdField_a_of_type_AndroidAppActivity.getString(2131692493));
      bfby.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, paramList);
      return;
    }
  }
  
  private void c(List<bebc> paramList, asxo paramasxo)
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidAppActivity)) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694108, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299076));
    }
    do
    {
      do
      {
        return;
        Iterator localIterator = paramList.iterator();
        for (long l = 0L; localIterator.hasNext(); l = ((bebc)localIterator.next()).jdField_a_of_type_Long + l) {}
        TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
        if ((!aszt.a()) || (l <= 3145728L)) {
          break;
        }
      } while (!bhnb.a(this.jdField_a_of_type_AndroidAppActivity, 1, new asxq(this, paramList, paramasxo)));
      paramList = new asxr(this, paramList, paramasxo);
      paramasxo = this.jdField_a_of_type_AndroidAppActivity.getString(2131696856);
      bfur.a(this.jdField_a_of_type_AndroidAppActivity, 230, this.jdField_a_of_type_AndroidAppActivity.getString(2131697076), paramasxo, 2131690620, 2131696793, paramList, paramList).show();
      return;
      a(paramList);
    } while (paramasxo == null);
    paramasxo.a(1, 0);
  }
  
  public void a(List<bebc> paramList, int paramInt, asxo paramasxo)
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
      c(paramList, paramasxo);
      return;
    case 2: 
      b(paramList);
      return;
    case 4: 
      c(paramList);
      return;
    case 3: 
      b(paramList, paramasxo);
      return;
    }
    a(paramList, paramasxo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxp
 * JD-Core Version:    0.7.0.1
 */