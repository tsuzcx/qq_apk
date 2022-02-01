import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;

final class bghe
  implements aofo
{
  bghe(String paramString1, String paramString2, boolean paramBoolean, QQAppInterface paramQQAppInterface, bghf parambghf) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("checkHomeworkTroopIdentity. troopUin=").append(this.jdField_a_of_type_JavaLangString).append(", memberUin=").append(this.b).append(", level=");
      if (paramTroopMemberInfo != null) {
        break label151;
      }
      localObject = "";
      localStringBuilder = localStringBuilder.append(localObject).append(", reqMemberInfo=").append(this.jdField_a_of_type_Boolean).append(", hwIdentity=");
      if (paramTroopMemberInfo != null) {
        break label163;
      }
    }
    label151:
    label163:
    for (Object localObject = "";; localObject = Integer.valueOf(paramTroopMemberInfo.hwIdentity))
    {
      QLog.i("hw_troop", 2, localObject);
      if (paramTroopMemberInfo != null) {
        break label217;
      }
      if (this.jdField_a_of_type_Boolean) {}
      try
      {
        long l1 = Long.parseLong(this.jdField_a_of_type_JavaLangString);
        long l2 = Long.parseLong(this.b);
        ((aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(l1, l2, true);
        return;
      }
      catch (NumberFormatException paramTroopMemberInfo)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("hw_troop", 2, new Object[] { "checkIdentity NumberFormatException,info.troopuin=", this.jdField_a_of_type_JavaLangString, ", memberuin=", this.b });
        return;
      }
      localObject = Integer.valueOf(paramTroopMemberInfo.level);
      break;
    }
    label217:
    if (!bghd.a(paramTroopMemberInfo.hwIdentity))
    {
      ((aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).e(this.jdField_a_of_type_JavaLangString, this.b);
      return;
    }
    bghd.a(this.jdField_a_of_type_Bghf, paramTroopMemberInfo.level);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bghe
 * JD-Core Version:    0.7.0.1
 */