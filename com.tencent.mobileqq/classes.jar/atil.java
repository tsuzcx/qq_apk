import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.qphone.base.util.QLog;

class atil
  implements akkh
{
  atil(atik paramatik, String paramString, AppInterface paramAppInterface) {}
  
  public void a(PromotionConfigInfo paramPromotionConfigInfo)
  {
    boolean bool = false;
    QLog.w(atik.jdField_a_of_type_JavaLangString, 1, "getRes, promotionConfigInfo[" + paramPromotionConfigInfo + "], activityID[" + this.jdField_a_of_type_JavaLangString + "], isDestroyed[" + atik.a(this.jdField_a_of_type_Atik) + "]");
    if (atik.a(this.jdField_a_of_type_Atik)) {
      return;
    }
    Object localObject = null;
    akkc localakkc;
    String str;
    if (paramPromotionConfigInfo != null)
    {
      if (this.jdField_a_of_type_JavaLangString == null) {
        break label324;
      }
      localakkc = paramPromotionConfigInfo.getItem(this.jdField_a_of_type_JavaLangString);
      str = atik.a(this.jdField_a_of_type_Atik).getCurrentAccountUin();
      int i = akxi.a(str + "AR_PROMOTION_ENTRY_SHOWONCE");
      int j = bakf.b(str);
      if ((j != akxi.a(str + "AR_PROMOTION_ENTRY_SERVER_VERSION")) || (j == 0))
      {
        akxi.a(str + "AR_PROMOTION_ENTRY_SERVER_VERSION", j);
        i = 0;
      }
      if ((!paramPromotionConfigInfo.showOnce) || (i == 0)) {
        akxi.a(str + "AR_PROMOTION_ENTRY_SHOWONCE", 0);
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
      atik.a(this.jdField_a_of_type_Atik).a(bool, paramPromotionConfigInfo.showInTopView);
      localObject = localakkc;
      if (bool)
      {
        localObject = localakkc;
        if (paramPromotionConfigInfo.showOnce)
        {
          akxi.a(str + "AR_PROMOTION_ENTRY_SHOWONCE", 1);
          localObject = localakkc;
        }
      }
      atik.a(this.jdField_a_of_type_Atik, this.jdField_a_of_type_ComTencentCommonAppAppInterface, localObject);
      return;
      localakkc = paramPromotionConfigInfo.getActivityItem();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     atil
 * JD-Core Version:    0.7.0.1
 */