import android.os.Bundle;
import cooperation.qqindividuality.ipc.QQIndividualityPluginProxyService;

class bmdc
  extends aods
{
  bmdc(bmcz parambmcz) {}
  
  protected void c(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      paramObject = (Bundle)paramObject;
      paramObject.putInt("which_method", 0);
      QQIndividualityPluginProxyService.a().a("qqindividuality_signature", 4, paramObject);
    }
  }
  
  protected void d(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      paramObject = (Bundle)paramObject;
      paramObject.putInt("which_method", 1);
      QQIndividualityPluginProxyService.a().a("qqindividuality_signature", 4, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmdc
 * JD-Core Version:    0.7.0.1
 */