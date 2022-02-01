import android.os.Bundle;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

class ammo
  extends bhyn
{
  ammo(amme paramamme) {}
  
  public void onDone(bhyo parambhyo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "download onDone");
    }
    if (parambhyo.a() == 3) {
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_download_success", 0, 0, new String[0]);
    }
    if (this.a.jdField_a_of_type_Anlu != null) {
      this.a.jdField_a_of_type_Anlu.b();
    }
  }
  
  public void onDoneFile(bhyo parambhyo)
  {
    if (parambhyo == null) {}
    label314:
    label320:
    for (;;)
    {
      return;
      String str1 = parambhyo.c;
      parambhyo = parambhyo.a();
      if (parambhyo != null)
      {
        parambhyo = (ApolloActionData)parambhyo.getSerializable(str1);
        if (parambhyo == null)
        {
          QLog.e("ApolloManager", 1, "action res onDoneFile but action data is null");
          return;
        }
        String str2 = ApolloUtil.a(parambhyo, 4);
        if (str1.equals(ApolloUtil.a(parambhyo, 5)))
        {
          try
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, "action res zip done acitonid=" + parambhyo.actionId + " action name =" + parambhyo.actionName);
            }
            if (!ApolloUtil.a(parambhyo.actionId, parambhyo.personNum))
            {
              FileUtils.uncompressZip(str2, ApolloUtil.a(parambhyo, 6), false);
              FileUtils.deleteFile(str2);
              this.a.a(parambhyo);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("ApolloManager", 2, "uncompressZip fail zip file: " + str2, localException);
              }
            }
          }
          if (parambhyo.compoundType <= 0) {
            break label314;
          }
        }
        for (boolean bool = ApolloUtil.a(parambhyo.actionId, 1, parambhyo.personNum, false);; bool = ApolloUtil.a(parambhyo))
        {
          if ((!bool) || (this.a.jdField_a_of_type_Anlu == null)) {
            break label320;
          }
          parambhyo.status = 1;
          if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
            ((ankc)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOOLO_DAO_MANAGER)).b(parambhyo);
          }
          this.a.jdField_a_of_type_Anlu.a(parambhyo);
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ApolloManager", 2, "onDoneFile panelView actionId = " + parambhyo.actionId + " action name =" + parambhyo.actionName);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ammo
 * JD-Core Version:    0.7.0.1
 */