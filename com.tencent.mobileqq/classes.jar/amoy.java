import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xe27.oidb_cmd0xe27.InOutQQ;
import tencent.im.oidb.cmd0xe27.oidb_cmd0xe27.ReqBody;
import tencent.im.oidb.cmd0xe27.oidb_cmd0xe27.RspBody;

public class amoy
  extends alpd
{
  private List<amoz> a = new ArrayList();
  
  public amoy(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  /* Error */
  public void a(amoz paramamoz)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +18 -> 21
    //   6: aload_0
    //   7: getfield 18	amoy:a	Ljava/util/List;
    //   10: aload_1
    //   11: invokeinterface 26 2 0
    //   16: istore_2
    //   17: iload_2
    //   18: ifeq +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 18	amoy:a	Ljava/util/List;
    //   28: aload_1
    //   29: invokeinterface 29 2 0
    //   34: pop
    //   35: goto -14 -> 21
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	amoy
    //   0	43	1	paramamoz	amoz
    //   16	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	17	38	finally
    //   24	35	38	finally
  }
  
  public void a(List<oidb_cmd0xe27.InOutQQ> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    int i = paramList.size();
    if (i > 20) {
      paramList.subList(i - 20, i);
    }
    oidb_cmd0xe27.ReqBody localReqBody = new oidb_cmd0xe27.ReqBody();
    localReqBody.rpt_msg_in_out_qq.set(paramList);
    sendPbReq(makeOIDBPkg("OidbSvc.0xe27", 3623, 1, localReqBody.toByteArray()));
  }
  
  public void b(amoz paramamoz)
  {
    if ((paramamoz == null) || (!this.a.contains(paramamoz))) {
      return;
    }
    this.a.remove(paramamoz);
  }
  
  protected Class<? extends alpg> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQDailyHandler", 0, "receive from front back report: " + paramFromServiceMsg.isSuccess());
    }
    oidb_cmd0xe27.RspBody localRspBody = new oidb_cmd0xe27.RspBody();
    if (parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody) == 0)
    {
      paramObject = this.a.iterator();
      while (paramObject.hasNext())
      {
        amoz localamoz = (amoz)paramObject.next();
        if (localamoz != null) {
          localamoz.a(paramToServiceMsg, paramFromServiceMsg, localRspBody);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amoy
 * JD-Core Version:    0.7.0.1
 */