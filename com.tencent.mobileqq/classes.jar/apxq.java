import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.ark.ArkAppCenter;

class apxq
  implements BusinessObserver
{
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", "ArkTemp.queryAppInfoByAppNameBatch, sso request failed");
      paramObject = null;
    }
    for (;;)
    {
      paramObject = apxp.a(this.jdField_a_of_type_Apxp, (String)paramObject);
      if (this.jdField_a_of_type_Apxx != null) {
        this.jdField_a_of_type_Apxx.a(paramObject, this.jdField_a_of_type_JavaLangObject);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apxq
 * JD-Core Version:    0.7.0.1
 */