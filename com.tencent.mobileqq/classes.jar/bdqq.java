import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0xe61.oidb_0xe61.BeancurdCubeInfo;
import tencent.im.oidb.cmd0xe61.oidb_0xe61.ReqBody;
import tencent.im.oidb.cmd0xe61.oidb_0xe61.RspBody;

public class bdqq
  extends anii
{
  public bdqq(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str1 = paramToServiceMsg.extraData.getString("selfUin", "");
    String str2 = paramToServiceMsg.extraData.getString("frdUin", "");
    paramToServiceMsg = new oidb_0xe61.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i == 0) {
      if (paramToServiceMsg.rpt_beancurd_cube_info_result.has())
      {
        paramToServiceMsg = paramToServiceMsg.rpt_beancurd_cube_info_result.get();
        if ((paramToServiceMsg == null) || (paramToServiceMsg.size() <= 0)) {
          break label190;
        }
        notifyUI(0, true, new Object[] { str1, str2, paramToServiceMsg });
      }
    }
    label190:
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        notifyUI(0, false, new Object[] { str1, str2, null });
      }
      if (QLog.isColorLevel()) {
        QLog.i("Tofu_TofuHandler", 2, String.format("handlePullTofuData result=%d suc=%b selfUin=%s frdUin=%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), str1, MobileQQ.getShortUinStr(str2) }));
      }
      return;
      paramToServiceMsg = null;
      break;
    }
  }
  
  public void a(String paramString, List<oidb_0xe61.BeancurdCubeInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Tofu_TofuHandler", 2, String.format("pullTofuData frdUin=%s reqSize=%s", new Object[] { MobileQQ.getShortUinStr(paramString), Integer.valueOf(paramList.size()) }));
    }
    oidb_0xe61.ReqBody localReqBody = new oidb_0xe61.ReqBody();
    localReqBody.rpt_beancurd_cube_info.set(paramList);
    paramList = makeOIDBPkg("OidbSvc.0x6e1_1", 3681, 1, localReqBody.toByteArray());
    paramList.extraData.putString("frdUin", paramString);
    paramList.extraData.putString("selfUin", this.app.getCurrentAccountUin());
    sendPbReq(paramList);
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x6e1_1");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends anil> observerClass()
  {
    return bdqv.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("OidbSvc.0x6e1_1".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdqq
 * JD-Core Version:    0.7.0.1
 */