import android.os.Bundle;
import com.tencent.mobileqq.data.QzoneCommonIntent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneCommonRequest;
import cooperation.qzone.util.ProtocolUtils;
import mqq.app.MSFServlet;

public final class arvh
  implements arvi
{
  public void a(MSFServlet paramMSFServlet, QzoneCommonIntent paramQzoneCommonIntent, FromServiceMsg paramFromServiceMsg)
  {
    QZoneCommonRequest localQZoneCommonRequest = paramQzoneCommonIntent.getRequest();
    Object localObject2 = localQZoneCommonRequest.uniKey();
    int i = localQZoneCommonRequest.getType();
    int[] arrayOfInt = new int[1];
    String[] arrayOfString = new String[1];
    Object localObject1 = null;
    if (!paramFromServiceMsg.isSuccess())
    {
      arrayOfInt[0] = (paramFromServiceMsg.getResultCode() + 300000);
      arrayOfString[0] = paramFromServiceMsg.getBusinessFailMsg();
      paramFromServiceMsg = (FromServiceMsg)localObject1;
      if (QLog.isColorLevel()) {
        QLog.i("QzoneCommonIntent", 2, String.format("cmd :%s, success:%b,code:%d, msg:%s", new Object[] { localQZoneCommonRequest.getCmdString(), Boolean.valueOf(QzoneCommonIntent.succeeded(arrayOfInt[0])), Integer.valueOf(arrayOfInt[0]), arrayOfString[0] }));
      }
      localObject2 = paramQzoneCommonIntent.getExtras();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new Bundle();
      }
      ((Bundle)localObject1).putSerializable("key_response", paramFromServiceMsg);
      ((Bundle)localObject1).putInt("key_response_code", arrayOfInt[0]);
      ((Bundle)localObject1).putString("key_response_msg", arrayOfString[0]);
      if (paramQzoneCommonIntent.getObserver() == null) {
        QLog.e("QzoneCommonIntent", 1, "observer ==null,无法回调，请检查是否有调用setObserver");
      }
      if ((paramFromServiceMsg == null) || (!QzoneCommonIntent.succeeded(arrayOfInt[0]))) {
        break label260;
      }
    }
    label260:
    for (boolean bool = true;; bool = false)
    {
      paramMSFServlet.notifyObserver(paramQzoneCommonIntent, i, bool, (Bundle)localObject1, null);
      if (arrayOfInt[0] != 1000006) {
        QzoneCommonIntent.access$000(localQZoneCommonRequest, arrayOfInt[0], arrayOfString[0]);
      }
      return;
      paramFromServiceMsg = ProtocolUtils.decode(paramFromServiceMsg.getWupBuffer(), (String)localObject2, arrayOfInt, arrayOfString);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arvh
 * JD-Core Version:    0.7.0.1
 */