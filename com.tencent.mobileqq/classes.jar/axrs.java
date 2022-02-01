import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.qphone.base.util.QLog;

class axrs
  implements anzq
{
  axrs(axrr paramaxrr, String paramString, AppInterface paramAppInterface) {}
  
  public void a(PromotionConfigInfo paramPromotionConfigInfo)
  {
    boolean bool = false;
    QLog.w(axrr.jdField_a_of_type_JavaLangString, 1, "getRes, promotionConfigInfo[" + paramPromotionConfigInfo + "], activityID[" + this.jdField_a_of_type_JavaLangString + "], isDestroyed[" + axrr.a(this.jdField_a_of_type_Axrr) + "]");
    if (axrr.a(this.jdField_a_of_type_Axrr)) {
      return;
    }
    Object localObject = null;
    anzl localanzl;
    String str;
    if (paramPromotionConfigInfo != null)
    {
      if (this.jdField_a_of_type_JavaLangString == null) {
        break label324;
      }
      localanzl = paramPromotionConfigInfo.getItem(this.jdField_a_of_type_JavaLangString);
      str = axrr.a(this.jdField_a_of_type_Axrr).getCurrentAccountUin();
      int i = aomj.a(str + "AR_PROMOTION_ENTRY_SHOWONCE");
      int j = bgax.b(str);
      if ((j != aomj.a(str + "AR_PROMOTION_ENTRY_SERVER_VERSION")) || (j == 0))
      {
        aomj.a(str + "AR_PROMOTION_ENTRY_SERVER_VERSION", j);
        i = 0;
      }
      if ((!paramPromotionConfigInfo.showOnce) || (i == 0)) {
        aomj.a(str + "AR_PROMOTION_ENTRY_SHOWONCE", 0);
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
      axrr.a(this.jdField_a_of_type_Axrr).a(bool, paramPromotionConfigInfo.showInTopView);
      localObject = localanzl;
      if (bool)
      {
        localObject = localanzl;
        if (paramPromotionConfigInfo.showOnce)
        {
          aomj.a(str + "AR_PROMOTION_ENTRY_SHOWONCE", 1);
          localObject = localanzl;
        }
      }
      axrr.a(this.jdField_a_of_type_Axrr, this.jdField_a_of_type_ComTencentCommonAppAppInterface, localObject);
      return;
      localanzl = paramPromotionConfigInfo.getActivityItem();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axrs
 * JD-Core Version:    0.7.0.1
 */