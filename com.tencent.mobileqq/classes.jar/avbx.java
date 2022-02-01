import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.predownload.ListenTogetherResDownloader.2.1;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class avbx
  implements INetEngine.INetEngineListener
{
  avbx(avbv paramavbv) {}
  
  public void onResp(NetResp paramNetResp)
  {
    boolean bool;
    Object localObject1;
    File localFile;
    int i;
    String str;
    label48:
    Object localObject2;
    if (paramNetResp.mResult == 0)
    {
      bool = true;
      localObject1 = (HttpNetReq)paramNetResp.mReq;
      localFile = new File(((HttpNetReq)localObject1).mOutPath);
      i = paramNetResp.mErrCode;
      if (paramNetResp.mErrDesc != null) {
        break label164;
      }
      str = "0";
      localObject2 = (Object[])((HttpNetReq)localObject1).getUserData();
      localObject1 = (MusicInfo)localObject2[0];
      localObject2 = (avbz)localObject2[1];
      if (!bool) {
        break label173;
      }
      ((avbz)localObject2).a = 2;
      this.a.a(((MusicInfo)localObject1).a);
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().post(new ListenTogetherResDownloader.2.1(this, paramNetResp, bool, (MusicInfo)localObject1));
      if (QLog.isColorLevel()) {
        QLog.d("ListenTogether.downloader", 2, String.format("onResp, errCode: %s, errDesc: %s, musicReqInfo: %s", new Object[] { Integer.valueOf(i), str, localObject2 }));
      }
      return;
      bool = false;
      break;
      label164:
      str = paramNetResp.mErrDesc;
      break label48;
      label173:
      if ((localFile != null) && (localFile.exists())) {
        localFile.delete();
      }
      ((avbz)localObject2).a = 3;
      avbv.a(this.a, (MusicInfo)localObject1);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avbx
 * JD-Core Version:    0.7.0.1
 */