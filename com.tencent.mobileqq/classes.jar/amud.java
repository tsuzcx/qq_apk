import android.content.res.Resources;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class amud
  extends bdno
{
  PromotionConfigInfo jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo;
  final String jdField_a_of_type_JavaLangString;
  WeakReference<AppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  amud(String paramString1, String paramString2, AppInterface paramAppInterface)
  {
    super(paramString1);
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
  }
  
  public void innerClean()
  {
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo = null;
  }
  
  public boolean runOnSubThread(Resources paramResources)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo = bdpg.a(this.jdField_a_of_type_JavaLangString, null);
    QLog.w(this.TAG, 1, "ReadConfigTask,ConfigInfo[" + this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo + "]");
    amtu.c();
    AudioHelper.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amud
 * JD-Core Version:    0.7.0.1
 */