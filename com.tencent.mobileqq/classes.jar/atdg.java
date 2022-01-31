import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.mobileqq.jsp.IdentificationApiPlugin.1.1;
import com.tencent.mobileqq.jsp.IdentificationApiPlugin.1.2;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class atdg
  implements astb
{
  atdg(atdf paramatdf) {}
  
  public void a(int paramInt, String paramString)
  {
    QLog.e("IdentificationApiPlugin", 1, "getAppConf error, code : " + paramInt + " errorMsg : " + paramString);
    if (atdf.a(this.a) == null)
    {
      QLog.e("IdentificationApiPlugin", 1, "getConfFailed, activity is null");
      return;
    }
    ThreadManager.getUIHandler().post(new IdentificationApiPlugin.1.2(this, paramString));
  }
  
  public void a(FaceDetectForThirdPartyManager.AppConf paramAppConf)
  {
    if (atdf.a(this.a) == null)
    {
      QLog.e("IdentificationApiPlugin", 1, "getConfSuccess, activity is null");
      return;
    }
    ThreadManager.getUIHandler().post(new IdentificationApiPlugin.1.1(this, paramAppConf));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atdg
 * JD-Core Version:    0.7.0.1
 */