import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.qphone.base.util.QLog;

class augm
  implements akys
{
  augm(augl paramaugl, String paramString, AppInterface paramAppInterface) {}
  
  public void a(PromotionConfigInfo paramPromotionConfigInfo)
  {
    boolean bool = false;
    QLog.w(augl.jdField_a_of_type_JavaLangString, 1, "getRes, promotionConfigInfo[" + paramPromotionConfigInfo + "], activityID[" + this.jdField_a_of_type_JavaLangString + "], isDestroyed[" + augl.a(this.jdField_a_of_type_Augl) + "]");
    if (augl.a(this.jdField_a_of_type_Augl)) {
      return;
    }
    Object localObject = null;
    akyn localakyn;
    String str;
    if (paramPromotionConfigInfo != null)
    {
      if (this.jdField_a_of_type_JavaLangString == null) {
        break label324;
      }
      localakyn = paramPromotionConfigInfo.getItem(this.jdField_a_of_type_JavaLangString);
      str = augl.a(this.jdField_a_of_type_Augl).getCurrentAccountUin();
      int i = allt.a(str + "AR_PROMOTION_ENTRY_SHOWONCE");
      int j = bbmd.b(str);
      if ((j != allt.a(str + "AR_PROMOTION_ENTRY_SERVER_VERSION")) || (j == 0))
      {
        allt.a(str + "AR_PROMOTION_ENTRY_SERVER_VERSION", j);
        i = 0;
      }
      if ((!paramPromotionConfigInfo.showOnce) || (i == 0)) {
        allt.a(str + "AR_PROMOTION_ENTRY_SHOWONCE", 0);
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
      augl.a(this.jdField_a_of_type_Augl).a(bool, paramPromotionConfigInfo.showInTopView);
      localObject = localakyn;
      if (bool)
      {
        localObject = localakyn;
        if (paramPromotionConfigInfo.showOnce)
        {
          allt.a(str + "AR_PROMOTION_ENTRY_SHOWONCE", 1);
          localObject = localakyn;
        }
      }
      augl.a(this.jdField_a_of_type_Augl, this.jdField_a_of_type_ComTencentCommonAppAppInterface, localObject);
      return;
      localakyn = paramPromotionConfigInfo.getActivityItem();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     augm
 * JD-Core Version:    0.7.0.1
 */