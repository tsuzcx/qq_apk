import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.ark.ArkAppCenter;

class aoum
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
      paramObject = aoul.a(this.jdField_a_of_type_Aoul, (String)paramObject);
      if (this.jdField_a_of_type_Aout != null) {
        this.jdField_a_of_type_Aout.a(paramObject, this.jdField_a_of_type_JavaLangObject);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoum
 * JD-Core Version:    0.7.0.1
 */