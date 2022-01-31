import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.qphone.base.util.QLog;

class avxq
  implements ampi
{
  avxq(avxp paramavxp, String paramString, AppInterface paramAppInterface) {}
  
  public void a(PromotionConfigInfo paramPromotionConfigInfo)
  {
    boolean bool = false;
    QLog.w(avxp.jdField_a_of_type_JavaLangString, 1, "getRes, promotionConfigInfo[" + paramPromotionConfigInfo + "], activityID[" + this.jdField_a_of_type_JavaLangString + "], isDestroyed[" + avxp.a(this.jdField_a_of_type_Avxp) + "]");
    if (avxp.a(this.jdField_a_of_type_Avxp)) {
      return;
    }
    Object localObject = null;
    ampd localampd;
    String str;
    if (paramPromotionConfigInfo != null)
    {
      if (this.jdField_a_of_type_JavaLangString == null) {
        break label324;
      }
      localampd = paramPromotionConfigInfo.getItem(this.jdField_a_of_type_JavaLangString);
      str = avxp.a(this.jdField_a_of_type_Avxp).getCurrentAccountUin();
      int i = ancj.a(str + "AR_PROMOTION_ENTRY_SHOWONCE");
      int j = bdkx.b(str);
      if ((j != ancj.a(str + "AR_PROMOTION_ENTRY_SERVER_VERSION")) || (j == 0))
      {
        ancj.a(str + "AR_PROMOTION_ENTRY_SERVER_VERSION", j);
        i = 0;
      }
      if ((!paramPromotionConfigInfo.showOnce) || (i == 0)) {
        ancj.a(str + "AR_PROMOTION_ENTRY_SHOWONCE", 0);
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
      avxp.a(this.jdField_a_of_type_Avxp).a(bool, paramPromotionConfigInfo.showInTopView);
      localObject = localampd;
      if (bool)
      {
        localObject = localampd;
        if (paramPromotionConfigInfo.showOnce)
        {
          ancj.a(str + "AR_PROMOTION_ENTRY_SHOWONCE", 1);
          localObject = localampd;
        }
      }
      avxp.a(this.jdField_a_of_type_Avxp, this.jdField_a_of_type_ComTencentCommonAppAppInterface, localObject);
      return;
      localampd = paramPromotionConfigInfo.getActivityItem();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avxq
 * JD-Core Version:    0.7.0.1
 */