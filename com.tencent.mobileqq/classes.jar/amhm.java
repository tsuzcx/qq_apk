import android.os.Bundle;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

class amhm
  extends bhhe
{
  amhm(amhd paramamhd) {}
  
  public void onDone(bhhf parambhhf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "download onDone");
    }
    if (parambhhf.a() == 3) {
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_download_success", 0, 0, new String[0]);
    }
    if (this.a.jdField_a_of_type_Andu != null) {
      this.a.jdField_a_of_type_Andu.b();
    }
  }
  
  public void onDoneFile(bhhf parambhhf)
  {
    if (parambhhf == null) {}
    label314:
    label320:
    for (;;)
    {
      return;
      String str1 = parambhhf.c;
      parambhhf = parambhhf.a();
      if (parambhhf != null)
      {
        parambhhf = (ApolloActionData)parambhhf.getSerializable(str1);
        if (parambhhf == null)
        {
          QLog.e("ApolloManager", 1, "action res onDoneFile but action data is null");
          return;
        }
        String str2 = ApolloUtil.a(parambhhf, 4);
        if (str1.equals(ApolloUtil.a(parambhhf, 5)))
        {
          try
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, "action res zip done acitonid=" + parambhhf.actionId + " action name =" + parambhhf.actionName);
            }
            if (!ApolloUtil.a(parambhhf.actionId, parambhhf.personNum))
            {
              bgmg.a(str2, ApolloUtil.a(parambhhf, 6), false);
              bgmg.d(str2);
              this.a.a(parambhhf);
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
          if (parambhhf.compoundType <= 0) {
            break label314;
          }
        }
        for (boolean bool = ApolloUtil.a(parambhhf.actionId, 1, parambhhf.personNum, false);; bool = ApolloUtil.a(parambhhf))
        {
          if ((!bool) || (this.a.jdField_a_of_type_Andu == null)) {
            break label320;
          }
          parambhhf.status = 1;
          if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
            ((ancd)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).b(parambhhf);
          }
          this.a.jdField_a_of_type_Andu.a(parambhhf);
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ApolloManager", 2, "onDoneFile panelView actionId = " + parambhhf.actionId + " action name =" + parambhhf.actionName);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amhm
 * JD-Core Version:    0.7.0.1
 */