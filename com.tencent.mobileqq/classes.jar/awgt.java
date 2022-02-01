import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.mobileqq.jsp.IdentificationApiPlugin.2.1;
import com.tencent.mobileqq.jsp.IdentificationApiPlugin.2.2;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class awgt
  implements avwz
{
  awgt(awgr paramawgr) {}
  
  public void a(int paramInt, String paramString)
  {
    QLog.e("IdentificationApiPlugin", 1, "getAppConf error, code : " + paramInt + " errorMsg : " + paramString);
    if (awgr.a(this.a) == null)
    {
      QLog.e("IdentificationApiPlugin", 1, "getConfFailed, activity is null");
      return;
    }
    ThreadManager.getUIHandler().post(new IdentificationApiPlugin.2.2(this, paramString));
  }
  
  public void a(FaceDetectForThirdPartyManager.AppConf paramAppConf)
  {
    if (awgr.a(this.a) == null)
    {
      QLog.e("IdentificationApiPlugin", 1, "getConfSuccess, activity is null");
      return;
    }
    ThreadManager.getUIHandler().post(new IdentificationApiPlugin.2.1(this, paramAppConf));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awgt
 * JD-Core Version:    0.7.0.1
 */