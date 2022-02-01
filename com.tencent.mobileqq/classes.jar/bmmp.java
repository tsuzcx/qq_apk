import android.content.Intent;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcooperation/vip/impl/VasAdvServlet;", "Lmqq/app/MSFServlet;", "()V", "onReceive", "", "intent", "Landroid/content/Intent;", "fromServiceMsg", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "onSend", "packet", "Lmqq/app/Packet;", "Companion", "SSOCallback", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bmmp
  extends MSFServlet
{
  public static final bmmq a;
  private static final Map<String, bmkd> a;
  
  static
  {
    jdField_a_of_type_Bmmq = new bmmq(null);
    jdField_a_of_type_JavaUtilMap = (Map)new LinkedHashMap();
  }
  
  public void onReceive(@Nullable Intent paramIntent, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    if ((paramIntent == null) || (paramFromServiceMsg == null)) {
      QLog.d("VasAdvServlet", 1, "onReceive intent or fromServiceMsg is null");
    }
    for (;;)
    {
      return;
      Object localObject = paramIntent.getStringExtra("cmd");
      String str = paramIntent.getStringExtra("req_uuid");
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty((CharSequence)str)))
      {
        QLog.d("VasAdvServlet", 1, "invalid cmd " + (String)localObject + " or uuid " + str + ", discard rsp");
        return;
      }
      paramIntent = (bmkd)jdField_a_of_type_JavaUtilMap.remove(str);
      if (!paramFromServiceMsg.isSuccess())
      {
        if (paramIntent != null) {
          paramIntent.a("from service msg failed", null);
        }
        QLog.d("VasAdvServlet", 1, "request failed, cmd:" + (String)localObject + ", uuid:" + str + ", serviceMsg:" + paramFromServiceMsg.getShortStringForLog());
        return;
      }
      try
      {
        int i = paramFromServiceMsg.getWupBuffer().length - 4;
        localObject = new byte[i];
        PkgTools.copyData((byte[])localObject, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
        if (paramIntent != null)
        {
          paramIntent.a((byte[])localObject);
          return;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        if (paramIntent != null) {
          paramIntent.a("error when parse response", (Throwable)paramFromServiceMsg);
        }
        QLog.e("VasAdvServlet", 1, "onReceive error: " + paramFromServiceMsg);
      }
    }
  }
  
  public void onSend(@Nullable Intent paramIntent, @Nullable Packet paramPacket)
  {
    long l = 10000L;
    byte[] arrayOfByte = null;
    if (paramIntent != null) {}
    for (String str = paramIntent.getStringExtra("cmd");; str = null)
    {
      if (paramIntent != null) {
        arrayOfByte = paramIntent.getByteArrayExtra("data");
      }
      if (paramIntent != null) {
        l = paramIntent.getLongExtra("timeout", 10000L);
      }
      if (paramPacket != null)
      {
        paramPacket.setSSOCommand(str);
        paramPacket.setTimeout(l);
        paramPacket.putSendData(arrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d("VasAdvServlet", 0, "onSend cmd: " + str);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmmp
 * JD-Core Version:    0.7.0.1
 */