import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.teamwork.TeamWorkUtils.TDFileQIPCModule.1;
import eipc.EIPCResult;

public class baie
  extends QIPCModule
{
  public baie()
  {
    super("Module_TDFileChangeNameQIPCModule");
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    bflp.c(baic.a(), "onCall action|" + paramString + " params|" + paramBundle + " callbackId|" + paramInt);
    if (paramString.equals("Action_url_2_fmdb")) {
      ThreadManager.postImmediately(new TeamWorkUtils.TDFileQIPCModule.1(this, paramBundle.getString("url")), null, true);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baie
 * JD-Core Version:    0.7.0.1
 */