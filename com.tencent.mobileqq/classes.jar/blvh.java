import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.manager.IliveAuthManager;
import cooperation.ilive.pb.QQALive.GetOpenInfoRsp;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class blvh
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IliveAuthServlet", 2, "onReceive cmd=" + paramIntent.getStringExtra("cmd") + ",success=" + paramFromServiceMsg.isSuccess());
    }
    if ((paramIntent == null) || (paramFromServiceMsg == null)) {}
    Object localObject;
    do
    {
      return;
      localObject = paramFromServiceMsg.getServiceCmd();
    } while (localObject == null);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      boolean bool = paramFromServiceMsg.isSuccess();
      localStringBuilder = new StringBuilder().append("resp:").append((String)localObject).append(" is ");
      if (!bool) {
        break label265;
      }
    }
    label265:
    for (paramIntent = "";; paramIntent = "not")
    {
      QLog.d("IliveAuthServlet", 2, paramIntent + " success");
      paramIntent = null;
      if (paramFromServiceMsg.isSuccess())
      {
        int i = paramFromServiceMsg.getWupBuffer().length - 4;
        paramIntent = new byte[i];
        PkgTools.copyData(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
      }
      if (!((String)localObject).equals("qqvalivelogin.GetOpenInfo")) {
        break;
      }
      localObject = new QQALive.GetOpenInfoRsp();
      if (paramFromServiceMsg.getResultCode() != 1000) {
        break label283;
      }
      try
      {
        ((QQALive.GetOpenInfoRsp)localObject).mergeFrom(paramIntent);
        if ((TextUtils.isEmpty(((QQALive.GetOpenInfoRsp)localObject).sOpenId.get())) || (TextUtils.isEmpty(((QQALive.GetOpenInfoRsp)localObject).sAccessToken.get()))) {
          break label271;
        }
        IliveAuthManager.getInstance().onGetStCallback(true, ((QQALive.GetOpenInfoRsp)localObject).sOpenId.get(), ((QQALive.GetOpenInfoRsp)localObject).sAccessToken.get());
        return;
      }
      catch (Exception paramIntent)
      {
        IliveAuthManager.getInstance().onGetStCallback(false, "", "");
        return;
      }
    }
    label271:
    IliveAuthManager.getInstance().onGetStCallback(false, "", "");
    return;
    label283:
    IliveAuthManager.getInstance().onGetStCallback(false, "", "");
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    String str = paramIntent.getStringExtra("cmd");
    long l = paramIntent.getLongExtra("timeout", 10000L);
    paramPacket.setSSOCommand(str);
    paramPacket.setTimeout(l);
    paramPacket.putSendData(arrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("IliveAuthServlet", 2, "onSend exit cmd=" + str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blvh
 * JD-Core Version:    0.7.0.1
 */