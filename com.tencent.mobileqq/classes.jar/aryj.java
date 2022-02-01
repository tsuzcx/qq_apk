import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.List;
import mqq.manager.TicketManager;
import tencent.im.oidb.cmd0x876.oidb_0x876.ReqBody;
import tencent.im.oidb.cmd0x877.oidb_0x877.ReqBody;
import tencent.im.oidb.cmd0xada.oidb_0xada.ReqBody;
import tencent.nearby.now.nearby_now_anchor.ReqBatchGetAnchorStatus;

public class aryj
{
  public static void a(QQAppInterface paramQQAppInterface)
  {
    oidb_0xada.ReqBody localReqBody = new oidb_0xada.ReqBody();
    localReqBody.uid.set(Long.parseLong(paramQQAppInterface.getCurrentAccountUin()));
    localReqBody.tinyid.set(Long.parseLong(paramQQAppInterface.getCurrentAccountUin()));
    Object localObject = (TicketManager)paramQQAppInterface.getManager(2);
    String str = ((TicketManager)localObject).getA2(paramQQAppInterface.getCurrentAccountUin());
    localObject = ((TicketManager)localObject).getSkey(paramQQAppInterface.getCurrentAccountUin());
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      localReqBody.a2.set(str);
      localReqBody.platform.set(1);
      localReqBody.version.set("8.4.10");
      localReqBody.original_id.set(paramQQAppInterface.getCurrentAccountUin());
      localReqBody.original_key.set((String)localObject);
      localReqBody.original_id_type.set(1);
    }
    localReqBody.cmd.set(24727);
    localReqBody.subcmd.set(6);
    ntb.a(paramQQAppInterface, new aryk(), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, aryl paramaryl)
  {
    oidb_0x877.ReqBody localReqBody = new oidb_0x877.ReqBody();
    localReqBody.uint32_refer.set(paramInt);
    ntb.a(paramQQAppInterface, paramaryl, localReqBody.toByteArray(), "OidbSvc.0x877_0", 2167, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, arym paramarym)
  {
    ntb.a(paramQQAppInterface, paramarym, new oidb_0x876.ReqBody().toByteArray(), "OidbSvc.0x876_" + paramInt, 2166, paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<Long> paramList, Bundle paramBundle, aryn paramaryn)
  {
    nearby_now_anchor.ReqBatchGetAnchorStatus localReqBatchGetAnchorStatus = new nearby_now_anchor.ReqBatchGetAnchorStatus();
    localReqBatchGetAnchorStatus.uint64_uin.set(paramList);
    paramList = paramBundle;
    if (paramBundle == null) {
      paramList = new Bundle();
    }
    ntb.a(paramQQAppInterface, paramaryn, localReqBatchGetAnchorStatus.toByteArray(), "NearbyNowTips.batch_get_anchor_stats", paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aryj
 * JD-Core Version:    0.7.0.1
 */