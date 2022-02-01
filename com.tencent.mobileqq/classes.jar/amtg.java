import android.os.Bundle;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

class amtg
  extends biht
{
  amtg(amsx paramamsx) {}
  
  public void onDone(bihu parambihu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "download onDone");
    }
    if (parambihu.a() == 3) {
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_download_success", 0, 0, new String[0]);
    }
    if (this.a.jdField_a_of_type_Anpo != null) {
      this.a.jdField_a_of_type_Anpo.b();
    }
  }
  
  public void onDoneFile(bihu parambihu)
  {
    if (parambihu == null) {}
    label314:
    label320:
    for (;;)
    {
      return;
      String str1 = parambihu.c;
      parambihu = parambihu.a();
      if (parambihu != null)
      {
        parambihu = (ApolloActionData)parambihu.getSerializable(str1);
        if (parambihu == null)
        {
          QLog.e("ApolloManager", 1, "action res onDoneFile but action data is null");
          return;
        }
        String str2 = ApolloUtil.a(parambihu, 4);
        if (str1.equals(ApolloUtil.a(parambihu, 5)))
        {
          try
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, "action res zip done acitonid=" + parambihu.actionId + " action name =" + parambihu.actionName);
            }
            if (!ApolloUtil.a(parambihu.actionId, parambihu.personNum))
            {
              bhmi.a(str2, ApolloUtil.a(parambihu, 6), false);
              bhmi.d(str2);
              this.a.a(parambihu);
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
          if (parambihu.compoundType <= 0) {
            break label314;
          }
        }
        for (boolean bool = ApolloUtil.a(parambihu.actionId, 1, parambihu.personNum, false);; bool = ApolloUtil.a(parambihu))
        {
          if ((!bool) || (this.a.jdField_a_of_type_Anpo == null)) {
            break label320;
          }
          parambihu.status = 1;
          if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
            ((annx)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).b(parambihu);
          }
          this.a.jdField_a_of_type_Anpo.a(parambihu);
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ApolloManager", 2, "onDoneFile panelView actionId = " + parambihu.actionId + " action name =" + parambihu.actionName);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amtg
 * JD-Core Version:    0.7.0.1
 */