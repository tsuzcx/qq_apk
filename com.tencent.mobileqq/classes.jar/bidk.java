import QC.GetItemWatchWordReq;
import QC.GetItemWatchWordRsp;
import QC.UniBusinessItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import eipc.EIPCModule;
import eipc.EIPCResultCallback;

public class bidk
  implements bidj
{
  public void a(String paramString1, String paramString2, EIPCModule paramEIPCModule, int paramInt, EIPCResultCallback paramEIPCResultCallback)
  {
    paramEIPCResultCallback = new biib("QC.UniBusinessLoginServer.UniBusinessLoginObj", "QCUniBusinessLogin.watchword", "stReq", "stRsp");
    UniBusinessItem localUniBusinessItem = new UniBusinessItem();
    localUniBusinessItem.appid = Integer.parseInt(paramString1);
    localUniBusinessItem.itemid = Integer.parseInt(paramString2);
    paramEIPCResultCallback.a("GetItemWatchWord", new GetItemWatchWordReq(aogu.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()), localUniBusinessItem), new GetItemWatchWordRsp(), new bidl(this, paramEIPCModule, paramInt), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bidk
 * JD-Core Version:    0.7.0.1
 */