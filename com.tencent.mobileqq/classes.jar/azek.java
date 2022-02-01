import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.qphone.base.util.QLog;

class azek
  implements apge
{
  azek(azej paramazej, String paramString, AppInterface paramAppInterface) {}
  
  public void a(PromotionConfigInfo paramPromotionConfigInfo)
  {
    boolean bool = false;
    QLog.w(azej.jdField_a_of_type_JavaLangString, 1, "getRes, promotionConfigInfo[" + paramPromotionConfigInfo + "], activityID[" + this.jdField_a_of_type_JavaLangString + "], isDestroyed[" + azej.a(this.jdField_a_of_type_Azej) + "]");
    if (azej.a(this.jdField_a_of_type_Azej)) {
      return;
    }
    Object localObject = null;
    apfz localapfz;
    String str;
    if (paramPromotionConfigInfo != null)
    {
      if (this.jdField_a_of_type_JavaLangString == null) {
        break label324;
      }
      localapfz = paramPromotionConfigInfo.getItem(this.jdField_a_of_type_JavaLangString);
      str = azej.a(this.jdField_a_of_type_Azej).getCurrentAccountUin();
      int i = apsw.a(str + "AR_PROMOTION_ENTRY_SHOWONCE");
      int j = bhui.b(str);
      if ((j != apsw.a(str + "AR_PROMOTION_ENTRY_SERVER_VERSION")) || (j == 0))
      {
        apsw.a(str + "AR_PROMOTION_ENTRY_SERVER_VERSION", j);
        i = 0;
      }
      if ((!paramPromotionConfigInfo.showOnce) || (i == 0)) {
        apsw.a(str + "AR_PROMOTION_ENTRY_SHOWONCE", 0);
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
      azej.a(this.jdField_a_of_type_Azej).a(bool, paramPromotionConfigInfo.showInTopView);
      localObject = localapfz;
      if (bool)
      {
        localObject = localapfz;
        if (paramPromotionConfigInfo.showOnce)
        {
          apsw.a(str + "AR_PROMOTION_ENTRY_SHOWONCE", 1);
          localObject = localapfz;
        }
      }
      azej.a(this.jdField_a_of_type_Azej, this.jdField_a_of_type_ComTencentCommonAppAppInterface, localObject);
      return;
      localapfz = paramPromotionConfigInfo.getActivityItem();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azek
 * JD-Core Version:    0.7.0.1
 */