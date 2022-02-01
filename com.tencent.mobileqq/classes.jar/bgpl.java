import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;

final class bgpl
  implements aojm
{
  bgpl(String paramString1, String paramString2, boolean paramBoolean, QQAppInterface paramQQAppInterface, bgpm parambgpm) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("checkHomeworkTroopIdentity. troopUin=").append(this.jdField_a_of_type_JavaLangString).append(", memberUin=").append(this.b).append(", level=");
      if (paramTroopMemberInfo != null) {
        break label150;
      }
      localObject = "";
      localStringBuilder = localStringBuilder.append(localObject).append(", reqMemberInfo=").append(this.jdField_a_of_type_Boolean).append(", hwIdentity=");
      if (paramTroopMemberInfo != null) {
        break label162;
      }
    }
    label150:
    label162:
    for (Object localObject = "";; localObject = Integer.valueOf(paramTroopMemberInfo.hwIdentity))
    {
      QLog.i("hw_troop", 2, localObject);
      if (paramTroopMemberInfo != null) {
        break label216;
      }
      if (this.jdField_a_of_type_Boolean) {}
      try
      {
        long l1 = Long.parseLong(this.jdField_a_of_type_JavaLangString);
        long l2 = Long.parseLong(this.b);
        ((aoip)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(l1, l2, true);
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
    label216:
    if (!bgpk.a(paramTroopMemberInfo.hwIdentity))
    {
      ((aoip)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).d(this.jdField_a_of_type_JavaLangString, this.b);
      return;
    }
    bgpk.a(this.jdField_a_of_type_Bgpm, paramTroopMemberInfo.level);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgpl
 * JD-Core Version:    0.7.0.1
 */