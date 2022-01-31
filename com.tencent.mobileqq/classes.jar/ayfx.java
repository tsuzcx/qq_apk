import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.teamwork.TeamWorkUtils.TDFileQIPCModule.1;
import eipc.EIPCResult;

public class ayfx
  extends QIPCModule
{
  public ayfx()
  {
    super("Module_TDFileChangeNameQIPCModule");
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    bdht.c(ayfv.a(), "onCall action|" + paramString + " params|" + paramBundle + " callbackId|" + paramInt);
    if (paramString.equals("Action_url_2_fmdb")) {
      ThreadManager.postImmediately(new TeamWorkUtils.TDFileQIPCModule.1(this, paramBundle.getString("url")), null, true);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayfx
 * JD-Core Version:    0.7.0.1
 */