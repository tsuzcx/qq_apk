import android.util.Log;
import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.jce.ReqHead;
import com.tencent.tmassistant.common.jce.Request;
import com.tencent.tmassistant.common.jce.Response;
import com.tencent.tmassistant.common.jce.StatItem;
import com.tencent.tmassistant.common.jce.StatReportRequest;
import com.tencent.tmassistant.common.jce.StatReportResponse;
import java.util.ArrayList;

public class bjqt
  extends bjqv
{
  protected bjqu a;
  
  public int a(ArrayList<StatItem> paramArrayList)
  {
    StatReportRequest localStatReportRequest = new StatReportRequest();
    localStatReportRequest.data = paramArrayList;
    return a(localStatReportRequest);
  }
  
  public void a(bjqu parambjqu)
  {
    this.a = parambjqu;
  }
  
  public void onFinished(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    Log.i("StatReportHttpRequest", "errorCode: " + paramInt);
    Response localResponse = ProtocolPackage.unpackPackage(paramArrayOfByte2);
    paramArrayOfByte1 = ProtocolPackage.unpackRequestPackage(paramArrayOfByte1);
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.head != null)) {}
    for (int i = paramArrayOfByte1.head.requestId;; i = 0)
    {
      if ((paramArrayOfByte2 == null) && (this.a != null))
      {
        Log.i("StatReportHttpRequest", "response is null");
        this.a.a(i, null, null, paramInt);
        return;
      }
      if (this.a != null)
      {
        if ((localResponse == null) || (localResponse.body == null)) {
          break label225;
        }
        paramArrayOfByte1 = ProtocolPackage.unpageageJceResponse(localResponse.body, StatReportResponse.class);
        if (paramArrayOfByte1 == null) {
          break label208;
        }
        if (paramInt != 0) {
          break label191;
        }
        if ((paramArrayOfByte1 instanceof StatReportResponse))
        {
          paramArrayOfByte1 = (StatReportResponse)paramArrayOfByte1;
          if (paramArrayOfByte1.ret != 0) {
            break label171;
          }
          this.a.a(i, null, paramArrayOfByte1, 0);
        }
      }
      for (;;)
      {
        Log.i("StatReportHttpRequest", "exit");
        return;
        label171:
        this.a.a(i, null, paramArrayOfByte1, paramArrayOfByte1.ret);
        continue;
        label191:
        this.a.a(i, null, null, paramInt);
        continue;
        label208:
        this.a.a(i, null, null, paramInt);
        continue;
        label225:
        this.a.a(i, null, null, paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjqt
 * JD-Core Version:    0.7.0.1
 */