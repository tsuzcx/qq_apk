import QC.GetItemWatchWordReq;
import QC.GetItemWatchWordRsp;
import QC.UniBusinessItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import eipc.EIPCModule;
import eipc.EIPCResultCallback;

public class bgjv
  implements bgju
{
  public void a(String paramString1, String paramString2, EIPCModule paramEIPCModule, int paramInt, EIPCResultCallback paramEIPCResultCallback)
  {
    paramEIPCResultCallback = new bgol("QC.UniBusinessLoginServer.UniBusinessLoginObj", "QCUniBusinessLogin.watchword", "stReq", "stRsp");
    UniBusinessItem localUniBusinessItem = new UniBusinessItem();
    localUniBusinessItem.appid = Integer.parseInt(paramString1);
    localUniBusinessItem.itemid = Integer.parseInt(paramString2);
    paramEIPCResultCallback.a("GetItemWatchWord", new GetItemWatchWordReq(anaj.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()), localUniBusinessItem), new GetItemWatchWordRsp(), new bgjw(this, paramEIPCModule, paramInt), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgjv
 * JD-Core Version:    0.7.0.1
 */