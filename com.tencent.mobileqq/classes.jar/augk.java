import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.qphone.base.util.QLog;

class augk
  implements akyt
{
  augk(augj paramaugj, String paramString, AppInterface paramAppInterface) {}
  
  public void a(PromotionConfigInfo paramPromotionConfigInfo)
  {
    boolean bool = false;
    QLog.w(augj.jdField_a_of_type_JavaLangString, 1, "getRes, promotionConfigInfo[" + paramPromotionConfigInfo + "], activityID[" + this.jdField_a_of_type_JavaLangString + "], isDestroyed[" + augj.a(this.jdField_a_of_type_Augj) + "]");
    if (augj.a(this.jdField_a_of_type_Augj)) {
      return;
    }
    Object localObject = null;
    akyo localakyo;
    String str;
    if (paramPromotionConfigInfo != null)
    {
      if (this.jdField_a_of_type_JavaLangString == null) {
        break label324;
      }
      localakyo = paramPromotionConfigInfo.getItem(this.jdField_a_of_type_JavaLangString);
      str = augj.a(this.jdField_a_of_type_Augj).getCurrentAccountUin();
      int i = allu.a(str + "AR_PROMOTION_ENTRY_SHOWONCE");
      int j = bblp.b(str);
      if ((j != allu.a(str + "AR_PROMOTION_ENTRY_SERVER_VERSION")) || (j == 0))
      {
        allu.a(str + "AR_PROMOTION_ENTRY_SERVER_VERSION", j);
        i = 0;
      }
      if ((!paramPromotionConfigInfo.showOnce) || (i == 0)) {
        allu.a(str + "AR_PROMOTION_ENTRY_SHOWONCE", 0);
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
      augj.a(this.jdField_a_of_type_Augj).a(bool, paramPromotionConfigInfo.showInTopView);
      localObject = localakyo;
      if (bool)
      {
        localObject = localakyo;
        if (paramPromotionConfigInfo.showOnce)
        {
          allu.a(str + "AR_PROMOTION_ENTRY_SHOWONCE", 1);
          localObject = localakyo;
        }
      }
      augj.a(this.jdField_a_of_type_Augj, this.jdField_a_of_type_ComTencentCommonAppAppInterface, localObject);
      return;
      localakyo = paramPromotionConfigInfo.getActivityItem();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     augk
 * JD-Core Version:    0.7.0.1
 */