import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.qphone.base.util.QLog;

class ayyd
  implements apcs
{
  ayyd(ayyc paramayyc, String paramString, AppInterface paramAppInterface) {}
  
  public void a(PromotionConfigInfo paramPromotionConfigInfo)
  {
    boolean bool = false;
    QLog.w(ayyc.jdField_a_of_type_JavaLangString, 1, "getRes, promotionConfigInfo[" + paramPromotionConfigInfo + "], activityID[" + this.jdField_a_of_type_JavaLangString + "], isDestroyed[" + ayyc.a(this.jdField_a_of_type_Ayyc) + "]");
    if (ayyc.a(this.jdField_a_of_type_Ayyc)) {
      return;
    }
    Object localObject = null;
    apcn localapcn;
    String str;
    if (paramPromotionConfigInfo != null)
    {
      if (this.jdField_a_of_type_JavaLangString == null) {
        break label324;
      }
      localapcn = paramPromotionConfigInfo.getItem(this.jdField_a_of_type_JavaLangString);
      str = ayyc.a(this.jdField_a_of_type_Ayyc).getCurrentAccountUin();
      int i = appk.a(str + "AR_PROMOTION_ENTRY_SHOWONCE");
      int j = bhjo.b(str);
      if ((j != appk.a(str + "AR_PROMOTION_ENTRY_SERVER_VERSION")) || (j == 0))
      {
        appk.a(str + "AR_PROMOTION_ENTRY_SERVER_VERSION", j);
        i = 0;
      }
      if ((!paramPromotionConfigInfo.showOnce) || (i == 0)) {
        appk.a(str + "AR_PROMOTION_ENTRY_SHOWONCE", 0);
      }
      if (!paramPromotionConfigInfo.showOnce) {
        break label333;
      }
      if (i != 0) {}
    }
    label324:
    label333:
    for (bool = true;; bool = true)
    {
      ayyc.a(this.jdField_a_of_type_Ayyc).a(bool, paramPromotionConfigInfo.showInTopView);
      localObject = localapcn;
      if (bool)
      {
        localObject = localapcn;
        if (paramPromotionConfigInfo.showOnce)
        {
          appk.a(str + "AR_PROMOTION_ENTRY_SHOWONCE", 1);
          localObject = localapcn;
        }
      }
      ayyc.a(this.jdField_a_of_type_Ayyc, this.jdField_a_of_type_ComTencentCommonAppAppInterface, localObject);
      return;
      localapcn = paramPromotionConfigInfo.getActivityItem();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayyd
 * JD-Core Version:    0.7.0.1
 */