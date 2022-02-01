import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.qphone.base.util.QLog;

class aylr
  implements aoso
{
  aylr(aylq paramaylq, String paramString, AppInterface paramAppInterface) {}
  
  public void a(PromotionConfigInfo paramPromotionConfigInfo)
  {
    boolean bool = false;
    QLog.w(aylq.jdField_a_of_type_JavaLangString, 1, "getRes, promotionConfigInfo[" + paramPromotionConfigInfo + "], activityID[" + this.jdField_a_of_type_JavaLangString + "], isDestroyed[" + aylq.a(this.jdField_a_of_type_Aylq) + "]");
    if (aylq.a(this.jdField_a_of_type_Aylq)) {
      return;
    }
    Object localObject = null;
    aosj localaosj;
    String str;
    if (paramPromotionConfigInfo != null)
    {
      if (this.jdField_a_of_type_JavaLangString == null) {
        break label324;
      }
      localaosj = paramPromotionConfigInfo.getItem(this.jdField_a_of_type_JavaLangString);
      str = aylq.a(this.jdField_a_of_type_Aylq).getCurrentAccountUin();
      int i = apfg.a(str + "AR_PROMOTION_ENTRY_SHOWONCE");
      int j = bguf.b(str);
      if ((j != apfg.a(str + "AR_PROMOTION_ENTRY_SERVER_VERSION")) || (j == 0))
      {
        apfg.a(str + "AR_PROMOTION_ENTRY_SERVER_VERSION", j);
        i = 0;
      }
      if ((!paramPromotionConfigInfo.showOnce) || (i == 0)) {
        apfg.a(str + "AR_PROMOTION_ENTRY_SHOWONCE", 0);
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
      aylq.a(this.jdField_a_of_type_Aylq).a(bool, paramPromotionConfigInfo.showInTopView);
      localObject = localaosj;
      if (bool)
      {
        localObject = localaosj;
        if (paramPromotionConfigInfo.showOnce)
        {
          apfg.a(str + "AR_PROMOTION_ENTRY_SHOWONCE", 1);
          localObject = localaosj;
        }
      }
      aylq.a(this.jdField_a_of_type_Aylq, this.jdField_a_of_type_ComTencentCommonAppAppInterface, localObject);
      return;
      localaosj = paramPromotionConfigInfo.getActivityItem();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aylr
 * JD-Core Version:    0.7.0.1
 */