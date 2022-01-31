import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.qphone.base.util.QLog;

class awbz
  implements amtx
{
  awbz(awby paramawby, String paramString, AppInterface paramAppInterface) {}
  
  public void a(PromotionConfigInfo paramPromotionConfigInfo)
  {
    boolean bool = false;
    QLog.w(awby.jdField_a_of_type_JavaLangString, 1, "getRes, promotionConfigInfo[" + paramPromotionConfigInfo + "], activityID[" + this.jdField_a_of_type_JavaLangString + "], isDestroyed[" + awby.a(this.jdField_a_of_type_Awby) + "]");
    if (awby.a(this.jdField_a_of_type_Awby)) {
      return;
    }
    Object localObject = null;
    amts localamts;
    String str;
    if (paramPromotionConfigInfo != null)
    {
      if (this.jdField_a_of_type_JavaLangString == null) {
        break label324;
      }
      localamts = paramPromotionConfigInfo.getItem(this.jdField_a_of_type_JavaLangString);
      str = awby.a(this.jdField_a_of_type_Awby).getCurrentAccountUin();
      int i = angs.a(str + "AR_PROMOTION_ENTRY_SHOWONCE");
      int j = bdpg.b(str);
      if ((j != angs.a(str + "AR_PROMOTION_ENTRY_SERVER_VERSION")) || (j == 0))
      {
        angs.a(str + "AR_PROMOTION_ENTRY_SERVER_VERSION", j);
        i = 0;
      }
      if ((!paramPromotionConfigInfo.showOnce) || (i == 0)) {
        angs.a(str + "AR_PROMOTION_ENTRY_SHOWONCE", 0);
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
      awby.a(this.jdField_a_of_type_Awby).a(bool, paramPromotionConfigInfo.showInTopView);
      localObject = localamts;
      if (bool)
      {
        localObject = localamts;
        if (paramPromotionConfigInfo.showOnce)
        {
          angs.a(str + "AR_PROMOTION_ENTRY_SHOWONCE", 1);
          localObject = localamts;
        }
      }
      awby.a(this.jdField_a_of_type_Awby, this.jdField_a_of_type_ComTencentCommonAppAppInterface, localObject);
      return;
      localamts = paramPromotionConfigInfo.getActivityItem();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awbz
 * JD-Core Version:    0.7.0.1
 */