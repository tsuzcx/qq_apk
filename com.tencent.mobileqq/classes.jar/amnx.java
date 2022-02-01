import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloResManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.qphone.base.util.QLog;

public class amnx
  implements bhot
{
  public amnx(ApolloResManager paramApolloResManager, String paramString, QQAppInterface paramQQAppInterface, amme paramamme, amof paramamof) {}
  
  public boolean a(String paramString, ApolloBaseInfo paramApolloBaseInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("getApolloDressInfo onGetBaseInfo : ");
    if (paramApolloBaseInfo == null) {}
    for (String str = null;; str = paramApolloBaseInfo.toString())
    {
      QLog.d("cm_res", 1, str);
      if ((TextUtils.isEmpty(paramString)) || (!paramString.equals(this.jdField_a_of_type_JavaLangString))) {
        break;
      }
      ApolloResManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloResManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Amme, this.jdField_a_of_type_JavaLangString, paramApolloBaseInfo, this.jdField_a_of_type_Amof);
      return true;
    }
    return false;
  }
  
  public boolean b(String paramString, ApolloBaseInfo paramApolloBaseInfo)
  {
    Object localObject2 = null;
    StringBuilder localStringBuilder = new StringBuilder().append("getApolloDressInfo onDressUpdated : ");
    Object localObject1;
    if (paramApolloBaseInfo == null)
    {
      localObject1 = null;
      QLog.d("cm_res", 1, (String)localObject1);
      if ((TextUtils.isEmpty(paramString)) || (!paramString.equals(this.jdField_a_of_type_JavaLangString))) {
        break label161;
      }
      paramString = paramApolloBaseInfo;
      if (paramApolloBaseInfo == null)
      {
        paramString = paramApolloBaseInfo;
        if (this.jdField_a_of_type_Amme != null)
        {
          paramApolloBaseInfo = this.jdField_a_of_type_Amme.b(this.jdField_a_of_type_JavaLangString);
          localObject1 = new StringBuilder().append("getApolloDressInfo onDressUpdated getApolloBaseInfo : ");
          if (paramApolloBaseInfo != null) {
            break label153;
          }
        }
      }
    }
    label153:
    for (paramString = localObject2;; paramString = paramApolloBaseInfo.toString())
    {
      QLog.d("cm_res", 1, paramString);
      paramString = paramApolloBaseInfo;
      ApolloResManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloResManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Amme, this.jdField_a_of_type_JavaLangString, paramString, this.jdField_a_of_type_Amof);
      return true;
      localObject1 = paramApolloBaseInfo.toString();
      break;
    }
    label161:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amnx
 * JD-Core Version:    0.7.0.1
 */